package com.example.springBootDemo.entity.vo.user;

public class UserInfoVO {
	
	private Integer userSn ; 
	private String  account ; 
	private String  userNick ; 
	private String  pwd ;
	private String  sex ; 
	private String  headUrl ; 
	private String  descripet ; 
	private String  status ;
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHeadUrl() {
		return headUrl;
	}
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
	
	public String getDescripet() {
		return descripet;
	}
	public void setDescripet(String descripet) {
		this.descripet = descripet;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getUserSn() {
		return userSn;
	}
	public void setUserSn(Integer userSn) {
		this.userSn = userSn;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	} 
	
}
