package database;

/**
 * import resources
 */
import java.sql.*;

/**
 * Class used to connect to the database and search for patient details
 * 
 * @author chrismcclune
 *
 */
public class JDBC {

	/**
	 * String for the JDBC driver
	 */
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	/**
	 * String for the database URL
	 */
	static final String DB_URL = "jdbc:mysql://web2.eeecs.qub.ac.uk/40025827";

	/**
	 * String for the username of the database
	 */
	static final String USER = "40025827";

	/**
	 * String for the password of the database
	 */
	static final String PASS = "UYN6542";

	/**
	 * String array for the attributes in the database
	 */
	public static String[] str = new String[9];

	/**
	 * Method to connect and search the database and save patient details
	 * 
	 * @param firstName
	 * @param lastName
	 * @param postcode
	 * @param id
	 */
	public void databaseSearch(String firstName, String lastName,
			String postcode, String id) {

		// Local Variables
		Connection conn = null;
		Statement stmt = null;

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			stmt = conn.createStatement();
			String sql1;

			// Passed in values with whitespace and 's removed
			String firstNamedb = firstName.replaceAll(" ", "");
			String surNamedb = lastName.replaceAll(" ", "").replaceAll("'", "");
			String postcodedb = postcode.replaceAll(" ", "");
			String IDdb = id;

			// REPLACE removes whitespace and 's
			sql1 = "SELECT * FROM patient WHERE REPLACE (first_name,' ','') = '"
					+ firstNamedb
					+ "' and REPLACE(REPLACE(last_name, '''', ''),' ','') = '"
					+ surNamedb
					+ "' and REPLACE(address_3, ' ', '') = '"
					+ postcodedb + "' and ID = '" + IDdb + "';";

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
			}
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

}