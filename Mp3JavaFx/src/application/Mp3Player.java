package application;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Mp3Player {
	
	static void PlayingAnMp3(File mp3File) {
		String mp3Path = mp3File.getAbsolutePath();
		mp3Path = mp3Path.replace("\\", "/");
		Media mp3 = new Media(new File(mp3Path).toURI().toString());
		MediaPlayer player = new MediaPlayer(mp3);
		player.play();
		
		}

}
