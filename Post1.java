package com.jdbc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Post1 {

	public static void main(String[] args) throws Exception 
	{
		Class.forName ("com.mysql.cj.jdbc.Driver");
    	System.out.println("Driver is loaded");
    	Connection con= DriverManager.getConnection ("jdbc:mysql://localhost/test","root","");
    	System.out.println("Connection is created");
    	Scanner scan =new Scanner(System.in);
       	System.out.println("enter the post title");
       	String title=scan.nextLine();
       	
       	System.out.println("enter the body of post");
       	String body=scan.nextLine();
    String sql ="insert into post(title,body) values(?,?)";
    	PreparedStatement pst=con.prepareStatement(sql);
    	pst.setString(1, title);
    	pst.setString(2, body);
    	int i=pst.executeUpdate();
    	System.out.println("rows affected ="+i);
   	//Statement st = con.createStatement();
   	
   	}

}
