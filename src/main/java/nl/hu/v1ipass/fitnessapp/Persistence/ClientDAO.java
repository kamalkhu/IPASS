package nl.hu.v1ipass.fitnessapp.Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nl.hu.v1ipass.fitnessapp.Domain.Client;

public class ClientDAO extends BaseDAO {

	private ArrayList<Client> selectClients(String query) {
		ArrayList<Client> client = new ArrayList<Client>();

		try (Connection con = super.connect()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			while (dbResultSet.next()) {
				int id = dbResultSet.getInt("id");
				String firstname = dbResultSet.getString("firstname");
				String lastname = dbResultSet.getString("lastname");
				Client c = new Client(id, firstname, lastname);
				client.add(c);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return client;
	}

	// Get all clients from db
	public ArrayList<Client> getAllClients() {
		return selectClients("SELECT * FROM Client");
	}

	// Get client by id from db
	public Client getClientById(int id) {
		Client c = new Client();
		try (Connection con = super.connect()) {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM Client WHERE id=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				c.setId(rs.getInt(1));
				c.setFirstName(rs.getString(2));
				c.setLastName(rs.getString(3));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return c;
	}

	// Insert client to db
	public void insertClient(String fn, String ln) {
		String query = "INSERT INTO Client(firstname, lastname) VALUES('" + fn + "','" + ln + "')";
		try (Connection con = super.connect()) {
			Statement stmt = con.createStatement();
			stmt.execute(query);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	// Update client from db
	public void updateClient(int id, String fn, String ln) {
		String query = "UPDATE Client SET firstname = '" + fn + "', lastname = '" + ln + "' WHERE id = " + id;
		try (Connection con = super.connect()) {
			Statement stmt = con.createStatement();
			stmt.execute(query);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	// Delete client from db
	public void deleteClient(int id) {
		String query = "DELETE FROM Client WHERE id = " + id;
		try (Connection con = super.connect()) {
			Statement stmt = con.createStatement();
			stmt.execute(query);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}