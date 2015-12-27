package tell.server.dao;

import java.util.Set;

import tell.server.model.Activity;
import tell.server.model.Team;
import tell.server.model.User;

public interface TeamDao {

	//ע��������ŶӺͺͿγ���������֮ǰҪ�� activity.getTeam().setTeam()
	public Boolean addTeam(Team team);
	
	public Boolean updateTeam(Team team);
	
	//ɾ���Ŷӵ�ʱ�򣬻�ɾ�������еĳ�Ա��¼            
	//---ע�����ô˷���ǰҪ���� ActivityDaoImpl �е�deleteActivites����ɾ�������е��Ŷӻ
	public Boolean deleteTeam(int tId);
	
	//
	public Boolean deleteMember(int tId,int userId);
	
	public Boolean addMember(int tId,int userId);
	
	public Set<User> getMembers(int tId);

	//ɾ�����û����������е��Ŷ�
	public Boolean deleteTeams(int userId);
	
	public Set<Team> getTeams(int userId);

    public Set<Team> getAllTeams();
}
