/**
 * 
 */
package NHSsystem;

/**
 * @author chrismcclune
 *
 */
public class OnCallTeam extends Person {

	/**
	 * Default constructor
	 */
	public OnCallTeam() {
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
	 */
	public OnCallTeam(String title, String firstName, String lastName,
			String street, String city, String postcode, String contactNumber) {
		super(title, firstName, lastName, street, city, postcode, contactNumber);
		// add any other class specific variables here
	}

}
