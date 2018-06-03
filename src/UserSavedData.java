package CSC394;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//import java.util.UUID;

public class UserSavedData {

	String db_url = "jdbc:oracle:thin:@team8oracle.c7mfymi8txgn.us-east-2.rds.amazonaws.com:1521:ORCL";
	String db_user = "Team8";
	String db_pass = "team8iscool";

	Connection conn = null;
	Statement stmt = null;

	public void UserSavedData() {
		
		// Random ID generator
//		UUID uuid = UUID.randomUUID();
//		String id = uuid.toString();
		
		// User input for Degree
		Scanner Degree_input = new Scanner(System.in);
		System.out.println("Enter Degree_Program (CS or IS Only): ");
		String Degree = Degree_input.next();

		// User input for Concentration 
		Scanner Concentration_input = new Scanner(System.in);
		if (Degree.contentEquals("CS")) {
		System.out.println("Enter Concentration :\r\n" +
				"Software and Systems Development\r\n" + 
				"Theory\r\n" + 
				"Data Science\r\n" + 
				"Database Systems\r\n" + 
				"Artificial Intelligence\r\n" + 
				"Software Engineering\r\n" + 
				"Game and Real-Time Systems\r\n" + 
				"Human-Computer Interaction: ");
		}
		else {
			System.out.println("Enter Concentration :\r\n" + 
				"Business Analysis/System Analysis\r\n" +
				"Business Intelligence\r\n" + 
				"Database Administration\r\n" +
				"IT Enterprise\r\n" +
				"Standard\r\n");
		}
		String Concentration = Concentration_input.next();
		// User input for Starting Quarter 
		Scanner StartingQuarter_input = new Scanner(System.in);
		System.out.println("Enter Starting Quarter (Ex. Fall, Winter Spring): ");
		String StartingQuarter = StartingQuarter_input.next();
		
		// User input for Credit hours per Quarter
		Scanner CreditHours_input = new Scanner(System.in);
		System.out.println("Enter Credit Hrs Per Quarter : ");
		String CreditHours = CreditHours_input.next();
		
		// User input for preferred Location ***ALWAYS BOTH***
		Scanner Location_input = new Scanner(System.in);
		System.out.println("Enter Perfered Location (Always Enter Both): ");
		String Location = Location_input.next();
		
		// User input to see if they have a background in CS or IS if not put "N"
		Scanner PreviousDegree_input = new Scanner(System.in);
		System.out.println("*ONLY ENTER Y or N* if you have a BS in CS or IS: ");
		String PreviousDegree = PreviousDegree_input.next();
		
		System.out.println("Establishing Connection to Database...");
		
//		if (perm.toUpperCase().equals("STUDENT") || perm.toUpperCase().equals("TEACHER") 
//				|| perm.toUpperCase().equals("ADMIN")) {
			 try {
				DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
				conn = DriverManager.getConnection(db_url, db_user, db_pass);
				System.out.println("");
				System.out.println("Connected database successfully...");

				System.out.println("Inserting records into the table...");
				stmt = conn.createStatement();
				System.out.println(Concentration);
				String sql = String.format("INSERT INTO USERS_SAVED_DATA VALUES (?,?,?,?,?,?)");
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, Degree);
				ps.setNString(2, Concentration);
				ps.setString(3, StartingQuarter);
				ps.setString(4, CreditHours);
				ps.setString(5, Location);
				ps.setString(6, PreviousDegree);

				ps.execute();
				ps.close();
			 
			} catch (Exception ex) {
				System.err.println(ex);
			}
			finally {
				try {
					if (stmt != null)
						conn.close();
				} catch (SQLException se) {
				
			
		 		

			System.out.println("Permissions must be either Student, Teacher, or Admin");
			 }
		 
		Degree_input.close();
		Concentration_input.close();
		StartingQuarter_input.close();
		CreditHours_input.close();
		Location_input.close();
		PreviousDegree_input.close();
		}
	}
	
	
	
	
	

	public static void main(String[] args) {
		UserSavedData r = new UserSavedData();
		r.UserSavedData();
	}
}
