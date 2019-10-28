package com.amar.dreamer.jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbcConnection
{

	public static void main(String str[])
	{

		String jdbcUrl = "jdbc:mysql://localhost:3306/learning_hibernate";
		String user = "root";
		String password = "data@123";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection Successfull");

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
