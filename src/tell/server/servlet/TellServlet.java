package tell.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import tell.server.model.Activity;
import tell.server.model.Team;
import tell.server.model.User;
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
			case '2': 
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
				Boolean login = userManage.login(user1);
				out.write(login.toString());
				break;
		    //注册
			case '2': 
				String temp2 = request.getParameter("user");
				User user2 = JSON.parseObject(temp2,User.class);
				Boolean register = userManage.register(user2);
				out.write(register.toString());
				break;
			//显示用户
			case '3':
				//String temp
				
				break;
			//注销
			case '4': 
				String temp4 = request.getParameter("userId");
				Boolean loginOut = userManage.logout(Integer.valueOf(temp4));
				out.write(loginOut.toString());
				break;
			//修改
			case '5': 
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
		
	}
	
	private void  acitvityOperation(char type, HttpServletRequest request,HttpServletResponse response) throws IOException{
		
	}
	
	private void  notificationOperation(char type, HttpServletRequest request,HttpServletResponse response) throws IOException{
		
	}
}
