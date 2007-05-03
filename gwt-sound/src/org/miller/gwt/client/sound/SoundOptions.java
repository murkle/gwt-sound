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
	
	public Option autoLoad(boolean auto) {
		return new Option("autoLoad", auto);
	}

	public Option multiShot(boolean multishot) {
		return new Option("multiShot", multishot);
	}

	public Option pan(int pan) {
		return new Option("pan", pan);
	}

	public Option volume(int volume) {
		return new Option("volume", volume);
	}

	public Option whileLoading(Callback callback) {
		return new Option("whileloading", callback);
	}

	public Option whilePlaying(Callback callback) {
		return new Option("whileplaying", callback);
	}

	public Option onLoad(Callback callback) {
		return new Option("onload", callback);
	}

	public Option onPlay(Callback callback) {
		return new Option("onplay", callback);
	}

	public Option onStop(Callback callback) {
		return new Option("onstop", callback);
	}

	public Option onFinish(Callback callback) {
		return new Option("onfinish", callback);
	}

	public Option onBeforeFinishComplete(Callback callback) {
		return new Option("onbeforefinishcomplete", callback);
	}

	public Option onBeforeFinishTime(Callback callback) {
		return new Option("onBeforeFinishTime", callback);
	}

	public Option onBeforeFinish(Callback callback) {
		return new Option("onBeforeFinish", callback);
	}

	public Option onJustBeforeFinish(Callback callback) {
		return new Option("onjustbeforefinish", callback);
	}

	public Option onJustBeforeFinishTime(Callback callback) {
		return new Option("onjustbeforefinishtime", callback);
	}

	public Option onID3(Callback callback) {
		return new Option("onid3", callback);
	}
}
