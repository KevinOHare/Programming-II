package javafx;

public enum TriageEnum {
	
	// Create priority types
	EMERGENCY (1), URGENT (2), SEMI_URGENT(3), NON_URGENT(4);
	
	// Enum variables
	private final int position;
	
	private TriageEnum(int position){
		this.position = position;
	}
	
	/**
	 * get method to return the triage priority
	 * @return position
	 */
	public int getPosition(){
		return position;
	}
	
	

}
