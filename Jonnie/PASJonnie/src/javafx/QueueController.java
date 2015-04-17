package javafx;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.ResourceBundle;
import java.util.SortedSet;
import java.util.TreeSet;

import queue.OnCallTeamQueue;
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
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.util.Duration;

public class QueueController implements Initializable {

	// TEXT AREAS

	@FXML
	TextArea treatmentRoomQueue;

	@FXML
	TextArea patientQueue;

	// INSTANCES FOR PATIENT OBJECT

	static ArrayList<Patient> alist = new ArrayList<Patient>();

	static LinkedList<Patient> llist = new LinkedList<Patient>();

	static SortedSet<Patient> sort = new TreeSet<Patient>();

	static PriorityQueue<Patient> pQueue = new PriorityQueue<Patient>();

	String[] stringPa = new String[10];

	// INSTANCES FOR TREATMENT ROOM OBJECT

	static LinkedList<TreatmentRoom> treat = new LinkedList<TreatmentRoom>();

	static TreatmentRoom[] treatAr = new TreatmentRoom[5];

	static TreatmentRoom room1 = new TreatmentRoom(1, true);
	static TreatmentRoom room2 = new TreatmentRoom(2, true);
	static TreatmentRoom room3 = new TreatmentRoom(3, true);
	static TreatmentRoom room4 = new TreatmentRoom(4, true);
	static TreatmentRoom room5 = new TreatmentRoom(5, true);

	String[] stringAr = new String[5];

	// JL INSTANCES FOR ON CALL TEAM OBJECT
	static LinkedList<OnCallTeam> onCall = new LinkedList<OnCallTeam>();

	static OnCallTeam onCallTeam = new OnCallTeam(true);

	// ************************ TEST DATA ***********************************

	static Patient pat1 = new Patient("Mr", "Steven", "Kennedy", "45 road",
			"Lisburn", "BT67 524", "098 38563", "3759-283", 4);
	static Patient pat2 = new Patient("Ms", "June", "Campbell", "20 road",
			"Lisburn", "BT23 524", "234 4263", "3234-83", 4);
	static Patient pat3 = new Patient("Mr", "Philip", "White", "94 road",
			"Hillsborough", "BT57 254", "234 4543", "0568-283", 4);
	static Patient pat4 = new Patient("Mrs", "Mary", "Kelly", "60 road",
			"Moria", "BT57 092", "689 2583", "3452-039", 4);
	static Patient pat5 = new Patient("Mr", "Conner", "Lee", "10 road",
			"Anahilt", "BT59 203", "582 9385", "0429-3458", 4);
	static Patient pat6 = new Patient("Mrs", "Will", "Goon", "85 road",
			"Kilea", "BT20 578", "098 3490", "0694-3829", 4);
	static Patient pat7 = new Patient("Mr", "Red", "Wright", "02 road",
			"Belfast", "BT03 039", "485 3020", "9592-2985", 3);
	static Patient pat8 = new Patient("Ms", "Kelly", "Goodman", "58 road",
			"Lisburn", "BT28 394", "509 3853", "9837-3029", 2);
	static Patient pat9 = new Patient("Mr", "Kevin", "Ken", "95 road",
			"Hillsborough", "BT02 984", "039 3085", "303-59387", 4);
	static Patient pat10 = new Patient("Ms", "Rachel", "Lenvine", "03 road",
			"Moria", "BT28 828", "493 03895", "294-3985", 1);

	// ************************************************************************

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// **** Treatment Rooms ****

		treat.add(room1);
		treat.add(room2);
		treat.add(room3);
		treat.add(room4);
		treat.add(room5);

		// JL On Call Team

		onCall.add(onCallTeam);

		// **** Patient Queue Arrays ****

		// ******************** TEST DATA ****************
		
		  pQueue.add(pat1); pQueue.add(pat2); pQueue.add(pat3);
		  pQueue.add(pat4); pQueue.add(pat5); pQueue.add(pat6);
		 
		// **************************************************

		// add to array list
		// for (int i = 0; i < alist.size(); i++) {
		// alist.get(i).
		// }

		// add to sort queue
		for (Patient ae : pQueue) {
			// add to sort queue
			sort.add(ae);
		}

		// add to array list for editing
		// the working queue
		for (Patient ju : sort) {
			// instantiate classes to activate the
			// start time at the queue
			PatientThread pt = new PatientThread(ju);
			Runnable rr = new Runnable() {
				public void run() {
					pt.run();
				}
			};
			new Thread(rr).start();
			llist.add(ju);
		}

