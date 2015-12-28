package tell.server.dao;

import java.util.*;

import tell.server.model.Notification;

/**
 * 
 * ֪ͨ��dao�ӿ�
 */
public interface NotificationDao {

	/**
	 * 
	 * �����ݿ������֪ͨ---�����֪֮ͨǰnotification.setUser(user)
	 * @param notification
	 * @return true-��ӳɹ���false-���ʧ�� 
	 */
	public Boolean addNotification(Notification notification);
	
	/**
	 * 
	 * �������ݿ��е�֪ͨ
	 * @param notification
	 * @return true-���³ɹ���false-����ʧ��
	 */
	public Boolean updateNotification(Notification notification);
	
	/**
	 * 
	 * �����ݿ��еõ�ָ���û����е�֪ͨ
	 * @param userId
	 * @return ֪ͨ��Ϣ
	 */
	public Set<Notification> getNotifications(int userId);
	
	/**
	 * 
	 * ɾ��ָ���û������е���Ϣ֪ͨ
	 * @param userId
	 * @return true--ɾ���ɹ���false--ɾ��ʧ��
	 */
	public Boolean deleteNotifications(int userId);
}
