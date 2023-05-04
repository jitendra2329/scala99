package com.knoldus

object P11 extends App {
  private def pack[A](ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) List(List())
    else {
      val (packed, next) = ls.span(_ == ls.head)
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }

  private def encode[A](ls: List[A]): List[Any] =
    pack(ls) map { e =>
      val length = e.length

      if (length > 1) (length, e.head)
      else e.head
    }

  println(encode(List('a', 'a', 'b', 'c', 'c', 'a')))
}
