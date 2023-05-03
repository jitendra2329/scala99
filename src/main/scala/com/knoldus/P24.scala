package com.knoldus

import scala.annotation.tailrec
import scala.util.Random

object P24 extends App {

  private def drawList(number: Int, range: Int): List[Int] = {
    @tailrec
    def helper(count: Int, tempList: List[Int]): Set[Int] = {
      count match {
        case count if count >= number => tempList.reverse.toSet
        case count if count <= number => helper(count + 1, Random.nextInt(range) :: tempList)
      }
    }

    @tailrec
    def ifValid(set: Set[Int]): List[Int] = {
      if (set.size == number) set.toList
      else ifValid(helper(0, Nil))
    }

    ifValid(helper(0, Nil))

  }

  println(drawList(5, 19))

}
