package javafx;

/**
 * inport resources
 */
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

import database.JDBC;

/**
 * Class to show the Treatment Room and control its functions
 * @author chrismcclune
 *
 */
public class TreatmentRoomController implements Initializable {

	/**
	 * Label object for the first name
	 */
	@FXML
	Label firstNameText;
	
	/**
	 * Label object for the last name
	 */
	@FXML
	Label surnameText;
	
	/**
	 * Label object for the blood type
	 */
	@FXML
	Label bloodTypeText;
	
	/**
	 * Label object for the allergies
	 */
	@FXML
	Label allergiesText;
	
	/**
	 * Label object for the start time of treatment
	 */
	@FXML
	Label beginTimeText;
	
	/**
	 * TextArea object for the doctor's notes for the treatment
	 */
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
	 * Method to override iniatise in super class
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// test message ensuring initialize begins
		System.out.println("initialising begins");

		if (QueueController.strFirstName == "Unknown Male" || QueueController.strFirstName == "Unknown Female"){
		// label text set by values from queue
		firstNameText.setText(QueueController.strFirstName);
		surnameText.setText(QueueController.strLastName);
		bloodTypeText.setText("Unknown");
		allergiesText.setText(QueueController.strAllergy);
		beginTimeText.setText(startTime.toString());}
		
		else{
		// label text set by values from queue
		firstNameText.setText(QueueController.strFirstName);
		surnameText.setText(QueueController.strLastName);
		bloodTypeText.setText(QueueController.strBloodType);
		allergiesText.setText(QueueController.strAllergy);
		beginTimeText.setText(startTime.toString());
		}
		// test message ensuring setting label finishes
		System.out.println("Labels text set");

	}

	/**
	 * Method for the save and clear Button handler
	 */
	@SuppressWarnings("null")
	@FXML
	private void handleSaveAndClearButtonAction() {

		// finishTime now instantiated upon saving
		finishTime = new Date();

		// Local Variables
		Connection conn = null;
		Statement stmt = null;

		// open the connection to the database
		JDBC.openConnection();

			// Create a query
			try {
				stmt = conn.createStatement();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			System.out.println("Statement created");

			// to be replaced by value from queue
			String NHS_Number = TriageTable.nhs;

			// start and finish times
			String startTimeString = startTime.toString();
			String finishTimeString = finishTime.toString();
			// time difference converted from milliseconds to minutes
			String appointmentDuration = (long) (finishTime.getTime() - startTime.getTime()) / 60000
					+ "m" + (long) ((finishTime.getTime() - startTime.getTime()) % 60000) / 1000 + "s";

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
			try {
				stmt.executeUpdate(insertCommand);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Command executed");

			JDBC.closeConnection();

			// reset texts to empty
		firstNameText.setText("");
		surnameText.setText("");
		bloodTypeText.setText("");
		allergiesText.setText("");
		beginTimeText.setText("");
		treatmentDetailsText.setText("");

		System.out.println("Goodbye!");
	}
}