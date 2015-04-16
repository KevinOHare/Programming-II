package javafx;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import NHSsystem.Patient;
import NHSsystem.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class QueueController implements Initializable {

	// DEFINE TABLE
	
	@FXML
	TableView<QueueTable> tableID;
	
	@FXML
	TableColumn<QueueTable, String> enterFirst;
	
	@FXML
	TableColumn<QueueTable, String> enterSurname;
	
	@FXML
	TableColumn<QueueTable, Integer> enterTimeStart;
	
	@FXML
	TableColumn<QueueTable, Integer> enterTimeWaiting;
	
	@FXML
	TableColumn<QueueTable, String> enterCondition;
		
	// ********* test *******
	QueueTable p1 = new QueueTable("pat5", "sur1", 2, 10, "arm broke");
	QueueTable p2 = new QueueTable("pat4", "sur2", 2, 11, "bleeding");
	QueueTable p3 = new QueueTable("pat2", "sur3", 3, 9, "broke nose");
	QueueTable p4 = new QueueTable("pat1", "sur4", 3, 14, "mouth bleed");
	QueueTable p5 = new QueueTable("pat3", "sur5", 4, 16, "knee lost");
	
	// ***************************
	
	// SET UP JAVA COLLECTIONS
	ArrayList<QueueTable> pr = new ArrayList<QueueTable>();
	
	HashSet<QueueTable> eo = new HashSet<QueueTable>(pr);
	
	Queue<QueueTable> qt = new LinkedList<QueueTable>(eo);
	
	
	// CREATE TABLE DATA
	ObservableList<QueueTable> data = FXCollections.observableArrayList();
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// method call for data
		
	    arrayToTable();
		
	    //Set<QueueTable> sf = new HashSet<QueueTable>(pr);
	    //data.addAll(sf);
	    
	    //HashSet<QueueTable> eo = new HashSet<QueueTable>(pr);
	    //ArrayList<QueueTable> ir = new ArrayList<QueueTable>(eo);
	    //data.addAll(ir);
		
		
		// TABLE VIEW
		
		enterFirst.setCellValueFactory(new PropertyValueFactory<QueueTable, String>(
				"firstName"));
		enterSurname.setCellValueFactory(new PropertyValueFactory<QueueTable, String>(
				"surname"));
		enterTimeStart.setCellValueFactory(new PropertyValueFactory<QueueTable, Integer>(
				"timeEntered"));
		enterTimeWaiting.setCellValueFactory(new PropertyValueFactory<QueueTable, Integer>(
				"timeWait"));
		enterCondition.setCellValueFactory(new PropertyValueFactory<QueueTable, String>(
				"Condition"));
		
		tableID.setItems(data);
		
		
	}
	
	public void arrayToTable(){
		// add to array list
		pr.add(p1);
		pr.add(p2);
		pr.add(p3);
		pr.add(p4);
		pr.add(p5);
		
		// add data 
		data.addAll(pr);
		
	}

}
