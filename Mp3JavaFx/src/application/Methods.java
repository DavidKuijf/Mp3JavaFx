package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.DirectoryChooser;
import javafx.util.Duration;

public class Methods {
	static void PlayingAnMp3(File mp3File) {
		String mp3Path = mp3File.getAbsolutePath(); 					//get the path of the passed File
		mp3Path = mp3Path.replace("\\", "/");							//Replace all \\ with /
		Media mp3 = new Media(new File(mp3Path).toURI().toString());	//Make it readable for the player
		MediaPlayer player = new MediaPlayer(mp3);						//Make the actual player instance
		player.play();													//Start playing
		
	}
	
	static void getMp3list(File libraryFolder) {
		Variables.fileList = libraryFolder.listFiles();
		SceneController.items.clear();
		for (File x:Variables.fileList){
			if(x.getName().endsWith(".mp3")) {
				System.out.println(x.getPath()+"\\" + x.getName());
				SceneController.items.add(x.getName());
			}
		}
	}
	
	static void makeTheLibDirTxt() {									//This was basically ripped word for word from https://docs.oracle.com/javase/tutorial/essential/io/file.html
		Path file = Paths.get("lib-dir.txt");
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
		Methods.writeToTxtFile(Variables.libraryFolderPassable.toString());
	}
	
	static void writeToTxtFile(String txt ) {
		FileWriter fWriter;
		try {
			fWriter = new FileWriter("lib-dir.txt");
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			bWriter.write(txt);
			bWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static String getLibraryDirectory() {
		DirectoryChooser directoryChooser = new DirectoryChooser();			//make a Directory chooser
		File libraryFolder = directoryChooser.showDialog(null);				//Open a Directory chooser
		String libFile = libraryFolder.getAbsolutePath(); 					//get the path of the passed File
		libFile = libFile.replace("\\", "/");								//Replace all \\ with /
		Variables.libraryDirTxt.setText(libFile);							//set the field to the selected file
		return libFile;

		
	}
	
	static void getMetadata(File selectedMp3) {
		String mp3Path = selectedMp3.getAbsolutePath();
		mp3Path = mp3Path.replace("\\", "/");
		Media mp3 = new Media(new File(mp3Path).toURI().toString());
		MediaPlayer player = new MediaPlayer(mp3);
		System.out.println(player.getMedia().getMetadata().get("title"));
		player.setOnReady(new Runnable() {

		        @Override
		        public void run() {
		        	
		            Variables.artistName=(String) player.getMedia().getMetadata().get("artist");
		            System.out.println(Variables.artistName);
		            Variables.titleName=(String) player.getMedia().getMetadata().get("title");
		            System.out.println(Variables.titleName);
		            Variables.albumName=(String) player.getMedia().getMetadata().get("album");
		            System.out.println(Variables.albumName);
		            Variables.composerName=(String) player.getMedia().getMetadata().get("composer");
		            System.out.println(Variables.composerName);
		            Variables.duration=(Duration) player.getMedia().getMetadata().get("duration");
		            System.out.println(Variables.duration);
		            if (player.getMedia().getMetadata().get("year") != null){
		            Variables.yearName=(int) player.getMedia().getMetadata().get("year");
		            System.out.println(Variables.yearName);
		            }
		            Variables.albumImage =(Image) player.getMedia().getMetadata().get("image");
		            
		            
		        }
		    });
	}
	
}
