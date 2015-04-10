package queue;

import NHSsystem.TreatmentRoom;

public class TreatmentRoomThread implements Runnable {

	/**
	 * Instance variable
	 */
	TreatmentRoom treatmentRoom;
	
	/**
	 * Set properties to treatment room object
	 * @param treatmentRoom
	 */
	public TreatmentRoomThread(TreatmentRoom treatmentRoom) {
		this.treatmentRoom = treatmentRoom;
	}
	
	/**
	 * Instance Variable
	 */
	private Boolean threadBool = false;

	/**
	 * Run thread counting time entered 
	 * treatment room object
	 */
	@Override
	public void run() {
		
		int loop = 0;
		
		do {
			//System.out.println(loop);
			this.treatmentRoom.setCountTimer(loop);
			loop++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex){
				System.out.println("Interrupted");
			}
			
		} while (!(loop == 100)); // to act as 10 mins
		
		setThreadBool(true);
		
	}

	/**
	 * get method for thread boolean
	 * @return threadBool
	 */
	public Boolean getThreadBool() {
		return threadBool;
	}

	/**
	 * set method for thread boolean
	 * @param threadBool
	 */
	private void setThreadBool(Boolean threadBool) {
		this.threadBool = threadBool;
	}

}
