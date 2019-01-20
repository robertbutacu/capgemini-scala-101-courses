package week.one.extra

import java.util.Calendar

object ScalaBasics extends App {
  //Exercise 1
/*  lazy val currentTime = Calendar.getInstance().getTime()
  println(Calendar.getInstance().getTime())
  Thread.sleep(3000)
  println(currentTime)
  Thread.sleep(3000)
  def callCurrentTime() = Calendar.getInstance().getTime()
  println(callCurrentTime)
  Thread.sleep(3000)
  println(currentTime)
  Thread.sleep(3000)
  println(callCurrentTime)*/

  //EXERCISE TWO
  trait Addable {
    def addAll(): Int
  }
case class CaseClassOne(x: Int, y: Int) extends Addable {
  override def addAll(): Int = {
    val result = x + y
    result
  }

}
case class CaseClassTwo(x: Int, y: Int, j: Int) extends Addable{
  override def addAll(): Int = {
    val result = x + y + j
    result
  }
}
  val InstanceOne = CaseClassOne(5, 20)
  val InstanceTwo = CaseClassTwo(30,20,1)
  val InstanceOneSister = CaseClassOne(5,20)
  println(InstanceOne.addAll())
  println(InstanceTwo.addAll())
  println(InstanceOne == InstanceOneSister)

class RegClass(x: Int, y: Int) extends Addable{
  override def addAll(): Int = {
    val result = x + y
    result
  }
}
  val regInstance =  new RegClass(10,30)
  val regInstanceSister = new RegClass(10,30)
  println(regInstance == regInstanceSister)
  println(regInstance.hashCode())
  println(regInstanceSister.hashCode())
  println(InstanceOne.hashCode())
  println(InstanceOneSister.hashCode())
  case class randomCase(){
    def returnString(): String = {
      val returnedString = "Returned string!"
      returnedString
    }
    instanceCaseNew = new randomCase().returnString()
  }
  object randomCase{
    def returnObjectString(): String = {
      val returnedObjectString = "Returned object string!"
      returnedObjectString
    }
    instanceObject = new randomCase().returnString()
  }

  /** Mechanism of lazy and differences between lazy, eager and function

     1. Declare 1 lazy variable which holds the current time.
        after this, print the current time ( hint - its just the call of a function )
        Pause the current thread for 3 seconds. Then print the lazy variable
        observe the differences

     2. Declare a function which takes no parameters and returns the current time.
      Next, call the function and print the result.
      Print the lazy variable again.
      Call the function again and print the result yet one more time.
    */

  /** Polymorphism. Case classes and their crucial importance.
     3. Write a trait Addable which has 1 method - addAll(): Int
     Next, write 2 case classes which extend the trait, and have 2, respectively 3 parameters of type Int.
     Implement the addAll() function for each.
     Have 1 instance of each case class and then print the result of the function call.
    */

  /** Internals of a case class
     4. Instantiate another case class - either one - but with the same parameters as it's sister.
     Print the result of the expression instance1 == instance2.

     Now, create a class with the same number of parameters ( not case class!! simple class )
     Same as before, have 2 instances of the class and print the result of instance1 == instance2.

     Print the hashCode() of each instance.
    */

  /** Companion objects and the difference between method and function
     5. Create a random case class. Add a method which only returns a string ( hard-coded, doesn't matter the value ).
     Add the companion object for this case class and add another function which returns another string.
     Next, try to call the function from the companion object using an instance of the case class
           and the method of the case class using NameOfCompanionObject.myFunc.
     Is that possible?
     What about the other way around?
     Why is this happening?
    */
}
