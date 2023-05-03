package com.knoldus

import scala.annotation.tailrec

object P31 extends App {
  def isPrime(number: Int): Boolean = {
    @tailrec
    def helper(number: Int, acc: Int): Boolean = {
      if (acc <= 1) true
      else if (number % acc == 0) false
      else helper(number, acc - 1)
    }

    helper(number, math.sqrt(number).toInt)
  }
}
