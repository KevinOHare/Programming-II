package javafx;

public class TriageTable {

	/**
	 * Table Variables
	 */
	public static String nhs;
	private String firstName;
	private String lastName;
	private String allergy;
	private int condition;
	

	/**
	 * Argument Constructor
	 * @param nhs
	 * @param firstName
	 * @param lastName
	 * @param allergy
	 * @param condition
	 */
	public TriageTable(String nhs, String firstName, String lastName, String allergy, int condition) {
		this.nhs = nhs;
		this.firstName = firstName;
		this.lastName = lastName;
		this.allergy = allergy;
		this.condition = condition;
	}

	/**
	 * Default Constructor
	 */
	public TriageTable() {

	}
	
	/**
	 * get method for nhs id
	 * @return nhs
	 */
	public String getNhs() {
		return nhs;
	}

	/**
	 * set method for nhs id
	 * @param nhs
	 */
	public void setNhs(String nhs) {
		this.nhs = nhs;
	}

	/**
	 * get method for first name
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * set method for first name
	 * @param firstName
	 * @return 
	 */
	public String setFirstName(String firstName) {
		return this.firstName = firstName;
	}

	/**
	 * get method for last name
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * set method for last name
	 * @param lastName
	 * @return 
	 */
	public String setLastName(String lastName) {
		return this.lastName = lastName;
	}

	/**
	 * get method for allergy
	 * @return
	 */
	public String getAllergy() {
		return allergy;
	}

	/**
	 * set method for allergy
	 * @param allergy
	 * @return 
	 */
	public String setAllergy(String allergy) {
		return this.allergy = allergy;
	}

	/**
	 * get method for condition
	 * @return condition
	 */
	public int getCondition() {
		return condition;
	}

	/**
	 * set method for condition
	 * @param condition
	 */
	public void setCondition(int condition) {
		this.condition = condition;
	}

	
	
	
	
	
	
	
	
}
