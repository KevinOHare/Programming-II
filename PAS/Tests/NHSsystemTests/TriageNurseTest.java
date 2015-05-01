package NHSsystemTests;
/**
 * to test the TriageNurse class
 * @author Vicky
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import NHSsystem.TriageNurse;

public class TriageNurseTest {

	//test data
	
	String title, firstName, lastName, street, city, postcode, contactNumber;
	int staffID;
	
	
	
	@Before
	public void setUp() throws Exception {
		
		TriageNurse tn = new TriageNurse();
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
	public void testTriageNurseDefaultConstructor() {
		TriageNurse tn = new TriageNurse();
		assertNotNull(tn);
	}

	/**
	 * test constructor with arguments
	 */
	@Test
	public void testTriageNurseArgConstructor() {
		TriageNurse tn = new TriageNurse(title, firstName, lastName, street, city, postcode, contactNumber, staffID);
		assertNotNull(tn);
	}

}
