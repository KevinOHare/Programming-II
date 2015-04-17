package javafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
	Label firstNameLabel;

	@FXML
	Label surnameLabel;

	@FXML
	Label bloodTypeLabel;

	@FXML
	Label allergiesLabel;
	
	@FXML
	Label beginTimeLabel;

	@FXML
	TextField treatmentDetails;
	
	/*
	@FXML
	private Button myButton;
	*/

	// public static Date startTime = new Date();
	// String startTime;

	// public static Date finishTime;
	// String finishTime;

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://web2.eeecs.qub.ac.uk/40025827";

	// Database credentials
	static final String USER = "40025827";
	static final String PASS = "UYN6542";
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		firstNameLabel.setText("testFirstName");
		
		surnameLabel.setText("testSurname");
		
		bloodTypeLabel.setText("testBloodType");
		
		allergiesLabel.setText("testAllergies");
		
	}

	/**
	 * saves Patients ID, start time, finish time, duration and treatment
	 * details to treatment_log
	 */
	// BUTTON
	@FXML
	private void saveTreatmentDetails() {

		// finishTime = new Date();
		// finishTime = "finish time";
		System.out.println("finish time created");

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

			String treatmentDetailsText = treatmentDetails.getText().toString();

			// *** Assign values to mysql query ***
			command = "INSERT INTO treatment_log VALUES (ID, startTimeString, finishTimeString, appointmentDuration, treatmentDetailsText)";

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
	}

}