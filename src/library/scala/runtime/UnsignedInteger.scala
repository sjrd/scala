/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2006-2015, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    http://scala-lang.org/               **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */



package scala.runtime

/** Marker trait for primitive unsigned integer types.
 *
 *  You should not extend this trait in user code.
 */
trait UnsignedInteger extends Any {
  def toByte: Byte
  def toShort: Short
  def toInt: Int
  def toLong: Long
  def toFloat: Float
  def toDouble: Double

  def toUByte: UByte
  def toUShort: UShort
  def toUInt: UInt
  def toULong: ULong
}
