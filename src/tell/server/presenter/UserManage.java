package tell.server.presenter;

import java.util.Iterator;
import java.util.Set;

import tell.server.dao.*;
import tell.server.dao.impl.*;
import tell.server.model.Team;
import tell.server.model.User;

/**
 * 
 * 用户类处理
 */
public class UserManage {
	/**
	 * 
	 * 用户注册
	 * @param user
	 * @return true--注册成功，false--注册失败
	 */
	public boolean register(User user) {
		UserDao userDao = new UserDaoImpl();
		userDao.addUser(user);
		
		return true;
	}
	
	/**
	 * 
	 * 用户登陆
	 * @param user
	 * @return 登陆成功返回当前User类对象，否则返回null
	 */
	public User login(User user){
		User ret = null;
		UserDao userDao = new UserDaoImpl();
		ret = userDao.exist(user);
		return ret;
	}
	
	/**
	 * 
	 * 用户注销
	 * @param userId
	 * @return true--注销成功，false--注销失败
	 */
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
	
	/**
	 * 
	 * 修改用户细腻些
	 * @param user
	 * @return true--修改成功，false--修改失败
	 */
	public boolean modify(User user){
		UserDao userDao = new UserDaoImpl();
		userDao.updateUser(user);
		return true;
	}
}
