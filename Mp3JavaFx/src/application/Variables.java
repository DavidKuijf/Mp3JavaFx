package application;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

public class Variables {
	static File libraryFolderPassable = new File((System.getProperty("user.home") + System.getProperty("file.separator") + "music"));
	static TextField libraryDirTxt = new TextField();							//init a Textfield
	static File[] fileList;
	static ObservableList<String> ol= FXCollections.observableArrayList();
}
