package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class SceneController implements Initializable {

	@FXML
	private ListView<String> mp3List; // Creates a java variable from fxml ListView component (see fx:id in scene builder).
	private ObservableList<String> items = FXCollections.observableArrayList(); // Creates an observable list as an array so we can add components to the list view.
	
	public void initialize(URL location, ResourceBundle resources) { // On stage init.
		mp3List.setItems(items); // Sets the observable list of the list view.
		// Add temporary components to observable list so they get drawn on the list view.
		items.add("test1");
		items.add("test2");
		items.add("test3");
	}
}
