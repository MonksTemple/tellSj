package tell.server.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import tell.server.dao.TeamDao;
import tell.server.hiberUtil.HiberSessionFactory;
import tell.server.model.Team;
import tell.server.model.User;

/**
 * 
 * �Ŷ���daoʵ��
 */
public class TeamDaoImpl implements TeamDao{

	/*
	 * 
	 * �����ݿ�������Ŷ�--������ŶӺͺͿγ���������֮ǰҪ�� activity.getTeam().setTeam()
	 * @param team
	 * @return true--��ӳɹ���false--���ʧ��
	 * @see tell.server.dao.TeamDao#addTeam(tell.server.model.Team)
	 */
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
		    //HiberSessionFactory.closeSession();
		}
		return flag;
	}

	/*
	 * 
	 * �޸����ݿ��е��Ŷ���Ϣ
	 * @param team
	 * @return true--�޸ĳɹ���false--�޸�ʧ��
	 * @see tell.server.dao.TeamDao#updateTeam(tell.server.model.Team)
	 */
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
		    //HiberSessionFactory.closeSession();
		}	
		
		return flag;
	}

	/*
	 * 
	 * �����Ŷ�idɾ���Ŷ���Ϣ<br/>
	 * ɾ���Ŷӵ�ʱ�򣬻�ɾ�������еĳ�Ա��¼      <br/>      
	 * ---ע�����ô˷���ǰҪ���� ActivityDaoImpl �е�deleteActivites����ɾ�������е��Ŷӻ
	 * @param tId
	 * @return true--ɾ���ɹ���false--ɾ��ʧ��
	 * @see tell.server.dao.TeamDao#deleteTeam(int)
	 */
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
		    //HiberSessionFactory.closeSession();
		}	
		
		return flag;
	}

	/*
	 * 
	 * �����ݿ���ɾ���Ŷ��г�Ա --����ָ�����Ŷ�id���û�id
	 * @param tId
	 * @param userId
	 * @return true--ɾ���ɹ���false--ɾ��ʧ��
	 * @see tell.server.dao.TeamDao#deleteMember(int, int)
	 */
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
		    //HiberSessionFactory.closeSession();
		}	
		
		return flag;
	}

	/*
	 * 
	 * �����ݿ�����Ŷӳ�Ա--����ָ�����Ŷ�id���û�id
	 * @param tId
	 * @param userId
	 * @return true--��ӳɹ���false--���ʧ��
	 * @see tell.server.dao.TeamDao#addMember(int, int)
	 */
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
		    //HiberSessionFactory.closeSession();
		}	
		return flag;
	}

	/*
	 * 
	 * �����ݿ��и����Ŷ�id���ָ���Ŷӵ��û���Ա
	 * @param tId
	 * @return �Ŷӳ�Ա�б�
	 * @see tell.server.dao.TeamDao#getMembers(int)
	 */
	@Override
	public Set<User> getMembers(int tId) {
		// TODO Auto-generated method stub
		Set<User> members = null;
		Set<User> tempMembers = null;
		Session session = null;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			Team team = (Team) session.load(Team.class,tId);
			if(team != null){
				tempMembers = team.getMembers();
				members = new HashSet<User>();
				for(User user:tempMembers){
					members.add(new User(user));
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
		
		return members;	
	}


	/*
	 * 
	 * �����ݿ���ɾ��ָ���û��������������Ŷ�
	 * TODO
	 * @param userId
	 * @return true--ɾ���ɹ���false--ɾ��ʧ��
	 * @see tell.server.dao.TeamDao#deleteTeams(int)
	 */
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
			//HiberSessionFactory.closeSession();
		}	
		
		return flag;
	}

	/*
	 * 
	 * �����ݿ��л���ö��û��������Ŷ�
	 * @param userId
	 * @return �Ŷ��б�
	 * @see tell.server.dao.TeamDao#getTeams(int)
	 */
	@Override
	public Set<Team> getTeams(int userId) {
		// TODO Auto-generated method stub
		Set<Team> teams = null;
		Set<Team> tempTeams = null;
		Session session = null;
		try{
			session = HiberSessionFactory.getSession(); 
			session.beginTransaction();  
			User user = (User) session.load(Team.class,userId);
			if(user != null){
				teams = new HashSet<Team>();
				tempTeams = user.getcTeams();
				for(Team team: tempTeams){
					teams.add(new Team(team));
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
		
		return teams;	
	}
	
	/*
	 * 
	 * �����ݿ��л�����е��Ŷ���Ϣ
	 * @return �Ŷ��б�
	 * @see tell.server.dao.TeamDao#getAllTeams()
	 */
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
			//query.executeUpdate();
			
			teams = new HashSet<Team>();
			for(Team team:(List<Team>)query.list()){
				teams.add(new Team(team));
			}
//			teams.addAll((List<Team>)query.list());
			
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//HiberSessionFactory.closeSession();
		}	
		
		return teams;
	}
	
}
