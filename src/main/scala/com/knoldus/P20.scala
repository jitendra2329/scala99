package com.knoldus

import scala.annotation.tailrec

object P20 extends App {

  private def removeElement[A](number: Int, list: List[A]): (List[A], A) = {
    @tailrec
    def helper(count: Int, startList: List[A], endList: List[A], elem: A): (List[A], A) = {
      (count, endList) match {
        case (c, _) if c >= number => (startList.reverse.take(startList.reverse.length - 1) ::: endList, elem)
        case (c, head :: tail) if c <= number => helper(c + 1, head :: startList, tail, head)
      }
    }

    helper(0, Nil, list, list.head)
  }

  val number = 3
  println(removeElement(number, List('a', 'b', 'c', 'd', 'e', 'f')))
}
