//package com.example.springBootDemo.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.example.springBootDemo.util.RedisUtil;
// 
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//public class RedisTest {
//	
//	@Resource
//	private RedisUtil redisUtils;
//	
//	/**
//	 * 插入缓存数据
//	 */
//	@Test
//	public void set() {
////		Map<String, Object> paraMap = new HashMap<String, Object>() ; 
////		paraMap.put("name", "a") ; 
////		paraMap.put("age", "3") ; 
////		redisUtils.hmset("person", paraMap);
//		
//		List<Object> list = new ArrayList<Object>() ; 
//		list.add("2") ; 
//		list.add("4") ; 
//		redisUtils.lSet2("list", list) ; 
//	}
//	
//	/**
//	 * 读取缓存数据
//	 */
//	@Test
//	public void get() {
//		String value = (String) redisUtils.get("list") ; 
//		System.out.println(value);
//	}
// 
//}