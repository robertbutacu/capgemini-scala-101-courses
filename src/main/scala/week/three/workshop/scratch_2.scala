import week.two.workshop.FunctionalPrinciples.MyTrafficLight

val x = List(1, 2)
val y = List(3, 4)
val a = List(1,1,1,1,2,2,2,2,3,3,3,5,6,5,7)
val b = List("This ", "Is ", "A ", "Test.")
val addElemLast = 6 +: x // :+ Adds an element to the front of the list
val colonAddTest = 6 :: x // :: performs in the same way as +:
val addElem = x :+ 6 // :+ Adds an element to the end of the list
val comboTest = x ::: y //`:::` essentially takes a list and outputs the two lists merged together
val foldRight = (x :\ 2)(_+_) // :\ takes a list and performs some form of operator on each element, from the right (The last value in the list), also taking a starting point as an input.
val foldLeft = (5 /: x)(_+_) // /: performs the same way as :\ but it starts from the left (the first value) instead of the right.
val containsTest = x.contains(2) // Checks each element in the list in comparison to the input for the contains function. outputs a boolean.
val countTest = x.count(elem => elem <= 1) // takes a function as an input that outputs a boolean. for each element that returns true, it adds 1 to the end Int it returns.
val distinctTest = a.distinct // Outputs a list without any duplicate elements.
val dropTest = a.drop(5) // outputs a list with the first x elements removed.
val dropWhileTest = a.dropWhile(elem => elem <= 2) // drops each element that returns true for the function. outputs new list
val existsTest = x.exists(elem => elem > 1) // has a function as input that outputs a boolean run against every element in the list. If at least one element returns true, then the output of exists returns true.
val filterTest = a.filter(elem => elem > 2) // outputs a list that includes every element that returned true when run through the inner function.
val filterNotTest = x.filterNot(elem => elem > 1) // outputs a list that includes every element that returned false when run through the inner function.
val findTest = y.find(elem => elem == 4) // returns the first element that returns true when run through the inner function as an option. Or else it returns None.
val flatMapTest = x.flatMap(elem => elem.toString) // takes a function and applies it to every element in a collection, then output's that collection
val flattenTest = List(x, y).flatten // performs similar to fold that it takes in multiple nested collections and flattens them into one.
val foldTest = b.fold("")((start, elem) => start+elem) // Takes a starting point and merges each element into that starting point, outputting the result of each element merged with the start.
val foldLeftTest = a.foldLeft("")((start, elem) => elem + " " + start) // unlike fold, foldLeft/Right enables you the output to be a different type then the collection.
val foldRightTest = a.foldRight("")((elem, start) => elem + " " + start) /// unlike fold, foldLeft/Right enables you the output to be a different type then the collection.
val forAllTest = x.forall(elem => elem > 0) // runs each element as the input through the inner function that outputs a boolean. If the boolean returns true for every element, the forAll function returns true.
val forEachTest = x.foreach(elem => println(elem+1)) // runs a function against each element in the collection. output is Unit, so this will only cause sideaffects.
val groupByTest = x.groupBy(x => x-1) // takes each element and places them into a Map that contains a key and a List. enables you to split elements up into multiple lists within a map.
val indexOfTest = a.indexOf(2) // compares each element to the function parameter value. for each value that returns true to matching, it adds one to the end int it returns. If none of the elements match it returns -1.
val indexWhereTest = a.indexWhere(elem => elem+1>5) // has an inner function that outputs a boolean value. The first element that returns true, it returns the position of that element in the collection as an Int as the output.
val indexWhereSpecifyTest = a.indexWhere(elem => elem+1>5, 5) // has an inner function that outputs a boolean value. The first element that returns true, it returns the position of that element in the collection as an Int as the output.
val mapFunctionTest = a.map(elem => elem+1) // applies a function to each element in a collection and returns a new collection containing the output of each function.
val maxByTest = a.maxBy(elem => elem)
val reverseTest = x.reverse
val sumTest = x.sum
sealed trait TrafficLight{
  def f(): String = {
    this match{
      case Red    => "Red light!"
      case Yellow => "Yellow Light!"
      case Green  => "Green light!"
      case _      => "Unknown state"
    }
  }
}
case object Red extends TrafficLight
case object Yellow extends TrafficLight
case object Green extends TrafficLight
case object test extends TrafficLight
val mapTest = Map("Witchell" -> "Password", "Witchell96" -> "Passw0rd")
Yellow.f()
test.f()
