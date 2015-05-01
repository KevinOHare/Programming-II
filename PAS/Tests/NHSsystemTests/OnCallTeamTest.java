package NHSsystemTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import NHSsystem.Doctor;
import NHSsystem.Nurse;
import NHSsystem.OnCallTeam;
import NHSsystem.Patient;
import NHSsystem.TreatmentRoom;

/**
 * class to test the OnCallTeam class
 * @author Vicky
 *
 */

public class OnCallTeamTest {
	
	//test data
	
	boolean isAvailable;
	int countTimer; 
	Patient patient;
	Doctor d1, d2; 
	Nurse n1, n2, n3; 

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * test default constructor
	 */
	@Test
	public void testDefaultConstructor() {
		OnCallTeam oct = new OnCallTeam();
		assertNotNull(oct);
	}

	/**
	 * test constructor with args
	 */
	@Test
	public void testArgConstructor(){
		OnCallTeam oct = new OnCallTeam(isAvailable, countTimer, patient, d1, d2, n1, n2, n3);
		assertNotNull(oct);
	}

	/**
	 * test on call team availability
	 */
	@Test
	public void testIsAvailableGetAndSet() {
		OnCallTeam oct = new OnCallTeam();
		oct.setAvailable(true);
		
		assertEquals(true, oct.isAvailable());
	}
	

	/**
	 * test timer getter and setter
	 */
	@Test
	public void testGetAndSetCountTimer() {
		OnCallTeam oct = new OnCallTeam();
		oct.setCountTimer(10);
		
		assertEquals(10, oct.getCountTimer());

	}
	
	/**
	 * test patient getter and setter
	 */
	@Test
	public void testGetAndSetPatient() {
		OnCallTeam oct = new OnCallTeam();
		oct.setPatient(patient);
		assertEquals(patient, oct.getPatient());
	}

	/**
	 * test D1 getter and setter
	 */
	@Test
	public void testGetAndSetD1() {
		OnCallTeam oct = new OnCallTeam();
		oct.setD1(d1);
		assertEquals(d1, oct.getD1());
	}


	/**
	 * test D2 getter and setter
	 */
	@Test
	public void testGetAndSetD2() {
		OnCallTeam oct = new OnCallTeam();
		oct.setD2(d2);
		assertEquals(d2, oct.getD2());
	}

	/**
	 * test D2 getter and setter
	 */
	@Test
	public void testGetAndSetN1() {
		OnCallTeam oct = new OnCallTeam();
		oct.setN1(n1);
		assertEquals(n1, oct.getN1());
	}

	/**
	 * test D2 getter and setter
	 */
	@Test
	public void testGetAndSetN2() {
		OnCallTeam oct = new OnCallTeam();
		oct.setN2(n2);
		assertEquals(n2, oct.getN2());
	}

	/**
	 * test D2 getter and setter
	 */
	@Test
	public void testGetAndSetN3() {
		OnCallTeam oct = new OnCallTeam();
		oct.setN3(n3);
		assertEquals(n3, oct.getN3());
	}

	/**
	 * testing the toString
	 */
	@Test
	public void testToString() {
		OnCallTeam oct = new OnCallTeam();
		String toString = oct.toString();
		assertTrue(toString.contains("On Call Team Timer:"));
        
	}

}
