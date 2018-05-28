
object Main {

  def main(args: Array[String]) {

    val words = Vector("blabla", "tell me", "wow", "scala", "labs", "my english is very well")

    //перевернуть все слова в коллекции, оставив неизменным их порядок
    println(CollectionWorksheet.reverseCollection(words))

    //используя fold, реализовать flatten, которая конкатенирует список списков
    println(CollectionWorksheet.flatten(List(List(1,2,3,4), List(2,4,6,7), List(5,6,7,9))))

    //на основе List[String] сгенеировать List[Int], ex: List("1", "bb", "-9", "++") -> List(1, -9)
    //используя map/flatMap/filter/reduce
    println(CollectionWorksheet.findInt(List("vvv", "=_", "-9", "55", "nnn")))
  }

}
