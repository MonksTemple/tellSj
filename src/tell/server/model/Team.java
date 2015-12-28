package tell.server.model;

import java.util.Set;

/**
 * �Ŷ���Ϣ��
 */
public class Team {

<<<<<<< HEAD
	/**�Ŷӱ��*/
	private int tId;           
	/**�Ŷ�����*/
	private String name;        
	/**�ŶӼ��*/
	private String description; 
	/**�Ŷ�����,typeΪ1��ʱ��Ϊ�Ŷ��飬typeΪ2��ʱ��Ϊ�γ���*/
	private int type;           
	/**�γ�id*/
	private int cno;            
	/**������*/
	private User creator;       
	/**���ŶӴ����Ļ*/
	private Set activities;     
	/**���Ŷ����еĳ�Ա*/
	private Set members;         
=======
	private int tId;             //�Ŷӱ��
	private String name;         //�Ŷ�����
	private String description;  //�ŶӼ��
	private int type;            //�Ŷ�����,TypeΪ1��ʱ��Ϊ�Ŷ��飬typeΪ2��ʱ��Ϊ�γ���
	private int cno;             //�γ�id
	private User creator;        //������
	private Set activities;      //���ŶӴ����Ļ
	private Set members;         //���Ŷ����еĳ�Ա
>>>>>>> 41bffe7798858c974e9d8a28138fce5dbd015d9a
	
	
	/**
	 * �Ŷ���Ϣ��Ĭ�Ϲ��캯��
	 */
	public Team(){
		this.tId = 0;
		this.name = "";
		this.description = "";
		this.type = 0;
		this.cno = 0;
		this.creator = null;
	}
	
	/**
	 * @param team
	 */
	public Team(Team team){
		this.tId = team.gettId();
		this.name = team.getName();
		this.description = team.getDescription();
		this.type = team.getType();
		this.cno = team.getCno();
		this.creator = new User(team.getCreator());
	}
	
	/** 
	 * ��ȡ�Ŷ�Id
	 * @return �Ŷ�Id
	 */
	public int gettId() {
		return tId;
	}
	
	/**
	 * �����Ŷ�Id
	 * @param tId
	 */
	public void settId(int tId) {
		this.tId = tId;
	}
	
	/**
	 * ����Ŷ���
	 * @return �Ŷ���
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * �����Ŷ���
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * ����Ŷ�������Ϣ
	 * @return �Ŷ�������Ϣ
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * �����Ŷ�������Ϣ
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * �õ��Ŷ�����,typeΪ1��ʱ��Ϊ�Ŷ��飬typeΪ2��ʱ��Ϊ�γ���
	 * @return �Ŷ�����
	 */
	public int getType() {
		return type;
	}
	
	/**
	 * �����Ŷ�����: typeΪ1��ʱ��Ϊ�Ŷ��飬typeΪ2��ʱ��Ϊ�γ���
	 * @param type
	 */
	public void settype(int type) {
		this.type = type;
	}
	
	/**
	 * �õ��ŶӶ�Ӧ�Ŀγ̺ţ�������Ŷ��ǿγ��飩
	 * @return �γ̺�
	 */
	public int getCno() {
		return cno;
	}
	
	/**
	 * ���ÿγ̺ţ�������Ŷ��ǿγ��飩
	 * @param cno
	 */
	public void setCno(int cno) {
		this.cno = cno;
	}
	
	/**
	 * �õ��Ŷ������������л��Ϣ
	 * @return ��б�
	 */
	public Set getActivities() {
		return activities;
	}
	
	/**
	 * 
	 * �����ŶӵĻ��Ϣ
	 * @param activities
	 */
	public void setActivities(Set activities) {
		this.activities = activities;
	}
	
	/**
	 * 
	 * ����Ŷ����еĳ�Ա
	 * @return �Ŷӳ�Ա�б�
	 */
	public Set getMembers() {
		return members;
	}
	
	/**
	 * 
	 * �����Ŷӵĳ�Ա
	 * @param members
	 */
	public void setMembers(Set members) {
		this.members = members;
	}
	
	/**
	 * 
	 * �õ��ŶӵĴ�����
	 * @return �ŶӴ�����
	 */
	public User getCreator() {
		return creator;
	}
	
	/**
	 * 
	 * �����ŶӵĴ�����
	 * @param creator
	 */
	public void setCreator(User creator) {
		this.creator = creator;
	}

}
