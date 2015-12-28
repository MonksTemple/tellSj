package tell.server.dao.impl;

import org.hibernate.Session;

import tell.server.dao.UserDao;
import tell.server.hiberUtil.HiberSessionFactory;
import tell.server.model.User;

/**
 * 
 * �û���daoʵ��
 */
public class UserDaoImpl implements UserDao{

	/*
	 * 
	 * �����ݿ����ж�ָ���û��Ƿ����
	 * @param user
	 * @return ����û����ڣ�����user����󣬷��򷵻�null
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
	 * �����ݿ�������û�
	 * @param user
	 * @return true--��ӳɹ���false--���ʧ��
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
	 * �޸����ݿ��е��û���Ϣ
	 * @param user
	 * @return true--�޸ĳɹ���false--�޸�ʧ��
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
	 * �����ݿ���ɾ��ָ���û�����Ϣ
	 * ɾ���û���ʱ�򣬻�ɾ�������ж�Ӧ���Ŷӳ�Ա�ͻ��Ա��¼         
	 *---ע�����ô˷���ǰҪ���� TeamDaoImpl �е�deleteTeam����ɾ�������䴴�����Ŷӣ�
	 *      ���� NotificationDaoImpl �е�deleteNotification����ɾ�����������е�֪ͨ��Ϣ��
	 * @param userId
	 * @return true--ɾ���ɹ���false--ɾ��ʧ��
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
