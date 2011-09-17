package projecthl7.client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

public class Testclient2 {
	public static void main(String[] args)
	{
		 
		 String url = "http://localhost:8082/PaDESRestAPI/authentication";
		   Form f = new Form();
		   f.add("username","HospitalC");
		   f.add("password","HospitalC");
		   
			
			Client c = Client.create();
		    WebResource r = c.resource(url);
		ClientResponse response =  r.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).accept(MediaType.TEXT_PLAIN).post(ClientResponse.class,f);
	    String check = response.getEntity(String.class);
		
		System.out.println(check);
	
	}

}
