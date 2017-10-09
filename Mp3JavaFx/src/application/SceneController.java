package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SceneController implements Initializable {
	
	File[] Testlist;
	
	@FXML
	private ListView<String> mp3List; // Creates a java variable from fxml ListView component (see fx:id in scene builder).
	static ObservableList<String> items = FXCollections.observableArrayList(); // Creates an observable list as an array so we can add components to the list view.
	static Stage prefstage = new Stage();
	
	@FXML 
		private void openPref() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Preferencesframe.fxml"));
			prefstage.setScene(new Scene(root, 570, 278));
			prefstage.showAndWait();
			mp3List.setVisible(false); //temp refresh
			mp3List.setVisible(true);  //temp refresh patch ASAP
		} catch(Exception e) {///
			e.printStackTrace();
		}
		
	}
		/*void getMp3list(File libraryFolder) {
			
			Testlist = libraryFolder.listFiles();
			for (File x:Testlist){
				System.out.println(x.getPath()+"\\" + x.getName());
				
		}*/
	
	
	public void initialize(URL location, ResourceBundle resources) { // On stage init.
		mp3List.setItems(items); // Sets the observable list of the list view.
		// Add temporary components to observable list so they get drawn on the list view.
		items.add("test2");
		items.add("test3");
	}
}
