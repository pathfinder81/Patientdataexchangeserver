package com.projecthl7;
import java.sql.ResultSet;
public class Emailfinder {
	public String emailfinderpartner(String partner)
	{
		String emailaddress = null;
		try
		{
		
		
		Databaseconnection conn = new Databaseconnection();
		conn.databaseconnect();
		//String email = null;
		ResultSet resultset = conn.statement.executeQuery("select contactEmail from ProviderStaff where username='"+partner+"'");
		if(resultset.next())
		{
			emailaddress = resultset.getString(1);
			conn.connection.close();
		}
		
		
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return emailaddress;
	
	}

}
