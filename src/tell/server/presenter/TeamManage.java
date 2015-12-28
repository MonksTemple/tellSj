package tell.server.presenter;

import java.util.Set;
import tell.server.dao.ActivityDao;
import tell.server.dao.TeamDao;
import tell.server.dao.impl.ActivityDaoImpl;
import tell.server.dao.impl.TeamDaoImpl;
import tell.server.model.*;

/**
 * 
 * �Ŷ��ദ��
 */
public class TeamManage {

	/**
	 * 
	 * �����Ŷ�
	 * @param team
	 * @return true--�����ɹ���false--����ʧ��
 	 */
	public Boolean createTeam(Team team){
		TeamDao teamDao = new TeamDaoImpl();
		return teamDao.addTeam(team);
	}
	
	/**
	 * 
	 * ����Ŷӳ�Ա--����ָ�����Ŷ�id���û�id
	 * @param tId
	 * @param userId
	 * @return true--��ӳɹ���false--���ʧ��
	 */
	public Boolean addMember(int tId,int userId){
		TeamDao teamDao = new TeamDaoImpl();
		return teamDao.addMember(tId, userId);
	}
	
	/**
	 * 
	 * �޸��Ŷ���Ϣ
	 * @param team
	 * @return true--�޸ĳɹ���false--�޸�ʧ��
	 */
	public Boolean modifyInfo(Team team){
		TeamDao teamDao = new TeamDaoImpl();
		return teamDao.updateTeam(team);
	}
	
	/**
	 * 
	 * ɾ���Ŷ���Ϣ--����ָ�����Ŷ�id
	 * @param tId
	 * @return true--ɾ���ɹ���false--ɾ��ʧ��
	 */
	public Boolean deleteTeam(int tId){
		TeamDao teamDao = new TeamDaoImpl();
		ActivityDao activityDao = new ActivityDaoImpl();
		activityDao.deleteActivites(tId);
		return teamDao.deleteTeam(tId);
		
	}
	
	/**
	 * 
	 * ��ʾ�Ŷ��б�
	 * @return �Ŷ��б�
	 */
	public Set<Team> ShowTeamList(){ 
		TeamDao teamDao = new TeamDaoImpl();
		return teamDao.getAllTeams();
		
	}
	
	/**
	 * 
	 * ɾ���Ŷӳ�Ա--����ָ�����Ŷ�id���û�id
	 * @param tId
	 * @param userId
	 * @return true--ɾ���ɹ���false--ɾ��ʧ��
	 */
	public Boolean deleteMember(int tId,int userId){
		TeamDao teamDao = new TeamDaoImpl();
		return teamDao.deleteMember(tId, userId);
	}
	
	/**
	 * 
	 * ��ʾ�Ŷӳ�Ա�б�
	 * @param tId
	 * @return �Ŷӳ�Ա�б�
	 */
	public Set<User> showMemberList(int tId){
		TeamDao teamDao = new TeamDaoImpl();
		return teamDao.getMembers(tId);
		
	}
	
	
}
