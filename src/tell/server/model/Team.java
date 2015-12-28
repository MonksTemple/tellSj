package tell.server.model;

import java.util.Set;

/**
 * ÍÅ¶ÓĞÅÏ¢Àà
 */
public class Team {

<<<<<<< HEAD
	/**ÍÅ¶Ó±àºÅ*/
	private int tId;           
	/**ÍÅ¶ÓÃû³Æ*/
	private String name;        
	/**ÍÅ¶Ó¼ò½é*/
	private String description; 
	/**ÍÅ¶ÓÀàĞÍ,typeÎª1µÄÊ±ºòÎªÍÅ¶Ó×é£¬typeÎª2µÄÊ±ºòÎª¿Î³Ì×é*/
	private int type;           
	/**¿Î³Ìid*/
	private int cno;            
	/**´´½¨ÈË*/
	private User creator;       
	/**¸ÃÍÅ¶Ó´´½¨µÄ»î¶¯*/
	private Set activities;     
	/**¸ÃÍÅ¶ÓËùÓĞµÄ³ÉÔ±*/
	private Set members;         
=======
	private int tId;             //ï¿½Å¶Ó±ï¿½ï¿½
	private String name;         //ï¿½Å¶ï¿½ï¿½ï¿½ï¿½ï¿½
	private String description;  //ï¿½Å¶Ó¼ï¿½ï¿½
	private int type;            //ï¿½Å¶ï¿½ï¿½ï¿½ï¿½ï¿½,TypeÎª1ï¿½ï¿½Ê±ï¿½ï¿½Îªï¿½Å¶ï¿½ï¿½é£¬typeÎª2ï¿½ï¿½Ê±ï¿½ï¿½Îªï¿½Î³ï¿½ï¿½ï¿½
	private int cno;             //ï¿½Î³ï¿½id
	private User creator;        //ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	private Set activities;      //ï¿½ï¿½ï¿½Å¶Ó´ï¿½ï¿½ï¿½ï¿½Ä»î¶¯
	private Set members;         //ï¿½ï¿½ï¿½Å¶ï¿½ï¿½ï¿½ï¿½ĞµÄ³ï¿½Ô±
>>>>>>> 41bffe7798858c974e9d8a28138fce5dbd015d9a
	
	
	/**
	 * ÍÅ¶ÓĞÅÏ¢ÀàÄ¬ÈÏ¹¹Ôìº¯Êı
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
	 * »ñÈ¡ÍÅ¶ÓId
	 * @return ÍÅ¶ÓId
	 */
	public int gettId() {
		return tId;
	}
	
	/**
	 * ÉèÖÃÍÅ¶ÓId
	 * @param tId
	 */
	public void settId(int tId) {
		this.tId = tId;
	}
	
	/**
	 * »ñµÃÍÅ¶ÓÃû
	 * @return ÍÅ¶ÓÃû
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * ÉèÖÃÍÅ¶ÓÃû
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * »ñµÃÍÅ¶ÓÃèÊöĞÅÏ¢
	 * @return ÍÅ¶ÓÃèÊöĞÅÏ¢
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * ÉèÖÃÍÅ¶ÓÃèÊöĞÅÏ¢
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * µÃµ½ÍÅ¶ÓÀàĞÍ,typeÎª1µÄÊ±ºòÎªÍÅ¶Ó×é£¬typeÎª2µÄÊ±ºòÎª¿Î³Ì×é
	 * @return ÍÅ¶ÓÀàĞÍ
	 */
	public int getType() {
		return type;
	}
	
	/**
	 * ÉèÖÃÍÅ¶ÓÀàĞÍ: typeÎª1µÄÊ±ºòÎªÍÅ¶Ó×é£¬typeÎª2µÄÊ±ºòÎª¿Î³Ì×é
	 * @param type
	 */
	public void settype(int type) {
		this.type = type;
	}
	
	/**
	 * µÃµ½ÍÅ¶Ó¶ÔÓ¦µÄ¿Î³ÌºÅ£¨Èç¹û¸ÃÍÅ¶ÓÊÇ¿Î³Ì×é£©
	 * @return ¿Î³ÌºÅ
	 */
	public int getCno() {
		return cno;
	}
	
	/**
	 * ÉèÖÃ¿Î³ÌºÅ£¨Èç¹û¸ÃÍÅ¶ÓÊÇ¿Î³Ì×é£©
	 * @param cno
	 */
	public void setCno(int cno) {
		this.cno = cno;
	}
	
	/**
	 * µÃµ½ÍÅ¶ÓËù´´½¨µÄËùÓĞ»î¶¯ĞÅÏ¢
	 * @return »î¶¯ÁĞ±í
	 */
	public Set getActivities() {
		return activities;
	}
	
	/**
	 * 
	 * ÉèÖÃÍÅ¶ÓµÄ»î¶¯ĞÅÏ¢
	 * @param activities
	 */
	public void setActivities(Set activities) {
		this.activities = activities;
	}
	
	/**
	 * 
	 * »ñµÃÍÅ¶ÓËùÓĞµÄ³ÉÔ±
	 * @return ÍÅ¶Ó³ÉÔ±ÁĞ±í
	 */
	public Set getMembers() {
		return members;
	}
	
	/**
	 * 
	 * ÉèÖÃÍÅ¶ÓµÄ³ÉÔ±
	 * @param members
	 */
	public void setMembers(Set members) {
		this.members = members;
	}
	
	/**
	 * 
	 * µÃµ½ÍÅ¶ÓµÄ´´½¨ÈË
	 * @return ÍÅ¶Ó´´½¨ÈË
	 */
	public User getCreator() {
		return creator;
	}
	
	/**
	 * 
	 * ÉèÖÃÍÅ¶ÓµÄ´´½¨ÈË
	 * @param creator
	 */
	public void setCreator(User creator) {
		this.creator = creator;
	}

}
