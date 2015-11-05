package perf

import scala.reflect.runtime.universe._
import scala.math.random
import scala.util.Try

object GenSignedUnsignedBenchmarks {
  val threshold = 16

  def arg(i: Int) =
    TermName(s"x$i")

  type Op = (Tree, Tree) => Tree

  val fastOps = List[Op](
    (x, y) => q"$x + $y",
    (x, y) => q"$x - $y",
    (x, y) => q"$x * $y"
  )

  val allOps = fastOps ++ List[Op](
    (x, y) => q"$x / $y",
    (x, y) => q"$x % $y"
  )

  def eval(t: Tree): Int = t match {
    case q"$x + $y" => eval(x) + eval(y)
    case q"$x - $y" => eval(x) - eval(y)
    case q"$x * $y" => eval(x) * eval(y)
    case q"$x / $y" => eval(x) / eval(y)
    case q"$x % $y" => eval(x) % eval(y)
    case _          => 1
  }

  def genExpr(ops: List[Op], args: Int): (Int, Tree) =
    if (random > 0.4)
      (0, q"${arg((random * args).toInt)}")
    else {
      val (i, left) = genExpr(ops, args)
      val (j, right) = genExpr(ops, args)
      val res = ops((random * ops.size).toInt)(left, right)

      (i + j + 1, res)
    }

  def genMethod(ops: List[Op], args: Int, name: TermName) = {
    def loop(): Tree = {
      val (complexity, e) = genExpr(ops, args)
      if (complexity > threshold && Try(eval(e)).isSuccess)
        e
      else
        loop()
    }
    val body = loop()

    q"""
      @Benchmark
      def $name = $body
    """
  }

  def genClasses(args: Int, fastOpsMethods: Int, allOpsMethods: Int) = {
    val state =
      (0 to args - 1).map { i =>
        q"private[this] var ${arg(i)}: Num = toNum(1)"
      }
    val fastOpsBenchmarks =
      (1 to fastOpsMethods).map { i =>
        val name = TermName(s"fastops$i")
        genMethod(fastOps, args, name)
      }
    val allOpsBenchmarks =
      (1 to allOpsMethods).map { i =>
        val name = TermName(s"allops$i")
        genMethod(allOps, args, name)
      }
    val classes =
      Seq("Byte", "Short", "Int", "Long").map(TypeName(_)).flatMap { signedNum =>
        val signedBenchName   = TypeName(s"${signedNum}Benchmark")
        val unsignedNum       = TypeName(s"U$signedNum")
        val unsignedBenchName = TypeName(s"${unsignedNum}Benchmark")
        val toSigned          = TermName(s"to$signedNum")
        val toUnsigned        = TermName(s"to$unsignedNum")

        Seq(
          q"""
            @State(Scope.Benchmark)
            class $signedBenchName {
              type Num = $signedNum
              def toNum(i: Int): Num = i.$toSigned
              ..$state
              ..$fastOpsBenchmarks
              ..$allOpsBenchmarks
            }
          """,
          q"""
            @State(Scope.Benchmark)
            class $unsignedBenchName {
              type Num = $unsignedNum
              def toNum(i: Int): Num = i.$toUnsigned
              ..$state
              ..$fastOpsBenchmarks
              ..$allOpsBenchmarks
            }
          """
        )
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
