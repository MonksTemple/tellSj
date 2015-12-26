package tell.server.dao;

import java.util.Set;

import tell.server.model.Activity;
import tell.server.model.User;

public interface ActivityDao {

	//注：如果是团队和和课程组活动，调用之前要先 activity.getTeam().setTeam()
	public void addActivity(Activity activity);
	
	public void updateActivity(Activity activity);
	
	//删除活动---并且自动删除其参加的成员的记录
	public void deleteActivity(int aId);
	
	public void deleteParticipant(int aId,int userId);
	
	public void addParticipant(int aId,int userId);
	
	public Set<User> getParticipants(int aId);
	
	//删除所有指定团队的活动
	public void deleteActivites(int tId);
	
	public Set<Activity> getActivites(int userId);
	
	public Set<Activity> getIsolateActivites();
	
	public Set<Activity> getActivities(int tId);
}
