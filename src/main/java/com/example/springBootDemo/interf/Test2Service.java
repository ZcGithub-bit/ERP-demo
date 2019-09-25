package com.example.springBootDemo.interf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springBootDemo.dao.HelloDao;

@Service
public class Test2Service implements CommonInterface{
	
	private static final Logger logger = LoggerFactory.getLogger(Test2Service.class) ;
	
	@Autowired
	private HelloDao hellDao;	
	
	@Override
	public void init() {
		logger.info("当前加载类{}" , new Object[]{Test2Service.class.getName()});
	}
	
	@Override
	public String getUserNick(String account) {
		String userNick = hellDao.queryUserNickByAccount(account);
		return userNick;
	}
	
}
