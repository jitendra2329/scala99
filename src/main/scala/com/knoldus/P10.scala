//package com.knoldus
//
//import scala.annotation.tailrec
//
//object P10 extends App {
//
//  private def countOccurrence[A](list: List[A]): (List[Int], List[A]) = {
//    @tailrec
//    def helper(tempList: List[A], count: Int, numList: List[Int], ls: List[A]): (List[Int], List[A]) = {
//      ls match {
//        case Nil => (numList.reverse, tempList)
//        case head :: tail if head == tempList.head => helper(tempList, count + 1, List(count + 1), tail)
//        case head :: tail if head != tempList.head => helper(head :: tempList, 1, count :: numList, tail)
//      }
//
//    }
//
//    helper(List(list.head), 0, Nil, list)
//  }
//
//  println(countOccurrence(List('a', 'a', 'b', 'c','c', 'a')))
//}
