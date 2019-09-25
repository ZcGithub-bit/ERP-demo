package com.example.springBootDemo.retcode;

public class Login {

	@RetCodeElement(value="账号密码不能为空") 
	public final String ACCOUNT_PWD_NULL = "L001" ; 
	
	@RetCodeElement(value="账号信息不存在") 
	public final String USER_INFO_NOT_EXISTS = "L002" ;
	
}
