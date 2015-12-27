package tell.server.dao.impl;

import org.hibernate.Session;

import tell.server.dao.UserDao;
import tell.server.hiberUtil.HiberSessionFactory;
import tell.server.model.User;

public class UserDaoImpl implements UserDao{

	@Override
	public User exist(User user) {
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
			return null;
		}
		finally{
		    HiberSessionFactory.closeSession();
		}
		
		if(temp==null||!temp.getPassword().equals(user.getPassword())){
			return null;
		}
		return new User(temp);
	}

	@Override
	public Boolean addUser(User user) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean flag = true;
		
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			session.save(user);
			session.getTransaction().commit();
		}
		catch(Exception e){
			flag = false;
			e.printStackTrace();
		}
		finally{
		    HiberSessionFactory.closeSession();
		}				
		
		return flag;
	}

	@Override
	public Boolean updateUser(User user) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean flag = true;
		
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			session.update(user);
			session.getTransaction().commit();
		}
		catch(Exception e){
			flag = false;
			e.printStackTrace();
		}
		finally{
		    HiberSessionFactory.closeSession();
		}			
		
		return flag;
	}

	@Override
	public Boolean deleteUser(int userId) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean flag = true;
		
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			User user = (User) session.get(User.class, userId);
			session.delete(user);
			session.getTransaction().commit();
		}
		catch(Exception e){
			flag =false;
			e.printStackTrace();
		}
		finally{
		    HiberSessionFactory.closeSession();
		}		
		
		return flag;
	}

}
