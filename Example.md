# Example Code #

```
        final SoundManager sm = SoundManager.getInstance();

	private List soundIDs;

	private int playListIndex = 0;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final Button play = new Button("Play");
		final Button toggle = new Button("Pause");
		final Button stop = new Button("Stop");
		final Button next = new Button("Next");
		final Button back = new Button("Back");
		final Label duration = new Label("0:00/0:00");
		final HorizontalPanel player = new HorizontalPanel();
		final FlexTable info = new FlexTable();

		final Timer timer = new Timer() {
			public void run() {
				SMSound sound = sm.getSoundById((String) soundIDs
						.get(playListIndex));
				duration.setText(formatTime(sound.getPosition()) + "/"
						+ formatTime(sound.getDuration()));
			}
		};

		sm.setDebugMode(true);
		sm.getDefaultOptions().autoLoad(true);
		sm.getDefaultOptions().onFinish(new Callback() {
			public void execute() {
				if (playListIndex < (soundIDs.size() - 1)) {
					playListIndex++;
					sm.play((String) soundIDs.get(playListIndex));
				}
			}
		});
		sm.getDefaultOptions().onLoad(new Callback() {
			public void execute() {
				play.setEnabled(true);
				next.setEnabled(true);
				stop.setEnabled(true);
				back.setEnabled(true);
				toggle.setEnabled(true);
				soundIDs = sm.getSoundIDs();
				updateID3(info);
			}
		});
		sm.getDefaultOptions().onPlay(new Callback() {
			public void execute() {
				updateID3(info);
				timer.scheduleRepeating(1000);
			}
		});
		sm.onLoad(new Callback() {
			public void execute() {
				sm.loadFromXML("sound/playlist.xml");
			}
		});

		play.setEnabled(false);
		next.setEnabled(false);
		stop.setEnabled(false);
		back.setEnabled(false);
		toggle.setEnabled(false);

		play.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				duration.setText("0:00/0:00");
				/**
				 * 1.) sm.play(SOUND_ID, "sound/Mist.mp3");
				 * 
				 * 2.) sm.createSound(SOUND_ID, "sound/Mist.mp3");
				 * sm.play(SOUND_ID);
				 * 
				 * 3.) sm.createSound(new Option[] { SoundOptions.id(SOUND_ID),
				 * SoundOptions.url("sound/Mist.mp3"), SoundOptions.onLoad(new
				 * Callback() { public void execute() { Window.alert("loaded"); } })
				 * }); sm.play(SOUND_ID);
				 * 
				 * 4.) sm.loadFromXML(XML); sm.play(SOUND_ID);
				 */
				sm.play((String) soundIDs.get(playListIndex));
			}
		});

		toggle.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				toggle.setText(toggle.getText().equals("Resume") ? "Pause"
						: "Resume");
				sm.togglePause((String) soundIDs.get(playListIndex));
			}
		});

		stop.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				sm.stop((String) soundIDs.get(playListIndex));
				timer.cancel();
				duration.setText("0/0");
			}
		});

		back.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				sm.stop((String) soundIDs.get(playListIndex));
				if (playListIndex > 0)
					playListIndex--;
				sm.play((String) soundIDs.get(playListIndex));
			}
		});

		next.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				sm.stop((String) soundIDs.get(playListIndex));
				if (playListIndex < (soundIDs.size() - 1))
					playListIndex++;
				sm.play((String) soundIDs.get(playListIndex));
			}
		});

		player.add(back);
		player.add(play);
		player.add(toggle);
		player.add(stop);
		player.add(next);

		RootPanel.get().add(duration);
		RootPanel.get().add(player);
		RootPanel.get().add(info);
	}

	public void updateID3(FlexTable info) {
		SMSound sound = sm.getSoundById((String) soundIDs.get(playListIndex));
		ID3 id3 = sound.getID3();
		info.setWidget(0, 0, new Label("Comment"));
		info.setWidget(1, 0, new Label("Album"));
		info.setWidget(2, 0, new Label("Genre"));
		info.setWidget(3, 0, new Label("Song Name"));
		info.setWidget(4, 0, new Label("Artist"));
		info.setWidget(5, 0, new Label("Track"));
		info.setWidget(6, 0, new Label("Year"));

		try {
			info.setText(0, 1, id3.getV1().getComment());
			info.setText(1, 1, id3.getV1().getAlbum());
			info.setText(2, 1, id3.getV1().getGenre());
			info.setText(3, 1, id3.getV1().getSongName());
			info.setText(4, 1, id3.getV1().getArtist());
			info.setText(5, 1, id3.getV1().getTrack());
			info.setText(6, 1, id3.getV1().getYear());
		} catch (Exception e) {
			info.setText(0, 1, id3.getV2().getOriginalLyricistTextWriter());
			info.setText(1, 1, id3.getV2().getOriginalAlbumMovieShowTitle());
			info.setText(2, 1, id3.getV2().getContentGroupDescription());
			info
					.setText(3, 1, id3.getV2()
							.getTitleSongNameContentDescription());
			info.setText(4, 1, id3.getV2().getOriginalArtistPerformer());
			info.setText(5, 1, id3.getV2().getTrackNumberPositionInSet());
			info.setText(6, 1, id3.getV2().getYear());
		}

	}

	private String formatTime(int sec) {
		int minutes = (sec / 60);
		int seconds = (sec - minutes) % 60;
		return minutes + ":" + (seconds < 10 ? "0" + seconds : "" + seconds);
	}
```

# Example XML #
```
<?xml version="1.0" encoding="UTF-8"?>

<!-- SoundManager Flash configuration -->
<!-- Sound IDs are referenced from JS -->

<items baseHref="sound/"> <!-- baseHref is optional, but note the trailing slash if used. -->

 <sound id="Oldman" href="Oldman.mp3" />
 <sound id="Mist" href="Mist.mp3" />
 
</items>
```