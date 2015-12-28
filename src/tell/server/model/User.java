package tell.server.model;
import java.util.HashSet;
import java.util.Set;

/**
 * �û���Ϣ��
 */
public class User {

	/**�û�id*/
	private int userId;        
	/**�û���*/
	private String userName;  
	/**�û�����*/
	private String password;   
	/**�ֻ�����*/
	private String phoneno;    
	/**���û������е�֪ͨ��*/
	private Set notifications = new HashSet();  
	/**���û����������е��Ŷ�*/
	private Set cTeams = new HashSet();          
	/**���û��μӵ����еĻ----�����û����ճ̣�����������ɵĺ�δ��ɵģ�*/
	private Set activities = new HashSet();     
	/**���û���������е��Ŷ�*/
	private Set jTeams = new HashSet();         
	
	/**
	 * Ĭ�Ϲ��캯�� 
	 */
	public User(){
		this.userId = 0;
		this.userName = "";
		this.password = "";
		this.phoneno = "";
		this.notifications = null;
		this.cTeams = null;
		this.activities = null;
		this.jTeams = null;		
	}
	
	/**
	 * �������е�user����һ���µ�User�����
	 * @param user
	 */
	public User(User user){
		this.userId = user.getUserId();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.phoneno = user.getPhoneno();
		this.notifications = null;
		this.cTeams = null;
		this.activities = null;
		this.jTeams = null;
	}
	
	/**
	 * ����û���Id
	 * @return �û���Id
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * �����û�Id
	 * @param userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * ����û���
	 * @return �û���
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * �����û���
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * �õ��û�����
	 * @return �û�����
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * �����û�����
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * �õ��û����ֻ���
	 * @return �û��ֻ���
	 */
	public String getPhoneno() {
		return phoneno;
	}
	
	/**
	 * �����û����ֻ���
	 * @param phoneno
	 */
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	/**
	 * �õ��û���֪ͨ��
	 * @return �û���֪ͨ��
	 */
	public Set getNotifications() {
		return notifications;
	}
	
	/**
	 * �����û���֪ͨ��
	 * @param notifications
	 */
	public void setNotifications(Set notifications) {
		this.notifications = notifications;
	}
	
	/**
	 * �õ�����б�
	 * @return ��б�
	 */
	public Set getActivities() {
		return activities;
	}
	
	/**
	 * ���û��
	 * @param activities
	 */
	public void setActivities(Set activities) {
		this.activities = activities;
	}
	
	/**
	 * ����û��������Ŷ���Ϣ
	 * @return �û��������Ŷ���Ϣ
	 */
	public Set getjTeams() {
		return jTeams;
	}
	
	/**
	 * ���һ���û��������Ŷ�
	 * @param jTeams
	 */
	public void setjTeams(Set jTeams) {
		this.jTeams = jTeams;
	}
	
	/**
	 * ����û��μӵ��Ŷ���Ϣ
	 * @return �û��μ����Ŷ���Ϣ
	 */
	public Set getcTeams() {
		return cTeams;
	}
	
	/**
	 * �����û��μӵ��Ŷ�
	 * @param cTeams
	 */
	public void setcTeams(Set cTeams) {
		this.cTeams = cTeams;
	}
}
