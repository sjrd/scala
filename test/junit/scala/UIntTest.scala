package scala

import org.junit.Test
import org.junit.Assert._
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import scala.tools.testing.AssertUtil._

@RunWith(classOf[JUnit4])
class UIntTest {

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

  @Test def uintCompareTo() = {
    assertTrue(0.toUInt.compareTo(0.toUInt) == 0)
    assertTrue(5.toUInt.compareTo(5.toUInt) == 0)
    assertTrue((-32).toUInt.compareTo((-32).toUInt) == 0)

    assertTrue(0.toUInt.compareTo(5.toUInt) < 0)
    assertTrue(Int.MaxValue.toUInt.compareTo(Int.MinValue.toUInt) < 0)
    assertTrue(54321.toUInt.compareTo((-12345).toUInt) < 0)
    assertTrue(0.toUInt.compareTo(UInt.MaxValue) < 0)

    assertTrue(5.toUInt.compareTo(0.toUInt) > 0)
    assertTrue(Int.MinValue.toUInt.compareTo(Int.MaxValue.toUInt) > 0)
    assertTrue((-12345).toUInt.compareTo(54321.toUInt) > 0)
    assertTrue(UInt.MaxValue.toUInt.compareTo(0.toUInt) > 0)
  }

  @Test def uintHasOrdering() = {
    val ord = implicitly[Ordering[UInt]]

    assertTrue(ord.compare(0.toUInt, 0.toUInt) == 0)
    assertTrue(ord.compare(5.toUInt, 5.toUInt) == 0)
    assertTrue(ord.compare((-32).toUInt, (-32).toUInt) == 0)

    assertTrue(ord.compare(0.toUInt, 5.toUInt) < 0)
    assertTrue(ord.compare(Int.MaxValue.toUInt, Int.MinValue.toUInt) < 0)
    assertTrue(ord.compare(54321.toUInt, (-12345).toUInt) < 0)
    assertTrue(ord.compare(0.toUInt, UInt.MaxValue) < 0)

    assertTrue(ord.compare(5.toUInt, 0.toUInt) > 0)
    assertTrue(ord.compare(Int.MinValue.toUInt, Int.MaxValue.toUInt) > 0)
    assertTrue(ord.compare((-12345).toUInt, 54321.toUInt) > 0)
    assertTrue(ord.compare(UInt.MaxValue.toUInt, 0.toUInt) > 0)
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

  @Test def uintLessThan() = {
    assertFalse(0.toUInt < 0.toUInt)
    assertFalse(5.toUInt < 5.toUInt)
    assertFalse((-32).toUInt < (-32).toUInt)

    assertTrue(0.toUInt < 5.toUInt)
    assertTrue(Int.MaxValue.toUInt < Int.MinValue.toUInt)
    assertTrue(54321.toUInt < (-12345).toUInt)
    assertTrue(0.toUInt < UInt.MaxValue)

    assertFalse(5.toUInt < 0.toUInt)
    assertFalse(Int.MinValue.toUInt < Int.MaxValue.toUInt)
    assertFalse((-12345).toUInt < 54321.toUInt)
    assertFalse(UInt.MaxValue.toUInt < 0.toUInt)
  }

  @Test def uintLessThanOrEqual() = {
    assertTrue(0.toUInt <= 0.toUInt)
    assertTrue(5.toUInt <= 5.toUInt)
    assertTrue((-32).toUInt <= (-32).toUInt)

    assertTrue(0.toUInt <= 5.toUInt)
    assertTrue(Int.MaxValue.toUInt <= Int.MinValue.toUInt)
    assertTrue(54321.toUInt <= (-12345).toUInt)
    assertTrue(0.toUInt <= UInt.MaxValue)

    assertFalse(5.toUInt <= 0.toUInt)
    assertFalse(Int.MinValue.toUInt <= Int.MaxValue.toUInt)
    assertFalse((-12345).toUInt <= 54321.toUInt)
    assertFalse(UInt.MaxValue.toUInt <= 0.toUInt)
  }

  @Test def uintGreaterThan() = {
    assertFalse(0.toUInt > 0.toUInt)
    assertFalse(5.toUInt > 5.toUInt)
    assertFalse((-32).toUInt > (-32).toUInt)

    assertFalse(0.toUInt > 5.toUInt)
    assertFalse(Int.MaxValue.toUInt > Int.MinValue.toUInt)
    assertFalse(54321.toUInt > (-12345).toUInt)
    assertFalse(0.toUInt > UInt.MaxValue)

    assertTrue(5.toUInt > 0.toUInt)
    assertTrue(Int.MinValue.toUInt > Int.MaxValue.toUInt)
    assertTrue((-12345).toUInt > 54321.toUInt)
    assertTrue(UInt.MaxValue.toUInt > 0.toUInt)
  }

  @Test def uintGreaterThanOrEqual() = {
    assertTrue(0.toUInt >= 0.toUInt)
    assertTrue(5.toUInt >= 5.toUInt)
    assertTrue((-32).toUInt >= (-32).toUInt)

    assertFalse(0.toUInt >= 5.toUInt)
    assertFalse(Int.MaxValue.toUInt >= Int.MinValue.toUInt)
    assertFalse(54321.toUInt >= (-12345).toUInt)
    assertFalse(0.toUInt >= UInt.MaxValue)

    assertTrue(5.toUInt >= 0.toUInt)
    assertTrue(Int.MinValue.toUInt >= Int.MaxValue.toUInt)
    assertTrue((-12345).toUInt >= 54321.toUInt)
    assertTrue(UInt.MaxValue.toUInt >= 0.toUInt)
  }

  @Test def uintBitwiseOr() = {
    assertEquals(0xefe5d73f.toUInt, 0x4ea54736.toUInt | 0xabe0d22d.toUInt)
    assertEquals(0xaf7d60fe.toUInt, 0x8b0920ee.toUInt | 0x2d7d40fc.toUInt)
    assertEquals(0x2b7fde3b.toUInt, 0x233e560b.toUInt | 0x2b65cc39.toUInt)
    assertEquals(0xdf535edf.toUInt, 0x4513569e.toUInt | 0x9f415acd.toUInt)
    assertEquals(0xbf7efcff.toUInt, 0xaf7ef8da.toUInt | 0x92601477.toUInt)
    assertEquals(0xfe8bcadd.toUInt, 0x640ac298.toUInt | 0xfe83ca45.toUInt)
    assertEquals(0xfeb75e3a.toUInt, 0xbeb64432.toUInt | 0xc6231e2a.toUInt)
    assertEquals(0xbfdfffbf.toUInt, 0x940fe139.toUInt | 0x3fdcffbf.toUInt)
    assertEquals(0x89724af5.toUInt, 0x88624ad1.toUInt | 0x81720a35.toUInt)
    assertEquals(0xdfffcffd.toUInt, 0x412f48bd.toUInt | 0x9fd3cffd.toUInt)
  }

  @Test def uintBitwiseAnd() = {
    assertEquals(0x42520814.toUInt, 0x4a528957.toUInt & 0x43db3abc.toUInt)
    assertEquals(0x10304a11.toUInt, 0x1b34de15.toUInt & 0x10b16a71.toUInt)
    assertEquals(0x48c0d908.toUInt, 0x79d8d93d.toUInt & 0xcec6fd0a.toUInt)
    assertEquals(0x15a502b8.toUInt, 0xd7bd02fc.toUInt & 0x1da7efb8.toUInt)
    assertEquals(0x00200d04.toUInt, 0x60221f04.toUInt & 0x13ac6db4.toUInt)
    assertEquals(0x8ce00042.toUInt, 0xace2114b.toUInt & 0x8ced6c66.toUInt)
    assertEquals(0x802d22b1.toUInt, 0x81af27b1.toUInt & 0x986dfaff.toUInt)
    assertEquals(0x14453408.toUInt, 0x15f5b78c.toUInt & 0x5c453c08.toUInt)
    assertEquals(0x53112978.toUInt, 0x53796978.toUInt & 0x5b11297e.toUInt)
    assertEquals(0x628a0846.toUInt, 0x629b0ace.toUInt & 0x628e1866.toUInt)
  }

  @Test def uintBitwiseXor() = {
    assertEquals(0x9bcde549.toUInt, 0xb0d69bb6.toUInt ^ 0x2b1b7eff.toUInt)
    assertEquals(0x7d0438bf.toUInt, 0x808f61b7.toUInt ^ 0xfd8b5908.toUInt)
    assertEquals(0xc1f1ed8c.toUInt, 0xaee95a24.toUInt ^ 0x6f18b7a8.toUInt)
    assertEquals(0x4f396a24.toUInt, 0xdebd4cdf.toUInt ^ 0x918426fb.toUInt)
    assertEquals(0x42f0ee15.toUInt, 0xac9c4749.toUInt ^ 0xee6ca95c.toUInt)
    assertEquals(0x5eade88f.toUInt, 0x4616405b.toUInt ^ 0x18bba8d4.toUInt)
    assertEquals(0xc0dd1b52.toUInt, 0x6c086230.toUInt ^ 0xacd57962.toUInt)
    assertEquals(0x5815a862.toUInt, 0xf764c297.toUInt ^ 0xaf716af5.toUInt)
    assertEquals(0x66d78b13.toUInt, 0x22fe835b.toUInt ^ 0x44290848.toUInt)
    assertEquals(0xb05bbc66.toUInt, 0x3e123468.toUInt ^ 0x8e49880e.toUInt)
  }

  @Test def uintAdd() = {
    assertEquals(0x2b99ecfc.toUInt, 0x7f7734f7.toUInt + 0xac22b805.toUInt)
    assertEquals(0xe8e8dc46.toUInt, 0x43f88660.toUInt + 0xa4f055e6.toUInt)
    assertEquals(0x6ef04aad.toUInt, 0xc92b5a50.toUInt + 0xa5c4f05d.toUInt)
    assertEquals(0x94cf09bf.toUInt, 0x2b096f64.toUInt + 0x69c59a5b.toUInt)
    assertEquals(0xc0ef600f.toUInt, 0x76cb5a86.toUInt + 0x4a240589.toUInt)
    assertEquals(0x21b18523.toUInt, 0xfc19f87c.toUInt + 0x25978ca7.toUInt)
    assertEquals(0x44182797.toUInt, 0x9271c281.toUInt + 0xb1a66516.toUInt)
    assertEquals(0xd3f098ce.toUInt, 0x9fba71ea.toUInt + 0x343626e4.toUInt)
    assertEquals(0xc469bf2e.toUInt, 0x31499221.toUInt + 0x93202d0d.toUInt)
    assertEquals(0x4c1bb14e.toUInt, 0xf3f0257d.toUInt + 0x582b8bd1.toUInt)
  }

  @Test def uintSubtract() = {
    assertEquals(0xc5411767.toUInt, 0x8d2fa8ba.toUInt - 0xc7ee9153.toUInt)
    assertEquals(0x87b8d550.toUInt, 0xd9275a26.toUInt - 0x516e84d6.toUInt)
    assertEquals(0x0a00516d.toUInt, 0x2f9a04bf.toUInt - 0x2599b352.toUInt)
    assertEquals(0xa6592086.toUInt, 0x47097ccb.toUInt - 0xa0b05c45.toUInt)
    assertEquals(0xedbcfae3.toUInt, 0x3a86cabc.toUInt - 0x4cc9cfd9.toUInt)
    assertEquals(0x3514ea79.toUInt, 0xb84c825b.toUInt - 0x833797e2.toUInt)
    assertEquals(0x4f196049.toUInt, 0x91e04789.toUInt - 0x42c6e740.toUInt)
    assertEquals(0x2e007f7d.toUInt, 0x704dd722.toUInt - 0x424d57a5.toUInt)
    assertEquals(0xa05a1dec.toUInt, 0x44e261bc.toUInt - 0xa48843d0.toUInt)
    assertEquals(0x524112a0.toUInt, 0xc79c6f5d.toUInt - 0x755b5cbd.toUInt)
  }

  @Test def uintMultiply() = {
    assertEquals(0xb033cfff.toUInt, 0x9ee12e5f.toUInt * 0x62cb8261.toUInt)
    assertEquals(0x21edc258.toUInt, 0x22bacd11.toUInt * 0x9b34fcd8.toUInt)
    assertEquals(0x742cf126.toUInt, 0x30979ce2.toUInt * 0x84010143.toUInt)
    assertEquals(0xa3ee7077.toUInt, 0xe19b0f17.toUInt * 0xc5e585a1.toUInt)
    assertEquals(0xfc5d2873.toUInt, 0x9a206e53.toUInt * 0xcd55d961.toUInt)
    assertEquals(0xfc7a404e.toUInt, 0x33e45d7b.toUInt * 0x1102d48a.toUInt)
    assertEquals(0xdb925941.toUInt, 0x012aebcb.toUInt * 0x3e01c5a3.toUInt)
    assertEquals(0xf4965c8d.toUInt, 0x9f324707.toUInt * 0x552b26cb.toUInt)
    assertEquals(0x8d0e8cdc.toUInt, 0xc220102b.toUInt * 0x69819c94.toUInt)
    assertEquals(0x2e19d72a.toUInt, 0x4e73e41a.toUInt * 0x604165a9.toUInt)
  }

  @Test def uintDivide() = {
    assertEquals(0.toUInt, 5.toUInt / (-1).toUInt)
    assertEquals(0.toUInt, Int.MinValue.toUInt / (-1).toUInt)

    assertEquals(0x00002525.toUInt, 0x2faba4e0.toUInt / 0x00014883.toUInt)
    assertEquals(0x00000f00.toUInt, 0x46073b42.toUInt / 0x0004ab26.toUInt)
    assertEquals(0x00000909.toUInt, 0x80200126.toUInt / 0x000e2e0a.toUInt)
    assertEquals(0x00000d62.toUInt, 0xb5794be5.toUInt / 0x000d8f15.toUInt)
    assertEquals(0x00000cc7.toUInt, 0xb179d79d.toUInt / 0x000de398.toUInt)
    assertEquals(0x00105c0e.toUInt, 0x467ca3eb.toUInt / 0x0000044f.toUInt)
    assertEquals(0x00000282.toUInt, 0x2106cbe7.toUInt / 0x000d2b02.toUInt)
    assertEquals(0x00001279.toUInt, 0x99d91f77.toUInt / 0x000853bf.toUInt)
    assertEquals(0x00000565.toUInt, 0x4691072d.toUInt / 0x000d140c.toUInt)
    assertEquals(0x000001e4.toUInt, 0x07d8d149.toUInt / 0x000425e8.toUInt)
  }

  @Test(expected = classOf[ArithmeticException])
  def uintDivideByZero() = {
    val _ = 5.toUInt / 0.toUInt
  }

  @Test def uintRemainder() = {
    assertEquals(0x7615d.toUInt, 0x00653d9b.toUInt % 0x962d3.toUInt)
    assertEquals(0x1b3f7.toUInt, 0xa676c753.toUInt % 0x5f252.toUInt)
    assertEquals(0x39968.toUInt, 0xb7af170d.toUInt % 0xa8571.toUInt)
    assertEquals(0x493f2.toUInt, 0xa2dd048d.toUInt % 0xc0803.toUInt)
    assertEquals(0x23239.toUInt, 0xc066ef0a.toUInt % 0x58dfb.toUInt)
    assertEquals(0x0669e.toUInt, 0x6ee7c405.toUInt % 0x866fd.toUInt)
    assertEquals(0x62a2e.toUInt, 0x5c471ff0.toUInt % 0xd319f.toUInt)
    assertEquals(0x37eed.toUInt, 0x50315939.toUInt % 0x450d7.toUInt)
    assertEquals(0x07dc3.toUInt, 0x0cee4d71.toUInt % 0x1ef81.toUInt)
    assertEquals(0x01948.toUInt, 0xe28b41a8.toUInt % 0xe453d.toUInt)
  }

  @Test(expected = classOf[ArithmeticException])
  def uintRemainderOfDivByZero() = {
    val _ = 5.toUInt % 0.toUInt
  }

  @Test def uintMin() = {
    assertEquals(0.toUInt, 0.toUInt min 0.toUInt)
    assertEquals(5.toUInt, 5.toUInt min 5.toUInt)
    assertEquals((-32).toUInt, (-32).toUInt min (-32).toUInt)

    assertEquals(0.toUInt, 0.toUInt min 5.toUInt)
    assertEquals(Int.MaxValue.toUInt, Int.MaxValue.toUInt min Int.MinValue.toUInt)
    assertEquals(54321.toUInt, 54321.toUInt min (-12345).toUInt)
    assertEquals(0.toUInt, 0.toUInt min UInt.MaxValue.toUInt)

    assertEquals(0.toUInt, 5.toUInt min 0.toUInt)
    assertEquals(Int.MaxValue.toUInt, Int.MinValue.toUInt min Int.MaxValue.toUInt)
    assertEquals(54321.toUInt, (-12345).toUInt min 54321.toUInt)
    assertEquals(0.toUInt, UInt.MaxValue.toUInt min 0.toUInt)
  }

  @Test def uintMax() = {
    assertEquals(0.toUInt, 0.toUInt max 0.toUInt)
    assertEquals(5.toUInt, 5.toUInt max 5.toUInt)
    assertEquals((-32).toUInt, (-32).toUInt max (-32).toUInt)

    assertEquals(5.toUInt, 0.toUInt max 5.toUInt)
    assertEquals(Int.MinValue.toUInt, Int.MaxValue.toUInt max Int.MinValue.toUInt)
    assertEquals((-12345).toUInt, 54321.toUInt max (-12345).toUInt)
    assertEquals(UInt.MaxValue.toUInt, 0.toUInt max UInt.MaxValue.toUInt)

    assertEquals(5.toUInt, 5.toUInt max 0.toUInt)
    assertEquals(Int.MinValue.toUInt, Int.MinValue.toUInt max Int.MaxValue.toUInt)
    assertEquals((-12345).toUInt, (-12345).toUInt max 54321.toUInt)
    assertEquals(UInt.MaxValue.toUInt, UInt.MaxValue.toUInt max 0.toUInt)
  }

  @Test def uintToBinaryString() = {
    assertEquals("1111001101101110110001000111101", 0x79b7623d.toUInt.toBinaryString)
    assertEquals("101111000101000000100101100", 0x5e2812c.toUInt.toBinaryString)
    assertEquals("10000000111111100011101110100110", 0x80fe3ba6.toUInt.toBinaryString)
    assertEquals("1001101000110101011000111001110", 0x4d1ab1ce.toUInt.toBinaryString)
    assertEquals("100001001001110011010100000000", 0x21273500.toUInt.toBinaryString)
    assertEquals("11001001100010100100000111001011", 0xc98a41cb.toUInt.toBinaryString)
    assertEquals("10111111101101000111011001110000", 0xbfb47670.toUInt.toBinaryString)
    assertEquals("1100011011011110110111000011100", 0x636f6e1c.toUInt.toBinaryString)
    assertEquals("10010111010110110000100010001111", 0x975b088f.toUInt.toBinaryString)
    assertEquals("1001000000101000100100011001001", 0x481448c9.toUInt.toBinaryString)
  }

  @Test def uintToHexString() = {
    assertEquals("fbce2f7f", 0xfbce2f7f.toUInt.toHexString)
    assertEquals("2ae59524", 0x2ae59524.toUInt.toHexString)
    assertEquals("e1e25b5d", 0xe1e25b5d.toUInt.toHexString)
    assertEquals("9f28fdf4", 0x9f28fdf4.toUInt.toHexString)
    assertEquals("e5525120", 0xe5525120.toUInt.toHexString)
    assertEquals("38f3400f", 0x38f3400f.toUInt.toHexString)
    assertEquals("f921ba33", 0xf921ba33.toUInt.toHexString)
    assertEquals("6245ae0a", 0x6245ae0a.toUInt.toHexString)
    assertEquals("71e644", 0x71e644.toUInt.toHexString)
    assertEquals("f829e5dc", 0xf829e5dc.toUInt.toHexString)
  }

  @Test def uintToOctalString() = {
    assertEquals("35700705040", 0xef038a20.toUInt.toOctalString)
    assertEquals("25630737642", 0xae63bfa2.toUInt.toOctalString)
    assertEquals("26733473624", 0xb76e7794.toUInt.toOctalString)
    assertEquals("14526772357", 0x655bf4ef.toUInt.toOctalString)
    assertEquals("7545576655", 0x3d96fdad.toUInt.toOctalString)
    assertEquals("22770751114", 0x97e3d24c.toUInt.toOctalString)
    assertEquals("12270122710", 0x52e0a5c8.toUInt.toOctalString)
    assertEquals("12161000320", 0x51c400d0.toUInt.toOctalString)
    assertEquals("11543124525", 0x4d8ca955.toUInt.toOctalString)
    assertEquals("31572225767", 0xcde92bf7.toUInt.toOctalString)
  }
}
