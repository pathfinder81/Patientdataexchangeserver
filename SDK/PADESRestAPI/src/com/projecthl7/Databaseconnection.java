package com.projecthl7;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
public class Databaseconnection {
	Statement statement = null;
	Connection connection = null;
	public void databaseconnect() throws Exception
	{
		
		try
		{
		
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/projecthl7","root","latech");
		 statement = connection.createStatement();
	 
		}
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	
	}
	
	
	
}
