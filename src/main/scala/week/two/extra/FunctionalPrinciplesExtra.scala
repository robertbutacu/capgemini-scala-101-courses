package week.two.extra

object FunctionalPrinciplesExtra {
  // Super important:
  /*
      Initially, try to make all the functions recursive without worrying about tail call optimization.
      After successfully implemented, transform them to be tail call optimized.
   */


  /*
      I) Model a List as an ADT - a list can either contain a Head, which contains an element and another list as tail,
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

      7. find     -> function with one parameter e: A where it returns the sublist to e - if it exists.

      8. fromList -> receives a normal Scala List[A] as a parameter and returns it as our custom made List.
   */

  /*
     II) Super extra - model a Tree as an adt with all the functions as above, included:
     1. BFS
     2. DFS
   */
}
