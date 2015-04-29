package javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.ResourceBundle;
import java.util.SortedSet;
import java.util.TreeSet;

import com.twilio.sdk.TwilioRestException;

import onCallMessage.OnCallMessage;
import queue.PatientThread;
import queue.TreatmentRoomThread;
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
import javafx.stage.Stage;
import javafx.util.Duration;

public class QueueController implements Initializable {

	// VALUES TO BE PASSED ON TO OTHER CLASSES

	public String strFirstName;
	public String strLastName;
	public String strAllergy;
	public String strBloodType;

	// FXML ID TAGS

	@FXML
	ChoiceBox triageListNum;

	@FXML
	ChoiceBox triagePriority;

	@FXML
	ChoiceBox treatBox;

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
		anotherStage.setTitle("Triage Page");
		anotherStage.show();
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

		// **********************TEST*********************
		/*
		 * Patient pat1 = new Patient("Mr", "Steven", "Kennedy", "45 road",
		 * "Lisburn", "BT67 524", "098 38563", "3759-283", 3, false); Patient
		 * pat2 = new Patient("Ms", "June", "Campbell", "20 road", "Lisburn",
		 * "BT23 524", "234 4263", "3234-83", 4, false); Patient pat3 = new
		 * Patient("Mr", "Philip", "White", "94 road", "Hillsborough",
		 * "BT57 254", "234 4543", "0568-283", 2, false); Patient pat4 = new
		 * Patient("Mrs", "Mary", "Kelly", "60 road", "Moria", "BT57 092",
		 * "689 2583", "3452-039", 1, true); Patient pat5 = new Patient("Mr",
		 * "Conner", "Lee", "10 road", "Anahilt", "BT59 203", "582 9385",
		 * "0429-3458", 3, false); Patient pat6 = new Patient("Mrs", "Will",
		 * "Goon", "85 road", "Kilea", "BT20 578", "098 3490", "0694-3829", 4,
		 * false); Patient pat7 = new Patient("Mr", "Red", "Wright", "02 road",
		 * "Belfast", "BT03 039", "485 3020", "9592-2985", 3, false); Patient
		 * pat8 = new Patient("Ms", "Kelly", "Goodman", "58 road", "Lisburn",
		 * "BT28 394", "509 3853", "9837-3029", 2, false); Patient pat9 = new
		 * Patient("Mr", "Kevin", "Ken", "95 road", "Hillsborough", "BT02 984",
		 * "039 3085", "303-59387", 4, false); Patient pat10 = new Patient("Ms",
		 * "Rachel", "Lenvine", "03 road", "Moria", "BT28 828", "493 03895",
		 * "294-3985", 1, true);
		 */

		/*
		 * llist.add(pat1); llist.add(pat2); llist.add(pat3); llist.add(pat4);
		 * llist.add(pat5); llist.add(pat6); llist.add(pat7); llist.add(pat8);
		 * llist.add(pat9);
		 */
		// ***************************************************

