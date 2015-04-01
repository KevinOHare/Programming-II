package javafx;

import java.awt.Button;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource(
					"Login.fxml"));
			Scene scene = new Scene(root, 320, 300);
			stage.setTitle("Login");
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
