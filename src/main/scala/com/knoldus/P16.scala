package com.knoldus

object P16 extends App {

  private def dropNthElement16[A](number: Int, list: List[A]): List[A] = {
    list.filterNot(_ == list(number - 1))
  }

  val list = List(1,2,3,4,5,6)
  val result = dropNthElement16(3,list)
  println(result)

}
