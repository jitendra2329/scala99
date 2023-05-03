package com.knoldus

import scala.annotation.tailrec

object P21 extends App {

  private def insert[A](element: A, index: Int, list: List[A]): List[A] = {
    require(index >= 0)

    @tailrec
    def helper(count: Int, tempList: List[A], ls: List[A]): List[A] = {
      (count, ls) match {
        case (_, Nil) => List()
        case (c, head :: tail) if c < index => helper(c + 1, head :: tempList, tail)
        case (c, ls) if c >= index => tempList.reverse ::: element :: ls
      }
    }

    helper(0, Nil, list)
  }

  private val intElement = 3
  val index = 2
  println(insert(intElement, index, List(1, 2, 4, 5, 6, 7, 8)))

  private val charElement = 'd'
  private val indx = 3
  println(insert(charElement, indx, List('a', 'b', 'c', 'e', 'f', 'g')))
}
