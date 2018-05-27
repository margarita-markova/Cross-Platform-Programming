import scala.annotation.tailrec

object Average {

  def averageWithTailRec(array: Array[Int]): Int =
    if (array.length == 1) array(0)
    else averageIter(0, 0, array)

  @tailrec private def averageIter(count: Int, elem: Int, array: Array[Int]): Int =
    if (elem == array.length) (count / elem)
    else averageIter(count + array(elem), elem + 1, array)

  def averageWithLoop(array: Array[Int]): Int = {
    if (array.length == 1) array(0)
    var count = 0
    var elem = 0
    while ( {elem != array.length}) {
      count += array(elem)
      elem += 1
    }
    count / elem
  }
}
