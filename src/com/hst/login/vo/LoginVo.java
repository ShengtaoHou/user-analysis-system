package com.hst.login.vo;

import java.sql.Timestamp;

public class LoginVo{
	private int loginId;
	private int userId;
	private String userIP;
	private String userBrowser;
	private String userOS;
	private String userLang;
	private Timestamp loginTime;
	
	public void setLoginId(int loginId){
		this.loginId=loginId;
	}
	public int getLoginId(){
		return this.loginId;
	}
	
	public void setUserId(int userId){
		this.userId=userId;
	}
	public int getUserId(){
		return userId;
	}
	
	public void setUserIP(String userIP){
		this.userIP=userIP;
	}
	public String getUserIP(){
		return this.userIP;
	}
	
	public void setUserBrowser(String userBrowser){
		this.userBrowser=userBrowser;
	}
	public String getUserBrowser(){
		return this.userBrowser;
	}
	
	public void setUserOS(String userOS){
		this.userOS=userOS;
	}
	public String getUserOS(){
		return this.userOS;
	}
	
	public void setUserLang(String userLang){
		this.userLang=userLang;
	}
	public String getUserLang(){
		return this.userLang;
	}
	
	public void setLoginTime(Timestamp loginTime){
		this.loginTime=loginTime;
	}
	public Timestamp getLoginTime(){
		return this.loginTime;
	}
}
