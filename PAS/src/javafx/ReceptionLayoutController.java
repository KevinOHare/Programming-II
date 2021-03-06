package javafx;

/**
 * import resources
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

/**
 * Class to show the reception layout and control its functions
 * 
 * @author chrismcclune
 *
 */
public class ReceptionLayoutController implements Initializable {

	/**
	 * String used to make title available to other classes
	 */
	public static String titlePass;

	/**
	 * String used to make nhs number available to other classes
	 */
	public static String nhsPass;

	/**
	 * String used to make first name available to other classes
	 */
	public static String firstNamePass;

	/**
	 * String used to make last name available to other classes
	 */
	public static String lastNamePass;

	/**
	 * String used to make allergy available to other classes
	 */
	public static String allergyPass;

	/**
	 * String used to make blood type available to other classes.=
	 */
	public static String bloodTypePass;

	/**
	 * Boolean used to show if user input of NHS number is correct
	 */
	public static boolean NHSValidation;

	/**
	 * Boolean used to show if user input of first name is correct
	 */
	public static boolean firstNameValidation;

	/**
	 * Boolean used to show if user input of last name is correct
	 */
	public static boolean lastNameValidation;

	/**
	 * Boolean used to show if user input of postcode is correct
	 */
	public static boolean postcodeValidation;

	/**
	 * String used to assign allergy of patient
	 */
	public static String tempAllergy;

	/**
	 * String used to assign blood type of patient
	 */
	public static String tempBloodType;

	/**
	 * TextField object for the first name
	 */
	@FXML
	TextField firstName;

	/**
	 * TextField object for the last name
	 */
	@FXML
	TextField lastName;

	/**
	 * TextField object for the postcode
	 */
	@FXML
	TextField postcode;

	/**
	 * TextField object for the id
	 */
	@FXML
	TextField id;

	/**
	 * TableView object for the ID
	 */
	@FXML
	TableView<ReceptionLayoutTable> tableID;

	/**
	 * TableColumn object for the title
	 */
	@FXML
	TableColumn<ReceptionLayoutTable, String> tableTitle;

	/**
	 * TableColumn object for the first name
	 */
	@FXML
	TableColumn<ReceptionLayoutTable, String> tableFirstName;

	/**
	 * TableColumn object for the last name
	 */
	@FXML
	TableColumn<ReceptionLayoutTable, String> tableLastName;

	/**
	 * TableColumn object for the Street
	 */
	@FXML
	TableColumn<ReceptionLayoutTable, String> tableStreet;

	/**
	 * TableColumn object for the City
	 */
	@FXML
	TableColumn<ReceptionLayoutTable, String> tableCity;

	/**
	 * TableColumn object for the postcode
	 */
	@FXML
	TableColumn<ReceptionLayoutTable, String> tablePostcode;

	/**
	 * TableColumn object for the telephone number
	 */
	@FXML
	TableColumn<ReceptionLayoutTable, String> tableTelephone;

	// create Table object
	ReceptionLayoutTable rt = new ReceptionLayoutTable();
	TriageTable tt = new TriageTable();
	// create observable list
	ObservableList<ReceptionLayoutTable> data = FXCollections
			.observableArrayList();

	/**
	 * Method to override initialize in super class
	 */
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

	/**
	 * Method to handle the action of the clear button
	 */
	@FXML
	private void handleButtonAction() {
		data.clear();

		NHSValidation = false;
		firstNameValidation = false;
		lastNameValidation = false;
		postcodeValidation = false;

		validateUserInput();

		while (NHSValidation && firstNameValidation && lastNameValidation
				&& postcodeValidation) {
			searchDB();
			break;
		}
	}

	/**
	 * Method to handle the action of moving to the next page
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void handleActionNewPage(ActionEvent event) throws IOException {
		// assign strings for the Triage table
		titlePass = rt.getTitle();
		nhsPass = id.getText();
		firstNamePass = rt.getFirstName();
		lastNamePass = rt.getLastName();

		if (tempAllergy == null) {
			allergyPass = "N/A";
		} else {
			allergyPass = tempAllergy;
		}
		bloodTypePass = tempBloodType;

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

	/**
	 * Method to access patient data from the database
	 */
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
		// get the allergy and blood type for Triage screen
		tempAllergy = ar[7];
		tempBloodType = ar[8];

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

	/**
	 * Method to validate the users input client side
	 */
	@FXML
	public void validateUserInput() {
		// validate firstName input
		String firstNameCheck = firstName.getText();
		if (firstNameCheck.length() > 0) {
			firstNameValidation = true;
		} else {
			firstName.setPromptText("Please enter first name");
		}

		// validate lastName input
		String lastNameCheck = lastName.getText();
		if (lastNameCheck.length() > 0) {
			lastNameValidation = true;
		} else {
			lastName.setPromptText("Please enter last name");
		}

		// validate postcode input
		String postcodeCheck = postcode.getText();
		String regexp = "^(GIR ?0AA|[A-PR-UWYZ]([0-9]{1,2}|([A-HK-Y][0-9]([0-9ABEHMNPRV-Y])?)|[0-9][A-HJKPS-UW]) ?[0-9][ABD-HJLNP-UW-Z]{2})$";

		// create pattern from regular expression
		Pattern pattern = Pattern.compile(regexp);
		// match user input to the valid pattern
		Matcher matcher = pattern.matcher(postcodeCheck.toUpperCase());

		if (matcher.matches()) {
			postcodeValidation = true;
		} else {
			postcode.setPromptText("Please enter valid postcode");
		}

		// validate NHS number input
		String NHSCharacters = id.getText();
		if (NHSCharacters.length() == 10) {
			NHSValidation = true;
		} else {
			id.setPromptText("Enter valid NHS number");
		}
	}

	/**
	 * Method to Handle the action of the button to add a new unknown male
	 * emergency
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void handleButtonAUM(ActionEvent event) throws IOException {
		// assign strings for the Triage table
		nhsPass = "0000000001";
		firstNamePass = tt.setFirstName("Unknown Male");
		lastNamePass = tt.setLastName("Unknown Male");
		allergyPass = tt.setAllergy("N/A");

		// check if the search has produced a result
		// open new window centred
		Parent root = FXMLLoader.load(getClass().getResource("Triage.fxml"));
		Scene scene = new Scene(root, 500, 400);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Triage Screen");
		stage.centerOnScreen();
		stage.show();
	}

	/**
	 * Method to handle the action of the button to add a new unknown female
	 * emergency
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void handleButtonAUF(ActionEvent event) throws IOException {
		// assign strings for the Triage table

		nhsPass = "0000000000";
		firstNamePass = tt.setFirstName("Unknown Female");
		lastNamePass = tt.setLastName("Unknown Female");
		allergyPass = tt.setAllergy("N/A");

		// check if the search has produced a result
		// open new window centred
		Parent root = FXMLLoader.load(getClass().getResource("Triage.fxml"));
		Scene scene = new Scene(root, 500, 400);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Triage Screen");
		stage.centerOnScreen();
		stage.show();
	}
}
