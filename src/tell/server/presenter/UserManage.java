package tell.server.presenter;

import java.util.Iterator;
import java.util.Set;

import tell.server.dao.*;
import tell.server.dao.impl.*;
import tell.server.model.Team;
import tell.server.model.User;

/**
 * 
 * �û��ദ��
 */
public class UserManage {
	/**
	 * 
	 * �û�ע��
	 * @param user
	 * @return true--ע��ɹ���false--ע��ʧ��
	 */
	public boolean register(User user) {
		UserDao userDao = new UserDaoImpl();
		userDao.addUser(user);
		
		return true;
	}
	
	/**
	 * 
	 * �û���½
	 * @param user
	 * @return ��½�ɹ����ص�ǰUser����󣬷��򷵻�null
	 */
	public User login(User user){
		User ret = null;
		UserDao userDao = new UserDaoImpl();
		ret = userDao.exist(user);
		return ret;
	}
	
	/**
	 * 
	 * �û�ע��
	 * @param userId
	 * @return true--ע���ɹ���false--ע��ʧ��
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
	 * �޸��û�ϸ��Щ
	 * @param user
	 * @return true--�޸ĳɹ���false--�޸�ʧ��
	 */
	public boolean modify(User user){
		UserDao userDao = new UserDaoImpl();
		userDao.updateUser(user);
		return true;
	}
}
