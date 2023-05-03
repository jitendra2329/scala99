package com.knoldus

import scala.annotation.tailrec

object P04 extends App {

  private def numberOfElementsInList[T](list: List[T]): Int = {
    list.length
  }

  @tailrec
  private def numberOfElementsInListUsingRecursion[T](list: List[T], elementsInList: Int = 0): Int = {
    list match {
      case Nil => elementsInList
      case _ :: tail => numberOfElementsInListUsingRecursion(tail, elementsInList + 1)
    }
  }

  println(numberOfElementsInList(List(3, 2, 4)))
  println(numberOfElementsInList(List().empty))
  println(numberOfElementsInListUsingRecursion(List(3, 22, 5, 3, 2, 7, 4)))
  println(numberOfElementsInListUsingRecursion(List().empty))

}
