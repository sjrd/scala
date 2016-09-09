package perf

import org.openjdk.jmh.annotations.{State, Scope, Benchmark}

sealed abstract class Foo

final class Foo1(val x: Int) extends Foo {
  final override def hashCode: Int = x.hashCode
  final override def equals(other: Any) = other match {
    case other: Foo1 => this.x == other.x
    case _           => false
  }
}

final class Foo2(val x: Int) extends Foo {
  final override def hashCode: Int = x.hashCode
  final override def equals(other: Any) = other match {
    case other: Foo2 => this.x == other.x
    case _           => false
  }
}

final class Foo3(val x: Int) extends Foo {
  final override def hashCode: Int = x.hashCode
  final override def equals(other: Any) = other match {
    case other: Foo3 => this.x == other.x
    case _           => false
  }
}

final class Foo4(val x: Int) extends Foo {
  final override def hashCode: Int = x.hashCode
  final override def equals(other: Any) = other match {
    case other: Foo4 => this.x == other.x
    case _           => false
  }
}

final class Foo5(val x: Int) extends Foo {
  final override def hashCode: Int = x.hashCode
  final override def equals(other: Any) = other match {
    case other: Foo5 => this.x == other.x
    case _           => false
  }
}

@State(Scope.Benchmark)
class MapsBenchmark {
  final val TotalSize = 10000
  final val PresentSize = TotalSize / 2

  private[this] lazy val intsArray =
    Array.fill[Int](TotalSize)(scala.util.Random.nextInt())

  private[this] lazy val foosArray =
    Array.tabulate[Foo](TotalSize)(i => createFoo(i, scala.util.Random.nextInt()))

  private[this] lazy val mixedArray =
    Array.tabulate[AnyRef](TotalSize) { i =>
      if (scala.util.Random.nextBoolean()) Integer.valueOf(scala.util.Random.nextInt())
      else createFoo(i, (scala.util.Random.nextInt()))
    }

  private[this] def fillMap[A](m: scala.collection.mutable.Map[A, Int],
      sourceArray: Array[A]): m.type = {
    val start = (TotalSize - PresentSize) / 2
    for (i <- start until (start + PresentSize))
      m += sourceArray(i) -> i
    m
  }

  private[this] def createFoo(i: Int, x: Int): Foo = (i % 5) match {
    case 0 => new Foo1(x)
    case 1 => new Foo2(x)
    case 2 => new Foo3(x)
    case 3 => new Foo4(x)
    case 4 => new Foo5(x)
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

  lazy val polluteEqEqProfiles: Int = {
    var value = 0
    val mixedArray = this.mixedArray
    var i = 0
    while (i != mixedArray.length - 1) {
      var j = 0
      while (j != mixedArray.length - 1) {
        if (mixedArray(i) == mixedArray(j))
          value += 1
        j += 1
      }
      i += 1
    }
    value
  }

  @Benchmark def intsListMapBench = {
    polluteEqEqProfiles

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
    polluteEqEqProfiles

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
    polluteEqEqProfiles

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
    polluteEqEqProfiles

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
    polluteEqEqProfiles

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
    polluteEqEqProfiles

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
