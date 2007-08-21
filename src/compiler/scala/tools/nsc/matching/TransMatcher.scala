/* NSC -- new Scala compiler
 * Copyright 2005-2007 LAMP/EPFL
 * @author Burak Emir
 */
// $Id$

package scala.tools.nsc.matching

/** Translation of pattern matching
 *
 *  @author Burak Emir
 */
trait TransMatcher { self: transform.ExplicitOuter with PatternNodes with CodeFactory =>

  import global._
  import definitions._
  import posAssigner.atPos
  import symtab.Flags

  import collection.mutable.ListBuffer

  var cunit: CompilationUnit = _

  def fresh = cunit.fresh

  var resultType: Type = _

  // cache these
  final val settings_debug       = settings.debug.value
  final val settings_squeeze     = settings.Xsqueeze.value == "on"
  final val settings_useParallel = settings.Xmatchalgo.value != "incr"
  final val settings_useIncr     = settings.Xmatchalgo.value != "par"
  final val settings_casetags    = settings.Xcasetags.value == "on"

  /** returns true if apply is a "sequence apply". analyzer inserts Sequence nodes if something is a
   *
   *  - last update: discussion with Martin 2005-02-18
   *
   *  - if true, tree.fn must be ignored. The analyzer ensures that the selector will be a subtype
   *    of fn; it thus assigns the expected type from the context (which is surely a subtype,
   *    but may have different flags etc.
   *
   *  - so should be
   *     (( tree.args.length == 1 ) && tree.args(0).isInstanceOf[Sequence])
   *     but fails
   */
  final def isSeqApply(tree: Apply): Boolean = {
    tree match {
      case Apply(_, List(ArrayValue(_,_))) => (tree.tpe.typeSymbol.flags & Flags.CASE) == 0
      case _ => false;
    }
  }

    /**
     */

  final def hasRegularPattern(pats1: List[Tree]): Boolean = {
    var pats = pats1; while(pats ne Nil) {
      if(isRegularPattern(pats.head)) { return true; } else { pats = pats.tail }
    }
    return false
  }
  final def isRegularPattern(pat: Tree): Boolean = {
    pat match {
      case Alternative(trees)    => hasRegularPattern(trees)
      case Star(t)               => true
      case Ident(_)              => false
      case Bind(n, pat1)         => isRegularPattern(pat1)
      case Sequence(trees)       => true // cause there are ArrayValues now
      case ArrayValue(tt, trees) => hasRegularPattern(trees)
      case Apply(fn, trees)      => hasRegularPattern(trees)
      case Literal(_)            => false
      case Select(_, _)          => false
      case Typed(_, _)           => false
      case UnApply(_,trees)      => hasRegularPattern(trees)
    }
  }



  // @todo: this should be isNotRegular :-/ premature opt src of all evil
  // check special case Seq(p1,...,pk,_*) where pi not regular
  protected def isRightIgnoring(p: ArrayValue): Boolean = {
    def isDefaultStar(p: Tree): Boolean = p match {
      case Bind(_, q)                 => isDefaultStar(q)
      case Star(Ident(nme.WILDCARD))  => true
      case _                          => false
    }
    p match {
      case ArrayValue(s, trees) =>
        var ts = trees
        var c: Tree = null
        while ((ts ne Nil) && {c = ts.head; ts = ts.tail; !isRegularPattern(c)}) {}
        (ts eq Nil) && isDefaultStar(c)
    }
  }

