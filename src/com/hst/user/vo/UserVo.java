package com.hst.user.vo;



public class UserVo{
	private int userId;
	private String userName;
	private String userPassword;
	private String userSex;
	private String userEmail;
	private String userOccup;
	
	
	public void setUserId(int userId){
		this.userId=userId;
	}
	public int getUserId(){
		return this.userId;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getUserName(){
		return userName;
	}
	
	public void setUserPassword(String userPassword){
		this.userPassword=userPassword;
	}
	public String getUserPassword(){
		return this.userPassword;
	}
	
	public void setUserSex(String userSex){
		this.userSex=userSex;
	}
	public String getUserSex(){
		return this.userSex;
	}
	
	public void setUserEmail(String userEmail){
		this.userEmail=userEmail;
	}
	public String getUserEmail(){
		return this.userEmail;
	}
	
	public void setUserOccup(String userOccup){
		this.userOccup=userOccup;
	}
	public String getUserOccup(){
		return this.userOccup;
	}
	
	

}
