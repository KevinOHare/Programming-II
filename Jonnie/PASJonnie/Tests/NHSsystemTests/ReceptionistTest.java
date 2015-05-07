package NHSsystemTests;

import static org.junit.Assert.*;

import org.junit.Test;

import NHSsystem.Receptionist;
/**
 * Testing the receptionist class
 * @author Rebecca Mckevitt
 *
 */
public class ReceptionistTest {
	
	//Test Data
	//Creating the receptionist object 
	static Receptionist r = new Receptionist();
	//Creating the receptionist object with vaild args
	static Receptionist r1 = new Receptionist("Miss", "Jane", "Kennedy", "Hillstreet", "Newry",
			"BT389HT", "0756767676", 8759);

	
	/**
	 * Testing the default constructor 
	 */
	@Test
	public void testReceptionist() {
		assertNotNull(r);
	}
	
	/**
	 * Testing the constructor with args
	 */
	@Test
	public void testReceptionistConstructor() {

		assertNotNull(r1);
	}
	
	/**
	 * Testing setting and getting title
	 */
	@Test
	public void testReceptionistTitle(){
		r.setTitle("Mr");
		assertEquals("Mr", r.getTitle());
	}
	
	/**
	 * Testing setting and getting FirstName
	 */
	@Test
	public void testReceptionistFirstName(){
		r.setFirstName("Sarah");
		assertEquals("Sarah", r.getFirstName());
	}
	
	/**
	 * Testing setting and getting LastName
	 */
	@Test
	public void testReceptionistLastName(){
		r.setLastName("Smith");
		assertEquals("Smith", r.getLastName());
	}
	
	/**
	 * Testing setting and getting Street
	 */
	@Test
	public void testReceptionistStreet(){
		r.setStreet("Hilltown");
		assertEquals("Hilltown", r.getStreet());
	}
	
	/**
	 * Testing setting and getting City
	 */
	@Test
	public void testReceptionistCity(){
		r.setCity("Belfast");
		assertEquals("Belfast", r.getCity());
	}
	
	/**
	 * Testing setting and getting Postcode
	 */
	@Test
	public void testReceptionistPostcode(){
		r.setPostcode("BT79FG");
		assertEquals("BT79FG", r.getPostcode());
	}
	
	/**
	 * Testing setting and getting ContactNumber
	 */
	@Test
	public void testReceptionistContactNumber(){
		r.setContactNumber("075979799");
		assertEquals("075979799", r.getContactNumber());
	}
	
	/**
	 * Testing setting and getting StaffID
	 */
	@Test
	public void testReceptionistStaffID(){
		r.setStaffID(9988);
		assertEquals(9988, r.getStaffID());
	}



}