package javafx;

public class ReceptionLayoutTable {

	/**
	 * Table variables
	 */
	private String title;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String postcode;
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
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
