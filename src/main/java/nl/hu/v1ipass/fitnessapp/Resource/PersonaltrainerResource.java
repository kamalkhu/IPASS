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

import nl.hu.v1ipass.fitnessapp.Domain.Personaltrainer;
import nl.hu.v1ipass.fitnessapp.Service.PersonaltrainerService;
import nl.hu.v1ipass.fitnessapp.Service.ServiceProvider;

@Path("/trainers")
public class PersonaltrainerResource {
	PersonaltrainerService personaltrainerService = new PersonaltrainerService();

	// CRUD -- READ operation
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllPersonaltrainers() {
		PersonaltrainerService service = ServiceProvider.getPersonaltrainerService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Personaltrainer p : service.getAllPersonaltrainers()) {
			JsonObjectBuilder personaltrainer = Json.createObjectBuilder();
			personaltrainer.add("id", p.getId());
			personaltrainer.add("firstname", p.getFirstname());
			personaltrainer.add("lastname", p.getLastname());
			personaltrainer.add("username", p.getUsername());
			personaltrainer.add("password", p.getPassword());

			jab.add(personaltrainer);
		}
		JsonArray array = jab.build();
		return array.toString();
	}

	// CRUD -- READ operation
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPersonaltrainerById(@PathParam("id") int id) {
		PersonaltrainerService service = ServiceProvider.getPersonaltrainerService();
		Personaltrainer personaltrainer = service.getPersonaltrainerById(id);

		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("id", personaltrainer.getId());
		job.add("firstname", personaltrainer.getFirstname());
		job.add("lastname", personaltrainer.getLastname());
		job.add("username", personaltrainer.getUsername());
		job.add("password", personaltrainer.getPassword());

		return job.build().toString();
	}

	// CRUD -- INSERT operation
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertPersonaltrainer(@QueryParam("Q1") String fn, @QueryParam("Q2") String ln,
			@QueryParam("Q3") String un, @QueryParam("Q4") String pw) {
		PersonaltrainerService service = ServiceProvider.getPersonaltrainerService();
		service.insertPersonaltrainer(fn, ln, un, pw);
	}

	// CRUD -- UPDATE operation
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updatePersonaltrainer(@QueryParam("Q1") int id, @QueryParam("Q2") String fn,
			@QueryParam("Q3") String ln, @QueryParam("Q4") String un, @QueryParam("Q5") String pw) {
		PersonaltrainerService service = ServiceProvider.getPersonaltrainerService();
		service.updatePersonaltrainer(id, fn, ln, un, pw);
	}

	// CRUD -- DELETE operation
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deletePersonaltrainer(@QueryParam("Q1") int id) {
		PersonaltrainerService service = ServiceProvider.getPersonaltrainerService();
		service.deletePersonaltrainer(id);
	}
}