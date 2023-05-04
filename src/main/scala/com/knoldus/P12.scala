package com.knoldus

import scala.annotation.tailrec

object P12 extends App {

  private def decoder[A](list: List[(Int, A)]): List[A] = {
    @tailrec
    def helper(count: Int, listLength: Int, tempList: List[A], ls: List[(Int, A)]): List[A] = {
      (listLength, ls) match {
        case (l, head :: tail) if l <= list.length =>
          count match {
            case c if c < head._1 => helper(count + 1, listLength - 1, head._2 :: tempList, ls)
            case c if c >= head._1 => helper(0, listLength - 1, tempList, tail)
          }
        case _ => tempList.reverse
      }
    }

    helper(0, list.length - 1, Nil, list)
  }

  println(decoder(List((7, 'a'), (1, 'b'), (9, 'c'), (2, 'a'))))
  println(decoder(List((1, 'a'), (3, 'b'), (5, 'c'), (0, 'a'))))
  println(decoder(List((2, 'a'), (5, 'b'), (2, 'c'), (4, 'a'))))
}
