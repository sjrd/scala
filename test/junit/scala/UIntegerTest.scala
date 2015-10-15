package scala

import org.junit.Test
import org.junit.Assert._
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import scala.tools.testing.AssertUtil._

@RunWith(classOf[JUnit4])
class UIntegerTest {

  @Test def createUIntFromInt() = {
    val x = 5.toUInt
    val xIsUInt: UInt = x
    assertEquals(5, x.toInt)
    val y = (-32).toUInt
    val yIsUInt: UInt = y
    assertEquals(-32, y.toInt)
  }

  @Test def uintEquals() = {
    assertEquals(5.toUInt, 5.toUInt)
    assertEquals((-32).toUInt, (-32).toUInt)
    assertEquals(Int.MinValue.toUInt, Int.MinValue.toUInt)

    assertNotEquals(5.toUInt, 0.toUInt)
    assertNotEquals(0.toUInt, 5.toUInt)
    assertNotEquals(5.toUInt, (-32).toUInt)
    assertNotEquals((-1).toUInt, Int.MinValue.toUInt)
  }

  @Test def uintEqEq() = {
    // This tests the primitive == comparison. We cannot use assertEquals.

    assertTrue(5.toUInt == 5.toUInt)
    assertTrue((-32).toUInt == (-32).toUInt)
    assertTrue(Int.MinValue.toUInt == Int.MinValue.toUInt)

    assertFalse(5.toUInt == 0.toUInt)
    assertFalse(0.toUInt == 5.toUInt)
    assertFalse(5.toUInt == (-32).toUInt)
    assertFalse((-1).toUInt == Int.MinValue.toUInt)
  }

  @Test def uintNotEq() = {
    // This tests the primitive != comparison. We cannot use assertEquals.

    assertFalse(5.toUInt != 5.toUInt)
    assertFalse((-32).toUInt != (-32).toUInt)
    assertFalse(Int.MinValue.toUInt != Int.MinValue.toUInt)

    assertTrue(5.toUInt != 0.toUInt)
    assertTrue(0.toUInt != 5.toUInt)
    assertTrue(5.toUInt != (-32).toUInt)
    assertTrue((-1).toUInt != Int.MinValue.toUInt)
  }

  @Test def uintLimitValues() = {
    assertEquals(0.toUInt, UInt.MinValue)
    assertEquals((-1).toUInt, UInt.MaxValue)

    assertEquals(0, UInt.MinValue.toInt)
    assertEquals(-1, UInt.MaxValue.toInt)
  }

  @Test def uintToString() = {
    assertEquals("0", 0.toUInt.toString)
    assertEquals("1", 1.toUInt.toString)
    assertEquals("2147483647", Int.MaxValue.toUInt.toString)
    assertEquals("2147483648", Int.MinValue.toUInt.toString)
    assertEquals("4294967294", (-2).toUInt.toString)
    assertEquals("4294967295", (-1).toUInt.toString)
    assertEquals("4294967295", UInt.MaxValue.toString)
  }

  @Test def uintUnaryNot() = {
    assertEquals(0xffffffff.toUInt, ~0.toUInt)
    assertEquals(0xfffffffe.toUInt, ~1.toUInt)
    assertEquals(0.toUInt, ~UInt.MaxValue)

    assertEquals(833416607.toUInt, ~(-833416608).toUInt)
    assertEquals(-335694663.toUInt, ~335694662.toUInt)
    assertEquals(1379907458.toUInt, ~(-1379907459).toUInt)
    assertEquals(-1918102915.toUInt, ~1918102914.toUInt)
    assertEquals(571905091.toUInt, ~(-571905092).toUInt)
    assertEquals(-471337540.toUInt, ~471337539.toUInt)
    assertEquals(-1828407611.toUInt, ~1828407610.toUInt)
    assertEquals(-425157457.toUInt, ~425157456.toUInt)
    assertEquals(-561596959.toUInt, ~561596958.toUInt)
    assertEquals(-1141874467.toUInt, ~1141874466.toUInt)
  }

  @Test def uintShiftLeft() = {
    assertEquals(0.toUInt, 0.toUInt << 3)
    assertEquals(32.toUInt, 1.toUInt << 5)
    assertEquals(0x10305070.toUInt, 0x01030507.toUInt << 4)
    assertEquals(0x10305070.toUInt, 0x01030507.toUInt << 36)
    assertEquals(0x10305070.toUInt, 0x01030507.toUInt << -28)
    assertEquals(0xfff00000.toUInt, 0x7f00ffff.toUInt << 20)

    assertEquals(0x53c448e0.toUInt, 0xaa9e2247.toUInt << -1916960571)
    assertEquals(0x34380000.toUInt, 0x8218d0e0.toUInt << -608340690)
    assertEquals(0xc8000000.toUInt, 0x580cd964.toUInt << 59011833)
    assertEquals(0x36938000.toUInt, 0xf44a6d27.toUInt << -759838577)
    assertEquals(0xa423cb40.toUInt, 0x5a423cb4.toUInt << 1036264548)
    assertEquals(0xf3584400.toUInt, 0xd3bcd611.toUInt << 1784055370)
    assertEquals(0xd5db1400.toUInt, 0x0b6aed8a.toUInt << -463959703)
    assertEquals(0x00000000.toUInt, 0x96770900.toUInt << 1965576766)
    assertEquals(0x62191700.toUInt, 0x2c621917.toUInt << 2025135688)
    assertEquals(0xe17e0000.toUInt, 0x3cc5f0bf.toUInt << 1459687249)
  }

