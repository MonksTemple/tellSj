package tell.server.model;

import java.util.Date;
import java.util.Set;

/**
 * 
 * ���Ϣ��
 */
public class Activity {

	/**�id*/
	private int aId;            
	/**�Ŷӣ�����Ǹ��˻��Ϊ��*/
	private Team team;            
	/**�����*/
	private String name;         
	/**����*/
	private String description;   
	/**��ʼʱ��*/
	private Date startTime;       
	/**����ʱ��*/
	private Date endTime;         
	/**�ص�*/
	private String place;         
	/**����ʱ��*/
	private Date remindTime;       
	/**����ͣ�typeΪ1��ʱ��Ϊ�Ŷӻ��typeΪ2��ʱ��Ϊ����type3 �Ǹ��˻��type4�ǵ����Ļ*/
	private int type;             
	/**������в�����*/
	private Set participants;      
	
	/**
	 * ���Ϣ��Ĭ�Ϲ��캯��
	 */
	public Activity(){
		this.aId = 0;
		this.name = "";
		this.description = "";
		this.startTime = new Date();
		this.endTime =  new Date();
		this.place = "";
		this.remindTime = new Date();
		this.type = 0;
		this.team = null;
		this.participants = null;
	}
	
	/**
	 * 
	 *
	 * @param activity
	 */
	public Activity(Activity activity){
		this.aId = activity.getaId();
		this.name = activity.getName();
		this.description = activity.getDescription();
		this.startTime = activity.getStartTime();
		this.endTime = activity.getEndTime();
		this.place = activity.getPlace();
		this.remindTime = activity.getRemindTime();
		this.type = activity.getType();
		this.team = new Team(activity.getTeam());
		this.participants = null;
	}
	
	/**
	 * 
	 * ��û��Id
	 * @return �Id
	 */
	public int getaId() {
		return aId;
	}
	
	/**
	 * 
	 * ���û��Id
	 * @param aId
	 */
	public void setaId(int aId) {
		this.aId = aId;
	}
	
	/**
	 * 
	 * ��û��
	 * @return ���
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * ���û��
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * ��û����
	 * @return �����
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * 
	 * ���û����
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 
	 * ��û����
	 * @return �����
	 */
	public Date getStartTime() {
		return startTime;
	}
	
	/**
	 * 
	 * ���û��ʼʱ��
	 * @param startTime
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * 
	 * ��û����ʱ�� 
	 * @return �����ʱ��
	 */
	public Date getEndTime() {
		return endTime;
	}
	
	/**
	 * 
	 * ���û����ʱ��
	 * @param endTime
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * 
	 * ��û�ٰ��
	 * @return ��ٰ��
	 */
	public String getPlace() {
		return place;
	}
	
	/**
	 * 
	 * ���û�ٰ��
	 * @param place
	 */
	public void setPlace(String place) {
		this.place = place;
	}
	
	/**
	 * 
	 * �õ������ʱ��
	 * @return �����ʱ��
	 */
	public Date getRemindTime() {
		return remindTime;
	}
	
	/**
	 * 
	 * ���û����ʱ��
	 * @param remindTime
	 */
	public void setRemindTime(Date remindTime) {
		this.remindTime = remindTime;
	}
	
	/**
	 * 
	 * ��û���ͣ�typeΪ1��ʱ��Ϊ�Ŷӻ��typeΪ2��ʱ��Ϊ����type3 �Ǹ��˻��type4�ǵ����Ļ
	 * @return �����
	 */
	public int getType() {
		return type;
	}
	
	/**
	 * 
	 * ���û����
	 * @param type
	 */
	public void setType(int type) {
		this.type = type;
	}
	
	/**
	 * 
	 * ��û�ľٰ��Ŷ�
	 * @return �ٰ��Ŷ�
	 */
	public Team getTeam() {
		return team;
	}
	
	/**
	 * ���û�ľٰ��Ŷ�
	 * @param team
	 */
	public void setTeam(Team team) {
		this.team = team;
	}
	
	/**
	 * 
	 * ��û�Ĳ�����Ա�б�
	 * @return ������Ա�б�
	 */
	public Set getParticipants() {
		return participants;
	}
	
	/**
	 * 
	 * ���û�Ĳ�����Ա
	 * @param participants
	 */
	public void setParticipants(Set participants) {
		this.participants = participants;
	}
}
