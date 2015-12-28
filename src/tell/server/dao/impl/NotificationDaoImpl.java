package tell.server.dao.impl;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import tell.server.dao.NotificationDao;
import tell.server.hiberUtil.HiberSessionFactory;
import tell.server.model.Notification;
import tell.server.model.User;

/**
 * 
 * ֪ͨ��ʵ��
 */
public class NotificationDaoImpl implements NotificationDao{

	/*
	 * 
	 * �����ݿ������֪ͨ---�����֪֮ͨǰnotification.setUser(user)
	 * @param notification
	 * @return true-��ӳɹ���false-���ʧ�� 
	 * @see tell.server.dao.NotificationDao#addNotification(tell.server.model.Notification)
	 */
	@Override
	public Boolean addNotification(Notification notification) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean flag = true;
		
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			session.save(notification);
			session.getTransaction().commit();
		}
		catch(Exception e){
			flag = false;
			e.printStackTrace();
		}
		finally{
		    //HiberSessionFactory.closeSession();
		}
		
		return flag;
	}

	/*
	 * 
	 * �������ݿ��е�֪ͨ
	 * @param notification
	 * @return true-���³ɹ���false-����ʧ��
	 * @see tell.server.dao.NotificationDao#updateNotification(tell.server.model.Notification)
	 */
	@Override
	public Boolean updateNotification(Notification notification) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean flag = true;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			session.update(notification);
			session.getTransaction().commit();
		}
		catch(Exception e){
			flag = false;
			e.printStackTrace();
		}
		finally{
		    //HiberSessionFactory.closeSession();
		}
		
		return flag;
	}

	/*
	 * 
	 * �����ݿ��еõ�ָ���û����е�֪ͨ
	 * @param userId
	 * @return ֪ͨ��Ϣ
	 * @see tell.server.dao.NotificationDao#getNotifications(int)
	 */
	@Override
	public Set<Notification> getNotifications(int userId) {
		// TODO Auto-generated method stub
		Set<Notification> nofitications = null;
		Set<Notification> tempNofs = null;
		Session session = null;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			User user = (User) session.load(User.class, userId);
			if(user != null){
				nofitications = new HashSet<Notification>();
				tempNofs = user.getNotifications();
				for(Notification not:tempNofs){
					nofitications.add(new Notification(not));
				}
			}
			session.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//HiberSessionFactory.closeSession();	
		}
		
		return nofitications;
	}

	/*
	 * 
	 * ɾ��ָ���û������е���Ϣ֪ͨ
	 * @param userId
	 * @return true--ɾ���ɹ���false--ɾ��ʧ��
	 * @see tell.server.dao.NotificationDao#deleteNotifications(int)
	 */
	@Override
	public Boolean deleteNotifications(int userId) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean flag = true;
		
		try{
			session = HiberSessionFactory.getSession();  
			session.getTransaction().begin();
			String hql="delete from Notification where userId="+userId;
			Query query=session.createQuery(hql);
			query.executeUpdate();
			session.getTransaction().commit();
		}catch(Exception e){
			flag = false;
			e.printStackTrace();
		}
		finally{
			//HiberSessionFactory.closeSession();
		}
		
		return flag;
	}
}
