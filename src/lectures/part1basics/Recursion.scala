package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  
  def factorial(n: Int): Int =
    if(n == 1) n
    else {
      println("Computing factorial of " + n + " - First I need factorial of " + (n-1) )
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)
      result
    }

  println(factorial(10)) //3628800
  // println(factorial(5000)) // stack overflow error
  /*
  JVM executes recursive functions and each time it adds it to a stack.
  It needs to store intermediate results somewhere.
  JVM cannot process so many calls to a recursive function
  We need to introduce a new concept: tail recursion
  */
  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression

    factHelper(n, 1)
  }

  /*
    anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9, 10 * 1)
    = factHelper(8, 9 * 10 * 1)
    = factHelper(7, 8 * 9 * 10 * 1)
    = ...
    = factHelper(2, 3 * 4 * ... * 10 * 1)
    = factHelper(1, 1 * 2 * 3 * 4 * ... * 10)
    = 1 * 2 * 3 * 4 * ... * 10
   */

  println(anotherFactorial(20000)) //18192063..........

  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION.

  /*
    The key is use an accumulator each time we need to call a recursive function
    Therefore we free the compiler from the burden of having to store the intermediate values
    Accumulator must always be the same type as the return type of the function
    There will be as many accumulators as times we call a recursive function
   */


  /*
    we can use @tailrec annotation
    to tell the compiler this should be a tail recursive function
    It will throw an error if it is not at compile time
   */

  /*
    Exercises:
    1.  Concatenate a string n times
    2.  IsPrime function tail recursive
    3.  Fibonacci function, tail recursive.
   */

  @tailrec
  def concatenateTailrec(aString: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatenateTailrec(aString, n-1, aString + accumulator)

  println(concatenateTailrec("hello", 3, "")) // hellohellohello


  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean = // isStillPrime is the accumulator in this case
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)
  }

  println(isPrime(2003)) // true
  println(isPrime(629)) // false

  def fibonacci(n: Int): Int = {
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if(i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(fibonacci(8)) // 1 1 2 3 5 8 13, 21


}
