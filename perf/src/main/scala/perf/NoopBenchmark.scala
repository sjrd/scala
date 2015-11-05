package perf

import org.openjdk.jmh.annotations.{State, Scope, Benchmark}

class NoopBenchmark {
  @Benchmark
  def noop: Unit = ()
}
