package nl.hu.v1ipass.fitnessapp.Service;

import java.util.List;

import nl.hu.v1ipass.fitnessapp.Domain.Activity;
import nl.hu.v1ipass.fitnessapp.Persistence.ActivityDAO;

public class ActivityService {
	private ActivityDAO activityDAO = new ActivityDAO();

	// GET function
	public List<Activity> getAllActivities() {
		return activityDAO.getAllActivities();
	}

	// GET{id} function
	public Activity getActivityById(int id) {
		Activity activityResponse = activityDAO.getActivityById(id);
		return activityResponse;
	}

	// POST function
	public void insertActivity(String sd, String st, int du, String tp, int cid, int pid) {
		activityDAO.insertActivity(sd, st, du, tp, cid, pid);
	}

	// PUT function
	public void updateActivity(int id, String sd, String st, int du, String tp, int cid, int pid) {
		activityDAO.updateActivity(id, sd, st, du, tp, cid, pid);
	}

	// DELETE function
	public void deleteActivity(int id) {
		activityDAO.deleteActivity(id);
	}
}
