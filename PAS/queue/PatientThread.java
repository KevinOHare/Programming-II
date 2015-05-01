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
	private int loop;
	
	public int getLoop() {
		return loop;
	}

	public void setLoop(int loop) {
		this.loop = loop;
	}
	@Override
	public synchronized void run() {

		 loop = 0;
		do {
			loop++;
			this.patient.setCountTimer(loop);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Interupted");
			}
		} while (loop < 30000000); // max of 500mins in the queue, can be changed.

	}

	public Boolean changeBool(Boolean threadBool) {
		return this.threadBool = threadBool;
	}

}
