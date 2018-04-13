package com.pavan.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

//http://localhost:8099/rest/hello/hi   --> Jersey say : hi

@Path("/hello")
public class HelloWorldService {
	
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
		String output = "Jersey say : " + msg;
		//return Response.status(200).entity(output).build();
		//return Response.status(Status.ACCEPTED).entity(output).build(); //Status code 202 accepted
		System.out.println("Ok : "+Status.OK);
		System.out.println("accepted"+Status.ACCEPTED);
		System.out.println("Bad Request : "+Status.BAD_REQUEST);
		System.out.println("CONFLICT : "+Status.CONFLICT);
		System.out.println("GONE : "+Status.GONE);
		System.out.println("NO_CONTENT : "+Status.NO_CONTENT);
		
		return Response.status(Status.OK).entity(output).build(); 
	}
}


/*
Error if we comment line 7

com.sun.jersey.api.container.ContainerException: The ResourceConfig instance does not contain any root resource classes.

Solution:

com.sun.jersey.config.property.packages doesn’t exist in your web.xml.
com.sun.jersey.config.property.packages included a package path, but that is not included any jersey services.
*
*/
