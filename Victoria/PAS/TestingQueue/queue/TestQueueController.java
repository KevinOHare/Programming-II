package TestingQueue.queue;

import static org.junit.Assert.*;

import java.util.LinkedList;

import javafx.QueueController;

import org.junit.Before;
import org.junit.Test;

import NHSsystem.TreatmentRoom;

public class TestQueueController {

	//test data
	
	static LinkedList<TreatmentRoom> treat = new LinkedList<TreatmentRoom>();
    QueueController q = new QueueController();
    boolean queueIsFull;
    static TreatmentRoom roomOne = new TreatmentRoom(1, true);

	
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInitialize() {
		fail("Not yet implemented");
	}

	@Test
	public void testStartTimerTreatmentRoom() {
		fail("Not yet implemented");
	}

	@Test
	public void testStartTimerOnCallTeam() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddToQueue() {
		fail("Not yet implemented");
	}

	@Test
	public void testSortingQueue() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckQueueTimerLimit() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemovePatientFromTreat() {
		fail("Not yet implemented");
	}

	@Test
	public void testExtensionOfTime() {
		fail("Not yet implemented");
	}
	
	@Test 
	public void testQueuePosittion(){
		
	}

}
