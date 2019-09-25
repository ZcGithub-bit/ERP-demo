package com.example.springBootDemo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.springBootDemo.service.HelloService;
import com.example.springBootDemo.util.BeanUtil;

@Controller
public class HelloController {
	@Autowired
	private HelloService helloService ; 
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class) ;
	
	@PostConstruct
	public void init() {
		System.out.println("初始化HelloController");
	}

	@RequestMapping(value="test" )
    public ModelAndView say(){
		logger.info("hha");
		String account = helloService.queryAccount();
		logger.info(account);
        return new ModelAndView("view/2048");
    }

	@RequestMapping(value="move" )
    public ModelAndView move(){
		logger.info("hha");
        return new ModelAndView("view/move");
    }
	
	@RequestMapping(value="mario" )
    public ModelAndView mario(String account){
		String userName = helloService.queryUserName(account);
		logger.info("当前操作用户名:" + userName);
        return new ModelAndView("mario");
    }
	/**
	 * 
	 * @Project: springBootDemo 
	 * @Title: HelloController.java 
	 * @Package com.example.springBootDemo.controller 
	 * @Description: 测试ajax请求  
	 * @author chen.zhao 
	 * @date Mar 1, 2019 5:23:49 PM  
	 * @version V1.0
	 */
	@ResponseBody
	@RequestMapping(value="changename")
	public Map<String, Object> changeName(HttpServletRequest request , HttpServletResponse response) {
		Map<String, Object> paraMap = BeanUtil.getOrderModel(request);
//		helloService.updateUserName(paraMap.get("name").toString());
		Map<String, Object> data = new HashMap<>() ;
		data.put("code", "0") ; 
		data.put("codeMsg", "成功");
		return data ; 
	}
	
	
}
