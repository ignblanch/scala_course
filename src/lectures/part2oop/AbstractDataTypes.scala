package lectures.part2oop

object AbstractDataTypes extends App {

  /*
  Abstract classes
  Abstract members are not implemented just defined
  They cannot be instantiated. Only the subclasses. They are supposed to be extended
  Abstract classes can have both abstract and non abstract members
   */
  abstract class Animal {
    val creatureType: String = "wild" // non abstract member
    def eat: Unit // abstract method
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine" // we must add override keyword for non abstract property
    def eat: Unit = println("crunch crunch") // this is an override but the keyword override is not necessary for abstract method
  }

  /*
   Traits
   they have abstract fields and methods. They can also have non abstract members
   They can be inherited together with classes using the keyword with
   we can add as many traits as we want
   */
  trait Carnivore {
    def eat(animal: Animal): Unit // abstract method
    val preferredMeal: String = "fresh meat" // non abstract member
  }

  trait ColdBlooded
  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog) // I'm a croc and I'm eating Canine

  // traits vs abstract classes
  // 1 - traits do not have constructor parameters
  // 2 - multiple traits may be  inherited by the same class
  // 3 - traits = behavior, abstract class = "thing"
}
