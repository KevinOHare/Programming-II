package NHSsystem;


/**
 * RoomOccupiedException
 * Thrown when trying to place patient into an already occupied room 
 * @author Vicky Stacey
 */
public class RoomOccupiedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public RoomOccupiedException() {
		super("Exception: Room Occupied");
	}
	
	/**
	 * Constructor
	 * @param arg Optional string message
	 */
	
	public RoomOccupiedException(String arg) {
		super(arg);
	}
}

