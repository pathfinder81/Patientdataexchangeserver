package com.projecthl7;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/authentication")
public class Authentication {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String check()
	{
		return "jaxrs";
	}
	

}
