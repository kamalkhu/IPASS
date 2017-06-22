package nl.hu.v1ipass.fitnessapp.Resource;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import nl.hu.v1ipass.fitnessapp.Domain.Client;
import nl.hu.v1ipass.fitnessapp.Service.ClientService;
import nl.hu.v1ipass.fitnessapp.Service.ServiceProvider;

@Path("/clients")
public class ClientResource {
	ClientService clientService = new ClientService();

	// CRUD -- READ operation
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllClients() {
		ClientService service = ServiceProvider.getClientService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Client c : service.getAllClients()) {
			JsonObjectBuilder client = Json.createObjectBuilder();
			client.add("id", c.getId());
			client.add("firstname", c.getFirstName());
			client.add("lastname", c.getLastName());

			jab.add(client);
		}
		JsonArray array = jab.build();
		return array.toString();
	}

	// CRUD -- READ operation
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getClientById(@PathParam("id") int id) {
		ClientService service = ServiceProvider.getClientService();
		Client client = service.getClientById(id);
		
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("id", client.getId());
		job.add("firstname", client.getFirstName());
		job.add("lastname", client.getLastName());
		
		return job.build().toString();
	}

	// CRUD -- INSERT operation
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertClient(@QueryParam("Q1") String fn, @QueryParam("Q2") String ln) {
		ClientService service = ServiceProvider.getClientService();
		service.insertClient(fn, ln);
	}

	// CRUD -- UPDATE operation
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateClient(@QueryParam("Q1") int id, @QueryParam("Q2") String fn, @QueryParam("Q3") String ln) {
		ClientService service = ServiceProvider.getClientService();
		service.updateClient(id, fn, ln);
	}

	// CRUD -- DELETE operation
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteClient(@QueryParam("Q1") int id) {
		ClientService service = ServiceProvider.getClientService();
		service.deleteClient(id);
	}
}