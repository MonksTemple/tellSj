package tell.server.dao;
import tell.server.model.User;

/**
 * �û���dao�ӿ�
 */
public interface UserDao {
	
	/**
	 * 
	 * �����ݿ����ж�ָ���û��Ƿ����
	 * @param user
	 * @return ����û����ڣ�����user����󣬷��򷵻�null
	 */
	public User exist(User user);
	
	/**
	 * 
	 * �����ݿ�������û�
	 * @param user
	 * @return true--��ӳɹ���false--���ʧ��
	 */
	public Boolean addUser(User user);
	
	/**
	 * 
	 * �޸����ݿ��е��û���Ϣ
	 * @param user
	 * @return true--�޸ĳɹ���false--�޸�ʧ��
	 */
	public Boolean updateUser(User user);
	
	/**
	 * 
	 * �����ݿ���ɾ��ָ���û�����Ϣ
	 * ɾ���û���ʱ�򣬻�ɾ�������ж�Ӧ���Ŷӳ�Ա�ͻ��Ա��¼         
	 *---ע�����ô˷���ǰҪ���� TeamDaoImpl �е�deleteTeam����ɾ�������䴴�����Ŷӣ�
	 *      ���� NotificationDaoImpl �е�deleteNotification����ɾ�����������е�֪ͨ��Ϣ��
	 * @param userId
	 * @return true--ɾ���ɹ���false--ɾ��ʧ��
	 */
	public Boolean deleteUser(int userId);
	

}
