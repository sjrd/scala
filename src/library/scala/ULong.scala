/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2002-2013, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    http://scala-lang.org/               **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */

package scala

import java.lang.{Long => JLong}

/** `ULong`, a 64-bit unsigned integer.
 */
final class ULong private[scala] (private val underlying: Long) extends AnyVal
    with java.io.Serializable with Comparable[ULong] {

  def toByte: Byte = underlying.toByte
  def toShort: Short = underlying.toShort
  def toChar: Char = underlying.toChar
  def toInt: Int = underlying.toInt
  def toLong: Long = underlying
  def toFloat: Float = toDouble.toFloat
  def toDouble: Double =
    if (underlying >= 0) underlying.toDouble
    else 18446744073709551616.0 - underlying.toDouble // TODO Verify precision

  def toUByte: UByte = new UByte(toByte)
  def toUShort: UShort = new UShort(toShort)
  def toUInt: UInt = new UInt(toInt)
  def toULong: ULong = this

  /**
   * Returns the bitwise negation of this value.
   */
  def unary_~ : ULong = new ULong(~underlying)

  /**
   * Returns this value bit-shifted left by the specified number of bits,
   *         filling in the new right bits with zeroes.
   * @example {{{ 6 << 3 == 48 // in binary: 0110 << 3 == 0110000 }}}
   */
  def <<(x: Int): ULong = new ULong(underlying << x)
  /**
   * Returns this value bit-shifted left by the specified number of bits,
   *         filling in the new right bits with zeroes.
   * @example {{{ 6 << 3 == 48 // in binary: 0110 << 3 == 0110000 }}}
   */
  def <<(x: Long): ULong = new ULong(underlying << x)
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
  def >>>(x: Int): ULong = new ULong(underlying >>> x)
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
  def >>>(x: Long): ULong = new ULong(underlying >>> x)
  /**
   * Returns this value bit-shifted left by the specified number of bits,
   *         filling in the right bits with the same value as the left-most bit of this.
   * @example {{{
   * 4294967275 >> 3 == 4294967293
   * // in binary: 11111111 11111111 11111111 11101011 >> 3 ==
   * //            11111111 11111111 11111111 11111101
   * }}}
   */
  def >>(x: Int): ULong = new ULong(underlying >> x)
  /**
   * Returns this value bit-shifted left by the specified number of bits,
   *         filling in the right bits with the same value as the left-most bit of this.
   * @example {{{
   * 4294967275 >> 3 == 4294967293
   * // in binary: 11111111 11111111 11111111 11101011 >> 3 ==
   * //            11111111 11111111 11111111 11111101
   * }}}
   */
  def >>(x: Long): ULong = new ULong(underlying >> x)

  override def compareTo(x: ULong): Int =
    JLong.compareUnsigned(underlying, x.underlying)

  /** Returns `true` if this value is equal to x, `false` otherwise. */
  def ==(x: UByte): Boolean = this == x.toULong
  /** Returns `true` if this value is equal to x, `false` otherwise. */
  def ==(x: UShort): Boolean = this == x.toULong
  /** Returns `true` if this value is equal to x, `false` otherwise. */
  def ==(x: UInt): Boolean = this == x.toULong
  /** Returns `true` if this value is equal to x, `false` otherwise. */
  def ==(x: ULong): Boolean = underlying == x.underlying

  /** Returns `true` if this value is not equal to x, `false` otherwise. */
  def !=(x: UByte): Boolean = this != x.toULong
  /** Returns `true` if this value is not equal to x, `false` otherwise. */
  def !=(x: UShort): Boolean = this != x.toULong
  /** Returns `true` if this value is not equal to x, `false` otherwise. */
  def !=(x: UInt): Boolean = this != x.toULong
  /** Returns `true` if this value is not equal to x, `false` otherwise. */
  def !=(x: ULong): Boolean = underlying != x.underlying

  /** Returns `true` if this value is less than x, `false` otherwise. */
  def <(x: UByte): Boolean = this < x.toULong
  /** Returns `true` if this value is less than x, `false` otherwise. */
  def <(x: UShort): Boolean = this < x.toULong
  /** Returns `true` if this value is less than x, `false` otherwise. */
  def <(x: UInt): Boolean = this < x.toULong
  /** Returns `true` if this value is less than x, `false` otherwise. */
  def <(x: ULong): Boolean = compareTo(x) < 0

  /** Returns `true` if this value is less than or equal to x, `false` otherwise. */
  def <=(x: UByte): Boolean = this <= x.toULong
  /** Returns `true` if this value is less than or equal to x, `false` otherwise. */
  def <=(x: UShort): Boolean = this <= x.toULong
  /** Returns `true` if this value is less than or equal to x, `false` otherwise. */
  def <=(x: UInt): Boolean = this <= x.toULong
  /** Returns `true` if this value is less than or equal to x, `false` otherwise. */
  def <=(x: ULong): Boolean = compareTo(x) <= 0

  /** Returns `true` if this value is greater than x, `false` otherwise. */
  def >(x: UByte): Boolean = this > x.toULong
  /** Returns `true` if this value is greater than x, `false` otherwise. */
  def >(x: UShort): Boolean = this > x.toULong
  /** Returns `true` if this value is greater than x, `false` otherwise. */
  def >(x: UInt): Boolean = this > x.toULong
  /** Returns `true` if this value is greater than x, `false` otherwise. */
  def >(x: ULong): Boolean = compareTo(x) > 0

  /** Returns `true` if this value is greater than or equal to x, `false` otherwise. */
  def >=(x: UByte): Boolean = this >= x.toULong
  /** Returns `true` if this value is greater than or equal to x, `false` otherwise. */
  def >=(x: UShort): Boolean = this >= x.toULong
  /** Returns `true` if this value is greater than or equal to x, `false` otherwise. */
  def >=(x: UInt): Boolean = this >= x.toULong
  /** Returns `true` if this value is greater than or equal to x, `false` otherwise. */
  def >=(x: ULong): Boolean = compareTo(x) >= 0

  /** * Returns the bitwise OR of this value and `x`. */
  def |(x: UByte): ULong = this | x.toULong
  /** * Returns the bitwise OR of this value and `x`. */
  def |(x: UShort): ULong = this | x.toULong
  /** * Returns the bitwise OR of this value and `x`. */
  def |(x: UInt): ULong = this | x.toULong
  /** * Returns the bitwise OR of this value and `x`. */
  def |(x: ULong): ULong = new ULong(underlying | x.underlying)

  /** * Returns the bitwise AND of this value and `x`. */
  def &(x: UByte): ULong = this & x.toULong
  /** * Returns the bitwise AND of this value and `x`. */
  def &(x: UShort): ULong = this & x.toULong
  /** * Returns the bitwise AND of this value and `x`. */
  def &(x: UInt): ULong = this & x.toULong
  /** * Returns the bitwise AND of this value and `x`. */
  def &(x: ULong): ULong = new ULong(underlying & x.underlying)

  /** * Returns the bitwise XOR of this value and `x`. */
  def ^(x: UByte): ULong = this ^ x.toULong
  /** * Returns the bitwise XOR of this value and `x`. */
  def ^(x: UShort): ULong = this ^ x.toULong
  /** * Returns the bitwise XOR of this value and `x`. */
  def ^(x: UInt): ULong = this ^ x.toULong
  /** * Returns the bitwise XOR of this value and `x`. */
  def ^(x: ULong): ULong = new ULong(underlying & x.underlying)

  /** Returns the sum of this value and `x`. */
  def +(x: UByte): ULong = this + x.toULong
  /** Returns the sum of this value and `x`. */
  def +(x: UShort): ULong = this + x.toULong
  /** Returns the sum of this value and `x`. */
  def +(x: UInt): ULong = this + x.toULong
  /** Returns the sum of this value and `x`. */
  def +(x: ULong): ULong = new ULong(underlying + x.underlying)

  /** Returns the difference of this value and `x`. */
  def -(x: UByte): ULong = this - x.toULong
  /** Returns the difference of this value and `x`. */
  def -(x: UShort): ULong = this - x.toULong
  /** Returns the difference of this value and `x`. */
  def -(x: UInt): ULong = this - x.toULong
  /** Returns the difference of this value and `x`. */
  def -(x: ULong): ULong = new ULong(underlying - x.underlying)

  /** Returns the product of this value and `x`. */
  def *(x: UByte): ULong = this * x.toULong
  /** Returns the product of this value and `x`. */
  def *(x: UShort): ULong = this * x.toULong
  /** Returns the product of this value and `x`. */
  def *(x: UInt): ULong = this * x.toULong
  /** Returns the product of this value and `x`. */
  def *(x: ULong): ULong = new ULong(underlying * x.underlying)

  /** Returns the quotient of this value and `x`. */
  def /(x: UByte): ULong = this / x.toULong
  /** Returns the quotient of this value and `x`. */
  def /(x: UShort): ULong = this / x.toULong
  /** Returns the quotient of this value and `x`. */
  def /(x: UInt): ULong = this / x.toULong
  /** Returns the quotient of this value and `x`. */
  def /(x: ULong): ULong = new ULong(JLong.divideUnsigned(underlying, x.underlying))

  /** Returns the remainder of the division of this value by `x`. */
  def %(x: UByte): ULong = this % x.toULong
  /** Returns the remainder of the division of this value by `x`. */
  def %(x: UShort): ULong = this % x.toULong
  /** Returns the remainder of the division of this value by `x`. */
  def %(x: UInt): ULong = this % x.toULong
  /** Returns the remainder of the division of this value by `x`. */
  def %(x: ULong): ULong = new ULong(JLong.remainderUnsigned(underlying, x.underlying))

  override def toString(): String = JLong.toUnsignedString(underlying)

  // "Rich" API

  def max(that: ULong): ULong = math.max(this, that)
  def min(that: ULong): ULong = math.min(this, that)

  def toBinaryString: String = toLong.toBinaryString
  def toHexString: String = toLong.toHexString
  def toOctalString: String = toLong.toOctalString
}

object ULong {
  /** The smallest value representable as a ULong. */
  final val MinValue = new ULong(0L)

  /** The largest value representable as a ULong. */
  final val MaxValue = new ULong(-1L)

  /** The String representation of the scala.ULong companion object. */
  override def toString(): String = "object scala.ULong"
}
