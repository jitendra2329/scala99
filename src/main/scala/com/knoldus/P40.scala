package com.knoldus

import scala.annotation.tailrec

object P40 extends App {


  private def findGoldbachsConjecture(number: Int): (Int, Int) = {
    require(number % 2 == 0)
    def findPrimeList(number: Int): List[Int] = {
      @tailrec
      def helper(count: Int, tempList: List[Int]): List[Int] = {
        count match {
          case c if c > 1 => c match {
            case value if P31.isPrime(value) => helper(c - 1, c :: tempList)
            case _ => helper(c - 1, tempList)
          }
          case c if c <= 1 => tempList
        }
      }

      helper(number, Nil)
    }


    val listOfPrimes = findPrimeList(number)

    def helper(start: Int, end: Int): (Int, Int) = {
      val sum = listOfPrimes(start) + listOfPrimes(end)
      if (sum == number) (listOfPrimes(start), listOfPrimes(end))
      else if (sum > number) helper(start, end - 1)
      else helper(start + 1, end)
    }

    helper(0, listOfPrimes.length - 1)

  }

  println(findGoldbachsConjecture(10))
  println(findGoldbachsConjecture(12))
  println(findGoldbachsConjecture(14))
  println(findGoldbachsConjecture(16))
  println(findGoldbachsConjecture(18))
  println(findGoldbachsConjecture(20))
  println(findGoldbachsConjecture(11))
}

