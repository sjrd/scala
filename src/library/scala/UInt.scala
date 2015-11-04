/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2002-2013, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    http://scala-lang.org/               **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */

package scala

import java.lang.{Integer => JInteger}

/** `UInt`, a 32-bit unsigned integer.
 */
final class UInt private[scala] (private val underlying: Int) extends AnyVal
    with java.io.Serializable with Comparable[UInt]
    with scala.runtime.UnsignedInteger {

  def toByte: Byte = underlying.toByte
  def toShort: Short = underlying.toShort
  def toChar: Char = underlying.toChar
  def toInt: Int = underlying
  def toLong: Long = JInteger.toUnsignedLong(underlying)
  def toFloat: Float = toLong.toFloat
  def toDouble: Double = toLong.toDouble

  def toUByte: UByte = new UByte(toByte)
  def toUShort: UShort = new UShort(toShort)
  def toUInt: UInt = this
  def toULong: ULong = new ULong(toLong)

  /**
   * Returns the bitwise negation of this value.
   * @example {{{
   * ~5 == 4294967290
   * // in binary: ~00000101 ==
   * //             11111010
   * }}}
   */
  def unary_~ : UInt = new UInt(~underlying)

  /**
   * Returns this value bit-shifted left by the specified number of bits,
   *         filling in the new right bits with zeroes.
   * @example {{{ 6 << 3 == 48 // in binary: 0110 << 3 == 0110000 }}}
   */
  def <<(x: Int): UInt = new UInt(underlying << x)
  /**
   * Returns this value bit-shifted left by the specified number of bits,
   *         filling in the new right bits with zeroes.
   * @example {{{ 6 << 3 == 48 // in binary: 0110 << 3 == 0110000 }}}
   */
  def <<(x: Long): UInt = new UInt(underlying << x)
  /**
   * Returns this value bit-shifted right by the specified number of bits,
   *         filling the new left bits with zeroes.
   * @example {{{ 21 >>> 3 == 2 // in binary: 010101 >>> 3 == 010 }}}
   * @example {{{
   * 4294967275 >>> 3 == 536870909
   * // in binary: 11111111 11111111 11111111 11101011 >>> 3 ==
   * //            00011111 11111111 11111111 11111101
   * }}}
   */
  def >>>(x: Int): UInt = new UInt(underlying >>> x)
  /**
   * Returns this value bit-shifted right by the specified number of bits,
   *         filling the new left bits with zeroes.
   * @example {{{ 21 >>> 3 == 2 // in binary: 010101 >>> 3 == 010 }}}
   * @example {{{
   * 4294967275 >>> 3 == 536870909
   * // in binary: 11111111 11111111 11111111 11101011 >>> 3 ==
   * //            00011111 11111111 11111111 11111101
   * }}}
   */
  def >>>(x: Long): UInt = new UInt(underlying >>> x)
  /**
   * Returns this value bit-shifted left by the specified number of bits,
   *         filling in the right bits with the same value as the left-most bit of this.
   * @example {{{
   * 4294967275 >> 3 == 4294967293
   * // in binary: 11111111 11111111 11111111 11101011 >> 3 ==
   * //            11111111 11111111 11111111 11111101
   * }}}
   */
  def >>(x: Int): UInt = new UInt(underlying >> x)
  /**
   * Returns this value bit-shifted left by the specified number of bits,
   *         filling in the right bits with the same value as the left-most bit of this.
   * @example {{{
   * 4294967275 >> 3 == 4294967293
   * // in binary: 11111111 11111111 11111111 11101011 >> 3 ==
   * //            11111111 11111111 11111111 11111101
   * }}}
   */
  def >>(x: Long): UInt = new UInt(underlying >> x)

  override def compareTo(x: UInt): Int =
    JInteger.compareUnsigned(underlying, x.underlying)

  /** Returns `true` if this value is equal to x, `false` otherwise. */
  def ==(x: UByte): Boolean = this == x.toUInt
  /** Returns `true` if this value is equal to x, `false` otherwise. */
  def ==(x: UShort): Boolean = this == x.toUInt
  /** Returns `true` if this value is equal to x, `false` otherwise. */
  def ==(x: UInt): Boolean = underlying == x.underlying
  /** Returns `true` if this value is equal to x, `false` otherwise. */
  def ==(x: ULong): Boolean = this.toULong == x

  /** Returns `true` if this value is not equal to x, `false` otherwise. */
  def !=(x: UByte): Boolean = this != x.toUInt
  /** Returns `true` if this value is not equal to x, `false` otherwise. */
  def !=(x: UShort): Boolean = this != x.toUInt
  /** Returns `true` if this value is not equal to x, `false` otherwise. */
  def !=(x: UInt): Boolean = underlying != x.underlying
  /** Returns `true` if this value is not equal to x, `false` otherwise. */
  def !=(x: ULong): Boolean = this.toULong != x

  /** Returns `true` if this value is less than x, `false` otherwise. */
  def <(x: UByte): Boolean = this < x.toUInt
  /** Returns `true` if this value is less than x, `false` otherwise. */
  def <(x: UShort): Boolean = this < x.toUInt
  /** Returns `true` if this value is less than x, `false` otherwise. */
  def <(x: UInt): Boolean = compareTo(x) < 0
  /** Returns `true` if this value is less than x, `false` otherwise. */
  def <(x: ULong): Boolean = this.toULong < x

  /** Returns `true` if this value is less than or equal to x, `false` otherwise. */
  def <=(x: UByte): Boolean = this <= x.toUInt
  /** Returns `true` if this value is less than or equal to x, `false` otherwise. */
  def <=(x: UShort): Boolean = this <= x.toUInt
  /** Returns `true` if this value is less than or equal to x, `false` otherwise. */
  def <=(x: UInt): Boolean = compareTo(x) <= 0
  /** Returns `true` if this value is less than or equal to x, `false` otherwise. */
  def <=(x: ULong): Boolean = this.toULong <= x

  /** Returns `true` if this value is greater than x, `false` otherwise. */
  def >(x: UByte): Boolean = this > x.toUInt
  /** Returns `true` if this value is greater than x, `false` otherwise. */
  def >(x: UShort): Boolean = this > x.toUInt
  /** Returns `true` if this value is greater than x, `false` otherwise. */
  def >(x: UInt): Boolean = compareTo(x) > 0
  /** Returns `true` if this value is greater than x, `false` otherwise. */
  def >(x: ULong): Boolean = this.toULong > x

  /** Returns `true` if this value is greater than or equal to x, `false` otherwise. */
  def >=(x: UByte): Boolean = this >= x.toUInt
  /** Returns `true` if this value is greater than or equal to x, `false` otherwise. */
  def >=(x: UShort): Boolean = this >= x.toUInt
  /** Returns `true` if this value is greater than or equal to x, `false` otherwise. */
  def >=(x: UInt): Boolean = compareTo(x) >= 0
  /** Returns `true` if this value is greater than or equal to x, `false` otherwise. */
  def >=(x: ULong): Boolean = this.toULong >= x

  /** Returns the bitwise OR of this value and `x`. */
  def |(x: UByte): UInt = this | x.toUInt
  /** Returns the bitwise OR of this value and `x`. */
  def |(x: UShort): UInt = this | x.toUInt
  /** Returns the bitwise OR of this value and `x`. */
  def |(x: UInt): UInt = new UInt(underlying | x.underlying)
  /** Returns the bitwise OR of this value and `x`. */
  def |(x: ULong): ULong = this.toULong | x

  /** Returns the bitwise AND of this value and `x`. */
  def &(x: UByte): UInt = this & x.toUInt
  /** Returns the bitwise AND of this value and `x`. */
  def &(x: UShort): UInt = this & x.toUInt
  /** Returns the bitwise AND of this value and `x`. */
  def &(x: UInt): UInt = new UInt(underlying & x.underlying)
  /** Returns the bitwise AND of this value and `x`. */
  def &(x: ULong): ULong = this.toULong & x

  /** Returns the bitwise XOR of this value and `x`. */
  def ^(x: UByte): UInt = this ^ x.toUInt
  /** Returns the bitwise XOR of this value and `x`. */
  def ^(x: UShort): UInt = this ^ x.toUInt
  /** Returns the bitwise XOR of this value and `x`. */
  def ^(x: UInt): UInt = new UInt(underlying ^ x.underlying)
  /** Returns the bitwise XOR of this value and `x`. */
  def ^(x: ULong): ULong = this.toULong ^ x

  /** Returns the sum of this value and `x`. */
  def +(x: UByte): UInt = this + x.toUInt
  /** Returns the sum of this value and `x`. */
  def +(x: UShort): UInt = this + x.toUInt
  /** Returns the sum of this value and `x`. */
  def +(x: UInt): UInt = new UInt(underlying + x.underlying)
  /** Returns the sum of this value and `x`. */
  def +(x: ULong): ULong = this.toULong + x

  /** Returns the difference of this value and `x`. */
  def -(x: UByte): UInt = this - x.toUInt
  /** Returns the difference of this value and `x`. */
  def -(x: UShort): UInt = this - x.toUInt
  /** Returns the difference of this value and `x`. */
  def -(x: UInt): UInt = new UInt(underlying - x.underlying)
  /** Returns the difference of this value and `x`. */
  def -(x: ULong): ULong = this.toULong - x

  /** Returns the product of this value and `x`. */
  def *(x: UByte): UInt = this * x.toUInt
  /** Returns the product of this value and `x`. */
  def *(x: UShort): UInt = this * x.toUInt
  /** Returns the product of this value and `x`. */
  def *(x: UInt): UInt = new UInt(underlying * x.underlying)
  /** Returns the product of this value and `x`. */
  def *(x: ULong): ULong = this.toULong * x

  /** Returns the quotient of this value and `x`. */
  def /(x: UByte): UInt = this / x.toUInt
  /** Returns the quotient of this value and `x`. */
  def /(x: UShort): UInt = this / x.toUInt
  /** Returns the quotient of this value and `x`. */
  def /(x: UInt): UInt = new UInt(JInteger.divideUnsigned(underlying, x.underlying))
  /** Returns the quotient of this value and `x`. */
  def /(x: ULong): ULong = this.toULong / x

  /** Returns the remainder of the division of this value by `x`. */
  def %(x: UByte): UInt = this % x.toUInt
  /** Returns the remainder of the division of this value by `x`. */
  def %(x: UShort): UInt = this % x.toUInt
  /** Returns the remainder of the division of this value by `x`. */
  def %(x: UInt): UInt = new UInt(JInteger.remainderUnsigned(underlying, x.underlying))
  /** Returns the remainder of the division of this value by `x`. */
  def %(x: ULong): ULong = this.toULong % x

  override def toString(): String = JInteger.toUnsignedString(underlying)

  // "Rich" API

  def max(that: UInt): UInt = math.max(this, that)
  def min(that: UInt): UInt = math.min(this, that)

  def toBinaryString: String = toInt.toBinaryString
  def toHexString: String = toInt.toHexString
  def toOctalString: String = toInt.toOctalString
}

object UInt {
  /** The smallest value representable as a UInt. */
  final val MinValue = new UInt(0)

  /** The largest value representable as a UInt. */
  final val MaxValue = new UInt(-1)

  /** The String representation of the scala.UInt companion object. */
  override def toString(): String = "object scala.UInt"

  /** Language mandated coercions from UInt to "wider" types. */
  import scala.language.implicitConversions
  implicit def uint2ulong(x: UInt): ULong = x.toULong
}