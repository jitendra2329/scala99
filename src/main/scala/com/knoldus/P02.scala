package com.knoldus

import scala.annotation.tailrec

object P02 extends App {

  private def secondLastByUsingSize[T](list: List[T]): T = {
    list(list.size - 2)
  }

  @tailrec
  private def secondLastByUsingRecursion[T](list: List[T]): T = {
    list match {
      case head :: tail if tail.size == 1 => head
      case _ :: tail => secondLastByUsingRecursion(tail)
      case _ => throw new NoSuchElementException
    }
  }

  val list = List(3, 8, 1, 44, 6, 8, 51)
  println(secondLastByUsingSize(list))
  println(secondLastByUsingRecursion(list))

}
