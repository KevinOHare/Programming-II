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
	
	private String email;

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
			int staffID, String email) {
		super(title, firstName, lastName, street, city, postcode,
				contactNumber, staffID);
		this.email = email;
		// add any other class specific variables here
	}

	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// INSTANCE OF MANAGER
	public Manager manager = new Manager("Mr.", "Jim", "Mourinho",
			"4 Catherine Street", "Belfast", "BT2 8LX", "+447713901488", 1, "chris.mcclune@hotmail.com");

}
