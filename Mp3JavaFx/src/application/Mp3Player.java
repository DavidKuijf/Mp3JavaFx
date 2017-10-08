package application;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Mp3Player {
	
	static void PlayingAnMp3(File mp3File) {
		String mp3Path = mp3File.getAbsolutePath(); 					//get the path of the passed File
		mp3Path = mp3Path.replace("\\", "/");							//Replace all \\ with /
		Media mp3 = new Media(new File(mp3Path).toURI().toString());	//Make it readable for the player
		MediaPlayer player = new MediaPlayer(mp3);						//Make the actual player instance
		player.play();													//Start playing
		
		}

}
