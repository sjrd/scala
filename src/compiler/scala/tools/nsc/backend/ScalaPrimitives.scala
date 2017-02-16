/* NSC -- new Scala compiler
 * Copyright 2005-2013 LAMP/EPFL
 * @author  Martin Odersky
 */

package scala
package tools.nsc
package backend

import scala.collection.{ mutable, immutable }

/** Scala primitive operations are represented as methods in `Any` and
 *  `AnyVal` subclasses. Here we demultiplex them by providing a mapping
 *  from their symbols to integers. Different methods exist for
 *  different value types, but with the same meaning (like plus, minus,
 *  etc.). They will all be mapped to the same int.
 *
 *  Note: The three equal methods have the following semantics:
 *  - `"=="` checks for `null`, and if non-null, calls
 *    `java.lang.Object.equals`
 *    `(class: Any; modifier: final)`. Primitive: `EQ`
 *  - `"eq"` usual reference comparison
 *    `(class: AnyRef; modifier: final)`. Primitive: `ID`
 *  - `"equals"` user-defined equality (Java semantics)
 *    `(class: Object; modifier: none)`. Primitive: `EQUALS`
 *
 * Inspired from the `scalac` compiler.
 */
abstract class ScalaPrimitives {
  val global: Global

  import global._
  import definitions._
  import ScalaPrimitives._
  import icodes.{TypeKind, BOOL, SHORT, BYTE, INT, LONG, REFERENCE, CHAR, FLOAT, DOUBLE, ARRAY, toTypeKind}

  private val primitives: mutable.Map[Symbol, Int] = new mutable.HashMap()

