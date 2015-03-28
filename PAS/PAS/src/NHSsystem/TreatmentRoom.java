/**
 * 
 */
package NHSsystem;

/**
 * Class that represents the treatment rooms
 * 
 * @author chrismcclune
 *
 */
public class TreatmentRoom {

	/**
	 * The treatment room number
	 */
	private static int roomNumber;

	/**
	 * The availability of the treatment room
	 */
	private static boolean isAvailable;

	/**
	 * How long a patient has been in the room
	 */
	private void timer() {

	}

	/**
	 * Default constructor
	 */
	public TreatmentRoom() {

	}

	/**
	 * Args based constructor
	 * 
	 * @param roomNumber
	 * @param isAvailable
	 */
	public TreatmentRoom(int roomNumber, boolean isAvailable) {
		this.roomNumber = roomNumber;
		this.isAvailable = isAvailable;
	}

	/**
	 * Gets the room number
	 * 
	 * @return the roomNumber
	 */
	public static int getRoomNumber() {
		return roomNumber;
	}

	/**
	 * Sets the room number
	 * 
	 * @param roomNumber
	 *            the roomNumber to set
	 */
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * Gets the availability of the room
	 * 
	 * @return the isAvailable
	 */
	public static boolean isAvailable() {
		return isAvailable;
	}

	/**
	 * Sets the availability of the room
	 * 
	 * @param isAvailable
	 *            the isAvailable to set
	 */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

}
