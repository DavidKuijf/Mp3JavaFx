package application;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Methods {
	static void PlayingAnMp3(File mp3File) {
		String mp3Path = mp3File.getAbsolutePath(); 					//get the path of the passed File
		mp3Path = mp3Path.replace("\\", "/");							//Replace all \\ with /
		Media mp3 = new Media(new File(mp3Path).toURI().toString());	//Make it readable for the player
		MediaPlayer player = new MediaPlayer(mp3);						//Make the actual player instance
		player.play();													//Start playing
		
		}
	
	static void getMp3list(File libraryFolder) {
		File[] Testlist;
		Testlist = libraryFolder.listFiles();
		for (File x:Testlist){
			if(x.getName().endsWith(".mp3")) {
				System.out.println(x.getPath()+"\\" + x.getName());
				SceneController.items.add(x.getName());
			}
		}
	}
	
	static void makeTheLibDirTxt() {
	Path file = Paths.get("./lib-dir2.txt");
		try {
		    // Create the empty file with default permissions, etc.
		    Files.createFile(file);
		} catch (FileAlreadyExistsException x) {
		    System.err.format("file named %s" +
		        " already exists%n", file);
		} catch (IOException x) {
		    // Some other sort of failure, such as permissions.
		    System.err.format("createFile error: %s%n", x);
		}
	}
}
