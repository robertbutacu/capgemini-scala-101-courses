import week.two.extra._

object Main extends App {

  // Super important:
  /*
      Initially, try to make all the functions recursive without worrying about tail call optimization.
      After successfully implemented, transform them to be tail call optimized.
   */
//String => String => Boolean
  def stringTest(s: String)(other: String): Boolean = s.contains("et")


  def apply[A](a: A): Option[A] = Option(a)

  def flatMap[A, B](maybe: Option[A])(f: A => Option[B]): Option[B] = {
    maybe match {
      case None => None
      case Some(x) => f(x)
    }
  }
  val treeTest = Branch(EmptyLeaf(), Branch(EmptyLeaf(), EmptyLeaf(), 50), 25)
  val test = Head("Something", Head("something Else", Empty[String]()))
  val test2 = Head(1, Head(5, Head(12, Empty())))
  val test3 = test2.map{
    x => s"Today I ate ${x} cookies"
  }
  val test4 = test2.++(5)
  val forComp = Head(1, Head(3, Head(5, Head(7, Head(9, Head(11, Empty()))))))

  println(test.exists(x => x=="Test"))
  println(test.exists(x => x.contains("et")))
  println(test.exists(x => stringTest("asdasd")(x)))
  println(test.exists(stringTest("@@")))
  println(treeTest.exists(i => i%2==0))
  println(treeTest.map(i => i*100))
  println(treeTest.toMyList())

  val forComp1 = for {
    a <- forComp.find(x => x==1)
    b <- forComp.find(x => x==3)
    c <- forComp.find(x => x==5)
  } yield a+b+c

  val forComp2 = for {
    a <- forComp.find(x => x==1)
    b <- forComp.find(x => x==2)
    c <- forComp.find(x => x==3)
  } yield a+b+c

  val partiallyAppliedFunction: String => Boolean = stringTest("x") //Anonymous function example
  println(partiallyAppliedFunction)
  println(partiallyAppliedFunction("x"))
  println(test3)
  println(test4.++(5))
  println(test2.foldLeft(0)((accumalator, current) => accumalator+current))


  case class Person(name: String = "", firstname: String = "", age: Int)

  val people = List(Person(age = 15), Person(age = 20), Person(age = 40))

  println(people.foldLeft(0)((acc, cur) => acc+cur.age))
  println(people.foldLeft(0){
    (acc, cur) =>
      if(cur.age>18)acc+cur.age
      else acc

  })

  println(forComp1)
  println(forComp2)

  println(test.mkString(", "))

  val tx = List(1, 2, 3)

}


