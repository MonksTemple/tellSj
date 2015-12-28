package tell.server.dao;

import java.util.Set;

import tell.server.model.Activity;
import tell.server.model.Team;
import tell.server.model.User;

/**
 * 
 * �Ŷ���dao�ӿ�
 */
public interface TeamDao {

	/**
	 * 
	 * �����ݿ�������Ŷ�--������ŶӺͺͿγ���������֮ǰҪ�� activity.getTeam().setTeam()
	 * @param team
	 * @return true--��ӳɹ���false--���ʧ��
	 */
	public Boolean addTeam(Team team);
	
	/**
	 * 
	 * �޸����ݿ��е��Ŷ���Ϣ
	 * @param team
	 * @return true--�޸ĳɹ���false--�޸�ʧ��
	 */
	public Boolean updateTeam(Team team);
	
	/**
	 * 
	 * �����Ŷ�idɾ���Ŷ���Ϣ<br/>
	 * ɾ���Ŷӵ�ʱ�򣬻�ɾ�������еĳ�Ա��¼      <br/>      
	 * ---ע�����ô˷���ǰҪ���� ActivityDaoImpl �е�deleteActivites����ɾ�������е��Ŷӻ
	 * @param tId
	 * @return true--ɾ���ɹ���false--ɾ��ʧ��
	 */
	public Boolean deleteTeam(int tId);
	
	/**
	 * 
	 * �����ݿ���ɾ���Ŷ��г�Ա --����ָ�����Ŷ�id���û�id
	 * @param tId
	 * @param userId
	 * @return true--ɾ���ɹ���false--ɾ��ʧ��
	 */
	public Boolean deleteMember(int tId,int userId);
	
	/**
	 * 
	 * �����ݿ�����Ŷӳ�Ա--����ָ�����Ŷ�id���û�id
	 * @param tId
	 * @param userId
	 * @return true--��ӳɹ���false--���ʧ��
	 */
	public Boolean addMember(int tId,int userId);
	
	/**
	 * 
	 * �����ݿ��и����Ŷ�id���ָ���Ŷӵ��û���Ա
	 * @param tId
	 * @return �Ŷӳ�Ա�б�
	 */
	public Set<User> getMembers(int tId);

	/**
	 * �����ݿ���ɾ��ָ���û��������������Ŷ�
	 * TODO
	 * @param userId
	 * @return true--ɾ���ɹ���false--ɾ��ʧ��
	 */
	public Boolean deleteTeams(int userId);
	
	/**
	 * 
	 * �����ݿ��л���ö��û��������Ŷ�
	 * @param userId
	 * @return �Ŷ��б�
	 */
	public Set<Team> getTeams(int userId);

	/**
	 * 
	 * �����ݿ��л�����е��Ŷ���Ϣ
	 * @return �Ŷ��б�
	 */
    public Set<Team> getAllTeams();
}
