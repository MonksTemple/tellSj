package tell.server.dao;

import java.util.*;

import tell.server.model.Notification;

public interface NotificationDao {

	//添加通知---在添加通知之前notification.setUser(user)
	public void addNotification(Notification notification);
	
	//更新通知
	public void updateNotification(Notification notification);
	
	//得到该用户所有的通知
	public Set<Notification> getNotifications(int userId);
	
	//删除用户所有的消息通知	
	public void deleteNotifications(int userId);
}