  @Test def uintShiftLeftLong() = {
    // We avoid any rhs with values outside of (0, 31) because of SI-9516

    assertEquals(0.toUInt, 0.toUInt << 3L)
    assertEquals(32.toUInt, 1.toUInt << 5L)
    assertEquals(0x10305070.toUInt, 0x01030507.toUInt << 4L)
    assertEquals(0xfff00000.toUInt, 0x7f00ffff.toUInt << 20L)

    assertEquals(0x53c448e0.toUInt, 0xaa9e2247.toUInt << 5L)
    assertEquals(0x34380000.toUInt, 0x8218d0e0.toUInt << 14L)
    assertEquals(0xc8000000.toUInt, 0x580cd964.toUInt << 25L)
    assertEquals(0x36938000.toUInt, 0xf44a6d27.toUInt << 15L)
    assertEquals(0xa423cb40.toUInt, 0x5a423cb4.toUInt << 4L)
    assertEquals(0xf3584400.toUInt, 0xd3bcd611.toUInt << 10L)
    assertEquals(0xd5db1400.toUInt, 0x0b6aed8a.toUInt << 9L)
    assertEquals(0x00000000.toUInt, 0x96770900.toUInt << 30L)
    assertEquals(0x62191700.toUInt, 0x2c621917.toUInt << 8L)
    assertEquals(0xe17e0000.toUInt, 0x3cc5f0bf.toUInt << 17L)
  }

  @Test def uintShiftLogicalRight() = {
    assertEquals(0.toUInt, 0.toUInt >>> 3)
    assertEquals(8.toUInt, 64.toUInt >>> 3)
    assertEquals(1024.toUInt, 0x80000000.toUInt >>> 21)
    assertEquals(0x09070503.toUInt, 0x90705030.toUInt >>> 4)
    assertEquals(0x09070503.toUInt, 0x90705030.toUInt >>> 36)
    assertEquals(0x09070503.toUInt, 0x90705030.toUInt >>> -28)
    assertEquals(0x000008f0.toUInt, 0x8f00ffff.toUInt >>> 20)

    assertEquals(0x000a9310.toUInt, 0xa9310225.toUInt >>> 1509108108)
    assertEquals(0x0000068a.toUInt, 0x68a34424.toUInt >>> -1731382316)
    assertEquals(0x000002b0.toUInt, 0xac2caaaa.toUInt >>> -400354218)
    assertEquals(0x00188ed5.toUInt, 0x623b5664.toUInt >>> 761740170)
    assertEquals(0x000001db.toUInt, 0xedbc8f0c.toUInt >>> -1602099369)
    assertEquals(0x0000419b.toUInt, 0x8336cbdd.toUInt >>> 469268337)
    assertEquals(0x0000035d.toUInt, 0xd77756b9.toUInt >>> 1234609558)
    assertEquals(0x00000256.toUInt, 0x95b61c30.toUInt >>> -73072874)
    assertEquals(0x0033d1dd.toUInt, 0x33d1dd8a.toUInt >>> 536608584)
    assertEquals(0x0000000d.toUInt, 0xde416f7b.toUInt >>> 993957596)
  }

  @Test def uintShiftArithmeticRight() = {
    assertEquals(0.toUInt, 0.toUInt >> 3)
    assertEquals(8.toUInt, 64.toUInt >> 3)
    assertEquals(0xfffffc00.toUInt, 0x80000000.toUInt >> 21)
    assertEquals(0xf9070503.toUInt, 0x90705030.toUInt >> 4)
    assertEquals(0xf9070503.toUInt, 0x90705030.toUInt >> 36)
    assertEquals(0xf9070503.toUInt, 0x90705030.toUInt >> -28)
    assertEquals(0xfffff8f0.toUInt, 0x8f00ffff.toUInt >> 20)

    assertEquals(0xfffa9310.toUInt, 0xa9310225.toUInt >> 1509108108)
    assertEquals(0x0000068a.toUInt, 0x68a34424.toUInt >> -1731382316)
    assertEquals(0xfffffeb0.toUInt, 0xac2caaaa.toUInt >> -400354218)
    assertEquals(0x00188ed5.toUInt, 0x623b5664.toUInt >> 761740170)
    assertEquals(0xffffffdb.toUInt, 0xedbc8f0c.toUInt >> -1602099369)
    assertEquals(0xffffc19b.toUInt, 0x8336cbdd.toUInt >> 469268337)
    assertEquals(0xffffff5d.toUInt, 0xd77756b9.toUInt >> 1234609558)
    assertEquals(0xfffffe56.toUInt, 0x95b61c30.toUInt >> -73072874)
    assertEquals(0x0033d1dd.toUInt, 0x33d1dd8a.toUInt >> 536608584)
    assertEquals(0xfffffffd.toUInt, 0xde416f7b.toUInt >> 993957596)
  }
}
