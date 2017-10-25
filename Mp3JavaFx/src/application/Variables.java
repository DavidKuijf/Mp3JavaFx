package application;

import java.io.File;
import java.text.DecimalFormat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Variables {
	static File libraryFolderPassable = new File((System.getProperty("user.home") + System.getProperty("file.separator") + "music"));
	static TextField libraryDirTxt = new TextField();							//init a Textfield
	static File[] fileList;
	static ObservableList<String> ol= FXCollections.observableArrayList();
	static String artistName;
	static String titleName;
	static String albumName;
	static String lenghtName;
	static int yearName;
	static Image albumImage;
	static String composerName;
	static Duration duration;
	static File selectedmp3;
	static MediaPlayer player;
	static boolean playing = false;
	final static DecimalFormat formatter = new DecimalFormat("");
}
