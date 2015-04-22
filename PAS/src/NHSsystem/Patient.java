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
	 * highest priority is emergency
	 */
	
	private static final int TOP_PRIORITY = 1;
	
	/** 
	 * lowest priority is Non Emergency
	 */
	
	private static final int LOW_PRIORITY = 4;
	
	/**
	 * Instance variable to count the timer method
	 */
	private int countTimer;
	
	/**
	 * Instance variable to signal if patient is
	 * in a treatment room
	 */
	private Boolean inRoom = false;
	
	/**
	 * Instance variable to indicate if patient is 
	 * is an emergency condition
	 */
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
		if (triage >= TOP_PRIORITY || triage <= LOW_PRIORITY) {
			this.triage = triage;
		} else if (triage < TOP_PRIORITY) {
			this.triage = 1;
		} else {
			this.triage = LOW_PRIORITY;
			this.triage = 4;
		}
	}
	
	/**
	 * get method for the count timer
	 * @return countTimer
	 */
	public int getCountTimer(){
		return countTimer;
	}
	
	/**
	 * set method for the count timer
	 * @param countTimer
	 */
	public void setCountTimer(int countTimer){
		this.countTimer = countTimer;
	}
	
	/**
	 * get method for the in room boolean
	 * @return inRoom
	 */
	public Boolean getInRoom(){
		return inRoom;
	}
	
	/**
	 * set method for the in room boolean
	 * @param inRoom
	 */
	public void setInRoom(Boolean inRoom){
		this.inRoom = inRoom;
	}
	
	/**
	 * @return the emergencyCondition
	 */
	public boolean isEmergencyCondition() {
		return emergencyCondition;
	}

	/**
	 * to set emergencyCondition
	 * @param emergencyCondition 
	 */
	public void setEmergencyCondition(boolean emergencyCondition) {
		this.emergencyCondition = emergencyCondition;
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
		return this.getFirstName() + "  "
				+ this.getLastName() + "   ID:" + this.getNhsNumber() + "  |  *Triage:{" + this.getTriage() + "}  *QueueTimer:[" + this.getCountTimer() + "]  |";

	}

}

