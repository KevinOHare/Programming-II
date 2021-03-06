package TestingQueue.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import javafx.QueueController;
import onCallMessage.Email;

import org.junit.Before;
import org.junit.Test;

import com.twilio.sdk.TwilioRestException;

import NHSsystem.Patient;
import NHSsystem.TreatmentRoom;

public class TestQueue {

	
	//test data
	QueueController q = new QueueController();
	
	Patient p1 = new Patient("Mr", "Steven", "Kennedy", "45 road",
			"Lisburn", "BT67 524", "098 38563", "3759-283", 0, false);
	
	Patient p2 = new Patient("Ms", "June", "Campbell", "20 road",
			"Lisburn", "BT23 524", "234 4263", "3234-83", 0, false);
	
	Patient p3 = new Patient("Mr", "Philip", "White", "94 road",
			"Hillsborough", "BT57 254", "234 4543", "0568-283", 0, false);
	
	Patient p4 = new Patient("Mrs", "Mary", "Kelly", "60 road",
			"Moria", "BT57 092", "689 2583", "3452-039", 0, false);
	Patient p5 = new Patient("Mr", "Conner", "Lee", "10 road",
			"Anahilt", "BT59 203", "582 9385", "0429-3458", 0, false);
	
	Patient p6 = new Patient("Mrs", "Will", "Goon", "85 road",
			"Kilea", "BT20 578", "098 3490", "0694-3829", 0, false);
	
	
	Patient p7 = new Patient("Mr", "Red", "Wright", "02 road",
			"Belfast", "BT03 039", "485 3020", "9592-2985", 0, false);
	
	Patient p8 = new Patient("Ms", "Kelly", "Goodman", "58 road",
			"Lisburn", "BT28 394", "509 3853", "9837-3029", 0, false);
	
	Patient p9 = new Patient("Mr", "Kevin", "Ken", "95 road",
			"Hillsborough", "BT02 984", "039 3085", "303-59387", 0, false);
	
	Patient p10 = new Patient("Ms", "Rachel", "Lenvine", "03 road",
			"Moria", "BT28 828", "493 03895", "294-3985", 0, false);
	Patient p11 = new Patient("Mr", "Simon", "Tim", "4 road",
			"Lisburn", "BT67 904", "098 38563", "3759-283", 0, false);

	
	
	@Before
	public void setUp() throws Exception {
		
		PriorityQueue<Patient> pQueue = new PriorityQueue<Patient>();
		
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
			
			pQueue.add(p1);
			pQueue.add(p2);
			pQueue.add(p3);
			pQueue.add(p4);
			pQueue.add(p5);
			pQueue.add(p6);
			pQueue.add(p7);
			pQueue.add(p8);
			pQueue.add(p9);
			pQueue.add(p10);
	}
	

	@Test
	public final void testSetTriageVaild() {
		
		p1.setTriage(1);
		assertEquals(1, p1.getTriage());
	}
	
	@Test
	public final void testSetTriageInvaild() {
		
		p1.setTriage(1);
		assertNotEquals(2, p1.getTriage());
		}
	

	@Test
	public final void testPatientsInQuene() {
		PriorityQueue<Patient> pQueue = new PriorityQueue<Patient>();
		
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
		
		pQueue.add(p1);
		pQueue.add(p2);
		pQueue.add(p3);
		pQueue.add(p4);
		pQueue.add(p5);
		pQueue.add(p6);
		pQueue.add(p7);
		pQueue.add(p8);
		pQueue.add(p9);
		pQueue.add(p10);
	
		/*assertEquals(p1, pQueue.contains(p1));
		assertEquals(p2, pQueue.contains(p2));
		assertEquals(p3, pQueue.contains(p3));
		assertEquals(p4, pQueue.contains(p4));
		assertEquals(p5, pQueue.contains(p5));
		assertEquals(p6, pQueue.contains(p6));
		assertEquals(p7, pQueue.contains(p7));
		assertEquals(p8, pQueue.contains(p8));
		assertEquals(p9, pQueue.contains(p9));
		assertEquals(p10, pQueue.contains(p10));
		*/
		assertNotNull(pQueue);
	}
	
