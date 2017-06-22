package nl.hu.v1ipass.fitnessapp.Service;

public class ServiceProvider {
	private static ActivityService activityService = new ActivityService();
	private static ClientService clientService = new ClientService();
	private static PersonaltrainerService personaltrainerService = new PersonaltrainerService();

	public static ActivityService getActivityService() {
		return activityService;
	}
	
	public static ClientService getClientService() {
		return clientService;
	}
	
	public static PersonaltrainerService getPersonaltrainerService() {
		return personaltrainerService;
	}
}
