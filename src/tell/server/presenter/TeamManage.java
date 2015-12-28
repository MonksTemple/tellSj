package tell.server.presenter;

import java.util.Set;
import tell.server.dao.ActivityDao;
import tell.server.dao.TeamDao;
import tell.server.dao.impl.ActivityDaoImpl;
import tell.server.dao.impl.TeamDaoImpl;
import tell.server.model.*;

/**
 * 
 * 团队类处理
 */
public class TeamManage {

	/**
	 * 
	 * 创建团队
	 * @param team
	 * @return true--创建成功，false--创建失败
 	 */
	public Boolean createTeam(Team team){
		TeamDao teamDao = new TeamDaoImpl();
		return teamDao.addTeam(team);
	}
	
	/**
	 * 
	 * 添加团队成员--根据指定的团队id和用户id
	 * @param tId
	 * @param userId
	 * @return true--添加成功，false--添加失败
	 */
	public Boolean addMember(int tId,int userId){
		TeamDao teamDao = new TeamDaoImpl();
		return teamDao.addMember(tId, userId);
	}
	
	/**
	 * 
	 * 修改团队信息
	 * @param team
	 * @return true--修改成功，false--修改失败
	 */
	public Boolean modifyInfo(Team team){
		TeamDao teamDao = new TeamDaoImpl();
		return teamDao.updateTeam(team);
	}
	
	/**
	 * 
	 * 删除团队信息--根据指定的团队id
	 * @param tId
	 * @return true--删除成功，false--删除失败
	 */
	public Boolean deleteTeam(int tId){
		TeamDao teamDao = new TeamDaoImpl();
		ActivityDao activityDao = new ActivityDaoImpl();
		activityDao.deleteActivites(tId);
		return teamDao.deleteTeam(tId);
		
	}
	
	/**
	 * 
	 * 显示团队列表
	 * @return 团队列表
	 */
	public Set<Team> ShowTeamList(){ 
		TeamDao teamDao = new TeamDaoImpl();
		return teamDao.getAllTeams();
		
	}
	
	/**
	 * 
	 * 删除团队成员--根据指定的团队id和用户id
	 * @param tId
	 * @param userId
	 * @return true--删除成功，false--删除失败
	 */
	public Boolean deleteMember(int tId,int userId){
		TeamDao teamDao = new TeamDaoImpl();
		return teamDao.deleteMember(tId, userId);
	}
	
	/**
	 * 
	 * 显示团队成员列表
	 * @param tId
	 * @return 团队成员列表
	 */
	public Set<User> showMemberList(int tId){
		TeamDao teamDao = new TeamDaoImpl();
		return teamDao.getMembers(tId);
		
	}
	
	
}
