package week.one.extra

object ScalaBasics extends App {
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
