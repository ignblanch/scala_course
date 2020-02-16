package lectures.part2oop

object Generics extends App {

  /*
    We use it with classes and methods when we want to be able to use them with any type we pass
    We specify a generic type by adding [A] usually a single letter.
    The type we pass will then be used in the class
    This poses a problem: variance problem. What happens when we pass a type that is a subtype or supertype
    There are three possible ways to deal with it. COVARIANCE, INVARIANCE, CONTRAVARIANCE
    Bounded types refer to specifying the type as a supertype B >: A or subtype B <: A.
   */
  class MyList[+A] {
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???
    /*
      A = Cat
      B = Animal - supertype of cat
     */
  }

  // we can specify the type with square brackets
  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // We can specify multiple types
  class MyMap[Key, Value]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes, List[Cat] extends List[Animal] = COVARIANCE
  // we indicate it by adding + sign to the type
  // we can create lists of cats for type animal Cats are animals
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? HARD QUESTION => we return a list of Animals

  // 2. NO = INVARIANCE
  // list of cats and list of animals are totally separate lists
  // only accepts the type specified no inherited types
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no! CONTRAVARIANCE
  // we indicate it with a - sign
  // we can create lists of animals for type cat animals are more general than cats
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  // class is restricted to subtypes of animal
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  // we could also restrict to supertypes with [A >:Animal]
  class BoundedClass[A >: Animal](animal: A)
  val myCat = new BoundedClass(new Cat)

  class Car
  // generic type needs proper bounded type
  //  val newCage = new Cage(new Car)
}
