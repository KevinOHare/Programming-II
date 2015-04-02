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
	public void run() {
		
		int loop = 0;
		
		do {
			System.out.println(loop);
			this.treatmentRoom.timer(loop);
			loop++;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ex){
				System.out.println("Interrupted");
			}
			
		} while (!(loop == 100));
		
	}

}
