package week.four.workshop

import scala.util.{Random, Try}

object Monads extends App {

  /*
      1. Motivation - problem and why?
            Make sure our programs dont get interrupted by errors - no matter, everything runs.

      2. Solution   - how monads fix this
            Dealing with errors without breaking the program.

      3. Different worlds

      4. Monadic design - composing functions which return Monads

      5. Unwrapping
   */

  /*
    Monad:
      1. pure/lift/apply =>
        def pure[F[_], A](a: A): F[A]

      2. map =>
        def map[F[_], A, B](fa: F[A])(f: A => B): F[B]

      3. flatMap =>
        def flatMap[F[_], A, B](fa: F[A])(f: A => F[B]): F[B]
   */


  sealed trait MyException

  case object DivisionByZero      extends MyException
  case class UnexpectedException() extends MyException
  case object IllegalDivision     extends MyException

  def div[A](a: A, b: A)(implicit fractional: Fractional[A]): A = fractional.div(a, b)

  def div2(a: Int, b: Int): Option[Int] = {
    b match {
      case 0 => None
      case 1 => None
      case other => Option(a / other)
    }
  }

  def div3(a: Int, b: Int): Either[MyException, Int] = {
    val random = Random.nextBoolean()

    if(random) Left(UnexpectedException())
    else {
      b match {
        case 0 => Left(DivisionByZero)
        case 1 => Left(IllegalDivision)
        case other => Right(a / other)
      }
    }
  }

  /*
    println(div2(5, 2))
    println(div2(4, 0))
    println(div2(1, 3))
    println(div2(1, 1))


    println(div3(5, 2))
    println(div3(4, 0))
    println(div3(1, 3))
    println(div3(1, 1))
  */

  /*
  Problem divide a number by 1, 2, randomly 0, 3, 4 and 5 and give out the result.
   */

  val n = 100000
  val firstDivide: Option[Int] = div2(n, 2)

  def randomBoolean = Random.nextBoolean()


  val finalResult: Option[Int] =
    firstDivide
      .flatMap(i => div2(i, 2))
      .flatMap { i => if (randomBoolean) div2(i, 0) else Option(i) }
      .flatMap(i => div2(i, 2))
      .flatMap(i => div2(i, 2))

  val finalResult2: Option[Int] = for {
    i1 <- div2(n, 2)
    i2 <- div2(i1, 2)
    i3 <- if (randomBoolean) div2(i2, 0) else Option(i2)
    i4 <- div2(i3, 2)
    i5 <- div2(i4, 2)
  } yield i5


  sealed trait Result
  case class Ok(i: Int)           extends Result
  case object InternalServerError extends Result
  case object BadRequest          extends Result

  def controller(a: Int, b: Int): Result = {
    recoverFromErrorState {
      println("running function")
      div3(a, b)
    }
  }

  def recoverFromErrorState(f: => Either[MyException, Int]): Result = {
    f match {
      case Right(i)  => Ok(i)
      case Left(err) => errorHandling(err)
    }
  }

  def errorHandling(myException: MyException): Result = {
    myException match {
      case _: DivisionByZero.type  => BadRequest
      case _: UnexpectedException  => InternalServerError
      case _: IllegalDivision.type => BadRequest
    }
  }

  println(controller(2, 3))
}
