/**
 * 
 */
package NHSsystem;

/**
 * Class that represents the on call team
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
	 * Instance of first doctor
	 */
	private Doctor d1;
	
	/**
	 * Instance of second doctor
	 */
	private Doctor d2;
	
	/**
	 * Instance of first nurse
	 */
	private Nurse n1;
	
	/**
	 * Instance of second nurse
	 */
	private Nurse n2;
	
	/**
	 * Instance of third nurse
	 */
	private Nurse n3;

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
	 * @param d1
	 * @param d2
	 * @param n1
	 * @param n2
	 * @param n3
	 */
	public OnCallTeam(boolean isAvailable, int countTimer, Patient patient,
			Doctor d1, Doctor d2, Nurse n1, Nurse n2, Nurse n3) {
		this.isAvailable = isAvailable;
		this.countTimer = countTimer;
		this.patient = patient;
		this.d1 = d1;
		this.d2 = d2;
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
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
	 * Gets the first doctor
	 * @return the d1
	 */
	public Doctor getD1() {
		return d1;
	}

	/**
	 * Sets the first doctor
	 * @param d1 the d1 to set
	 */
	public void setD1(Doctor d1) {
		this.d1 = d1;
	}

	/**
	 * Gets the second doctor
	 * @return the d2
	 */
	public Doctor getD2() {
		return d2;
	}

	/**
	 * Sets the second doctor
	 * @param d2 the d2 to set
	 */
	public void setD2(Doctor d2) {
		this.d2 = d2;
	}

	/**
	 * Gets the first nurse
	 * @return the n1
	 */
	public Nurse getN1() {
		return n1;
	}

	/**
	 * Sets the first nurse
	 * @param n1 the n1 to set
	 */
	public void setN1(Nurse n1) {
		this.n1 = n1;
	}

	/**
	 * Gets the second nurse
	 * @return the n2
	 */
	public Nurse getN2() {
		return n2;
	}

	/**
	 * Sets the second nurse
	 * @param n2 the n2 to set
	 */
	public void setN2(Nurse n2) {
		this.n2 = n2;
	}

	/**
	 * Gets the third nurse
	 * @return the n3
	 */
	public Nurse getN3() {
		return n3;
	}

	/**
	 * Sets the third nurse
	 * @param n3 the n3 to set
	 */
	public void setN3(Nurse n3) {
		this.n3 = n3;
	}

	/**
	 * To string method
	 */
	@Override
	public String toString() {
		return this.isAvailable + "\t\t" + this.patient
				+ "\tOn Call Team Timer: " + this.getCountTimer();
	}

}
