package tell.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import tell.server.hiberUtil.JsonDateValueProcessor;
import tell.server.model.Activity;
import tell.server.model.Notification;
import tell.server.model.Team;
import tell.server.model.User;
import tell.server.presenter.ActivityManage;
import tell.server.presenter.NotificationManage;
import tell.server.presenter.TeamManage;
import tell.server.presenter.UserManage;

/**
 * Servlet implementation class tellServlet
 */

public class TellServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 默认构造函数 
	 */
	public TellServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 处理GET形式的方法
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * 处理POST形式的方法
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");

		switch(type.charAt(0)){
		case '0':userOperation(type.charAt(1),request,response);
		break;
		case '1': teamOperation(type.charAt(1),request,response);
		break;
		case '2': acitvityOperation(type.charAt(1),request,response);
		break;
		case '3': notificationOperation(type.charAt(1),request,response);
		break;
		}
	}

	/**
	 * 
	 * 用户操作
	 * @param type
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void userOperation(char type, HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		UserManage userManage = new UserManage();
		switch(type){
		//登陆 
		case '1':
			String temp1 = request.getParameter("user");
			User  user1 = JSON.parseObject(temp1, User.class);
			User myUser = userManage.login(user1);
			if(myUser != null){
				String tempUser = JSON.toJSONString(myUser);
				out.write(tempUser);
			}
			else{
				out.write("false");
			}				

			break;
			//注册
		case '2': 
			String temp2 = request.getParameter("user");
			User user2 = JSON.parseObject(temp2,User.class);
			Boolean register = userManage.register(user2);
			out.write(register.toString());
			break;
			//注销
		case '3': 
			String temp4 = request.getParameter("userId");
			Boolean loginOut = userManage.logout(Integer.valueOf(temp4));
			out.write(loginOut.toString());
			break;
			//修改
		case '4': 
			String temp5 = request.getParameter("user");
			User user5 = JSON.parseObject(temp5,User.class);
			Boolean modify = userManage.modify(user5);
			out.write(modify.toString());
			break;
		}
		out.flush();
		out.close();
	}

	/**
	 * 
	 * 团队处理
	 * @param type
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void  teamOperation(char type, HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		TeamManage teamManage = new TeamManage();
		switch(type){
		//创建 
		case '1':
			String temp1 = request.getParameter("team");
			Team  team1 = JSON.parseObject(temp1, Team.class);
			if(teamManage.createTeam(team1)){
				out.write("true");
			}
			else{
				out.write("false");
			}

			break;
			//添加成员
		case '2': 
			int tId = Integer.valueOf(request.getParameter("tId"));
			int userId = Integer.valueOf(request.getParameter("userId"));
			if(teamManage.addMember(tId, userId)){
				out.write("true");
			}
			else{
				out.write("false");
			}
			break;
			//修改信息
		case '3':
			String temp2 = request.getParameter("team");
			Team  team2 = JSON.parseObject(temp2, Team.class);
			if(teamManage.modifyInfo(team2)){
				out.write("true");	
			}
			else{
				out.write("false");
			}

			break;
			//修改信息
		case '4':
			int tId2 = Integer.valueOf(request.getParameter("tId"));
			if(teamManage.deleteTeam(tId2)){
				out.write("true");	
			}
			else{
				out.write("false");
			}

			break;
			//返回团队列表
		case '5':
			Set<Team> teams =teamManage.ShowTeamList();
			if(teams !=null){
				JSONArray jsonArray = JSONArray.fromObject(teams);
				out.write(jsonArray.toString());	
			}
			else{
				out.write("false");
			}

			break;

			//删除用户
		case '6':
			int tId3 = Integer.valueOf(request.getParameter("tId"));
			int userId2 = Integer.valueOf(request.getParameter("userId"));
			if(teamManage.deleteMember(tId3, userId2)){
				out.write("true");	
			}
			else{
				out.write("false");
			}

			break;	
			//删除用户
		case '7':
			int tId4 = Integer.valueOf(request.getParameter("tId"));
			Set<User> users = teamManage.showMemberList(tId4);
			if(users != null){
				JSONArray jsonArray = JSONArray.fromObject(users);
				out.write(jsonArray.toString());	
			}
			else{
				out.write("false");
			}

			break;		
		}
		out.flush();
		out.close();
	}

	/**
	 * 
	 * 活动处理
	 * @param type
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void  acitvityOperation(char type, HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		ActivityManage activityManage = new ActivityManage();
		switch(type){
		//创建 
		case '1':
			String temp1 = request.getParameter("activity");
			Activity  activity1 = JSON.parseObject(temp1, Activity.class);
			if(activityManage.addActivity(activity1)){
				out.write("true");	
			}
			else{
				out.write("false");
			}		
			break;
			//修改
		case '2': 
			String temp2 = request.getParameter("activity");
			Activity  activity2 = JSON.parseObject(temp2, Activity.class);
			if(activityManage.modifyActivity(activity2)){
				out.write("true");	
			}
			else{
				out.write("false");
			}		
			break;
			//删除
		case '3': 
			int aId = Integer.valueOf(request.getParameter("aId"));
			if(activityManage.deleteActivity(aId)){
				out.write("true");
			}
			else{
				out.write("false");
			}
			break;
			//根据团队id获取团队活动列表
		case '4': 
			int tId = Integer.valueOf(request.getParameter("tId"));
			Set<Activity> acts1 = activityManage.showActivitiesByTeamId(tId);
			if(acts1 == null){
				out.write("false");
			}
			else{
				JsonConfig jsonConfig = new JsonConfig();
				jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());
				JSONArray jsonArray = JSONArray.fromObject( acts1,jsonConfig );  
				out.write(jsonArray.toString());
			}
			break;

			//根据用户id获取用户参加的活动列表
		case '5': 
			int userId = Integer.valueOf(request.getParameter("userId"));
			Set<Activity> acts2 = activityManage.showActivitiesByUserId(userId);
			if(acts2 == null){
				out.write("false");
			}
			else{
				JsonConfig jsonConfig = new JsonConfig();
				jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());
				JSONArray jsonArray = JSONArray.fromObject( acts2,jsonConfig );  
				String actsString = jsonArray.toString();
				out.write(actsString);
			}
			break;

			//获得个人活动
		case '6': 
			Set<Activity> acts3 = activityManage.showIsolateActivities();
			if(acts3 == null){
				out.write("false");
			}
			else{
				JsonConfig jsonConfig = new JsonConfig();
				jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());
				JSONArray jsonArray = JSONArray.fromObject( acts3,jsonConfig );  
				String actsString = jsonArray.toString();
				out.write(actsString);
			}
			break;

			//显示活动成员
		case '7': 
			int aId2 = Integer.valueOf(request.getParameter("aId"));
			Set<User> users = activityManage.showMembers(aId2);
			if(users == null){
				out.write("false");
			}
			else{
				JSONArray jsonArray = JSONArray.fromObject(users);
				out.write(jsonArray.toString());
			}
			break;
		}
		out.flush();
		out.close();
	}

	/**
	 * 
	 * 通知处理
	 * @param type
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void  notificationOperation(char type, HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		NotificationManage notificationManage = new NotificationManage();
		switch(type){
		//添加通知
		case '1':
			String temp = request.getParameter("notification");
			Notification notification = JSON.parseObject(temp, Notification.class);
			if(notificationManage.addNotification(notification)){
				out.write("true");
			}
			else{
				out.write("false");
			}
			break;

			//修改通知
		case '2':
			String temp2 = request.getParameter("notification");
			Notification notification2 = JSON.parseObject(temp2, Notification.class);
			if(notificationManage.updateNotification(notification2)){
				out.write("true");
			}
			else{
				out.write("false");
			}
			break;
		}
		out.flush();
		out.close();
	}
}
