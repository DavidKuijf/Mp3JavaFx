package application;

import java.io.File;

import javafx.fxml.FXML;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class PreferencesController{
	
	FileChooser fileChooser = new FileChooser();

	
	@FXML
	private File getLibraryDirectory() {
		System.out.println(" It works");
		DirectoryChooser directoryChooser = new DirectoryChooser();
		File libraryFolder = directoryChooser.showDialog(null);
		return libraryFolder;
	}
	
}