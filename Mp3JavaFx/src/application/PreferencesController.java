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
	TextField libraryDirTxt = new TextField();							//init a Textfield
	
	@FXML 
	void getLibraryDirectory() {
	DirectoryChooser directoryChooser = new DirectoryChooser();			//make a Directory chooser
	File libraryFolder = directoryChooser.showDialog(null);				//Open a Directory chooser
	String libFile = libraryFolder.getAbsolutePath(); 					//get the path of the passed File
	libFile = libFile.replace("\\", "/");								//Replace all \\ with /
	libraryDirTxt.setText(libFile);										//set the field to the selected file
	}
	
	@FXML
	void cancel() {
		SceneController.prefstage.close();								//close prefstage
	}
	@FXML
	void apply() {
		libraryFolderPassable = new File(libraryDirTxt.getText().replace("\\", "/"));	//set the textfield to a passable File
		if(libraryFolderPassable != null) {
			getMp3list(libraryFolderPassable);
		}
	}
	@FXML
	void getMp3list(File libraryFolder) {
		File[] Testlist;
		Testlist = libraryFolder.listFiles();
		for (File x:Testlist){
			if(x.getName().endsWith(".mp3")) {
				System.out.println(x.getPath()+"\\" + x.getName());
				SceneController.items.add(x.getName());
			}
		}
		
	}
	
	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        // TODO
	    }  
	
}