/* NSC -- new Scala compiler
 * Copyright 2005-2013 LAMP/EPFL
 * @author  Martin Odersky
 */

package scala
package tools.nsc
package backend
package jvm

object Opcodes {

  /** This class represents a method invocation style. */
  sealed abstract class InvokeStyle {
    /** Is this a dynamic method call? */
    def isDynamic: Boolean = false

    /** Is this a static method call? */
    def isStatic: Boolean = false

    def isSuper: Boolean = false

    /** Is this an instance method call? */
    def hasInstance: Boolean = true

    /** Returns a string representation of this style. */
    override def toString(): String
  }

  /** Virtual calls.
    *  On JVM, translated to either `invokeinterface` or `invokevirtual`.
    */
  case object Dynamic extends InvokeStyle {
    override def isDynamic = true
    override def toString(): String = "dynamic"
  }

  /**
   * Special invoke:
   *   Static(true)  is used for calls to private members, ie `invokespecial` on JVM.
   *   Static(false) is used for calls to class-level instance-less static methods, ie `invokestatic` on JVM.
   */
  case class Static(onInstance: Boolean) extends InvokeStyle {
    override def isStatic    = true
    override def hasInstance = onInstance
    override def toString(): String = {
      if(onInstance) "static-instance"
      else           "static-class"
    }
  }

  /** Call through super[mix].
    *  On JVM, translated to `invokespecial`.
    */
  case class SuperCall(mix: String) extends InvokeStyle {
    override def isSuper = true
    override def toString(): String = { "super(" + mix + ")" }
  }

}
