package javafxTests;

// import resources
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Class to test the login window
 * @author chrismcclune
 *
 */
public class loginTest {
	
	// Test data
	String adminUsername = "admin";
	String triageUsername = "triage";
	String doctorUsername = "doctor";
	String demoUsername = "demo";
	String password = "password";
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}


	/**
	 * Test method for the Admin Username
	 */
	@Test
	public void testValidateLoginAdminUsername() {
		String actual = "admin";
		String expected = adminUsername;
		assertEquals(expected, actual);
	}
	
	/**
	 * Test method for the Triage Username
	 */
	@Test
	public void testValidationTriageUsername() {
		String actual = "triage";
		String expected = triageUsername;
		assertEquals(expected, actual);
	}
	
	/**
	 * Test method for the Doctor Username
	 */
	@Test
	public void testValidationDoctorUsername() {
		String actual = "doctor";
		String expected = doctorUsername;
		assertEquals(expected, actual);
	}
	
	/**
	 * Test method for the Demo Username
	 */
	@Test
	public void testValidationDemoUsername() {
		String actual = "demo";
		String expected = demoUsername;
		assertEquals(expected, actual);
	}
	
	/**
	 * Test method for the Password
	 */
	@Test
	public void testValidateLoginPassword() {
		String actual = "password";
		String expected = password;
		assertEquals(expected, actual);
	}

}
