package com.knoldus

object P32 extends App {

  def gcd(number1: Int, number2: Int): Int = {
    if (number2 == 0) number1
    else if (number1 == 0) number2
    else if (number1 < number2) gcd(number1, number2 % number1)
    else gcd(number2, number1 % number2)
  }

  println(gcd(50, 10))
}
