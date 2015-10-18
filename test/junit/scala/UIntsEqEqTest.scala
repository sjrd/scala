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

  @Test def uintEqEqUByte() = {
    assertEqEq(0.toUInt, 0.toUByte)
    assertEqEq(5.toUInt, 5.toUByte)
    assertEqEq(0x7f.toUInt, 0x7f.toUByte)
    assertEqEq(0x80.toUInt, 0x80.toUByte)
    assertEqEq(0xff.toUInt, 0xff.toUByte)

    assertNotEq(0.toUInt, 5.toUByte)
    assertNotEq((-32).toUInt, (-32).toUByte)
    assertNotEq((-1).toUInt, (-1).toUByte)
    assertNotEq(0x123.toUInt, 0x123.toUByte)
  }

  @Test def ubyteEqEqUInt() = {
    assertEqEq(0.toUByte, 0.toUInt)
    assertEqEq(5.toUByte, 5.toUInt)
    assertEqEq(0x7f.toUByte, 0x7f.toUInt)
    assertEqEq(0x80.toUByte, 0x80.toUInt)
    assertEqEq(0xff.toUByte, 0xff.toUInt)

    assertNotEq(0.toUByte, 5.toUInt)
    assertNotEq((-32).toUByte, (-32).toUInt)
    assertNotEq((-1).toUByte, (-1).toUInt)
    assertNotEq(0x123.toUByte, 0x123.toUInt)
  }

  @Test def uintEqEqUShort() = {
    assertEqEq(0.toUInt, 0.toUShort)
    assertEqEq(5.toUInt, 5.toUShort)
    assertEqEq(0x7fff.toUInt, 0x7fff.toUShort)
    assertEqEq(0x8000.toUInt, 0x8000.toUShort)
    assertEqEq(0xffff.toUInt, 0xffff.toUShort)

    assertNotEq(0.toUInt, 5.toUShort)
    assertNotEq((-32).toUInt, (-32).toUShort)
    assertNotEq((-1).toUInt, (-1).toUShort)
    assertNotEq(0x12345.toUInt, 0x12345.toUShort)
  }

  @Test def ushortEqEqUInt() = {
    assertEqEq(0.toUShort, 0.toUInt)
    assertEqEq(5.toUShort, 5.toUInt)
    assertEqEq(0x7fff.toUShort, 0x7fff.toUInt)
    assertEqEq(0x8000.toUShort, 0x8000.toUInt)
    assertEqEq(0xffff.toUShort, 0xffff.toUInt)

    assertNotEq(0.toUShort, 5.toUInt)
    assertNotEq((-32).toUShort, (-32).toUInt)
    assertNotEq((-1).toUShort, (-1).toUInt)
    assertNotEq(0x12345.toUShort, 0x12345.toUInt)
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

  @Test def uintEqEqULong() = {
    assertEqEq(0.toUInt, 0L.toULong)
    assertEqEq(5.toUInt, 5L.toULong)
    assertEqEq(0x7fffffff.toUInt, 0x7fffffffL.toULong)
    assertEqEq(0x80000000.toUInt, 0x80000000L.toULong)
    assertEqEq(0xffffffff.toUInt, 0xffffffffL.toULong)

    assertNotEq(0.toUInt, 5L.toULong)
    assertNotEq((-32).toUInt, (-32L).toULong)
    assertNotEq((-1).toUInt, (-1L).toULong)
    assertNotEq(0x123456489L.toUInt, 0x123456489L.toULong)
  }

  @Test def ulongEqEqUInt() = {
    assertEqEq(0L.toULong, 0.toUInt)
    assertEqEq(5L.toULong, 5.toUInt)
    assertEqEq(0x7fffffffL.toULong, 0x7fffffff.toUInt)
    assertEqEq(0x80000000L.toULong, 0x80000000.toUInt)
    assertEqEq(0xffffffffL.toULong, 0xffffffff.toUInt)

    assertNotEq(0L.toULong, 5.toUInt)
    assertNotEq((-32L).toULong, (-32).toUInt)
    assertNotEq((-1L).toULong, (-1).toUInt)
    assertNotEq(0x123456489L.toULong, 0x123456489L.toUInt)
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

  @Test def uintEqEqLong() = {
    assertEqEq(0.toUInt, 0L)
    assertEqEq(5.toUInt, 5L)
    assertEqEq(0x7fffffff.toUInt, 0x7fffffffL)
    assertEqEq(0x80000000.toUInt, 0x80000000L)
    assertEqEq(0xffffffff.toUInt, 0xffffffffL)

    assertNotEq(0.toUInt, 5L)
    assertNotEq((-32).toUInt, -32L)
    assertNotEq((-1).toUInt, -1L)
    assertNotEq(0x123456489L.toUInt, 0x123456489L)
  }

  @Test def longEqEqUInt() = {
    assertEqEq(0L, 0.toUInt)
    assertEqEq(5L, 5.toUInt)
    assertEqEq(0x7fffffffL, 0x7fffffff.toUInt)
    assertEqEq(0x80000000L, 0x80000000.toUInt)
    assertEqEq(0xffffffffL, 0xffffffff.toUInt)

    assertNotEq(0L, 5.toUInt)
    assertNotEq(-32L, (-32).toUInt)
    assertNotEq(-1L, (-1).toUInt)
    assertNotEq(0x123456489L, 0x123456489L.toUInt)
  }

  @Test def ulongEqEqLong() = {
    assertEqEq(0L.toULong, 0L)
    assertEqEq(5L.toULong, 5L)
    assertEqEq(0x7fffffffL.toULong, 0x7fffffffL)
    assertEqEq(0x80000000L.toULong, 0x80000000L)
    assertEqEq(0xffffffffL.toULong, 0xffffffffL)
    assertEqEq(0x100000000L.toULong, 0x100000000L)
    assertEqEq(0x123456789abcdefL.toULong, 0x123456789abcdefL)
    assertEqEq(0x7fffffffffffffffL.toULong, 0x7fffffffffffffffL)

    assertNotEq(0L.toULong, 5L)
    assertNotEq((-32L).toULong, -32L)
    assertNotEq((-1L).toULong, -1L)
    assertNotEq(0x8000000000000000L.toULong, 0x8000000000000000L)
  }

  @Test def longEqEqULong() = {
    assertEqEq(0L, 0L.toULong)
    assertEqEq(5L, 5L.toULong)
    assertEqEq(0x7fffffffL, 0x7fffffffL.toULong)
    assertEqEq(0x80000000L, 0x80000000L.toULong)
    assertEqEq(0xffffffffL, 0xffffffffL.toULong)
    assertEqEq(0x100000000L, 0x100000000L.toULong)
    assertEqEq(0x123456789abcdefL, 0x123456789abcdefL.toULong)
    assertEqEq(0x7fffffffffffffffL, 0x7fffffffffffffffL.toULong)

    assertNotEq(0L, 5L.toULong)
    assertNotEq(-32L, (-32L).toULong)
    assertNotEq(-1L, (-1L).toULong)
    assertNotEq(0x8000000000000000L, 0x8000000000000000L.toULong)
  }

}
