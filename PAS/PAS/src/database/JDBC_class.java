package database;

//STEP 1. Import required packages
import java.sql.*;

public class JDBC_class {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://web2.eeecs.qub.ac.uk/40025827";

	// Database credentials
	static final String USER = "40025827";
	static final String PASS = "UYN6542";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
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

			// *** Assign values to mysql query ***
			sql1 = "SELECT ID, title, first_name, last_name, address_1, address_2, address_3, country, telephone_number, allergies, blood_type FROM patient ";
			// sql2 =
			// "SELECT id, title, firstName, lastName, address1, address2, address3, country, phone_number, allergies, blood_type FROM patient ";

			// *** Result Set ***
			ResultSet rs = stmt.executeQuery(sql1);

			// STEP 5: Extract data from result set
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
				System.out.println(rset1 + " " + rset2 + " " + rset3);

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
			}// end finally try
		}// end try
		System.out.println("Goodbye!");
	}// end main
}// end FirstExample