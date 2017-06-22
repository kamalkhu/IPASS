package nl.hu.v1ipass.fitnessapp.Resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

import nl.hu.v1ipass.fitnessapp.Domain.Activity;
import nl.hu.v1ipass.fitnessapp.Service.ActivityService;
import nl.hu.v1ipass.fitnessapp.Service.ServiceProvider;

@Path("/activities")
public class ActivityResource {

	@GET
	@Produces("application/json")
	public String getActivities() {
		ActivityService service = ServiceProvider.getActivityService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Activity a : service.getAllActivities()) {
			JsonObjectBuilder activity = Json.createObjectBuilder();
			activity.add("activityid", a.getId());
			activity.add("startdate", a.getStartdate());
			activity.add("starttime", a.getStarttime());
			activity.add("duration", a.getDuration());
			activity.add("type", a.getType());
			activity.add("clientid", a.getClientId());
			activity.add("personaltrainerid", a.getPersonalTrainerId());

			jab.add(activity);
		}
		JsonArray array = jab.build();
		return array.toString();
	}

	@GET
	@Path("/parsed")
	@Produces("application/json")
	public String getParsedActivities() throws ParseException {
		ActivityService service = ServiceProvider.getActivityService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Activity a : service.getAllActivities()) {
			JsonObjectBuilder activity = Json.createObjectBuilder();
			activity.add("id", a.getId());
			activity.add("title", a.getType());

			final String OLD_FORMAT = "dd-MM-yyyy";
			final String NEW_FORMAT = "yyyy-MM-dd";

			// format date
			String oldDateString = a.getStartdate();
			String newDateString;
			SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
			Date d = sdf.parse(oldDateString);
			sdf.applyPattern(NEW_FORMAT);
			newDateString = sdf.format(d);

			// format time
			String myTime = a.getStarttime();
			SimpleDateFormat df = new SimpleDateFormat("HH:mm");
			Date d1 = df.parse(myTime);
			Calendar cal = Calendar.getInstance();
			cal.setTime(d1);
			cal.add(Calendar.MINUTE, a.getDuration());
			String newTime = df.format(cal.getTime());

			activity.add("start", newDateString + "T" + a.getStarttime());
			activity.add("end", newDateString + "T" + newTime);

			jab.add(activity);
		}
		JsonArray array = jab.build();
		return array.toString();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getActivityById(@PathParam("id") int id) {
		ActivityService service = ServiceProvider.getActivityService();
		Activity activity = service.getActivityById(id);

		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("activityid", activity.getId());
		job.add("startdate", activity.getStartdate());
		job.add("starttime", activity.getStarttime());
		job.add("duration", activity.getDuration());
		job.add("type", activity.getType());
		job.add("clientid", activity.getClientId());
		job.add("personaltrainerid", activity.getPersonalTrainerId());

		return job.build().toString();
	}

	// CRUD -- INSERT operation
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertActivity(@QueryParam("Q1") String sd, @QueryParam("Q2") String st, @QueryParam("Q3") int du,
			@QueryParam("Q4") String tp, @QueryParam("Q5") int cid, @QueryParam("Q6") int pid) {
		ActivityService service = ServiceProvider.getActivityService();
		service.insertActivity(sd, st, du, tp, cid, pid);
	}

	// CRUD -- UPDATE operation
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateActivity(@QueryParam("Q1") int id, @QueryParam("Q2") String sd, @QueryParam("Q3") String st,
			@QueryParam("Q4") int du, @QueryParam("Q5") String tp, @QueryParam("Q6") int cid, @QueryParam("Q7") int pid) {
		ActivityService service = ServiceProvider.getActivityService();
		service.updateActivity(id, sd, st, du, tp, cid, pid);
	}

	// CRUD -- DELETE operation
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteActivity(@QueryParam("Q1") int id) {
		ActivityService service = ServiceProvider.getActivityService();
		service.deleteActivity(id);
	}
}
