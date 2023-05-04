package com.knoldus

import scala.annotation.tailrec

object P39 extends App {

  @tailrec
  private def getListOfPrimeNumbers(start: Int, end: Int, list: List[Int] = Nil): List[Int] = {

    if (start >= end) list.reverse
    else if (P31.isPrime(start)) {
      getListOfPrimeNumbers(start + 1, end, start :: list)
    }
    else getListOfPrimeNumbers(start + 1, end, list)
  }

  println(getListOfPrimeNumbers(10, 20))
}
