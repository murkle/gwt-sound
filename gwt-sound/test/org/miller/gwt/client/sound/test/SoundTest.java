package org.miller.gwt.client.sound.test;

import org.miller.gwt.client.sound.Callback;
import org.miller.gwt.client.sound.Option;
import org.miller.gwt.client.sound.SMSound;
import org.miller.gwt.client.sound.SoundManager;
import org.miller.gwt.client.sound.SoundOptions;

import com.google.gwt.junit.client.GWTTestCase;

public class SoundTest extends GWTTestCase {

	final String SOUND_ID = "soundID";

	private SoundManager sm;

	public String getModuleName() {
		return "org.miller.gwt.Sound";
	}

	protected void setUp() throws Exception {
		sm = SoundManager.getInstance();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testJUnit() {
		assertEquals(true, true);
	}

	public void testCreateSound1() {
		sm.createSound(SOUND_ID, "sound/Mist.mp3");
		assertNotNull(sm.getSoundById(SOUND_ID));
		sm.destroySound(SOUND_ID);
	}

	public void testCreateSound2() {
		sm.createSound(new Option[] { SoundOptions.id(SOUND_ID),
				SoundOptions.url("sound/Mist.mp3") });
		assertNotNull(sm.getSoundById(SOUND_ID));
		sm.destroySound(SOUND_ID);
	}
	
	public void testPlay() {
		sm.getDefaultOptions().onID3(new Callback() {
			public void execute() {
				SMSound sound = sm.getSoundById(SOUND_ID);
				assertNotNull(sound.getID3());
				System.out.println(sound.getID3().getV1().getArtist());
			}
		});
		sm.play(SOUND_ID, "sound/Mist.mp3");
	}
}
