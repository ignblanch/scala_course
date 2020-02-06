package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 26) // instantiation
  /*
  class parameters are NOT MEMBER FIELDS
  we cannot access directly a class parameter ex: person.name (would throw an error)
  If we want a parameter to be accessible as a member field we have to add the keyword val to the constructor declaration
  ex: person.age is ok because in the constructor we have val age: Int
  We can access class parameters INSIDE the class with the this keyword ex. this.name
  We can also add default values for parameters and then we don't pass it to the constructor
   */
  println(person.x) // 2
  person.greet("Daniel") // John says: Hi, Daniel
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val impostor = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge) // 49
  println(novel.isWrittenBy(author)) // true
  println(novel.isWrittenBy(impostor)) // false - author and impostor have the same values but they are different instances

  val counter = new Counter
  counter.inc.print // incrementing 1
  counter.inc.inc.inc.print // incrementing incrementing incrementing 3. This is the same as counter.inc(3).print
  counter.inc(10).print // incrementing incrementing..(10 times) 10
}

// constructor
class Person(name: String, val age: Int = 0) {
  // body
  val x = 2 // fields

  println(1 + 3) // instruction will be executed in each instantiation

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  // we use this.name so that the compiler does not consider it the param of the method also called name
  // however to acces fields inside the class we do not need the this keyword if there is no confusion

  // overloading
  def greet(): Unit = println(s"Hi, I am $name") // same function name but with different parameters signature

  /*
  Multiple constructors
  They can only call the primary constructor
  They can be used for default parameters, but we can also specify them in the primary constructor
  val age: Int = 0 will set the default value of the age param to 0
  So in practice auxiliary constructors are not that useful
  */
  def this(name: String) = this(name, 0) // this would not be necessary if we already have a default value
  def this() = this("John Doe") // constructor with no params would set the value of name 'John Doe' and the default value of age 0
}

/*
  Exercises:
  Implement Novel and Writer classes
  Writer: first name, surname, year
    - method fullname
  Novel: name, year of release, author
  - authorAge
  - isWrittenBy(author)
  - copy (new year of release) = new instance of Novel
 */

class Writer(firstName: String, surname: String, val yearOfBirth: Int) {
  def fullName: String = firstName + " " + surname
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge = year - author.yearOfBirth // we can access author.year because it is declared with val in the Writer constructor thus becoming a field
  def isWrittenBy(author: Writer): Boolean = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

/*
  Counter class
    - receives an int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount
 */
class Counter(val count: Int = 0) {
  def inc = {
    println("incrementing")
    new Counter(count + 1)  // IMMUTABILITY. We do not reassign the value to count, but rather return a whole new instance
                            // instances are fixed, they do not get modified inside
  }

  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  // oveloaded methods
  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n-1) // inc returns an instance of counter so we call the inc method of that returned instance
  }

  def dec(n: Int): Counter =
    if (n <= 0) this
    else dec.dec(n-1)

  def print = println(count)
}
