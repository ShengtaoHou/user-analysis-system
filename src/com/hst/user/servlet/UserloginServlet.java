package com.hst.user.servlet;

import javax.servlet.http.*; 

import com.hst.login.vo.*;
import com.hst.login.dao.*;

import com.hst.user.vo.*;
import java.sql.Timestamp;
import com.hst.user.dao.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserloginServlet
 */
@WebServlet("/UserloginServlet")
public class UserloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserloginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 

    public static String getIpAddr(HttpServletRequest request) {  
        String ip = request.getHeader("X-Real-IP");  
        if (ip!= null && !"".equals(ip) && !"unknown".equalsIgnoreCase(ip)) {  
            return ip;  
        }  
        ip = request.getHeader("X-Forwarded-For");  
        if (ip!= null && !"".equals(ip)  && !"unknown".equalsIgnoreCase(ip)) {  
            // 多次反向代理后会有多个IP值，第一个为真实IP。  
            int index = ip.indexOf(',');  
            if (index != -1) {  
                return ip.substring(0, index);  
            } else {  
                return ip;  
            }  
        } else {  
            return request.getRemoteAddr();  
        }  
    }  

    public static String getRequestBrowserInfo(HttpServletRequest request){  
        String browserVersion = null;  
        String header = request.getHeader("user-agent");  
        if(header == null || header.equals("")){  
           return "";  
         }  
        if(header.indexOf("MSIE")>0){  
            browserVersion = "IE";  
        }else if(header.indexOf("Firefox")>0){  
            browserVersion = "Firefox";  
        }else if(header.indexOf("Chrome")>0){  
            browserVersion = "Chrome";  
        }else if(header.indexOf("Safari")>0){  
            browserVersion = "Safari";  
        }else if(header.indexOf("Camino")>0){  
            browserVersion = "Camino";  
        }else if(header.indexOf("Konqueror")>0){  
            browserVersion = "Konqueror";  
        }  
        return browserVersion;  
    }  
  

    public static String getRequestSystemInfo(HttpServletRequest request){  
      String systenInfo = null;  
      String header = request.getHeader("user-agent");  
      if(header == null || header.equals("")){  
       return "";  
      }  
        //得到用户的操作系统  
        if (header.indexOf("NT 6.0") > 0){  
            systenInfo = "Windows Vista/Server 2008";  
        } else if (header.indexOf("NT 5.2") > 0){  
            systenInfo = "Windows Server 2003";  
        } else if (header.indexOf("NT 5.1") > 0){  
            systenInfo = "Windows XP";  
        } else if (header.indexOf("NT 6.0") > 0){  
            systenInfo = "Windows Vista";  
        } else if (header.indexOf("NT 6.1") > 0){  
            systenInfo = "Windows 7";  
        } else if (header.indexOf("NT 6.2") > 0){  
            systenInfo = "Windows Slate";  
        } else if (header.indexOf("NT 6.3") > 0){  
            systenInfo = "Windows 9";  
        } else if (header.indexOf("NT 5") > 0){  
            systenInfo = "Windows 2000";  
        } else if (header.indexOf("NT 4") > 0){  
            systenInfo = "Windows NT4";  
        } else if (header.indexOf("Me") > 0){  
            systenInfo = "Windows Me";  
        } else if (header.indexOf("98") > 0){  
            systenInfo = "Windows 98";  
        } else if (header.indexOf("95") > 0){  
            systenInfo = "Windows 95";  
        } else if (header.indexOf("Mac") > 0){  
            systenInfo = "Mac";  
        } else if (header.indexOf("Unix") > 0){  
            systenInfo = "UNIX";  
        } else if (header.indexOf("Linux") > 0){  
            systenInfo = "Linux";  
        } else if (header.indexOf("SunOS") > 0){  
            systenInfo = "SunOS";  
        }else{
        	systenInfo = "Win10"; 
        }//暂时先这样，需要后续查找 win10版本号
        return systenInfo;  
     }  
    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        // 前台得到用户输入
        UserDao userDao = new UserDao();
        UserVo user = userDao.judgeUserPassword(userName, userPassword);
        // 调用方法判断用户是否存在
        String message = "用户名或密码错误~！";
        
        //*****get the request header****
        String userIP=getIpAddr(request);
        String userBrowser=getRequestBrowserInfo(request);
        String userOS=getRequestSystemInfo(request);
        
        
        
        System.out.println(userIP);
        System.out.println(userBrowser);
        System.out.println(userOS);
        
        //*****get the request header***
        
        if (user == null) {
            // 如果用户不存在，重新登录
            request.setAttribute("message", message);
            request.getRequestDispatcher("/userlogin.jsp").forward(request,
                    response);
        } else {

        	int userId=user.getUserId();
        	
        	 // 将前台得到的数据存入ＶＯ
            LoginDao loginDao = new LoginDao();
        	
        	LoginVo login = new LoginVo();
            // 实例化一个VO对象
        	login.setUserId(userId);
            login.setUserIP(userIP);
            login.setUserBrowser(userBrowser);
            login.setUserOS(userOS);
            login.setUserLang("zh"); //先这样
            
            Timestamp ts = new Timestamp(System.currentTimeMillis()); 
            
            login.setLoginTime(ts);
            
          
              // 实例化一个数据库操作对象
             loginDao.insertLogin(login);
             
             
             	System.out.println(login.getLoginId());
             
             	HttpSession session = request.getSession(false); 	
        		session.setAttribute("curlogin",login);
        		session.setAttribute("curuser",user);
        		
        		request.getRequestDispatcher("/video.jsp").forward(request,response);

        }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
