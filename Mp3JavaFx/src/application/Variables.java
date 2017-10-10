package application;

import java.io.File;

import javafx.scene.control.TextField;

public class Variables {
	static File libraryFolderPassable = new File((System.getProperty("user.home") + System.getProperty("file.separator") + "music"));
	static TextField libraryDirTxt = new TextField();							//init a Textfield
}
