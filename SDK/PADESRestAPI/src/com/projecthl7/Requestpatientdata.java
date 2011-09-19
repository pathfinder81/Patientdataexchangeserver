package com.projecthl7;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/requestpatientdata")

public class Requestpatientdata
{
	
	@Produces(MediaType.TEXT_PLAIN)
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String requestpatientdata(@FormParam("firstname") String firstname,@FormParam("lastname") String lastname,
	@FormParam("phoneno") String phoneno,@FormParam("sex") String sex,@FormParam("age") String age,
	@FormParam("address") String address, @FormParam("partner") String partner, @FormParam("user") String user) throws Exception
	
	{
		
		
		Emailfinder finder = new Emailfinder();
		Partnercheck listpartners = new Partnercheck();
		String[] partners = listpartners.partener(user);
		List<String> StringtoList = Arrays.asList(partners);
		if(StringtoList.contains(partner))
		{
		 String emailaddress = finder.emailfinderpartner(partner);
		
		
	
        //System.out.println(firstname);		
		String SMTP_HOST_NAME="smtp.gmail.com";
		int SMTP_HOST_PORT = 465;
		String subject = "Request of Patient data of " + firstname +lastname;
		String to = emailaddress;
		Properties props = new Properties();
		String SMTP_AUTH_USER="exchangeserverhl7@gmail.com";
		String SMTP_AUTH_PWD="exchangeserver";
		props.put("mail.transport.protocol","smtps");
		props.put("mail.smtps.host",SMTP_HOST_NAME);
		props.put("mail.smtps.auth", "true");
		
		try
		{
			Session mailSession = Session.getDefaultInstance(props);
			mailSession.setDebug(true);
			Transport transport = null;
			transport = mailSession.getTransport();
			MimeMessage message = new MimeMessage(mailSession);
			message.setSubject(subject);
			message.setContent("Firstname : " +firstname+"\n"
			+"Lastname :" +lastname+"\n"
			+"Sex :" +sex+"\n"
			+"Age :" +age+"\n"
			+"Address :" +address+"\n"
			+"Phoneno :" +phoneno+"\n","text/plain");
			
		/*	Multipart multipart = new MimeMultipart();
			BodyPart part1 = new MimeBodyPart();
			part1.setText("Firstname" + " " +firstname);
			multipart.addBodyPart(part1); */
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			transport.connect(SMTP_HOST_NAME,SMTP_HOST_PORT,SMTP_AUTH_USER,SMTP_AUTH_PWD);
			transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
			transport.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "request send";
		}
		else
		{
			return " error encounter while requesting a patient data";
		}
		
		
	}
	
}
