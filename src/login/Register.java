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

	Connection conn = null;
	Statement stmt = null;

	public void createUser() {
		
		// Random ID generator
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		
		// User input for username and password
		Scanner user_input = new Scanner(System.in);
		System.out.println("Create a Username: ");
		String user = user_input.next();

		Scanner pass_input = new Scanner(System.in);
		System.out.println("Create a Password: ");
		String pass = pass_input.next();
		
		Scanner perm_input = new Scanner(System.in);
		System.out.println("Choose Permission Level: ");
		String perm = perm_input.next();
		
	/*	if (perm.toUpperCase() != "STUDENT" && perm.toUpperCase() != "TEACHER" 
				&& perm.toUpperCase() != "ADMIN") {
				System.out.println("Permissions must be either Student, Teacher, or Admin");
		} else {
	*/{		try {
				DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
				conn = DriverManager.getConnection(db_url, db_user, db_pass);
				System.out.println("Connected database successfully...");

				System.out.println("Inserting records into the table...");
				stmt = conn.createStatement();

				String sql = String.format("INSERT INTO USER_INFO VALUES (?,?,?,?)");
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, user);
				ps.setString(2, pass);
				ps.setString(3, id);
				ps.setString(4, perm);

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

		
		user_input.close();
		pass_input.close();
		perm_input.close();

		

		
		
	}

	public static void main(String[] args) {
		Register r = new Register();
		r.createUser();
	}
}
