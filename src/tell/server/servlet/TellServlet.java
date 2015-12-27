package tell.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import tell.server.model.Activity;
import tell.server.model.Team;
import tell.server.model.User;
import tell.server.presenter.ActivityManage;
import tell.server.presenter.TeamManage;
import tell.server.presenter.UserManage;

/**
 * Servlet implementation class tellServlet
 */

public class TellServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TellServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
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
			case '1': 
				break;
			case '2': acitvityOperation(type.charAt(1),request,response);
				break;
			case '3': 
				break;
		}
	}

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
	
	private void  teamOperation(char type, HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		TeamManage teamManage = new TeamManage();
		switch(type){
		    //创建 
			case '1':
				String temp1 = request.getParameter("team");
				Team  team1 = JSON.parseObject(temp1, Team.class);
				teamManage.createTeam(team1);
				out.write("true");			
				break;
		    //添加成员
			case '2': 
			    int tId = Integer.valueOf(request.getParameter("tId"));
			    int userId = Integer.valueOf(request.getParameter("userId"));
				teamManage.addMember(tId, userId);
				out.write("true");
				break;
			case '3':
//				String temp4 = request.getParameter("userId");
//				Boolean loginOut = teamManage.logout(Integer.valueOf(temp4));
//				out.write(loginOut.toString());
				break;
		}
		out.flush();
		out.close();
	}
	
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
					String actsString = JSON.toJSONString(acts1);
					out.write(actsString);
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
						String actsString = JSON.toJSONString(acts2);
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
							String actsString = JSON.toJSONString(acts3);
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
							String actsString = JSON.toJSONString(users);
							out.write(actsString);
						}
					break;
		}
		out.flush();
		out.close();
	}
	
	private void  notificationOperation(char type, HttpServletRequest request,HttpServletResponse response) throws IOException{
		
	}
}
