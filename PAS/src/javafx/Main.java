package javafx;

import java.awt.Button;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		Stage anotherStage = new Stage();

		try {
			FXMLLoader loader = new FXMLLoader(); // FXML for primary stage
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			// set icon of the application
			Image applicationIcon = new Image(getClass().getResourceAsStream(
					"PASicon.png"));
			primaryStage.getIcons().add(applicationIcon);

			/**
			 * 
			 FXMLLoader anotherLoader = new FXMLLoader() ; // FXML for second
			 * stage
			 * 
			 * Parent anotherRoot = FXMLLoader.load(getClass().getResource(
			 * "Queue.fxml")); Scene anotherScene = new Scene(anotherRoot);
			 * anotherStage.setScene(anotherScene); anotherStage.show();
			 */
		} catch (Exception exc) {

			exc.printStackTrace();

		}
	}

	public static void main(String[] args) {
		launch(args);

	}
}
