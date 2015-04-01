package javafx;

public class Table {

	private String FirstName;
	private String LastName;
	private Integer Position;
	
	
	public Table(String FirstName, String LastName, Integer Position) {
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Position = Position;
	}


	public String getFirstName() {
		return FirstName;
	}
	
	public void setFirstName(String FirstName){
		this.FirstName = FirstName;
	}

	public String getLastName() {
		return LastName;
	}
	
	public void setLastName(String LastName){
		this.LastName = LastName;
	}

	public Integer getPosition() {
		return Position;
	}

	public void setPosition(Integer Position){
		this.Position = Position;
	}

	

	

}
