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
			//BorderPane root = new BorderPane();
			//Scene scene = new Scene(root,600,600);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//primaryStage.setScene(scene);
			//primaryStage.show();
			   Parent root = FXMLLoader.load(getClass().getResource("ReceptionLayout.fxml"));		  
		        Scene scene = new Scene(root, 400, 300);  
		        stage.setTitle("PAS Login");
		        stage.setScene(scene);
		        stage.show();
		        
		        
		        
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
