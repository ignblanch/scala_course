package lectures.part2oop

object CaseClasses extends App {

  /*
  Lightweight classes with some static functionality
  we can create classes with little boilerplate
  add a lot of features implemented to classes without adding boilerplate
  we do not need to create companion objects etc.
   */
  case class Person(name: String, age: Int)

  // 1. class parameters are all promoted to fields (static functionality)
  val jim = new Person("Jim", 34)
  println(jim.name) // Jim - we can access them directly

  // 2. sensible toString
  // println(instance) = println(instance.toString) // syntactic sugar
  println(jim) // Person(Jim, 34) - same as println(jim.toString)
  // without the 'case' class it would have printed some strange compiler stuff

  // 3. equals and hashCode implemented out of the box in 'case' classes
  val jim2 = new Person("Jim", 34)
  println(jim == jim2) // true - in classes that are not case classes it would return false

  // 4. CCs have handy copy method - creates a new instance with the same params
  val jim3 = jim.copy(age = 45) // we can reassign some values
  println(jim3) // Person(Jim, 45)

  // 5. CCs have companion objects
  val thePerson = Person // valid definition Person is the companion object of case class Person
  val mary = Person("Mary", 23) // call the apply method of companion object Person
  // when we instantiate case classes we usually don't use the 'new' keyword.
  // We call the built in companion object apply method

  // 6. CCs are serializable
  // Akka

  // 7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }
  // case objects work the same as case classes except they don't have companion objects built in
  // they are the companion object themselves

  /*
    Expand MyList - use case classes and case objects
   */
}