  /** a casedef with sequence subpatterns like
   *
   *  case ..x @ ().. => body
   *
   * should be replaced straight away with
   *
   *  case    .. () .. => val x = Nil; body
   */
  def isRegular(pats: List[CaseDef]): (List[CaseDef],Boolean) = {
    var existsReg = false
    var isReg = false
    var nilVars: List[Symbol] = null

    def isRegular1(pat: Tree): Tree = pat match {
      case Alternative(trees) =>
        copy.Alternative(pat, trees map { isRegular1 })

      case Star(t) =>
        isReg = true; copy.Star(pat, isRegular1(t))

      case Ident(_) =>
        pat

      case Bind(id, empt @ Sequence(List())) =>
        nilVars = pat.symbol /*id.symbol()*/ :: nilVars
        empt

      case Bind(n, pat1) =>
        copy.Bind(pat, n, isRegular1(pat1))

      case Sequence(trees) =>
        //isReg = isReg || ( trees.length == 0 );
        isReg = true // cause there are ArrayValues now
        copy.Sequence(pat, trees map { isRegular1 })

      case UnApply(fn, args) => copy.UnApply(pat, fn, args map { isRegular1 })

        // a pattern of the form List(foo@_*)
      case app @ Apply(fn, List(pat2@ ArrayValue( tt, List(b @ Bind(id, Star(wc @ Ident(nme.WILDCARD))))))) if isSeqApply(app) =>
        //Console.println("OPTIMIZING")
        //Console.println(pat)
        //Console.println(pat.tpe)
        //Console.println(tt.tpe)
        //Console.println("b.tpe "+b.tpe+" widened"+b.tpe.widen)
        //Console.println("b.symbol.tpe "+b.symbol.tpe+" widened"+b.symbol.tpe.widen)
        //Console.println("pat2.tpe "+pat2.tpe+" widened"+pat2.tpe.widen)
        val tpe1:Type = pat2.tpe.widen.baseType( definitions.SeqClass ).typeArgs(0)

        val tpe = appliedType(definitions.SeqClass.typeConstructor, List(tpe1))
        b.symbol.setInfo(tpe)
        b.setType(tpe)
        val res = copy.Bind(b, id, wc)
        //Console.println("====>")
        //Console.println(res)
        res

      // a pattern of the form MyCaseConstructor(foo@_*)
      case app @ Apply(fn, List(pat2@ ArrayValue( tt, List(b @ Bind(id, Star(wc @ Ident(nme.WILDCARD)))))))  =>
        //Console.println("OPTIMIZING")
        //Console.println(pat)
        //Console.println(pat.tpe)
        //Console.println(tt.tpe)
        //Console.println("b.tpe "+b.tpe+" widened"+b.tpe.widen)
        //Console.println("b.symbol.tpe "+b.symbol.tpe+" widened"+b.symbol.tpe.widen)
        //Console.println("pat2.tpe "+pat2.tpe+" widened"+pat2.tpe.widen)
        val tpe1:Type = pat2.tpe.widen.baseType( definitions.SeqClass ).typeArgs(0)

        val tpe = appliedType(definitions.SeqClass.typeConstructor, List(tpe1))
        b.symbol.setInfo(tpe)
        b.setType(tpe)
        val res =  copy.Apply(pat, fn, List(copy.Bind(b, id, wc)))
        //Console.println("====>")
        //Console.println(res)
        res

      case av @ ArrayValue(s, trees) =>
        if (isRightIgnoring(av)) pat
        else copy.ArrayValue(pat, s, (trees map { isRegular1 }))

      case Apply(fn, List(Sequence(List()))) =>
        pat

      case Apply(fn, trees) =>
        //Console.println(" IN isRegular, apply node "+pat.toString());
        //Console.println(" trees are:"+(trees map {x => x.getClass().toString()}));
        copy.Apply(pat, fn, (trees map { isRegular1 }))

      case Literal(_) =>
        pat

      case Select(_, _) =>
        pat

      case Typed(_, _) =>
        pat

      case This(_) => // Sean's feature request #1134, compiled incorrectly
        val stpe = mkThisType(pat.tpe.typeSymbol)
        Typed(Ident(nme.WILDCARD) setType stpe, TypeTree(stpe))

      //case _ =>
      //  Console.println(pat);
      //  Console.println(pat.getClass());
      //  scala.Predef.error(" what is this ? ")
    }

    var res = new ListBuffer[CaseDef]
    val it = pats.elements; while (it.hasNext) {
      nilVars = Nil
      val cdef = it.next
      val newt = isRegular1(cdef.pat)
      existsReg = existsReg || isReg

      val nbody = if (nilVars.isEmpty) cdef.body else
        atPos(cdef.body.pos)(
          Block(nilVars map {
            x => ValDef(x, Ident(definitions.NilModule))
          }, cdef.body)
        )

      res += copy.CaseDef(cdef, newt, cdef.guard, nbody)
    }
    (res.toList, existsReg)
  }

  /** handles all translation of pattern matching
     */
    def handlePattern(sel: Tree, ocases: List[CaseDef], doCheckExhaustive: Boolean,
                      owner: Symbol, handleOuter: Tree => Tree, localTyper: Tree => Tree): Tree = {
      // TEMPORARY
      //new NewMatcher().toIR(sel, ocases)
      //
      // 1. is there a regular pattern?

      val (cases, containsReg) = isRegular(ocases)

      // @todo: remove unused variables

      if (containsReg) {
        cunit.error(sel.pos, "regular expressions not yet implemented")
        //sel
        EmptyTree
      } else {
        val pm = new PatternMatcher()
        pm.initialize(sel, doCheckExhaustive, owner,handleOuter, localTyper)
        pm.construct(cases)
        //if (global.log()) {
        //  global.log("internal pattern matching structure");
        //  pm.print();
        //}
        pm.toTree()
      }
    }
}