  /** Initialize the primitive map */
  def init() {
    import ScalaPrimitives._

    primitives.clear()
    // scala.Any
    addPrimitive(Any_==, EQ)
    addPrimitive(Any_!=, NE)
    addPrimitive(Any_isInstanceOf, IS)
    addPrimitive(Any_asInstanceOf, AS)
    addPrimitive(Any_##, HASH)

    // java.lang.Object
    addPrimitive(Object_eq, ID)
    addPrimitive(Object_ne, NI)
    addPrimitive(Object_==, EQ)
    addPrimitive(Object_!=, NE)
    addPrimitive(Object_synchronized, SYNCHRONIZED)
    addPrimitive(Object_isInstanceOf, IS)
    addPrimitive(Object_asInstanceOf, AS)

    // java.lang.String
    addPrimitive(String_+, CONCAT)

    // scala.Array
    addPrimitives(ArrayClass, nme.length, LENGTH)
    addPrimitives(ArrayClass, nme.apply, APPLY)
    addPrimitives(ArrayClass, nme.update, UPDATE)

    // scala.Boolean
    addPrimitives(BooleanClass, nme.EQ, EQ)
    addPrimitives(BooleanClass, nme.NE, NE)
    addPrimitives(BooleanClass, nme.UNARY_!, ZNOT)
    addPrimitives(BooleanClass, nme.ZOR, ZOR)
    addPrimitives(BooleanClass, nme.ZAND, ZAND)
    addPrimitives(BooleanClass, nme.OR, OR)
    addPrimitives(BooleanClass, nme.AND, AND)
    addPrimitives(BooleanClass, nme.XOR, XOR)

    // scala.Byte
    addPrimitives(ByteClass, nme.EQ, EQ)
    addPrimitives(ByteClass, nme.NE, NE)
    addPrimitives(ByteClass, nme.ADD, ADD)
    addPrimitives(ByteClass, nme.SUB, SUB)
    addPrimitives(ByteClass, nme.MUL, MUL)
    addPrimitives(ByteClass, nme.DIV, DIV)
    addPrimitives(ByteClass, nme.MOD, MOD)
    addPrimitives(ByteClass, nme.LT, LT)
    addPrimitives(ByteClass, nme.LE, LE)
    addPrimitives(ByteClass, nme.GT, GT)
    addPrimitives(ByteClass, nme.GE, GE)
    addPrimitives(ByteClass, nme.XOR, XOR)
    addPrimitives(ByteClass, nme.OR, OR)
    addPrimitives(ByteClass, nme.AND, AND)
    addPrimitives(ByteClass, nme.LSL, LSL)
    addPrimitives(ByteClass, nme.LSR, LSR)
    addPrimitives(ByteClass, nme.ASR, ASR)
      // conversions
    addPrimitives(ByteClass, nme.toByte,   B2B)
    addPrimitives(ByteClass, nme.toShort,  B2S)
    addPrimitives(ByteClass, nme.toChar,   B2C)
    addPrimitives(ByteClass, nme.toInt,    B2I)
    addPrimitives(ByteClass, nme.toLong,   B2L)
    // unary methods
    addPrimitives(ByteClass, nme.UNARY_+, POS)
    addPrimitives(ByteClass, nme.UNARY_-, NEG)
    addPrimitives(ByteClass, nme.UNARY_~, NOT)

    addPrimitives(ByteClass, nme.toFloat,  B2F)
    addPrimitives(ByteClass, nme.toDouble, B2D)

    // scala.Short
    addPrimitives(ShortClass, nme.EQ, EQ)
    addPrimitives(ShortClass, nme.NE, NE)
    addPrimitives(ShortClass, nme.ADD, ADD)
    addPrimitives(ShortClass, nme.SUB, SUB)
    addPrimitives(ShortClass, nme.MUL, MUL)
    addPrimitives(ShortClass, nme.DIV, DIV)
    addPrimitives(ShortClass, nme.MOD, MOD)
    addPrimitives(ShortClass, nme.LT, LT)
    addPrimitives(ShortClass, nme.LE, LE)
    addPrimitives(ShortClass, nme.GT, GT)
    addPrimitives(ShortClass, nme.GE, GE)
    addPrimitives(ShortClass, nme.XOR, XOR)
    addPrimitives(ShortClass, nme.OR, OR)
    addPrimitives(ShortClass, nme.AND, AND)
    addPrimitives(ShortClass, nme.LSL, LSL)
    addPrimitives(ShortClass, nme.LSR, LSR)
    addPrimitives(ShortClass, nme.ASR, ASR)
      // conversions
    addPrimitives(ShortClass, nme.toByte,   S2B)
    addPrimitives(ShortClass, nme.toShort,  S2S)
    addPrimitives(ShortClass, nme.toChar,   S2C)
    addPrimitives(ShortClass, nme.toInt,    S2I)
    addPrimitives(ShortClass, nme.toLong,   S2L)
    // unary methods
    addPrimitives(ShortClass, nme.UNARY_+, POS)
    addPrimitives(ShortClass, nme.UNARY_-, NEG)
    addPrimitives(ShortClass, nme.UNARY_~, NOT)

    addPrimitives(ShortClass, nme.toFloat,  S2F)
    addPrimitives(ShortClass, nme.toDouble, S2D)

    // scala.Char
    addPrimitives(CharClass, nme.EQ, EQ)
    addPrimitives(CharClass, nme.NE, NE)
    addPrimitives(CharClass, nme.ADD, ADD)
    addPrimitives(CharClass, nme.SUB, SUB)
    addPrimitives(CharClass, nme.MUL, MUL)
    addPrimitives(CharClass, nme.DIV, DIV)
    addPrimitives(CharClass, nme.MOD, MOD)
    addPrimitives(CharClass, nme.LT, LT)
    addPrimitives(CharClass, nme.LE, LE)
    addPrimitives(CharClass, nme.GT, GT)
    addPrimitives(CharClass, nme.GE, GE)
    addPrimitives(CharClass, nme.XOR, XOR)
    addPrimitives(CharClass, nme.OR, OR)
    addPrimitives(CharClass, nme.AND, AND)
    addPrimitives(CharClass, nme.LSL, LSL)
    addPrimitives(CharClass, nme.LSR, LSR)
    addPrimitives(CharClass, nme.ASR, ASR)
      // conversions
    addPrimitives(CharClass, nme.toByte,   C2B)
    addPrimitives(CharClass, nme.toShort,  C2S)
    addPrimitives(CharClass, nme.toChar,   C2C)
    addPrimitives(CharClass, nme.toInt,    C2I)
    addPrimitives(CharClass, nme.toLong,   C2L)
    // unary methods
    addPrimitives(CharClass, nme.UNARY_+, POS)
    addPrimitives(CharClass, nme.UNARY_-, NEG)
    addPrimitives(CharClass, nme.UNARY_~, NOT)
    addPrimitives(CharClass, nme.toFloat,  C2F)
    addPrimitives(CharClass, nme.toDouble, C2D)

    // scala.Int
    addPrimitives(IntClass, nme.EQ, EQ)
    addPrimitives(IntClass, nme.NE, NE)
    addPrimitives(IntClass, nme.ADD, ADD)
    addPrimitives(IntClass, nme.SUB, SUB)
    addPrimitives(IntClass, nme.MUL, MUL)
    addPrimitives(IntClass, nme.DIV, DIV)
    addPrimitives(IntClass, nme.MOD, MOD)
    addPrimitives(IntClass, nme.LT, LT)
    addPrimitives(IntClass, nme.LE, LE)
    addPrimitives(IntClass, nme.GT, GT)
    addPrimitives(IntClass, nme.GE, GE)
    addPrimitives(IntClass, nme.XOR, XOR)
    addPrimitives(IntClass, nme.OR, OR)
    addPrimitives(IntClass, nme.AND, AND)
    addPrimitives(IntClass, nme.LSL, LSL)
    addPrimitives(IntClass, nme.LSR, LSR)
    addPrimitives(IntClass, nme.ASR, ASR)
      // conversions
    addPrimitives(IntClass, nme.toByte,   I2B)
    addPrimitives(IntClass, nme.toShort,  I2S)
    addPrimitives(IntClass, nme.toChar,   I2C)
    addPrimitives(IntClass, nme.toInt,    I2I)
    addPrimitives(IntClass, nme.toLong,   I2L)
    // unary methods
    addPrimitives(IntClass, nme.UNARY_+, POS)
    addPrimitives(IntClass, nme.UNARY_-, NEG)
    addPrimitives(IntClass, nme.UNARY_~, NOT)
    addPrimitives(IntClass, nme.toFloat,  I2F)
    addPrimitives(IntClass, nme.toDouble, I2D)

    // scala.Long
    addPrimitives(LongClass, nme.EQ, EQ)
    addPrimitives(LongClass, nme.NE, NE)
    addPrimitives(LongClass, nme.ADD, ADD)
    addPrimitives(LongClass, nme.SUB, SUB)
    addPrimitives(LongClass, nme.MUL, MUL)
    addPrimitives(LongClass, nme.DIV, DIV)
    addPrimitives(LongClass, nme.MOD, MOD)
    addPrimitives(LongClass, nme.LT, LT)
    addPrimitives(LongClass, nme.LE, LE)
    addPrimitives(LongClass, nme.GT, GT)
    addPrimitives(LongClass, nme.GE, GE)
    addPrimitives(LongClass, nme.XOR, XOR)
    addPrimitives(LongClass, nme.OR, OR)
    addPrimitives(LongClass, nme.AND, AND)
    addPrimitives(LongClass, nme.LSL, LSL)
    addPrimitives(LongClass, nme.LSR, LSR)
    addPrimitives(LongClass, nme.ASR, ASR)
      // conversions
    addPrimitives(LongClass, nme.toByte,   L2B)
    addPrimitives(LongClass, nme.toShort,  L2S)
    addPrimitives(LongClass, nme.toChar,   L2C)
    addPrimitives(LongClass, nme.toInt,    L2I)
    addPrimitives(LongClass, nme.toLong,   L2L)
    // unary methods
    addPrimitives(LongClass, nme.UNARY_+, POS)
    addPrimitives(LongClass, nme.UNARY_-, NEG)
    addPrimitives(LongClass, nme.UNARY_~, NOT)
    addPrimitives(LongClass, nme.toFloat,  L2F)
    addPrimitives(LongClass, nme.toDouble, L2D)

    // scala.Float
    addPrimitives(FloatClass, nme.EQ, EQ)
    addPrimitives(FloatClass, nme.NE, NE)
    addPrimitives(FloatClass, nme.ADD, ADD)
    addPrimitives(FloatClass, nme.SUB, SUB)
    addPrimitives(FloatClass, nme.MUL, MUL)
    addPrimitives(FloatClass, nme.DIV, DIV)
    addPrimitives(FloatClass, nme.MOD, MOD)
    addPrimitives(FloatClass, nme.LT, LT)
    addPrimitives(FloatClass, nme.LE, LE)
    addPrimitives(FloatClass, nme.GT, GT)
    addPrimitives(FloatClass, nme.GE, GE)
    // conversions
    addPrimitives(FloatClass, nme.toByte,   F2B)
    addPrimitives(FloatClass, nme.toShort,  F2S)
    addPrimitives(FloatClass, nme.toChar,   F2C)
    addPrimitives(FloatClass, nme.toInt,    F2I)
    addPrimitives(FloatClass, nme.toLong,   F2L)
    addPrimitives(FloatClass, nme.toFloat,  F2F)
    addPrimitives(FloatClass, nme.toDouble, F2D)
    // unary methods
    addPrimitives(FloatClass, nme.UNARY_+, POS)
    addPrimitives(FloatClass, nme.UNARY_-, NEG)

    // scala.Double
    addPrimitives(DoubleClass, nme.EQ, EQ)
    addPrimitives(DoubleClass, nme.NE, NE)
    addPrimitives(DoubleClass, nme.ADD, ADD)
    addPrimitives(DoubleClass, nme.SUB, SUB)
    addPrimitives(DoubleClass, nme.MUL, MUL)
    addPrimitives(DoubleClass, nme.DIV, DIV)
    addPrimitives(DoubleClass, nme.MOD, MOD)
    addPrimitives(DoubleClass, nme.LT, LT)
    addPrimitives(DoubleClass, nme.LE, LE)
    addPrimitives(DoubleClass, nme.GT, GT)
    addPrimitives(DoubleClass, nme.GE, GE)
    // conversions
    addPrimitives(DoubleClass, nme.toByte,   D2B)
    addPrimitives(DoubleClass, nme.toShort,  D2S)
    addPrimitives(DoubleClass, nme.toChar,   D2C)
    addPrimitives(DoubleClass, nme.toInt,    D2I)
    addPrimitives(DoubleClass, nme.toLong,   D2L)
    addPrimitives(DoubleClass, nme.toFloat,  D2F)
    addPrimitives(DoubleClass, nme.toDouble, D2D)
    // unary methods
    addPrimitives(DoubleClass, nme.UNARY_+, POS)
    addPrimitives(DoubleClass, nme.UNARY_-, NEG)
  }

  /** Add a primitive operation to the map */
  def addPrimitive(s: Symbol, code: Int) {
    assert(!(primitives contains s), "Duplicate primitive " + s)
    primitives(s) = code
  }

  def addPrimitives(cls: Symbol, method: Name, code: Int) {
    val alts = (cls.info member method).alternatives
    if (alts.isEmpty)
      inform(s"Unknown primitive method $cls.$method")
    else alts foreach (s =>
      addPrimitive(s,
        s.info.paramTypes match {
          case tp :: _ if code == ADD && tp =:= StringTpe => CONCAT
          case _                                          => code
        }
      )
    )
  }

  final val typeOfArrayOp: Map[Int, TypeKind] = Map(
    (List(ZARRAY_LENGTH, ZARRAY_GET, ZARRAY_SET) map (_ -> BOOL)) ++
    (List(BARRAY_LENGTH, BARRAY_GET, BARRAY_SET) map (_ -> BYTE)) ++
    (List(SARRAY_LENGTH, SARRAY_GET, SARRAY_SET) map (_ -> SHORT)) ++
    (List(CARRAY_LENGTH, CARRAY_GET, CARRAY_SET) map (_ -> CHAR)) ++
    (List(IARRAY_LENGTH, IARRAY_GET, IARRAY_SET) map (_ -> INT)) ++
    (List(LARRAY_LENGTH, LARRAY_GET, LARRAY_SET) map (_ -> LONG)) ++
    (List(FARRAY_LENGTH, FARRAY_GET, FARRAY_SET) map (_ -> FLOAT)) ++
    (List(DARRAY_LENGTH, DARRAY_GET, DARRAY_SET) map (_ -> DOUBLE)) ++
    (List(OARRAY_LENGTH, OARRAY_GET, OARRAY_SET) map (_ -> REFERENCE(AnyRefClass))) : _*
  )



  def isPrimitive(sym: Symbol): Boolean = primitives contains sym

  /** Return the code for the given symbol. */
  def getPrimitive(sym: Symbol): Int = {
    assert(isPrimitive(sym), "Unknown primitive " + sym)
    primitives(sym)
  }

  /**
   * Return the primitive code of the given operation. If the
   * operation is an array get/set, we inspect the type of the receiver
   * to demux the operation.
   *
   * @param fun The method symbol
   * @param tpe The type of the receiver object. It is used only for array
   *            operations
   */
  def getPrimitive(fun: Symbol, tpe: Type): Int = {
    import definitions._
    val code = getPrimitive(fun)

    def elementType = enteringTyper {
      val arrayParent = tpe :: tpe.parents collectFirst {
        case TypeRef(_, ArrayClass, elem :: Nil) => elem
      }
      arrayParent getOrElse sys.error(fun.fullName + " : " + (tpe :: tpe.baseTypeSeq.toList).mkString(", "))
    }

    code match {

      case APPLY =>
        toTypeKind(elementType) match {
          case BOOL    => ZARRAY_GET
          case BYTE    => BARRAY_GET
          case SHORT   => SARRAY_GET
          case CHAR    => CARRAY_GET
          case INT     => IARRAY_GET
          case LONG    => LARRAY_GET
          case FLOAT   => FARRAY_GET
          case DOUBLE  => DARRAY_GET
          case REFERENCE(_) | ARRAY(_) => OARRAY_GET
          case _ =>
            abort("Unexpected array element type: " + elementType)
        }

      case UPDATE =>
        toTypeKind(elementType) match {
          case BOOL    => ZARRAY_SET
          case BYTE    => BARRAY_SET
          case SHORT   => SARRAY_SET
          case CHAR    => CARRAY_SET
          case INT     => IARRAY_SET
          case LONG    => LARRAY_SET
          case FLOAT   => FARRAY_SET
          case DOUBLE  => DARRAY_SET
          case REFERENCE(_) | ARRAY(_) => OARRAY_SET
          case _ =>
            abort("Unexpected array element type: " + elementType)
        }

      case LENGTH =>
        toTypeKind(elementType) match {
          case BOOL    => ZARRAY_LENGTH
          case BYTE    => BARRAY_LENGTH
          case SHORT   => SARRAY_LENGTH
          case CHAR    => CARRAY_LENGTH
          case INT     => IARRAY_LENGTH
          case LONG    => LARRAY_LENGTH
          case FLOAT   => FARRAY_LENGTH
          case DOUBLE  => DARRAY_LENGTH
          case REFERENCE(_) | ARRAY(_) => OARRAY_LENGTH
          case _ =>
            abort("Unexpected array element type: " + elementType)
        }

      case _ =>
        code
    }
  }

  /** If code is a coercion primitive, the result type */
  def generatedKind(code: Int): TypeKind = code match {
    case B2B | C2B | S2B | I2B | L2B | F2B | D2B => BYTE
    case B2C | C2C | S2C | I2C | L2C | F2C | D2C => CHAR
    case B2S | C2S | S2S | I2S | L2S | F2S | D2S => SHORT
    case B2I | C2I | S2I | I2I | L2I | F2I | D2I => INT
    case B2L | C2L | S2L | I2L | L2L | F2L | D2L => LONG
    case B2F | C2F | S2F | I2F | L2F | F2F | D2F => FLOAT
    case B2D | C2D | S2D | I2D | L2D | F2D | D2D => DOUBLE
  }

}

object ScalaPrimitives extends ScalaPrimitivesOps
