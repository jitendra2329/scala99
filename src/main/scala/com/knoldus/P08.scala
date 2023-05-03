//package com.knoldus
//
//import scala.List
//import scala.annotation.tailrec
//import scala.collection.mutable.ListBuffer
//
//object P08 extends App {
//
//  @tailrec
//  private def eliminateConsecutiveDuplicate[A](list: List[A]): List[A] = {
//    //        val tempList = List().empty
//    //        list match {
//    //          case Nil => List().empty
//    //          case head::Nil => List(head)
//    //          case head:: secondHead:: Nil => if( head != secondHead) tempList :+ head :+ secondHead else tempList:+ head
//    //          case head:: secondHead :: tail => if (head == secondHead ) tempList :+ head
//    //          else {
//    //            tempList:+ head :+ secondHead
//    //            eliminateConsecutiveDuplicate(tail)
//    //          }
//    //    //      case _ :: tail => eliminateConsecutiveDuplicate(tail)
//    //        }
//    //
//    ////    val emptyList:
//    ////    val t = list.drop(1)
//    //
//    ////    for{
//    ////      x <- list
//    ////      y <- t
//    ////    }
//    val temprList = list.drop(1)
//    val index = 0
//
//    def helper(list: List[A], tempList: List[A], index: Int): List[A] = {
//      if (index == temprList.length - 2) tempList
//      else if (temprList.head != list.head) {
//        tempList :+ list.head
//        helper(list.drop(index + 1), tempList, index + 1)
//      }
//      else
//
//    }
//    helper(list, List().empty, 0)
//
//  }
//
//  println(eliminateConsecutiveDuplicate(List('a', 'a', 'b', 'b', 'b')))
//
//}
