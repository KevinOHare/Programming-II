package javafx;

import javafx.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.TextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

public class TreatmentRoomController implements Initializable {

	// TEXT FIELDS
	@FXML
	public static TextField firstNameText;

	@FXML
	public static TextField surnameText;

	@FXML
	public static TextField bloodTypeText;

	@FXML
	public static TextField allergiesText;

	@FXML
	public static TextField treatmentDetailsText;

	// public static Date startTime = new Date();
	public static TextField startTimeText;

	// public static Date finishTime;
	public static String finishTimeText;

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://web2.eeecs.qub.ac.uk/40025827";

	// Database credentials
	static final String USER = "40025827";
	static final String PASS = "UYN6542";

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		firstNameText.setText("testFirstName");

		surnameText.setText("testSurname");

		bloodTypeText.setText("testBloodType");

		allergiesText.setText("testAllergies");

		startTimeText.setText("testStartTime");

	}

	/**
	 * saves Patients ID, start time, finish time, duration and treatment
	 * details to treatment_log
	 */
	public static void saveTreatmentDetails() {

		// test message to make sure method begins running
		System.out.println("saveTreatmentDetails invoked");

		// Local Variables
		Connection conn = null;
		Statement stmt = null;

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

			// Passed in values being applied to SQL query

			String ID = "test";

			// String startTimeString = startTime.toString();
			String startTimeString = "test";

			// String finishTimeString = finishTime.toString();
			String finishTimeString = "test";

			// int appointmentDuration = startTime.compareTo(finishTime);
			int appointmentDuration = 0;

			String treatmentDetailsString = treatmentDetailsText.getText()
					.toString();

			// *** Assign values to mysql query ***
			command = "INSERT INTO treatment_log VALUES (ID, startTimeString, finishTimeString, appointmentDuration, treatmentDetailsString)";

			// *** Result Set ***
			ResultSet rs = stmt.executeQuery(command);

			// command execution flag
			System.out.println("Command executed");

			// STEP 6: Clean-up environment
			rs.close();
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
		System.out.println("Goodbye!");
	}// end main

	// BUTTON
	@FXML
	private void handleButtonAction() {

		// finishTime = new Date();
		finishTimeText = "finish time";
		System.out.println("finish time created");

		saveTreatmentDetails();

	}

}