package javafx;

import javafx.*;
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

	// Labels and TextArea from TreatmentRoom.fxml
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
	TextArea treatmentDetailsTextArea;

	// startTime instantiated upon window opening
	public static Date startTime = new Date();
	// finishTime not instantiated until save button selected
	public static Date finishTime;

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://web2.eeecs.qub.ac.uk/40025827";

	// Database credentials
	static final String USER = "40025827";
	static final String PASS = "UYN6542";

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		System.out.println("initialising begins");

		firstNameLabel.setText("test firstName");

		surnameLabel.setText("test surname");

		bloodTypeLabel.setText("test blood type");

		allergiesLabel.setText("test allergies");

		beginTimeLabel.setText(startTime.toString());

		System.out.println("initialising ends");

	}

	// BUTTON
	@FXML
	private void handleSaveAndClearButtonAction() {

		finishTime = new Date();
		// System.out.println("finish time created");

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
			System.out.println("statement created");

			// Passed in values being applied to SQL query
			System.out.println("setting input vars");
			String ID = "test ID 10";

			String startTimeString = startTime.toString();

			String finishTimeString = finishTime.toString();

			long appointmentDuration = (finishTime.getTime() - startTime
					.getTime()) / 60000;

			String treatmentDetailsString = treatmentDetailsTextArea.getText()
					.toString();

			System.out.println("input vars set");

			System.out.println("About to set command");
			// *** Assign values to mysql query ***
			command = "INSERT INTO treatment_log VALUES ('" + ID + "', '"
					+ startTimeString + "', '" + finishTimeString + "', '"
					+ appointmentDuration + "', '" + treatmentDetailsString
					+ "')";
			System.out.println("command set");

			// *** Result Set ***
			stmt.executeUpdate(command);

			// command execution flag
			System.out.println("Command executed");

			// STEP 6: Clean-up environment
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
}