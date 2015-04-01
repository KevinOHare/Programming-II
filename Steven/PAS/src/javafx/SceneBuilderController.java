package javafx;

import java.awt.Button;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.ResourceBundle;

import database.JDBC;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SceneBuilderController implements Initializable {

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

	// DEFINE ADD TO QUEUE

	// check status for message that says person is in the database
	String checkdb;
	
	@FXML
	Button bt;
	
	@FXML
	ChoiceBox triageBox;

	// DEFINE TABLE

	@FXML
	TableView<SceneBuilderTable> tableID;

	@FXML
	TableColumn<SceneBuilderTable, String> FirstName;

	@FXML
	TableColumn<SceneBuilderTable, String> LastName;

	@FXML
	TableColumn<SceneBuilderTable, String> nhsNumber;
	
	@FXML
	TableColumn<SceneBuilderTable, String> triage;

	
	// CREATE TABLE DATA
	
	PriorityQueue<SceneBuilderTable> que = new PriorityQueue<SceneBuilderTable>();
	
	ObservableList<SceneBuilderTable> data = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
		// TABLE VIEW

		FirstName.setCellValueFactory(new PropertyValueFactory<SceneBuilderTable, String>(
				"FirstName"));
		LastName.setCellValueFactory(new PropertyValueFactory<SceneBuilderTable, String>(
				"LastName"));
		nhsNumber.setCellValueFactory(new PropertyValueFactory<SceneBuilderTable, String>(
				"Position"));
		triage.setCellValueFactory(new PropertyValueFactory<SceneBuilderTable, String>("triage"));
		
		tableID.setItems(data);

	}

	/**
	 * A method called by the 'Search Patient' button to search the database for
	 * a Patient
	 */
	public void enterSearch() {

		JDBC db = new JDBC();
		db.databaseSearch(enterFirst.getText(), enterSurname.getText(),
				enterNHSnum.getText());

		if (!db.traceCond()) {
			dbAns.setText("Patient details Found");
			checkdb = dbAns.getText();
		} else {
			dbAns.setText("No details found - Exception ex");
		}
	}
	
	/**
	 * A method to check for the checkdb message and add data to the table
	 * @param event
	 */
	public void onAddItem(ActionEvent event){
		
		if (checkdb.contentEquals("Patient details Found")) {
		
			String str = (String) triageBox.getValue();
		System.out.println(triageBox.getValue());
		
			
		SceneBuilderTable entry = new SceneBuilderTable(enterFirst.getText(), enterSurname.getText(), enterNHSnum.getText());
		entry.setTriage(str);
		entry.getTriage();
	
		
		data.clear();
		que.add(entry);
		// data.add(entry);
		
		//Table t1 = new Table("name", "LastName", "Position");
		//que.add(t1);
		
		//for(Table t: que){
		//	data.add(t);
		//}
		
		
		for (SceneBuilderTable tb: que){
			data.add(tb);
		}
		//System.out.println(que.peek().getFirstName());
		enterFirst.clear();
		enterSurname.clear();
		enterNHSnum.clear();
		dbAns.clear();
		}
	}

	

		


}