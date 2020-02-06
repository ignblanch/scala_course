package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {
  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    // Exercises
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def learns(thing: String) = s"$name is learning $thing"
    def learnsScala = this learns "Scala"
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
  }


  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception")) // true
  // infix notation = operator notation (syntactic sugar)
  println(mary likes "Inception") // equivalent. works with metods with 1 parameter

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  // we can think of the method hangOutWith as an "operator", because it operates on two things and returns a third thing
  println(mary hangOutWith tom) // Mary is hanging out with Tom
  // we can rename the method to + (a valid expression) so we can call it as:
  println(mary + tom) // Mary is hanging out with Tom
  println(mary.+(tom)) // equivalent:  we call the method + of the class Mary with the parameter tom

  println(1 + 2) // 3
  println(1.+(2)) // 3: we can see that math operators act the same way as methods: + is a method of 1 with the parameter 2

  // ALL OPERATORS ARE METHODS

  // prefix notation
  // unary operators are also methods
  val x = -1  // equivalent with 1.unary_-
  val y = 1.unary_- // equivalent to -1
  // unary_ prefix only works with - + ~ !

  // we can declare a method with unary_(- + ~ !) and we can use it with prefix notation
  println(!mary) // Mary, what the heck?!
  println(mary.unary_!) // equivalent: Mary, what the heck?!

  // postfix notation. Only for methods with no params
  // this notation is discouraged as it can be prone to ambiguity for us humans to read
  println(mary.isAlive)
  println(mary isAlive)

  // apply - special method in Scala
  println(mary.apply()) //Hi, my name is Mary and I like Inception
  println(mary()) // equivalent Hi, my name is Mary and I like Inception
  // when we call the object directly with () the compiler looks for an apply method

  /*
    EXERCISES
    1.  Overload the + operator
        mary + "the rockstar" => new person "Mary (the rockstar)"
    2.  Add an age to the Person class
        Add a unary + operator => new person with the age + 1
        +mary => mary with the age incrementer
    3.  Add a "learns" method in the Person class => "Mary learns Scala"
        Add a learnsScala method, calls learns method with "Scala".
        Use it in postfix notation.
    4.  Overload the apply method
        mary.apply(2) => "Mary watched Inception 2 times"
   */

  println((mary + "the Rockstar")()) // Hi, my name is Mary (the Rockstar) and I like Inception
  println((mary + "the Rockstar").apply()) // Hi, my name is Mary (the Rockstar) and I like Inception
  println((+mary).age) // 1
  println(mary learnsScala) // Mary is learning Scala
  println(mary(10)) // Mary watched Inception 10 times
}
