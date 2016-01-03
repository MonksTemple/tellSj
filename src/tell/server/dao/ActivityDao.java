package tell.server.dao;

import java.util.Set;

import tell.server.model.Activity;
import tell.server.model.User;

/**
 * 
 * ���dao�����ӿ�
 */
public interface ActivityDao {

	/**
	 * 
	 * �����ݿ�����ӻ��Ϣ
	 * @param activity
	 * @return true-��ӻ�ɹ���false--��ӻʧ��
	 */
	public Boolean addActivity(Activity activity);
	
	/**
	 *
	 * �޸����ݿ��еĻ��Ϣ
	 * @param activity
	 * @return true-�޸Ļ�ɹ���false--�޸Ļʧ��
	 */
	public Boolean updateActivity(Activity activity);
	
	/**
	 * �����ݿ���ɾ�����Ϣ
	 * @param aId
	 * @return true-ɾ���ɹ���false-ɾ��ʧ��
	 */
	public Boolean deleteActivity(int aId);

	/**
	 * 
	 * �����ݿ���ɾ���������
	 * @param aId
	 * @param userId
	 * @return true-ɾ���ɹ���false-ɾ��ʧ��
	 */
	public Boolean deleteParticipant(int aId,int userId);
	
	/**
	 * 
	 * �����ݿ�����ӻ��Ա
	 * @param aId
	 * @param userId
	 * @return true-��ӳɹ���false-���ʧ��
	 */
	public Boolean addParticipant(int aId,int userId);
	
	/**
	 * 
	 * �����ݿ��л�û�Ĳ�����Ա
	 * @param aId
	 * @return �������Ա�б�
	 */
	public Set<User> getParticipants(int aId);
	
	/**
	 * 
	 * �����ݿ���ɾ��ָ���ŶӵĻ
	 * @param tId
	 * @return true-ɾ���ɹ���false-ɾ��ʧ��
	 */
	public Boolean deleteActivites(int tId);
	
	/**
	 * 
	 * �����û�id�õ����û�����Ļ�б�
	 * @param userId
	 * @return ��б�
	 */
	public Set<Activity> getActivites(int userId);
	
	/**
	 * 
	 * �õ����˻�б�
	 * @return ��б�
	 */
	public Set<Activity> getIsolateActivites();
	
	/**
	 * 
	 * �õ��ŶӾٰ�Ļ�б�
	 * @param tId
	 * @return ��б�
	 */
	public Set<Activity> getActivities(int tId);
	
	/**
	 * 
	 * �õ����еĻ
	 * @param 
	 * @return ��б�
	 */
	public Set<Activity> getActivities();
}
