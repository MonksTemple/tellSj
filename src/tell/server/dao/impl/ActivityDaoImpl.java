package tell.server.dao.impl;

import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import tell.server.dao.ActivityDao;
import tell.server.hiberUtil.HiberSessionFactory;
import tell.server.model.Activity;
import tell.server.model.Team;
import tell.server.model.User;

public class ActivityDaoImpl implements ActivityDao{

	@Override
	public void addActivity(Activity activity) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			session.save(activity);
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
	public void updateActivity(Activity activity) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			session.update(activity);
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
	public void deleteActivity(int aId) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction(); 
			Activity activity = (Activity) session.get(Activity.class, aId);
			session.delete(activity);
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
	public void deleteParticipant(int aId, int userId) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction(); 
			Activity activity = (Activity) session.get(Activity.class, aId);
			User user = (User)session.get(User.class, userId);
			activity.getParticipants().remove(user);
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
	public void addParticipant(int aId, int userId) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction(); 
			Activity activity = (Activity) session.get(Activity.class, aId);
			User user = (User)session.get(User.class, userId);
			activity.getParticipants().add(user);
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
	public Set<User> getParticipants(int aId) {
		// TODO Auto-generated method stub
		Set<User> participants = null;
		Session session = null;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			Activity activity = (Activity) session.load(Activity.class,aId);
			if(activity != null){
				participants = activity.getParticipants();
			}
			session.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			HiberSessionFactory.closeSession();	
		}
		
		return participants;	
	}

	
	@Override
	public void deleteActivites(int tId) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = HiberSessionFactory.getSession();  
			session.getTransaction().begin();
			String hql="delete from Activity where tId="+tId;
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

	@Override
	public Set<Activity> getActivites(int userId) {
		// TODO Auto-generated method stub
		Set<Activity> activites = null;
		Session session = null;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			User user = (User) session.load(Team.class,userId);
			if(user != null){
				activites = user.getActivities();
			}
			session.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			HiberSessionFactory.closeSession();	
		}
		
		return activites;	
	}

	@Override
	public Set<Activity> getActivities(int tId) {
		// TODO Auto-generated method stub
		Set<Activity> activities = null;
		Session session = null;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			Team team = (Team) session.load(Team.class,tId);
			if(team != null){
				activities = team.getActivities();
			}
			session.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			HiberSessionFactory.closeSession();	
		}
		
		return activities;	
	}

	@Override
	public Set<Activity> getIsolateActivites() {
		Set<Activity> activites = null;
		Session session = null;
		try{
			session = HiberSessionFactory.getSession();  
			session.getTransaction().begin();
			String hql="from Activity where type =4";
			Query query=session.createQuery(hql);
			activites = (Set<Activity>) query.list();
			session.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			HiberSessionFactory.closeSession();	
		}
		
		return activites;	
	}

}
