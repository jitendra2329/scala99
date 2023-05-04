package com.knoldus

import scala.annotation.tailrec
import scala.math.pow

object P37 extends App {

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


  val result = multiplicity(findPrimeFactors(10090))

  def EulersTotient(list: List[(Int, Int)]): Int = {
    list.map { values =>
      (values._1 - 1) * pow(values._1, values._2 - 1)
    }.product.toInt
  }

  println(EulersTotient(result))
}
