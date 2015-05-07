package javafxTests;

// import resources
import static org.junit.Assert.*;
import java.util.Collections;
import java.util.LinkedList;
import javafx.QueueController;
import org.junit.Before;
import org.junit.Test;
import com.twilio.sdk.TwilioRestException;
import NHSsystem.Patient;
import NHSsystem.TreatmentRoom;

/**
 * Class to test the Queue Controller
 * @author chrismcclune
 *
 */
public class QueueControllerTest {
	/**
	 * Instance Variable
	 */
	static QueueController qc = new QueueController();

	/**
	 * linked list
	 */
	static LinkedList<Patient> llist = new LinkedList<Patient>();

	/**
	 * Patient object 1
	 */
	static Patient p1 = new Patient("Mr", "Steven", "Kennedy", "45 road",
			"Lisburn", "BT67 524", "098 38563", "3759-283", 0, false);

	/**
	 * Patient object 2
	 */
	static Patient p2 = new Patient("Ms", "June", "Campbell", "20 road",
			"Lisburn", "BT23 524", "234 4263", "3234-83", 0, false);

	/**
	 * Patient object 3
	 */
	static Patient p3 = new Patient("Mr", "Philip", "White", "94 road",
			"Hillsborough", "BT57 254", "234 4543", "0568-283", 0, false);

	/**
	 * Patient object 4
	 */
	static Patient p4 = new Patient("Mrs", "Mary", "Kelly", "60 road", "Moria",
			"BT57 092", "689 2583", "3452-039", 0, false);

	/**
	 * Patient object 5
	 */
	static Patient p5 = new Patient("Mr", "Conner", "Lee", "10 road",
			"Anahilt", "BT59 203", "582 9385", "0429-3458", 0, false);

	/**
	 * Patient object 6
	 */
	static Patient p6 = new Patient("Mrs", "Will", "Goon", "85 road", "Kilea",
			"BT20 578", "098 3490", "0694-3829", 0, false);

	/**
	 * Patient object 7
	 */
	static Patient p7 = new Patient("Mr", "Red", "Wright", "02 road",
			"Belfast", "BT03 039", "485 3020", "9592-2985", 0, false);

	/**
	 * Patient object 8
	 */
	static Patient p8 = new Patient("Ms", "Kelly", "Goodman", "58 road",
			"Lisburn", "BT28 394", "509 3853", "9837-3029", 0, false);

	/**
	 * Patient object 9
	 */
	static Patient p9 = new Patient("Mr", "Kevin", "Ken", "95 road",
			"Hillsborough", "BT02 984", "039 3085", "303-59387", 0, false);

	/**
	 * Patient object 10
	 */
	static Patient p10 = new Patient("Ms", "Rachel", "Lenvine", "03 road",
			"Moria", "BT28 828", "493 03895", "294-3985", 0, false);

	/**
	 * linked list for the treatment rooms
	 */
	static LinkedList<TreatmentRoom> treat = new LinkedList<TreatmentRoom>();

	/**
	 * treatment room object
	 */
	static TreatmentRoom room1 = new TreatmentRoom(1, true);

	/**
	 * before set up method
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {

		llist.add(p1);
		llist.add(p2);
		llist.add(p3);
		llist.add(p4);
		llist.add(p5);
		llist.add(p6);
		llist.add(p7);
		llist.add(p8);
		llist.add(p9);
		llist.add(p10);

		treat.add(room1);

	}

	/**
	 * test get and set triage valid
	 */
	@Test
	public final void testGetSetTriageVaild() {
		p1.setTriage(1);
		assertEquals(1, p1.getTriage());
	}

	/**
	 * test get and set triage invalid
	 */
	@Test
	public final void testGetSetTriageInvaild() {
		p1.setTriage(1);
		assertNotEquals(2, p1.getTriage());
	}

	/**
	 * test emergency condition true
	 */
	@Test
	public final void TestEmergencyConditionTrue() throws TwilioRestException {
		p1.setTriage(1);
		int Expected = 1;
		assertEquals(Expected, p1.getTriage());
	}

	/**
	 * test emergency condition false
	 */
	@Test
	public final void TestEmergencyConditionFalse() {
		p1.setTriage(1);
		assertEquals(false, p1.getEmergencyCondition());
	}

