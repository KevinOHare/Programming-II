package javafx;

/**
 * import the resources
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

/**
 * Class to start the application
 * @author chrismcclune
 *
 */
public class Main extends Application {

	/**
	 * Method to start the application
	 */
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

		} catch (Exception exc) {

			exc.printStackTrace();

		}
	}

	public static void main(String[] args) {
		launch(args);

	}
}
