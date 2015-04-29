package TestingQuene.quene;

import static org.junit.Assert.*;
import javafx.QueueController;
import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;
import java.util.PriorityQueue;

import NHSsystem.Patient;

public class TestQueueController {

	
	//Test Data 
        QueueController q = new QueueController();
        boolean queueIsFull;
        
        
	Patient p1 = new Patient("Ms", "June", "Campbell", "20 road",
			"Lisburn", "BT23 524", "234 4263", "3234-83", 0, false);
	Patient p2 = new Patient("Miss", "Amy", "Lynch", "10 street",
			"Lisburn", "BT28 7EY", "124 2837", "3232-13", 0, false);
	Patient p3 = new Patient("Mr", "Paul", "Hamm", "20 road",
			"Lisburn", "BT23 524", "234 7638", "3234-1903", 0, false);
	Patient p4 = new Patient("Miss", "Laura", "Smith", "10 lane",
			"Lisburn", "BT28 345", "104 2836", "3220-13", 0, false);
	Patient pat5 = new Patient("Mr", "Conner", "Lee", "10 road",
			"Anahilt", "BT59 203", "582 9385", "0429-3458", 3, false);
	Patient pat6 = new Patient("Mrs", "Will", "Goon", "85 road",
			"Kilea", "BT20 578", "098 3490", "0694-3829", 4, false);
	Patient pat7 = new Patient("Mr", "Red", "Wright", "02 road",
			"Belfast", "BT03 039", "485 3020", "9592-2985", 3, false);
	Patient pat8 = new Patient("Ms", "Kelly", "Goodman", "58 road",
			"Lisburn", "BT28 394", "509 3853", "9837-3029", 2, false);
	Patient pat9 = new Patient("Mr", "Kevin", "Ken", "95 road",
			"Hillsborough", "BT02 984", "039 3085", "303-59387", 4, false);
	Patient pat10 = new Patient("Ms", "Rachel", "Lenvine", "03 road",
			"Moria", "BT28 828", "493 03895", "294-3985", 1, false);
	Patient pat11 = new Patient("Mr", "Robert", "Lenvine", "03 road",
			"Moria", "BT28 828", "493 03895", "214-3985", 1, false);
	
	PriorityQueue<Patient> pQueue = new PriorityQueue<Patient>(10, new Comparator<Patient>() {
        public int compare(Patient patient1, Patient patient2) {
            return (patient1.getEmergencyCondition() == patient2.getEmergencyCondition()) ? (Integer.valueOf(patient1.getTriage()).compareTo(patient2.getTriage()))
                                                                              : (patient1.getEmergencyCondition() ? -1 : 1);
        }
	
	
	@Before
	public void setUp() throws Exception {
	}
    // check initial placement in the queue depends on triage priority
	@Test
	public void testQueuePlacement() {

		
		p1.setTriage(4);
		p2.setTriage(2);
		p3.setTriage(3);
		p4.setTriage(1);
		
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
	        System.out.print(currentPatient.getFirstName() + currentPatient.getLastName() +" <-- ");
	    }
	    System.out.println();
	//expected result Laura Smith, Amy Lynch, Paul Hamm, June Campbell
	}
});
	
	//test that when queue has 10 patients a message is sent to on call team
	@Test
	public void testQueueFullEmergency() {
		
	}

	//test that when 3 or more patients have been waiting for 30 mins a message is sent to the hospital manager
	@Test
	public void testQueueTimeExcededLimit() {
		fail("Not yet implemented");
	}

	//test that time patients leave treatment rooms is recorded
	@Test
	public void testQueueFull() {
		
		q.queueFull();
		queueIsFull = true;
		}
		


	@Test
	public void testAddingToArrays() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddToQueue() {
		fail("Not yet implemented");
	}

}

