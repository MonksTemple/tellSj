package tell.server.dao;

import java.util.*;

import tell.server.model.Notification;

public interface NotificationDao {

	//���֪ͨ---�����֪֮ͨǰnotification.setUser(user)
	public Boolean addNotification(Notification notification);
	
	//����֪ͨ
	public Boolean updateNotification(Notification notification);
	
	//�õ����û����е�֪ͨ
	public Set<Notification> getNotifications(int userId);
	
	//ɾ���û����е���Ϣ֪ͨ	
	public Boolean deleteNotifications(int userId);
}
