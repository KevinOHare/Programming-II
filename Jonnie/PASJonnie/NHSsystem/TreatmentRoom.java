/**
 * 
 */
package NHSsystem;

/**
 * Class that represents the treatment rooms
 * 
 * @author chrismcclune
 *
 */
public class TreatmentRoom {

	/**
	 * The treatment room number
	 */
	private int roomNumber;

	/**
	 * The availability of the treatment room
	 */
	private boolean isAvailable;

	/**
	 * A count for the timer method
	 */
	private int countTimer;
	
	/**
	 * Instance of Doctor object
	 */
	private Doctor doctor;
	
	/**
	 * Instance of Patient object
	 */
	private Patient patient;

	/**
	 * Default constructor
	 */
	public TreatmentRoom() {

	}

	/**
	 * Args based constructor
	 * 
	 * @param roomNumber
	 * @param isAvailable
	 */
	public TreatmentRoom(int roomNumber, boolean isAvailable) {
		this.roomNumber = roomNumber;
		this.isAvailable = isAvailable;
	}

	/**
	 * Gets the room number
	 * 
	 * @return the roomNumber
	 */
	public int getRoomNumber() {
		return roomNumber;
	}

	/**
	 * Sets the room number
	 * 
	 * @param roomNumber
	 *            the roomNumber to set
	 */
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * Gets the availability of the room
	 * 
	 * @return the isAvailable
	 */
	public boolean isAvailable() {
		return isAvailable;
	}

	/**
	 * Sets the availability of the room
	 * 
	 * @param isAvailable
	 *            the isAvailable to set
	 */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	/**
	 * @return the doctor
	 */
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 * @param doctor the doctor to set
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/**
	 * Get the Patient object
	 * @return patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * Set the Patient object
	 * @param as
	 */
	public void setPatient(Patient as) {
		this.patient = as;
	}
	
	/**
	 * Get the count of the treatment thread timer
	 * @return countTimer
	 */
	public int getCountTimer(){
		return countTimer;
	}
	
	/**
	 * Set the count of the treatment thread timer
	 * @param countTimer
	 */
	public void setCountTimer(int countTimer){
		this.countTimer = countTimer;
	}
	
	/**
	 * A to string method to print the results
	 */
	@Override
	public String toString(){
		return this.roomNumber + " \t\t " + this.isAvailable + " \t\t    " + this.patient + "  |  *TreatTimer=[" + this.getCountTimer() + "]  |";
	}

}
