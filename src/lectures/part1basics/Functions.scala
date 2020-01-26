package lectures.part1basics

object Functions extends App {

  /*
  The syntax for functions is
  def keyword
  name of the function
  params in parenthesis with type
  colon with type it returns.
  Return types can be inferred by the compiler (except for recursive functions!)
  a SINGLE expression(the value it returns)
  since expressions can be code blocks we can add {}
   */
  // Example:
  def aFunction(a: String, b:Int): String =
    a + " " + b

  // Example with code block
  def anotherFunction(a: String, b:Int): String = {
    a + " " + b
  }

  // To call a function we call it with parenths and the params inside
  println(aFunction("hello", 3)) // hello 3

  // Functions that take no params can be called with or without parentheses
  def parameterLessFuncrtion(): Int = 42
  println(parameterLessFuncrtion()) // 42
  println(parameterLessFuncrtion) // 42

  // WHEN WE NEED LOOPS IN FUNCTIONAL PROGRAMMING WE USE RECURSION
  // In recursive functions we must specify the return type
  def repeat(aString: String, times: Int): String = {
    if (times == 1) aString
    else aString + repeat(aString, times - 1)
  }

  println(repeat("hello ", 3))

  // The return type of a function can be Unit
  // We can use functions with side effects when they have nothing to do with computation
  // Ex: print to the console, logs, writing to files etc.
  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  aFunctionWithSideEffects("Hello")

  // We can define functions inside code blocks
  def anOuterFunction(n: Int): Int = {
    def innerFunction(a: Int, b: Int): Int = a + b

    innerFunction(n, n -1)
  }

  println(anOuterFunction(3)) // 5

  /*
  Execises
  1. greeting funnction with two params(name, age)
    should return "Hello my name is +name + and i am + age + years old

  2. Factorial function. Calculates the product of all numbers up to a given n param

  3. Fibonacci function
    f(1) = 1
    f(2) = 1
    f(n) = f(n-1) + f)n-2)
  4. Test if a number is prime
   */

  def greeting(name: String, age: Int): String =
    "Hello, my name is " + name + " and I am " + age + " years old."

  println(greeting("Tom", 5))

  def factorial(n: Int): Int =
    if(n == 1) n
    else n * factorial(n-1)

  println(factorial(5)) // 120

  def fibonacci(n: Int): Int =
    if(n <= 2) 1
    else fibonacci(n-1) + fibonacci(n-2)

  // 1 1 2 3 5 8 13 21
  println(fibonacci(8)) // 21

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t -1)

    isPrimeUntil(n / 2)
  }

  println(isPrime(37)) // true
  println(isPrime(9)) // false
}
