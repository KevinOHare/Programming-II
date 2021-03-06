package javafx;

/**
 * import resources
 */
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.stage.Stage;

/**
 * Class that allows a valid user to be able to login to PAS
 * @author chrismcclune
 *
 */
public class LoginController extends Application implements Initializable {

	/**
	 * Label Object for the Login 
	 */
	@FXML
	private Label loginLabel;
	
	/**
	 * TextField object for the username 
	 */
	@FXML
	private TextField fieldUsername;
	
	/**
	 * TextField object for the password
	 */
	@FXML
	private PasswordField fieldPassword;
	
	/**
	 * Button object for the login screen
	 */
	@FXML
	private Button myButton; // value will be injected by the FXMLLoader

	String expectedPassword, usersPermissions, fxmlToLoad, fxmlHeader;

	/**
	 * JDBC driver name and database URL
	 */
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	/**
	 * URL of database connection
	 */
	static final String DB_URL = "jdbc:mysql://web2.eeecs.qub.ac.uk/40025827";

	/**
	 * Database username
	 */
	static final String USER = "40025827";

	/**
	 * Database password
	 */
	static final String PASS = "UYN6542";

	/**
	 * Constant to be used with the valid admin's username
	 */
	static final String validAdminUsername = "admin";
	
	/**
	 * Constant to be used with the valid Triage Nurse's username
	 */
	static final String validTriageUsername = "triage";
	
	/**
	 * Constant to be used with the valid doctor's username
	 */
	static final String validDoctorUsername = "doctor";
	
	/**
	 * Constant to be used with the valid password
	 */
	static final String validPassword = "password";

	/**
	 * Boolean to be used with username/password validation
	 */
	static boolean validationCheck = false;

	/**
	 * Method to display the Java FX windows
	 * @param event
	 * @throws Exception
	 */
	public void display(ActionEvent event) throws Exception {
	}

	/**
	 * Method called by FXMLLoader upon initialization
	 * Overrides initialise in super class
	 */
	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

		assert myButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";

		// initialize your logic here: all @FXML variables will have been
		// injected

		myButton.setOnAction(new EventHandler<ActionEvent>() {
			/**
			 * Method that handles button clicked with mouse
			 */
			@Override
			public void handle(ActionEvent arg0) {
				validateLogin();
				// if valid details are entered then check details against database username/password
				while (validationCheck == true) {
					attemptLogin();
					// reset validation for next login
					validationCheck = false;
				}
			}
		});

		fieldPassword.setOnKeyPressed(new EventHandler<KeyEvent>() {
			/**
			 * Method that handles button pressed with Enter Key
			 */
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					validateLogin();
					// if valid details are entered then check details against database username/password
					while (validationCheck == true) {
						attemptLogin();
						// reset validation for next login
						validationCheck = false;
					}
				}
			}
		});
	}

	/**
	 * Method to connect to the Username / Password Database 
	 */
	public void attemptLogin() {

		// Local Variables
		Connection conn = null;
		Statement stmt = null;

		String findPassword = null;
		String findPermissions = null;

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			stmt = conn.createStatement();
			
			// *** Assign values to mysql insert***
			findPassword = "SELECT password FROM login_details WHERE username = \""
					+ fieldUsername.getText().toString() + "\";";

			// *** Assign values to mysql insert***
			findPermissions = "SELECT permissions FROM login_details WHERE username = \""
					+ fieldUsername.getText().toString() + "\";";

			// findPassword query executed
			ResultSet rs1 = stmt.executeQuery(findPassword);

			while (rs1.next()) {

				expectedPassword = rs1.getString("password");

			}

			if (expectedPassword.equalsIgnoreCase(fieldPassword.getText()
					.toString())) {
				System.out.println("Successful login");
			} else {
				System.out.println("Unsuccesful login");
			}

			// findPermissions query executed
			ResultSet rs2 = stmt.executeQuery(findPermissions);
			while (rs2.next()) {
				usersPermissions = rs2.getString("permissions");
			}

			// loads screen allowed for that user
			switch (usersPermissions) {

			case "reception":
				fxmlToLoad = "ReceptionLayout.fxml";
				fxmlHeader = "Reception Page";
				userLogin();
				break;
			case "triage":
				fxmlToLoad = "Triage.fxml";
				fxmlHeader = "Triage Page";
				userLogin();
				break;
			case "doctor":
				fxmlToLoad = "TreatmentRoom.fxml";
				fxmlHeader = "Treatment Room Page";
				userLogin();
				break;

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

	/**
	 * Method to validate the login details provided by user
	 */
	public void validateLogin() {
		// if username is either 'admin'/'triage'/'doctor' AND password is 'password'
		if ((fieldUsername.getText().equalsIgnoreCase(validAdminUsername)
				|| fieldUsername.getText()
						.equalsIgnoreCase(validTriageUsername) || fieldUsername
				.getText().equalsIgnoreCase(validDoctorUsername))
				&& (fieldPassword.getText().equalsIgnoreCase(validPassword))) {
			// set validation boolean to true
			validationCheck = true;
		} else {
			// else boolean is false and display message
			validationCheck = false;
			System.err.println("Please enter valid username and password");
		}
	}

	/**
	 * Method to set Java FX login
	 */
	public void userLogin() {

		Parent root = null;
		Stage anotherStage = new Stage();

		try {
			root = FXMLLoader
					.load(getClass().getResource("/javafx/Queue.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root, 1400, 684);
		primaryStage.setTitle("Queue Page");
		primaryStage.setScene(scene);
		primaryStage.show();
		Stage stage = (Stage) myButton.getScene().getWindow();

		// FXML for second stage
		Parent anotherRoot = null;
		try {
			anotherRoot = FXMLLoader.load(getClass().getResource(fxmlToLoad));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene anotherScene = new Scene(anotherRoot);
		anotherStage.setScene(anotherScene);
		anotherStage.setTitle(fxmlHeader);
		anotherStage.show();
		stage.close();

		// set icon of the application
		Image applicationIcon = new Image(getClass().getResourceAsStream(
				"PASicon.png"));
		primaryStage.getIcons().add(applicationIcon);

	}

	/**
	 * Method to start Java FX application
	 */
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

	}

}
