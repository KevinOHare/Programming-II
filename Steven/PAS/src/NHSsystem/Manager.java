/**
 * 
 */
package NHSsystem;

/**
 * @author chrismcclune
 *
 */
public class Manager extends Staff {

	/**
	 * Default constructor
	 */
	public Manager() {
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
	public Manager(String title, String firstName, String lastName,
			String street, String city, String postcode, String contactNumber, int staffID) {
		super(title, firstName, lastName, street, city, postcode, contactNumber, staffID);
		// add any other class specific variables here
	}

}
