package javafx;
	
import javafx.application.Application;
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
			   Parent root = FXMLLoader.load(getClass().getResource("SceneBuilder.fxml"));
			  
		        Scene scene = new Scene(root, 540, 550);
		    
		        stage.setTitle("Queue System");
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
