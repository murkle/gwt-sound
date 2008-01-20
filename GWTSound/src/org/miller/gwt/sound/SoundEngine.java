package org.miller.gwt.sound;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.Instrument;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiFileFormat;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Soundbank;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Track;
import javax.sound.midi.spi.MidiFileWriter;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.spi.AudioFileWriter;

public class SoundEngine {

	public static void main(String[] args) {
		SoundEngine engine = new SoundEngine();
		engine.generateSound();
	}

	public void generateSound() {
		Sequencer sequencer;
		Sequence sequence;
		Synthesizer synth;
		Soundbank soundbank;
		int channelNumber = 0; // 16 channels loaded at a time
		int noteNumber = 60; // middle C is 60 (0-127)
		int velocity = 100; // volume
		int duration = 7000; // time in milliseconds

		try {
			synth = MidiSystem.getSynthesizer(); // default
			synth.open();

			MidiChannel[] channels = synth.getChannels();
			MidiChannel channel = channels[channelNumber];

			channel.programChange(25);
			soundbank = synth.getDefaultSoundbank();

			sequencer = MidiSystem.getSequencer();
			sequencer.open();

			sequence = new Sequence(Sequence.PPQ, 100); // 10 ticks per 1/4 note
			Track track = sequence.createTrack();

			add(track, 0, 60, velocity, 100);
			add(track, 0, 68, velocity, 100);

			add(track, 0, 65, velocity, 200);

			add(track, 0, 68, velocity, 300);

			add(track, 0, 72, velocity, 400);

			add(track, 0, 0, velocity, 600); // sustain last note

			sequencer.setSequence(sequence);

			sequencer.start();

			// channel.noteOn(noteNumber, velocity);

			Thread.sleep(duration);

			// channel.noteOff(noteNumber);

			sequencer.stop();

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			MidiSystem.write(sequencer.getSequence(), 0, out);

			AudioFileFormat format = AudioSystem.getAudioFileFormat(new ByteArrayInputStream(out
					.toByteArray()));
			format.getFormat().getEncoding().toString();
			
			out.close();
			synth.close();
			sequencer.close();

			/*
			 * Now display the information about the soundbank.
			 */
			// out("------------------------------------");
			// out("Soundbank: " + soundbank);
			// out("Name: " + soundbank.getName());
			// out("Description: " + soundbank.getDescription());
			// out("Vendor: " + soundbank.getVendor());
			// out("Version: " + soundbank.getVersion());
			// out("------------------------------------");
			//
			// out("Instruments (instr#:[bank#, patch#] name):");
			// Instrument[] aInstruments = soundbank.getInstruments();
			// for (int i = 0; i < aInstruments.length; i++)
			// {
			// out("" + i + ":[" + aInstruments[i].getPatch().getBank() + ", " +
			// aInstruments[i].getPatch().getProgram() + "] " +
			// aInstruments[i].getName());
			// }
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		}

	}

	private static void out(String strMessage) {
		System.out.println(strMessage);
	}

	private static void add(Track track, int channel, int noteNumber,
			int velocity, int tick) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		message.setMessage(ShortMessage.NOTE_ON, channel, noteNumber, velocity);
		MidiEvent event = new MidiEvent(message, tick);
		track.add(event);
	}

}