		// Thread run in the background to produce the queue
		Runnable r = new Runnable() {
			public void run() {
				while (boolQ = true) {

					// call to method to check if new patients
					// can be added
					addToQueue();

					// to add and cycle through arrays
					addingToArrays();

					// **

					/*
					 * for (Patient sa : llist) { // add to priority queue
					 * pQueue.add(sa);
					 * 
					 * }
					 * 
					 * llist.clear();
					 */
					// add to sort queue
					for (Patient ae : pQueue) {
						// add to sort queue

						sort.add(ae);
					}

					// add to sort queue
					for (Patient ae : sort) {
						// add to sort queue

						llist.add(ae);
					}

					// **

					// print treatment room to console
					System.out.println("****** Treatment Room *******");
					System.out
							.println("Room Number \t Room Available?    Patient Details ");
					for (TreatmentRoom tr : treat) {
						System.out.println(tr.toString());
					}

					// print details for console for patient
					System.out.println("********** Queue ************");
					System.out
							.println("Name\t\t  Address & Contact Details & ID number");
					// check if a Patient can get into a treatment room
					for (Patient as : llist) {
						// print patient in queue
						System.out.println(as.toString());

						// check rooms are available
						if (treat.getFirst().isAvailable() == true) {
							treat.getFirst().setPatient(as);
							treat.getFirst().setAvailable(false);
							// start count for treatment room
							// using Treatment room thread
							startTimer(treat.getFirst());
							// a boolean assigned within patient
							// object to execute the remove later
							as.setInRoom(true);
						} else if (treat.get(1).isAvailable() == true) {
							treat.get(1).setPatient(as);
							treat.get(1).setAvailable(false);
							// start count for treatment room
							// using Treatment room thread
							startTimer(treat.get(1));
							// a boolean assigned within patient
							// object to execute the remove later
							as.setInRoom(true);
						} else if (treat.get(2).isAvailable() == true) {
							treat.get(2).setPatient(as);
							treat.get(2).setAvailable(false);
							// start count for treatment room
							// using Treatment room thread
							startTimer(treat.get(2));
							// a boolean assigned within patient
							// object to execute the remove later
							as.setInRoom(true);
						} else if (treat.get(3).isAvailable() == true) {
							treat.get(3).setPatient(as);
							treat.get(3).setAvailable(false);
							// start count for treatment room
							// using Treatment room thread
							startTimer(treat.get(3));
							// a boolean assigned within patient
							// object to execute the remove later
							as.setInRoom(true);
						} else if (treat.get(4).isAvailable() == true) {
							treat.get(4).setPatient(as);
							treat.get(4).setAvailable(false);
							// start count for treatment room
							// using Treatment room thread
							startTimer(treat.get(4));
							// a boolean assigned within patient
							// object to execute the remove later
							as.setInRoom(true);
						} else if (treat.getLast().isAvailable() == true) {
							treat.getLast().setPatient(as);
							treat.getLast().setAvailable(false);
							// start count for treatment room
							// using Treatment room thread
							startTimer(treat.getLast());
							// a boolean assigned within patient
							// object to execute the remove later
							as.setInRoom(true);
						}
					}

					// check patient is emergency and put in a
					// treatment room
					for (int l = 0; l < llist.size(); l++) {
						if (llist.get(l).getTriage() == 1) {
							// check to remove a non-emergency patient
							// from treatment room if an emergency patient
							// needs a treatment room
							removePatientFromTreat(llist.get(l));
							llist.remove(llist.get(l));
						}
					}

					// to remove patients from the list that are in
					// treatment rooms
					for (int i = 0; i < llist.size(); i++) {
						if (llist.get(i).getInRoom() == true) {
							llist.remove(llist.get(i));

						}
					}

					// check if the treatment rooms are finished
					// with patients
					if (treat.getFirst().getCountTimer() == 49) {
						treat.getFirst().setAvailable(true);
						// treat.remove(treat.getFirst().getPatient());
						treat.getFirst().setPatient(null);
						treat.getFirst().setCountTimer(0);
					}
					if (treat.get(1).getCountTimer() == 49) {
						treat.get(1).setAvailable(true);
						treat.get(1).setPatient(null);
						treat.get(1).setCountTimer(0);

					}
					if (treat.get(2).getCountTimer() == 49) {
						treat.get(2).setAvailable(true);
						treat.get(2).setPatient(null);
						treat.get(2).setCountTimer(0);

					}
					if (treat.get(3).getCountTimer() == 49) {
						treat.get(3).setAvailable(true);
						treat.get(3).setPatient(null);
						treat.get(3).setCountTimer(0);
					}
					if (treat.getLast().getCountTimer() == 49) {
						treat.getLast().setAvailable(true);
						treat.getLast().setPatient(null);
						treat.getLast().setCountTimer(0);
					}

					// call method to check if patient has
					// exceeded the queue limits
					checkQueueTimerLimit();

					/*
					 * // print on call team to console
					 * System.out.println("\n******On Call Team******\n");
					 * 
					 * // prints out whether or not the on call team is
					 * available if (onCallTeam.isAvailable() == true) {
					 * System.out.println("Current status: Available"); } else
					 * if (onCallTeam.isAvailable() == false) {
					 * System.out.println("Current status: Engaged"); // print
					 * out details of patient here }
					 */

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
			public void run() {
				thr.run();
			}
		};
		new Thread(r).start();
	}

	/**
	 * A method to cycle through the array collections to order, organise and
	 * begin the Patient thread
	 */
	public void addingToArrays() {

		if (bool == true) {

			for (Patient ft : llist) {
				PatientThread pt = new PatientThread(ft);
				Runnable rr = new Runnable() {
					public void run() {
						pt.run();
					}
				};
				new Thread(rr).start();
				// llist.add(ft);
			}

			bool = false;
			/*
			 * for (int i = 0; i < alist.size(); i++) { alist.remove(i); }
			 */
		}

		/*
		 * // check if Patient object can be added (with the // 10 limit of
		 * Patients) and a boolean to check if // the Patient is new if ((bool
		 * == true)) {
		 * 
		 * // add to array list for (Patient sa : alist) { // add to priority
		 * queue pQueue.add(sa); }
		 * 
		 * // add to sort queue for (Patient ae : pQueue) { // add to sort queue
		 * 
		 * sort.add(ae); }
		 * 
		 * // add to array list for editing // the working queue for (Patient ju
		 * : sort) { // instantiate classes to activate the // start time at the
		 * queue PatientThread pt = new PatientThread(ju); Runnable rr = new
		 * Runnable() { public void run() { pt.run(); } }; new
		 * Thread(rr).start(); llist.add(ju); } // prevent adding unless a new
		 * // patient is added bool = false; }
		 */
	}

	/**
	 * A method to instantiate the information from Triage controller to add to
	 * queue
	 */
	public void addToQueue() {
		// Instance of Triage Controller
		TriageController tc = new TriageController();

		// Instance of the Patient object
		Patient ptq = new Patient();

		// find out if triage controller has data
		// in order to add data to patient object
		if ((tc.firstNamePass != null) && (tc.firstNamePass != duplicate)) {

			// check linked list size is 10
			if (llist.size() < 10) {
				ptq.setFirstName(tc.firstNamePass);
				ptq.setLastName(tc.lastNamePass);
				ptq.setTriage(tc.triagePass);
				
				ptq.setAllergy(tc.allergyPass);
				ptq.setBloodType(tc.bloodTypePass);
				
				

				// add to array for sorting
				llist.add(ptq);

				// ************test**********
				/*
				 * Patient pat1 = new Patient("Mr", "Steven", "Kennedy",
				 * "45 road", "Lisburn", "BT67 524", "098 38563", "3759-283", 3,
				 * false); Patient pat2 = new Patient("Ms", "June", "Campbell",
				 * "20 road", "Lisburn", "BT23 524", "234 4263", "3234-83", 4,
				 * false); Patient pat3 = new Patient("Mr", "Philip", "White",
				 * "94 road", "Hillsborough", "BT57 254", "234 4543",
				 * "0568-283", 2, false); Patient pat4 = new Patient("Mrs",
				 * "Mary", "Kelly", "60 road", "Moria", "BT57 092", "689 2583",
				 * "3452-039", 1, true); Patient pat5 = new Patient("Mr",
				 * "Conner", "Lee", "10 road", "Anahilt", "BT59 203",
				 * "582 9385", "0429-3458", 3, false); Patient pat6 = new
				 * Patient("Mrs", "Will", "Goon", "85 road", "Kilea",
				 * "BT20 578", "098 3490", "0694-3829", 4, false); Patient pat7
				 * = new Patient("Mr", "Red", "Wright", "02 road", "Belfast",
				 * "BT03 039", "485 3020", "9592-2985", 3, false);
				 * llist.add(pat1); llist.add(pat2); llist.add(pat3);
				 * llist.add(pat4); llist.add(pat5); llist.add(pat6);
				 * llist.add(pat7);
				 */
				// ****************************************

				// allow access for addingToArrays()
				bool = true;
				// reset values
				tc.firstNamePass = null;
				tc.tableLastName = null;
				// tc.triagePass = 0;
				duplicate = tc.firstNamePass;
				
			} else {
				// queue is full of non-emergency
				// patients
				//call.ManagerMessage1();
				
			}
		}
	}

	/**
	 * check each patient in queue to check if a on call message is needed to be
	 * sent to Hospital Manager
	 * @throws TwilioRestException 
	 */
	public void checkQueueTimerLimit() throws TwilioRestException {
		// Local variable
		int count = 0;

		// cycle through and check if 30min
		// limit is hit by any patient
		for (int i = 0; i < llist.size(); i++) {
			count += llist.get(i).getPatientMin();
			if (llist.get(i).getPatientMin() == 1) {
				llist.remove(llist.get(i));
			}
		}
		if (count == 2) {
			call.ManagerMessage2();
		}
	}

	/**
	 * a method to remove patients in a treatment room to make way for an
	 * emergency patient
	 * 
	 * @param Patient
	 * @throws TwilioRestException 
	 */
	public void removePatientFromTreat(Patient pt) throws TwilioRestException{
		// Local variable
		Boolean bool = false;
		
		// check treatment rooms for patient less than 
		// emergency (or 1)
		for (int i = 0; i < treat.size(); i++){
			if (treat.get(i).getPatient().getTriage() == 1){
				//*do nothing
				// set bool for on call message
				bool = true;
			} else if ((treat.get(i).getPatient().getTriage() >= 2) || (treat.get(i).getPatient().getTriage() <= 4)) {
				// adjust triage priority
				treat.get(i).getPatient().setTriage(1);
				treat.get(i).getPatient().getTriage();
				// add back to queue list
				llist.add(treat.get(i).getPatient());
				// set patient here to null
				treat.get(i).setPatient(null);
				treat.get(i).setCountTimer(0);
				
				// add emergency patient
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
		if (bool = true){
			// call message for queue full
			call.ManagerMessage1();
		}	
	}
	
}//************************end of class**********************
