package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.DirectoryChooser;

public class Methods {

		
	static void playingAnMp3(File mp3File) {
		
		// This logic compartment checks if the player is currently playing or not and acts accordingly.
		if (!Variables.playing) {
			Variables.player.play();	//Start playing
			Variables.playing = true;
			Variables.controlFile = mp3File;
		return;
		}
		if (Variables.playing) {
			Variables.player.pause();
			Variables.playing = false;
			return;
		}
		
	}
	
	static String readFile(String path) 
		throws IOException {
			byte[] encoded = Files.readAllBytes(Paths.get(path)); // Reads the bytes of the specific file
			return new String(encoded, Charset.defaultCharset()); // Turns the bytes into a string of chars
		}
	
	static void getMp3list(File libraryFolder) {
		Variables.fileList = libraryFolder.listFiles();	// Gets a list of files in the library folder and stores it.
		SceneController.items.clear();	// Clears the current list.
		for (File x:Variables.fileList){	// Checks for every file if it is an mp3
			if(x.getName().endsWith(".mp3")) {
				System.out.println(x.getPath()+"\\" + x.getName()); // Prints out the files it found.
				SceneController.items.add(x.getName()); // Adds the found files to the list.
			}
		}
	}
	
	static void makeTheLibDirTxt() throws IOException {									//This was basically ripped word for word from https://docs.oracle.com/javase/tutorial/essential/io/file.html
		Path file = Paths.get("lib-dir.txt");
		try {
		    // Create the empty file with default permissions, etc.
		    Files.createFile(file);
		} catch (FileAlreadyExistsException x) {
		    System.err.format("file named %s" +
		        " already exists%n", file);
		    Variables.libraryFolderPassable = new File(readFile("lib-dir.txt"));
		} catch (IOException x) {
		    // Some other sort of failure, such as permissions.
		    System.err.format("createFile error: %s%n", x);
		}
		Methods.writeToTxtFile(Variables.libraryFolderPassable.toString());
	}
	
	static void writeToTxtFile(String txt) {
		FileWriter fWriter; 
		try {
			fWriter = new FileWriter("lib-dir.txt"); // Create a new FileWriter object that will write to 'lib-dir.txt'
			BufferedWriter bWriter = new BufferedWriter(fWriter); // Create a new BufferedWriter object to write data to the FileWriter
			bWriter.write(txt); // Write the given String to the BufferedWriter
			bWriter.close(); // Close the BufferedWriter object to preserve memory
		} catch (IOException e) {
			e.printStackTrace(); // Catch and print I/O error
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
		String mp3Path = selectedMp3.getAbsolutePath(); // Stores the absolute path of the given mp3
		mp3Path = mp3Path.replace("\\", "/"); // Replaces '//' to '\' so we can use it
		Media mp3 = new Media(new File(mp3Path).toURI().toString()); // Stores the mp3 file as a Media object
		Variables.player = new MediaPlayer(mp3); // Creates new MediaPlayer object and loads the Media object into the MediaPlayer
		System.out.println(Variables.player.getMedia().getMetadata().get("title")); // Prints out the mp3 title (for debugging purposes)
		Variables.player.setOnReady(() -> { // Get's the mp3 ready to play so we can read the metadata (and also for when the user presses play)
				
			// Reads all the metadata, stores it and prints it out.
			Variables.artistName = (String) Variables.player.getMedia().getMetadata().get("artist");
			System.out.println("Artist: " + Variables.artistName);
			Variables.titleName = (String) Variables.player.getMedia().getMetadata().get("title");
			System.out.println("Title: " + Variables.titleName);
			Variables.albumName = (String) Variables.player.getMedia().getMetadata().get("album");
			System.out.println("Album: " + Variables.albumName);
			Variables.composerName = (String) Variables.player.getMedia().getMetadata().get("composer");
			System.out.println("Composer: " + Variables.composerName);
			Variables.duration = Variables.player.getMedia().getDuration();
			System.out.println(Variables.duration);
			Variables.yearName = (int) Variables.player.getMedia().getMetadata().get("year");
			System.out.println(Variables.yearName);
			Variables.albumImage = (Image) Variables.player.getMedia().getMetadata().get("image");
			}
		);
	}
}
