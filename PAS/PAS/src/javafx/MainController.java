package javafx;

import java.awt.Button;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController implements Initializable {

	// BUTTON
	
	@FXML
	Button button;
	
	
	// DEFINE TEXT FIELDS
	
	@FXML
	TextField enterFirst;
	
	@FXML
	TextField enterSurname;
	
	@FXML
	TextField enterNHSnum;
	
	// Local variables
	String firstStr = "0";
	String surnameStr = "0";
	int nhsStr = 0;

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
	//private int Number = 1;

	// **DEMO
	ArrayList<Table> ar = new ArrayList<Table>();
	Table t1 = new Table("Joanne", "Kennedy", 19384);
	Table t2 = new Table("Kelly", "Dole", 48593);
	Table t3 = new Table("Jamie", "Call", 57829);
	Table t4 = new Table("Doran", "Blur", 69034);
	Table t5 = new Table("Joe", "Wicke", 95737);
	Table t6 = new Table(firstStr, surnameStr, nhsStr);
	
	// **** ****
		
	// CREATE TABLE DATA
	ObservableList<Table> data = FXCollections.observableArrayList(
			t1, t2, t3, t4, t5
	);


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
		
		firstStr = enterFirst.getText();
		surnameStr = enterSurname.getText();
		//nhsStr = Integer.parseInt(enterNHSnum.getText());
	}
}