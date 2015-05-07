/**
 * 
 */
package NHSsystem;

/**
 * Class that represents a patient
 * 
 * @author chrismcclune
 *
 */
public class Patient extends Person implements Comparable<Patient> {

	/**
	 * Instance variable for the NHS number of the patient
	 */
	private String nhsNumber;

	/**
	 * Instance variable for triage priority
	 */
	private int triage;

	/**
	 * Constant for highest priority is emergency
	 */

	public static final int TOP_PRIORITY = 1;

	/**
	 * Constant for lowest priority is Non Emergency
	 *
	public static final int LOW_PRIORITY = 4;

	/**
	 * Instance variable to count the timer method
	 */
	private int countTimer;

	/**
	 * Instance variable to signal if patient is in a treatment room
	 */
	private Boolean inRoom = false;

	/**
	 * Instance variable to indicate if patient is is an emergency condition
	 */
	private boolean emergencyCondition;

	/**
	 * Instance variable to indicate if patient timer has exceeded queue time
	 * limit
	 */
	private int PatientMin;

	/**
	 * Instance Variable of Allergy
	 */
	private String allergy;

	/**
	 * Instance Variable of Blood Type
	 */
	private String bloodType;

	/**
	 * Default constructor
	 */
	public Patient() {

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

	/**
	 * Get triage priority
	 * 
	 * @return triage
	 */
	public int getTriage() {
		return triage;
	}

	/**
	 * Set triage priority with validation
	 * 
	 * @param triage
	 */
	public void setTriage(int triage) {
		if (triage >= 1 || triage <= 4) {
			this.triage = triage;
		} else {
			this.triage = 4;
		}
	}

	/**
	 * get method for the count timer
	 * 
	 * @return countTimer
	 */
	public int getCountTimer() {
		return countTimer;
	}

	/**
	 * set method for the count timer
	 * 
	 * @param countTimer
	 */
	public void setCountTimer(int countTimer) {
		this.countTimer = countTimer;
	}

	/**
	 * get method for the in room boolean
	 * 
	 * @return inRoom
	 */
	public Boolean getInRoom() {
		return inRoom;
	}

	/**
	 * set method for the in room boolean
	 * 
	 * @param inRoom
	 */
	public void setInRoom(Boolean inRoom) {
		this.inRoom = inRoom;
	}

	/**
	 * @return the emergencyCondition
	 */
	public boolean getEmergencyCondition() {
		return emergencyCondition;
	}

	/**
	 * to set emergencyCondition
	 * 
	 * @param emergencyCondition
	 */
	public void setEmergencyCondition(boolean emergencyCondition) {
		this.emergencyCondition = emergencyCondition;
	}

	/**
	 * to get the patient min limit
	 * 
	 * @return PatientMin
	 */
	public int getPatientMin() {
		return PatientMin;
	}

	/**
	 * to set the patient min limit
	 * 
	 * @param PatientMin
	 */
	public void setPatientMin(int PatientMin) {
		this.PatientMin = PatientMin;
	}

	/**
	 * get allergy method
	 * 
	 * @return allergy
	 */
	public String getAllergy() {
		return allergy;
	}

	/**
	 * set allergy method
	 * 
	 * @param allergy
	 */
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	/**
	 * get blood type method
	 * 
	 * @return bloodType
	 */
	public String getBloodType() {
		return bloodType;
	}

	/**
	 * set blood type method
	 * 
	 * @param bloodType
	 */
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	/**
	 * Implemented with comparable to be used by priority queue to sort the
	 * triage in the right order
	 */

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

	/**
	 * A to string method to print results
	 */
	@Override
	public String toString() {
		return this.getFirstName() + "  " + this.getLastName() + "  |  *Triage:{" + this.getTriage()
				+ "}  *QueueTimer:[" + this.getCountTimer() + "]  |";

	}

}
