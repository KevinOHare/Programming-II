/**
 * 
 */
package NHSsystem;

/**
 * @author chrismcclune
 *
 */
public abstract class Person {
	/**
	 * Instance variables to hold information about the Person
	 */
	private String title;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String postcode;
	private String contactNumber;
	
	
	/**
	 * Default constructor
	 */
	public Person(){
		
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
	public Person(String title, String firstName, String lastName, String street, String city, String postcode, String contactNumber){
		this.title = title;
		this.firstName = firstName;
		this.firstName = lastName;
		this.street = street;
		this.city = city;
		this.postcode = postcode;
		this.contactNumber = contactNumber;
	}
	
	
	/**
	 * Get the title of the Person
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Set the title of the Person
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Get the first name of the Person
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Set the first name of the Person
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Get the last name of the Person
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Set the last name of the Person
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Get the street address of the Person
	 * @return
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * Set the street address of the Person
	 * @param streetAddress
	 */
	public void setStreet(String streetAddress) {
		this.street = streetAddress;
	}
	
	/**
	 * Get the city address of the Person
	 * @return
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Set the city address of the Person
	 * @param cityAddress
	 */
	public void setCity(String cityAddress) {
		this.city = cityAddress;
	}
	
	/**
	 * Get the postcode of the Person
	 * @return
	 */
	public String getPostcode() {
		return postcode;
	}
	
	/**
	 * Set the postcode of the Person
	 * @param postCodeAddress
	 */
	public void setPostcode(String postCodeAddress) {
		this.postcode = postCodeAddress;
	}
	
	/**
	 * Get the contact number of the Person
	 * @return
	 */
	public String getContactNumber() {
		return contactNumber;
	}
	
	/**
	 * Set the contact number of the Person
	 * @param contactNumber
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
}
