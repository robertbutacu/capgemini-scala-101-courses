package week.five.workshop

import java.time.Instant

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Random

object Futures {
  def f1()(implicit ec: ExecutionContext): Future[Unit] = Future {
    Thread.sleep(Random.nextInt(10000))
    println(s"[${Instant.now}] f1")
  }
  def f2(int: Int)(implicit ec: ExecutionContext): Future[Unit] = Future {
    Thread.sleep(Random.nextInt(10000))
    print(s"[${Instant.now}]$int")
  }
  def f3(string: String)(implicit ec: ExecutionContext): Future[Unit] = Future {
    Thread.sleep(Random.nextInt(10000))
    print(s"[${Instant.now}] $string")
  }
}
