class Windows extends OperatingSystem {

  val browser : String =
    (Math.random()*5).toInt match {
      case 1 => "Google Chrome"
      case 2 => "Opera"
      case 3 => "Internet Explorer"
      case 4 => "Microsoft Edge"
      case 5 => "Mozilla Firefox"
    }

  def getLink ():String = {
    browser match {
      case ("Internet Explorer") => "ERROR"
      case _=> getDownloadLink()
    }
  }
}