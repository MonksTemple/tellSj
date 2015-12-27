package tell.server.dao;
import tell.server.model.User;

public interface UserDao {
	
	//�ж��Ƿ���ڸ��û�
	public User exist(User user);
	
	public Boolean addUser(User user);
	
	public Boolean updateUser(User user);
	
	//ɾ���û���ʱ�򣬻�ɾ�������ж�Ӧ���Ŷӳ�Ա�ͻ��Ա��¼         
	//---ע�����ô˷���ǰҪ���� TeamDaoImpl �е�deleteTeam����ɾ�������䴴�����Ŷӣ�
	//                    ���� NotificationDaoImpl �е�deleteNotification����ɾ�����������е�֪ͨ��Ϣ��
	public Boolean deleteUser(int userId);
	

}
