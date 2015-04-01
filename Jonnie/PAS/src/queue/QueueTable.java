package queue;

public class QueueTable {

	private String firstName;
	private String surname;
	private Integer timeEntered;
	private Integer timeWait;
	private String condition;
	
	
	public QueueTable(String firstName, String surname, Integer timeEntered, Integer timeWait, String condition) {
		this.firstName = firstName;
		this.surname = surname;
		this.timeEntered = timeEntered;
		this.timeWait = timeWait;
		this.condition = condition;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public Integer getTimeEntered() {
		return timeEntered;
	}


	public void setTimeEntered(Integer timeEntered) {
		this.timeEntered = timeEntered;
	}


	public Integer getTimeWait() {
		return timeWait;
	}


	public void setTimeWait(Integer timeWait) {
		this.timeWait = timeWait;
	}


	public String getCondition() {
		return condition;
	}


	public void setCondition(String condition) {
		this.condition = condition;
	}


	

	

	

}
