package javafx;

public class QueueTable {

	/**
	 * Table variables
	 */
	private String firstName;
	private String surname;
	private Integer timeEntered;
	private Integer timeWait;
	private String condition;
	
	/**
	 * Default Constructor
	 */
	public QueueTable(){
		
	}
	
	/**
	 * Args Constructor
	 * @param firstName
	 * @param surname
	 * @param timeEntered
	 * @param timeWait
	 * @param condition
	 */
	public QueueTable(String firstName, String surname, Integer timeEntered, Integer timeWait, String condition) {
		this.firstName = firstName;
		this.surname = surname;
		this.timeEntered = timeEntered;
		this.timeWait = timeWait;
		this.condition = condition;
	}

	/**
	 * get first name
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * set first name
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * get surname
	 * @return surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * set surname
	 * @param surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * get time entered
	 * @return timeEntered
	 */
	public Integer getTimeEntered() {
		return timeEntered;
	}

	/**
	 * set time entered
	 * @param timeEntered
	 */
	public void setTimeEntered(Integer timeEntered) {
		this.timeEntered = timeEntered;
	}

	/**
	 * get time wait
	 * @return timeWait
	 */
	public Integer getTimeWait() {
		return timeWait;
	}

	/**
	 * set time wait
	 * @param timeWait
	 */
	public void setTimeWait(Integer timeWait) {
		this.timeWait = timeWait;
	}

	/**
	 * get condition
	 * @return condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * set condition
	 * @param condition
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}


	

	

	

}
