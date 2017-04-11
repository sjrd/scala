/* NSC -- new scala compiler
 * Copyright 2005-2013 LAMP/EPFL
 * @author  Martin Odersky
 */


package scala.tools.nsc
package backend
package icode

trait Primitives { self: ICodes =>
  import jvm.Primitives._

  // type : (type) => type
  // range: type <- { BOOL, Ix, Ux, Rx }
  // jvm  : {i, l, f, d}neg
  case class Negation(kind: TypeKind) extends Primitive

  // type : zero ? (type) => BOOL : (type,type) => BOOL
  // range: type <- { BOOL, Ix, Ux, Rx, REF }
  // jvm  : if{eq, ne, lt, ge, le, gt}, if{null, nonnull}
  //        if_icmp{eq, ne, lt, ge, le, gt}, if_acmp{eq,ne}
  case class Test(op: TestOp, kind: TypeKind,  zero: Boolean) extends Primitive

  // type : (type,type) => I4
  // range: type <- { Ix, Ux, Rx }
  // jvm  : lcmp, {f, d}cmp{l, g}
  case class Comparison(op: ComparisonOp, kind: TypeKind) extends Primitive

  // type : (type,type) => type
  // range: type <- { Ix, Ux, Rx }
  // jvm  : {i, l, f, d}{add, sub, mul, div, rem}
  case class Arithmetic(op: ArithmeticOp, kind: TypeKind) extends Primitive

  // type : (type,type) => type
  // range: type <- { BOOL, Ix, Ux }
  // jvm  : {i, l}{and, or, xor}
  case class Logical(op: LogicalOp, kind: TypeKind) extends Primitive

  // type : (type,I4) => type
  // range: type <- { Ix, Ux }
  // jvm  : {i, l}{shl, ushl, shr}
  case class Shift(op: ShiftOp, kind: TypeKind) extends Primitive

  // type : (src) => dst
  // range: src,dst <- { Ix, Ux, Rx }
  // jvm  : i2{l, f, d}, l2{i, f, d}, f2{i, l, d}, d2{i, l, f}, i2{b, c, s}
  case class Conversion(src: TypeKind, dst: TypeKind) extends Primitive

  // type : (Array[REF]) => I4
  // range: type <- { BOOL, Ix, Ux, Rx, REF }
  // jvm  : arraylength
  case class ArrayLength(kind: TypeKind) extends Primitive

  // type : (buf,el) => buf
  // range: lf,rg <- { BOOL, Ix, Ux, Rx, REF, STR }
  // jvm  : It should call the appropiate 'append' method on StringBuffer
  case class StringConcat(el: TypeKind) extends Primitive
}
