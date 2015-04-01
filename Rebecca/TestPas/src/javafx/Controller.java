package javafx;

import java.awt.Button;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import database.JDBC_class;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable {

	// BUTTON SEARCH

	@FXML
	private void handleButtonAction() {
		  enterSearch();
		}

	// DEFINE DATABASE SEARCH

	@FXML
	TextField enterFirst;

	@FXML
	TextField enterSurname;

	@FXML
	TextField enterNHSnum;

	@FXML
	ChoiceBox enterBox;

	@FXML
	TextField dbAns;
	
	// DEFINE TABLE

	@FXML
	TableView<Table> tableID;

	@FXML
	TableColumn<Table, String> FirstName;

	@FXML
	TableColumn<Table, String> LastName;

	@FXML
	TableColumn<Table, Integer> nhsNumber;

	// DEFINE VARIABLES
	// **DEMO
	ArrayList<Table> ar = new ArrayList<Table>();
	Table t1 = new Table("Joanne", "Kennedy", 19384);
	Table t2 = new Table("Kelly", "Dole", 48593);
	Table t3 = new Table("Jamie", "Call", 57829);
	Table t4 = new Table("Doran", "Blur", 69034);
	Table t5 = new Table("Joe", "Wicke", 95737);
	

	// **** ****

	// CREATE TABLE DATA
	ObservableList<Table> data = FXCollections.observableArrayList(t1, t2, t3,
			t4, t5);

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// TABLE VIEW

		FirstName.setCellValueFactory(new PropertyValueFactory<Table, String>(
				"FirstName"));
		LastName.setCellValueFactory(new PropertyValueFactory<Table, String>(
				"LastName"));
		nhsNumber.setCellValueFactory(new PropertyValueFactory<Table, Integer>(
				"Position"));

		tableID.setItems(data);

		// TEXT FIELDS

		//enterSearch();
		// firstStr = enterFirst.getText();
		// surnameStr = enterSurname.getText();
		// nhsStr = Integer.parseInt(enterNHSnum.getText());
		
		
	}

	/**
	 * A method called by the 'Search Patient' button to search the 
	 * database for a Patient
	 */
	public void enterSearch() {
		
		JDBC_class db = new JDBC_class();
		db.databaseSearch(enterFirst.getText(), enterSurname.getText(), enterNHSnum.getText());
		
		if (!db.traceCond()){
			dbAns.setText("Patient details Found");
		} else {
			dbAns.setText("No details found - Exception ex");
		}
	}

}