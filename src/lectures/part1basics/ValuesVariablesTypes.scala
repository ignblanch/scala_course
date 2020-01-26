package lectures.part1basics

object ValuesVariablesTypes extends App {

  // Double quotes are not required in scala

  // vals
  // they are immutable. Their value cannot be reasigned
  // types of vals are optional.
  // The compiler will infer them from the right hand side of the = sign. In this case Int
  val x: Int = 42 // Can also be val x = 42. In practice we don't usually mention types explicitly for vals and variables
  println(x)

  val aString: String = "Hello"          // String. Pieces of text inside double quotes
  val aBoolean: Boolean = true           // Boolean. true or false values
  val aChar: Char = 'a'                  // Single charactes inside single quotes
  val aInt: Int = x                      // Integer. 4byes max
  val aShort: Short = 4613               // Short numbers half the represetation of ints: 2bytes max
  val aLong: Long = 12343432312121212L   // Long numbers. 8bytes max. If a number is too long for a int we must
                                         // specifically indicate it's a long number with a capital L at the end
  val aFloat: Float = 2.0f               // we specify it's a float by adding f at the end. Otherwise it's a double
  val aDouble: Double = 3.14             // by default the double representation of decimal point numbers

  // variables
  // they can be reasigned. Always the same type
  // They are used for side effects
  var aVariable: Int = 42
  aVariable = 5

}
