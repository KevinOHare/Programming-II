package queue;

import NHSsystem.Patient;

public class PatientThread implements Runnable {

	/**
	 * Instance Variables
	 */
	Patient patient;
	
	/**
	 * Set properties to patient object
	 * @param patient
	 */
	public PatientThread(Patient patient){
		this.patient = patient;
	}
	
	// Instance variables
	
	private boolean threadBool = true;
	
	@Override
	public void run() {

		int loop = 0;
		do {
			//System.out.println(loop);
			loop++;
			this.patient.setCountTimer(loop);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Interupted");
			}
		} while (loop < 300); // to act as 30 mins

	}
	
	public Boolean changeBool(Boolean threadBool){
		return this.threadBool = threadBool;
	}
}
