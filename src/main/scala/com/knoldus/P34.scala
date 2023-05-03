package com.knoldus

import scala.annotation.tailrec

object P34 extends App {
  private def EulersTotient(number: Int): (Int, List[Int]) = {
    @tailrec
    def helper(count: Int, g: Int, temp: Int, list: List[Int]): (Int, List[Int]) = {
      if (count >= number) (temp, list.reverse)
      else if (g == 1) helper(count + 1, gcd(count + 1, number), temp + 1, count :: list)
      else helper(count + 1, gcd(count + 1, number), temp, list)
    }

    @tailrec
    def gcd(number1: Int, number2: Int): Int = {
      if (number2 == 0) number1
      else if (number1 == 0) number2
      else if (number1 < number2) gcd(number1, number2 % number1)
      else gcd(number2, number1 % number2)
    }

    helper(1, gcd(1, number), 0, Nil)
  }

  println(EulersTotient(50))
}
