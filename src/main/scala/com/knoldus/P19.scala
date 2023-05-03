package com.knoldus

import scala.annotation.tailrec

object P19 extends App {
  private def rotate[A](number: Int, list: List[A]): List[A] = {
    @tailrec
    def helper(count: Int, ls: List[A], tempList: List[A]): List[A] = {
      (count, ls) match {
        case (_ , ls) if number < 0 => ls.drop(ls.length + number) ::: ls.take(ls.length + number - 1)
        case (_, Nil) => List()
        case (c, list) if c >= number => tempList ::: list
        case (c, head :: tail) if c <= number => helper(c + 1, tail, head :: tempList)
      }
    }

    helper(0, list, Nil)
  }

  println(rotate(-2, List(2, 3, 5, 7, 8, 4, 9, 0)))
}
