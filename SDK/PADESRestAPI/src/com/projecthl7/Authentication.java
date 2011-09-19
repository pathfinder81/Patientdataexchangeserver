package com.projecthl7;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.FormParam;




@Path("/authentication")
public class Authentication {
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	
	public String verification(@FormParam("username") String username,@FormParam("password") String password)
	{
        
		Authen auth = new Authen();
		String user1 = username;//"HospitalA";
   	    String pass1 = password;
		boolean check = false;
		try {
			check = auth.checklogin(user1, pass1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(check == true)
		{
			return "true";
		}
		else
		{
			return "false";
		}
	//	String authentication = null;
    //    Databaseconnection conn = new Databaseconnection();
     //   Mdfiveconverter md = new Mdfiveconverter();
        
   	 //   String hashword = md.converter(pass1);
   	  //  ResultSet result = null;
/*		try
     {
	 	
		
     
     
 	  conn.databaseconnect();
 	 result = conn.statement.executeQuery("select username,password from ProviderStaff where username = '"+user1+"' and password = '"+hashword+"'");
 	
     }
     catch(Exception e)
     {
    	 System.out.println(e);
     }
	  
     if(result.next())
	  {
	     authentication = "true"; 
		 conn.connection.close(); 
		  // System.out.println("login successfull");
	      
	      return authentication;
	  }
	  else
	  {
	      authentication = "false";
	      conn.connection.close();
	      // System.out.println("login unsuccessfull");
		  return authentication;
	  } */
    
	
	
   
		
		
		
		
	} 
	

}
