package javafx;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import database.JDBC;

public class TreatmentRoomController {

	String treatmentDetailsText;

	// TEXT FIELDS

	@FXML
	TextField treatmentDetails;

	private void saveTreatmentDetails() {

		treatmentDetailsText = treatmentDetails.getText().toString();

		//JDBC db = new JDBC();

	}

}
