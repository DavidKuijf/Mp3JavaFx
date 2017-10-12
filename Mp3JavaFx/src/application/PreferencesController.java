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
		Applybtn.setDisable(false);												//Disables the applybutton
	}
	

	@FXML
	void getLibraryDirectoryfx(){
		libraryDirTxtfx.setText(Methods.getLibraryDirectory());					//Gets the path of the library directory in a string and sets the textbox to it
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