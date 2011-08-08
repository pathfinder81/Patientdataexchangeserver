package projecthl7.com.dataexchange.client;



import java.rmi.RemoteException;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import org.apache.axis2.Constants;

import projecthl7.com.dataexchange.client.DataexchangeStub;
import projecthl7.com.dataexchange.client.DataexchangeStub.AuthenticatonRequest;
import projecthl7.com.dataexchange.client.DataexchangeStub.AuthenticatonResponse;
import projecthl7.com.dataexchange.client.DataexchangeStub.RequestpatientdataRequest;
import projecthl7.com.dataexchange.client.DataexchangeStub.RequestpatientdataResponse;
import projecthl7.com.dataexchange.client.DataexchangeStub.SendpatientdataRequest;
import projecthl7.com.dataexchange.client.DataexchangeStub.SendpatientdataResponse;
public class Dataexchangeclient {
	public static void main(String[] args) throws RemoteException
	{
		 DataexchangeStub service = new DataexchangeStub();
    	 AuthenticatonRequest request = new AuthenticatonRequest();
    	 request.setUsername("HospitalA");
    	 request.setPassword("HospitalA");
    	 AuthenticatonResponse response = service.authenticaton(request);
 		System.out.println(response.getAuthenticatonResponse());
 		RequestpatientdataRequest request1 = new RequestpatientdataRequest();
 		request1.setFirstname("apurba");
 		request1.setLastname("dhungana");
 		request1.setAddress("Ruston");
 		request1.setAge("45");
 		request1.setPartner("HospitalA");
 		request1.setSex("male");
 		request1.setPhoneno("123123");
 		request1.setDateadmitted("12/12/002");
 		request1.setDatereleased("12/12/12");
 		RequestpatientdataResponse response1 = service.requestpatientdata(request1);
 		System.out.println(response1.getRequestpatientdataResponse());
 		  service._getServiceClient().getOptions().setProperty(Constants.Configuration.ENABLE_MTOM,"true");
 		  DataSource source = new FileDataSource("/home/apurba/Desktop/1.pdf");
 	      DataHandler handler = new DataHandler(source);
 	      SendpatientdataRequest request3 = new SendpatientdataRequest();
 	      String filename = "1";
 	      request3.setFile(handler);
 	      request3.setPartner("HospitalA");
 	      request3.setFilename(filename);
 	      SendpatientdataResponse response3 = service.sendpatientdata(request3);
 	      System.out.println(response3.getSendpatientdataResponse());
 		
	}
	

}