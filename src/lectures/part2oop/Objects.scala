package lectures.part2oop

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  /*
    If we want to use both static and class level functionality in Scala we
    create an Object, not a class
   */
  object Person { // type + its only instance (singleton) by definition
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method - we call the constructor of the class with the same name to build a new instance from inside the object
    def apply(mother: Person, father: Person): Person = new Person(s"Child of ${mother.name} and ${father.name}")
  }
  class Person(val name: String) {
    // instance-level functionality
  }

  println(Person.N_EYES) // 2
  println(Person.canFly) // false . we can access class-level 'static' properties because Person is an object

  /*
    COMPANIONS
    A common practice in scala is having an Object and a Class with the same name
    in the same scope. We call this pattern Companions.
    We split the functionality between the two
    Object will provide class level functionality(static)
    Class will provide instance-level functionality
   */

  // Scala object = SINGLETON INSTANCE
  val person1 = Person
  val person2 = Person
  println(person1 == person2) // true Person is its own ONLY instance of the object Person

  val mary = new Person("Mary") // instance of the class Person
  val john = new Person("John")
  println(mary == john) // false

  val bobbie = Person(mary, john) // we can always call the apply method directly with Object()
  println(bobbie.name) // Child of Mary and John

  /*
    Scala Applications = Scala object with
    def main(args: Array[String]): Unit
    by extending App we inherit the main method and can run the application
    we could also add the exact signature of the main method to our object
    without extending App
   */
}