	/**
	 * test patients are in queue
	 */
	@Test
	public final void testPatientsInQuene() {
		p1.setTriage(1);
		p2.setTriage(2);
		p3.setTriage(2);
		p4.setTriage(2);
		p5.setTriage(2);
		p6.setTriage(2);
		p7.setTriage(2);
		p8.setTriage(3);
		p9.setTriage(3);
		p10.setTriage(3);

		llist.add(p1);
		llist.add(p2);
		llist.add(p3);
		llist.add(p4);
		llist.add(p5);
		llist.add(p6);
		llist.add(p7);
		llist.add(p8);
		llist.add(p9);
		llist.add(p10);

	
		assertNotNull(llist);
	}

	/**
	 * checking if patient goes straight into a treatment room and to ensure
	 * that the 6th patient is left in the queue
	 */
	@Test
	public final void TreatmentTime() {

		p1.setTriage(1);
		p2.setTriage(2);
		p3.setTriage(2);
		p4.setTriage(2);
		p5.setTriage(2);
		p6.setTriage(2);
		p7.setTriage(2);
		p8.setTriage(3);
		p9.setTriage(3);
		p10.setTriage(3);

		// Testing that the first 5 don't enter the queue
		llist.add(p1);

		equals(p5.getCountTimer() == 0);

		llist.add(p2);

		equals(p5.getCountTimer() == 0);

		llist.add(p3);

		equals(p5.getCountTimer() == 0);

		llist.add(p4);

		equals(p5.getCountTimer() == 0);

		llist.add(p5);

		equals(p5.getCountTimer() == 0);

		// Testing how long Patient 6 stays in the queue (25 is acting as 25
		// minutes for this test).

		llist.add(p6);

		equals(p6.getCountTimer() == 30);
	}

	/**
	 * test treatment room exists
	 */
	@Test
	public void TestRoomNotNull() {

		LinkedList<TreatmentRoom> treat = new LinkedList<TreatmentRoom>();

		TreatmentRoom room1 = new TreatmentRoom(1, true);
		treat.add(room1);

		p1.setTriage(3);
		llist.add(p1);

		assertNotNull(room1);
	}

	/**
	 * test if room is available for a patient
	 */
	@Test
	public void TestRoomIsAvailable() {

		LinkedList<TreatmentRoom> treat = new LinkedList<TreatmentRoom>();

		TreatmentRoom room1 = new TreatmentRoom(1, true);
		treat.add(room1);

		p1.setTriage(3);
		llist.add(p1);

		assertEquals(true, room1.isAvailable());
	}

	/**
	 * test count timer is valid
	 */
	@Test
	public void TestTreatValid() {

		LinkedList<TreatmentRoom> treat = new LinkedList<TreatmentRoom>();

		TreatmentRoom room1 = new TreatmentRoom(1, true);
		TreatmentRoom room2 = new TreatmentRoom(2, true);
		TreatmentRoom room3 = new TreatmentRoom(3, true);
		TreatmentRoom room4 = new TreatmentRoom(4, true);
		TreatmentRoom room5 = new TreatmentRoom(5, true);

		treat.add(room1);
		treat.add(room2);
		treat.add(room3);
		treat.add(room4);
		treat.add(room5);

		room1.setCountTimer(30);
		assertEquals(30, room1.getCountTimer());
	}

	/**
	 * test count timer is invalid
	 */
	@Test
	public void TestTreatInvalid() {

		LinkedList<TreatmentRoom> treat = new LinkedList<TreatmentRoom>();

		TreatmentRoom room1 = new TreatmentRoom(1, true);
		TreatmentRoom room2 = new TreatmentRoom(2, true);
		TreatmentRoom room3 = new TreatmentRoom(3, true);
		TreatmentRoom room4 = new TreatmentRoom(4, true);
		TreatmentRoom room5 = new TreatmentRoom(5, true);

		treat.add(room1);
		treat.add(room2);
		treat.add(room3);
		treat.add(room4);
		treat.add(room5);

		treat.getFirst().setCountTimer(50);
		int Expected = 50;
		assertEquals(Expected, treat.getFirst().getCountTimer());
	}

	/**
	 * test patient is removed from the queue
	 */
	@Test
	public void TestRemoveFromQueue() {

		llist.clear();

		p2.setInRoom(true);

		llist.add(p1);
		llist.add(p2);
		llist.add(p3);

		// EXTRACT FROM QUEUE CONTROLLER CLASS
		// to remove patients from the list that are in
		// treatment rooms
		for (int i = 0; i < llist.size(); i++) {
			if (llist.get(i).getInRoom() == true) {
				llist.remove(llist.get(i));
			}
		}

		// expected 2 patients still in
		// queue
		int Expected = 2;

		assertEquals(Expected, llist.size());
	}

