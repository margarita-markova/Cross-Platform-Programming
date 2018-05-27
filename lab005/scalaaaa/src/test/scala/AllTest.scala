import org.scalatest.FunSuite

class AllTest extends FunSuite{
  test("AverageWithTailRec.average") {
    assert(Average.averageWithTailRec(Array(1, 2, 3, 3)) === 2)
    assert(Average.averageWithTailRec(Array(1)) === 1)
    assert(Average.averageWithTailRec(Array(48, 21, 36, 62)) === 41)
  }

  test("AverageWithLoop.average") {
    assert(Average.averageWithLoop(Array(1, 2, 3, 3)) === 2)
    assert(Average.averageWithLoop(Array(1)) === 1)
    assert(Average.averageWithLoop(Array(48, 21, 36, 62)) === 41)
  }

  test("ExtremumWithTailRec.extremum") {
    assert(Extremum.extremumTailRec(List(1, 2, 3, 3)) === (1,3))
    assert(Extremum.extremumTailRec(List(1,2)) === (1,2))
    assert(Extremum.extremumTailRec(List(48, 21, 36, 62)) === (21,62))
  }

  test("ExtremumWithLoop.extremum") {
    assert(Extremum.extremumNotTail(List(1, 2, 3, 3)) === (1,3))
    assert(Extremum.extremumNotTail(List(1,2)) === (1,2))
    assert(Extremum.extremumNotTail(List(48, 21, 36, 62)) === (21,62))
  }
}
