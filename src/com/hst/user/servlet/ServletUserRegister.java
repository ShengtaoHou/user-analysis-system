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
        // ���ñ����ʽΪ UTF-8
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String userSex = request.getParameter("userSex");
        String userEmail = request.getParameter("userEmail");
        String userOccup = request.getParameter("userOccup");
        // for ѭ��ƴ�Ӱ��������е�����

        UserVo user = new UserVo();
        // ʵ����һ��VO����
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setUserSex(userSex);
        user.setUserEmail(userEmail);
        user.setUserOccup(userOccup);
        // ��ǰ̨�õ������ݴ���֣�
        UserDao userDao = new UserDao();
        // ʵ����һ�����ݿ��������
        userDao.insertUser(user);
        // ���������û�����
        request.getRequestDispatcher("/userlogin.jsp").forward(request,
                response);
        // ת����¼ҳ��
        
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
