package tell.server.dao;
import tell.server.model.User;

/**
 * 用户类dao接口
 */
public interface UserDao {
	
	/**
	 * 
	 * 从数据库中判断指定用户是否存在
	 * @param user
	 * @return 如果用户存在，返回user类对象，否则返回null
	 */
	public User exist(User user);
	
	/**
	 * 
	 * 向数据库中添加用户
	 * @param user
	 * @return true--添加成功，false--添加失败
	 */
	public Boolean addUser(User user);
	
	/**
	 * 
	 * 修改数据库中的用户信息
	 * @param user
	 * @return true--修改成功，false--修改失败
	 */
	public Boolean updateUser(User user);
	
	/**
	 * 
	 * 从数据库中删除指定用户的信息
	 * 删除用户的时候，会删除掉所有对应的团队成员和活动成员记录         
	 *---注：调用此方法前要调用 TeamDaoImpl 中的deleteTeam，先删除所有其创建的团队；
	 *      调用 NotificationDaoImpl 中的deleteNotification，先删除所有其所有的通知信息；
	 * @param userId
	 * @return true--删除成功，false--删除失败
	 */
	public Boolean deleteUser(int userId);
	

}
