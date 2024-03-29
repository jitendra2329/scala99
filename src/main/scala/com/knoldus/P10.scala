package com.knoldus

object P10 extends App {

  private def pack[A](ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) List(List())
    else {
      val (packed, next) = ls.span(_ == ls.head)
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }

  private def encode[A](ls: List[A]): List[(Int, A)] =
    pack(ls) map { e => (e.length, e.head) }

  println(encode(List('a', 'a', 'b', 'c', 'c', 'a')))

}
