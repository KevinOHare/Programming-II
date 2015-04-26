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

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class LoginController extends Application implements Initializable {

	@FXML
	private Label loginLabel;

	@FXML
	private TextField fieldUsername;

	@FXML
	private PasswordField fieldPassword;

	@FXML
	private Button myButton; // value will be injected by the FXMLLoader

	/**
	 * JDBC driver name and database URL
	 */
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://web2.eeecs.qub.ac.uk/40025827";

	/**
	 * Database credentials
	 */
	static final String USER = "40025827";
	static final String PASS = "UYN6542";

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

				// Local Variables
				Connection conn = null;
				Statement stmt = null;

				java.sql.PreparedStatement preparedCon;

				try {
					// STEP 2: Register JDBC driver
					Class.forName("com.mysql.jdbc.Driver");

					// STEP 3: Open a connection
					System.out.println("Connecting to database...");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);

					// STEP 4: Execute a query
					System.out.println("Creating statement...\n");
					stmt = conn.createStatement();
					String command;
					System.out.println("statement created");

					// Passed in values being applied to SQL query
					System.out.println("setting input vars");

					// test message
					System.out.println("input vars set");

					// test message
					System.out.println("About to set command");
					// *** Assign values to mysql insert***
					command = "SELECT password FROM login_details WHERE username = \""
							+ fieldUsername.getText().toString() + "\";";
					// test message
					System.out.println("command set");

					// command executed
					ResultSet rs = stmt.executeQuery(command);
					// test message
					System.out.println("Query executed");

					String expectedPassword = null;

					while (rs.next()) {

						expectedPassword = rs.getString("password");

					}

					System.out.println("Expected = " + expectedPassword);
					System.out.println("Actual = "
							+ fieldPassword.getText().toString());

					if (expectedPassword.equalsIgnoreCase(fieldPassword
							.getText().toString())) {
						System.out.println("Successful login");
					} else {
						System.out.println("Unsuccesful login");
					}

					// Clean-up environment
					stmt.close();
					conn.close();

				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();

				} catch (Exception e) {
					// Handle errors for Class.forName
					e.printStackTrace();

				} finally {
					// finally block used to close resources
					try {
						if (stmt != null)
							stmt.close();
					} catch (SQLException se2) {
					}// nothing we can do
					try {
						if (conn != null)
							conn.close();
					} catch (SQLException se) {
						se.printStackTrace();
					}// end finally try
				}// end try
			
	}

	public void triageLogin() {

		Parent root;

		Stage anotherStage = new Stage();

		Parent anotherRoot;

		root = FXMLLoader.load(getClass().getResource("/javafx/Queue.fxml"));
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root, 1400, 684);
		primaryStage.setTitle("Queue Page");
		primaryStage.setScene(scene);
		primaryStage.show();
		Stage stage = (Stage) myButton.getScene().getWindow();

		// FXML for second stage Parent anotherRoot =
		FXMLLoader.load(getClass().getResource("Triage.fxml"));
		Scene anotherScene = new Scene(anotherRoot);
		anotherStage.setScene(anotherScene);
		anotherStage.setTitle("Triage Page");
		anotherStage.show();
		stage.close();

		// set icon of the application Image applicationIcon =
		// new
		Image(getClass().getResourceAsStream("PASicon.png"));
		primaryStage.getIcons().add(applicationIcon);

	}

	public void adminLogin() {

		root = FXMLLoader.load(getClass().getResource("/javafx/Queue.fxml"));
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root, 500, 250);
		primaryStage.setTitle("Queue Page");
		primaryStage.setScene(scene);
		primaryStage.show();
		Stage stage = (Stage) myButton.getScene().getWindow();

		// FXML for second stage Parent anotherRoot =
		FXMLLoader.load(getClass().getResource("ReceptionLayout.fxml"));
		Scene anotherScene = new Scene(anotherRoot);
		anotherStage.setScene(anotherScene);
		anotherStage.setTitle("Reception Page");
		anotherStage.show();
		stage.close();

		// set icon of the application Image applicationIcon =
		// new
		Image(getClass().getResourceAsStream("PASicon.png"));
		primaryStage.getIcons().add(applicationIcon);

	}

	public void doctorLogin() {

		root = FXMLLoader.load(getClass().getResource("/javafx/Queue.fxml"));
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root, 1400, 684);
		primaryStage.setTitle("Treatment Room");
		primaryStage.setScene(scene);
		primaryStage.show();
		Stage stage = (Stage) myButton.getScene().getWindow();

		// FXML for second stage Parent anotherRoot =
		FXMLLoader.load(getClass().getResource("TreatmentRoom.fxml"));
		Scene anotherScene = new Scene(anotherRoot);
		anotherStage.setScene(anotherScene);
		anotherStage.setTitle("Treatment Room Page");
		anotherStage.show();
		stage.close();

		// set icon of the application Image applicationIcon =
		// new
		Image(getClass().getResourceAsStream("PASicon.png"));
		primaryStage.getIcons().add(applicationIcon);

	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

	}

}
