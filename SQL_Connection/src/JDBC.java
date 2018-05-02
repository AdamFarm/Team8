package software_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC {

	
	public static void main(String a[])
    {
        //Creating the connection
        String url = "jdbc:oracle:thin:@team8oracle.c7mfymi8txgn.us-east-2.rds.amazonaws.com:1521:ORCL";
        String user = "Team8";
        String pass = "team8iscool";
 
        /**
        Scanner k = new Scanner(System.in);
        System.out.println("enter name");
        **/ 
        
        // String name = k.next();
        // System.out.println("enter roll no");
        String roll = "123";
        String name = "something";
        //System.out.println("enter class");
        //String cls =  k.next();
 
        //Inserting data using SQL query
        String sql = "INSERT INTO MD_APPLICATIONS (ID, NAME, PROJECT_ID_FK) VALUES ('213', 'etst', '123')";
        Connection con=null;
        try
        {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
 
            //Reference to connection interface
            con = DriverManager.getConnection(url,user,pass);
 
            Statement st = con.createStatement();
            int m = st.executeUpdate(sql);
            if (m == 1)
                System.out.println("inserted successfully : "+sql);
            else
                System.out.println("insertion failed");
            con.close();
        }
        catch(Exception ex)
        {
            System.err.println(ex);
        }
    }
}
