import scala.collection.immutable

object dividerElements {

 def isNonPrimeNonComplicated(num: Double) : Boolean = {
   (num).<(2)
   }

  def isPrime(num: Double) : Boolean = ! ((2 until num.toInt - 1) exists (num % _ == 0))

  def dividerInt(num: Double) : Double =
  {
    val prime = isPrime(num)
    val negative = isNonPrimeNonComplicated(num)
    val result = true

    result match
      {
      case `negative` => num.toDouble
      case `prime` => num / 2
      case _ => num / 3
      }
    }

  def resultElementsDivider(list: List[Double]) : List[Double] =
  {
    list.map(dividerInt)
  }
}
