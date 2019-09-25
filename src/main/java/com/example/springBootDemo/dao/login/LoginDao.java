package com.example.springBootDemo.dao.login;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.springBootDemo.entity.vo.user.UserInfoVO;

@Mapper
public interface LoginDao {

	UserInfoVO queryUserInfoByAccountAndPwd(@Param("account")String account, @Param("pwd")String pwd);
	
	
}
