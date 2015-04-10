/**
 * 
 */
package NHSsystem;

/**
 * @author chrismcclune
 *
 */
public class Staff extends Person {
	
	/**
	 * Instance variable for the staffID of the staff member
	 */
	private int staffID;

	/**
	 * 
	 */
	public Staff() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @param street
	 * @param city
	 * @param postcode
	 * @param contactNumber
	 * @param staffID
	 */
	public Staff(String title, String firstName, String lastName,
			String street, String city, String postcode, String contactNumber, int staffID) {
		super(title, firstName, lastName, street, city, postcode, contactNumber);
		this.staffID = staffID;
	}

	/**
	 * Get the staff ID of the staff member
	 * @return
	 */
	public int getStaffID() {
		return staffID;
	}

	/**
	 * Set the staff ID of the staff member
	 * @param staffID
	 */
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

}
