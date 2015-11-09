package perf

import org.openjdk.jmh.annotations.{State, Scope, Benchmark}

@State(Scope.Benchmark)
class HashEqualityBenchmark {
  private[this] var signed1: Any = 1
  private[this] var signed2: Any = 2
  private[this] var unsigned1: Any = 1.toUInt
  private[this] var unsigned2: Any = 2.toUInt

  @Benchmark def signedHash     = signed1.##
  @Benchmark def signedEquals   = signed1 == signed2
  @Benchmark def unsignedHash   = unsigned1.##
  @Benchmark def unsignedEquals = unsigned1 == unsigned2
}
