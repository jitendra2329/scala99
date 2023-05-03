package com.knoldus

import scala.annotation.tailrec

object P35 extends App {

  private def findPrimeFactors(num: Int): List[Int] = {
    @tailrec
    def helper(num: Int, acc: Int, list: List[Int]): List[Int] = {
      if (acc >= num ) list
      else if (num % acc == 0 && P31.isPrime(acc)) helper(num, acc + 1, acc :: list)
      else helper(num, acc + 1, list)
    }

    val result = helper(num, 2, Nil)

    @tailrec
    def addNumber(number: Int): List[Int] = {
      if (number <= 0) number :: result
      else if (P31.isPrime(number)) {
        val res = number :: result
        if (res.product == num) res
        else addNumber(num / res.product)
      }
      else helper(number, 2, result)
    }


    if (result.product == num) result
    else addNumber(num / result.product).sorted


  }

  println(findPrimeFactors(15))

}
