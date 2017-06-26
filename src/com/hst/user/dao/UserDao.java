package com.hst.user.dao;

import com.hst.dbmanage.*;
import com.hst.user.vo.*;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hst.Sequence;

import com.hst.Sequence.*;


import java.text.SimpleDateFormat;
import java.util.*;

public class UserDao {
	
	public void insertUser(UserVo user) {
        // 用户注册方法
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;

        try {
            conn = dbmanage.initDB();
            if(conn==null){
            	System.out.println("conn is null, shit");
            	
            }
            sta = conn.createStatement();
            //*****should　add a check username function*****
            String sql = "INSERT INTO usertable (user_name,user_password,user_sex,user_email,user_occup)VALUES('"
                    + user.getUserName()
                    + "','"
                    + user.getUserPassword()
                    + "','"
                    + user.getUserSex()
                    + "','"
                    + user.getUserEmail()
                    + "','"
                    + user.getUserOccup()
                    + "')";
            sta.executeUpdate(sql);
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(sta, conn);
        }
    }
	
	public UserVo judgeUserPassword(String userName, String userPassword) {
        // 用户登录验证
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        UserVo user = null;
        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            System.out.println(userName);
            System.out.println(userPassword);
            String sql = "SELECT * FROM usertable WHERE user_name = '"
                    + userName + "' AND user_password= '" + userPassword + "'";
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                user = new UserVo();
                user.setUserName(rs.getString("user_name"));
                user.setUserPassword(rs.getString("user_password"));
                user.setUserId(rs.getInt("user_id"));
                user.setUserEmail(rs.getString("user_email"));
                user.setUserOccup(rs.getString("user_occup"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(rs, sta, conn);
        }
        return user;
    }
	
	public ArrayList<UserVo> selectNotDeleteList() {
        // 查询所有正常用户
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        UserVo user = null;
        ArrayList<UserVo> list = new ArrayList<UserVo>();
        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();

            String sql = "SELECT * FROM userTable WHERE user_display = 1";

            rs = sta.executeQuery(sql);
            while (rs.next()) {

                user = new UserVo();

                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserPassword(rs.getString("user_password"));
               
                user.setUserSex(rs.getString("user_sex"));
                user.setUserEmail(rs.getString("user_email"));
                user.setUserOccup(rs.getString("user_occup"));

                list.add(user);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(rs, sta, conn);
        }
        return list;
    }
	
	public void deleteOneUser(int userId) {
        // 删除单条记录方法
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            String sql = "UPDATE userTable SET user_display = 0 WHERE user_id ="
                    + userId;
            sta.executeUpdate(sql);
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(sta, conn);
        }

    }
	
