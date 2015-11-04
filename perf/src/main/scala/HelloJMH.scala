package perf

import org.openjdk.jmh.annotations.Benchmark

class HelloJMH {
  @Benchmark
  def hello: Unit = 5.toUInt + 10.toUInt
}
