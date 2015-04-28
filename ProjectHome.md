After reviewing a few flash->javascript api's I decided this was one of the better implementations.  This project attempts to wrap the javascript api using GWT.

Resource:
http://www.schillmania.com/projects/soundmanager2/

javadocs:
http://gwt-sound.googlecode.com/svn/trunk/gwt-sound/docs/index.html

# Quick Start #

1.) Add 

&lt;inherits name='org.miller.gwt.Sound'/&gt;

 to your .gwt.xml

2.) Reference the jar file in your projects classpath

3.) Example

```
   final String SOUND_ID = 'soundID';
   SoundManager sm = SoundManager.getInstance();
   sm.createSound(SOUND_ID, 'sound/Mist.mp3');
   sm.play(SOUND_ID);
   sm.destroySound(SOUND_ID);
```