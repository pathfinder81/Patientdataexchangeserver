import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Authenticate {
	public boolean authentication(String user, String password) throws Exception
	{
	 Class.forName("com.mysql.jdbc.Driver");
     //System.out.println("Driver loaded");
     //String partner = null;
    // Establish a connection
      Connection connection = DriverManager.getConnection
      ("jdbc:mysql://localhost/projecthl7","root","1234");
    //System.out.println("Database connected");

    // Create a statement
    Statement statement = connection.createStatement();
    String user1 = user;//"HospitalA";
 	  String pass1 = password;
 	  String hashword = null;
 	  
    MessageDigest md5 = MessageDigest.getInstance("MD5");
    md5.update(pass1.getBytes());
    BigInteger hash = new BigInteger(1, md5.digest());
    hashword = hash.toString(16);
           
 	  
 	  //"ff4f570486b00aad70e82616ce987552"; 
 	 // Statement select = connection().createStatement();
 	  ResultSet result = statement.executeQuery("select username,password from ProviderStaff where username = '"+user1+"' and password = '"+hashword+"'");
 	  if(result.next())
 	  {
 	      connection.close(); 
 		   System.out.println("login successfull");
 	      
 	      return true;
 	  }
 	  else
 	  {
 	      connection.close();
 	      System.out.println("login unsuccessfull");
 		  return false;
 	  }
	
	
	}
	
	public String[] partener(String users) throws Exception/*SQLException, ClassNotFoundException*/ {
	      // Load the JDBC driver
		 
		 String user = users;
		 int k = 0;
		 
	      Class.forName("com.mysql.jdbc.Driver");
	      //System.out.println("Driver loaded");
	      String partner = null;
	     // Establish a connection
	       Connection connection = DriverManager.getConnection
	       ("jdbc:mysql://localhost/projecthl7","root","1234");
	     //System.out.println("Database connected");
	
	     // Create a statement
	     Statement statement = connection.createStatement();
	
	     // Execute a statement
	     ResultSet resultSet = statement.executeQuery("select serviceID from Provider where name='"+user+"'");
	
	     // Iterate through the result and print the student names
	     while (resultSet.next())
	     
	    	 partner = resultSet.getString(1);
	        //System.out.println(partner); 	 
	     
	      
	    	/* System.out.println(resultSet.getString(1) + "\t" +
	         resultSet.getString(2) + "\t" + resultSet.getString(3)); */
	
	     // Close the connection
	     String[] results = partner.split(",");
	     int length = results.length;
	     String arr[] = new String[length];    
		     for(int i =0;i<length;i++)
		     {
		    	 
		    	 ResultSet resultSet1 = statement.executeQuery("select name from Provider where id='"+results[i]+"'");
			
		     // Iterate through the result 
		     while (resultSet1.next())
		     { 
		    	 //int k = 0;
		    	
		    	 arr[k] =  resultSet1.getString(1);
		    	 //System.out.println(resultSet1.getString(1));
		         
		     }
		     
		     k++;
	    
	        }
		     
		     
		     connection.close();


		     return arr;

	 }
	
	public String emailfinder(String name) throws Exception/*SQLException, ClassNotFoundException*/
	{
		Class.forName("com.mysql.jdbc.Driver");
		String name1 = null;
		String email = null;
		name1=name;
		Connection connection = DriverManager.getConnection
	       ("jdbc:mysql://localhost/projecthl7","root","1234");
		Statement statement = connection.createStatement();
		
	     // Execute a statement
	     ResultSet resultSet = statement.executeQuery("select contactEmail from ProviderStaff where username='"+name1+"'");
	     while (resultSet.next())
		   
	    	 email = resultSet.getString(1);
		connection.close();
		return email;
		
	}
	
	public void uplaod(byte[] upl,String fname,String recpt) throws Exception
	{
		byte[] bytes = upl;
		String filename = fname;
		String recepitent = recpt;
		Class.forName("com.mysql.jdbc.Driver");
		
		String email = null;
		
		Connection connection = DriverManager.getConnection
	       ("jdbc:mysql://localhost/projecthl7","root","1234");
		Statement statement = connection.createStatement();
		
	     // Execute a statement
	     ResultSet resultSet = statement.executeQuery("select contactEmail from ProviderStaff where username='"+recepitent+"'");
	     while (resultSet.next())
		   
	    	 email = resultSet.getString(1);
		connection.close();
		File check = new File("/opt/tomcat6/webapps/projecthl7/uploads/"+filename);
		FileOutputStream fos = new FileOutputStream(check);
        fos.write(bytes);
        fos.flush();
        fos.close();
        String SMTP_HOST_NAME = "smtp.gmail.com";
        int SMTP_HOST_PORT = 465;
        String msg = "Please click here to download a patient file";
        String msg1 = "<a href=\"http://localhost:8080/projecthl7/uploads/";
        String msg2 = "\"> here</a>";
        String text = msg+msg1+filename+msg2;
       // Stric;
       //* String pass;
        String check1 = "http://localhost:8080";
        //String text = "Please click here to download a patient file <a href=\"http://localhost:8080/New/check.txt\"> here</a>";
       
       String url = "<a href='"+check1+"'>";
        String subject = "patient data file";
        String to = email;
        
      Properties props = new Properties();
      String SMTP_AUTH_USER="exchangeserverhl7@gmail.com";
      String SMTP_AUTH_PWD="exchangeserver";
      props.put("mail.transport.protocol", "smtps");
      props.put("mail.smtps.host", SMTP_HOST_NAME);
      props.put("mail.smtps.auth", "true");
      // props.put("mail.smtps.quitwait", "false");

      Session mailSession = Session.getDefaultInstance(props);
      mailSession.setDebug(true);
      Transport transport = mailSession.getTransport();

      MimeMessage message = new MimeMessage(mailSession);
      message.setSubject(subject);
      message.setSentDate(new Date());
      message.setContent(text+url, "text/html");
      //message.setContent("<h1>text</h1>"+text, "text/plain");
      message.setContentMD5(text);
  	//message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
      message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
      transport.connect
        (SMTP_HOST_NAME, SMTP_HOST_PORT, SMTP_AUTH_USER, SMTP_AUTH_PWD);

      transport.sendMessage(message,
          message.getRecipients(Message.RecipientType.TO));
      transport.close();
        
	}
	
	
	
	
	
	public void sendemail(String receiptent,String firstname,String lastname,String age,String sex) throws Exception
    {
		String Firstname = firstname;
		String Lastname = lastname;
		String Sex = sex;
		String Age = age;
		
		Class.forName("com.mysql.jdbc.Driver");
	      //System.out.println("Driver loaded");
	      String emailaddress = null;
	      String user = receiptent;
	     // Establish a connection
	       Connection connection = DriverManager.getConnection
	       ("jdbc:mysql://localhost/projecthl7","root","1234");
	     //System.out.println("Database connected");
	      
	     // Create a statement
	     Statement statement = connection.createStatement();
	     ResultSet resultSet = statement.executeQuery("select contactEmail from ProviderStaff where username='"+user+"'");
	     if(resultSet.next())
	     {	 
	      
	    	 emailaddress = resultSet.getString(1); 
	    	 String SMTP_HOST_NAME = "smtp.gmail.com";
	         int SMTP_HOST_PORT = 465;
	        // String user;
	        //* String pass;
	        // String check = "http://localhost:8080";
	        // String text = " Hello welcome,click <a href=\"http://localhost:8080/New/ER-EHR.pdf\"> here</a> to enjoy ";
	        
	        // String url = "<a href='"+check+"'>";
	         String subject = "Request of Patient data of" + Firstname + Lastname;
	         String to = emailaddress;
	         
	       Properties props = new Properties();
	       String SMTP_AUTH_USER="exchangeserverhl7@gmail.com";
	       String SMTP_AUTH_PWD="exchangeserver";
	       props.put("mail.transport.protocol", "smtps");
	       props.put("mail.smtps.host", SMTP_HOST_NAME);
	       props.put("mail.smtps.auth", "true");
	       // props.put("mail.smtps.quitwait", "false");

	       Session mailSession = Session.getDefaultInstance(props);
	       mailSession.setDebug(true);
	       Transport transport = mailSession.getTransport();

	       MimeMessage message = new MimeMessage(mailSession);
	       message.setSubject(subject);
	       message.setSentDate(new Date());
	       Multipart multipart = new MimeMultipart();
	       BodyPart part1 = new MimeBodyPart();
	       part1.setText("Firstname" + " " + Firstname);
	       BodyPart part2 = new MimeBodyPart();
	       part2.setText("Lastname" + " " + Lastname);
	       BodyPart part3 = new MimeBodyPart();
	       part3.setText("Age" +" " + Age);
	       BodyPart part4 = new MimeBodyPart();
	       part4.setText("Sex" +" " + Sex);
	       multipart.addBodyPart(part1);
	       multipart.addBodyPart(part2);
	       multipart.addBodyPart(part3);
	       multipart.addBodyPart(part4);
	       
	       message.setContent(multipart);
	       //message.setContent("<h1>text</h1>"+text, "text/plain");
	       //message.setContentMD5(text);
	   	//message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
	       message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
	       transport.connect
	         (SMTP_HOST_NAME, SMTP_HOST_PORT, SMTP_AUTH_USER, SMTP_AUTH_PWD);

	       transport.sendMessage(message,
	           message.getRecipients(Message.RecipientType.TO));
	       transport.close();
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	connection.close(); 
	     } 
	     else
	     {
	    	 connection.close();
	     }
	

}
	
	
	
	
	
}
