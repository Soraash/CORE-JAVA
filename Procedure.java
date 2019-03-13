package com.jdbc.jdbcprograms.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLType;
import java.sql.Types;

public class Procedure {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");

		CallableStatement cst1 = con.prepareCall("call updateTitle(?,?)");
		cst1.setInt(1, 1);
		cst1.setString(2, "new post title");
		cst1.registerOutParameter(2, Types.VARCHAR);

		int res1 = cst1.executeUpdate();
		String title = cst1.getString(2);
	System.out.println(title);

		CallableStatement cst2 = con.prepareCall("call insertTitle(?,?)");
		
		cst2.setString(1, "profile picture");
		 cst2.registerOutParameter(1, Types.VARCHAR);

		cst2.setString(2, "body of the post");
		 cst2.registerOutParameter(2, Types.VARCHAR);

		boolean res2 = cst2.execute();
		System.out.println("insertion done" + res2);
		String title1 = cst2.getString(1);
		System.out.println(title1);

		String title2 = cst2.getString(2);
		System.out.println(title2);

		CallableStatement cst3 = con.prepareCall("call deleteBodynTitle(?)");
		cst3.setInt(1, 1);

		int res3 = cst3.executeUpdate();
		System.out.println("deleted the post");

	}
}
