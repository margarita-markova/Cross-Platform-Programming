import scala.annotation.tailrec

object Extremum {

  def extremumNotTail(list: List[Int]): Tuple2[Int, Int]  =
  {
    val min = list.min
    val max = list.max
    (min, max)
  }

  def extremumTailRec(list: List[Int]) : Tuple2[Int, Int]  =
  {
    if (list.size == 2) (list.head, list.last)
    else extrIter(list.head, list.last, 0, list)
  }

  @tailrec private def extrIter(min: Int, max: Int, elem: Int, list: List[Int]): Tuple2[Int, Int] =
    if (elem == list.size) (min,max)
    else
      {
        if (max < list(elem))
          extrIter(min, list(elem), elem + 1, list)
        else {
          if(min > list(elem))
            extrIter(list(elem), max, elem + 1, list)
          else
          extrIter(min, max, elem + 1, list)
        }
      }
}
