package NHSsystemTests;

// import resources
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import NHSsystem.Doctor;

/**
 * Class to test the Doctor class
 * @author chrismcclune
 *
 */
public class DoctorTest {
	
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
	 * Method to test the Default Constructor
	 */
	@Test
	public void testDoctorDefaultConstructor() {
		Doctor doc = new Doctor();
		assertNotNull(doc);
	}

	/**
	 * Method to test the Non-Default Constructor
	 */
	@Test
	public void testDoctorNonDefaultConstructor() {
		Doctor doc = new Doctor(title, firstName, lastName, street, city, postcode, contactNumber, staffID);
		assertEquals(title, doc.getTitle());
		assertEquals(firstName, doc.getFirstName());
		assertEquals(lastName, doc.getLastName());
		assertEquals(street, doc.getStreet());
		assertEquals(city, doc.getCity());
		assertEquals(postcode, doc.getPostcode());
		assertEquals(contactNumber, doc.getContactNumber());
		assertEquals(staffID, doc.getStaffID());
		
	}

}
