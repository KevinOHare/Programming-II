package javafx;

/**
 * Class to show the reception table and its functionality
 * @author chrismcclune
 *
 */
public class ReceptionLayoutTable {

	/**
	 * String for the title in the table
	 */
	private String title;
	
	/**
	 * String for the first name in the table
	 */
	private String firstName;
	
	/**
	 * String for the last name in the table
	 */
	private String lastName;
	
	/**
	 * String for the street in the table
	 */
	private String street;
	
	/**
	 * String for the city in the table
	 */
	private String city;
	
	/**
	 * String for the postcode in the table
	 */
	private String postcode;
	
	/**
	 * String for the telephone in the table
	 */
	private String telephone;

	/**
	 * Args Constructor
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @param street
	 * @param city
	 * @param postcode
	 * @param telephone
	 */
	public ReceptionLayoutTable(String title, String firstName,
			String lastName, String street, String city, String postcode,
			String telephone) {
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.postcode = postcode;
		this.telephone = telephone;
	}

	/**
	 * Default Constructor
	 */
	public ReceptionLayoutTable() {

	}
	
	/**
	 * get title
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * set title
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * get first name
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * set first name
	 * @param firstName
	 * @return 
	 */
	public String setFirstName(String firstName) {
		return this.firstName = firstName;
	}

	/**
	 * get last name
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * set last name
	 * @param lastName
	 * @return 
	 */
	public String setLastName(String lastName) {
		return this.lastName = lastName;
	}

	/**
	 * get street
	 * @return street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * set street
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * get city
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * set city
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * get postcode
	 * @return postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * set postcode
	 * @param postcode
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * get telephone
	 * @return telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * set telephone
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
