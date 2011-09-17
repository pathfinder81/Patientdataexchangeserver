package projecthl7.client;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.*;
import com.sun.jersey.api.representation.Form;

public class Testclient1 {
	
	public static void main(String[] args)
	{
		  
		   String url = "http://localhost:8082/PaDESRestAPI/requestpatientdata";
		   Form f = new Form();
		   f.add("firstname","Apurba");
		   f.add("lastname","Dhungana");
		   f.add("age","24");
		   f.add("sex","male");
		   f.add("address","Ruston,USA");
		   f.add("partner", "HospitalA");
		   f.add("user", "HospitalB");
			
			
			Client c = Client.create();
		    WebResource r = c.resource(url);
		    ClientResponse clientresponse =  r.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).accept(MediaType.TEXT_PLAIN).post(ClientResponse.class,f);
		    String check = clientresponse.getEntity(String.class);
		    System.out.println(check);
		/*   String ret = null;  
			 String url = "http://localhost:8081/projecthl71/authentication";
			   Form f = new Form();
			   f.add("username","HospitalA");
			   f.add("password","HospitalA");
			   
				
				Client c = Client.create();
			    WebResource r = c.resource(url);
			    r.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).accept(MediaType.TEXT_PLAIN).post(f); */
	   }

}
