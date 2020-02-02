package lectures.part1basics

object StringOps extends App {
  val str: String = "Hello, I am learning Scala"

  // methods of String present in Java
  println(str.charAt(2)) // l
  println(str.substring(7, 11)) // I am
  println(str.split(" ").toList) // List (Hello,, I, am, learning, Scala)
  println(str.startsWith("Hello")) // true
  println(str.replace(" ", "-")) // Hello,-I-am-learning-Scala
  println(str.toLowerCase) // hello, i am learning scala
  println(str.length) // 26

  // Scala specific utils
  val aNumberString = "2"
  val aNumber = aNumberString.toInt // converts the string to int
  println('a' +: aNumberString :+ 'z') // a2z +: means prepending :+ means appending
  println(str.reverse) // alacS gninrael ma I ,olleH
  println(str.take(2)) // He

  // Scala-specific: String interpolators.

  // S-interpolators - we introduce the string that'll be interpolated with a letter s
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old" // the s at the beginning tells the compiler the variables should be interpolated
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old." // we can also interpolate logic that'll be evaluated
  println(anotherGreeting) // Hello, my name is David and I will be turning 13 years old.

  // F-interpolators - formatted strings-similar to printf
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute" //%2.2f is the format of the float, two characters minimum, 2 decimals precision
  println(myth) // David can eat 1.20 burgers per minute

  // raw-interpolator - prints characters literally. Ignores escaped characters
  println(raw"This is a \n newline") // This is a \n newline backslash won't be escaped
  val escaped = "This is a \n newline"
  println(raw"$escaped") // will escape the new line
  /*
  This is a
    newline
   */
}
