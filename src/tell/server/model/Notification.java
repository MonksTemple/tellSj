package tell.server.model;

/**
 * 
 * ֪ͨ��
 */
public class Notification {

    /**֪ͨ�ı��*/
	private int nId;                
	 /**֪ͨ��Ϣ*/
	private String description;    
	 /**�Ƿ��Ѿ��Ķ���0��ʾδ����1��ʾ�Ѷ�*/
	private boolean state;           
	 /**�û�*/
	private User user;          
	
	/**
	 * ֪ͨ��Ĭ�Ϲ��캯��
	 */
	public Notification(){
		this.nId = 0;
		this.description ="";
		this.state = false;
		this.user = null;
	}
	
	/**
	 *
	 * @param notification
	 */
	public Notification(Notification notification){
		this.nId = notification.getnId();
		this.description = notification.getDescription();
		this.state = notification.getState();
		this.user = new User(notification.getUser());
	}
	
	/**
	 * 
	 * ���֪ͨ������
	 * @return ֪ͨ����
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * 
	 * ����֪ͨ����
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 
	 * ���֪ͨ״̬
	 * @return ֪ͨ״̬
	 */
	public boolean getState() {
		return state;
	}
	
	/**
	 * 
	 * ����֪ͨ״̬
	 * @param state
	 */
	public void setState(boolean state) {
		this.state = state;
	}
	
	/**
	 * 
	 * �֪ͨ��Id
	 * @return ֪ͨId
	 */
	public int getnId() {
		return nId;
	}
	
	/**
	 * 
	 * ����֪ͨ��Id
	 * @param nId
	 */
	public void setnId(int nId) {
		this.nId = nId;
	}
	
	/**
	 * ���֪ͨ������
	 * @return �û�
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * ����֪ͨ������
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
