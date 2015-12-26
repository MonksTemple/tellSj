package tell.server.presenter;

import java.util.Iterator;
import java.util.Set;

import tell.server.dao.*;
import tell.server.dao.impl.*;
import tell.server.model.Team;
import tell.server.model.User;

public class UserManage {
	public boolean register(User user) {
		UserDao userDao = new UserDaoImpl();
		userDao.addUser(user);
		
		return true;
	}
	
	public boolean login(User user){
		boolean ret = false;
		UserDao userDao = new UserDaoImpl();
		ret = userDao.exist(user);
		return ret;
	}
	
	public boolean logout(int userId){
		UserDao userDao = new UserDaoImpl();
		TeamDao teamDao = new TeamDaoImpl();
		Set<Team> set = teamDao.getTeams(userId);

		Iterator it=set.iterator();
		while(it.hasNext()){
			Team team = (Team) it.next();
			ActivityDao activityDao = new ActivityDaoImpl();
			activityDao.deleteActivites(team.gettId());
			teamDao.deleteTeam(team.gettId());
		}
		userDao.deleteUser(userId);
		return true;
	}
	
	public boolean modify(User user){
		UserDao userDao = new UserDaoImpl();
		userDao.updateUser(user);
		return true;
	}
}
