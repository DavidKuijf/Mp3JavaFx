package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;

public class PreferencesController implements Initializable {
	
	
	@FXML
	TextField libraryDirTxtfx = new TextField("test");							//init a Textfield
	
	@FXML
	Button Applybtn = new Button();
	
	@FXML
	void enableApplyButton() {
		Applybtn.setDisable(false);
	}
	
	
	/*@FXML 
	void getLibraryDirectory() {
	DirectoryChooser directoryChooser = new DirectoryChooser();			//make a Directory chooser
	File libraryFolder = directoryChooser.showDialog(null);				//Open a Directory chooser
	String libFile = libraryFolder.getAbsolutePath(); 					//get the path of the passed File
	libFile = libFile.replace("\\", "/");								//Replace all \\ with /
	libraryDirTxt.setText(libFile);										//set the field to the selected file
	
	}*/
	@FXML
	void getLibraryDirectoryfx(){
		libraryDirTxtfx.setText(Methods.getLibraryDirectory());
		enableApplyButton();
	}
	
	
	@FXML
	void cancel() {
		SceneController.prefstage.close();	//close prefstage
	}
	@FXML
	void apply() {
		Variables.libraryFolderPassable = new File(libraryDirTxtfx.getText().replace("\\", "/"));	//set the textfield to a passable File
		Methods.getMp3list(Variables.libraryFolderPassable);
	}
	
	
	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
		 	Applybtn.setDisable(true);
	    }  
	
}