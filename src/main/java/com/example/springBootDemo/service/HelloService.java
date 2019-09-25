package com.example.springBootDemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springBootDemo.dao.HelloDao;

@Service
public class HelloService {
	@Autowired
	private HelloDao hellDao;
	
	private static final Logger logger = LoggerFactory.getLogger(HelloService.class) ;

	public String queryAccount() {
		return hellDao.queryAccount();
	}

	public void updateUserName(String name) {
		hellDao.updateUserName(name);
	}

	public String queryUserName(String account) {
		return hellDao.queryUserName(account);
	}
	
}
