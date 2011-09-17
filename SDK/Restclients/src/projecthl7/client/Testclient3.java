package projecthl7.client;

import java.io.File;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

public class Testclient3 {
	 public static void main(String[] args)
	 {
		
		    File f = new File("/opt/2.txt");
		   String partner = "HospitalB";
		   String user = "HospitalA";
		    String url = "http://localhost:8082/PaDESRestAPI/sendpatientdata";
			Client c = Client.create();
			WebResource r = c.resource(url);
			FormDataMultiPart fdm = new FormDataMultiPart();
			fdm.bodyPart(new FileDataBodyPart("f",f,MediaType.APPLICATION_OCTET_STREAM_TYPE));
			//fdm.bodyPart(new FileDataBodyPart("partner",partner,MediaType.TEXT_PLAIN));
			fdm.field("partner",partner);
			fdm.field("user",user);
			
			//String partner = "catchapurba@gmail.com";
			//fdm.bodyPart(new FileDataBodyPart("f",f,MediaType.APPLICATION_OCTET_STREAM_TYPE));
			//fdm.bodyPart(new FileDataBodyPart("partner",partner,MediaType.TEXT_PLAIN));
			//fdm.field("f",f);
			
			ClientResponse response =  r.type(MediaType.MULTIPART_FORM_DATA_TYPE).accept(MediaType.TEXT_PLAIN).post(ClientResponse.class,fdm);
		    String check = response.getEntity(String.class);
			
			System.out.println(check);
			
			
			
			//r.type(MediaType.MULTIPART_FORM_DATA_TYPE).post(fdm);
	 }


}
