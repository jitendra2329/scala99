package com.knoldus


import scala.annotation.tailrec
import scala.util.Random

object P26 extends App {

  private def getNCombination[A](number: Int, list: List[A]): List[List[A]] = {
    @tailrec
    def helper(count: Int, tempList: List[A]): Set[A] = {
      count match {
        case c if c >= number => tempList.reverse.toSet
        case c if c <= number => helper(c + 1, list(Random.nextInt(list.length)) :: tempList)

      }
    }

    @tailrec
    def combinations(set: Set[A], lst: List[List[A]]): List[List[A]] = {
      if (lst.size == (numberOfCombinations(number, list.length) / numberOfCombinations(number, number))) lst
      else if (set.size == number) combinations(helper(0, Nil), set.toList :: lst)
      else combinations(helper(0, Nil), lst)
    }

    def numberOfCombinations(n: Int, length: Int): Int = {
      @tailrec
      def helper(number: Int, acc: Int, ln: Int = length): Int = {
        if (number <= 0) acc
        else {
          helper(number - 1, acc * ln, ln - 1)
        }
      }

      helper(n, 1)
    }

    combinations(helper(0, Nil), Nil)
  }

  println(getNCombination(2, List(1, 2, 3)).size)
  getNCombination(2, List(1, 2, 3)).foreach(println)
}
