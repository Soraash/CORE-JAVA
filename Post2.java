package com.jdbc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Post2 
{
	public static void main(String[] args) throws Exception 
	{
	Class.forName ("com.mysql.cj.jdbc.Driver");
	System.out.println("Driver is loaded");
	Connection con= DriverManager.getConnection ("jdbc:mysql://localhost/test","root","");
	System.out.println("Connection is created");
}
}

