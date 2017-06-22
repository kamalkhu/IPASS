package nl.hu.v1ipass.fitnessapp.Domain;

public class Client {
	private int id;
	private String firstname;
	private String lastname;
	
	public Client(){};
	
	public Client(int id, String fn, String ln){
		this.id = id;
		this.firstname = fn;
		this.lastname = ln;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstname;
	}

	public void setFirstName(String fn) {
		this.firstname = fn;
	}

	public String getLastName() {
		return this.lastname;
	}
	
	public void setLastName(String ln) {
		this.lastname = ln;
	}
}