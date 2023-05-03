package com.knoldus

import scala.annotation.tailrec

object P07 extends App {

  @tailrec
  private def flattenList[A](list: List[Any]): List[A] = {
    list match {
      case list: List[_] => flattenList(list)
      case element: A => List(element)
    }
  }

  println(flattenList(List(34,4,List(34,33, List(4,3,5,8)),5)))
}
