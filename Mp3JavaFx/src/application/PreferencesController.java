package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;

public class PreferencesController implements Initializable {
	@FXML
	Button Browsebtn;

	@FXML File getLibraryDirectory(ActionEvent event) {
		System.out.println(" It works");
		DirectoryChooser directoryChooser = new DirectoryChooser();
		File libraryFolder = directoryChooser.showDialog(null);
		return libraryFolder;
	}
	
	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        // TODO
	    }  
	
}