import java.util.*;
import javax.sound.midi.*;
import java.io.*;

public class MIDIPlayer
{
	MIDIPlayer()
	{}

	public void play()
	{
	    try
	    {
	        // From file
	        Sequence sequence = MidiSystem.getSequence(new File("HotelCaliforniaTheGame.mid"));
	        // Create a sequencer for the sequence
	        Sequencer sequencer = MidiSystem.getSequencer();
	        sequencer.open();
	        sequencer.setSequence(sequence);
	        // Start playing
	        sequencer.start();
	        System.out.println("Playing Started");
	    } catch (Exception e)
	    {
			System.out.println("ERROR: Song not playing :(");
		}
    }
}