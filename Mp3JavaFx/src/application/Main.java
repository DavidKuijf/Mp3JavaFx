package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	/*
	 * Stage = window.
	 * Scene = stuff inside window.
	 */
	
	@Override
	public void start(Stage primaryStage) {
		Methods.makeTheLibDirTxt();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Libwindow.fxml")); 						// Loads Scene Builder fxml file.
			Methods.getMp3list(Variables.libraryFolderPassable);
			Scene mainScene = new Scene(root,1280,800); 													// Creates the scene in the stage.
			primaryStage.setTitle("MP3 Library");															// Speaks for itself.
			mainScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());		// Loads the css style sheet.
			primaryStage.setScene(mainScene); 																// Sets the scene of the stage.
			primaryStage.show(); 																			// Draws the stage on screen.
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
