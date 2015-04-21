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
	TextField firstName;
	
	@FXML
	public static TextField surname;
	
	@FXML
	public static TextField bloodType;
	
	@FXML
	public static TextField allergies;
	
	@FXML
	public static TextField treatmentDetails;

	//public static Date startTime = new Date();
	public static String startTime;
	
	//public static Date finishTime;
	public static String finishTime;

	
	public static void main(String[] args) {

		//startTime = new Date();
		startTime = "test";
		System.out.println("startTime created");

	}
	

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://web2.eeecs.qub.ac.uk/40025827";

	// Database credentials
	static final String USER = "40025827";
	static final String PASS = "UYN6542";

	// create treatment details string array
	static String[] detailsstr = new String[5];

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

			//String startTimeString = startTime.toString();
			String startTimeString = "test";

			//String finishTimeString = finishTime.toString();
			String finishTimeString = "test";

			//int appointmentDuration = startTime.compareTo(finishTime);
			int appointmentDuration = 0;

			String treatmentDetailsText = treatmentDetails.getText().toString();

			// *** Assign values to mysql query ***
			command = "INSERT INTO treatment_log VALUES (ID, startTimeString, finishTimeString, appointmentDuration, treatmentDetailsText)";

			// *** Result Set ***
			ResultSet rs = stmt.executeQuery(command);

			// command execution flag
			System.out.println("Command executed");

			// prints results to console
			/*
			 * // STEP 5: Extract data from result set // Cycle through database
			 * for the result set while (rs.next()) { // Retrieve by column name
			 * 
			 * // *** cycle through result set and assign values *** String
			 * rset1 = rs.getString("ID"); String rset2 =
			 * rs.getString("Started"); String rset3 = rs.getString("Finished");
			 * String rset4 = rs.getString("Duration"); String rset5 =
			 * rs.getString("Details");
			 * 
			 * // *** Test *** System.out.println(rset1 + " | " + rset2 + " | "
			 * + rset3 + " | " + rset4 + " | \n" + rset5);
			 * 
			 * // assign values to str array detailsstr[0] = rset1;
			 * detailsstr[1] = rset2; detailsstr[2] = rset3; detailsstr[3] =
			 * rset4; detailsstr[4] = rset5;
			 * 
			 * }
			 */

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

	/**
	 * A method to return the rsets of the correct patient search
	 * @return rsets
	 */
	public String[] rsetPrint() {
		// local variable
		return detailsstr;
	}
	
	// ************** class ************

	// BUTTON
	@FXML
	private void handleButtonAction() {

		//finishTime = new Date();
		finishTime = "finish time";
		System.out.println("finish time created");

		saveTreatmentDetails();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}