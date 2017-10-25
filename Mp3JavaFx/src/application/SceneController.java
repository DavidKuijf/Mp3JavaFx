package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SceneController implements Initializable {
	
	@FXML
	private ListView<String> mp3List; 											// Creates a java variable from fxml ListView component (see fx:id in scene builder).
	static ObservableList<String> items = FXCollections.observableArrayList(); 	// Creates an observable list as an array so we can add components to the list view.
	static Stage prefstage = new Stage();
	@FXML SplitPane splitpane;

	@FXML Label artistlbl;
	@FXML Label albumlbl;
	@FXML Label titlelbl;
	@FXML Label lengthlbl;
	@FXML Label timeSliderlbl;

	@FXML ImageView imageview;
	@FXML Button playpauseBtn;
	@FXML Button stopBtn;
	@FXML Button skipBtn;
	@FXML Button rewindBtn;
	
	@FXML void playpause() {Methods.playingAnMp3(Variables.selectedmp3);}
	@FXML void stop() {Variables.player.stop(); Variables.playing = false;}
	@FXML void rewind() {}
	@FXML void skip() {}
	
	
	
	@FXML 
		private void openPref() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Preferencesframe.fxml"));
			prefstage.setScene(new Scene(root, 570, 278));
			prefstage.showAndWait();
			mp3List.setVisible(false); //temp refresh patch ASAP
			mp3List.setVisible(true);  //temp refresh patch ASAP
		} catch(Exception e) {///
			e.printStackTrace();
		}
		
	}
	
	
	public void initialize(URL location, ResourceBundle resources) { // On stage init.
		mp3List.setItems(items); // Sets the observable list of the list view.
		// Add temporary components to observable list so they get drawn on the list view.
		mp3List.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println(newValue);
				for (File f : Variables.fileList) {
					if (f.getName().equals(newValue)) {
						Methods.getMetadata(f);
						//set all metadata on screen
						artistlbl.setText("Artist: \t" + Variables.artistName);
						albumlbl.setText("Album:\t" + Variables.albumName);
						titlelbl.setText("Title: \t" + Variables.titleName);
						timeSliderlbl.setText(" / " + String.valueOf(Variables.formatter.format(Math.floor(Variables.duration.toSeconds()))));
					}
					
				}
				System.out.println("Selected item: " + newValue);
				String localstring = Variables.libraryFolderPassable.toString() + "\\" + newValue;
				Variables.selectedmp3 = new File(localstring);
				if (Variables.albumImage != null) {
					imageview.setImage(Variables.albumImage);
				}
			}
		});
	}
}
