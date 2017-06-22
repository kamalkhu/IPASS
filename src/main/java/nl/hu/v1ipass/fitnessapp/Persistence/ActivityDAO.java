package nl.hu.v1ipass.fitnessapp.Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nl.hu.v1ipass.fitnessapp.Domain.Activity;

public class ActivityDAO extends BaseDAO {

	private ArrayList<Activity> selectActivities(String query) {
		ArrayList<Activity> activity = new ArrayList<Activity>();

		try (Connection con = super.connect()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			while (dbResultSet.next()) {
				Integer id = dbResultSet.getInt("id");
				String startdate = dbResultSet.getString("startdate");
				String starttime = dbResultSet.getString("starttime");
				int duration = dbResultSet.getInt("duration");
				String type = dbResultSet.getString("type");
				int clientid = dbResultSet.getInt("clientid");
				int personaltrainerid = dbResultSet.getInt("personaltrainerid");
				Activity a = new Activity(id, startdate, starttime, duration, type, clientid,  personaltrainerid);
				activity.add(a);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return activity;
	}

	public ArrayList<Activity> getAllActivities() {
		return selectActivities("SELECT * FROM Activity");
	}

	// Get activity by id from db
	public Activity getActivityById(int id) {
		Activity c = new Activity();
		try (Connection con = super.connect()) {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM Activity WHERE id=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				c.setId(rs.getInt(1));
				c.setStartdate(rs.getString(2));
				c.setStarttime(rs.getString(3));
				c.setDuration(rs.getInt(4));
				c.setType(rs.getString(5));
				c.setClientId(rs.getInt(6));
				c.setPersonalTrainerId(rs.getInt(7));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return c;
	}

	// Insert client to db
	public void insertActivity(String sd, String st, int du, String tp, int cid, int pid) {
		String query = "INSERT INTO Activity(Startdate, Starttime, Duration, Type, Clientid, Personaltrainerid) VALUES('" + sd + "','" + st
				+ "','" + du + "','" + tp + "'," + cid + "," + pid + ")";
		try (Connection con = super.connect()) {
			Statement stmt = con.createStatement();
			stmt.execute(query);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	// Update client from db
	public void updateActivity(int id, String sd, String st, int du, String tp, int cid, int pid) {
		String query = "UPDATE Activity SET startdate = '" + sd + "', starttime = '" + st + "', duration= " + du
				+ ", type= '" + tp + "', clientid= " + cid + ", personaltrainerid= " + pid +" WHERE id = " + id;
		try (Connection con = super.connect()) {
			Statement stmt = con.createStatement();
			stmt.execute(query);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	// Delete client from db
	public void deleteActivity(int id) {
		String query = "DELETE FROM Activity WHERE id = " + id;
		try (Connection con = super.connect()) {
			Statement stmt = con.createStatement();
			stmt.execute(query);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
