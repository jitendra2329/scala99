package com.knoldus

import scala.annotation.tailrec

object P36 extends App {

  private def findPrimeFactors(num: Int): List[Int] = {
    @tailrec
    def helper(num: Int, acc: Int, list: List[Int]): List[Int] = {
      if (acc >= num) acc :: list
      else if (num % acc == 0 && P31.isPrime(acc)) helper(num / acc, acc, acc :: list)
      else helper(num, acc + 1, list)
    }

    helper(num, 2, Nil).reverse
  }

  private def multiplicity(list: List[Int]): List[(Int, Int)] = {
    if(list.isEmpty) List()
    else {
      val (factor, tail) = list.span(_ == list.head)
      (factor.head, factor.length) :: multiplicity(tail)
    }
  }

  println(multiplicity(findPrimeFactors(315)))
}
