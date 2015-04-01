package javafx;

public class ReceptionLayoutTable {

	// Variables
	private String title;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String postcode;
	private String telephone;

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

	public ReceptionLayoutTable() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
