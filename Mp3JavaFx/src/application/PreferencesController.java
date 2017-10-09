package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;

public class PreferencesController implements Initializable {
	
	File libraryFolderPassable = null;
	@FXML
	TextField libraryDirTxt = new TextField();
	
	@FXML 
	File getLibraryDirectory(ActionEvent event) {
	System.out.println(" It works");
	DirectoryChooser directoryChooser = new DirectoryChooser();
	File libraryFolder = directoryChooser.showDialog(null);
	String libFile = libraryFolder.getAbsolutePath(); 					//get the path of the passed File
	libFile = libFile.replace("\\", "/");							//Replace all \\ with /
	libraryDirTxt.setText(libFile);
	return libraryFolder;
	}
	
	@FXML
	void cancel(ActionEvent event) {
		SceneController.prefstage.close();
	}
	@FXML
	void apply(ActionEvent event) {
		libraryFolderPassable = new File(libraryDirTxt.getText().replace("\\", "/"));
		
	}
	
	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        // TODO
	    }  
	
}