package NHSsystemTests;

// import resources
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import NHSsystem.Manager;

/**
 * Class to test the Manager class
 * @author chrismcclune
 *
 */
public class ManagerTest {
	
	// Test data
	String title;
	String firstName;
	String lastName;
	String street;
	String city;
	String postcode;
	String contactNumber;
	int staffID;
	String email;

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Method to test the Default Constructor
	 */
	@Test
	public void testManagerDefaultConstructor() {
		Manager man = new Manager();
		assertNotNull(man);
	}

	/**
	 * Method to test the Non-Default Constructor
	 */
	@Test
	public void testManagerNonDefaultConstructor() {
		Manager man = new Manager(title, firstName, lastName, street, city, postcode, contactNumber, staffID, email);
		assertEquals(title, man.getTitle());
		assertEquals(firstName, man.getFirstName());
		assertEquals(lastName, man.getLastName());
		assertEquals(street, man.getStreet());
		assertEquals(city, man.getCity());
		assertEquals(postcode, man.getPostcode());
		assertEquals(contactNumber, man.getContactNumber());
		assertEquals(staffID, man.getStaffID());
		assertEquals(email, man.getEmail());
	}

	/**
	 * Method to test the Get and Set of email address variable
	 */
	@Test
	public void testSetGetEmail() {
		Manager man = new Manager();
		man.setEmail(email);
		assertEquals(email, man.getEmail());
	}


}
