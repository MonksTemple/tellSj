package tell.server.dao.impl;

import org.hibernate.Session;

import tell.server.dao.UserDao;
import tell.server.hiberUtil.HiberSessionFactory;
import tell.server.model.User;

/**
 * 
 * 用户类dao实现
 */
public class UserDaoImpl implements UserDao{

	/*
	 * 
	 * 从数据库中判断指定用户是否存在
	 * @param user
	 * @return 如果用户存在，返回user类对象，否则返回null
	 * @see tell.server.dao.UserDao#exist(tell.server.model.User)
	 */
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
		    //HiberSessionFactory.closeSession();
		}
		
		if(temp==null||!temp.getPassword().equals(user.getPassword())){
			return null;
		}
		return new User(temp);
	}

	/*
	 * 
	 * 向数据库中添加用户
	 * @param user
	 * @return true--添加成功，false--添加失败
	 * @see tell.server.dao.UserDao#addUser(tell.server.model.User)
	 */
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
		    //HiberSessionFactory.closeSession();
		}				
		
		return flag;
	}

	/*
	 * 
	 * 修改数据库中的用户信息
	 * @param user
	 * @return true--修改成功，false--修改失败
	 * @see tell.server.dao.UserDao#updateUser(tell.server.model.User)
	 */
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
		    //HiberSessionFactory.closeSession();
		}			
		
		return flag;
	}

	/*
	 * 
	 * 从数据库中删除指定用户的信息
	 * 删除用户的时候，会删除掉所有对应的团队成员和活动成员记录         
	 *---注：调用此方法前要调用 TeamDaoImpl 中的deleteTeam，先删除所有其创建的团队；
	 *      调用 NotificationDaoImpl 中的deleteNotification，先删除所有其所有的通知信息；
	 * @param userId
	 * @return true--删除成功，false--删除失败
	 * @see tell.server.dao.UserDao#deleteUser(int)
	 */
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
		    //HiberSessionFactory.closeSession();
		}		
		
		return flag;
	}

}
