package org.miller.gwt.client.sound;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * SMSound objects are created everytime SoundManager creates a sound. You can
 * retrieve SMSound objects from SoundManager by calling getSoundById and
 * passing in the id that was passed to SoundManager to create the sound.
 * SMSound is used to collect data on the sound loaded up by SoundManager. To
 * use callbacks on a particular sound use SoundOptions callbacks when creating
 * the sound initially.
 * 
 * @author JMILLER
 * 
 */
public class SMSound {

	private JavaScriptObject obj;

	SMSound(JavaScriptObject obj) {
		this.obj = obj;
	}

	public String getSID() {
		return sID();
	}

	private native String sID()/*-{
	 return this.@org.miller.gwt.client.sound.SMSound::obj.sID;
	 }-*/;

	public String getURL() {
		return url();
	}

	private native String url()/*-{
	 return this.@org.miller.gwt.client.sound.SMSound::obj.url;
	 }-*/;

	/**
	 * Need to abstract out again to make ID3 an actual object
	 * 
	 * @return ID3
	 */
	public ID3 getID3() {
		return new ID3(id3());
	}

	private native JavaScriptObject id3()/*-{
	 return this.@org.miller.gwt.client.sound.SMSound::obj.id3;
	 }-*/;

	public int getBytesLoaded() {
		return bytesLoaded();
	}

	private native int bytesLoaded()/*-{
	 return this.@org.miller.gwt.client.sound.SMSound::obj.bytesLoaded;
	 }-*/;

	public int getBytesTotal() {
		return bytesTotal();
	}

	private native int bytesTotal()/*-{
	 return this.@org.miller.gwt.client.sound.SMSound::obj.bytesTotal;
	 }-*/;

	public int getPosition() {
		try {
			return position() / 1000;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	private native int position()/*-{
	 return this.@org.miller.gwt.client.sound.SMSound::obj.position;
	 }-*/;

	public int getDuration() {
		try {
			return duration() / 1000;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	private native int duration()/*-{
	 return this.@org.miller.gwt.client.sound.SMSound::obj.duration;
	 }-*/;

	public int getDurationEstimate() {
		try {
			return durationEstimate() / 1000;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	private native int durationEstimate()/*-{
	 return this.@org.miller.gwt.client.sound.SMSound::obj.durationEstimate;
	 }-*/;

	public boolean getLoaded() {
		return loaded();
	}

	private native boolean loaded()/*-{
	 return this.@org.miller.gwt.client.sound.SMSound::obj.loaded;
	 }-*/;

	public int getPlayState() {
		return playState();
	}

	/**
	 * 0 = stopped/uninitialised
	 * 
	 * 1 = playing or buffering sound (play has been called, waiting for data
	 * etc.)
	 * 
	 * @return play state
	 */
	private native int playState()/*-{
	 return this.@org.miller.gwt.client.sound.SMSound::obj.playState;
	 }-*/;

	public int getReadyState() {
		return readyState();
	}

	/**
	 * 0 = uninitialised
	 * 
	 * 1 = loading
	 * 
	 * 2 = failed/error
	 * 
	 * 3 = loaded/success
	 * 
	 * @return ready state
	 */
	private native int readyState()/*-{
	 return this.@org.miller.gwt.client.sound.SMSound::obj.readyState;
	 }-*/;

	public boolean getDidBeforeFinish() {
		return didBeforeFinish();
	}

	private native boolean didBeforeFinish()/*-{
	 return this.@org.miller.gwt.client.sound.SMSound::obj.didBeforeFinish;
	 }-*/;

	public boolean getDidJustBeforeFinish() {
		return didJustBeforeFinish();
	}

	private native boolean didJustBeforeFinish()/*-{
	 return this.@org.miller.gwt.client.sound.SMSound::obj.didJustBeforeFinish;
	 }-*/;
}
