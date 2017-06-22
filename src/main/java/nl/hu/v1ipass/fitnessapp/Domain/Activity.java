package nl.hu.v1ipass.fitnessapp.Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Activity {
	private int id;
	private String startdate;
	private String starttime;
	private int duration;
	private String type;
	private int clientid;
	private int personaltrainerid;
	
	public Activity(){};
	
	public Activity(int id, String sd, String st, int dr, String tp,int cid, int pid){
		this.id = id;
		this.startdate = sd;
		this.starttime = st;
		this.duration = dr;
		this.type = tp;
		this.clientid = cid;
		this.personaltrainerid = pid;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getStartdate(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
		try{
            simpleDateFormat.parse(startdate);
        }
        catch (ParseException ex){
            System.out.println("Exception "+ex);
        }
		return this.startdate;
	}
	
	public void setStartdate(String sd){
		this.startdate = sd;
	}
	
	public String getStarttime(){
		return this.starttime;
	}
	
	public void setStarttime(String st){
		this.starttime = st;
	}
	
	public int getDuration(){
		return this.duration;
	}
	
	public void setDuration(int dr){
		this.duration = dr;
	}
	
	public String getType(){
		return this.type;
	}
	
	public void setType(String tp){
		this.type = tp;
	}
	
	public int getClientId(){
		return this.clientid;
	}
	
	public void setClientId(int cid){
		this.clientid = cid;
	}
	
	public int getPersonalTrainerId(){
		return this.personaltrainerid;
	}
	
	public void setPersonalTrainerId(int pid){
		this.personaltrainerid = pid;
	}
}
