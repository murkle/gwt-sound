package org.miller.gwt.client.sound;

public class SoundOptions {

	private SoundOptions() {
		
	}
	
	public Option id(String id) {
		return new Option("id", id);
	}
	
	public Option autoPlay(boolean auto) {
		return new Option("autoPlay", auto);
	}
	
	private native void setAutoPlay(boolean auto)/*-{
	 $wnd.soundManager.defaultOptions.autoPlay = auto;
	 }-*/;

	public void autoLoad(boolean auto) {
		setAutoLoad(auto);
	}

	private native void setAutoLoad(boolean auto)/*-{
	 $wnd.soundManager.defaultOptions.autoLoad = auto;
	 }-*/;

	public void multiShot(boolean multishot) {
		setMultiShot(multishot);
	}

	private native void setMultiShot(boolean multishot)/*-{
	 $wnd.soundManager.defaultOptions.multiShot = multishot;
	 }-*/;

	public void pan(int pan) {
		setPan(pan);
	}

	private native void setPan(int pan)/*-{
	 $wnd.soundManager.defaultOptions.pan = pan;
	 }-*/;

	public void volume(int volume) {
		setVolume(volume);
	}

	private native void setVolume(int volume) /*-{
	 $wnd.soundManagerdefaultOptions.volume(volume); 	
	 }-*/;

	public void whileLoading(Callback callback) {
		executeWhileLoading(callback);
	}

	private native boolean executeWhileLoading(Callback callback)/*-{
	 $wnd.soundManager.defaultOptions.whileloading = function() {		
	 callback.@org.miller.gwt.client.sound.Callback::execute()();
	 }
	 }-*/;

	public void whilePlaying(Callback callback) {
		executeWhilePlaying(callback);
	}

	private native boolean executeWhilePlaying(Callback callback)/*-{
	 $wnd.soundManager.defaultOptions.whileplaying = function() {		
	 callback.@org.miller.gwt.client.sound.Callback::execute()();
	 }
	 }-*/;

	public void onLoad(Callback callback) {
		executeOnLoad(callback);
	}

	private native void executeOnLoad(Callback callback)/*-{
	 $wnd.soundManager.defaultOptions.onload = function() {		
	 callback.@org.miller.gwt.client.sound.Callback::execute()();
	 }
	 }-*/;

	public void onPlay(Callback callback) {
		executeOnPlay(callback);
	}

	private native void executeOnPlay(Callback callback)/*-{
	 $wnd.soundManager.defaultOptions.onplay = function() {		
	 callback.@org.miller.gwt.client.sound.Callback::execute()();
	 }
	 }-*/;

	public void onStop(Callback callback) {
		executeOnStop(callback);
	}

	private native void executeOnStop(Callback callback) /*-{
	 $wnd.soundManager.defaultOptions.onstop = function() {		
	 callback.@org.miller.gwt.client.sound.Callback::execute()();
	 }
	 }-*/;

	public void onFinish(Callback callback) {
		executeOnFinish(callback);
	}

	private native void executeOnFinish(Callback callback) /*-{
	 $wnd.soundManager.defaultOptions.onfinish = function() {		
	 callback.@org.miller.gwt.client.sound.Callback::execute()();
	 }
	 }-*/;

	public void onBeforeFinishComplete(Callback callback) {
		executeOnBeforeFinishComplete(callback);
	}

	private native void executeOnBeforeFinishComplete(Callback callback) /*-{
	 $wnd.soundManager.defaultOptions.onbeforefinishcomplete = function() {		
	 callback.@org.miller.gwt.client.sound.Callback::execute()();
	 }
	 }-*/;

	public void onBeforeFinishTime(Callback callback) {
		executeOnBeforeFinishTime(callback);
	}

	private native void executeOnBeforeFinishTime(Callback callback) /*-{
	 $wnd.soundManager.defaultOptions.onbeforefinishtime = function() {		
	 callback.@org.miller.gwt.client.sound.Callback::execute()();
	 }
	 }-*/;

	public void onBeforeFinish(Callback callback) {
		executeOnBeforeFinish(callback);
	}

	private native void executeOnBeforeFinish(Callback callback) /*-{
	 $wnd.soundManager.defaultOptions.onbeforefinish = function() {		
	 callback.@org.miller.gwt.client.sound.Callback::execute()();
	 }
	 }-*/;

	public void onJustBeforeFinish(Callback callback) {
		executeOnJustBeforeFinish(callback);
	}

	private native void executeOnJustBeforeFinish(Callback callback) /*-{
	 $wnd.soundManager.defaultOptions.onjustbeforefinish = function() {		
	 callback.@org.miller.gwt.client.sound.Callback::execute()();
	 }
	 }-*/;

	public void onJustBeforeFinishTime(Callback callback) {
		executeOnJustBeforeFinishTime(callback);
	}

	private native void executeOnJustBeforeFinishTime(Callback callback) /*-{
	 $wnd.soundManager.defaultOptions.onjustbeforefinishtime = function() {		
	 callback.@org.miller.gwt.client.sound.Callback::execute()();
	 }
	 }-*/;

	public void onID3(Callback callback) {
		executeOnID3(callback);
	}

	private native void executeOnID3(Callback callback)/*-{
	 $wnd.soundManager.defaultOptions.onid3 = function() {
	 callback.@org.miller.gwt.client.sound.Callback::execute()();
	 }
	 }-*/;
}
