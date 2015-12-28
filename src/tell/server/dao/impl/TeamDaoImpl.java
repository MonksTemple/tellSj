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
 * 团队类dao实现
 */
public class TeamDaoImpl implements TeamDao{

	/*
	 * 
	 * 向数据库中添加团队--如果是团队和和课程组活动，调用之前要先 activity.getTeam().setTeam()
	 * @param team
	 * @return true--添加成功，false--添加失败
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
	 * 修改数据库中的团队信息
	 * @param team
	 * @return true--修改成功，false--修改失败
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
	 * 根据团队id删除团队信息<br/>
	 * 删除团队的时候，会删除掉所有的成员记录      <br/>      
	 * ---注：调用此方法前要调用 ActivityDaoImpl 中的deleteActivites，先删除其所有的团队活动
	 * @param tId
	 * @return true--删除成功，false--删除失败
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
	 * 从数据库中删除团队中成员 --根据指定的团队id和用户id
	 * @param tId
	 * @param userId
	 * @return true--删除成功，false--删除失败
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
	 * 向数据库添加团队成员--根据指定的团队id和用户id
	 * @param tId
	 * @param userId
	 * @return true--添加成功，false--添加失败
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
	 * 从数据库中根据团队id获得指定团队的用户成员
	 * @param tId
	 * @return 团队成员列表
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
	 * 从数据库中删除指定用户所创建的所有团队
	 * TODO
	 * @param userId
	 * @return true--删除成功，false--删除失败
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
	 * 从数据库中获得置顶用户的所有团队
	 * @param userId
	 * @return 团队列表
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
	 * 从数据库中获得所有的团队信息
	 * @return 团队列表
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
