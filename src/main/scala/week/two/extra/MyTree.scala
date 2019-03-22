package week.two.extra

import week.two.{Empty, MyList}

sealed trait MyTree[A] {
  def map[B](f: A => B): MyTree[B]= {
    this match {
      case e: EmptyLeaf[A] => EmptyLeaf[B]()
      case h: Branch[A] => Branch(h.left.map(f), h.right.map(f), f(h.value))
    }
  }
  def exists(f: A => Boolean): Boolean = {
    this match {
      case e: EmptyLeaf[A] => false
      case h: Branch[A] => f(h.value) || h.right.exists(f) || h.left.exists(f)
    }
  }
  def forAll(f: A => Boolean): Boolean = {
    this match {
      case e: EmptyLeaf[A] => true
      case h: Branch[A] => f(h.value) && h.right.forAll(f) && h.left.forAll(f)
    }
  }
  def toMyList(): MyList[A] ={
    this match {
      case e: EmptyLeaf[A] => Empty[A]()
      case h: Branch[A] => h.left.toMyList() ::: MyList.lift(h.value) ::: h.right.toMyList()
    }
  }
}
case class Branch[A](left: MyTree[A], right: MyTree[A], value: A) extends MyTree[A]
case class EmptyLeaf[A]() extends MyTree[A]

