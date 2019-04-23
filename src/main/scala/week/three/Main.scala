package week.three

object Exercises extends App {
  trait Monoid[A] {
    def id: A
    def combine(a1: A, a2: A): A
  }

  def stringSemigroup = new Monoid[String] {
    override def id: String = ""
    override def combine(a1: String, a2: String): String = a1 + a2
  }

  def intSemigroup = new Monoid[Int] {
    override def id: Int = 0
    override def combine(a1: Int, a2: Int): Int = a1 + a2
  }

  def sum[A](list: List[A], monoid: Monoid[A]) = {
    list.foldLeft(monoid.id)((acc, curr) => monoid.combine(acc, curr))
  }

  def standardDeviation(list: List[Double]): Double = {
    val listMean = mean(list)
    val difference = list.map(elem => Math.pow(elem - listMean, 2))
    val varience = mean(difference)
    Math.sqrt(varience)
  }

  def mean(list: List[Double]): Double = {
    list.sum / list.size
  }

  def standardPerformanceTestsDeviation(lists: List[List[Double]]): Double = {
    standardDeviation(lists.map(performanceTest => standardDeviation(performanceTest)))
  }

  def performanceTestsMeans(lists: List[List[Double]]): Double = {
    mean(lists.map(performanceTest => mean(performanceTest)))
  }

  type StandardDeviation = Double
  type Mean              = Double

  def report(lists: List[List[Double]]): (StandardDeviation, Mean) = {
    (standardPerformanceTestsDeviation(lists), performanceTestsMeans(lists))
  }
}
