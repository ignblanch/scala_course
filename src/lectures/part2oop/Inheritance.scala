package lectures.part2oop

object Inheritance extends App {
  // single class inheritance
  sealed class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch // nomnom crunch crunch
  /*
  Animal is a superclass of cat. Cat is a subclass of animal
  We can have modifiers in properties and methods
  private - only accessible by the class
  protected - only accessible by class and subclasses
   */


  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0) // auxiliary constructor
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name) // here we call the aux constructor with just 1 param

  // overriding. We can override fields directly in the constructor or in the definition
  class Dog(override val creatureType: String) extends Animal {
    //    override val creatureType = "domestic"
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }
  val dog = new Dog("K9")
  dog.eat // in the dog class eat is not protected // crunch crunch
  println(dog.creatureType) // K9


  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat // crunch crunch (although declared an Animal it's an instance of Dog)

  // overRIDING vs overLOADING

  // super - refers to the parent class

  // preventing overrides
  // 1 - use final on member - prevents subclasses from overriding the member
  // 2 - use final on the entire class - prevents the class from being extended
  // 3 - seal the class = extend classes in THIS FILE, prevent extension in other files (sealed class Animal)
}
