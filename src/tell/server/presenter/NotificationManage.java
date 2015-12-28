package tell.server.presenter;

import tell.server.dao.NotificationDao;
import tell.server.dao.TeamDao;
import tell.server.dao.impl.NotificationDaoImpl;
import tell.server.dao.impl.TeamDaoImpl;
import tell.server.model.Notification;

/**
 * 
 * 通知类处理
 */
public class NotificationManage {

	/**
	 * 
	 * 添加通知信息
	 * @param notification
	 * @return true--添加成功，false--添加失败
	 */
	public Boolean addNotification(Notification notification) {
		NotificationDao notificationDao = new NotificationDaoImpl();
		return notificationDao.addNotification(notification);
		
	}
	
	/**
	 * 
	 * 修改通知信息
	 * @param notification
	 * @return true--修改该成功，false--修改失败
	 */
	public Boolean updateNotification(Notification notification) {
		NotificationDao notificationDao = new NotificationDaoImpl();
		notificationDao.updateNotification(notification);
		String str = notification.getDescription();
		if(str.contains("邀请您加入该团队")){            //如果是同意邀请信息则加入团队 用户信息
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
