package javafx;

import java.net.URL;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;
import javafx.QueueController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class waitingRoomController {
	
	@FXML
	static Label tRoom1;
	@FXML
	Label tRoom2;
	@FXML
	Label tRoom3;
	@FXML
	Label tRoom4;
	@FXML
	Label tRoom5;

	@FXML
	Label qPosition1;
	@FXML
	Label qPosition2;
	@FXML
	Label qPosition3;
	@FXML
	Label qPosition4;
	@FXML
	Label qPosition5;
	@FXML
	Label qPosition6;
	@FXML
	Label qPosition7;
	@FXML
	Label qPosition8;
	@FXML
	Label qPosition9;
	@FXML
	Label qPosition10;
	
	public static String tRoom1Text = QueueController.strFirstName + QueueController.strLastName;
	
	public static void main(String args[]){
		
		System.out.println("String tRoom1Text = "+tRoom1Text);
		
		// test message ensuring initialize begins
				System.out.println("WRController initialising begins");
				
				tRoom1.setText("testing set text");

				System.out.println("Current tRoom patient = ");
						//+ QueueController.treat.get(0).getPatient().getFirstName());

				// label text set by values from queue
				//tRoom1.setText(QueueController.treat.get(0).getPatient().getFirstName());
				
				System.out.println("Now the tRoom patient = "
						+ QueueController.treat.get(0).getPatient().getFirstName());

				// test message ensuring setting label finishes
				System.out.println("WRController Labels text set");

	}
	
}
