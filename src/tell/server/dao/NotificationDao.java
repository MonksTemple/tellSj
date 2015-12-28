package tell.server.dao;

import java.util.*;

import tell.server.model.Notification;

/**
 * 
 * 通知类dao接口
 */
public interface NotificationDao {

	/**
	 * 
	 * 向数据库中添加通知---在添加通知之前notification.setUser(user)
	 * @param notification
	 * @return true-添加成功，false-添加失败 
	 */
	public Boolean addNotification(Notification notification);
	
	/**
	 * 
	 * 更新数据库中的通知
	 * @param notification
	 * @return true-更新成功，false-更新失败
	 */
	public Boolean updateNotification(Notification notification);
	
	/**
	 * 
	 * 从数据库中得到指定用户所有的通知
	 * @param userId
	 * @return 通知信息
	 */
	public Set<Notification> getNotifications(int userId);
	
	/**
	 * 
	 * 删除指定用户的所有的消息通知
	 * @param userId
	 * @return true--删除成功，false--删除失败
	 */
	public Boolean deleteNotifications(int userId);
}
