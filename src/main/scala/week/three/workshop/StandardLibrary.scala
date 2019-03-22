package week.three.workshop

import scala.util.Random

object StandardLibrary extends App {
  /*
  List vs Set =>
  - unstructured, irrelevant number of elements -> List
  - structured, unique elements                 -> Set
    */

  println((0 to 100).map(_ => Random.nextInt(5)).toSet)
  println((0 to 100).map(_ => Random.nextInt(5)).toList)

  /*
  Tree[A] -> List[Tree], A
   */

  type Id = String
  case class UserDetails(password: String)
  case class Map(store: List[(Id, List[UserDetails])]) {
    def put(id: Id, userDetails: UserDetails): Map = {
      store.find(_._1 == id) match {
        case None => Map(store :+ (id, List(userDetails)))
        case Some(v: (Id, List[UserDetails])) => ???
      }
    }

    def get(id: Id): Option[UserDetails] = {
      store.find(e => e._1 == id).flatMap(e => e._2.lastOption)
    }

    def getWholeHistory(id: Id): Option[List[UserDetails]] = {
      store.find(e => e._1 == id).map(_._2)
    }
  }

  /*
  The main advantage of Maps is that the lookup is done in O(1)
  instead of O(n) like is the case for lists.
   */


}
