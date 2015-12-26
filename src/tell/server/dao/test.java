package tell.server.dao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

import tell.server.dao.impl.NotificationDaoImpl;
import tell.server.hiberUtil.HiberSessionFactory;
import tell.server.model.Notification;
import tell.server.model.User;

public class test {
	
	public static void main(String[] args){

//		Session session = HiberSessionFactory.getSession();
//		
//		session.beginTransaction();  
//		User user = new User();
//		user.setUserName("tt");
//		user.setUserId(13301044);
//		user.setPassword("111");
//		user.setPhoneno("122");
//		
//		Notification no = new Notification();
//		no.setState(false);
//		no.setDescription("aaaa");
//		user.getNotifications().add(no);
//		no.setUser(user);
//		
//		session.save(user);
//		session.getTransaction().commit(); 	
//		HiberSessionFactory.closeSession();
		
		
	
		
//		Session session2 = HiberSessionFactory.getSession();
//		
//		session2.beginTransaction();  
//		User user = new User();
//		user.setUserId(13301044);
//		//session2.update(user);
//		session2.delete(user);
//		session2.getTransaction().commit();
//		HiberSessionFactory.closeSession();
		
		NotificationDao notifDao = new NotificationDaoImpl();
		notifDao.deleteNotifications(13301044);
		
	}
}
