import java.io.File

import javax.sound.midi.{Sequence, Track}
import javax.sound.midi.MidiSystem
import models.Note


object MidiMaker {


  def makeMidiTrack(channel: Int, instrument: Int,notes: List[Note], tempo: Int): Sequence = {

    val sequence: Sequence = new Sequence(Sequence.PPQ, 480)
    val track: Track = sequence.createTrack()

    import javax.sound.midi.MetaMessage
    import javax.sound.midi.MidiEvent
    import javax.sound.midi.ShortMessage

    val mMessage = new MetaMessage
    val l: Int = 60 * 1000000 / tempo
    mMessage.setMessage(0x51, Array[Byte]((l / 65536).toByte, (l % 65536 / 256).toByte, (l % 256).toByte), 3)
    track.add(new MidiEvent(mMessage, 0))


    //set instrument
    val message = new ShortMessage
    message.setMessage(ShortMessage.PROGRAM_CHANGE, channel, instrument, 0)
    track.add(new MidiEvent(message, 0))

    go(notes, 0)

    sequence

    def go(makeNotes: List[Note], pastTickSum: Int): Unit = makeNotes match{
      case x::xs =>
        val noteOn = new ShortMessage
        noteOn.setMessage(ShortMessage.NOTE_ON, channel, x.pitch, x.velocity)
        track.add(new MidiEvent(message, pastTickSum))

        val noteOff = new ShortMessage
        noteOff.setMessage(ShortMessage.NOTE_OFF, channel, x.pitch, 0)
        track.add(new MidiEvent(message, pastTickSum + x.duration))

        go(xs, pastTickSum + x.duration)

      case Nil =>
    }



    def write(seq: Sequence, path: String): Unit = MidiSystem.write(sequence, 0, new File(path))


  }

}
