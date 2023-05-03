package com.knoldus

import scala.annotation.tailrec

object P18 extends App {

  //  private def sliceList[A](start: Int, end: Int, list: List[A]): List[A] = {
  //    list.slice(start, end)
  //  }

  private def sliceList[A](start: Int, end: Int, list: List[A]): List[A] = {

    (start, end, list) match {
      case (_, _, Nil) => List()
      case (s, e, list) if s >= e => list
      case (s, e, list) => list.take(e).drop(s)
    }
  }

  private def sliceTailRecursive[A](start: Int, end: Int, ls: List[A]): List[A] = {
    @tailrec
    def sliceR(count: Int, curList: List[A], result: List[A]): List[A] =

      (count, curList) match {
        case (_, Nil) => result
        case (c, _ :: _) if end <= c => result.reverse
        case (c, h :: tail) if start <= c => sliceR(c + 1, tail, h :: result)
        case (c, _ :: tail) => sliceR(c + 1, tail, result)
      }

    sliceR(0, ls, Nil)
  }

  println(sliceTailRecursive(3, 7, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i')))
}
