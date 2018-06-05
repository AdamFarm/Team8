package course_search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Updates needed to this class:
 * 	(2) User chosen information needs to be connected back to the database
 *  (3) Searches need to be saved back into the database
 * 
 * @author Dana Deering
 *
 */

public class TreeClient {
	ResultSet rset;
	String query;
	String sqlString;
	Connection conn = null;
	Statement stmt;

	// Database Information
	String db_url = "jdbc:oracle:thin:@team8oracle.c7mfymi8txgn.us-east-2.rds.amazonaws.com:1521:ORCL";
	String db_user = "Team8";
	String db_pass = "team8iscool";
	
	// TEST CASES
	// REAL INPUT NEEDED FROM DATABASE/USER:
//	String masters_program = "Computer Science";
//	String concentration = "Software Engineering";
//	int max_credit_hours = 12;
//	String current_quarter = "Fall"; //starting quarter
	
	String masters_program = "Information Systems";
	String concentration = "Standard Concentration";
	int max_credit_hours = 8;
	String current_quarter = "Winter"; //starting quarter
	
	public void startSearch() throws SQLException{ 
		// Connect to the database
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		conn = DriverManager.getConnection(db_url, db_user, db_pass);
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

		// SQL Query from Oracle Database
		query = "SELECT * FROM COURSE_CATALOG"; 
		rset = stmt.executeQuery(query); 
		
		if (masters_program.equalsIgnoreCase("Computer Science")) {
			TreeSearchCS search = new TreeSearchCS(rset, concentration, max_credit_hours, current_quarter);
			search.getCourses(rset);
		}
		else if (masters_program.equalsIgnoreCase("Information Systems") && concentration.contains("Business Analysis")) {
			BusinessAnalysisConcentration is_ba = new BusinessAnalysisConcentration(rset, concentration, max_credit_hours, current_quarter);
			is_ba.getCourses(rset);
		}
		else if (masters_program.equalsIgnoreCase("Information Systems") && concentration.contains("Business Intelligence")) {
			BusinessIntelligenceConcentration is_bi = new BusinessIntelligenceConcentration(rset, concentration, max_credit_hours, current_quarter);
			is_bi.getCourses(rset);
		}
		else if (masters_program.equalsIgnoreCase("Information Systems") && concentration.contains("Database")) {
			DatabaseAdministrationConcentration is_da = new DatabaseAdministrationConcentration(rset, concentration, max_credit_hours, current_quarter);
			is_da.getCourses(rset);
		}
		else if (masters_program.equalsIgnoreCase("Information Systems") && concentration.contains("IT Enterprise")) {
			ITEnterpriseManagementConcentration is_it = new ITEnterpriseManagementConcentration(rset, concentration, max_credit_hours, current_quarter);
			is_it.getCourses(rset);
		}
		else if (masters_program.equalsIgnoreCase("Information Systems") && concentration.contains("Standard")) {
			StandardConcentration is_sc = new StandardConcentration(rset, concentration, max_credit_hours, current_quarter);
			is_sc.getCourses(rset);
		}
	}
	
	public static void main(String[] args) throws SQLException {
		TreeClient client = new TreeClient();
		client.startSearch();
	}

}
