package COM.MPHASIS.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) throws Exception 
	{
		Class.forName ("com.mysql.cj.jdbc.Driver");
    	System.out.println("Driver is loaded");
    	Connection con= DriverManager.getConnection ("jdbc:mysql://localhost/test","root","");
    	String sql ="update post set  title=? where title=?";
    	PreparedStatement pst=con.prepareStatement(sql);
    	Scanner scan =new Scanner(System.in);
    	System.out.println("enter the new title ");
    	String new_title=scan.nextLine();
    	System.out.println("enter the old title");
    	String old_title=scan.nextLine();
    	pst.setString(1, new_title);
    	pst.setString(2, old_title);
    	
    	int i=pst.executeUpdate();
    	System.out.println("rows affected ="+i);


	}

}
