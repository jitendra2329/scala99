package com.knoldus

import scala.annotation.tailrec
import scala.math.pow

object P38 extends App {

  private def EulersTotientP34(number: Int): (Int, List[Int]) = {
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
    if (list.isEmpty) List()
    else {
      val (factor, tail) = list.span(_ == list.head)
      (factor.head, factor.length) :: multiplicity(tail)
    }
  }



  private def EulersTotient37(list: List[(Int, Int)]): Int = {
    list.map { values =>
      (values._1 - 1) * pow(values._1, values._2 - 1)
    }.product.toInt
  }

  private val result34 = EulersTotientP34(10090)._1
  private val result37 = EulersTotient37(multiplicity(findPrimeFactors(10090)))

  if(result34 == result37) println("Both the methods are correct.")
  else println("Only one method is working.")

}
