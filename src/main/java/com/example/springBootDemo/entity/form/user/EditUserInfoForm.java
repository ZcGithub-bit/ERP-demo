package com.example.springBootDemo.entity.form.user;

import org.springframework.web.multipart.MultipartFile;

public class EditUserInfoForm {
	private MultipartFile file ; //头像
	private String userNick ; 
	private String descripet ; 
	private String sex ; 
	private String status ;
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
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
