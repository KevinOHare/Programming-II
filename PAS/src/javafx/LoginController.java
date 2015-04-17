package javafx;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	// TEXT BOXES

	@FXML
	TextField staffID;

	@FXML
	TextField password;

	// BUTTON

	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {
		// check details first
		if ((staffID.getText().equals("login"))
				&& (password.getText().equals("password"))) {
			// open new window centred
			Parent root = FXMLLoader.load(getClass().getResource(
					"ReceptionLayout.fxml"));
			Scene scene = new Scene(root, 630, 650);
			Stage stage = (Stage) ((Node) event.getSource()).getScene()
					.getWindow();
			stage.setScene(scene);
			stage.setTitle("Reception Screen");
			stage.centerOnScreen();
			stage.show();
		}

	}

}
