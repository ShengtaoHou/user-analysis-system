package com.hst.user.servlet;

import com.hst.user.dao.*;
import com.hst.user.vo.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletToUserUpdate
 */
@WebServlet("/ServletToUserUpdate")
public class ServletToUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletToUserUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userId = Integer.parseInt(request.getParameter("userId"));
        UserDao userDao = new UserDao();
        UserVo user = userDao.selectOneUserInfo(userId);
        
        request.setAttribute("user", user);
        request.getRequestDispatcher("/userupdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("utf-8");
	        response.setCharacterEncoding("utf-8");
	        // 设置编码格式为 UTF-8
	        int userId = Integer.parseInt(request.getParameter("userId"));
	        String userName = request.getParameter("userName");
	        String userPassword = request.getParameter("userPassword");
	        String userSex = request.getParameter("userSex");
	        String userEmail = request.getParameter("userEmail");
	        String userOccup = request.getParameter("userOccup");
	        // 前台得到 用户输入数据

	        // for 循环拼接爱好数组中的数据

	        UserVo user = new UserVo();
	        // 实例化一个VO对象
	        user.setUserId(userId);
	        user.setUserName(userName);
	        user.setUserPassword(userPassword);
	        user.setUserSex(userSex);
	        user.setUserEmail(userEmail);
	        user.setUserOccup(userOccup);
	        // 将前台得到的数据存入ＶＯ
	        
	        UserDao userDao = new UserDao();
	        userDao.updateUser(user);
	                
	        ArrayList<UserVo> list=userDao.selectNotDeleteList();
	        request.setAttribute("list", list);
	        request.getRequestDispatcher("/video.jsp").forward(request, response);
	}

}
