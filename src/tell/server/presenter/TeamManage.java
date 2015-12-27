package tell.server.presenter;

import java.util.ArrayList;
import java.util.Set;

import tell.server.dao.ActivityDao;
import tell.server.dao.NotificationDao;
import tell.server.dao.TeamDao;
import tell.server.dao.impl.ActivityDaoImpl;
import tell.server.dao.impl.NotificationDaoImpl;
import tell.server.dao.impl.TeamDaoImpl;
import tell.server.model.*;

public class TeamManage {

	public void createTeam(Team team){
		TeamDao teamDao = new TeamDaoImpl();
		teamDao.addTeam(team);
	}
	public void addMember(int tId,int userId){
		TeamDao teamDao = new TeamDaoImpl();
		teamDao.addMember(tId, userId);
	}
	
	public void modifyInfo(Team team){
		TeamDao teamDao = new TeamDaoImpl();
		teamDao.updateTeam(team);
	}
	public void deleteTeam(int tId){
		TeamDao teamDao = new TeamDaoImpl();
		ActivityDao activityDao = new ActivityDaoImpl();
		activityDao.deleteActivites(tId);
		teamDao.deleteTeam(tId);
		
	}
	public Set<Team> ShowTeamList(){ 
		TeamDao teamDao = new TeamDaoImpl();
		return teamDao.getAllTeams();
		
	}
	public void deleteMember(int tId,int userId){
		TeamDao teamDao = new TeamDaoImpl();
		teamDao.deleteMember(tId, userId);
	}
	public Set<User> showMemberList(int tId){
		TeamDao teamDao = new TeamDaoImpl();
		return teamDao.getMembers(tId);
		
	}
	
	
}