package javafx;

public class SceneBuilderTable implements Comparable<SceneBuilderTable> {

	private String FirstName;
	private String LastName;
	private String Position;
	private int triage;

	public SceneBuilderTable(String FirstName, String LastName, String Position) {
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Position = Position;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public String getPosition() {
		return Position;
	}

	public void setPosition(String Position) {
		this.Position = Position;
	}

	public int getTriage() {
		return triage;
	}

	public void setTriage(String triage) {

		switch (triage) {
		case "emergency":
			this.triage = 1;
			break;
		case "urgent":
			this.triage = 2;
			break;
		case "semi-urgent":
			this.triage = 3;
			break;
		case "non-urgent":
			this.triage = 4;
			break;
		}

	}

	public boolean equals(SceneBuilderTable other) {
		return this.getTriage() == other.getTriage();
	}

	@Override
	public int compareTo(SceneBuilderTable other) {

		if (this.equals(other)) {
			return 0;
		} else if (this.getTriage() > other.getTriage()) {
			return 1;
		} else {
			return -1;
		}

	}

	@Override
	public String toString() {
		System.out.println(this.FirstName + " " + this.LastName + " " + this.triage);
		return super.toString();
	}

}
