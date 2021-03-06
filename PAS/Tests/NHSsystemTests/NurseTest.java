package NHSsystemTests;

// import resources
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import NHSsystem.Nurse;

/**
 * Class to test the Nurse class
 * @author chrismcclune
 *
 */
public class NurseTest {
	
	// Test data
	String title;
	String firstName;
	String lastName;
	String street;
	String city;
	String postcode;
	String contactNumber;
	int staffID;

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Method to test the Defuult Constructor
	 */
	@Test
	public void testNurseDefaultConstructor() {
		Nurse nur = new Nurse();
		assertNotNull(nur);
	}

	/**
	 * Method to test the non default constructor
	 */
	@Test
	public void testNurseNonDefaultConstructor() {
		Nurse nur = new Nurse(title, firstName, lastName, street, city, postcode, contactNumber, staffID);
		assertEquals(title, nur.getTitle());
		assertEquals(firstName, nur.getFirstName());
		assertEquals(lastName, nur.getLastName());
		assertEquals(street, nur.getStreet());
		assertEquals(city, nur.getCity());
		assertEquals(postcode, nur.getPostcode());
		assertEquals(contactNumber, nur.getContactNumber());
		assertEquals(staffID, nur.getStaffID());
	}

}
