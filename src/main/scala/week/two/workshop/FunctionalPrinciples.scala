package week.two.workshop


object FunctionalPrinciples extends App {
  // immutability

  // pureness + referential transparency

  // what implies to be pure ?
  // what implies to be referential transparent ?
  // function which is impure
  //transform it so it is pure => simple division after asking for input from user

  def add(a: Int, b: Int) = a + b

  def division(a: Int, b: Int) = a / b
  def division2(a: Int, b: Int): Option[Int] = {
    if(b==0) {
      None
    } else {
      Some(a/b)
    }
  }

  Some(Yellow)

  // explain what functions are in scala

  // brewing coffee example
  // 3 functions which take 1 string and return a string
  // compose them

  //for function composition, define functions which return other functions
  // using andThen pipelines the output of the first function to the input of the next function
  def computationOne= (x: Int) =>  x + 5
  def computationTwo = (s: Int) => s + 10
  def computationThree = (s: Int) => s * 15
  def computationFour = (s: Int) => s / 2

  val bigComputation = computationOne andThen computationTwo andThen computationThree andThen computationFour

  println(bigComputation(19))
  // ADTs - algebraic data type
  // examples => traffic signaling light
  // pattern matching on the previous ADT

  sealed trait Option2 {
    def wrap(x: Int) = {
      if(x >= 0) Some(x)
      else None
    }
  }

  case class Some2(x: Int) extends Option2
  case object None2 extends Option2

  sealed trait List
  case class Head(h: Int, tail: List) extends List
  case object EmptyList extends List


  sealed trait TrafficLight {
    def f(): String = {
      this match {
        case Red => "red"
        case Green => "green"
        case Yellow => "yellow"
        case MyTrafficLight => "MyTrafficLight"
      }
    }
  }

  case object Red extends TrafficLight
  case object Yellow extends TrafficLight
  case object Green extends TrafficLight
  case object MyTrafficLight extends TrafficLight


  MyTrafficLight.f()

  // problems with that
  // @tailrec and memoization

  // higher order functions
  // examples
  def executeFunction[A, B](input: Option[A], f: (A,A) => B): Option[B] = input.map(e => f(e, e))


  // types - generics and relevance
  // function which takes Int, Double, Float and returns String
  // make it generics
  println(executeFunction[Int, String](Some(3), {
    (e: Int, g: Int) =>
      e.toString + g.toString
  }))

  println(executeFunction[String, String](Some("3"), {
    (e: String, g: String) =>
      e + g
  }))

  Some(3).map{e => e.toString}

  // recursiveness + @tailrec
  // modelling every iterative problem as a recursive one
  // function which takes Int and returns a list with elements up to that int

  /**
    * By nature, iteration in programming involves side effects:
    *   For example, for(i = 0; i <= n; i++) {...}
    *   I is mutable: furthermore, iteration itself hints towards side-effects being performed in the body.
    *   Examples: modifying a list.
    *
    * In order to avoid this, in functional programming, this is usually done with the help of recursion.
    * Recursion, on a basic mathematical form, is represented by 2 or more forms:
    *   1. the base case - when should the recursion stop?
    *   2. other cases where computation happen - most of the time, it's only 1 step which represents the actual computation.
    *
    * I won't even be writing any iterations in Scala, since I don't know how, but I will show you how to write recursive functions.
    * 2 problems will be solved: factorial, and fibonacci sequence.
    */

  def factorial(n: Int): Int = {
    // base case
    if(n == 0) 1
    /** computation happening: formula for factorial is f(n) = n * f(n-1) * f(n-2) ... f(0)
      * In our code, n represents the actual n, while factorial(n - 1) represents the rest of the result ie f(n-1) * f(n-2) ... f(0)
    */
    else n * factorial(n - 1)
  }


  /**
    Fibonacci is an interesting case where there are 2 base cases, but there's nothing difficult about it.
   */
  def fibonnaci(n: Int): Int = {
    n match {
      case 0 => 1 // base case
      case 1 => 1 // base case
      case e => fibonnaci(e - 1) + fibonnaci(e - 2) // formula for fibonnaci(n) = fibonacci(n-1) + fibonacci(n-2)
    }
  }

  /**
    * Beauty about recursiveness is the fact that it goes relatively close to the mathematical representation.
    *
    * An edge case of recursiveness and more importantly, performance optimization, is the fact that all these calls
    * fill the stack with intermediary calls which could overflow and break the program.
    * Fortunately, there is one technique to avoid this - and that is tail call elimination done through memoization.
    * In Scala, this is done through @tailrec - we will talk more about this next week.
    * For now, the explanation should be enough to solve the exercises.
    */

  // why is this relevant
  // testing, accuracy, stable
}
