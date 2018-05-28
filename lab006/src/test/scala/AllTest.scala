import org.scalatest.FunSuite

class AllTest extends FunSuite{
  test("ReverseCollection.reverse") {
    assert(CollectionWorksheet.reverseCollection(Vector("yellp", "miu", "key")) === Vector("plley", "uim", "yek"))
    assert(CollectionWorksheet.reverseCollection(Vector("palindrom", "time", "New York")) === Vector("mordnilap", "emit", "kroY weN"))
    assert(CollectionWorksheet.reverseCollection(Vector("HELL YEAH", "1234 nkb33 88n", "6789")) === Vector("HAEY LLEH", "n88 33bkn 4321", "9876"))
  }

  test("FlattenCollection.flatten") {
    assert(CollectionWorksheet.flatten(List(List(1,2,3,4), List(2,4,6,7), List(5,6,7,9))) === List(1, 2, 3, 4, 2, 4, 6, 7, 5, 6, 7, 9))
    assert(CollectionWorksheet.flatten(List(List(1,2), List(2,4), List(5,6), List(10000, 66), List("Vasya", "Cat")))
      === List(1, 2, 2, 4, 5, 6, 10000, 66, "Vasya", "Cat"))
    assert(CollectionWorksheet.flatten(List(List("llll"), List("jjjj", "kate"), List(5,6,7,9)))
      === List("llll", "jjjj", "kate", 5, 6, 7, 9))
  }

  test("FindInt.findint") {
    assert(CollectionWorksheet.findInt(List("forever", "young", "-9", "55", "forever", "drunk")) === List(-9, 55))
    assert(CollectionWorksheet.findInt(List("INSIDE", "10000000", "-100", "85")) === List(10000000, -100, 85))
    assert(CollectionWorksheet.findInt(List("8855ffgnv7", "9h", "8u", "n9n", "33")) === List(33))
  }
}
