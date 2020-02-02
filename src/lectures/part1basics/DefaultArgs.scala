package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {
  @tailrec
  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n-1, n*acc)

  val fact09 = trFact(9) // acc param value will be the default: 1
  val fact10 = trFact(10, 2) // we can pass acc param if we want


  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")
  savePicture() // the compiler will apply all default arguments
  // savePicture(800) the compiler won't know which arg it is. I'll assume it's the first
  savePicture("bmp") // that's ok because it's the leading arg. The rest will get the default value
  // NAMED ARGUMENTS
  savePicture(width = 800) // we can name the argument and the rest will get default values

  /*
    1. pass in every leading argument
    2. name the arguments
   */

  // if we name the arguments we can pass them in different order than the function declaration
  savePicture(height = 600, width = 800, format = "bmp")


}
