package database;

public class JDBC_getAndSet {

	/**
	 * Attributes
	 */
	private String firstNamedb;
	private String surNamedb;
	private String nhsNumdb;
	
	/**
	 * Default Constructor
	 */
	public JDBC_getAndSet() {

	}

	/**
	 * Args Constructor
	 * @param firstNamedb
	 * @param surNamedb
	 * @param nhsNumdb
	 */
	public JDBC_getAndSet(String firstNamedb, String surNamedb, String nhsNumdb) {
		this.firstNamedb = firstNamedb;
		this.surNamedb = surNamedb;
		this.nhsNumdb = nhsNumdb;
	}

	/**
	 * Getter for first name database search
	 * @return firstNamedb
	 */
	public String getFirstNamedb() {
		return firstNamedb;
	}

	/**
	 * Setter for first name database search
	 * @param firstNamedb
	 */
	public void setFirstNamedb(String firstNamedb) {
		this.firstNamedb = firstNamedb;
	}

	/**
	 * Getter for surname database search
	 * @return surNamedb
	 */
	public String getSurNamedb() {
		return surNamedb;
	}

	/**
	 * Setter for surname database search
	 * @param surNamedb
	 */
	public void setSurNamedb(String surNamedb) {
		this.surNamedb = surNamedb;
	}

	/**
	 * Getter for nhs number database search
	 * @return nhsNumdb
	 */
	public String getNhsNumdb() {
		return nhsNumdb;
	}

	/**
	 * Setter for nhs number database search
	 * @param nhsNumdb
	 */
	public void setNhsNumdb(String nhsNumdb) {
		this.nhsNumdb = nhsNumdb;
	}

}
