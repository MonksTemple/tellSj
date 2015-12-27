package tell.server.presenter;

import java.util.Set;

import tell.server.dao.ActivityDao;
import tell.server.dao.impl.ActivityDaoImpl;
import tell.server.model.Activity;
import tell.server.model.User;

public class ActivityManage {
	
	public Boolean addActivity(Activity activity){
		ActivityDao activityDao = new ActivityDaoImpl();
		return activityDao.addActivity(activity);
	}
	
	public Boolean modifyActivity(Activity activity){
		ActivityDao activityDao = new ActivityDaoImpl();
		return activityDao.updateActivity(activity);
	}
	
	public Boolean deleteActivity(int aId){
		ActivityDao activityDao = new ActivityDaoImpl();
		return activityDao.deleteActivity(aId);
		
	}
	
	public Set<Activity> showActivitiesByTeamId(int tId) {
		ActivityDao activityDao = new ActivityDaoImpl();
		return activityDao.getActivities(tId);
		
	}
	public Set<Activity> showActivitiesByUserId(int userId) {
		ActivityDao activityDao = new ActivityDaoImpl();
		
		return activityDao.getActivites(userId);
		
	}
	public Set<Activity> showIsolateActivities() {
		ActivityDao activityDao = new ActivityDaoImpl();
		return activityDao.getIsolateActivites();
		
	}
	
	public Set<User> showMembers(int aId) {
		ActivityDao activityDao = new ActivityDaoImpl();
		return activityDao.getParticipants(aId);
		
	}
}
