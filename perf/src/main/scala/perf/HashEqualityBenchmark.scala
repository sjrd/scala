package perf

import org.openjdk.jmh.annotations.{State, Scope, Benchmark}

final class C(val x: Int) {
  final override def hashCode: Int = x.hashCode
  final override def equals(other: Any) = other match {
    case other: C => this.x == other.x
    case _        => false
  }
}

@State(Scope.Benchmark)
class HashEqualityBenchmark {
  private[this] var signed1: Any = 1
  private[this] var signed2: Any = 2
  private[this] var unsigned1: Any = 1.toUInt
  private[this] var unsigned2: Any = 2.toUInt
  private[this] var object1: Any = new C(1)
  private[this] var object2: Any = new C(2)

  @Benchmark def signedHash     = signed1.##
  @Benchmark def signedEquals   = signed1 == signed2
  @Benchmark def unsignedHash   = unsigned1.##
  @Benchmark def unsignedEquals = unsigned1 == unsigned2
  @Benchmark def objectHash     = object1.##
  @Benchmark def objectEquals   = object1 == object2
}
