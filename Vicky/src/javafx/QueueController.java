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

	// Boolean to check whether a new Patient can be added
	// to queue
	
	static Boolean bool = false;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// **** Treatment Rooms ****

		treat.add(room1);
		treat.add(room2);
		treat.add(room3);
		treat.add(room4);
		treat.add(room5);

		// In order to refresh the page every few seconds, the timeline feature
		// is used to carry out the action event below
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2),
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						
						// to add and cycle through arrays
						addingToArrays();
						
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
							//treat.remove(treat.getFirst());
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
	 * A method to invoke the treatment room thread 
	 * class timer count
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
	 * A method to cycle through the array collections to
	 * order, organise and begin the Patient thread 
	 */
	public void addingToArrays() {

		// check if Patient object can be added (with the
		// 10 limit of Patients) and a boolean to check if
		// the Patient is new
		if ((llist.size() <= 10) && (bool == true)) {

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
			bool = false;
		}
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
			pQueue.add(ptq);
			bool = true;
			tc.firstNamePass = null;
			tc.tableLastName = null;
			//tc.triagePass = null;
			
		}
	}

}
