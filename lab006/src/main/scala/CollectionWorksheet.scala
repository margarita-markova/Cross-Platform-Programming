

object CollectionWorksheet {

  def reverse(s: String) : String =
    (for(i <- s.length until 0 by -1) yield s(i-1)).mkString
  //equal: for (int i = s.length; i == 0; i+=-1) { s(i-1)).mkString }
  //mkString каждый цикл добавляет новый символ в уже преобразованную строку последовательности

  def reverseCollection(vect: Vector[String]) : Vector[String]=
    {
      vect.map(reverse)
    }



  def append[A](xs: List[A], ys: List[A]): List[A] = xs.foldRight(ys)(_ :: _)

  def flatten[A](xs: List[List[A]]): List[A] = xs.fold(List.empty[A])(append)



  def toOptInt(s: String): Option[Int] = {
    try {
      Some(s.toInt)
    } catch {
      case e: Exception => None
    }
  }

  def toInt(o: Option[Int]) : Int = {
    o match {
      case Some(x: Int) => x
      case _ => Int.MinValue
    }
  }

  def findInt(list: List[String]) : List[Int] =
    {
      list.map(toOptInt).filter((i: Option[Int]) => i.isDefined).map(toInt)
    }
}
