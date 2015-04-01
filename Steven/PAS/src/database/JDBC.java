package database;

//STEP 1. Import required packages
import java.sql.*;

public class JDBC {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://web2.eeecs.qub.ac.uk/40025827";

	// Database credentials
	static final String USER = "40025827";
	static final String PASS = "UYN6542";

	// Boolean to confirm search status
	private Boolean bool;
	
	// create string array
	String[] str = new String[7];

	public void databaseSearch(String firstName, String lastName,
			String postcode, String id) {

		// Local Variables
		Connection conn = null;
		Statement stmt = null;
		bool = false;
		String cf = "";
		String cs = "";
		String ci = "";
		String cp = "";

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...\n");
			stmt = conn.createStatement();
			String sql1;

			// Passed in values being applied to SQL query
			String firstNamedb = firstName;
			String surNamedb = lastName;
			String postcodedb = postcode;
			String IDdb = id;

			// *** Assign values to mysql query ***
			sql1 = "SELECT ID, title, first_name, last_name, address_1, address_2, address_3, country, telephone_number, allergies, blood_type FROM patient WHERE first_name = '"
					+ firstNamedb
					+ "' AND last_name = '"
					+ surNamedb
					+ "' AND address_3 = '"
					+ postcodedb
					+ "' AND ID = '"
					+ IDdb + "'";

			// *** Result Set ***
			ResultSet rs = stmt.executeQuery(sql1);

			// STEP 5: Extract data from result set
			// Cycle through database for the result set
			while (rs.next()) {
				// Retrieve by column name

				// *** cycle through result set and assign values ***
				String rset1 = rs.getString("ID");
				String rset2 = rs.getString("title");
				String rset3 = rs.getString("first_name");
				String rset4 = rs.getString("last_name");
				String rset5 = rs.getString("address_1");
				String rset6 = rs.getString("address_2");
				String rset7 = rs.getString("address_3");
				String rset8 = rs.getString("country");
				String rset9 = rs.getString("telephone_number");
				String rset10 = rs.getString("allergies");
				String rset11 = rs.getString("blood_type");

				// *** Test ***
				System.out.println(rset1 + " " + rset3 + " " + rset4 + " "
						+ rset7);
				// assign values to str array
				str[0] = rset2;
				str[1] = rset3;
				str[2] = rset4;
				str[3] = rset5;
				str[4] = rset6;
				str[5] = rset7;
				str[6] = rset9;

				// To check for values that relate to the search tag
				if (!rset1.isEmpty() && !rset3.isEmpty() && !rset4.isEmpty()
						&& !rset7.isEmpty()) {
					cf = rset3; // First name
					cs = rset4; // surname
					ci = rset1; // nhs number or ID
					cp = rset7; // postcode
				}
			}

			// Check if a result was found, assign value to boolean to explain
			// if found or not
			if (!cf.isEmpty() && !cs.isEmpty() && !ci.isEmpty()
					&& !cp.isEmpty()) {
				bool = false; // result was found
			} else {
				bool = true; // result was not found
			}

			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			bool = true;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			bool = true;
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		System.out.println("Goodbye!");
	}// end main

	/**
	 * A method to return the status of finding the value of the search
	 * 
	 * @return bool
	 */
	public Boolean traceCond() {
		return bool;
	}

	/**
	 * A method to return the rsets of the correct patient search
	 * 
	 * @return rsets
	 */
	public String[] rsetPrint() {
		// local variable
		return str;
	}

}// ************** class ************