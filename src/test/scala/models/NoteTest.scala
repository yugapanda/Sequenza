package models

import org.scalatest.{DiagrammedAssertions, FlatSpec}

class NoteTest extends FlatSpec with DiagrammedAssertions{


  val notes = (0 to 12).map(x =>  Note(60 + x,120,120))


  "getPitchName" should "音程の名前をStringで返すことが出来る" in {
    assert(notes(0).getPitchName === "C")
    assert(notes(1).getPitchName === "C#")
    assert(notes(2).getPitchName === "D")
    assert(notes(3).getPitchName === "Eb")
    assert(notes(4).getPitchName === "E")
    assert(notes(5).getPitchName === "F")
    assert(notes(6).getPitchName === "F#")
    assert(notes(7).getPitchName === "G")
    assert(notes(8).getPitchName === "Ab")
    assert(notes(9).getPitchName === "A")
    assert(notes(10).getPitchName === "Bb")
    assert(notes(11).getPitchName === "B")
  }

  "getOctave" should "オクターブを返すことが出来る" in{
    assert(notes(0).getOctave === 6)
  }


}
