package COM.MPHASIS.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Delete 
{
    public static void main( String[] args ) throws Exception
    {
    	Class.forName ("com.mysql.cj.jdbc.Driver");
    	System.out.println("Driver is loaded");
    	Connection con= DriverManager.getConnection ("jdbc:mysql://localhost/test","root","");
    	/*System.out.println("Connection is created");
    	Scanner scan =new Scanner(System.in);
       	System.out.println("enter the post title");
       	String title=scan.nextLine();
       	
       	System.out.println("enter the body of post");
       	String body=scan.nextLine();*/
    String sql ="delete from post where id=?";
    	PreparedStatement pst=con.prepareStatement(sql);
    	Scanner scan =new Scanner(System.in);
    	System.out.println("enter the id whose row as to be deleted ");
    	int id=scan.nextInt();
    	pst.setInt(1, id);
    	int i=pst.executeUpdate();
    	System.out.println("rows affected ="+i);
   	//Statement st = con.createStatement();
    }
}
