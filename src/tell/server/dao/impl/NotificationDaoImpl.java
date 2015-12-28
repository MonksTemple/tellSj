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
 * 通知类实现
 */
public class NotificationDaoImpl implements NotificationDao{

	/*
	 * 
	 * 向数据库中添加通知---在添加通知之前notification.setUser(user)
	 * @param notification
	 * @return true-添加成功，false-添加失败 
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
	 * 更新数据库中的通知
	 * @param notification
	 * @return true-更新成功，false-更新失败
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
	 * 从数据库中得到指定用户所有的通知
	 * @param userId
	 * @return 通知信息
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
	 * 删除指定用户的所有的消息通知
	 * @param userId
	 * @return true--删除成功，false--删除失败
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
