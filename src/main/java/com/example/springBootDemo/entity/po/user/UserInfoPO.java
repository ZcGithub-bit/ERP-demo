package com.example.springBootDemo.entity.po.user;

public class UserInfoPO {
	private Integer userSn ; 
	private String userNick ; 
	private String descripet ; 
	private String sex ; 
	private String status ;
	private String headUrl ; 
	
	public String getHeadUrl() {
		return headUrl;
	}
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
	public Integer getUserSn() {
		return userSn;
	}
	public void setUserSn(Integer userSn) {
		this.userSn = userSn;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	
	public String getDescripet() {
		return descripet;
	}
	public void setDescripet(String descripet) {
		this.descripet = descripet;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
