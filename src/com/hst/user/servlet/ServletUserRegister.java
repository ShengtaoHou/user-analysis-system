package com.hst.user.servlet;

import com.hst.user.vo.*;
import com.hst.user.dao.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletUserRegister
 */
@WebServlet("/ServletUserRegister")
public class ServletUserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        // 设置编码格式为 UTF-8
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String userSex = request.getParameter("userSex");
        String userEmail = request.getParameter("userEmail");
        String userOccup = request.getParameter("userOccup");
        // for 循环拼接爱好数组中的数据

        UserVo user = new UserVo();
        // 实例化一个VO对象
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setUserSex(userSex);
        user.setUserEmail(userEmail);
        user.setUserOccup(userOccup);
        // 将前台得到的数据存入ＶＯ
        UserDao userDao = new UserDao();
        // 实例化一个数据库操作对象
        userDao.insertUser(user);
        // 调用增加用户方法
        request.getRequestDispatcher("/userlogin.jsp").forward(request,
                response);
        // 转到登录页面
        
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
