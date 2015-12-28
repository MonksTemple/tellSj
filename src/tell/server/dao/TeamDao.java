package tell.server.dao;

import java.util.Set;

import tell.server.model.Activity;
import tell.server.model.Team;
import tell.server.model.User;

/**
 * 
 * 团队类dao接口
 */
public interface TeamDao {

	/**
	 * 
	 * 向数据库中添加团队--如果是团队和和课程组活动，调用之前要先 activity.getTeam().setTeam()
	 * @param team
	 * @return true--添加成功，false--添加失败
	 */
	public Boolean addTeam(Team team);
	
	/**
	 * 
	 * 修改数据库中的团队信息
	 * @param team
	 * @return true--修改成功，false--修改失败
	 */
	public Boolean updateTeam(Team team);
	
	/**
	 * 
	 * 根据团队id删除团队信息<br/>
	 * 删除团队的时候，会删除掉所有的成员记录      <br/>      
	 * ---注：调用此方法前要调用 ActivityDaoImpl 中的deleteActivites，先删除其所有的团队活动
	 * @param tId
	 * @return true--删除成功，false--删除失败
	 */
	public Boolean deleteTeam(int tId);
	
	/**
	 * 
	 * 从数据库中删除团队中成员 --根据指定的团队id和用户id
	 * @param tId
	 * @param userId
	 * @return true--删除成功，false--删除失败
	 */
	public Boolean deleteMember(int tId,int userId);
	
	/**
	 * 
	 * 向数据库添加团队成员--根据指定的团队id和用户id
	 * @param tId
	 * @param userId
	 * @return true--添加成功，false--添加失败
	 */
	public Boolean addMember(int tId,int userId);
	
	/**
	 * 
	 * 从数据库中根据团队id获得指定团队的用户成员
	 * @param tId
	 * @return 团队成员列表
	 */
	public Set<User> getMembers(int tId);

	/**
	 * 从数据库中删除指定用户所创建的所有团队
	 * TODO
	 * @param userId
	 * @return true--删除成功，false--删除失败
	 */
	public Boolean deleteTeams(int userId);
	
	/**
	 * 
	 * 从数据库中获得置顶用户的所有团队
	 * @param userId
	 * @return 团队列表
	 */
	public Set<Team> getTeams(int userId);

	/**
	 * 
	 * 从数据库中获得所有的团队信息
	 * @return 团队列表
	 */
    public Set<Team> getAllTeams();
}
