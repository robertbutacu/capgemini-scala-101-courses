package week.two.extra


sealed trait MyList[A] {
  def exists(f: A => Boolean): Boolean = {
    this match { // starts up case match
      case e: Empty[A] => false
      case h: Head[A] => f(h.elem) || h.tail.exists(f)
    }
  }

  def notExists(f: A => Boolean): Boolean = {
    this match {
      case e: Empty[A] => true
      case h: Head[A] => !f(h.elem) && h.tail.notExists(f)
    }
  }

  def forAll(f: A => Boolean): Boolean = {
    this match {
      case e: Empty[A] => true
      case h: Head[A] => f(h.elem) && h.tail.exists(f)
    }
  }
  def ++(e: A): MyList[A] = {
    this match {
      case _: Empty[A] => Head(e, Empty())
      case h: Head[A] => Head(h.elem, h.tail.++(e))
    }
  }
  def map[B](f: A => B): MyList[B]= {
    this match {
      case e: Empty[A] => Empty[B]()
      case h: Head[A] => Head(f(h.elem), h.tail.map(f))
    }
  }

  def flatMap[B](f: A => MyList[B]): MyList[B] = {
    this match {
      case e: Empty[A] => Empty[B]()
      case h: Head[A] => {
        f(h.elem) match {
          case _: Empty[A] => h.tail.flatMap(f)
         // case anotherH: Head[A] => anotherH : h.tail.flatMap(f)
        }
      }
    }
  }
  def isEmpty(myList: MyList[A]): Boolean = {
    this match {
      case e: Empty[A] => true
      case h: Head[A]   => false
    }
  }
  def foldLeft[B](startingPoint: B)(f: (B, A) => B): B = {
    this match {
      case e: Empty[B] => startingPoint
      case h: Head[A] => h.tail.foldLeft(f(startingPoint, h.elem))(f)
    }
  }
  def :::(otherList: MyList[A]): MyList[A] = {
    this match {
      case _: Empty[A] => otherList
      case h: Head[A] => Head(h.elem, h.tail.:::(otherList))
    }
  }
  def find(p: (A) => Boolean): Option[A] = {
    this match {
      case e: Empty[A]             => None
      case h: Head[A] if p(h.elem) => Some(h.elem)
      case h: Head[A]              =>  h.tail.find(p)

    }
  }
  def mkString(sep: String): String = {
      def inner(acc: String, remainingList: MyList[A]): String = {
        remainingList match {
          case e: Empty[A]                   => acc
          case h: Head[A] if isEmpty(h.tail) => acc + h.elem
          case h: Head[A]                    => inner(acc+h.elem+sep, h.tail)
        }
      }
    inner("", this)
  }
  def toList(): List[A] = {
    this.foldLeft(List.empty[A])((acc, curr) =>  acc.+:(curr))
  }
  def zipWithIndex: MyList[(A, Int)] = {
    def inner(remainingList: MyList[A], currentIndex: Int, resultSoFar: MyList[(A, Int)]): MyList[(A, Int)] = {
      remainingList match{
        case Empty() => resultSoFar
        case h: Head[A] => inner(h.tail, currentIndex+1, resultSoFar.++((h.elem, currentIndex)))
      }
    }
    inner(this, 0, MyList.empty)
  }


  /*
    I) Model a List as an ADT - a  list can either contain a Head, which contains an element and another list as tail,
    or it can be an empty List.
    List[A] =>
          1. Empty[A]()
          2. Head[A](elem: A, tail: List[A])


    After successfully modelled, that, define the following functions on the ADT:
    1. map      -> a function which has 1 parameter f: A => B, whereby f is applied on all elements of a list

    2. exists   -> a function which has 1 parameter f: A => Boolean
                -> returns true if there exists 1 element for which f returns true
                -> false otherwise

    2. notExists -> a function which has 1 parameter f: A => Boolean
                -> returns true if there is no element for which f returns true
                -> false otherwise

    3. forAll   -> a function with 1 parameter f: A => Boolean
                -> returns true if all elements returns true for f
                -> false otherwise

    4. ++       -> a function with one parameter e: A which adds e to the current List

    5. reverse  -> reverse the current list

    6. zipWithIndex -> the list of A becomes list of (A, Int)
                -> Int represents the current index of the element in the list
no

    9. :::      -> merge two lists together
    7. find     -> function with one parameter e: A where it returns the sublist to e - if it exists.

    8. fromList -> receives a normal Scala List[A] as a parameter and returns it as our custom made List.
    Hint: pattern matching over Scala List
    1 :: 2 :: 3 :: Nil => List(1,2,3)
 */

  /*
   II) Model a Tree as an adt with all the functions as above, included:
   1. BFS
   2. DFS
 */
}
object MyList {
  def lift[A](a: A): MyList[A] = Head(a, Empty())
  def empty[A]: MyList[A] = Empty[A]()
    def fromList[A](list: List[A]): MyList[A] = {
      list.foldLeft(MyList.empty[A])((acc, curr) => acc ++ curr)
    }
}

case class Head[A](elem: A, tail: MyList[A] ) extends MyList[A]

case class Empty[A]() extends MyList[A]
