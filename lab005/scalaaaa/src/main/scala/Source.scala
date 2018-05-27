object Source {
  def main(args: Array[String]) {
    val array = Array(45,12,65,2,300)
    val list = List(45,12,65,2,300)


    println(Average.averageWithLoop(array))
    println(Average.averageWithTailRec(array))

    println(Extremum.extremumNotTail(list))
    println(Extremum.extremumTailRec(list))
  }
}
