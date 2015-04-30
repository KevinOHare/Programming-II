/**
 * 
 */
package NHSsystem;

/**
 * Class that represents the hospital manager
 * 
 * @author chrismcclune
 *
 */
public class Manager extends Staff {

	/**
	 * Default constructor
	 */
	public Manager() {

	}

	/**
	 * Constructor with arguments
	 * 
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @param street
	 * @param city
	 * @param postcode
	 * @param contactNumber
	 */
	public Manager(String title, String firstName, String lastName,
			String street, String city, String postcode, String contactNumber,
			int staffID) {
		super(title, firstName, lastName, street, city, postcode,
				contactNumber, staffID);
		// add any other class specific variables here
	}

	// INSTANCE OF MANAGER
	public Manager manager = new Manager("Mr.", "Jim", "Mourinho",
			"4 Catherine Street", "Belfast", "BT2 8LX", "+447713901488", 1);

}
