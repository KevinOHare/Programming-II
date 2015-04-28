package queue;

import NHSsystem.Patient;
import onCallMessage.OnCallMessage;


public class PatientThread implements Runnable {

	/**
	 * Instance Variables
	 */
	Patient patient;

	/**
	 * Set properties to patient object
	 * 
	 * @param patient
	 */
	public PatientThread(Patient patient) {
		this.patient = patient;
	}

	// Instance variables

	private boolean threadBool = true;
	
	@Override
	public void run() {

		int loop = 0;
		do {
			// System.out.println(loop);
			loop++;
			this.patient.setCountTimer(loop);
			
			// 25 mins has passed
			if (loop == 1500) { 
				// set triage to 1 so patient 
				// can move up queue
				this.patient.setTriage(1);
			}
			
			// 30 mins has passed
			if (loop >= 1800){
				// set patient beyound 
				this.patient.setPatientMin(1);
			}
				
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Interupted");
			}
		} while (loop < 3000); // to act as say 40 mins

	}

	public Boolean changeBool(Boolean threadBool) {
		return this.threadBool = threadBool;
	}
}
