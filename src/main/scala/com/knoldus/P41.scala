package com.knoldus

import scala.annotation.tailrec

object P41 extends App {

  private def findGoldbachsConjecture(number: Int): (Int, Int) = {

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

    @tailrec
    def helper(start: Int, end: Int): (Int, Int) = {
      val sum = listOfPrimes(start) + listOfPrimes(end)
      if (sum == number) (listOfPrimes(start), listOfPrimes(end))
      else if (sum > number) helper(start, end - 1)
      else helper(start + 1, end)
    }

    helper(0, listOfPrimes.length - 1)

  }


  @tailrec
  private def makeComposition(start: Int, end: Int): Unit = {
    if (start > end) System.exit(0)
    else if (start % 2 == 0) {
      println(s"$start = ${findGoldbachsConjecture(start)._1}  + ${findGoldbachsConjecture(start)._2} ")
      makeComposition(start + 1, end)
    }
    else makeComposition(start + 1, end)
  }

  makeComposition(9, 20)

}