	public void deleteUserList(String[] userId) {
        // 批量刪除记录方法
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            int Id = 0;
            for (int i = 0; i < userId.length; i++) {

                // 循环遍历集合中的元素，然后逐个删除
                Id = Integer.parseInt(userId[i]);
                String sql = "UPDATE userTable SET user_display = 0 WHERE user_id ="
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
	
	public UserVo selectOneUserInfo(int userId) {
        // 查看单一用户信息
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        UserVo user = null;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            String sql = "SELECT * FROM usertable WHERE user_id = " + userId;
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                user = new UserVo();
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserPassword(rs.getString("user_password"));
             
                user.setUserSex(rs.getString("user_sex"));
                user.setUserEmail(rs.getString("user_email"));
                user.setUserOccup(rs.getString("user_occup"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(rs, sta, conn);
        }
        return user;

    }
	
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
                    + "', user_occup= '" + user.getUserOccup()
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
	public int getSexNumber(String str) {
        // 查看单一用户信息
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        int num=0;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            String sql = "SELECT * FROM usertable WHERE user_sex= '" + str + "'";  //暂时这样，之后改成count语句
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                 num++;  
            }
		

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(rs, sta, conn);
        }
        return num;
    }
	
	public int getOccupNumber(String str) {
        // 查看单一用户信息
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        int num=0;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            String sql = "SELECT * FROM usertable WHERE user_occup= '" + str + "'";  //暂时这样，之后改成count语句
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                 num++;  
            }
		

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            // 执行完关闭数据库
            dbmanage.closeDB(rs, sta, conn);
        }
        return num;
    }
	
	public int[][] getOS(){
	    Dbmanage dbmanage = new Dbmanage();
        Connection conn=null;
        Statement sta = null;
        ResultSet result = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        int [] windows_count = new int[12];
        int [] linux_count = new int[12];
        int [] macos_count = new int[12];
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR,-1);
	    try{
	        conn=dbmanage.initDB();
	        sta = conn.createStatement();
	        String sql=null;
            Date begin  = calendar.getTime();
            calendar.add(Calendar.MONTH,1);
            Date end =  calendar.getTime();
            for(int i = 0;i<11;i++)
            {
                sql="select count(*) from logintable where user_OS='Linux'" +
                        "and login_time BETWEEN '"+ formatter.format(begin)+"' and '"+formatter.format(end)+"'";
                result = sta.executeQuery(sql);
                while(result.next())
                {
                    linux_count[i] = result.getInt(1);
                }
                sql="select count(*) from logintable where user_OS LIKE 'Windows%'" +
                        "and login_time BETWEEN '"+ formatter.format(begin)+"' and '"+formatter.format(end)+"'";
                result = sta.executeQuery(sql);
                while(result.next()){
                    windows_count[i] = result.getInt(1);
                }


                sql="select count(*) from logintable where user_OS='MAC'" +
                        "and login_time BETWEEN '"+ formatter.format(begin)+"' and '"+formatter.format(end)+"'";
                result = sta.executeQuery(sql);
                while(result.next()){
                    macos_count[i] = result.getInt(1);
                }

                begin=end;
                calendar.add(Calendar.MONTH,1);
                end =  calendar.getTime();

            }

        }catch (SQLException e)
        {
            e.printStackTrace();

        }
        finally {
            dbmanage.closeDB(result, sta, conn);
        }
        int[][] os_information={windows_count,linux_count,macos_count};
        return os_information;
    }
    public int[] flow(){
        Dbmanage dbmanage = new Dbmanage();
        Connection conn=null;
        Statement sta = null;
        ResultSet result = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int[] flow = new int[12];
        calendar.add(Calendar.YEAR,-1);
        try{
            conn=dbmanage.initDB();
            sta = conn.createStatement();
            String sql=null;
            Date begin  = calendar.getTime();
            calendar.add(Calendar.MONTH,1);
            Date end =  calendar.getTime();
            for(int i = 0;i<11;i++)
            {
                sql="select count(*) from logintable where " +
                        "login_time BETWEEN '"+ formatter.format(begin)+"' and '"+formatter.format(end)+"'";
                result = sta.executeQuery(sql);
                while(result.next())
                {
                    flow[i] = result.getInt(1);
                }
                begin=end;
                calendar.add(Calendar.MONTH,1);
                end =  calendar.getTime();

            }

        }catch (SQLException e)
        {
            e.printStackTrace();

        }
        finally {
            dbmanage.closeDB(result, sta, conn);
        }
    return flow;
    }
    public int[][] getBrowser(){
        Dbmanage dbmanage = new Dbmanage();
        Connection conn=null;
        Statement sta = null;
        ResultSet result = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        int [] chrome_count = new int[12];
        int [] ie_count = new int[12];
        int [] firefox_count=new int[12];
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR,-1);
        try{
            conn=dbmanage.initDB();
            sta = conn.createStatement();
            String sql=null;
            Date begin  = calendar.getTime();
            calendar.add(Calendar.MONTH,1);
            Date end =  calendar.getTime();
            for(int i = 0;i<11;i++)
            {
                sql="select count(*) from logintable where user_browser='Chrome'" +
                        "and login_time BETWEEN '"+ formatter.format(begin)+"' and '"+formatter.format(end)+"'";
                result = sta.executeQuery(sql);
                while(result.next())
                {
                    chrome_count[i] = result.getInt(1);
                }
                
                sql="select count(*) from logintable where user_browser='Firefox'" +
                        "and login_time BETWEEN '"+ formatter.format(begin)+"' and '"+formatter.format(end)+"'";
                result = sta.executeQuery(sql);
                while(result.next())
                {
                    firefox_count[i] = result.getInt(1);
                }
                
                sql="select count(*) from logintable where user_browser='IE'" +
                        "and login_time BETWEEN '"+ formatter.format(begin)+"' and '"+formatter.format(end)+"'";
                result = sta.executeQuery(sql);
                while(result.next())
                {
                    ie_count[i] = result.getInt(1);
                }
                

                begin=end;
                calendar.add(Calendar.MONTH,1);
                end =  calendar.getTime();

            }

        }catch (SQLException e)
        {
            e.printStackTrace();

        }
        finally {
            dbmanage.closeDB(result, sta, conn);
        }
        int[][] browser_information={chrome_count,firefox_count,ie_count};
        return browser_information;
    }
	
}
