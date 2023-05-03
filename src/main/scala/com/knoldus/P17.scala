package com.knoldus

import scala.annotation.tailrec

object P17 extends App {

  //  private def spitList[A](index: Int, list: List[A]): (List[A], List[A]) = {
  //    list.splitAt(index)
  //
  //  }

  private def spitList[A](index: Int, list: List[A]): (List[A], List[A]) = {
    @tailrec
    def helper(count: Int, list: List[A], ls: List[A]): (List[A], List[A]) = {
      (count, list) match {
        case (c, list) if c >= index => (ls.reverse, list)
        case (c, head :: tail) if c <= index => helper(c + 1, tail, head :: ls)
      }
    }

    helper(0, list, Nil)

  }


  println(spitList(6, List(1, 2, 3, 4, 5, 6, 7, 8)))
}
