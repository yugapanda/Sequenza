package models

import models.NoteValue.N16
import org.scalatest.{DiagrammedAssertions, FlatSpec}

class UnitsTest extends FlatSpec with DiagrammedAssertions {
  val baseTempo = 480
  val n = new Units(baseTempo)

  "apply" should "その音価を返すことが出来る" in{
    assert(n.t(16) === (baseTempo/16))
  }

}