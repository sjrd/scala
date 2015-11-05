package perf

import scala.reflect.runtime.universe._
import scala.math.random
import scala.util.Try

object GenUIntBenchmark {
  val threshold = 10

  def arg(i: Int) =
    TermName(s"x$i")

  val ops = List[(Tree, Tree) => Tree](
    (x, y) => q"$x + $y",
    (x, y) => q"$x - $y",
    (x, y) => q"$x * $y",
    (x, y) => q"$x / $y"
  )

  def eval(t: Tree): Long = t match {
    case q"$x + $y" => eval(x) + eval(y)
    case q"$x - $y" => eval(x) - eval(y)
    case q"$x * $y" => eval(x) * eval(y)
    case q"$x / $y" => eval(x) / eval(y)
    case _          => 1L
  }

  def genExpr(args: Int): (Int, Tree) =
    if (random > 0.4)
      (0, q"${arg((random * args).toInt)}")
    else {
      val (i, left) = genExpr(args)
      val (j, right) = genExpr(args)
      val res = ops((random * ops.size).toInt)(left, right)

      (i + j + 1, res)
    }

  def genMethod(args: Int, name: TermName) = {
    def loop(): Tree = {
      val (complexity, e) = genExpr(args)
      if (complexity > threshold && Try(eval(e)).isSuccess)
        e
      else
        loop()
    }
    val body = loop()

    q"""
      @Benchmark
      def $name: Num = $body
    """
  }

  def genClass(args: Int, methods: Int, signedNum: TypeName) = {
    val state =
      (0 to args - 1).map { i =>
        q"private[this] var ${arg(i)}: Num = toNum(1)"
      }
    val benchmarks =
      (1 to methods).map { i =>
        val name = TermName(s"bench$i")
        genMethod(args, name)
      }
    val signedBenchName   = TypeName(s"${signedNum}Benchmark")
    val unsignedNum       = TypeName(s"U$signedNum")
    val unsignedBenchName = TypeName(s"${unsignedNum}Benchmark")
    val toSigned          = TermName(s"to$signedNum")
    val toUnsigned        = TermName(s"to$unsignedNum")

    q"""
      package perf {
        import org.openjdk.jmh.annotations.{State, Scope, Benchmark}

        @State(Scope.Benchmark)
        class $signedBenchName {
          type Num = $signedNum
          def toNum(i: Int): Num = i.$toSigned
          ..$state
          ..$benchmarks
        }

        @State(Scope.Benchmark)
        class $unsignedBenchName {
          type Num = $unsignedNum
          def toNum(i: Int): Num = i.$toUnsigned
          ..$state
          ..$benchmarks
        }
      }
    """
  }

  def main(args: Array[String]): Unit = {
    val code = showCode(genClass(args = 4, methods = 16, TypeName("Int")))
    val writer = new java.io.PrintWriter(args(0))
    writer.println(code)
    writer.close()
  }
}
