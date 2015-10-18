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

  @Test def ubyteEqEqUByte() = {
    assertEqEq(0.toUByte, 0.toUByte)
    assertEqEq(5.toUByte, 5.toUByte)
    assertEqEq(Byte.MaxValue.toUByte, Byte.MaxValue.toUByte)
    assertEqEq(Byte.MinValue.toUByte, Byte.MinValue.toUByte)
    assertEqEq(UByte.MaxValue, UByte.MaxValue)

    assertNotEq(0.toUByte, 5.toUByte)
    assertNotEq((-32).toUByte, 5.toUByte)
  }

  @Test def ubyteEqEqByte() = {
    assertEqEq(0.toUByte, 0.toByte)
    assertEqEq(5.toUByte, 5.toByte)
    assertEqEq(Byte.MaxValue.toUByte, Byte.MaxValue)

    assertNotEq(Byte.MinValue.toUByte, Byte.MinValue)
    assertNotEq(UByte.MaxValue, UByte.MaxValue.toByte)

    assertNotEq(0.toUByte, 5.toByte)
    assertNotEq((-32).toUByte, 5.toByte)
    assertNotEq(5.toUByte, (-32).toByte)
  }

  @Test def byteEqEqUByte() = {
    assertEqEq(0.toByte, 0.toUByte)
    assertEqEq(5.toByte, 5.toUByte)
    assertEqEq(Byte.MaxValue, Byte.MaxValue.toUByte)

    assertNotEq(Byte.MinValue, Byte.MinValue.toUByte)
    assertNotEq(UByte.MaxValue.toByte, UByte.MaxValue)

    assertNotEq(0.toByte, 5.toUByte)
    assertNotEq((-32).toByte, 5.toUByte)
    assertNotEq(5.toByte, (-32).toUByte)
  }

  @Test def ushortEqEqUByte() = {
    assertEqEq(0.toUShort, 0.toUByte)
    assertEqEq(5.toUShort, 5.toUByte)
    assertEqEq(0x7f.toUShort, 0x7f.toUByte)
    assertEqEq(0x80.toUShort, 0x80.toUByte)
    assertEqEq(0xff.toUShort, 0xff.toUByte)

    assertNotEq(0.toUShort, 5.toUByte)
    assertNotEq((-32).toUShort, (-32).toUByte)
    assertNotEq((-1).toUShort, (-1).toUByte)
    assertNotEq(0x123.toUShort, 0x123.toUByte)
  }

  @Test def ushortEqEqByte() = {
    assertEqEq(0.toUShort, 0.toByte)
    assertEqEq(5.toUShort, 5.toByte)
    assertEqEq(0x7f.toUShort, 0x7f.toByte)

    assertNotEq(0.toUShort, 5.toByte)
    assertNotEq(0x80.toUShort, 0x80.toByte)
    assertNotEq(0xff.toUShort, 0xff.toByte)
    assertNotEq((-32).toUShort, (-32).toByte)
    assertNotEq((-1).toUShort, (-1).toByte)
    assertNotEq(0x123.toUShort, 0x123.toByte)
  }

  @Test def byteEqEqUShort() = {
    assertEqEq(0.toByte, 0.toUShort)
    assertEqEq(5.toByte, 5.toUShort)
    assertEqEq(0x7f.toByte, 0x7f.toUShort)

    assertNotEq(0.toByte, 5.toUShort)
    assertNotEq(0x80.toByte, 0x80.toUShort)
    assertNotEq(0xff.toByte, 0xff.toUShort)
    assertNotEq((-32).toByte, (-32).toUShort)
    assertNotEq((-1).toByte, (-1).toUShort)
    assertNotEq(0x123.toByte, 0x123.toUShort)
  }

  @Test def ubyteEqEqUShort() = {
    assertEqEq(0.toUByte, 0.toUShort)
    assertEqEq(5.toUByte, 5.toUShort)
    assertEqEq(0x7f.toUByte, 0x7f.toUShort)
    assertEqEq(0x80.toUByte, 0x80.toUShort)
    assertEqEq(0xff.toUByte, 0xff.toUShort)

    assertNotEq(0.toUByte, 5.toUShort)
    assertNotEq((-32).toUByte, (-32).toUShort)
    assertNotEq((-1).toUByte, (-1).toUShort)
    assertNotEq(0x123.toUByte, 0x123.toUShort)
  }

  @Test def ushortEqEqUShort() = {
    assertEqEq(0.toUShort, 0.toUShort)
    assertEqEq(5.toUShort, 5.toUShort)
    assertEqEq(Short.MaxValue.toUShort, Short.MaxValue.toUShort)
    assertEqEq(Short.MinValue.toUShort, Short.MinValue.toUShort)
    assertEqEq(UShort.MaxValue, UShort.MaxValue)

    assertNotEq(0.toUShort, 5.toUShort)
    assertNotEq((-32).toUShort, 5.toUShort)
  }

  @Test def ushortEqEqShort() = {
    assertEqEq(0.toUShort, 0.toShort)
    assertEqEq(5.toUShort, 5.toShort)
    assertEqEq(Short.MaxValue.toUShort, Short.MaxValue)

    assertNotEq(Short.MinValue.toUShort, Short.MinValue)
    assertNotEq(UShort.MaxValue, UShort.MaxValue.toShort)

    assertNotEq(0.toUShort, 5.toShort)
    assertNotEq((-32).toUShort, 5.toShort)
    assertNotEq(5.toUShort, (-32).toShort)
  }

  @Test def shortEqEqUShort() = {
    assertEqEq(0.toShort, 0.toUShort)
    assertEqEq(5.toShort, 5.toUShort)
    assertEqEq(Short.MaxValue, Short.MaxValue.toUShort)

    assertNotEq(Short.MinValue, Short.MinValue.toUShort)
    assertNotEq(UShort.MaxValue.toShort, UShort.MaxValue)

    assertNotEq(0.toShort, 5.toUShort)
    assertNotEq((-32).toShort, 5.toUShort)
    assertNotEq(5.toShort, (-32).toUShort)
  }

  @Test def ushortEqEqChar() = {
    assertEqEq(0.toUShort, 0.toChar)
    assertEqEq(5.toUShort, 5.toChar)
    assertEqEq(0x7fff.toUShort, 0x7fff.toChar)
    assertEqEq(0x8000.toUShort, 0x8000.toChar)
    assertEqEq(0xffff.toUShort, 0xffff.toChar)
    assertEqEq((-32).toUShort, (-32).toChar)
    assertEqEq((-1).toUShort, (-1).toChar)
    assertEqEq(0x12345.toUShort, 0x12345.toChar)

    assertNotEq(0.toUShort, 5.toChar)
    assertNotEq(10.toUShort, 8.toChar)
  }

  @Test def charEqEqUShort() = {
    assertEqEq(0.toChar, 0.toUShort)
    assertEqEq(5.toChar, 5.toUShort)
    assertEqEq(0x7fff.toChar, 0x7fff.toUShort)
    assertEqEq(0x8000.toChar, 0x8000.toUShort)
    assertEqEq(0xffff.toChar, 0xffff.toUShort)
    assertEqEq((-32).toChar, (-32).toUShort)
    assertEqEq((-1).toChar, (-1).toUShort)
    assertEqEq(0x12345.toChar, 0x12345.toUShort)

    assertNotEq(0.toChar, 5.toUShort)
    assertNotEq(10.toChar, 8.toUShort)
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

  @Test def uintEqEqByte() = {
    assertEqEq(0.toUInt, 0.toByte)
    assertEqEq(5.toUInt, 5.toByte)
    assertEqEq(0x7f.toUInt, 0x7f.toByte)

    assertNotEq(0.toUInt, 5.toByte)
    assertNotEq(0x80.toUInt, 0x80.toByte)
    assertNotEq(0xff.toUInt, 0xff.toByte)
    assertNotEq((-32).toUInt, (-32).toByte)
    assertNotEq((-1).toUInt, (-1).toByte)
    assertNotEq(0x123.toUInt, 0x123.toByte)
  }

  @Test def byteEqEqUInt() = {
    assertEqEq(0.toByte, 0.toUInt)
    assertEqEq(5.toByte, 5.toUInt)
    assertEqEq(0x7f.toByte, 0x7f.toUInt)

    assertNotEq(0.toByte, 5.toUInt)
    assertNotEq(0x80.toByte, 0x80.toUInt)
    assertNotEq(0xff.toByte, 0xff.toUInt)
    assertNotEq((-32).toByte, (-32).toUInt)
    assertNotEq((-1).toByte, (-1).toUInt)
    assertNotEq(0x123.toByte, 0x123.toUInt)
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

  @Test def uintEqEqChar() = {
    assertEqEq(0.toUInt, 0.toChar)
    assertEqEq(5.toUInt, 5.toChar)
    assertEqEq(0x7fff.toUInt, 0x7fff.toChar)
    assertEqEq(0x8000.toUInt, 0x8000.toChar)
    assertEqEq(0xffff.toUInt, 0xffff.toChar)

    assertNotEq(0.toUInt, 5.toChar)
    assertNotEq((-32).toUInt, (-32).toChar)
    assertNotEq((-1).toUInt, (-1).toChar)
    assertNotEq(0x12345.toUInt, 0x12345.toChar)
  }

  @Test def charEqEqUInt() = {
    assertEqEq(0.toChar, 0.toUInt)
    assertEqEq(5.toChar, 5.toUInt)
    assertEqEq(0x7fff.toChar, 0x7fff.toUInt)
    assertEqEq(0x8000.toChar, 0x8000.toUInt)
    assertEqEq(0xffff.toChar, 0xffff.toUInt)

    assertNotEq(0.toChar, 5.toUInt)
    assertNotEq((-32).toChar, (-32).toUInt)
    assertNotEq((-1).toChar, (-1).toUInt)
    assertNotEq(0x12345.toChar, 0x12345.toUInt)
  }

  @Test def uintEqEqShort() = {
    assertEqEq(0.toUInt, 0.toShort)
    assertEqEq(5.toUInt, 5.toShort)
    assertEqEq(0x7fff.toUInt, 0x7fff.toShort)

    assertNotEq(0.toUInt, 5.toShort)
    assertNotEq(0x8000.toUInt, 0x8000.toShort)
    assertNotEq(0xffff.toUInt, 0xffff.toShort)
    assertNotEq((-32).toUInt, (-32).toShort)
    assertNotEq((-1).toUInt, (-1).toShort)
    assertNotEq(0x12345.toUInt, 0x12345.toShort)
  }

  @Test def shortEqEqUInt() = {
    assertEqEq(0.toShort, 0.toUInt)
    assertEqEq(5.toShort, 5.toUInt)
    assertEqEq(0x7fff.toShort, 0x7fff.toUInt)

    assertNotEq(0.toShort, 5.toUInt)
    assertNotEq(0x8000.toShort, 0x8000.toUInt)
    assertNotEq(0xffff.toShort, 0xffff.toUInt)
    assertNotEq((-32).toShort, (-32).toUInt)
    assertNotEq((-1).toShort, (-1).toUInt)
    assertNotEq(0x12345.toShort, 0x12345.toUInt)
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
