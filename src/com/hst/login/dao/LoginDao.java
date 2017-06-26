package com.hst.login.dao;

import com.hst.dbmanage.*;
import com.hst.login.vo.*;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class LoginDao {
	
	public void insertLogin(LoginVo login) {
        // 用户注册方法
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            //*****should　add a check username function*****
            String sql = "INSERT INTO logintable (user_id,user_IP,user_browser,user_OS,user_Lang,login_time)VALUES('"
                    + login.getUserId()
                    + "','"
                    + login.getUserIP()
                    + "','"
                    + login.getUserBrowser()
                    + "','"
                    + login.getUserOS()
                    + "','"
                    + login.getUserLang()
                    + "','"
                    + login.getLoginTime()
                    + "')";
            sta.executeUpdate(sql);
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(sta, conn);
        }
    }
	
	public LoginVo judgeUserId(int userId) {
        // 用户登录验证
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        LoginVo login = null;
        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            System.out.println(userId);
            
            String sql = "SELECT * FROM logintable WHERE user_id = '"
                    + userId + "' ";
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                login = new LoginVo();
                login.setLoginId(rs.getInt("login_id"));
                login.setUserId(rs.getInt("user_id"));
                login.setUserIP(rs.getString("user_IP"));
                login.setUserBrowser(rs.getString("user_browser"));
                login.setUserOS(rs.getString("user_OS"));                
                login.setUserLang(rs.getString("user_lang"));
                login.setLoginTime(rs.getTimestamp("login_time"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(rs, sta, conn);
        }
        return login;
    }
	
	
	
	public ArrayList<LoginVo> selectNotDeleteList() {
        // 查询所有正常用户
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        LoginVo login = null;
        ArrayList<LoginVo> list = new ArrayList<LoginVo>();
        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();

            String sql = "SELECT * FROM loginTable WHERE login_display = 1";

            rs = sta.executeQuery(sql);
            while (rs.next()) {

            	login = new LoginVo();

            	login.setLoginId(rs.getInt("login_id"));
            	login.setUserId(rs.getInt("user_id"));
            	login.setUserIP(rs.getString("user_IP"));
            	login.setUserBrowser(rs.getString("user_browser"));
            	login.setUserOS(rs.getString("user_OS"));
            	login.setUserLang(rs.getString("user_lang"));
            	login.setLoginTime(rs.getTimestamp("login_time"));
                

                list.add(login);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(rs, sta, conn);
        }
        return list;
    }
	
	
	public void deleteOneLogin(int loginId) {
        // 删除单条记录方法
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            String sql = "UPDATE logintable SET login_display = 0 WHERE login_id ="
                    + loginId;
            sta.executeUpdate(sql);
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(sta, conn);
        }

    }
	
	public void deleteUserList(String[] loginId) {
        // 批量刪除记录方法
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            int Id = 0;
            for (int i = 0; i < loginId.length; i++) {

                // 循环遍历集合中的元素，然后逐个删除
                Id = Integer.parseInt(loginId[i]);
                String sql = "UPDATE logintable SET login_display = 0 WHERE login_id ="
                        + Id;
                sta.executeUpdate(sql);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(sta, conn);
        }
    }
	public int getOSnumber(String OS) {
        // 查看单一用户信息
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        int osnum=0;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            String sql = "SELECT * FROM logintable WHERE user_OS= '" + OS + "'";  //暂时这样，之后改成count语句
            rs = sta.executeQuery(sql);
            rs.last();
            osnum=rs.getRow();
		

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(rs, sta, conn);
        }
        return osnum;
    }
	
	public int getOSnumberSex(String OS,String Sex) {
        // 查看单一用户信息
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        int osnum=0;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            String sql = 
            		"SELECT * "
            		+ "FROM logintable inner join usertable on logintable.user_id=usertable.user_id"
            		+ " WHERE user_OS= '" + OS + "' AND user_sex='" +Sex+ "'";  //暂时这样，之后改成count语句
            rs = sta.executeQuery(sql);
            rs.last();
            osnum=rs.getRow();  
            
		

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(rs, sta, conn);
        }
        return osnum;
    }
	
	public int getOSnumberOccup(String OS,String Occup) {
        // 查看单一用户信息
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        int osnum=0;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            String sql = 
            		"SELECT * "
            		+ "FROM logintable inner join usertable on logintable.user_id=usertable.user_id"
            		+ " WHERE user_OS= '" + OS + "' AND user_occup='" +Occup+ "'";  //暂时这样，之后改成count语句
            rs = sta.executeQuery(sql);
            rs.last();
            osnum=rs.getRow();  
            
		

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(rs, sta, conn);
        }
        return osnum;
    }
	
	public int getBrowserNumber(String Bro) {
        // 查看单一用户信息
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        int num=0;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            String sql = "SELECT * FROM logintable WHERE user_Browser= '" + Bro + "'";  //暂时这样，之后改成count语句
            rs = sta.executeQuery(sql);
            rs.last();
            num=rs.getRow();
		

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(rs, sta, conn);
        }
        return num;
    }
	
	
	
	public int getBrowserNumberSex(String Bro,String Sex) {
        // 查看单一用户信息
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        int num=0;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            String sql = 
            		"SELECT * "
            		+ "FROM logintable inner join usertable on logintable.user_id=usertable.user_id"
            		+ " WHERE user_Browser= '" + Bro + "' AND user_sex='" +Sex+ "'";  //暂时这样，之后改成count语句
            rs = sta.executeQuery(sql);
            rs.last();
            num=rs.getRow();
		

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(rs, sta, conn);
        }
        return num;
    }
	
	public int getBrowserNumberOccup(String Bro,String Occup) {
        // 查看单一用户信息
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        int num=0;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            String sql = 
            		"SELECT * "
            		+ "FROM logintable inner join usertable on logintable.user_id=usertable.user_id"
            		+ " WHERE user_Browser= '" + Bro + "' AND user_occup='" +Occup+ "'";  //暂时这样，之后改成count语句
            rs = sta.executeQuery(sql);
            rs.last();
            num=rs.getRow();
		

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(rs, sta, conn);
        }
        return num;
    }

	public ArrayList<LoginVo> selectUserLoginList(int userId) {
        // 查询所有正常用户
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        LoginVo login = null;
        ArrayList<LoginVo> list = new ArrayList<LoginVo>();
        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();

            String sql = "SELECT * FROM loginTable WHERE user_id = "+userId;

            rs = sta.executeQuery(sql);
            while (rs.next()) {

            	login = new LoginVo();

            	login.setLoginId(rs.getInt("login_id"));
            	login.setUserId(rs.getInt("user_id"));
            	login.setUserIP(rs.getString("user_IP"));
            	login.setUserBrowser(rs.getString("user_browser"));
            	login.setUserOS(rs.getString("user_OS"));
            	login.setUserLang(rs.getString("user_lang"));
            	login.setLoginTime(rs.getTimestamp("login_time"));
                

                list.add(login);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(rs, sta, conn);
        }
        return list;
    }
	
	/*
	public void updateUser(UserVo user) {
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            String sql = "UPDATE  usertable SET "
            		+ "user_name= '"+ user.getUserName() 
                    + "', user_password= '"+ user.getUserPassword() 
                    + "', user_sex= '"+ user.getUserSex()                   
                    + "', user_email= '" + user.getUserEmail()
                    + "' WHERE user_id= " + user.getUserId();
            System.out.println(sql);
            sta.executeUpdate(sql);
            System.out.println("update success");
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(sta, conn);
        }

    }
*/	
}

