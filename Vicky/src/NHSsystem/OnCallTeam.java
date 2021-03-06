/**
 * 
 */
package NHSsystem;

/**
 * Class that represents the on-call team
 * 
 * @author Jonnie Leathem
 *
 */
public class OnCallTeam {

	/**
	 * The availability of the treatment room
	 */
	private boolean isAvailable;

	/**
	 * A count for the timer method
	 */
	private int countTimer;

	/**
	 * Instance of Patient object
	 */
	private Patient patient;

	/**
	 * Default constructor
	 */
	public OnCallTeam() {

	}

	/**
	 * Args based constructor
	 * 
	 * @param isAvailable
	 * @param countTimer
	 * @param patient
	 */
	public OnCallTeam(boolean isAvailable, int countTimer, Patient patient) {
		this.setAvailable(isAvailable);
		this.setCountTimer(countTimer);
		this.setPatient(patient);
	}

	/**
	 * Gets the availability of the on call team
	 * @return the isAvailable
	 */
	public boolean isAvailable() {
		return isAvailable;
	}

	/**
	 * Sets the availability of the on call team
	 * @param isAvailable
	 *            the isAvailable to set
	 */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	/**
	 * Gets the count of the on call timer
	 * @return the countTimer
	 */
	public int getCountTimer() {
		return countTimer;
	}

	/**
	 * Sets the count of the on call timer
	 * @param countTimer
	 *            the countTimer to set
	 */
	public void setCountTimer(int countTimer) {
		this.countTimer = countTimer;
	}

	/**
	 * Gets the patient being treated by on call team
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * Sets the patient being treated by on call team
	 * @param patient
	 *            the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * To string method
	 */
	@Override
	public String toString() {
		return this.isAvailable + "\t" + this.patient
				+ "\tOn Call Team Timer: " + this.getCountTimer();
	}

}
