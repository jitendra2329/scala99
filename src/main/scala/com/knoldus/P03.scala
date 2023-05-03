package com.knoldus

import scala.annotation.tailrec

object P03 extends App {

  private def khElementByUsingSize[T](list: List[T], k: Int): T = {
    if (k >= 0) list(k)
    else throw new IllegalArgumentException()
  }

  @tailrec
  private def kthElementByUsingRecursion[T](list: List[T], k: Int, sizeOfList: Int): T = {
    require(k >= 0)
    list match {
      case head :: tail if sizeOfList - k - 1 == tail.size => head
      case _ :: tail => kthElementByUsingRecursion(tail, k, sizeOfList)
      case _ => throw new NoSuchElementException
    }
  }

  val list = List(4, 6, 8, 54, 3, 2, 44, 6, 41)
  println(khElementByUsingSize(list, 5))
  println(kthElementByUsingRecursion(list, 4, list.size))
}
