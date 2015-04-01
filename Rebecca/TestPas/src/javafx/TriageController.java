package javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TriageController extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		 Parent root = FXMLLoader.load(getClass().getResource("/javafx/Triage.fxml"));		  
	        Scene scene = new Scene(root, 500, 600);  
	        primaryStage.setTitle("Traiage Page");
	        primaryStage.setScene(scene);
	        primaryStage.show();
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
