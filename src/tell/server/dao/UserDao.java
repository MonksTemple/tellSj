package tell.server.dao;
import tell.server.model.User;

public interface UserDao {
	
	//判断是否存在该用户
	public Boolean exist(User user);
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	//删除用户的时候，会删除掉所有对应的团队成员和活动成员记录         
	//---注：调用此方法前要调用 TeamDaoImpl 中的deleteTeam，先删除所有其创建的团队；
	//                    调用 NotificationDaoImpl 中的deleteNotification，先删除所有其所有的通知信息；
	public void deleteUser(int userId);
	

}
