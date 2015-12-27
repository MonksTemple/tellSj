package tell.server.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import tell.server.dao.TeamDao;
import tell.server.hiberUtil.HiberSessionFactory;
import tell.server.model.Activity;
import tell.server.model.Team;
import tell.server.model.User;

public class TeamDaoImpl implements TeamDao{

	@Override
	public Boolean addTeam(Team team) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean flag = true;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			session.save(team);
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
	public Boolean updateTeam(Team team) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean flag = true;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			session.update(team);
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
	public Boolean deleteTeam(int tId) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean flag = true;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction(); 
			Team team = (Team) session.get(Team.class, tId);
			session.delete(team);
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
	public Boolean deleteMember(int tId, int userId) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean flag = true;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction(); 
			Team team = (Team) session.get(Team.class, tId);
			User user = (User)session.get(User.class, userId);
			team.getMembers().remove(user);
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
	public Boolean addMember(int tId, int userId) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean flag = true;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction(); 
			Team team = (Team) session.get(Team.class, tId);
			User user = (User)session.get(User.class, userId);
			team.getMembers().add(user);
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
	public Set<User> getMembers(int tId) {
		// TODO Auto-generated method stub
		Set<User> members = null;
		Session session = null;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			Team team = (Team) session.load(Team.class,tId);
			if(team != null){
				members = team.getMembers();
			}
			session.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			HiberSessionFactory.closeSession();	
		}
		
		return members;	
	}


	@Override
	public Boolean deleteTeams(int userId) {
		// TODO Auto-generated method stub
		Session session = null;
		Boolean flag = true;
		try{
			session = HiberSessionFactory.getSession();  
			session.getTransaction().begin();
			String hql="delete from Team where userId="+userId;
			Query query=session.createQuery(hql);
			query.executeUpdate();
			session.getTransaction().commit();
		}catch(Exception e){
			flag = false;
			e.printStackTrace();
		}
		finally{
			HiberSessionFactory.closeSession();
		}	
		
		return flag;
	}

	@Override
	public Set<Team> getTeams(int userId) {
		// TODO Auto-generated method stub
		Set<Team> teams = null;
		Session session = null;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			User user = (User) session.load(Team.class,userId);
			if(user != null){
				teams = user.getcTeams();
			}
			session.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			HiberSessionFactory.closeSession();	
		}
		
		return teams;	
	}
	
	@Override
	public Set<Team> getAllTeams() {
		// TODO Auto-generated method stub
		Set<Team> teams = null;
		Session session = null;
		try{
			session = HiberSessionFactory.getSession();  
			session.getTransaction().begin();
			String hql="from Team";
			Query query=session.createQuery(hql);
			query.executeUpdate();
			
			teams = new HashSet<Team>();
			teams.addAll((List<Team>)query.list());
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			HiberSessionFactory.closeSession();
		}	
		
		return teams;
	}
	
}
