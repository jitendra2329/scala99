package com.knoldus

import scala.annotation.tailrec
import scala.util.Random

object P25 extends App {

  private def selectRandomPermutation[A](number: Int, list: List[A]): List[A] = {
    @tailrec
    def helper(count: Int, tempList: List[A]): List[A] = {
      count match {
        case count if count >= number => tempList.reverse
        case count if count < number => helper(count + 1, list(Random.nextInt(list.length)) :: tempList)
      }
    }

    helper(0, Nil)
  }

  val list = List(3, 5, 2, 8, 1, 9, 10, 11, 70)
  println(selectRandomPermutation(Random.nextInt(list.length-1),list ))
}
