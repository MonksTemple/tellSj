package tell.server.dao;

import java.util.Set;

import tell.server.model.Activity;
import tell.server.model.User;

public interface ActivityDao {

	//注：如果是团队和和课程组活动，调用之前要先 activity.getTeam().setTeam()
	public Boolean addActivity(Activity activity);
	
	public Boolean updateActivity(Activity activity);
	
	//删除活动---并且自动删除其参加的成员的记录
	public Boolean deleteActivity(int aId);
	
	public Boolean deleteParticipant(int aId,int userId);
	
	public Boolean addParticipant(int aId,int userId);
	
	public Set<User> getParticipants(int aId);
	
	//删除所有指定团队的活动
	public Boolean deleteActivites(int tId);
	
	public Set<Activity> getActivites(int userId);
	
	public Set<Activity> getIsolateActivites();
	
	public Set<Activity> getActivities(int tId);
}
