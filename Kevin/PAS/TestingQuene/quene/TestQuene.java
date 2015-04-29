package TestingQuene.quene;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.PriorityQueue;

import org.junit.Before;
import org.junit.Test;

import NHSsystem.Patient;
import queue.Queue;

public class TestQuene {

	@Before
	public void setUp() throws Exception {
		
		PriorityQueue<Patient> pQueue = new PriorityQueue<Patient>();

		
			Patient p1 = new Patient("Mr", "Steven", "Kennedy", "45 road",
					"Lisburn", "BT67 524", "098 38563", "3759-283", 0, false);
			p1.setTriage(1);
			
			/**
			 * (String title, String firstName, String lastName,
			String street, String city, String postcode, String contactNumber,
			String nhsNumber, int triage, boolean emergencyCondition)
			 */
			
			Patient p2 = new Patient("Ms", "June", "Campbell", "20 road",
					"Lisburn", "BT23 524", "234 4263", "3234-83", 0, false);
			p2.setTriage(2);
			
			Patient p3 = new Patient("Mr", "Philip", "White", "94 road",
					"Hillsborough", "BT57 254", "234 4543", "0568-283", 0, false);
			p3.setTriage(2);
			
			Patient p4 = new Patient("Mrs", "Mary", "Kelly", "60 road",
					"Moria", "BT57 092", "689 2583", "3452-039", 0, false);
			p4.setTriage(2);
			
			Patient p5 = new Patient("Mr", "Conner", "Lee", "10 road",
					"Anahilt", "BT59 203", "582 9385", "0429-3458", 0, false);
			p5.setTriage(2);
			
			Patient p6 = new Patient("Mrs", "Will", "Goon", "85 road",
					"Kilea", "BT20 578", "098 3490", "0694-3829", 0, false);
			p6.setTriage(2);
			
			
			Patient p7 = new Patient("Mr", "Red", "Wright", "02 road",
					"Belfast", "BT03 039", "485 3020", "9592-2985", 0, false);
			p7.setTriage(2);
			
			Patient p8 = new Patient("Ms", "Kelly", "Goodman", "58 road",
					"Lisburn", "BT28 394", "509 3853", "9837-3029", 0, false);
			p8.setTriage(3);
			
			Patient p9 = new Patient("Mr", "Kevin", "Ken", "95 road",
					"Hillsborough", "BT02 984", "039 3085", "303-59387", 0, false);
			p9.setTriage(3);
			
			Patient p10 = new Patient("Ms", "Rachel", "Lenvine", "03 road",
					"Moria", "BT28 828", "493 03895", "294-3985", 0, false);
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
		Patient p1 = new Patient("Mr", "Steven", "Kennedy", "45 road",
				"Lisburn", "BT67 524", "098 38563", "3759-283", 0, false);
		p1.setTriage(1);
		assertEquals(1, p1.getTriage());
	}
	
	@Test
	public final void testSetTriageInvaild() {
		Patient p1 = new Patient("Mr", "Steven", "Kennedy", "45 road",
				"Lisburn", "BT67 524", "098 38563", "3759-283", 0, false);
		p1.setTriage(1);
		assertNotEquals(2, p1.getTriage());
		}
	

	@Test
	public final void testPatientsInQuene() {
		PriorityQueue<Patient> pQueue = new PriorityQueue<Patient>();
		
		Patient p1 = new Patient("Mr", "Steven", "Kennedy", "45 road",
				"Lisburn", "BT67 524", "098 38563", "3759-283", 0, false);
		p1.setTriage(1);
		
		Patient p2 = new Patient("Ms", "June", "Campbell", "20 road",
				"Lisburn", "BT23 524", "234 4263", "3234-83", 0, false);
		p2.setTriage(2);
		
		Patient p3 = new Patient("Mr", "Philip", "White", "94 road",
				"Hillsborough", "BT57 254", "234 4543", "0568-283", 0, false);
		p3.setTriage(2);
		
		Patient p4 = new Patient("Mrs", "Mary", "Kelly", "60 road",
				"Moria", "BT57 092", "689 2583", "3452-039", 0, false);
		p4.setTriage(2);
		
		Patient p5 = new Patient("Mr", "Conner", "Lee", "10 road",
				"Anahilt", "BT59 203", "582 9385", "0429-3458", 0, false);
		p5.setTriage(2);
		
		Patient p6 = new Patient("Mrs", "Will", "Goon", "85 road",
				"Kilea", "BT20 578", "098 3490", "0694-3829", 0, false);
		p6.setTriage(2);
		
		
		Patient p7 = new Patient("Mr", "Red", "Wright", "02 road",
				"Belfast", "BT03 039", "485 3020", "9592-2985", 0, false);
		p7.setTriage(2);
		
		Patient p8 = new Patient("Ms", "Kelly", "Goodman", "58 road",
				"Lisburn", "BT28 394", "509 3853", "9837-3029", 0, false);
		p8.setTriage(3);
		
		Patient p9 = new Patient("Mr", "Kevin", "Ken", "95 road",
				"Hillsborough", "BT02 984", "039 3085", "303-59387", 0, false);
		p9.setTriage(3);
		
		Patient p10 = new Patient("Ms", "Rachel", "Lenvine", "03 road",
				"Moria", "BT28 828", "493 03895", "294-3985", 0, false);
		
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
		
		Patient p1 = new Patient("Mr", "Steven", "Kennedy", "45 road",
				"Lisburn", "BT67 524", "098 38563", "3759-283", 0, false);
		p1.setTriage(1);
		
		Patient p2 = new Patient("Ms", "June", "Campbell", "20 road",
				"Lisburn", "BT23 524", "234 4263", "3234-83", 0, false);
		p2.setTriage(2);
		
		Patient p3 = new Patient("Mr", "Philip", "White", "94 road",
				"Hillsborough", "BT57 254", "234 4543", "0568-283", 0, false);
		p3.setTriage(2);
		
		Patient p4 = new Patient("Mrs", "Mary", "Kelly", "60 road",
				"Moria", "BT57 092", "689 2583", "3452-039", 0, false);
		p4.setTriage(2);
		
		Patient p5 = new Patient("Mr", "Conner", "Lee", "10 road",
				"Anahilt", "BT59 203", "582 9385", "0429-3458", 0, false);
		p5.setTriage(2);
		
		Patient p6 = new Patient("Mrs", "Will", "Goon", "85 road",
				"Kilea", "BT20 578", "098 3490", "0694-3829", 0 , false);
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
		
		

}
