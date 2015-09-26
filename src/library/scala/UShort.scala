/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2002-2013, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    http://scala-lang.org/               **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */

package scala

/** `UShort`, a 16-bit unsigned integer.
 */
final class UShort private[scala] (private val underlying: Short) extends AnyVal
    with java.io.Serializable with Comparable[UShort] {

  def toByte: Byte = underlying.toByte
  def toShort: Short = underlying
  def toChar: Char = underlying.toChar
  def toInt: Int = underlying & 0xffff
  def toLong: Long = toInt.toLong
  def toFloat: Float = toInt.toFloat
  def toDouble: Double = toInt.toDouble

  def toUByte: UByte = new UByte(toByte)
  def toUShort: UShort = this
  def toUInt: UInt = new UInt(toInt)
  def toULong: ULong = new ULong(toLong)

  /**
   * Returns the bitwise negation of this value.
   * @example {{{
   * ~5 == -6
   * // in binary: ~00000101 ==
   * //             11111010
   * }}}
   */
  def unary_~ : UInt = ~toUInt

  /**
   * Returns this value bit-shifted left by the specified number of bits,
   *         filling in the new right bits with zeroes.
   * @example {{{ 6 << 3 == 48 // in binary: 0110 << 3 == 0110000 }}}
   */
  def <<(x: Int): UInt = toUInt << x
  /**
   * Returns this value bit-shifted left by the specified number of bits,
   *         filling in the new right bits with zeroes.
   * @example {{{ 6 << 3 == 48 // in binary: 0110 << 3 == 0110000 }}}
   */
  def <<(x: Long): UInt = toUInt << x
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
  def >>>(x: Int): UInt = toUInt >>> x
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
  def >>>(x: Long): UInt = toUInt >>> x
  /**
   * Returns this value bit-shifted left by the specified number of bits,
   *         filling in the right bits with the same value as the left-most bit of this.
   * @example {{{
   * 4294967275 >> 3 == 4294967293
   * // in binary: 11111111 11111111 11111111 11101011 >> 3 ==
   * //            11111111 11111111 11111111 11111101
   * }}}
   */
  def >>(x: Int): UInt = toUInt >> x
  /**
   * Returns this value bit-shifted left by the specified number of bits,
   *         filling in the right bits with the same value as the left-most bit of this.
   * @example {{{
   * 4294967275 >> 3 == 4294967293
   * // in binary: 11111111 11111111 11111111 11101011 >> 3 ==
   * //            11111111 11111111 11111111 11111101
   * }}}
   */
  def >>(x: Long): UInt = toUInt >> x

  override def compareTo(x: UShort): Int =
    (underlying & 0xffff) - (x.underlying & 0xffff)

  /** Returns `true` if this value is equal to x, `false` otherwise. */
  def ==(x: UByte): Boolean = toUInt == x.toUInt
  /** Returns `true` if this value is equal to x, `false` otherwise. */
  def ==(x: UShort): Boolean = underlying == x.underlying
  /** Returns `true` if this value is equal to x, `false` otherwise. */
  def ==(x: UInt): Boolean = toUInt == x
  /** Returns `true` if this value is equal to x, `false` otherwise. */
  def ==(x: ULong): Boolean = toULong == x

  /** Returns `true` if this value is not equal to x, `false` otherwise. */
  def !=(x: UByte): Boolean = toUInt != x.toUInt
  /** Returns `true` if this value is not equal to x, `false` otherwise. */
  def !=(x: UShort): Boolean = underlying != x.underlying
  /** Returns `true` if this value is not equal to x, `false` otherwise. */
  def !=(x: UInt): Boolean = toUInt != x
  /** Returns `true` if this value is not equal to x, `false` otherwise. */
  def !=(x: ULong): Boolean = toULong != x

  /** Returns `true` if this value is less than x, `false` otherwise. */
  def <(x: UByte): Boolean = toUInt < x.toUInt
  /** Returns `true` if this value is less than x, `false` otherwise. */
  def <(x: UShort): Boolean = toUInt < x.toUInt
  /** Returns `true` if this value is less than x, `false` otherwise. */
  def <(x: UInt): Boolean = toUInt < x
  /** Returns `true` if this value is less than x, `false` otherwise. */
  def <(x: ULong): Boolean = toULong < x

  /** Returns `true` if this value is less than or equal to x, `false` otherwise. */
  def <=(x: UByte): Boolean = toUInt <= x.toUInt
  /** Returns `true` if this value is less than or equal to x, `false` otherwise. */
  def <=(x: UShort): Boolean = toUInt <= x.toUInt
  /** Returns `true` if this value is less than or equal to x, `false` otherwise. */
  def <=(x: UInt): Boolean = toUInt <= x
  /** Returns `true` if this value is less than or equal to x, `false` otherwise. */
  def <=(x: ULong): Boolean = toULong <= x

  /** Returns `true` if this value is greater than x, `false` otherwise. */
  def >(x: UByte): Boolean = toUInt > x.toUInt
  /** Returns `true` if this value is greater than x, `false` otherwise. */
  def >(x: UShort): Boolean = toUInt > x.toUInt
  /** Returns `true` if this value is greater than x, `false` otherwise. */
  def >(x: UInt): Boolean = toUInt > x
  /** Returns `true` if this value is greater than x, `false` otherwise. */
  def >(x: ULong): Boolean = toULong > x

  /** Returns `true` if this value is greater than or equal to x, `false` otherwise. */
  def >=(x: UByte): Boolean = toUInt >= x.toUInt
  /** Returns `true` if this value is greater than or equal to x, `false` otherwise. */
  def >=(x: UShort): Boolean = toUInt >= x.toUInt
  /** Returns `true` if this value is greater than or equal to x, `false` otherwise. */
  def >=(x: UInt): Boolean = toUInt >= x
  /** Returns `true` if this value is greater than or equal to x, `false` otherwise. */
  def >=(x: ULong): Boolean = toULong >= x

  /** Returns the bitwise OR of this value and `x`. */
  def |(x: UByte): UInt = this.toUInt | x.toUInt
  /** Returns the bitwise OR of this value and `x`. */
  def |(x: UShort): UInt = this.toUInt | x.toUInt
  /** Returns the bitwise OR of this value and `x`. */
  def |(x: UInt): UInt = this.toUInt | x
  /** Returns the bitwise OR of this value and `x`. */
  def |(x: ULong): ULong = this.toULong | x

  /** Returns the bitwise AND of this value and `x`. */
  def &(x: UByte): UInt = this.toUInt & x.toUInt
  /** Returns the bitwise AND of this value and `x`. */
  def &(x: UShort): UInt = this.toUInt & x.toUInt
  /** Returns the bitwise AND of this value and `x`. */
  def &(x: UInt): UInt = this.toUInt & x
  /** Returns the bitwise AND of this value and `x`. */
  def &(x: ULong): ULong = this.toULong & x

  /** Returns the bitwise XOR of this value and `x`. */
  def ^(x: UByte): UInt = this.toUInt ^ x.toUInt
  /** Returns the bitwise XOR of this value and `x`. */
  def ^(x: UShort): UInt = this.toUInt ^ x.toUInt
  /** Returns the bitwise XOR of this value and `x`. */
  def ^(x: UInt): UInt = this.toUInt ^ x
  /** Returns the bitwise XOR of this value and `x`. */
  def ^(x: ULong): ULong = this.toULong ^ x

  /** Returns the sum of this value and `x`. */
  def +(x: UByte): UInt = this.toUInt + x.toUInt
  /** Returns the sum of this value and `x`. */
  def +(x: UShort): UInt = this.toUInt + x.toUInt
  /** Returns the sum of this value and `x`. */
  def +(x: UInt): UInt = this.toUInt + x
  /** Returns the sum of this value and `x`. */
  def +(x: ULong): ULong = this.toULong + x

  /** Returns the difference of this value and `x`. */
  def -(x: UByte): UInt = this.toUInt - x.toUInt
  /** Returns the difference of this value and `x`. */
  def -(x: UShort): UInt = this.toUInt - x.toUInt
  /** Returns the difference of this value and `x`. */
  def -(x: UInt): UInt = this.toUInt - x
  /** Returns the difference of this value and `x`. */
  def -(x: ULong): ULong = this.toULong - x

  /** Returns the product of this value and `x`. */
  def *(x: UByte): UInt = this.toUInt * x.toUInt
  /** Returns the product of this value and `x`. */
  def *(x: UShort): UInt = this.toUInt * x.toUInt
  /** Returns the product of this value and `x`. */
  def *(x: UInt): UInt = this.toUInt * x
  /** Returns the product of this value and `x`. */
  def *(x: ULong): ULong = this.toULong * x

  /** Returns the quotient of this value and `x`. */
  def /(x: UByte): UInt = this.toUInt / x.toUInt
  /** Returns the quotient of this value and `x`. */
  def /(x: UShort): UInt = this.toUInt / x.toUInt
  /** Returns the quotient of this value and `x`. */
  def /(x: UInt): UInt = this.toUInt / x
  /** Returns the quotient of this value and `x`. */
  def /(x: ULong): ULong = this.toULong / x

  /** Returns the remainder of the division of this value by `x`. */
  def %(x: UByte): UInt = this.toUInt % x.toUInt
  /** Returns the remainder of the division of this value by `x`. */
  def %(x: UShort): UInt = this.toUInt % x.toUInt
  /** Returns the remainder of the division of this value by `x`. */
  def %(x: UInt): UInt = this.toUInt % x
  /** Returns the remainder of the division of this value by `x`. */
  def %(x: ULong): ULong = this.toULong % x

  override def toString(): String = toInt.toString()

  // "Rich" API

  def max(that: UShort): UShort = math.max(this.toUInt, that.toUInt).toUShort
  def min(that: UShort): UShort = math.min(this.toUInt, that.toUInt).toUShort

  def toBinaryString: String = toUInt.toBinaryString
  def toHexString: String = toUInt.toHexString
  def toOctalString: String = toUInt.toOctalString
}

object UShort {
  /** The smallest value representable as a UShort. */
  final val MinValue = new UShort(0.toShort)

  /** The largest value representable as a UShort. */
  final val MaxValue = new UShort((-1).toShort)

  /** The String representation of the scala.UShort companion object. */
  override def toString(): String = "object scala.UShort"

  /** Language mandated coercions from UShort to "wider" types. */
  import scala.language.implicitConversions
  implicit def ubyte2uint(x: UShort): UInt = x.toUInt
  implicit def ubyte2ulong(x: UShort): ULong = x.toULong
}
