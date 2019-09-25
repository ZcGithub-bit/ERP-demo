package com.example.springBootDemo.service.login;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springBootDemo.dao.login.LoginDao;
import com.example.springBootDemo.entity.form.login.LoginCheckForm;
import com.example.springBootDemo.entity.vo.user.UserInfoVO;
import com.example.springBootDemo.retcode.RetCode;

@Service
public class LoginService {
	
	@Autowired
	private LoginDao loginDao ; 
	
	/*
	 * 登陆验证
	 */
	public Map<String, Object> doLoginCheck(LoginCheckForm form) throws Exception{
		try {
			if (form.getAccount() == null || form.getPwd() == null ) {
				return RetCode.buildRetCodeResult(RetCode.LOGIN.ACCOUNT_PWD_NULL) ; 
			}
			UserInfoVO userInfoVO = loginDao.queryUserInfoByAccountAndPwd(form.getAccount() , form.getPwd() );
			if (userInfoVO == null ) {
				return RetCode.buildRetCodeResult(RetCode.LOGIN.USER_INFO_NOT_EXISTS) ; 
			}
			return RetCode.buildRetCodeResult(RetCode.SUCCESS) ; 
		} catch (Exception e) {
			return RetCode.buildRetCodeResult(RetCode.SYSTEM_ERROR) ;
		}
	}
	/*
	 * 获取用户信息
	 */
	public UserInfoVO queryAdminInfo(LoginCheckForm form) {
		UserInfoVO userInfoVO = loginDao.queryUserInfoByAccountAndPwd(form.getAccount() , form.getPwd() );
		return userInfoVO;
	}
	
}
