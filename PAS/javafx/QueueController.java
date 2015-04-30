package javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.ResourceBundle;
import java.util.SortedSet;
import java.util.TreeSet;

import com.twilio.sdk.TwilioRestException;

import onCallMessage.OnCallMessage;
import queue.OnCallTeamThread;
import queue.PatientThread;
import queue.TreatmentRoomThread;
import NHSsystem.OnCallTeam;
import NHSsystem.Patient;
import NHSsystem.TreatmentRoom;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

public class QueueController implements Initializable {

	// VALUES TO BE PASSED ON TO OTHER CLASSES

	public static String strFirstName;
	public static String strLastName;
	public static String strAllergy;
	public static String strBloodType;

	// FXML ID TAGS

	@FXML
	ChoiceBox triageListNum;

	@FXML
	ChoiceBox triagePriority;

	@FXML
	ChoiceBox treatBox;

	@FXML
	ChoiceBox treatNumTime;
	
	@FXML
	ChoiceBox searchTriage;
	
	@FXML
	TextField searchFirst;
	
	@FXML
	TextField searchNhs;
	
	@FXML
	TextArea searchDisplay;
	

	@FXML
	private void handleButtonTriage() {
		// take the entered number in the linked list for patient
		int llistNum = Integer.parseInt((String) triageListNum.getValue());
		llistNum--; // remove 1 as dealing with an array

		// take the entered triage priority and set it to the
		// selected linked list patient number
		int priNum = Integer.parseInt((String) triagePriority.getValue());
		llist.get(llistNum).setTriage(priNum);
	}

	@FXML
	private void handleButtonTreat() throws IOException {
		// take the entered number in the linked list for treatment room
		int num = Integer.parseInt((String) treatBox.getValue());
		num--; // remove 1 as dealing with an array

		// pass in strings for labels in TreatmentRoomController
		strFirstName = treat.get(num).getPatient().getFirstName();
		strLastName = treat.get(num).getPatient().getLastName();
		strAllergy = treat.get(num).getPatient().getAllergy();
		strBloodType = treat.get(num).getPatient().getBloodType();
		// open new window for Treatment Room
		Stage anotherStage = new Stage();
		Parent anotherRoot = FXMLLoader.load(getClass().getResource(
				"TreatmentRoom.fxml"));
		Scene anotherScene = new Scene(anotherRoot);
		anotherStage.setScene(anotherScene);
		anotherStage.setTitle("Treatment Room Page");
		anotherStage.show();
	}

	@FXML
	private void handleButtonTreatTimerEx() {
		extensionOfTime();
	}
	
	@FXML
	private void handleButtonSearchFunction(){
		searchMethod();
	}

	// INSTANCES FOR PATIENT OBJECT

	static ArrayList<Patient> alist = new ArrayList<Patient>();

	static LinkedList<Patient> llist = new LinkedList<Patient>();

	static SortedSet<Patient> sort = new TreeSet<Patient>();

	static PriorityQueue<Patient> pQueue = new PriorityQueue<Patient>();

	public static String[] stringPa = new String[10];

	// INSTANCES FOR TREATMENT ROOM OBJECT

	static LinkedList<TreatmentRoom> treat = new LinkedList<TreatmentRoom>();

	static TreatmentRoom[] treatAr = new TreatmentRoom[5];

	static TreatmentRoom room1 = new TreatmentRoom(1, true);
	static TreatmentRoom room2 = new TreatmentRoom(2, true);
	static TreatmentRoom room3 = new TreatmentRoom(3, true);
	static TreatmentRoom room4 = new TreatmentRoom(4, true);
	static TreatmentRoom room5 = new TreatmentRoom(5, true);

	public static String[] stringAr = new String[5];

	// INSTANCE FOR ON CALL TEAM

	static OnCallTeam onCallTeam = new OnCallTeam();

	// Boolean to check whether a new Patient can be added
	// to queue
	static Boolean bool = false;

	// Boolean to keep queue working
	static Boolean boolQ = true;

	// Check duplicate patients
	static String duplicate = " ";

	// instance of OnCallMessage
	static OnCallMessage call = new OnCallMessage();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// **** Treatment Rooms ****

