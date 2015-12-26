package tell.server.dao;

import java.util.Set;

import tell.server.model.Activity;
import tell.server.model.User;

public interface ActivityDao {

	//ע��������ŶӺͺͿγ���������֮ǰҪ�� activity.getTeam().setTeam()
	public void addActivity(Activity activity);
	
	public void updateActivity(Activity activity);
	
	//ɾ���---�����Զ�ɾ����μӵĳ�Ա�ļ�¼
	public void deleteActivity(int aId);
	
	public void deleteParticipant(int aId,int userId);
	
	public void addParticipant(int aId,int userId);
	
	public Set<User> getParticipants(int aId);
	
	//ɾ������ָ���ŶӵĻ
	public void deleteActivites(int tId);
	
	public Set<Activity> getActivites(int userId);
	
	public Set<Activity> getIsolateActivites();
	
	public Set<Activity> getActivities(int tId);
}
