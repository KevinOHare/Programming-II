/**
 * 
 */
package NHSsystem;

/**
 * Class that represents a doctor
 * 
 * @author chrismcclune
 *
 */
public class Doctor extends Staff {

	/**
	 * Default constructor
	 */
	public Doctor() {
		
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
	 * @param staffID
	 */
	public Doctor(String title, String firstName, String lastName,
			String street, String city, String postcode, String contactNumber,
			int staffID) {
		super(title, firstName, lastName, street, city, postcode,
				contactNumber, staffID);
	}

	// INTANCES OF DOCTORS

	public static Doctor d1 = new Doctor("Dr.", "Jospeh", "Barton",
			"383 Holywood Road", "Belfast", "BT4 2LS", "02838345746", 10);
	public static Doctor d2 = new Doctor("Dr.", "Floyd", "Pacquiao",
			"30 Eastleigh Drive", "Belfast", "BT4 3DX", "02838340092", 11);
	public static Doctor d3 = new Doctor("Dr.", "Manny", "Mayweather",
			"15 Aston Gardens", "Belfast", "BT4 3FS", "02838341246", 12);
	public static Doctor d4 = new Doctor("Dr.", "Kate", "Taylor", "35 Stoney Road",
			"Belfast", "BT4 2XS", "02838345835", 13);
	public static Doctor d5 = new Doctor("Dr.", "Todd", "Umptious",
			"1 Churchland Close", "Holywood", "BT18 9LF", "02838341823", 14);
	public static Doctor d6 = new Doctor("Dr.", "Sarah", "Parker",
			"385 Holywood Road", "Belfast", "BT4 2LS", "02838343321", 15);
	public static Doctor d7 = new Doctor("Dr.", "Jessica", "Parker", "1 Orchard Lane",
			"Belfast", "BT4 5BS", "02838345731", 16);

}
