package lectures.part1basics

object CallByNamevsCallByValue extends App {
  def calledByValue(x: Long): Unit ={
    println("by value: " + x)
    println("by value: " + x)
  }

  // the arrow in the param tells the compiler to call by name
  def calledByName(x: => Long): Unit ={
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime()) // System.nanoTime returns Long with the time in nanoseconds
  calledByName(System.nanoTime())
  /*
  by value: 27650512175807
  by value: 27650512175807
  by name: 27650583342116
  by name: 27650583385409

  In the 'by value' case the param is evaluated at the time of calling the function
  and it uses that value during the whole function execution
  (it is what most programming languages do)

  In the 'by name' function it evaluates the param each time it appears in the code
  It evaluates the param when it needs it (also it won't evaluate it if it does not need it)
  (see example below)
  In the example it evaluates it twice and therefore it changes


  WHEN WE CALL BY VALUE THE PARAM IS AN ACTUAL VALUE - IT DOES NOT CHANGE DURING EXECUTION OF THE FUNCTION
  WHEN WE CALL BY NAME THE PARAM IS AN EXPRESSION - IT GETS EVALUATED EVERY TIME IT IS USED IN THE EXECUTION
  */

  def infinite(): Int = 1 + infinite()
  def printFirstParamByName(x: Int, y: => Int): Unit = println(x) // no crash
  def printFirstParamByValue(x: Int, y: Int): Unit = println(x) // crash

  //printFirstParam(infinite(), 34)  This will crash. It evaluates the first param and crashes
  printFirstParamByName(34, infinite()) // 34. Since the second param is called by name, it does not evaluate it because it does not need it
  //printFirstParamByValue(34, infinite()) // Will also crash. It does not need the second param but it evaluates it as well
}
