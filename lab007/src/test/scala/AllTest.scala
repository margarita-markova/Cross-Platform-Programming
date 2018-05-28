import org.scalatest.FunSuite

class AllTest extends FunSuite{

  test("Divider.div") {
    assert(dividerElements.resultElementsDivider(List(-5, 1.4, 1.999998, 2.0, -11.88, 0)) === List(-5.0, 1.4, 1.999998, 1.0, -11.88, 0.0))
    assert(dividerElements.resultElementsDivider(List(7, 17, 3, 2.0, -11.99, 0.3333)) === List(3.5, 8.5, 1.5, 1.0, -11.99, 0.3333))
    assert(dividerElements.resultElementsDivider(List(33, 9, 27, 18)) === List(11.0, 3.0, 9.0, 6.0))
  }

  test("Browser matching Explorer error"){
    val os = new Windows
    if (os.browser == "Internet Explorer") assert(os.getLink() == "ERROR")
    else assert(os.getLink() == "https//download_link.?php")
  }

  test("MacOS and Linus getting link"){
    val os = new MacOS
    val os1 = new Linux
    assert(os.link == "https//download_link.?php" && os1.link == "https//download_link.?php")
  }
}