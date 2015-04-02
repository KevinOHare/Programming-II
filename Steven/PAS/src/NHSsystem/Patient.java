/**
 * 
 */
package NHSsystem;

import queue.PatientThread;


/**
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
	 * Instance variable to count the timer method
	 */
	private int countTimer;

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
			String nhsNumber, int triage) {
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
	 * @return triage
	 */
	public int getTriage() {
		return triage;
	}

	/**
	 * Set triage priority
	 * with validation 
	 * @param triage
	 */
	public void setTriage(int triage) {
		if (triage >= 1 || triage <= 4) {
			this.triage = triage;
		} else {
			this.triage = 4;
		}
	}
	
	public int getCountTimer(){
		return countTimer;
	}
	
	public void setCountTimer(int countTimer){
		this.countTimer = countTimer;
	}

	//public boolean equals(Patient other) {
	//	return this.getTriage() == other.getTriage();
	//}

	/**
	 * Implemented with comparable to
	 * be used by priority queue to
	 * sort the triage in the right order
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
		return this.getTitle() + "  " + this.getFirstName() + "  "
				+ this.getLastName() + "  " + this.getStreet() + "  "
				+ this.getCity() + "  " + this.getPostcode() + "  "
				+ this.getContactNumber() + "  " + this.getNhsNumber() + "  *Triage:{" + this.getTriage() + "}  *QueueTimer:[" + this.getCountTimer() + "]";

	}
}
