package tell.server.dao;

import java.util.Set;

import tell.server.model.Activity;
import tell.server.model.User;

/**
 * 
 * 活动类dao操作接口
 */
public interface ActivityDao {

	/**
	 * 
	 * 向数据库中添加活动信息
	 * @param activity
	 * @return true-添加活动成功，false--添加活动失败
	 */
	public Boolean addActivity(Activity activity);
	
	/**
	 *
	 * 修改数据库中的活动信息
	 * @param activity
	 * @return true-修改活动成功，false--修改活动失败
	 */
	public Boolean updateActivity(Activity activity);
	
	/**
	 * 从数据库中删除活动信息
	 * @param aId
	 * @return true-删除成功，false-删除失败
	 */
	public Boolean deleteActivity(int aId);

	/**
	 * 
	 * 从数据库中删除活动参与者
	 * @param aId
	 * @param userId
	 * @return true-删除成功，false-删除失败
	 */
	public Boolean deleteParticipant(int aId,int userId);
	
	/**
	 * 
	 * 向数据库中添加活动成员
	 * @param aId
	 * @param userId
	 * @return true-添加成功，false-添加失败
	 */
	public Boolean addParticipant(int aId,int userId);
	
	/**
	 * 
	 * 从数据库中获得活动的参与人员
	 * @param aId
	 * @return 活动参与人员列表
	 */
	public Set<User> getParticipants(int aId);
	
	/**
	 * 
	 * 从数据库中删除指定团队的活动
	 * @param tId
	 * @return true-删除成功，false-删除失败
	 */
	public Boolean deleteActivites(int tId);
	
	/**
	 * 
	 * 根据用户id得到该用户参与的活动列表
	 * @param userId
	 * @return 活动列表
	 */
	public Set<Activity> getActivites(int userId);
	
	/**
	 * 
	 * 得到单人活动列表
	 * @return 活动列表
	 */
	public Set<Activity> getIsolateActivites();
	
	/**
	 * 
	 * 得到团队举办的活动列表
	 * @param tId
	 * @return 活动列表
	 */
	public Set<Activity> getActivities(int tId);
	
	/**
	 * 
	 * 得到所有的活动
	 * @param 
	 * @return 活动列表
	 */
	public Set<Activity> getActivities();
}
