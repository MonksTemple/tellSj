package tell.server.presenter;

import java.util.Set;

import tell.server.dao.ActivityDao;
import tell.server.dao.impl.ActivityDaoImpl;
import tell.server.model.Activity;
import tell.server.model.User;

/**
 * 
 * ��ദ��
 */
public class ActivityManage {
	
	/**
	 * 
	 * ��ӻ��Ϣ
	 * @param activity
	 * @return true-��ӻ�ɹ���false--��ӻʧ��
	 */
	public Boolean addActivity(Activity activity){
		ActivityDao activityDao = new ActivityDaoImpl();
		return activityDao.addActivity(activity);
	}
	
	/**
	 * 
	 * �޸Ļ��Ϣ
	 * @param activity
	 * @return true-�޸Ļ�ɹ���false--�޸Ļʧ��
	 */
	public Boolean modifyActivity(Activity activity){
		ActivityDao activityDao = new ActivityDaoImpl();
		return activityDao.updateActivity(activity);
	}
	
	/**
	 * 
	 * ɾ�����Ϣ
	 * @param aId
	 * @return true-ɾ���ɹ���false-ɾ��ʧ��
	 */
	public Boolean deleteActivity(int aId){
		ActivityDao activityDao = new ActivityDaoImpl();
		return activityDao.deleteActivity(aId);
		
	}
	
	/**
	 * 
	 * ��ʾ�Ŷӵ����еĻ�б�
	 * @param tId
	 * @return ��б�
	 */
	public Set<Activity> showActivitiesByTeamId(int tId) {
		ActivityDao activityDao = new ActivityDaoImpl();
		return activityDao.getActivities(tId);
		
	}
	
	/**
	 * 
	 * �������ָ���û��μӵĻ
	 * @param userId
	 * @return ��б�
	 */
	public Set<Activity> showActivitiesByUserId(int userId) {
		ActivityDao activityDao = new ActivityDaoImpl();
		
		return activityDao.getActivites(userId);
		
	}
	
	/**
	 * 
	 * ������еĵ��˻
	 * @return ��б�
	 */
	public Set<Activity> showIsolateActivities() {
		ActivityDao activityDao = new ActivityDaoImpl();
		return activityDao.getIsolateActivites();
		
	}
	
	/**
	 * 
	 * ��ʾ��ĳ�Ա
	 * @param aId
	 * @return ���Ա�б�
	 */
	public Set<User> showMembers(int aId) {
		ActivityDao activityDao = new ActivityDaoImpl();
		return activityDao.getParticipants(aId);
		
	}
}
