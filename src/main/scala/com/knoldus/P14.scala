package com.knoldus

object P14 extends App {

  private def mySolution[A](list: List[A]): List[A] = {
    list match {
      case Nil => List()
      case head :: Nil => List(head, head)
      case head :: tail => List(head, head) ++ mySolution(tail)
    }
  }

  private def scala99Solution[A](list:List[A]): List[A] = {
    list.flatMap(e => List(e,e))
  }

  println(scala99Solution(List(2, 4, 3, 5, 6, 7, 8, 9)))
  println(scala99Solution(List()))

  println(mySolution[Int](List(2, 4, 3, 5, 6, 7, 8, 9)))
  println(mySolution[Char](List('a', 'b', 'c', 'd', 'e', 'f', 'f', 'h')))
  println(mySolution[Char](List()))
}
