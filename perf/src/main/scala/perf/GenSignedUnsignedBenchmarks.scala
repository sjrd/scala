package perf

import scala.reflect.runtime.universe._
import scala.math.random
import scala.util.Try

object GenSignedUnsignedBenchmarks {
  val threshold = 16

  sealed trait Op
  final case class Arg(index: Int) extends Op
  sealed trait BinOp extends Op { def l: Op; def r: Op }
  final case class Add(l: Op, r: Op) extends BinOp
  final case class Sub(l: Op, r: Op) extends BinOp
  final case class Mul(l: Op, r: Op) extends BinOp
  final case class Div(l: Op, r: Op) extends BinOp
  final case class Mod(l: Op, r: Op) extends BinOp

  type MkBinOp = (Op, Op) => Op

  val fastOps = List[MkBinOp](Add, Sub, Mul)
  val allOps = fastOps ++ List[MkBinOp](Div, Mod)

  def complexity(op: Op): Int = op match {
    case arg: Arg   => 0
    case bin: BinOp => complexity(bin.l) + complexity(bin.r) + 1
  }

  def eval(t: Op): Int = t match {
    case Arg(i)    => i
    case Add(l, r) => eval(l) + eval(r)
    case Sub(l, r) => eval(l) - eval(r)
    case Mul(l, r) => eval(l) * eval(r)
    case Div(l, r) => eval(l) / eval(r)
    case Mod(l, r) => eval(l) % eval(r)
  }

  def genOp(ops: List[MkBinOp], args: Int): Op =
    if (random > 0.4)
      Arg((random * args).toInt)
    else
      ops((random * ops.size).toInt)(genOp(ops, args), genOp(ops, args))

  def genNonTrivialOp(ops: List[MkBinOp], args: Int): Op = {
    def loop(): Op = {
      val op = genOp(ops, args)
      if (complexity(op) > threshold && Try(eval(op)).isSuccess)
        op
      else
        loop()
    }
    loop()
  }

  def arg(i: Int) =
    TermName(s"x$i")

  def lift(op: Op, wrap: Tree => Tree): Tree = op match {
    case Arg(i)    => q"${arg(i)}"
    case Add(l, r) => wrap(q"${lift(l, wrap)} + ${lift(r, wrap)}")
    case Sub(l, r) => wrap(q"${lift(l, wrap)} - ${lift(r, wrap)}")
    case Mul(l, r) => wrap(q"${lift(l, wrap)} * ${lift(r, wrap)}")
    case Div(l, r) => wrap(q"${lift(l, wrap)} / ${lift(r, wrap)}")
    case Mod(l, r) => wrap(q"${lift(l, wrap)} % ${lift(r, wrap)}")
  }

  def genMethod(name: TermName, op: Op, wrap: Tree => Tree) =
    q"""
      @Benchmark
      def $name = ${lift(op, wrap)}
    """

  def genClasses(args: Int, fastOpsMethods: Int, allOpsMethods: Int) = {
    val fastOpsSamples =
      (1 to fastOpsMethods).map { _ => genNonTrivialOp(fastOps, args) }
    val allOpsSamples =
      (1 to fastOpsMethods).map { _ => genNonTrivialOp(allOps, args) }
    val classes =
      Seq("Byte", "Short", "Int", "Long",
          "UByte", "UShort", "UInt", "ULong").map(TypeName(_)).map { Num =>
        val benchName         = TypeName(s"${Num}Benchmark")
        val toNum             = TermName(s"to$Num")
        val state =
          (0 to args - 1).map { i =>
            q"private[this] var ${arg(i)}: $Num = $i.$toNum"
          }
        val wrap =
          Num.toString match {
            case "Byte" | "UByte" | "Short" | "UShort" =>
              (t: Tree) => q"$t.$toNum"
            case _ =>
              (t: Tree) => t
          }
        val fastOpsMethods = fastOpsSamples.zipWithIndex.map { case (op, i) =>
          genMethod(TermName(s"fastop$i"), op, wrap)
        }
        val allOpsMethods = allOpsSamples.zipWithIndex.map { case (op, i) =>
          genMethod(TermName(s"allop$i"), op, wrap)
        }

        q"""
          @State(Scope.Benchmark)
          class $benchName {
            ..$state
            ..$fastOpsMethods
            ..$allOpsMethods
          }
        """
      }

    q"""
      package perf {
        import org.openjdk.jmh.annotations.{State, Scope, Benchmark}

        ..$classes
      }
    """
  }

  def dump(path: String, value: String) = {
    val writer = new java.io.PrintWriter(path)
    writer.println(value)
    writer.close()
  }

  def main(args: Array[String]): Unit =
    dump(args(0), showCode(genClasses(args = 4, fastOpsMethods = 4, allOpsMethods = 4)))
}
