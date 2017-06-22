package nl.hu.v1ipass.fitnessapp.Service;

import java.util.List;

import nl.hu.v1ipass.fitnessapp.Domain.Personaltrainer;
import nl.hu.v1ipass.fitnessapp.Persistence.PersonaltrainerDAO;

public class PersonaltrainerService {
	private PersonaltrainerDAO personaltrainerDAO = new PersonaltrainerDAO();

	// GET function
	public List<Personaltrainer> getAllPersonaltrainers() {
		return personaltrainerDAO.getAllPersonaltrainers();
	}

	// GET{id} function
	public Personaltrainer getPersonaltrainerById(int id) {
		Personaltrainer personaltrainerResponse = personaltrainerDAO.getPersonaltrainerById(id);
		return personaltrainerResponse;
	}

	// POST function
	public void insertPersonaltrainer(String fn, String ln, String un, String pw) {
		personaltrainerDAO.insertPersonaltrainer(fn, ln, un, pw);
	}

	// PUT function
	public void updatePersonaltrainer(int id, String fn, String ln, String un, String pw) {
		personaltrainerDAO.updatePersonaltrainer(id, fn, ln, un, pw);
	}

	// DELETE function
	public void deletePersonaltrainer(int id) {
		personaltrainerDAO.deletePersonaltrainer(id);
	}
}