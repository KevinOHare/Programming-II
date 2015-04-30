package javafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

public class TreatmentRoomController implements Initializable {

	/**
	 * Labels and TextArea from TreatmentRoom.fxml
	 */
	@FXML
	Label firstNameText;
	@FXML
	Label surnameText;
	@FXML
	Label bloodTypeText;
	@FXML
	Label allergiesText;
	@FXML
	Label beginTimeText;
	@FXML
	TextArea treatmentDetailsText;

	/**
	 * startTime instantiated upon window opening
	 */
	public static Date startTime = new Date();
	/**
	 * finishTime not instantiated until save button selected
	 */
	public static Date finishTime;

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// test message ensuring initialize begins
		System.out.println("initialising begins");

		// label text set by values from queue
		firstNameText.setText(QueueController.strFirstName);
		surnameText.setText(QueueController.strLastName);
		bloodTypeText.setText(QueueController.strBloodType);
		allergiesText.setText(QueueController.strAllergy);
		beginTimeText.setText(startTime.toString());

		// test message ensuring setting label finishes
		System.out.println("Labels text set");

	}

	// BUTTON
	@FXML
	private void handleSaveAndClearButtonAction() {

		// finishTime now instantiated upon saving
		finishTime = new Date();

		// Local Variables
		Connection conn = null;
		Statement stmt = null;

		try {
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Create a query
			stmt = conn.createStatement();
			System.out.println("Statement created");

			// to be replaced by value from queue
			String NHS_Number = TriageTable.nhs;

			// start and finish times
			String startTimeString = startTime.toString();
			String finishTimeString = finishTime.toString();
			// time difference converted from milliseconds to minutes
			String appointmentDuration = (long) (finishTime.getTime() - startTime
					.getTime())
					/ 60000
					+ "m"
					+ (long) ((finishTime.getTime() - startTime.getTime()) % 60000)
					/ 1000 + "s";

			// doctors manually entered treatment details
			String treatmentDetailsString = treatmentDetailsText.getText()
					.toString();

			// test message
			System.out.println("input vars set");

			// test message
			System.out.println("About to set command");
			// *** Assign values to mysql insert***
			String insertCommand = "INSERT INTO treatment_log (NHS,Started,Finished,Duration,Details) VALUES ( '"
					+ NHS_Number
					+ "','"
					+ startTimeString
					+ "','"
					+ finishTimeString
					+ "','"
					+ appointmentDuration
					+ "','"
					+ treatmentDetailsString + "')";
			System.out.println("command set");

			// command executed
			stmt.executeUpdate(insertCommand);
			System.out.println("Command executed");

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

		firstNameText.setText("");
		surnameText.setText("");
		bloodTypeText.setText("");
		allergiesText.setText("");
		beginTimeText.setText("");
		treatmentDetailsText.setText("");

		System.out.println("Goodbye!");
	}// end main
}