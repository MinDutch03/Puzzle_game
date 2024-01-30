package Scene;

import java.net.URL;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public class gameMusic {
	private Clip clip;
	
	private URL musicURL;
	
	public gameMusic(String musicFilePath) {
        this.musicURL = getClass().getResource(musicFilePath);
        initializeClip();
    }
	
	 private void initializeClip() {
	        try {
	            AudioInputStream ais = AudioSystem.getAudioInputStream(musicURL);
	            clip = AudioSystem.getClip();
	            clip.open(ais);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public void play() {
	        if (clip != null) {
	            clip.start();
	        }
	    }

	    public void loop() {
	        if (clip != null) {
	            clip.loop(Clip.LOOP_CONTINUOUSLY);
	        }
	    }

	    public void stop() {
	        if (clip != null) {
	            clip.stop();
	        }
	    }
	}
