package NHSsystemTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import NHSsystem.Staff;
import NHSsystem.TriageNurse;

/**
 * to test Staff class
 * @author Vicky
 *
 */

public class TestStaff {
	
	
	//test data
	
		String title, firstName, lastName, street, city, postcode, contactNumber;
		int staffID;
		

	@Before
	public void setUp() throws Exception {
		
		Staff staff = new Staff();
		title = "Miss";
		firstName = "Mary";
		lastName = "Wilson";
		street = "2 Din Lane";
		city = "Lisburn";
		postcode = "BT28 5TO";
		contactNumber = "02892 663 663";
		staffID = 40020449;
		
	}
	
	/**
	 * test default constructor
	 */
	@Test
	public void testStaffDefaultConstructor() {
		Staff staff = new Staff();
		assertNotNull(staff);
	}

	/**
	 * test constructor with arguments
	 */
	@Test
	public void testStaffArgConstructor() {
		Staff staff = new Staff(title, firstName, lastName, street, city, postcode, contactNumber, staffID);
		assertNotNull(staff);
	}

	@Test
	/**
	 * test staffID getter and setter
	 */
	public void testStaffIDGetAndSet() {
		Staff staff = new Staff();
		staff.setStaffID(staffID);
		
		assertEquals(40020449, staff.getStaffID());
}
}