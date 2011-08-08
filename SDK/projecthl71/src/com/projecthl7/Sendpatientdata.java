package com.projecthl7;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/sendpatientdata")

public class Sendpatientdata {
	
	
  
  
	
	@POST
	@Consumes("multipart/form-data")
	
	public void sendpatientdata(@FormDataParam("f") InputStream f,@FormDataParam("f") FormDataContentDisposition fileInfo,@FormDataParam("partner") String partner) throws IOException
	{
		  
		
		
		
		
		
		String uploadedFileLocation = "/opt/upload/"+fileInfo.getFileName();
		String filename = fileInfo.getFileName();
		
		
		
		OutputStream out = new FileOutputStream(new File(
				uploadedFileLocation));
		int read = 0;
		byte[] bytes = new byte[1024];

		out = new FileOutputStream(new File(uploadedFileLocation));
		
		while ((read = f.read(bytes)) != -1) {
			out.write(bytes, 0, read);

		
		}
		out.flush();
		out.close();
		
		Emailfinder finder = new Emailfinder();   
		String emailaddress = finder.emailfinderpartner(partner);
		//String emailaddress = "catchapurba@gmail.com";
		String SMTP_HOST_NAME = "smtp.gmail.com";
        int SMTP_HOST_PORT = 465;
        String msg = "Please click here to download a patient file";
        String msg1 = "<a href=\"http://localhost:8082/projecthl7/uploads/";
        String msg2 = "\"> here</a>";
        String text = msg+msg1+filename+msg2;
        String subject = "patient data file";
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
      Transport transport = mailSession.getTransport();

      MimeMessage message = new MimeMessage(mailSession);
      message.setSubject(subject);
      message.setContent(text, "text/html");
      message.setContentMD5(text);
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
   	
		
		
		
		
		
		
		
		
	}

}

//@Path("/requestpatientdata")
//public class Uploadpatientdata {
/*	@POST
	@Consumes("multipart/form-data")
	
	public void reqpatientdata(@FormParam("file") InputStream file) throws Exception
	{
		File f1 = new File("/opt/jersey.txt");
		OutputStream out = new FileOutputStream(f1);
		byte buf[] = new byte[1024];
		int len;
		while((len=file.read(buf))>0)
			out.write(buf,0,len);
	     //   out.close;
		
	        
	     file.close();
	}

} */