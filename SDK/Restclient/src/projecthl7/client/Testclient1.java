package projecthl7.client;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.*;
import com.sun.jersey.api.representation.Form;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

public class Testclient1 {
	
	public static void main(String[] args) throws IOException
	{
		String check;
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the Username  ");
		String user = br.readLine();
		System.out.println("Enter the Password  ");
		String pwd = br.readLine();
		String url = "http://localhost:8080/PaDESRestAPI/authentication";
		Form f = new Form();
		f.add("username",user);
		f.add("password",pwd);
		   
			
	   Client c = Client.create();
	    WebResource r = c.resource(url);
	  ClientResponse response =  r.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).accept(MediaType.TEXT_PLAIN).post(ClientResponse.class,f);
       check = response.getEntity(String.class).trim(); 
	   if(check.equals("true"))
	   {
		   System.out.println("login successfull ");
			System.out.println(" 1) Request Patient Data");
			System.out.println(" 2) Send Patient Data");
			System.out.println(" 3) Exit");
			boolean quit = false;
			do
			{
				
			  System.out.println("Enter the choice ");
			  String option = br.readLine();
			  int choice = Integer.parseInt(option.trim());
			  switch(choice)
			  {
			  case 1:
				    System.out.println("Enter the Partner Name");
				    String partner = br.readLine();
				    System.out.println("Patient Details");
				    System.out.println("Enter the FirstName");
				    String firstname = br.readLine();
				    System.out.println("Enter the LastName");
				    String lastname = br.readLine();
				    System.out.println("Enter the Age");
				    String age = br.readLine();
				    System.out.println("Enter the Sex");
				    String sex = br.readLine();
				    
				    System.out.println("Enter the address");
				    String address = br.readLine();
				    String url1 = "http://localhost:8080/PaDESRestAPI/requestpatientdata";
					   Form f1 = new Form();
					   f1.add("firstname",firstname);
					   f1.add("lastname",lastname);
					   f1.add("age",age);
					   f1.add("sex",sex);
					   f1.add("address",address);
					   f1.add("partner",partner);
					   f1.add("user",user);
						
						
						Client c1 = Client.create();
					    WebResource r1 = c1.resource(url1);
					    ClientResponse clientresponse1 =  r1.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).accept(MediaType.TEXT_PLAIN).post(ClientResponse.class,f1);
					    String check1 = clientresponse1.getEntity(String.class);
					    System.out.println(check1);
				    break;
			  case 2:
				 //  File fil = new File("/opt/2.txt");
				  System.out.println("Enter the partner name");
				    String partner_ = br.readLine();
				   // System.out.println("");
				    final JFileChooser choose = new JFileChooser();
					  choose.showOpenDialog(null);
					File selFile = choose.getSelectedFile();   
				  
					    
					    //String partner = "HospitalB";
				  
				    String url2 = "http://localhost:8080/PaDESRestAPI/sendpatientdata";
					Client c2 = Client.create();
					WebResource r2 = c2.resource(url2);
					FormDataMultiPart fdm = new FormDataMultiPart();
					fdm.bodyPart(new FileDataBodyPart("f",selFile,MediaType.APPLICATION_OCTET_STREAM_TYPE));
					//fdm.bodyPart(new FileDataBodyPart("partner",partner,MediaType.TEXT_PLAIN));
					fdm.field("partner",partner_);
					fdm.field("user",user);
					
					//String partner = "catchapurba@gmail.com";
					//fdm.bodyPart(new FileDataBodyPart("f",f,MediaType.APPLICATION_OCTET_STREAM_TYPE));
					//fdm.bodyPart(new FileDataBodyPart("partner",partner,MediaType.TEXT_PLAIN));
					//fdm.field("f",f);
					
					ClientResponse response2 =  r2.type(MediaType.MULTIPART_FORM_DATA_TYPE).accept(MediaType.TEXT_PLAIN).post(ClientResponse.class,fdm);
				    String check2 = response2.getEntity(String.class);
					
					System.out.println(check2); 
				    
				   
				    break;
			  case 3: 
				  quit = true;
				  break;
			  default:
				   System.out.println("please select the correct choice");
				  
			  }
			   
			  
			}while(!quit);
			
		    	
			
		}
		else
		{
			System.out.println("unsuccessfull ");
		}
	   }
		
		
		
		
		
		   
		
		
		
		
		/*   String ret = null;  
			 String url = "http://localhost:8081/projecthl71/authentication";
			   Form f = new Form();
			   f.add("username","HospitalA");
			   f.add("password","HospitalA");
			   
				
				Client c = Client.create();
			    WebResource r = c.resource(url);
			    r.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).accept(MediaType.TEXT_PLAIN).post(f); */
	   

}
