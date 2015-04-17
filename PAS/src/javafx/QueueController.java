package javafx;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.ResourceBundle;
import java.util.SortedSet;
import java.util.TreeSet;

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

	// ************************ TEST DATA  ***********************************

	static Patient pat1 = new Patient("Mr", "Steven", "Kennedy", "45 road",
			"Lisburn", "BT67 524", "098 38563", "3759-283", 3);
	static Patient pat2 = new Patient("Ms", "June", "Campbell", "20 road",
			"Lisburn", "BT23 524", "234 4263", "3234-83", 4);
	static Patient pat3 = new Patient("Mr", "Philip", "White", "94 road",
			"Hillsborough", "BT57 254", "234 4543", "0568-283", 2);
	static Patient pat4 = new Patient("Mrs", "Mary", "Kelly", "60 road",
			"Moria", "BT57 092", "689 2583", "3452-039", 1);
	static Patient pat5 = new Patient("Mr", "Conner", "Lee", "10 road",
			"Anahilt", "BT59 203", "582 9385", "0429-3458", 3);
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

		// **** Queue ****

		

		// add to Priority queue
		/*
		 * pQueue.add(pat1); pQueue.add(pat2); pQueue.add(pat3);
		 * pQueue.add(pat4); pQueue.add(pat5); pQueue.add(pat6);
		 * pQueue.add(pat7); pQueue.add(pat8); pQueue.add(pat9);
		 * pQueue.add(pat10);
		 */

		// add to sort queue
		for (Patient ae : pQueue) {
			// instantiate classes to activate the
			// start time at the queue
			PatientThread pt = new PatientThread(ae);
			Runnable rr = new Runnable() {
				public void run() {
					pt.run();
				}
			};
			new Thread(rr).start();
			// add to sort queue
			sort.add(ae);
		}

		// add to array list for editing
		// the working queue
		for (Patient ju : sort) {
			alist.add(ju);
		}

		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2),
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {

						addToQueue();

						// print out sort queue results

						// System.out.println("****** Treatment Room *******");
						// System.out.println("Room Number \t Room Available?    Patient Details ");
						for (int i = 0; i < treat.size(); i++) {
							// System.out.println(tr.toString());
							stringAr[i] = treat.get(i).toString();
						}

						treatmentRoomQueue.setText(stringAr[0] + "\n"
								+ stringAr[1] + "\n" + stringAr[2] + "\n"
								+ stringAr[3] + "\n" + stringAr[4]);

						// System.out.println("********** Queue ************");
						// System.out.println("Name\t\t  Address & Contact Details & ID number");

						for (int i = 0; i < alist.size(); i++) {
							stringPa[i] = alist.get(i).toString();
						}

						patientQueue.setText(stringPa[0] + "\n" + stringPa[1]
								+ "\n" + stringPa[2] + "\n" + stringPa[3]
								+ "\n" + stringPa[4] + "\n" + stringPa[5]
								+ "\n" + stringPa[6] + "\n" + stringPa[7]
								+ "\n" + stringPa[8] + "\n" + stringPa[9]);

						for (Patient as : alist) {
							// System.out.println(as.toString());
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
						for (int i = 0; i < alist.size(); i++) {
							if (alist.get(i).getInRoom() == true) {
								alist.remove(alist.get(i));
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

						// System.out.println("\n*****************************************\n");

					}
				}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	
	
	
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

	public void addToQueue() {

		TriageController tc = new TriageController();
		Patient ptq = new Patient();

		if (tc.firstNamePass != null) {
			ptq.setFirstName(tc.firstNamePass);
			ptq.setLastName(tc.lastNamePass);
			ptq.setTriage(tc.triagePass);

			alist.add(ptq);
		}
	}

}
