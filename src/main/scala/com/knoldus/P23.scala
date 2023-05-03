package com.knoldus

import scala.annotation.tailrec
import scala.util.Random

object P23 extends App {

  private def selectRandomElement[A](number: Int, list:List[A]): List[A] = {
    @tailrec
    def helper(count: Int, tempList: List[A]): List[A] = {
      count match {
        case count if count >= number => tempList.reverse
        case count if count < number => helper(count + 1, list(Random.nextInt(list.length))::tempList)
      }
    }
    helper(0,Nil)
  }

  println(selectRandomElement(3,List(3,5,2,8,1,9,10,11,70)))
}
