package NHSsystemTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import NHSsystem.Patient;
import NHSsystem.TreatmentRoom;

/**
 * class to rest the TreatmentRoom class
 * @author Vicky
 *
 */
public class TreatmentRoomTest {

	//test data
	int roomNumber;
	boolean isAvailable;
	private Patient p1;
	
	@Before
	public void setUp() throws Exception {
		
		TreatmentRoom tr = new TreatmentRoom();
		roomNumber = 1;
		isAvailable = true;
	}

	/**
	 * test default constructor
	 */
	@Test
	public void testTreatmentRoomDefaultConstructor() {
		TreatmentRoom tr = new TreatmentRoom();
		assertNotNull(tr);
	}

	/**
	 * test constructor with arguments
	 */
	@Test
	public void testTreatmentRoomIntBoolean() {
		TreatmentRoom tr = new TreatmentRoom(roomNumber, isAvailable);
		assertNotNull(tr);
		
	}

	/**
	 * test roomNumber getter and setter
	 */
	@Test
	public void testGetRoomNumber() {
		TreatmentRoom tr = new TreatmentRoom();
		tr.setRoomNumber(roomNumber);
		
		assertEquals(1, tr.getRoomNumber());
	}

	/**
	 * test room availability getter and setter
	 */
	@Test
	public void testIsAvailable() {
		TreatmentRoom tr = new TreatmentRoom();
		tr.setAvailable(false);
		
		assertEquals(false, tr.isAvailable());
		
	}

	/**
	 * tests patient getter and setter
	 */
	@Test
	public void testPatientGetAndSet(){
		TreatmentRoom tr = new TreatmentRoom();
		tr.setPatient(p1); 
		
		assertEquals(p1, tr.getPatient());
		
	}

	/**
	 * Test counter getter and setter
	 */
	@Test
	public void testGetAndSetCountTimer() {
		TreatmentRoom tr = new TreatmentRoom();
		tr.setCountTimer(10);
		
		assertEquals(10, tr.getCountTimer());
	}

	/**
	 * testing the toString
	 */
	@Test
	public void testToString() {
		TreatmentRoom tr = new TreatmentRoom();
		String toString = tr.toString();
		assertTrue(toString.contains(" *TreatTimer=["));
        
	}

}
