package perf

import java.lang.{Integer => JInteger, Long => JLong}
import org.openjdk.jmh.annotations.{State, Scope, Benchmark}

@State(Scope.Benchmark)
class JavaUnsignedOpsBenchmark {
  private[this] var i1, i2: Int = 1
  private[this] var l1, l2: Long = 1L

  @Benchmark
  def divideSignedInt = i1 / i2

  @Benchmark
  def divideSignedLong = l1 / l2

  @Benchmark
  def divideUnsignedInt = JInteger.divideUnsigned(i1, i2)

  @Benchmark
  def divideUnsignedLong = JLong.divideUnsigned(l1, l2)

  @Benchmark
  def remainderSignedInt = i1 % i2

  @Benchmark
  def remainderSignedLong = l1 % l2

  @Benchmark
  def remainderUnsignedInt = JInteger.remainderUnsigned(i1, i2)

  @Benchmark
  def remainderUnsignedLong = JLong.remainderUnsigned(l1, l2)
}
