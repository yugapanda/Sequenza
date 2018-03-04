package models

case class Note(pitch: Int, velocity: Int, duration: Int) {

  /**
    * return pitch name
    * @return pitch name like: "C#"
    */
  def getPitchName:String = Note.pitchName(pitch % 12)


  /**
    * return pitch octave
    * @return octave like : 6
    */
  def getOctave:Int = (pitch / 12) + 1


}

object Note {

  /**
    * pitch name
    */
  val pitchName: List[String] = List("C","C#","D","Eb","E","F","F#","G","Ab","A","Bb","B")

}