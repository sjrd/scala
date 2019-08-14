/*
 * Scala (https://www.scala-lang.org)
 *
 * Copyright EPFL and Lightbend, Inc.
 *
 * Licensed under Apache License 2.0
 * (http://www.apache.org/licenses/LICENSE-2.0).
 *
 * See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 */

package scala
package runtime

final class RichDouble(val self: Double) extends AnyVal {
  /** `'''true'''` if this number has no decimal component, `'''false'''` otherwise. */
  def isWhole: Boolean = {
    val l = self.toLong
    l.toDouble == self || l == Long.MaxValue && self < Double.PositiveInfinity || l == Long.MinValue && self > Double.NegativeInfinity
  }

  @deprecated("use the method available on Double itself", "2.14.0")
  def toChar: Char = self.toChar
  @deprecated("use the method available on Double itself", "2.14.0")
  def toByte: Byte = self.toByte
  @deprecated("use the method available on Double itself", "2.14.0")
  def toShort: Short = self.toShort
  @deprecated("use the method available on Double itself", "2.14.0")
  def toInt: Int = self.toInt
  @deprecated("use the method available on Double itself", "2.14.0")
  def toLong: Long = self.toLong
  @deprecated("use the method available on Double itself", "2.14.0")
  def toFloat: Float = self.toFloat
  @deprecated("use the method available on Double itself", "2.14.0")
  def toDouble: Double = self.toDouble

  @deprecated("use toByte instead", "2.14.0")
  def byteValue: Byte = self.toByte
  @deprecated("use toShort instead", "2.14.0")
  def shortValue: Short = self.toShort
  @deprecated("use toInt instead", "2.14.0")
  def intValue: Int = self.toInt
  @deprecated("use toLong instead", "2.14.0")
  def longValue: Long = self.toLong
  @deprecated("use toFloat instead", "2.14.0")
  def floatValue: Float = self.toFloat
  @deprecated("statically known to be an identity", "2.14.0")
  def doubleValue: Double = self

  /** Returns `true` iff this has a zero fractional part, and is within the
    * range of [[scala.Byte]] MinValue and MaxValue; otherwise returns `false`.
    */
  def isValidByte: Boolean = self.toByte.toDouble == self

  /** Returns `true` iff this has a zero fractional part, and is within the
    * range of [[scala.Short]] MinValue and MaxValue; otherwise returns `false`.
    */
  def isValidShort: Boolean = self.toShort.toDouble == self

  /** Returns `true` iff this has a zero fractional part, and is within the
    * range of [[scala.Int]] MinValue and MaxValue; otherwise returns `false`.
    */
  def isValidInt: Boolean = self.toInt.toDouble == self

  /** Returns `true` iff this has a zero fractional part, and is within the
    * range of [[scala.Char]] MinValue and MaxValue; otherwise returns `false`.
    */
  def isValidChar: Boolean = self.toChar.toDouble == self

  def isNaN: Boolean         = java.lang.Double.isNaN(self)
  def isInfinity: Boolean    = java.lang.Double.isInfinite(self)
  def isFinite: Boolean      = java.lang.Double.isFinite(self)
  def isPosInfinity: Boolean = Double.PositiveInfinity == self
  def isNegInfinity: Boolean = Double.NegativeInfinity == self

  /** Result of comparing `this` with operand `that`.
   *
   *  Returns `x` where:
   *
   *  - `x < 0` when `this < that`
   *  - `x == 0` when `this == that`
   *  - `x > 0` when  `this > that`
   *
   *  For the purposes of this method, `NaN` is considered equal to itself and
   *  greater than all other values. `-0.0` is considered less than `+0.0`.
   */
  def compare(y: Double): Int = java.lang.Double.compare(self, y)

  /** Returns `'''this'''` if `'''this''' < that` or `that` otherwise. */
  def min(that: Double): Double = Math.min(self, that)

  /** Returns `'''this'''` if `'''this''' > that` or `that` otherwise. */
  def max(that: Double): Double = Math.max(self, that)

  /** Returns the absolute value of `'''this'''`. */
  def abs: Double = Math.abs(self)

  /**
   * Returns the sign of `'''this'''`.
   * zero if the argument is zero, -zero if the argument is -zero,
   * one if the argument is greater than zero, -one if the argument is less than zero,
   * and NaN if the argument is NaN where applicable.
   */
  def sign: Double = Math.signum(self)

  /** Returns the signum of `'''this'''`. */
  @deprecated("signum does not handle -0.0 or Double.NaN; use `sign` method instead", since = "2.13.0")
  def signum: Int = sign.toInt

  def round: Long = Math.round(self)
  def ceil: Double = Math.ceil(self)
  def floor: Double = Math.floor(self)

  /** Converts an angle measured in degrees to an approximately equivalent
   *  angle measured in radians.
   *
   *  @return the measurement of the angle x in radians.
   */
  def toRadians: Double = math.toRadians(self)

  /** Converts an angle measured in radians to an approximately equivalent
   *  angle measured in degrees.
   *  @return the measurement of the angle x in degrees.
   */
  def toDegrees: Double = math.toDegrees(self)

  override def toString(): String = java.lang.Double.toString(self)
}
