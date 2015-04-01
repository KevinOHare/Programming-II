package NHSsystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeSet;

import NHSsystem.Patient;

public class Queue {

	// set up instances

	static LinkedList<Patient> link = new LinkedList<Patient>();

	static SortedSet<Patient> sort = new TreeSet<Patient>();

	static PriorityQueue<Patient> pQueue = new PriorityQueue<Patient>();

	static LinkedList<TreatmentRoom> treat = new LinkedList<TreatmentRoom>();

	static TreatmentRoom[] treatAr = new TreatmentRoom[5];

	// local variables

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

	static TreatmentRoom room1 = new TreatmentRoom(1, true);
	static TreatmentRoom room2 = new TreatmentRoom(2, true);
	static TreatmentRoom room3 = new TreatmentRoom(3, true);
	static TreatmentRoom room4 = new TreatmentRoom(4, true);
	static TreatmentRoom room5 = new TreatmentRoom(5, true);

	// **get details from database - fill object of patient
	// **print patient object
	// **put in linkedlist
	// **add 10 patient objects
	// **put in linkedlist
	// **sort list on priority
	// **give each object a time - thread
	// **(comparable in Patient)

	// ********** ad hoc **********
	public static void main(String[] args) throws InterruptedException {

		// **Treatment Rooms

		treat.add(room1);
		treat.add(room2);
		treat.add(room3);
		treat.add(room4);
		treat.add(room5);

		// **Queue

		System.out.println("*******************************");
		System.out.println("*********** Queue *************\n");

		// add to linked list
		link.add(pat1);
		link.add(pat2);
		link.add(pat3);
		link.add(pat4);
		link.add(pat5);
		link.add(pat6);
		link.add(pat7);
		link.add(pat8);
		link.add(pat9);
		link.add(pat10);

		// add to priority queue
		for (Patient ap : link) {
			pQueue.add(ap);
		}

		// add to sort queue
		for (Patient ae : pQueue) {
			sort.add(ae);
		}

		// print out sort queue results
		while (!sort.isEmpty()) {

			System.out.println("****** Treatment Room *******");
			for (TreatmentRoom tr : treat) {
				System.out.println(tr.toString());
			}

			System.out.println("********** Queue ************");
			for (Patient as : sort) {
				System.out.println(as.toString());
				if (treat.getFirst().isAvailable() == true) {
					treat.getFirst().setPatient(as);
					treat.getFirst().setAvailable(false);
					//sort.remove();
				} else if (treat.get(1).isAvailable() == true) {
					treat.get(1).setPatient(as);
					treat.get(1).setAvailable(false);
				} else if (treat.get(2).isAvailable() == true) {
					treat.get(2).setPatient(as);
					treat.get(2).setAvailable(false);
				} else if (treat.get(3).isAvailable() == true) {
					treat.get(3).setPatient(as);
					treat.get(3).setAvailable(false);
				} else if (treat.get(4).isAvailable() == true) {
					treat.get(4).setPatient(as);
					treat.get(4).setAvailable(false);
				} else if (treat.getLast().isAvailable() == true) {
					treat.getLast().setPatient(as);
					treat.getLast().setAvailable(false);
				}

			}
			
			System.out.println("\n*****************************************\n");
			Thread.sleep(4000);
		}

	}


}
