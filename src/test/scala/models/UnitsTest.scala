package models

import models.NoteValue.N16
import org.scalatest.{DiagrammedAssertions, FlatSpec}

class UnitsTest extends FlatSpec with DiagrammedAssertions {
  implicit val timebase = 480

  "apply" should "その音価を返すことが出来る" in{
    assert(N16 === (480/16))
  }

}