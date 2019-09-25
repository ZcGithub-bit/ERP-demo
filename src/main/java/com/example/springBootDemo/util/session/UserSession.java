package com.example.springBootDemo.util.session;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class UserSession implements Serializable{

    private static final long serialVersionUID = 9120765714832970813L;
    private Integer userSn ; 
	private String  account ; 
	private String  userNick ; 
	private String  pwd ;
	private String  sex ; 
	private String  headUrl ; 
	private String  descripet ; 
	private String  status ;
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
    
    //getter  setter 方法
}
//
//这里注意@Scope注解：
//    @Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)这个是说在每次注入的时候回自动创建一个新的bean实例
//    @Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)单例模式，在整个应用中只能创建一个实例
//    @Scope(value=WebApplicationContext.SCOPE_GLOBAL_SESSION)全局session中的一般不常用
//    @Scope(value=WebApplicationContext.SCOPE_APPLICATION)在一个web应用中只创建一个实例
//    @Scope(value=WebApplicationContext.SCOPE_REQUEST)在一个请求中创建一个实例
//    @Scope(value=WebApplicationContext.SCOPE_SESSION)每次创建一个会话中创建一个实例
//里面还有个属性
//    proxyMode=ScopedProxyMode.INTERFACES创建一个JDK代理模式
//    proxyMode=ScopedProxyMode.TARGET_CLASS基于类的代理模式
//    proxyMode=ScopedProxyMode.NO（默认）不进行代理
