package com.jdbc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class post 
{
    public static void main( String[] args ) throws Exception
    {
    	Class.forName ("com.mysql.cj.jdbc.Driver");
    	System.out.println("Driver is loaded");
    	Connection con= DriverManager.getConnection ("jdbc:mysql://localhost/test","root","");
    	System.out.println("Connection is created");
    	String q ="select * from post";
   	Statement st = con.createStatement();
    	//String q = "insert into post(title,body) values('Orochimaru',' former ninja of the village of Konohagakure ')";
    	ResultSet rs = st.executeQuery(q);
    	//System.out.println("Rows affected : "+i);
    	System.out.println("id\tTitle\t\t\tBody");
    	while(rs.next())
    	{
    		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3));
    	}
    }
}
