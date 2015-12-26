package tell.server.dao.impl;

import org.hibernate.Session;

import tell.server.dao.UserDao;
import tell.server.hiberUtil.HiberSessionFactory;
import tell.server.model.User;

public class UserDaoImpl implements UserDao{

	@Override
	public Boolean exist(User user) {
		// TODO Auto-generated method stub
		Session session = null;
		User temp  = null;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			temp = (User) session.get(User.class, user.getUserId());
			session.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		finally{
		    HiberSessionFactory.closeSession();
		}
		
		if(!temp.getPassword().equals(user.getPassword())){
			return false;
		}
		return true;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			session.save(user);
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
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			session.update(user);
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
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			User user = (User) session.get(User.class, userId);
			session.delete(user);
			session.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
		    HiberSessionFactory.closeSession();
		}		
	}

}
