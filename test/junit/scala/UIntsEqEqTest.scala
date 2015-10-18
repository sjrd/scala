package scala

import org.junit.Test
import org.junit.Assert._
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import scala.tools.testing.AssertUtil._

@RunWith(classOf[JUnit4])
class UIntsEqEqTest {

  def assertEqEq(a: Any, b: Any): Unit = {
    if (a != b) {
      fail(s"expected (of class ${a.getClass.getSimpleName}) $a == " +
          s"$b (of class ${b.getClass.getSimpleName}) but they are !=")
    }
  }

  def assertNotEq(a: Any, b: Any): Unit = {
    if (a == b) {
      fail(s"expected (of class ${a.getClass.getSimpleName}) $a != " +
          s"$b (of class ${b.getClass.getSimpleName}) to but they are ==")
    }
  }

  @Test def uintEqEqUInt() = {
    assertEqEq(0.toUInt, 0.toUInt)
    assertEqEq(5.toUInt, 5.toUInt)
    assertEqEq(Int.MaxValue.toUInt, Int.MaxValue.toUInt)
    assertEqEq(Int.MinValue.toUInt, Int.MinValue.toUInt)
    assertEqEq(UInt.MaxValue, UInt.MaxValue)

    assertNotEq(0.toUInt, 5.toUInt)
    assertNotEq((-32).toUInt, 5.toUInt)
  }

  @Test def uintEqEqInt() = {
    assertEqEq(0.toUInt, 0)
    assertEqEq(5.toUInt, 5)
    assertEqEq(Int.MaxValue.toUInt, Int.MaxValue)

    assertNotEq(Int.MinValue.toUInt, Int.MinValue)
    assertNotEq(UInt.MaxValue, UInt.MaxValue.toInt)

    assertNotEq(0.toUInt, 5)
    assertNotEq((-32).toUInt, 5)
    assertNotEq(5.toUInt, -32)
  }

  @Test def intEqEqUInt() = {
    assertEqEq(0, 0.toUInt)
    assertEqEq(5, 5.toUInt)
    assertEqEq(Int.MaxValue, Int.MaxValue.toUInt)

    assertNotEq(Int.MinValue, Int.MinValue.toUInt)
    assertNotEq(UInt.MaxValue.toInt, UInt.MaxValue)

    assertNotEq(0, 5.toUInt)
    assertNotEq(-32, 5.toUInt)
    assertNotEq(5, (-32).toUInt)
  }

}
