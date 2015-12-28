package tell.server.presenter;

import java.util.Set;

import tell.server.dao.ActivityDao;
import tell.server.dao.impl.ActivityDaoImpl;
import tell.server.model.Activity;
import tell.server.model.User;

/**
 * 
 * 活动类处理
 */
public class ActivityManage {
	
	/**
	 * 
	 * 添加活动信息
	 * @param activity
	 * @return true-添加活动成功，false--添加活动失败
	 */
	public Boolean addActivity(Activity activity){
		ActivityDao activityDao = new ActivityDaoImpl();
		return activityDao.addActivity(activity);
	}
	
	/**
	 * 
	 * 修改活动信息
	 * @param activity
	 * @return true-修改活动成功，false--修改活动失败
	 */
	public Boolean modifyActivity(Activity activity){
		ActivityDao activityDao = new ActivityDaoImpl();
		return activityDao.updateActivity(activity);
	}
	
	/**
	 * 
	 * 删除活动信息
	 * @param aId
	 * @return true-删除成功，false-删除失败
	 */
	public Boolean deleteActivity(int aId){
		ActivityDao activityDao = new ActivityDaoImpl();
		return activityDao.deleteActivity(aId);
		
	}
	
	/**
	 * 
	 * 显示团队的所有的活动列表
	 * @param tId
	 * @return 活动列表
	 */
	public Set<Activity> showActivitiesByTeamId(int tId) {
		ActivityDao activityDao = new ActivityDaoImpl();
		return activityDao.getActivities(tId);
		
	}
	
	/**
	 * 
	 * 获得所有指定用户参加的活动
	 * @param userId
	 * @return 活动列表
	 */
	public Set<Activity> showActivitiesByUserId(int userId) {
		ActivityDao activityDao = new ActivityDaoImpl();
		
		return activityDao.getActivites(userId);
		
	}
	
	/**
	 * 
	 * 获得所有的单人活动
	 * @return 活动列表
	 */
	public Set<Activity> showIsolateActivities() {
		ActivityDao activityDao = new ActivityDaoImpl();
		return activityDao.getIsolateActivites();
		
	}
	
	/**
	 * 
	 * 显示活动的成员
	 * @param aId
	 * @return 活动成员列表
	 */
	public Set<User> showMembers(int aId) {
		ActivityDao activityDao = new ActivityDaoImpl();
		return activityDao.getParticipants(aId);
		
	}
}