	/**
	 * test patient can be added to a treatment room
	 */
	@Test
	public void TestAddToTreatQueue() {

		llist.add(p1);
		llist.add(p2);
		llist.add(p3);

		treat.getFirst().setAvailable(true);

		// EXTRACT FROM QUEUE CONTROLLER
		// check rooms are available
		if (treat.getFirst().isAvailable() == true) {

			treat.getFirst().setPatient(llist.getFirst());
			treat.getFirst().setAvailable(false);

			llist.getFirst().setInRoom(true);
			llist.remove(llist.getFirst());
		}

		Patient Expected = p1;

		assertEquals(Expected, treat.getFirst().getPatient());
	}

	/**
	 * test the sort of patients in the linked list
	 */
	@Test
	public void TestSortCollection() {

		llist.clear();

		Boolean bool = null;

		p1.setTriage(4);
		p2.setTriage(1);
		p3.setTriage(2);
		p4.setTriage(3);

		llist.add(p1);
		llist.add(p2);
		llist.add(p3);
		llist.add(p4);

		// EXTRACT CODE FROM QUEUE CONTROLLER
		// sortingQueue()
		Collections.sort(llist);

		if (llist.get(0) == p2 && llist.get(1) == p3 && llist.get(2) == p4
				&& llist.get(3) == p1) {
			bool = true;
		}

		Boolean Expected = true;

		assertEquals(Expected, bool);

	}

	/**
	 * Tests status code four
	 */
	@Test
	public void TestStatusCodeUpdate() {

		llist.clear();

		int status = 0;

		llist.add(p1);
		llist.add(p2);
		llist.add(p3);
		llist.add(p4);
		llist.add(p5);
		llist.add(p6);
		llist.add(p7);
		llist.add(p8);
		llist.add(p9);
		llist.add(p10);

		int Expected = 4;

		// EXTRACT CODE FROM QUEUE CONTROLLER
		// if linked list queue is greater than or
		// is 10
		if (llist.size() == 10) {
			status = 4;
		}

		assertEquals(Expected, status);

	}

	/**
	 * Tests status code three
	 */
	@Test
	public void TestStatusCodeUpdateThree() {

		int Expected = 3;
		int currentMax = 25;
		int status = 0;

		// EXTRACTED CODE
		if (currentMax >= 20) {
			status = 3;
		}

		assertEquals(Expected, status);

	}

	/**
	 * Tests status code two
	 */
	@Test
	public void TestStatusCodeUpdateTwo() {

		int Expected = 2;
		int currentMax = 15;
		int status = 0;

		// EXTRACTED CODE
		if (currentMax >= 10 && currentMax < 20) {
			status = 2;
		}

		assertEquals(Expected, status);

	}

	/**
	 * Tests status code one
	 */
	@Test
	public void TestStatusCodeUpdateOne() {

		int Expected = 1;
		int currentMax = 5;
		int status = 0;

		// EXTRACTED CODE
		if (currentMax >= 0 && currentMax < 10) {
			status = 1;
		}

		assertEquals(Expected, status);

	}
	
	/**
	 * test to check the queue timer limit  works as required
	 */
	@Test
	public void TestCheckQueueTimerLimit() throws TwilioRestException{
		
		llist.clear();
		
		p1.setCountTimer(1500);
		p1.setTriage(3);
		
		llist.add(p1);
		llist.add(p2);
		llist.add(p3);
		llist.add(p4);
		llist.add(p5);
		
		QueueController cc = new QueueController();
		
		// EXTRACT CODE FROM QUEUE CONTROLLER
		for (int i = 0; i < llist.size(); i++) {
			// 25 mins has passed - 1500milsec
			if (llist.get(i).getCountTimer() == 1500) {
				// set triage to 2 so patient
				// can move up queue
				llist.get(i).setTriage(2);
			}
		}
		int Expected = 2;
		
		assertEquals(Expected, llist.get(0).getTriage());
	}
	
	/**
	 * test the treatment room thread 
	 */
	@Test
	public void TestTreatmentThreads(){
		
		qc.startTimer(room1);
		
		int l = 0;
		
		assertEquals(l, room1.getCountTimer());	
	}
	
}
