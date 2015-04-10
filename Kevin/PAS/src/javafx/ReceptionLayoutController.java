package javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import database.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ReceptionLayoutController implements Initializable {

	// LOCAL VARIABLES

	public static String nhsPass;
	public static String firstNamePass;
	public static String lastNamePass;
	public static String allergyPass;
	
	String tempAllergy;

	// TEXT FIELDS

	@FXML
	TextField firstName;

	@FXML
	TextField lastName;

	@FXML
	TextField postcode;

	@FXML
	TextField id;

	// BUTTON

	@FXML
	private void handleButtonAction() {
		data.clear();
		searchDB();
	}

	@FXML
	private void handleActionNewPage(ActionEvent event) throws IOException {
		// assign strings for the Triage table
		nhsPass = id.getText();
		firstNamePass = rt.getFirstName();
		lastNamePass = rt.getLastName();
		allergyPass = tempAllergy;
		
		// check if the search has produced a result
		if (!data.isEmpty()) {
			// open new window centred
			Parent root = FXMLLoader
					.load(getClass().getResource("Triage.fxml"));
			Scene scene = new Scene(root, 500, 400);
			Stage stage = (Stage) ((Node) event.getSource()).getScene()
					.getWindow();
			stage.setScene(scene);
			stage.setTitle("Triage Screen");
			stage.centerOnScreen();
			stage.show();
		}
	}

	// TABLE PROPERTIES
	@FXML
	TableView<ReceptionLayoutTable> tableID;

	@FXML
	TableColumn<ReceptionLayoutTable, String> tableTitle;

	@FXML
	TableColumn<ReceptionLayoutTable, String> tableFirstName;

	@FXML
	TableColumn<ReceptionLayoutTable, String> tableLastName;

	@FXML
	TableColumn<ReceptionLayoutTable, String> tableStreet;

	@FXML
	TableColumn<ReceptionLayoutTable, String> tableCity;

	@FXML
	TableColumn<ReceptionLayoutTable, String> tablePostcode;

	@FXML
	TableColumn<ReceptionLayoutTable, String> tableTelephone;

	// CREATE TABLE

	ReceptionLayoutTable rt = new ReceptionLayoutTable();

	ObservableList<ReceptionLayoutTable> data = FXCollections
			.observableArrayList();

	// Method to pull text from text fields
	// and call the JDBC class to get the
	// information needed
	public void searchDB() {
		// instance class
		JDBC db = new JDBC();

		// search database
		db.databaseSearch(firstName.getText(), lastName.getText(),
				postcode.getText(), id.getText());

		// assign string results of database to
		// reception table class object here
		String[] ar = db.rsetPrint();

		// take string objects from db search
		// to a string value
		String str1 = ar[0];
		String str2 = ar[1];
		String str3 = ar[2];
		String str4 = ar[3];
		String str5 = ar[4];
		String str6 = ar[5];
		String str7 = ar[6];
		// get the allergy for Triage screen
		tempAllergy = ar[7];

		// set string values to ReceptionLayoutTable
		// object
		rt.setTitle(str1);
		rt.setFirstName(str2);
		rt.setLastName(str3);
		rt.setStreet(str4);
		rt.setCity(str5);
		rt.setPostcode(str6);
		rt.setTelephone(str7);

		// get the object variables
		rt.getTitle();
		rt.getFirstName();
		rt.getLastName();
		rt.getStreet();
		rt.getCity();
		rt.getPostcode();
		rt.getTelephone();
		
		// add to observable array list
		data.addAll(rt);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// TABLE VIEW
		tableTitle
				.setCellValueFactory(new PropertyValueFactory<ReceptionLayoutTable, String>(
						"title"));
		tableFirstName
				.setCellValueFactory(new PropertyValueFactory<ReceptionLayoutTable, String>(
						"firstName"));
		tableLastName
				.setCellValueFactory(new PropertyValueFactory<ReceptionLayoutTable, String>(
						"lastName"));
		tableStreet
				.setCellValueFactory(new PropertyValueFactory<ReceptionLayoutTable, String>(
						"street"));
		tableCity
				.setCellValueFactory(new PropertyValueFactory<ReceptionLayoutTable, String>(
						"city"));
		tablePostcode
				.setCellValueFactory(new PropertyValueFactory<ReceptionLayoutTable, String>(
						"postcode"));
		tableTelephone
				.setCellValueFactory(new PropertyValueFactory<ReceptionLayoutTable, String>(
						"telephone"));

		// set data to table id for show results
		tableID.setItems(data);

	}


}
