package javafx;

import java.awt.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TriageController implements Initializable {

	// BUTTON

	@FXML
	private void handleButtonAction() {
		data.clear();
		// selected item from choice box
		String str = (String) box.getValue();
		setData(str);
	}

	@FXML
	private void handleButtonNextPage(ActionEvent event) throws IOException {
		// open new window centred
		Parent root = FXMLLoader.load(getClass().getResource("Queue.fxml"));
		Scene scene = new Scene(root, 600, 550);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Queue Screen");
		stage.centerOnScreen();
		stage.show();
	}

	// CHOICEBOX

	@FXML
	ChoiceBox box;

	// TABLE PROPERTIES

	@FXML
	TableView<TriageTable> tableID;

	@FXML
	TableColumn<TriageTable, String> tableNhs;

	@FXML
	TableColumn<TriageTable, String> tableFirstName;

	@FXML
	TableColumn<TriageTable, String> tableLastName;

	@FXML
	TableColumn<TriageTable, String> tableAllergy;

	@FXML
	TableColumn<TriageTable, String> tableCondition;

	// CREATE TABLE

	ObservableList<TriageTable> data = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		setData();

		// TABLE VIEW
		tableNhs.setCellValueFactory(new PropertyValueFactory<TriageTable, String>(
				"nhs"));
		tableFirstName
				.setCellValueFactory(new PropertyValueFactory<TriageTable, String>(
						"firstName"));
		tableLastName
				.setCellValueFactory(new PropertyValueFactory<TriageTable, String>(
						"lastName"));
		tableAllergy
				.setCellValueFactory(new PropertyValueFactory<TriageTable, String>(
						"allergy"));
		tableCondition
				.setCellValueFactory(new PropertyValueFactory<TriageTable, String>(
						"condition"));

		// set data to table id for show results
		tableID.setItems(data);

	}

	/**
	 * a method to set the data of the table
	 */
	public void setData() {

		// Instance Variables
		TriageTable tt = new TriageTable();
		ReceptionLayoutController rlc = new ReceptionLayoutController();

		// Local Variables
		String str = (String) box.getValue();

		// set values for table
		tt.setNhs(rlc.nhsPass);
		tt.setFirstName(rlc.firstNamePass);
		tt.setLastName(rlc.lastNamePass);
		tt.setAllergy(rlc.allergyPass);
		// Default non-urgent = 4
		tt.setCondition(4);

		// get values for table
		tt.getNhs();
		tt.getFirstName();
		tt.getLastName();
		tt.getAllergy();
		tt.getCondition();

		// add TriageTable object to the table
		data.addAll(tt);

	}

	/**
	 * a method to set the data of the table
	 * 
	 * @param strg
	 */
	public void setData(String strg) {

		// Instance Variables
		TriageTable tt = new TriageTable();
		ReceptionLayoutController rlc = new ReceptionLayoutController();

		// set values for table
		tt.setNhs(rlc.nhsPass);
		tt.setFirstName(rlc.firstNamePass);
		tt.setLastName(rlc.lastNamePass);
		tt.setAllergy(rlc.allergyPass);
		// entered value from choice box
		tt.setCondition(triageBox(strg));

		// get values for table
		tt.getNhs();
		tt.getFirstName();
		tt.getLastName();
		tt.getAllergy();
		tt.getCondition();

		// add TriageTable object to the table
		data.addAll(tt);

	}

	/**
	 * a method to add a priority number to the table
	 * 
	 * @param str
	 * @return temp
	 */
	public int triageBox(String str) {
		// check the triage priority set
		int temp = 0;
		switch (str) {
		case "1. Emergency":
			temp = TriageEnum.EMERGENCY.getPosition();
			break;
		case "2. Urgent":
			temp = TriageEnum.URGENT.getPosition();
			break;
		case "3. Semi-Urgent":
			temp = TriageEnum.SEMI_URGENT.getPosition();
			break;
		case "4. Non-Urgent":
			temp = TriageEnum.NON_URGENT.getPosition();
		}
		return temp;
	}

}
