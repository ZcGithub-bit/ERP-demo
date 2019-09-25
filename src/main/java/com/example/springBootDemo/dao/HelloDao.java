package com.example.springBootDemo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HelloDao {
	
	String queryAccount();

	void updateUserName(@Param("name")String name);

	String queryUserNickByAccount(@Param("account")String account);
	
	String queryUserName(@Param("account")String account);
	
}
