package NHSsystem;

public interface Triaged {
	
	/**
	 * Getter for patient triage priority
	 * @return Patient triage priority
	 */
	
	public int getTriage();
	
	/**
	 * Setter for patient triage priority
	 * @param triage New priority to assign to patient
	 */
	public void setTriage(int triage);
	
	/**
	 * Compares the priority of this patient to another patient.
	 * Returns a negative number if this priority is lower than another priority.
	 * Returns a positive number if this priority is higher than another priority.
	 * @param p Other patient to compare to this patient
	 * @return Difference between patient priorities
	 */
	public int compareToTriage(Triaged p);

}

