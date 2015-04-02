/**
 * 
 */
package NHSsystem;

import javafx.SceneBuilderTable;

/**
 * @author chrismcclune
 *
 */
public class Patient extends Person implements Comparable<Patient> {

	/**
	 * Instance variable for the NHS number of the patient
	 */
	private String nhsNumber;

	private int triage;
	
	private boolean emergencyCondition;

	/**
	 * Default constructor
	 */
	public Patient() {
		// TODO Auto-generated constructor stub
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
	 * @param nhsNumber
	 */
	public Patient(String title, String firstName, String lastName,
			String street, String city, String postcode, String contactNumber,
			String nhsNumber, int triage, boolean emergencyCondition) {
		super(title, firstName, lastName, street, city, postcode, contactNumber);
		this.nhsNumber = nhsNumber;
		this.emergencyCondition = emergencyCondition;
		this.setTriage(triage);
	}

	/**
	 * Get the NHS number of the patient
	 * 
	 * @return
	 */
	public String getNhsNumber() {
		return nhsNumber;
	}

	/**
	 * Set the NHS number of the patient
	 * 
	 * @param nhsNumber
	 */
	public void setNhsNumber(String nhsNumber) {
		this.nhsNumber = nhsNumber;
	}

	public int getTriage() {
		return triage;
	}

	public void setTriage(int triage) {
		if (triage >= 1 || triage <= 4) {
			this.triage = triage;
		} else {
			this.triage = 4;
		}
	}

	//public boolean equals(Patient other) {
	//	return this.getTriage() == other.getTriage();
	//}

	@Override
	public int compareTo(Patient other) {

		if (this.equals(other)) {
			return 0;
		} else if (this.getTriage() > other.getTriage()) {
			return 1;
		} else {
			return -1;
		}

	}

	@Override
	public String toString() {
		return this.getTitle() + "  " + this.getFirstName() + "  "
				+ this.getLastName() + "  " + this.getStreet() + "  "
				+ this.getCity() + "  " + this.getPostcode() + "  "
				+ this.getContactNumber() + "  " + this.getNhsNumber() + "  " + this.getTriage();

	}

	public boolean isEmergencyCondition() {
		return emergencyCondition;
	}

	public void setEmergencyConditon(boolean emergencyCondition) {
		this.emergencyCondition = emergencyCondition;
	}
	
	 public int compare(Patient patient1, Patient patient2) {
         return (patient1.isEmergencyCondition() == patient2.isEmergencyCondition()) ?
        		(Integer.valueOf(patient1.getTriage()).compareTo(patient2.getTriage())) : 
        		(patient1.isEmergencyCondition() ? -1 : 1);

	 }
}
