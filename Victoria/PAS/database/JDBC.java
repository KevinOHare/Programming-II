package database;

/**
 * Import resources
 */
import java.sql.*;

/**
 * Class to connect to the database and search it to hold the patient information
 * 
 * @author chrismcclune
 *
 */
public class JDBC {
	/**
	 * String to hold the JDBC driver
	 */
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	/**
	 * String to hold the URL of the database
	 */
	public static final String DB_URL = "jdbc:mysql://web2.eeecs.qub.ac.uk/40025827";

	/**
	 * String to hold the username for the database
	 */
	public static final String USER = "40025827";

	/**
	 * String to hold the password for the database
	 */
	public static final String PASS = "UYN6542";

	/**
	 * Connection object for the database
	 */
	public static Connection conn = null;

	/**
	 * Statement object for the database
	 */
	public static Statement stmt = null;

	/**
	 * String array to hold the attributes from the database
	 */
	public static String[] str = new String[9];

	/**
	 * Method to open connection to the database
	 */
	public static void openConnection() {

		// STEP 2: Register JDBC driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// STEP 3: Open a connection
		System.out.println("Connecting to database...");
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Method to search the database
	 * 
	 * @param firstName
	 * @param lastName
	 * @param postcode
	 * @param id
	 */
	public void databaseSearch(String firstName, String lastName,
			String postcode, String id) {

		try {
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
						+ rset7 + " " + rset10);

				// assign values to str array
				str[0] = rset2;
				str[1] = rset3;
				str[2] = rset4;
				str[3] = rset5;
				str[4] = rset6;
				str[5] = rset7;
				str[6] = rset9;
				str[7] = rset10;
				str[8] = rset11;

			}

			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();

		} finally {
			// finally block used to close resources
			closeConnection();
		}
		System.out.println("Goodbye!");
	}

	/**
	 * A method to return the rsets of the correct patient search
	 * 
	 * @return rsets
	 */
	public String[] rsetPrint() {
		return str;
	}

	/**
	 * Method to close the database connection
	 */
	public static void closeConnection() {

		// close the statement
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException se2) {
		}
		// close the connection
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

}