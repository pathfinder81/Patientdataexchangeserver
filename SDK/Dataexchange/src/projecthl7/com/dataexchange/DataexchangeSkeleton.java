
/**
 * DataexchangeSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.3  Built on : Aug 10, 2007 (04:45:47 LKT)
 */
    package projecthl7.com.dataexchange;
   

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
    import java.security.MessageDigest;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.Statement;
    import java.util.Properties;

import javax.activation.DataHandler;
    import javax.mail.BodyPart;
    import javax.mail.Message;
    import javax.mail.Multipart;
    import javax.mail.Session;
    import javax.mail.Transport;
    import javax.mail.internet.InternetAddress;
    import javax.mail.internet.MimeBodyPart;
    import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
    
    
    
    /**
     *  DataexchangeSkeleton java skeleton for the axisService
     */
    public class DataexchangeSkeleton implements DataexchangeSkeletonInterface{
        
         
        /**
         * Auto generated method signature
         
         
                                     * @param authenticatonRequest0
         */
        

                 public projecthl7.com.dataexchange.AuthenticatonResponse authenticaton
                  (
                  projecthl7.com.dataexchange.AuthenticatonRequest authenticatonRequest0
                  )
            {
                	 
                	 
                	 
                	 String username = authenticatonRequest0.getUsername();
                     String password = authenticatonRequest0.getPassword();
                     String token = null;
                     try {
      				  Class.forName("com.mysql.jdbc.Driver");
      			
                      Connection connection = null;
      				  connection = DriverManager.getConnection
      				  ("jdbc:mysql://localhost/projecthl7","root","latech");
      				
                   
                     Statement statement = null;
      			
      				 statement = connection.createStatement();
      			
                     String user1 = username;//"HospitalA";
                 	 String pass1 = password;
                 	 String hashword = null;
                 	  
                     MessageDigest md5 = null;
      			
      				 md5 = MessageDigest.getInstance("MD5");
      			
                    md5.update(pass1.getBytes());
                    BigInteger hash = new BigInteger(1, md5.digest());
                    hashword = hash.toString(16);
                           
                 	  
                 	  //"ff4f570486b00aad70e82616ce987552"; 
                 	 // Statement select = connection().createStatement();
                 	  ResultSet result = null;
      		
      				result = statement.executeQuery("select username,password from ProviderStaff where username = '"+user1+"' and password = '"+hashword+"'");
      			
                 	  
      				if(result.next())
      				  {
      				      connection.close(); 
      					  // System.out.println("login successfull");
      				      
      				      token = "true";
      				  }
      				  else
      				  {
      				      connection.close();
      				      // System.out.println("login unsuccessfull");
      					  token = "false";
      				  }
                     }
                     catch(Exception e)
                     {
                    	e.printStackTrace();
                     }
      				// TODO Auto-generated catch block
      				
      				AuthenticatonResponse response = new AuthenticatonResponse();
      				response.setAuthenticatonResponse(token);
      				return response;
                	 
                	   	 
                	
               // throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#authenticaton");
        }
     
         
        /**
         * Auto generated method signature
         
         
                                     * @param requestpatientdataRequest2
         */
        

                 public projecthl7.com.dataexchange.RequestpatientdataResponse requestpatientdata
                  (
                  projecthl7.com.dataexchange.RequestpatientdataRequest requestpatientdataRequest2
                  )
            {
                	 String firstname = requestpatientdataRequest2.getFirstname();
                	 String lastname = requestpatientdataRequest2.getLastname();
                	 String age = requestpatientdataRequest2.getAge();
                	 String address = requestpatientdataRequest2.getAddress();
                	 String phoneno = requestpatientdataRequest2.getPhoneno();
                	 String sex = requestpatientdataRequest2.getSex();
                	 String partner = requestpatientdataRequest2.getPartner();
                	 String admitdate = requestpatientdataRequest2.getDateadmitted();
                	 String releasedate = requestpatientdataRequest2.getDatereleased();
                     
                     String emailaddress = null;
                     String token = null;
                    // Connection connection = null;
                     try {
     					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/projecthl7","root","latech");
     				
                    
     				
     					Statement statement = connection.createStatement();
     				    ResultSet resultset = statement.executeQuery("select contactEmail from ProviderStaff where username='"+partner+"'"); 	 
     				    if(resultset.next())
     				    {

     				    emailaddress = resultset.getString(1);
     				    
     				    connection.close();
     				    }
     				    else
     				    {
     				    connection.close();
     				    } 
     				}
     				catch(Exception e)
     				{
     					e.printStackTrace();
     				}
     				    
     				    
     				    
     				    String SMTP_HOST_NAME = "smtp.gmail.com";
     				    int SMTP_HOST_PORT = 465;
     				    String subject = "Request of Patient data of" + firstname ;
     				    String to = emailaddress;
     				    Properties props = new Properties();
     				    String SMTP_AUTH_USER="exchangeserverhl7@gmail.com";
     				    String SMTP_AUTH_PWD="exchangeserver";
     				    props.put("mail.transport.protocol", "smtps");
     				    props.put("mail.smtps.host", SMTP_HOST_NAME);
     				    props.put("mail.smtps.auth", "true");
     				    // props.put("mail.smtps.quitwait", "false");
                        
     				   
     				    
     				  try
     				  {
     				    
     				    
     				    Session mailSession = Session.getDefaultInstance(props);
     				    mailSession.setDebug(true);
     				    Transport transport = null;
     					transport = mailSession.getTransport();
     					MimeMessage message = new MimeMessage(mailSession);
     				    message.setSubject(subject);
     				    Multipart multipart = new MimeMultipart();
     				    BodyPart part1 = new MimeBodyPart();
     				    part1.setText("Firstname" + " " + firstname);
     					BodyPart part2 = new MimeBodyPart();
     				    part2.setText("Lastname" + " " + lastname);
     				    BodyPart part3 = new MimeBodyPart();
     				    part3.setText("Address" + " " + address);
     				    BodyPart part4 = new MimeBodyPart();
     				    part4.setText("Sex" + " " + sex);
     				    BodyPart part5 = new MimeBodyPart();
     				    part5.setText("Age" + " " + age);
     				    BodyPart part6 = new MimeBodyPart();
     				    part6.setText("Phoneno" + " " +phoneno);
     				    BodyPart part7 = new MimeBodyPart();
     				    part7.setText("Admitdate" + " " + admitdate);
     				    BodyPart part8 = new MimeBodyPart();
     				    part8.setText("Realesedate" + " " + releasedate);
     					
     				    multipart.addBodyPart(part1);
     				    multipart.addBodyPart(part2);
     				    multipart.addBodyPart(part3);
     				    multipart.addBodyPart(part4);
     				    multipart.addBodyPart(part5);
     				    multipart.addBodyPart(part6);
     				    multipart.addBodyPart(part7);
     				    multipart.addBodyPart(part8);
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
     				    token = "send";
     					
     				  }
     				  catch(Exception e)
     				  {
     					  e.printStackTrace();
     				  }


                        

     				  RequestpatientdataResponse response = new RequestpatientdataResponse();
         			  response.setRequestpatientdataResponse(token);
         			  return response; 
              
          // throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#requestpatientdata");
        }
     
         
        /**
         * Auto generated method signature
         
         
                                     * @param sendpatientdataRequest4
         */
        

                 public projecthl7.com.dataexchange.SendpatientdataResponse sendpatientdata
                  (
                  projecthl7.com.dataexchange.SendpatientdataRequest sendpatientdataRequest4
                  )
            {
                	 String email = null;

                	 String filename = sendpatientdataRequest4.getFilename();
                	 DataHandler image = sendpatientdataRequest4.getFile();
                	 String partner = sendpatientdataRequest4.getPartner();
                	 
                	 try
                	 {
                	 
                	 InputStream in = image.getInputStream();
                	 String outfile = "/opt/tomcat6/webapps/projecthl7/uploads";
                	 FileOutputStream out = new FileOutputStream(new File(outfile,filename));
                	 try
                	 {
                		 byte buf[] = new byte[1024];
                		 for(;;)
                		 {
                			 int noBytesRead = in.read(buf);
                			 out.write(buf,0,noBytesRead);
                			 if(noBytesRead < buf.length)
                			 {
                				 break;
                			 }
                		 }
                	 }
                	 finally {
                		 out.close();
                	 }
                	 
                	 
                	 
                	 }
                	 catch(IOException e)
                	 {
                		 throw new RuntimeException(e);
                	 }
                	
                	 try
                	 {
                	 Class.forName("com.mysql.jdbc.Driver");

                	 
                	 Connection connection = DriverManager.getConnection
                	 ("jdbc:mysql://localhost/projecthl7","root","latech");
                	 Statement statement = connection.createStatement();

                	 // Execute a statement
                	 ResultSet resultSet = statement.executeQuery("select contactEmail from ProviderStaff where username='"+partner+"'");
                	 while (resultSet.next())

                	 email = resultSet.getString(1);
                	 connection.close();
                	 }
                	 catch (Exception e)
                	 {
                		 e.printStackTrace();
                	 }
                	 
                	  String SMTP_HOST_NAME = "smtp.gmail.com";
                      int SMTP_HOST_PORT = 465;
                      String msg = "Please click here to download a patient file";
                      String msg1 = "<a href=\"http://localhost:8082/projecthl7/uploads/";
                      String msg2 = "\"> here</a>";
                      String text = msg+msg1+filename+msg2;
                     // Stric;
                     //* String pass;
                      String check1 = "http://localhost:8082";
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

                   try
                   {
                    
                    Session mailSession = Session.getDefaultInstance(props);
                    mailSession.setDebug(true);
                    Transport transport = mailSession.getTransport();

                    MimeMessage message = new MimeMessage(mailSession);
                    message.setSubject(subject);
                   // message.setSentDate(new Date());
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
                   catch(Exception e)
                   {
                	   e.printStackTrace();
                   }     	                 	 
                 	 String result = "done";
                	 SendpatientdataResponse response = new SendpatientdataResponse();
                	 response.setSendpatientdataResponse(result);
                	 return response;
                	 
                     	 //TODO : fill this with the necessary business logic
             //   throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#sendpatientdata");
        }
     
    }
    