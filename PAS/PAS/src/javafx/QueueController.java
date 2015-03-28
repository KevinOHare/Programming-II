package javafx;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class QueueController {


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
	ChoiceBox enterBox;

	@FXML
	TextField dbAns;
	
	// DEFINE TABLE

	@FXML
	TableView<Table> queueTable;

	@FXML
	TableColumn<Table, String> FirstName;

	@FXML
	TableColumn<Table, String> LastName;

	@FXML
	TableColumn<Table, Integer> TimeEntered;
	
	@FXML
	TableColumn<Table, Integer> TimeInQueue;

	@FXML
	TableColumn<Table, String> Condition;

	

	// DEFINE VARIABLES
	// **DEMO
	ArrayList<Table> queue = new ArrayList<Table>();
	Table r1 = new Table("Joanne", "Kennedy", null, 8, "Non-Urgent");
	Table r2 = new Table("Kelly", "Dole", 48593);
	Table r3 = new Table("Jamie", "Call", 57829);
	Table r4 = new Table("Doran", "Blur", 69034);
	Table r5 = new Table("Joe", "Wicke", 95737);

	
	// CREATE TABLE DATA
		ObservableList<Table> data = FXCollections.observableArrayList(r1, r2, r3,
				r4, r5);

}
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
	
}
}