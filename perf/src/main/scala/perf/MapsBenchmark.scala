package perf

import org.openjdk.jmh.annotations.{State, Scope, Benchmark}

final class Foo(val x: Int) {
  final override def hashCode: Int = x.hashCode
  final override def equals(other: Any) = other match {
    case other: Foo => this.x == other.x
    case _          => false
  }
}

@State(Scope.Benchmark)
class MapsBenchmark {
  final val TotalSize = 10000
  final val PresentSize = TotalSize / 2

  private[this] lazy val intsArray =
    Array.fill[Int](TotalSize)(scala.util.Random.nextInt())

  private[this] lazy val foosArray =
    Array.fill[Foo](TotalSize)(new Foo(scala.util.Random.nextInt()))

  private[this] lazy val mixedArray =
    Array.fill[AnyRef](TotalSize)(
        if (scala.util.Random.nextBoolean()) Integer.valueOf(scala.util.Random.nextInt())
        else new Foo(scala.util.Random.nextInt()))

  private[this] def fillMap[A](m: scala.collection.mutable.Map[A, Int],
      sourceArray: Array[A]): m.type = {
    val start = (TotalSize - PresentSize) / 2
    for (i <- start until (start + PresentSize))
      m += sourceArray(i) -> i
    m
  }

  private[this] lazy val intsListMap =
    fillMap(new scala.collection.mutable.ListMap[Int, Int], intsArray)

  private[this] lazy val intsHashMap =
    fillMap(new scala.collection.mutable.HashMap[Int, Int], intsArray)

  private[this] lazy val foosListMap =
    fillMap(new scala.collection.mutable.ListMap[Foo, Int], foosArray)

  private[this] lazy val foosHashMap =
    fillMap(new scala.collection.mutable.HashMap[Foo, Int], foosArray)

  private[this] lazy val mixedListMap =
    fillMap(new scala.collection.mutable.ListMap[AnyRef, Int], mixedArray)

  private[this] lazy val mixedHashMap =
    fillMap(new scala.collection.mutable.HashMap[AnyRef, Int], mixedArray)

  @Benchmark def intsListMapBench = {
    var result = 0
    var i = 0
    while (i != intsArray.length) {
      val elem = intsArray(i)
      if (intsListMap.contains(elem))
        result ^= intsListMap(elem)
      i += 1
    }
    result
  }

  @Benchmark def intsHashMapBench = {
    var result = 0
    var i = 0
    while (i != intsArray.length) {
      val elem = intsArray(i)
      if (intsHashMap.contains(elem))
        result ^= intsHashMap(elem)
      i += 1
    }
    result
  }

  @Benchmark def foosListMapBench = {
    var result = 0
    var i = 0
    while (i != foosArray.length) {
      val elem = foosArray(i)
      if (foosListMap.contains(elem))
        result ^= foosListMap(elem)
      i += 1
    }
    result
  }

  @Benchmark def foosHashMapBench = {
    var result = 0
    var i = 0
    while (i != foosArray.length) {
      val elem = foosArray(i)
      if (foosHashMap.contains(elem))
        result ^= foosHashMap(elem)
      i += 1
    }
    result
  }

  @Benchmark def mixedListMapBench = {
    var result = 0
    var i = 0
    while (i != mixedArray.length) {
      val elem = mixedArray(i)
      if (mixedListMap.contains(elem))
        result ^= mixedListMap(elem)
      i += 1
    }
    result
  }

  @Benchmark def mixedHashMapBench = {
    var result = 0
    var i = 0
    while (i != mixedArray.length) {
      val elem = mixedArray(i)
      if (mixedHashMap.contains(elem))
        result ^= mixedHashMap(elem)
      i += 1
    }
    result
  }
}
