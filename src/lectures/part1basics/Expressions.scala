package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 // expression: evaluated to a value. Expressions have a type
  println(x) // 3

  // arithmetic expressions are some of the most common
  println (2 + 3 + 4)  // 9
  // mathematical operators in Scala are
  // + - * / & | ^ << >> >>>(right shift with zero extension)

  // expressions can also test for equality and evaluate to a boolean
  println(1 == x) // false
  // operators to test for equality are
  // == != > >= < <=
  // we also use logical operators that act on booleans and return a boolean
  // ! negation && logical and || logical or
  println(!(1 == x)) // true

  var aVariable = 2
  // we have operators that modify a variable... side effects
  // += -= *= /=
  aVariable +=3 // will evaluate the variable + 3 and store the value
  println(aVariable) // 5


  /*
  Instructions(DO) vs Expressions(VALUE)
  Instructions are executed vs Expressions are evaluated
  In Scala we will work with expressions
  EVERYTHING in Scala is an expression!!
  whereas in declarative languages such as Java we will work wth instructions
   */

  /*
  IF expression
  In scala we call it if EXPRESSION. Because it always returns a value
  Instead of if(something) DO something(instruction). We say if(something) the VALUE is something
  */
  var aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue) // 5
  // since expressions ARE values we can use them directly. Ex in a println statement
  println(if(aCondition) 5 else 3) // 5

  /*
  LOOPS are DISCOURAGED in Scala. They don't return a value and only produce side effects
  Looping in general is typical of imperative programming
  */
  var i = 0
  while (i < 10) {
      println(i)
      i += 1
  } // 0 1 2 3 4 5 6 7 8 9

  val aWeirdValue = (aVariable = 3) // Evaluates to Unit. In Scala it's the equivalent to void
  println(aWeirdValue) // () unit always evaluates to empty parenthesis
  /*
  side effects in Scala always return unit
  Examples of side effects : println(), while loops, reassigning of vars
  Instructions in Scala are side effects that return unit
  */


  /*
  Code blocks
  They are expressions. They have a value
  The value of a block is the value of the last expression
  vals and variables declared inside the code block are not visible outside
  vals declared outside are accessible inside the block
   */
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }
  println(aCodeBlock)
  // val anotherValue = z + 1 will through an error in the compiler because z is not accessible here

  // Questions:

  // 1. Difference between "hello world" and println("Hello world")
  // First is a value of type string. Second is an instruction of type unit

  // 2. What is the value of the code block
  val someValue = {
    2 < 3
  } // true
  println(someValue)

  // 3. What is the value of the code block
  val someOtherValue = {
    if(someValue) 239 else 986
    42
  } // 42
  print(someOtherValue)
}
