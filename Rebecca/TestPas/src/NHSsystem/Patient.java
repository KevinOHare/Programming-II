/**
 * 
 */
package NHSsystem;

/**
 * @author chrismcclune
 *
 */
public class Patient extends Person {
	
	/**
	 * Instance variable for the NHS number of the patient
	 */
	private String nhsNumber;

	/**
	 * Default constructor
	 */
	public Patient() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor with arguments
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @param street
	 * @param city
	 * @param postcode
	 * @param contactNumber
	 * @param nhsNumber
	 */
	public Patient(String title, String firstName, String lastName,
			String street, String city, String postcode, String contactNumber, String nhsNumber) {
		super(title, firstName, lastName, street, city, postcode, contactNumber);
		this.nhsNumber = nhsNumber;
	}

	/**
	 * Get the NHS number of the patient
	 * @return
	 */
	public String getNhsNumber() {
		return nhsNumber;
	}

	/**
	 * Set the NHS number of the patient
	 * @param nhsNumber
	 */
	public void setNhsNumber(String nhsNumber) {
		this.nhsNumber = nhsNumber;
	}

}
