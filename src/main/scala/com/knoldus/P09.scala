package com.knoldus

object P09 extends App {

  val list: List[Char] = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')

  private def makeList[A](ls: List[A]): List[List[A]] = {

    if (ls.isEmpty) List(List())
    else {
      val (head, tail) = ls.span(_ == ls.head)
      if (tail == Nil) List(head)
      else head :: makeList(tail)
    }
  }

  println(makeList(list))

}
