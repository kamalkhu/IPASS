package nl.hu.v1ipass.fitnessapp.Domain;

public class Personaltrainer {
	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	
	public Personaltrainer(){};
	
	public Personaltrainer(int id, String fn, String ln, String un, String pw){
		this.id = id;
		this.firstname = fn;
		this.lastname = ln;
		this.username = un;
		this.password = pw;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getFirstname(){
		return this.firstname;
	}
	
	public void setFirstname(String fn) {
		this.firstname = fn;
	}
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String ln) {
		this.lastname = ln;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String un) {
		this.username = un;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pw) {
		this.password = pw;
	}
}