		treat.add(room1);
		treat.add(room2);
		treat.add(room3);
		treat.add(room4);
		treat.add(room5);

		// Thread run in the background to produce the queue
		Runnable r = new Runnable() {
			public synchronized void run() {
				while (boolQ = true) {

					// Local variable
					int count = 1;

					// call to method to check if new patients
					// can be added
					try {
						addToQueue();
					} catch (TwilioRestException e2) {
						// error message
						e2.printStackTrace();
						System.out.println("Could not send message");
					}

					// method to sort java collections
					sortingQueue();

					// print treatment room to console
					System.out.println("****** Treatment Room *******");
					System.out
							.println("Room Number \t Room Available?    Patient Details ");
					for (TreatmentRoom tr : treat) {
						System.out.println(tr.toString());
					}

					// check the status code
					statusCodeUpdate();

					// print details for console for patient
					System.out.println("********** Queue ************");
					System.out
							.println("Name\t\t  Address & Contact Details & ID number");
					// check if a Patient can get into a treatment room
					for (Patient as : llist) {

						// print patient in queue
						System.out.println(count + ". " + as.toString());
						// Numbering of patients in queue
						count++;
						if (count < 11) {
							count = 1;
						}

						// check rooms are available
						if (treat.get(0).isAvailable() == true) {
							System.out.println("\n*** " + as.getFirstName()
									+ " " + as.getLastName()
									+ " to treatment room 1 please. ***");
							treat.get(0).setPatient(as);
							treat.get(0).setAvailable(false);
							// start count for treatment room
							// using Treatment room thread
							startTimer(treat.get(0));
							// a boolean assigned within patient
							// object to execute the remove later
							as.setInRoom(true);
							llist.remove(as);
						} else if (treat.get(1).isAvailable() == true) {
							System.out.println("\n*** " + as.getFirstName()
									+ " " + as.getLastName()
									+ " to treatment room 2 please. ***");
							treat.get(1).setPatient(as);
							treat.get(1).setAvailable(false);
							// start count for treatment room
							// using Treatment room thread
							startTimer(treat.get(1));
							// a boolean assigned within patient
							// object to execute the remove later
							as.setInRoom(true);
							llist.remove(as);
						} else if (treat.get(2).isAvailable() == true) {
							System.out.println("\n*** " + as.getFirstName()
									+ " " + as.getLastName()
									+ " to treatment room 3 please. ***");
							treat.get(2).setPatient(as);
							treat.get(2).setAvailable(false);
							// start count for treatment room
							// using Treatment room thread
							startTimer(treat.get(2));
							// a boolean assigned within patient
							// object to execute the remove later
							as.setInRoom(true);
							llist.remove(as);
						} else if (treat.get(3).isAvailable() == true) {
							System.out.println("\n*** " + as.getFirstName()
									+ " " + as.getLastName()
									+ " to treatment room 4 please. ***");
							treat.get(3).setPatient(as);
							treat.get(3).setAvailable(false);
							// start count for treatment room
							// using Treatment room thread
							startTimer(treat.get(3));
							// a boolean assigned within patient
							// object to execute the remove later
							as.setInRoom(true);
							llist.remove(as);
						} else if (treat.get(4).isAvailable() == true) {
							System.out.println("\n*** " + as.getFirstName()
									+ " " + as.getLastName()
									+ " to treatment room 5 please. ***");
							treat.get(4).setPatient(as);
							treat.get(4).setAvailable(false);
							// start count for treatment room
							// using Treatment room thread
							startTimer(treat.get(4));
							// a boolean assigned within patient
							// object to execute the remove later
							as.setInRoom(true);
							llist.remove(as);
						}
					}

					// to remove patients from the list that are in
					// treatment rooms
					for (int i = 0; i < llist.size(); i++) {
						if (llist.get(i).getInRoom() == true) {
							llist.remove(llist.get(i));
						}
					}

					// check patient is emergency and put in a
					// treatment room
					for (int l = 0; l < llist.size(); l++) {
						if (llist.get(l).getTriage() == 1) {
							// check to remove a non-emergency patient
							// from treatment room if an emergency patient
							// needs a treatment room
							try {
								removePatientFromTreat(llist.get(l));
								llist.remove(llist.get(l));
							} catch (TwilioRestException tre) {
								tre.printStackTrace();
								System.out
										.println("Could not send message to on call team");
							}

						}
					}

					// check if the treatment rooms are finished
					// with patients
					if (treat.getFirst().getCountTimer() == 599) {
						treat.getFirst().setAvailable(true);
						// treat.remove(treat.getFirst().getPatient());
						treat.getFirst().setPatient(null);
						treat.getFirst().setCountTimer(0);
					}
					if (treat.get(1).getCountTimer() == 599) {
						treat.get(1).setAvailable(true);
						treat.get(1).setPatient(null);
						treat.get(1).setCountTimer(0);

					}
					if (treat.get(2).getCountTimer() == 599) {
						treat.get(2).setAvailable(true);
						treat.get(2).setPatient(null);
						treat.get(2).setCountTimer(0);

					}
					if (treat.get(3).getCountTimer() == 599) {
						treat.get(3).setAvailable(true);
						treat.get(3).setPatient(null);
						treat.get(3).setCountTimer(0);
					}
					if (treat.getLast().getCountTimer() == 599) {
						treat.getLast().setAvailable(true);
						treat.getLast().setPatient(null);
						treat.getLast().setCountTimer(0);
					}

					// call method to check if patient has
					// exceeded the queue limits
					try {
						checkQueueTimerLimit();
					} catch (TwilioRestException e1) {
						e1.printStackTrace();
						System.out.println("Could not send message to manager");
					}

					// print on call team to console
					System.out
							.println("\n************ On Call Team ***********\n");
					System.out.println("Available? \t Patient Details");
					System.out.println(onCallTeam.toString());

					System.out
							.println("\n*****************************************\n");
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		new Thread(r).start();
	}

	/**
	 * A method to invoke the treatment room thread class timer count
	 * 
	 * @param tr
	 */
	public static void startTimer(TreatmentRoom tr) {

		// instantiate classes to activate the
		// start time at the queue
		TreatmentRoomThread thr = new TreatmentRoomThread(tr);
		Runnable r = new Runnable() {
			public synchronized void run() {
				thr.run();
			}
		};
		new Thread(r).start();
	}

	/**
	 * A method to invoke the on call team thread class thread timer count
	 * 
	 * @param oct
	 */
	public static void startTimer(OnCallTeam oct) {

		// instantiate classes to activate the
		// start time at the queue
		OnCallTeamThread octt = new OnCallTeamThread(oct);
		Runnable r = new Runnable() {
			public synchronized void run() {
				octt.run();
			}
		};
		new Thread(r).start();
	}

	/**
	 * A method to instantiate the information from Triage controller to add to
	 * queue
	 * 
	 * @throws TwilioRestException
	 */
	public void addToQueue() throws TwilioRestException {
		// Instance of Triage Controller
		TriageController tc = new TriageController();

		// find out if triage controller has data
		// in order to add data to patient object
		if ((tc.firstNamePass != null) && (tc.firstNamePass != duplicate)) {

			// check linked list size is 10
			if (llist.size() <= 9) {

				// Instance of the Patient object
				Patient ptq = new Patient();

				ptq.setFirstName(tc.firstNamePass);
				ptq.setLastName(tc.lastNamePass);
				ptq.setTriage(tc.triagePass);

				ptq.setAllergy(tc.allergyPass);
				ptq.setBloodType(tc.bloodTypePass);

				// start patient thread
				PatientThread pt = new PatientThread(ptq);
				Runnable rr = new Runnable() {
					public synchronized void run() {
						pt.run();
					}
				};
				new Thread(rr).start();

				// add to linked list array
				llist.add(ptq);

				// reset values
				tc.firstNamePass = null;
				tc.tableLastName = null;
				// tc.triagePass = 0;
				duplicate = tc.firstNamePass;

			} else {
				// queue is full of non-emergency
				// patients
				call.ManagerMessage1();

			}
		}
	}

	/**
	 * a method to sort the java collections
	 */
	public void sortingQueue() {

		Collections.sort(llist);
	}

	/**
	 * A method to update the queue based on the status of the longest waiting
	 * patient in the queue
	 */
	public void statusCodeUpdate() {
		// automatically updating status code based on waiting times
		// iterate through the queue and find the highest waiting time
		int status = 1; // Default code
		int countValue;
		int currentMax = 0;

		// checking the highest time in queue
		for (int i = 0; i < llist.size(); i++) {
			countValue = llist.get(i).getCountTimer();
			if (countValue > currentMax) {
				currentMax = countValue;
			}
		}

		// if linked list queue is greater than or
		// is 10
		if (llist.size() == 10) {
			status = 4;
		}
		// set the status code based on the
		// highest timed patient in queue
		else if (currentMax >= 0 && currentMax < 10) {
			status = 1;
		} else if (currentMax >= 10 && currentMax < 20) {
			status = 2;
		} else if (currentMax >= 20) {
			status = 3;
		}

		System.out.println("*********** Status Code *****************");
		// print out the status code
		System.out.println("Waititng time status code: " + status);
		if (status == 4){
			System.out.println("**Queue is Full**");
		}
	}

	/**
	 * check each patient in queue to check if a on call message is needed to be
	 * sent to Hospital Manager
	 * 
	 * @throws TwilioRestException
	 */
	public void checkQueueTimerLimit() throws TwilioRestException {
		// Local variable
		int count = 0;

		for (int i = 0; i < llist.size(); i++) {
			// 25 mins has passed - 1500milsec
			if (llist.get(i).getCountTimer() == 1500) {
				// set triage to 2 so patient
				// can move up queue
				llist.get(i).setTriage(2);
			}
			// 30 mins has passed - 1800milsec
			if (llist.get(i).getCountTimer() == 1800) {
				// set patient beyound
				llist.get(i).setPatientMin(1);
			}
		}

		// cycle through and check if 30min
		// limit is hit by any patient
		for (int i = 0; i < llist.size(); i++) {
			count += llist.get(i).getPatientMin();
			if (llist.get(i).getPatientMin() == 1) {
				llist.remove(llist.get(i));
			}
		}

		if (count == 3) {
			OnCallMessage.ManagerMessage2();
		}
		if (count == 2) {
			OnCallMessage.ManagerMessage2();
		}
	}

	/**
	 * a method to remove patients in a treatment room to make way for an
	 * emergency patient
	 * 
	 * @param Patient
	 * @throws TwilioRestException
	 */
	public void removePatientFromTreat(Patient pt) throws TwilioRestException {
		// Local variable
		Boolean bool = false;

		// check treatment rooms for patient less than
		// emergency (or 1)
		for (int i = 0; i < treat.size(); i++) {
			if (treat.get(i).getPatient().getTriage() == 1) {
				// *do nothing
				// set bool for on call message
				bool = true;
			} else if ((treat.get(i).getPatient().getTriage() == 2)
					|| (treat.get(i).getPatient().getTriage() == 3)
					|| (treat.get(i).getPatient().getTriage() == 4)) {
				// adjust triage priority
				treat.get(i).getPatient().setTriage(2);// set as higher priority
				// treat.get(i).getPatient().getTriage();
				// add back to queue list
				llist.add(treat.get(i).getPatient());
				// set patient here to null
				treat.get(i).setPatient(null);
				treat.get(i).setCountTimer(0);

				// add emergency patient
				pt.setInRoom(true);
				treat.get(i).setPatient(pt);
				treat.get(i).getPatient();
				startTimer(treat.get(i));

				// set bool to not call message
				bool = false;

				break;
			}
			break;
		}

		// message call
		if (bool = true) {
			// call message for queue full
			OnCallMessage.OnCallTeamMessage();
			onCallTeam.setPatient(pt);
		}
	}

	/**
	 * a method to extend the time of a patient in a treatment room
	 */
	public void extensionOfTime() {
		// Local variable
		int resetTime = 30;

		// get the patient in chosen treatment
		// room and extend treat timer
		int num = Integer.parseInt((String) treatNumTime.getValue());
		num--; // remove 1 as dealing with an array

		startTimer(treat.get(num));
	}
	
	/**
	 * a search method used to find the patient as
	 * entered in the queue fxml
	 */
	public void searchMethod(){
		//searchTriage.getText();
		//searchFirst.getText();
		
		//searchNhs.getText();
		
	
		//searchDisplay.setText();
	}

}// ************************end of class**********************
