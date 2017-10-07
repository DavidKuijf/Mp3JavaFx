package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SceneController implements Initializable {
	
	FileChooser fileChooser = new FileChooser();

	@FXML
	private ListView<String> mp3List; // Creates a java variable from fxml ListView component (see fx:id in scene builder).
	private ObservableList<String> items = FXCollections.observableArrayList(); // Creates an observable list as an array so we can add components to the list view.
	
	@FXML
	private void doAThing() {
		//This was a test
	}
	
	@FXML
	private void openPref() {
		System.out.println("It WORKS!");
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Preferencesframe.fxml")); // Loads Scene Builder fxml file.
			Stage prefstage = new Stage();
			prefstage.setScene(new Scene(root, 450, 450));
			//prefstage.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); // Loads the css style sheet.
			prefstage.show();
		} catch(Exception e) {///
			e.printStackTrace();
		}
		
	}
	
	
	public void initialize(URL location, ResourceBundle resources) { // On stage init.
		mp3List.setItems(items); // Sets the observable list of the list view.
		// Add temporary components to observable list so they get drawn on the list view.
		items.add("test1");
		items.add("test2");
		items.add("test3");
	}
}
