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
	 * Run thread counting time entered 
	 * treatment room object
	 */
	@Override
	public synchronized void run() {
		
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
			
		} while (loop != 600); // to act as 10 mins
		
		
	}

}
