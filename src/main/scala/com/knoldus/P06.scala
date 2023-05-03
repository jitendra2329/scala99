package com.knoldus

//import com.knoldus.ReverseListP05.reverseList

object P06 extends App {

  def isPalindrome[T](list: List[T]): Boolean = {
    reverseList(list) == list
  }

  private def reverseList[T](list: List[T], reversedList: List[T] = List().empty): List[T] = {
    list match {
      case Nil => reversedList
      case head :: tail => reverseList(tail, head +: reversedList)
    }
  }

  val firstList = List(2, 7, 37, 9, 37, 7, 2)
  val secondList = List(2, 7, 37, 9, 5, 37, 7, 2)

  println(isPalindrome(firstList))
  println(isPalindrome(secondList))
}