		// In order to refresh the page every few seconds, the timeline feature
		// is
		// used to carry out the action event below

		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2),
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						
						// JL call to method to check if new emergency
						// patients can be added to treatment rooms
						emergencyPatients();

						// call to method to check if new patients
						// can be added
						addToQueue();

						// *** Treatment Room Queue ***

						// set queue results to string array for
						// printing
						for (int i = 0; i < treat.size(); i++) {
							stringAr[i] = treat.get(i).toString();
						}

						// setting the text box with the refreshed data
						treatmentRoomQueue.setText(stringAr[0] + "\n"
								+ stringAr[1] + "\n" + stringAr[2] + "\n"
								+ stringAr[3] + "\n" + stringAr[4]);

						// *** Patient Queue ***

						// set queue results to string array for
						// printing
						for (int i = 0; i < llist.size(); i++) {
							stringPa[i] = llist.get(i).toString();
						}

						// setting the text box with the refreshed data
						patientQueue.setText(stringPa[0] + "\n" + stringPa[1]
								+ "\n" + stringPa[2] + "\n" + stringPa[3]
								+ "\n" + stringPa[4] + "\n" + stringPa[5]
								+ "\n" + stringPa[6] + "\n" + stringPa[7]
								+ "\n" + stringPa[8] + "\n" + stringPa[9]);

						// check if a Patient can get into a treatment room
						for (Patient as : llist) {

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
						}
						if (treat.get(1).getCountTimer() == 49) {
							treat.get(1).setAvailable(true);
						}
						if (treat.get(2).getCountTimer() == 49) {
							treat.get(2).setAvailable(true);
						}
						if (treat.get(3).getCountTimer() == 49) {
							treat.get(3).setAvailable(true);
						}
						if (treat.get(4).getCountTimer() == 49) {
							treat.get(4).setAvailable(true);
						}
						if (treat.getLast().getCountTimer() == 49) {
							treat.getLast().setAvailable(true);
						}
					}
				}));
		// it will continue to cycle and refresh
		timeline.setCycleCount(Animation.INDEFINITE);
		// begin again
		timeline.play();
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
	 * JL a method to invoke the on call team thread class timer count
	 */
	public static void startTimer(OnCallTeam oct) {

		// instantiate the classes to activate the start time
		OnCallTeamQueue octq = new OnCallTeamQueue(oct);
		Runnable r = new Runnable() {
			public void run() {
				octq.run();
			}
		};
		new Thread(r).start();
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
		if (tc.firstNamePass != null) {
			ptq.setFirstName(tc.firstNamePass);
			ptq.setLastName(tc.lastNamePass);
			ptq.setTriage(tc.triagePass);
			// add to array for sorting
			llist.add(ptq);
		}
	}

	/**
	 * JL A method to send emergency patients straight to treatment room without
	 * joining the queue
	 */
	public void emergencyPatients() {

		// Instance of Triage Controller
		TriageController tc = new TriageController();
		// Instance of the Patient object
		Patient ep = new Patient();

		// find out if triage controller has data
		// in order to add data to patient object
		if (tc.firstNamePass != null) {
			ep.setFirstName(tc.firstNamePass);
			ep.setLastName(tc.lastNamePass);
			ep.setTriage(tc.triagePass);
		}
		
		// if emergency then assign patient to an empty treatment room
		if (ep.getTriage() == 1) {
			if (treat.getFirst().isAvailable() == true) {
				treat.getFirst().setPatient(ep);
				treat.getFirst().setAvailable(false);
				// start count for treatment room
				// using Treatment room thread
				startTimer(treat.getFirst());
				// a boolean assigned within patient
				// object to execute the remove later
				ep.setInRoom(true);
			} else if (treat.get(1).isAvailable() == true) {
				treat.get(1).setPatient(ep);
				treat.get(1).setAvailable(false);
				// start count for treatment room
				// using Treatment room thread
				startTimer(treat.get(1));
				// a boolean assigned within patient
				// object to execute the remove later
				ep.setInRoom(true);
			} else if (treat.get(2).isAvailable() == true) {
				treat.get(2).setPatient(ep);
				treat.get(2).setAvailable(false);
				// start count for treatment room
				// using Treatment room thread
				startTimer(treat.get(2));
				// a boolean assigned within patient
				// object to execute the remove later
				ep.setInRoom(true);
			} else if (treat.get(3).isAvailable() == true) {
				treat.get(3).setPatient(ep);
				treat.get(3).setAvailable(false);
				// start count for treatment room
				// using Treatment room thread
				startTimer(treat.get(3));
				// a boolean assigned within patient
				// object to execute the remove later
				ep.setInRoom(true);
			} else if (treat.get(4).isAvailable() == true) {
				treat.get(4).setPatient(ep);
				treat.get(4).setAvailable(false);
				// start count for treatment room
				// using Treatment room thread
				startTimer(treat.get(4));
				// a boolean assigned within patient
				// object to execute the remove later
				ep.setInRoom(true);
			} else if (treat.getLast().isAvailable() == true) {
				treat.getLast().setPatient(ep);
				treat.getLast().setAvailable(false);
				// start count for treatment room
				// using Treatment room thread
				startTimer(treat.getLast());
				// a boolean assigned within patient
				// object to execute the remove later
				ep.setInRoom(true);
			} else if (onCallTeam.isAvailable() == true) { // if all treatment rooms full
				onCallTeam.setPatient(ep);
				onCallTeam.setAvailable(false);
				// start count for treatment room
				// using Treatment room thread
				startTimer(onCallTeam);
				// a boolean assigned within patient
				// object to execute the remove later
				ep.setInRoom(true);
			}
		}
		
	}

}
