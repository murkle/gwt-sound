package org.miller.gwt.client.sound;

import com.google.gwt.core.client.JavaScriptObject;

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
	 * @return
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
	 * @return
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
	 * @return
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

	// ============= NOT SURE HOW EFFECTIVE THESE CALLBACKS ARE ===========

	public void whileLoading(Callback callback) {
		executeWhileLoading(callback);
	}

	private native boolean executeWhileLoading(Callback callback)/*-{
	 this.@org.miller.gwt.client.sound.SMSound::obj.whileloading = function() {		
	 callback.@org.miller.gwt.client.sound.Callback::execute()();
	 }
	 }-*/;

	public void whilePlaying(Callback callback) {
		executeWhilePlaying(callback);
	}

	private native boolean executeWhilePlaying(Callback callback)/*-{
	 this.@org.miller.gwt.client.sound.SMSound::obj.whileplaying = function() {		
	 callback.@org.miller.gwt.client.sound.Callback::execute()();
	 }
	 }-*/;

	public void onLoad(Callback callback) {
		executeOnLoad(callback);
	}

	private native void executeOnLoad(Callback callback)/*-{
	 this.@org.miller.gwt.client.sound.SMSound::obj.onload = function() {		
	 callback.@org.miller.gwt.client.sound.Callback::execute()();
	 }
	 }-*/;

	public void onPlay(Callback callback) {
		executeOnPlay(callback);
	}

	private native void executeOnPlay(Callback callback)/*-{
	 this.@org.miller.gwt.client.sound.SMSound::obj.onplay = function() {		
	 callback.@org.miller.gwt.client.sound.Callback::execute()();
	 }
	 }-*/;

	public void onStop(Callback callback) {
		executeOnStop(callback);
	}

	private native void executeOnStop(Callback callback) /*-{
	 this.@org.miller.gwt.client.sound.SMSound::obj.onstop = function() {		
	 callback.@org.miller.gwt.client.sound.Callback::execute()();
	 }
	 }-*/;

	public void onFinish(Callback callback) {
		executeOnFinish(callback);
	}

	private native void executeOnFinish(Callback callback) /*-{
	 this.@org.miller.gwt.client.sound.SMSound::obj.onfinish = function() {		
	 callback.@org.miller.gwt.client.sound.Callback::execute()();
	 }
	 }-*/;

	public void onBeforeFinishComplete(Callback callback) {
		executeOnBeforeFinishComplete(callback);
	}

	private native void executeOnBeforeFinishComplete(Callback callback) /*-{
	 this.@org.miller.gwt.client.sound.SMSound::obj.onbeforefinishcomplete = function() {		
	 callback.@org.miller.gwt.client.sound.Callback::execute()();
	 }
	 }-*/;

	public void onBeforeFinish(Callback callback) {
		executeOnBeforeFinish(callback);
	}

	private native void executeOnBeforeFinish(Callback callback) /*-{
	 this.@org.miller.gwt.client.sound.SMSound::obj.onbeforefinish = function() {		
	 callback.@org.miller.gwt.client.sound.Callback::execute()();
	 }
	 }-*/;

	public void onJustBeforeFinish(Callback callback) {
		executeOnJustBeforeFinish(callback);
	}

	private native void executeOnJustBeforeFinish(Callback callback) /*-{
	 this.@org.miller.gwt.client.sound.SMSound::obj.onjustbeforefinish = function() {		
	 callback.@org.miller.gwt.client.sound.Callback::execute()();
	 }
	 }-*/;

	public void onID3(Callback callback) {
		executeOnID3(callback);
	}

	private native void executeOnID3(Callback callback)/*-{
	 this.@org.miller.gwt.client.sound.SMSound::obj.onid3 = function() {
	 callback.@org.miller.gwt.client.sound.Callback::execute()();
	 }
	 }-*/;
}
