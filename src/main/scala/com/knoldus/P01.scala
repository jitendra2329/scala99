package com.knoldus

import scala.annotation.tailrec

object P01 extends App {

  private def lastByUsingSize[T](list: List[T]): T = list(list.size - 1)

  private def lastByUsingLast[T](list: List[T]): T = list.last

  @tailrec
  private def lastByUsingRecursion[T](list: List[T]): T = {
    list match {
      case head :: Nil => head
      case head :: tail => lastByUsingRecursion(tail)
      case _ => throw new NoSuchElementException
    }
  }

  private val list = List(7, 9, 4, 3, 90, 21)
  println(lastByUsingSize(list))
  println(lastByUsingLast(list))
  println(lastByUsingRecursion(list))

  private val stringList = List("Jitendra", "Ajit", "Naman", "Aman")
  println(lastByUsingSize(stringList))
  println(lastByUsingLast(stringList))
  println(lastByUsingRecursion(stringList))

//  println(lastByUsingRecursion(List().empty))
}
