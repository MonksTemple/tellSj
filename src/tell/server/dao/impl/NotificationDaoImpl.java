package tell.server.dao.impl;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import tell.server.dao.NotificationDao;
import tell.server.hiberUtil.HiberSessionFactory;
import tell.server.model.Notification;
import tell.server.model.User;

public class NotificationDaoImpl implements NotificationDao{

	@Override
	public void addNotification(Notification notification) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			session.save(notification);
			session.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
		    HiberSessionFactory.closeSession();
		}
	}

	@Override
	public void updateNotification(Notification notification) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			session.update(notification);
			session.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
		    HiberSessionFactory.closeSession();
		}
	}

	@Override
	public Set<Notification> getNotifications(int userId) {
		// TODO Auto-generated method stub
		Set<Notification> nofitications = null;
		Session session = null;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			User user = (User) session.load(User.class, userId);
			if(user != null){
			   nofitications = user.getNotifications();
			}
			session.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			HiberSessionFactory.closeSession();	
		}
		
		return nofitications;
	}

	@Override
	public void deleteNotifications(int userId) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
		session = HiberSessionFactory.getSession();  
		session.getTransaction().begin();
		String hql="delete from Notification where userId="+userId;
		Query query=session.createQuery(hql);
		query.executeUpdate();
		session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			HiberSessionFactory.closeSession();
		}
	}
}
