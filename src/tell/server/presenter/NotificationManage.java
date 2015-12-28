package tell.server.presenter;

import tell.server.dao.NotificationDao;
import tell.server.dao.TeamDao;
import tell.server.dao.impl.NotificationDaoImpl;
import tell.server.dao.impl.TeamDaoImpl;
import tell.server.model.Notification;

/**
 * 
 * ֪ͨ�ദ��
 */
public class NotificationManage {

	/**
	 * 
	 * ���֪ͨ��Ϣ
	 * @param notification
	 * @return true--��ӳɹ���false--���ʧ��
	 */
	public Boolean addNotification(Notification notification) {
		NotificationDao notificationDao = new NotificationDaoImpl();
		return notificationDao.addNotification(notification);
		
	}
	
	/**
	 * 
	 * �޸�֪ͨ��Ϣ
	 * @param notification
	 * @return true--�޸ĸóɹ���false--�޸�ʧ��
	 */
	public Boolean updateNotification(Notification notification) {
		NotificationDao notificationDao = new NotificationDaoImpl();
		notificationDao.updateNotification(notification);
		String str = notification.getDescription();
		if(str.contains("������������Ŷ�")){            //�����ͬ��������Ϣ������Ŷ� �û���Ϣ
			String[] strBuf = str.split("<|:|>|+|+| "); 
			if(strBuf[4].equals("Y")){
				int no = Integer.valueOf(strBuf[1]);
				int userId = Integer.valueOf(strBuf[5]);
				TeamDao teamDao = new TeamDaoImpl();
				teamDao.addMember(no, userId);
			}

		}
		
		return true;
	}
}