	@Test
	public final void TreatmentTime() {
		
		PriorityQueue<Patient> pQueue = new PriorityQueue<Patient>();
		
		p1.setTriage(1);

		p2.setTriage(2);
		
		p3.setTriage(2);
	
		p4.setTriage(2);
		
		p5.setTriage(2);
		
		p6.setTriage(2);
		
		//Testing that the first 5 don't enter the queue
		pQueue.add(p1);
		
		equals(p5.getCountTimer() == 0);
		
		pQueue.add(p2);
		
		equals(p5.getCountTimer() == 0);
		
		pQueue.add(p3);
		
		equals(p5.getCountTimer() == 0);
		
		pQueue.add(p4);
		
		equals(p5.getCountTimer() == 0);
		
		pQueue.add(p5);
		
		equals(p5.getCountTimer() == 0);
		
		//Testing how long Patient 6 stays in the queue (25 is acting as 25 minutes for this test).
		
		pQueue.add(p6);
		
		equals(p6.getCountTimer() == 25);
	}
		
	//test initial placement in queue is depends on triage category 
	@Test
	public void testQueuePlacement() {

		PriorityQueue<Patient> pQueue = new PriorityQueue<Patient>();

		//LinkedList<TreatmentRoom> treat = new LinkedList<TreatmentRoom>();
		//QueueController q = new QueueController();
		
		//TreatmentRoom roomOne = new TreatmentRoom(1, true);
		
		p1.setTriage(3);
		
		p2.setTriage(1);
		
		p3.setTriage(2);
		
		p4.setTriage(4);
		
		pQueue.add(p1);
		pQueue.add(p2);
		pQueue.add(p3);
		pQueue.add(p4);
		
		System.out.println();
	    System.out.print("Queue : ");
	    while(true) {
	        Patient currentPatient = pQueue.poll();
	        if(currentPatient == null) {
	            break;
	        }
	        System.out.print(currentPatient.getFirstName() + currentPatient.getLastName() +"\t");
	    }//expected result Campbell,  White,  Kennedy,  Kelly
	    System.out.println();
	
	}
	
	//test romm is valid
	@Test
		public void testsetRoomValid(){
		
		LinkedList<TreatmentRoom> treat = new LinkedList<TreatmentRoom>();
		QueueController q = new QueueController();
				
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
		
		room1.setPatient(p1);
		room2.setPatient(p2);
		room3.setPatient(p3);
		room4.setPatient(p4);
		room5.setPatient(p5);
		
		assertEquals(p1, room1.getPatient());
		assertEquals(p2, room2.getPatient());
		assertEquals(p3, room3.getPatient());
		assertEquals(p4, room4.getPatient());
		assertEquals(p5, room5.getPatient());
			
		}
	
	@Test
	public void testsetRoomInvalid(){
		
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
		
		room1.setPatient(p1);
		room2.setPatient(p2);
		
		assertNotEquals(p1, room2);
		assertNotEquals(p2, room1);
	}
	
	@Test
	public void queueUpperBoundaryValid(){
		
		PriorityQueue<Patient> pQueue = new PriorityQueue<Patient>();
		
		p1.setTriage(3);
		p2.setTriage(2);
		p3.setTriage(2);
		p4.setTriage(2);
		p5.setTriage(2);
		p6.setTriage(2);
		p7.setTriage(2);
		p8.setTriage(3);
		p9.setTriage(3);
		p10.setTriage(3);
		
		
		pQueue.add(p1);
		pQueue.add(p2);
		pQueue.add(p3);
		pQueue.add(p4);
		pQueue.add(p5);
		pQueue.add(p6);
		pQueue.add(p7);
		pQueue.add(p8);
		pQueue.add(p9);
		pQueue.add(p10);
		
		int expected, actual;
		expected = 10;
		actual = pQueue.size();
		
		assertEquals(expected,actual);
		
	}
	//
	@Test(expected = IllegalArgumentException.class)
	public void queueUpperBoundaryInValid() throws TwilioRestException{
	
		//PriorityQueue<Patient> pQueue = new PriorityQueue<Patient>();
		
		p1.setTriage(4);
		p2.setTriage(4);
		p3.setTriage(4);
		p4.setTriage(4);
		p5.setTriage(4);
		p6.setTriage(4);
		p7.setTriage(4);
		p8.setTriage(4);
		p9.setTriage(4);
		p10.setTriage(4);
		p11.setTriage(4);
		
		
	/**	pQueue.add(p1);
		pQueue.add(p2);
		pQueue.add(p3);
		pQueue.add(p4);
		pQueue.add(p5);
		pQueue.add(p6);
		pQueue.add(p7);
		pQueue.add(p8);
		pQueue.add(p9);
		pQueue.add(p10);
		pQueue.add(p11); */
		
		/*int expected = 11;
		int actual = pQueue.size();
		assertEquals(expected, actual);
		System.out.println(pQueue.size()); */
		
		LinkedList<Patient> llist = new LinkedList<Patient>();
		
		int invalid = 11;
		
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
			llist.add(p11);
			
			assertEquals(invalid, llist.size());
		}
		
		
	}
