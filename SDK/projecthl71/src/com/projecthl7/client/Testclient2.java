package com.projecthl7.client;
import java.io.File;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.*;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

public class Testclient2 {
	 public static void main(String[] args)
	 {
		
		    File f = new File("/opt/2.txt");
		    String partner = "HospitalA";
		    String url = "http://localhost:8081/projecthl71/sendpatientdata";
			Client c = Client.create();
			WebResource r = c.resource(url);
			FormDataMultiPart fdm = new FormDataMultiPart();
			fdm.bodyPart(new FileDataBodyPart("f",f,MediaType.APPLICATION_OCTET_STREAM_TYPE));
			//fdm.bodyPart(new FileDataBodyPart("partner",partner,MediaType.TEXT_PLAIN));
			fdm.field("partner", partner);
			
			
			//String partner = "catchapurba@gmail.com";
			//fdm.bodyPart(new FileDataBodyPart("f",f,MediaType.APPLICATION_OCTET_STREAM_TYPE));
			//fdm.bodyPart(new FileDataBodyPart("partner",partner,MediaType.TEXT_PLAIN));
			//fdm.field("f",f);
			
			
			
			
			
			r.type(MediaType.MULTIPART_FORM_DATA_TYPE).post(fdm);
	 }


	/* FormDataMultiPart formData;
	         formData = new FormDataMultiPart();
	         formData.field("schema", "THESCHEMA", MediaType.TEXT_PLAIN_TYPE);
	         formData.field("table", "THETABLE", MediaType.TEXT_PLAIN_TYPE);
	         formData.field("authUser", "THEUSER", MediaType.TEXT_PLAIN_TYPE);
	         final String result =
	  resource.type("multipart/form-data").post(String.class, formData);
	         formData.close();
	         return result; */
	 


















}
