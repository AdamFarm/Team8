package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.UUID;

public class Register {

	String db_url = "jdbc:oracle:thin:@team8oracle.c7mfymi8txgn.us-east-2.rds.amazonaws.com:1521:ORCL";
	String db_user = "Team8";
	String db_pass = "team8iscool";

	/*
	 * String user; String pass; String user_id; String priv_id; String sec_id;
	 * String created_on; String created_by; String last_updated_on; String
	 * last_updated_by;
	 */
	Connection conn = null;
	Statement stmt = null;

	public void createUser() {
		Scanner user_input = new Scanner(System.in);
		System.out.println("Create a Username: ");
		String user = user_input.next();

		Scanner pass_input = new Scanner(System.in);
		System.out.println("Create a Password: ");
		String pass = pass_input.next();
		user_input.close();
		pass_input.close();

		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			conn = DriverManager.getConnection(db_url, db_user, db_pass);
			System.out.println("Connected database successfully...");

			System.out.println("Inserting records into the table...");
			stmt = conn.createStatement();

			String sql = String.format("INSERT INTO USER_INFO VALUES (?,?,?)");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.setString(3, id);

			ps.execute();
			ps.close();
		} catch (Exception ex) {
			System.err.println(ex);
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}
		}
	}

	public static void main(String[] args) {
		Register r = new Register();
		r.createUser();
	}
}
