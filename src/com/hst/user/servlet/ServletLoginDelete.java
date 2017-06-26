package com.hst.user.servlet;

import com.hst.login.dao.*;
import com.hst.login.vo.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletUserDelete
 */
@WebServlet("/ServletLoginDelete")
public class ServletLoginDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLoginDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int loginId = Integer.parseInt(request.getParameter("loginId"));
		System.out.println("loginId"+loginId);
		LoginDao loginDao = new LoginDao();
        loginDao.deleteOneLogin(loginId);
        ArrayList<LoginVo> loginlist = loginDao.selectNotDeleteList();
        request.setAttribute("loginlist", loginlist);
        request.getRequestDispatcher("/loginlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
