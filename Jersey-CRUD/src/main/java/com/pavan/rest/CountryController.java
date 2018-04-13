package com.pavan.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.pavan.bean.Country;
import com.pavan.services.CountryService;


@Path("/countries")
public class CountryController {
	
	CountryService countryService=new CountryService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCountries() {

		List listOfCountries = countryService.getAllCountries();
		return Response.status(Status.OK).entity(listOfCountries).build();
		//return listOfCountries;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCountryById(@PathParam("id") int id) {
		
		return Response.status(Status.OK).entity(countryService.getCountry(id)).build();
		//return countryService.getCountry(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Country addCountry(Country country) {
		//return Response.status(Status.OK).entity(countryService.addCountry(country)).build();
		return countryService.addCountry(country);
	}
	
	/*@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCountry1(Country country) {
		//countryService.addCountry(country);
		return Response.status(Status.OK).entity(countryService.addCountry(country)).build();
	}*/
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCountry(Country country) {
		//return countryService.updateCountry(country);
		return Response.status(Status.OK).entity(countryService.updateCountry(country)).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCountry(@PathParam("id") int id) {
		countryService.deleteCountry(id);
		//return Response.status(Status.).entity().build();
	}
}

/*
http://localhost:8099/rest/countries/
[
	{"id":1,"countryName":"India","population":10000},
	{"id":2,"countryName":"Bhutan","population":7000},
	{"id":3,"countryName":"Nepal","population":8000},
	{"id":4,"countryName":"China","population":20000}
]

http://localhost:8099/rest/countries/1
{"id":1,"countryName":"India","population":10000}

http://localhost:8099/rest/countries/

input: {"id":5,"countryName":"India","population":10000}
output: {"id": 5, "countryName": "India","population": 10000}

*/
