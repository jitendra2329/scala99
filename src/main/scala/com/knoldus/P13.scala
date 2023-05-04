package com.knoldus

object P13 extends App {

  private def encodeDirect[A](ls: List[A]): List[(Int, A)] =
    if (ls.isEmpty) Nil
    else {
      val (packed, next) = ls span {
        _ == ls.head
      }
      (packed.length, packed.head) :: encodeDirect(next)
    }

  println(encodeDirect(List('a', 'a', 'v', 'b', 'b')))
}
