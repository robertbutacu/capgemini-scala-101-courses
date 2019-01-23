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

  def fone(): String = "Im took out coffe"
  def ftwo(s: String) = s + "\n Im putting in the machine"
  def fthree(s: String) = s + "\n Im brewing the coffee"
  def ffour(s: String) = s + "\n Im drinking coffee"


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


  // why is this relevant
  // testing, accuracy, stable
}
