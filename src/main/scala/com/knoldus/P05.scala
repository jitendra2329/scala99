package com.knoldus

import scala.annotation.tailrec


object P05 extends App{

  @tailrec
  private def reverseList[T](list: List[T], reversedList: List[T]= List().empty): List[T] = {
    list match {
      case Nil => reversedList
      case head::tail => reverseList(tail, head +: reversedList)
    }
  }

//  private def reverseList[T](list: List[T]): List[T] = {
//    list match {
//      case Nil =>
//      case head::tail => reverseList(tail :+ head)
//    }
//  }



  println(reverseList(List(45,7,88,9)))

}
