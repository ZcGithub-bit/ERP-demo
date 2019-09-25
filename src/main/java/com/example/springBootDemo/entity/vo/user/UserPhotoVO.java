package com.example.springBootDemo.entity.vo.user;

public class UserPhotoVO {
	private Integer upId ; 
	private Integer userSn ;
	private String  imgUrl ; 
	private String  createDt ; 
	private String  createTm ; 
	private String  isDeleted ;
	public Integer getUpId() {
		return upId;
	}
	public void setUpId(Integer upId) {
		this.upId = upId;
	}
	public Integer getUserSn() {
		return userSn;
	}
	public void setUserSn(Integer userSn) {
		this.userSn = userSn;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	public String getCreateTm() {
		return createTm;
	}
	public void setCreateTm(String createTm) {
		this.createTm = createTm;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	} 
	
}
