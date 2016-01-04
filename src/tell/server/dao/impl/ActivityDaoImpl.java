package tell.server.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import tell.server.dao.ActivityDao;
import tell.server.hiberUtil.HiberSessionFactory;
import tell.server.model.Activity;
import tell.server.model.Team;
import tell.server.model.User;

/**
 * 
 * ���daoʵ����
 */
public class ActivityDaoImpl implements ActivityDao{

	/*
	 * �����ݿ�����ӻ��Ϣ
	 * @param activity
	 * @return  true-��ӻ�ɹ���false--��ӻʧ��
	 * @see tell.server.dao.ActivityDao#addActivity(tell.server.model.Activity)
	 */
	@Override
	public Boolean addActivity(Activity activity) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean flag = true;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			session.save(activity);
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
	 * �޸����ݿ��еĻ��Ϣ
	 * @param activity
	 * @return true-�޸Ļ�ɹ���false--�޸Ļʧ��
	 * @see tell.server.dao.ActivityDao#updateActivity(tell.server.model.Activity)
	 */
	@Override
	public Boolean updateActivity(Activity activity) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean flag = true;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			session.update(activity);
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
	 * �����ݿ���ɾ�����Ϣ
	 * @param aId
	 * @return true-ɾ���ɹ���false-ɾ��ʧ��
	 * @see tell.server.dao.ActivityDao#deleteActivity(int)
	 */
	@Override
	public Boolean deleteActivity(int aId) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean flag = true;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction(); 
			Activity activity = (Activity) session.get(Activity.class, aId);
			session.delete(activity);
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
	 * �����ݿ���ɾ���������
	 * @param aId
	 * @param userId
	 * @return true-ɾ���ɹ���false-ɾ��ʧ��
	 * @see tell.server.dao.ActivityDao#deleteParticipant(int, int)
	 */
	@Override
	public Boolean deleteParticipant(int aId, int userId) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean flag = true;
		
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction(); 
			Activity activity = (Activity) session.get(Activity.class, aId);
			User user = (User)session.get(User.class, userId);
			activity.getParticipants().remove(user);
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

	/*
	 * 
	 * �����ݿ�����ӻ��Ա
	 * @param aId
	 * @param userId
	 * @return true-��ӳɹ���false-���ʧ��
	 * @see tell.server.dao.ActivityDao#addParticipant(int, int)
	 */
	@Override
	public Boolean addParticipant(int aId, int userId) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean flag = true;
		
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction(); 
			Activity activity = (Activity) session.get(Activity.class, aId);
			User user = (User)session.get(User.class, userId);
			activity.getParticipants().add(user);
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
	 * �����ݿ��л�û�Ĳ�����Ա
	 * @param aId
	 * @return �������Ա�б�
	 * @see tell.server.dao.ActivityDao#getParticipants(int)
	 */
	@Override
	public Set<User> getParticipants(int aId) {
		// TODO Auto-generated method stub
		Set<User> participants = null;
		Set<User> tempUsers = null;
		Session session = null;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			Activity activity = (Activity) session.load(Activity.class,aId);
			if(activity != null){
				participants = new HashSet<User>();
				tempUsers = activity.getParticipants();
				for(User user:tempUsers){
					participants.add(new User(user));
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
		
		return participants;	
	}

	/*
	 * 
	 * �����ݿ���ɾ��ָ���ŶӵĻ
	 * @param tId
	 * @return true-ɾ���ɹ���false-ɾ��ʧ��
	 * @see tell.server.dao.ActivityDao#deleteActivites(int)
	 */
	@Override
	public Boolean deleteActivites(int tId) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean flag = true;
		try{
			session = HiberSessionFactory.getSession();  
			session.getTransaction().begin();
			String hql="delete from Activity where tId="+tId;
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

	/*
	 * 
	 * �����û�id�õ����û�����Ļ�б�
	 * @param userId
	 * @return ��б�
	 * @see tell.server.dao.ActivityDao#getActivites(int)
	 */
	@Override
	public Set<Activity> getActivites(int userId) {
		// TODO Auto-generated method stub
		Set<Activity> activites = null;
		Set<Activity> tempActs = null;
		Session session = null;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			User user = (User) session.load(User.class,userId);
			if(user != null){
				activites = new HashSet<Activity>();
				tempActs = user.getActivities();
				for(Activity act:tempActs){
					activites.add(new Activity(act));
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
		
		return activites;	
	}

	/*
	 * 
	 * �õ��ŶӾٰ�Ļ�б�
	 * @param tId
	 * @return ��б�
	 * @see tell.server.dao.ActivityDao#getActivities(int)
	 */
	@Override
	public Set<Activity> getActivities(int tId) {
		// TODO Auto-generated method stub
		Set<Activity> activities = null;
		Set<Activity> tempActs = null;
		Session session = null;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			Team team = (Team) session.load(Team.class,tId);
			if(team != null){
				tempActs = team.getActivities();
				activities = new HashSet<Activity>();
				for(Activity act:tempActs){
					activities.add(new Activity(act));
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
		
		return activities;	
	}

	/*
	 * 
	 * �õ����˻�б�
	 * @return ��б�
	 * @see tell.server.dao.ActivityDao#getIsolateActivites()
	 */
	public Set<Activity> getIsolateActivites() {
		Set<Activity> activites = null;
		Session session = null;
		try{
			session = HiberSessionFactory.getSession();  
			session.getTransaction().begin();
			String hql="from Activity where type =4";
			Query query=session.createQuery(hql);

			activites = new HashSet<Activity>();
			for(Activity act:(List<Activity>)query.list()){
				activites.add(new Activity(act));
			}
			session.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//HiberSessionFactory.closeSession();	
		}
		
		return activites;	
	}

	/*
	 * �õ����еĻ
	 * @return 
	 * @see tell.server.dao.ActivityDao#getActivities()
	 */
	@Override
	public Set<Activity> getActivities() {
		// TODO Auto-generated method stub
		Set<Activity> activites = null;
		Session session = null;
		try{
			session = HiberSessionFactory.getSession();  
			session.getTransaction().begin();
			String hql="from Activity";
			Query query=session.createQuery(hql);

			activites = new HashSet<Activity>();
			for(Activity act:(List<Activity>)query.list()){
				if(act.getType() != 3){
					activites.add(new Activity(act));
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
		
		return activites;	
	}


}
