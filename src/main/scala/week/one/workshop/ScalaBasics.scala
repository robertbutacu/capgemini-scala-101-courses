package week.one.workshop

import week.six.workshop.PlayFramework

object ScalaBasics extends App {

  val playFramework = new PlayFramework()

  //what is a var/val + difference

  val x = 5 + 4

  //type inference

  val y: Double = 5: Int

  //how to declare a function -> brief discussion about currying

  def name(x: Int, asdfa: Double): Unit = ???


  println("asdfas'0")

  //lazy/eager

  lazy val a = 5 + 4

  // object

  object X {
    def x(): String = ???
  }

  X.x()

  //class / case class

  //companion objects

  class X(f: Int)

  val u = new X(5)

  case class X2(f: Int, f3: Int) {
  }

  object X2 {

    def f2(x2: X2): String = ???
  }

  val v = X2(5, 4)
  val z = X2(5, 4)
  val q = X2(6, 5)

  println(v == q)
  println(v == z)

  //trait / abstract class

  trait B {
    def h(): Unit = ???
  }
  trait C {
    def h(): Unit = ???
  }

  //extends, with
  //sealed

  sealed trait UB extends B with C {
    val x: Int = ???
    def f(): Unit = ???
    def g(): Unit = {???}
  }

  case class A() extends UB

  //imports

  //sbt clean compile, sbt test, talk about build file
}
