package week.five.workshop

import scala.language.implicitConversions
import scala.concurrent.ExecutionContext.Implicits.global

object Implicits extends App {
  def f1[A](a: A)(implicit logger: (A, String) => Unit) = {
    f2(a)
    f3(a)
    f4(a)
    f5(a)

    a
  }

  def f2[A](a: A)(implicit logger: (A, String) => Unit) = {
    logger(a, "f2")
  }
  def f3[A](a: A)(implicit logger: (A, String) => Unit) = {
    logger(a, "f3")
  }
  def f4[A](a: A)(implicit logger: (A, String) => Unit) = {
    logger(a, "f4")
  }
  def f5[A](a: A)(implicit logger: (A, String) => Unit) = {
    logger(a, "f5")
  }

  implicit def toInt(s: Int) : String = {
    s.toString
  }

  def func(i: String): Unit = {
    println(i)
  }

  func(123)

  implicit val logger: (Int, String) => Unit = { (x: Int, scope: String) => println(s"Logging from $scope: Logged $x") }

  f1(5)

  for {
    _ <- Futures.f1()
    _ <- Futures.f2(3)
    _ <- Futures.f3("asd")
  } yield ()

  Thread.sleep(1000000)
}
