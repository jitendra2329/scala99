//package com.knoldus
//
object P22 extends App {
//
  def createList(range: Range ): List[Int] = {
    range.map(value => value).toList
  }

  val r =  -1 to 9
  println(createList(r))
}
