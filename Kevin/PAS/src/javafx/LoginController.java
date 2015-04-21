package javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class LoginController extends Application implements Initializable {

	@FXML
	private Label loginLabel;

	@FXML
	private TextField fieldUsername;

	@FXML
	private PasswordField fieldPassword;

	@FXML
	private Button myButton; // value will be injected by the FXMLLoader

	public void display(ActionEvent event) throws Exception {

	}

	@Override
	// This method is called by the FXMLLoader when initialization is complete
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

		assert myButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";

		// initialize your logic here: all @FXML variables will have been
		// injected

		myButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Parent root;
				
				 Stage anotherStage = new Stage();
				
				try {
					if (fieldUsername.getText().equals("triage")
							&& fieldPassword.getText().equals("password")) {
						root = FXMLLoader.load(getClass().getResource(
								"/javafx/Queue.fxml"));
						Stage primaryStage = new Stage();
						Scene scene = new Scene(root, 1400, 684);
						primaryStage.setTitle("Queue Page");
						primaryStage.setScene(scene);
						primaryStage.show();
						Stage stage = (Stage) myButton.getScene().getWindow();
						
						// FXML for second stage			        
			            Parent anotherRoot = FXMLLoader.load(getClass().getResource("Triage.fxml"));
			            Scene anotherScene = new Scene(anotherRoot);
			            anotherStage.setScene(anotherScene);
						anotherStage.setTitle("Triage Page");
			            anotherStage.show();
						stage.close();

						// set icon of the application
						Image applicationIcon = new Image(getClass()
								.getResourceAsStream("PASicon.png"));
						primaryStage.getIcons().add(applicationIcon);
						

					}
					if (fieldUsername.getText().equals("admin")
							&& fieldPassword.getText().equals("password")) {
						root = FXMLLoader.load(getClass().getResource(
								"/javafx/Queue.fxml"));
						Stage primaryStage = new Stage();
						Scene scene = new Scene(root, 1400, 684);
						primaryStage.setTitle("Queue Page");
						primaryStage.setScene(scene);
						primaryStage.show();
						Stage stage = (Stage) myButton.getScene().getWindow();
						
						// FXML for second stage			        
			            Parent anotherRoot = FXMLLoader.load(getClass().getResource("ReceptionLayout.fxml"));
			            Scene anotherScene = new Scene(anotherRoot);
			            anotherStage.setScene(anotherScene);
						anotherStage.setTitle("Reception Page");
			            anotherStage.show();
						stage.close();

						// set icon of the application
						Image applicationIcon = new Image(getClass()
								.getResourceAsStream("PASicon.png"));
						primaryStage.getIcons().add(applicationIcon);

					}
					if (fieldUsername.getText().equals("doctor")
							&& fieldPassword.getText().equals("password")) {
						root = FXMLLoader.load(getClass().getResource(
								"/javafx/Queue.fxml"));
						Stage primaryStage = new Stage();
						Scene scene = new Scene(root, 1400, 684);
						primaryStage.setTitle("Treatment Room");
						primaryStage.setScene(scene);
						primaryStage.show();
						Stage stage = (Stage) myButton.getScene().getWindow();
						
						// FXML for second stage			        
			            Parent anotherRoot = FXMLLoader.load(getClass().getResource("TreatmentRoom.fxml"));
			            Scene anotherScene = new Scene(anotherRoot);
			            anotherStage.setScene(anotherScene);
						anotherStage.setTitle("Treatment Room Page");
			            anotherStage.show();
						stage.close();

						// set icon of the application
						Image applicationIcon = new Image(getClass()
								.getResourceAsStream("PASicon.png"));
						primaryStage.getIcons().add(applicationIcon);

					} else {
						loginLabel.setText("Wrong credentials were entered");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		fieldPassword.setOnKeyPressed(new EventHandler<KeyEvent>()
			    {
			        @Override
			        public void handle(KeyEvent ke)
			        {
			            if (ke.getCode().equals(KeyCode.ENTER))
			            {
			            	Parent root;
							
							 Stage anotherStage = new Stage();
							
							try {
								if (fieldUsername.getText().equals("triage")
										&& fieldPassword.getText().equals("password")) {
									root = FXMLLoader.load(getClass().getResource(
											"/javafx/Queue.fxml"));
									Stage primaryStage = new Stage();
									Scene scene = new Scene(root, 1400, 684);
									primaryStage.setTitle("Queue Page");
									primaryStage.setScene(scene);
									primaryStage.show();
									Stage stage = (Stage) myButton.getScene().getWindow();
									
									// FXML for second stage			        
						            Parent anotherRoot = FXMLLoader.load(getClass().getResource("Triage.fxml"));
						            Scene anotherScene = new Scene(anotherRoot);
						            anotherStage.setScene(anotherScene);
									anotherStage.setTitle("Triage Page");
						            anotherStage.show();
									stage.close();

									// set icon of the application
									Image applicationIcon = new Image(getClass()
											.getResourceAsStream("PASicon.png"));
									primaryStage.getIcons().add(applicationIcon);
									

								}
								if (fieldUsername.getText().equals("admin")
										&& fieldPassword.getText().equals("password")) {
									root = FXMLLoader.load(getClass().getResource(
											"/javafx/Queue.fxml"));
									Stage primaryStage = new Stage();
									Scene scene = new Scene(root, 1400, 684);
									primaryStage.setTitle("Queue Page");
									primaryStage.setScene(scene);
									primaryStage.show();
									Stage stage = (Stage) myButton.getScene().getWindow();
									
									// FXML for second stage			        
						            Parent anotherRoot = FXMLLoader.load(getClass().getResource("ReceptionLayout.fxml"));
						            Scene anotherScene = new Scene(anotherRoot);
						            anotherStage.setScene(anotherScene);
									anotherStage.setTitle("Reception Page");
						            anotherStage.show();
									stage.close();

									// set icon of the application
									Image applicationIcon = new Image(getClass()
											.getResourceAsStream("PASicon.png"));
									primaryStage.getIcons().add(applicationIcon);

								}
								if (fieldUsername.getText().equals("doctor")
										&& fieldPassword.getText().equals("password")) {
									root = FXMLLoader.load(getClass().getResource(
											"/javafx/Queue.fxml"));
									Stage primaryStage = new Stage();
									Scene scene = new Scene(root, 1400, 684);
									primaryStage.setTitle("Treatment Room");
									primaryStage.setScene(scene);
									primaryStage.show();
									Stage stage = (Stage) myButton.getScene().getWindow();
									
									// FXML for second stage			        
						            Parent anotherRoot = FXMLLoader.load(getClass().getResource("TreatmentRoomController.fxml"));
						            Scene anotherScene = new Scene(anotherRoot);
						            anotherStage.setScene(anotherScene);
									anotherStage.setTitle("Treatment Room Page");
						            anotherStage.show();
									stage.close();

									// set icon of the application
									Image applicationIcon = new Image(getClass()
											.getResourceAsStream("PASicon.png"));
									primaryStage.getIcons().add(applicationIcon);

								} else {
									loginLabel.setText("Wrong credentials were entered");
								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
			            }
			        }
			        }});
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

	}

}
