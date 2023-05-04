package com.knoldus

object P46 extends App {

  private def and(x:Boolean, y: Boolean): Boolean ={
    if (!y || !x) false
    else true
  }

  private def or(x: Boolean, y: Boolean): Boolean ={
    if(x || y) true
    else false
  }

  private def nand(x: Boolean, y: Boolean): Boolean = {
   !and(x, y)
  }

  private def nor(x: Boolean, y: Boolean): Boolean = {
    !or(x, y)
  }

//  def table2(expression: String): Unit = {
//    expression match {
//      case "AND" || "and" || "And" => println(s"true false true")
//    }
//  }

  println("AND gate-")
  println(and(x = true,y = true))
  println(and(x = false,y = true))
  println(and(x = true,y = false))
  println(and(x = false,y = false))

  println("NAND gate-")
  println(nand(x = true, y = true))
  println(nand(x = false, y = true))
  println(nand(x = true, y = false))
  println(nand(x = false, y = false))

  println("\nOR gate-")
  println(or(x = true, y = true))
  println(or(x = false, y = true))
  println(or(x = true, y = false))
  println(or(x = false, y = false))

  println("\nNOR gate-")
  println(nor(x = true, y = true))
  println(nor(x = false, y = true))
  println(nor(x = true, y = false))
  println(nor(x = false, y = false))

}
