package queue;

import NHSsystem.TreatmentRoom;

public class QueueManager {
	private static int roomNumber;
	private static boolean roomAvailable;
	

	public static void main(String[] args) {
		
		roomNumber = TreatmentRoom.getRoomNumber();
		roomAvailable = TreatmentRoom.isAvailable();

		if (roomAvailable = true);
			
	}

}
