package nl.hu.v1ipass.fitnessapp.Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nl.hu.v1ipass.fitnessapp.Domain.Personaltrainer;

public class PersonaltrainerDAO extends BaseDAO {

	private ArrayList<Personaltrainer> selectPersonaltrainers(String query) {
		ArrayList<Personaltrainer> personaltrainer = new ArrayList<Personaltrainer>();

		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			while (dbResultSet.next()) {
				int id = dbResultSet.getInt("id");
				String firstname = dbResultSet.getString("firstname");
				String lastname = dbResultSet.getString("lastname");
				String username = dbResultSet.getString("username");
				String password = dbResultSet.getString("password");
				Personaltrainer p = new Personaltrainer(id, firstname, lastname, username, password);
				personaltrainer.add(p);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return personaltrainer;
	}

	// Get all personaltrainers from db
	public ArrayList<Personaltrainer> getAllPersonaltrainers() {
		return selectPersonaltrainers("SELECT * FROM personaltrainer");
	}

	// Get personaltrainers by id from db
	public Personaltrainer getPersonaltrainerById(int id) {
		Personaltrainer p = new Personaltrainer();
		try (Connection con = super.getConnection()) {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM personaltrainer WHERE id=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				p.setId(rs.getInt(1));
				p.setFirstname(rs.getString(2));
				p.setLastname(rs.getString(3));
				p.setUsername(rs.getString(4));
				p.setPassword(rs.getString(5));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return p;
	}

	// Insert personaltrainers to db
	public void insertPersonaltrainer(String fn, String ln, String un, String pw) {
		String query = "INSERT INTO personaltrainer(firstname, lastname, username, password) VALUES('" + fn + "','" + ln + "','" + un + "','" + pw + "')";
		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			stmt.execute(query);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	// Update personaltrainers from db
	public void updatePersonaltrainer(int id, String fn, String ln, String un, String pw) {
		String query = "UPDATE personaltrainer SET firstname = '" + fn + "', lastname = '" + ln + "', username = '" + un + "', password = '" + pw + "' WHERE id = " + id;
		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			stmt.execute(query);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	// Delete client from db
	public void deletePersonaltrainer(int id) {
		String query = "DELETE FROM personaltrainer WHERE id = " + id;
		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			stmt.execute(query);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}