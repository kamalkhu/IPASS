package nl.hu.v1ipass.fitnessapp.Service;

import java.util.List;

import nl.hu.v1ipass.fitnessapp.Domain.Client;
import nl.hu.v1ipass.fitnessapp.Persistence.ClientDAO;

public class ClientService {
	private ClientDAO clientDAO = new ClientDAO();

	// GET function
	public List<Client> getAllClients() {
		return clientDAO.getAllClients();
	}

	// GET{id} function
	public Client getClientById(int id) {
		Client clientResponse = clientDAO.getClientById(id);
		return clientResponse;
	}

	// POST function
	public void insertClient(String fn, String ln) {
		clientDAO.insertClient(fn, ln);
	}

	// PUT function
	public void updateClient(int id, String fn, String ln) {
		clientDAO.updateClient(id, fn, ln);
	}

	// DELETE function
	public void deleteClient(int id) {
		clientDAO.deleteClient(id);
	}

}