/**
 * 
 */
package NHSsystem;

/**
 * Class that represents the triage nurse
 * 
 * @author chrismcclune
 *
 */
public class TriageNurse extends Staff {

	/**
	 * Default constructor
	 */
	public TriageNurse() {
		
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
	 */
	public TriageNurse(String title, String firstName, String lastName,
			String street, String city, String postcode, String contactNumber, int staffID) {
		super(title, firstName, lastName, street, city, postcode, contactNumber, staffID);
		// add any other class specific variables here
	}

}
