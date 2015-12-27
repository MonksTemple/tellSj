package tell.server.dao;

import java.util.Set;

import tell.server.model.Activity;
import tell.server.model.Team;
import tell.server.model.User;

public interface TeamDao {

	//注：如果是团队和和课程组活动，调用之前要先 activity.getTeam().setTeam()
	public Boolean addTeam(Team team);
	
	public Boolean updateTeam(Team team);
	
	//删除团队的时候，会删除掉所有的成员记录            
	//---注：调用此方法前要调用 ActivityDaoImpl 中的deleteActivites，先删除其所有的团队活动
	public Boolean deleteTeam(int tId);
	
	//
	public Boolean deleteMember(int tId,int userId);
	
	public Boolean addMember(int tId,int userId);
	
	public Set<User> getMembers(int tId);

	//删除该用户创建的所有的团队
	public Boolean deleteTeams(int userId);
	
	public Set<Team> getTeams(int userId);

    public Set<Team> getAllTeams();
}
