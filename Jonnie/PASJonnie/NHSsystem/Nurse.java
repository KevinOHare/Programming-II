/**
 * 
 */
package NHSsystem;

/**
 * Class that represents a nurse
 * 
 * @author chrismcclune
 *
 */
public class Nurse extends Staff {

	/**
	 * Default constructor
	 */
	public Nurse() {
		
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
	public Nurse(String title, String firstName, String lastName,
			String street, String city, String postcode, String contactNumber,
			int staffID) {
		super(title, firstName, lastName, street, city, postcode,
				contactNumber, staffID);
		// add any other class specific variables here
	}

	// INSTANCES OF NURSES

	public static Nurse n1 = new Nurse("Ms.", "Josephina", "Barton",
			"2A Manderson Street", "Belfast", "BT4 1TR", "02838348854", 20);
	public static Nurse n2 = new Nurse("Mr.", "James", "McEvoy", "13 Aston Gardens",
			"Belfast", "BT4 3FS", "02838347665", 21);
	public static Nurse n3 = new Nurse("Ms.", "Roberta", "McGregor",
			"15 Aston Gardens", "Belfast", "BT4 3FS", "02838342355", 22);

}
