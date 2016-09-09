package scala

class UByte(val underlying: Byte) extends AnyVal
class UShort(val underlying: Short) extends AnyVal
class UInt(val underlying: Int) extends AnyVal

class ULong(val underlying: Long) extends AnyVal {
  final def toDouble: Double =
    if (underlying >= 0) underlying.toDouble
    else 18446744073709551616.0 - underlying.toDouble // TODO Verify precision
}
