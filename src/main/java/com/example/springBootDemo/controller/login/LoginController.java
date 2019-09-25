package com.example.springBootDemo.controller.login;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.springBootDemo.entity.form.login.LoginCheckForm;
import com.example.springBootDemo.entity.vo.user.UserInfoVO;
import com.example.springBootDemo.retcode.RetCode;
import com.example.springBootDemo.service.login.LoginService;
import com.example.springBootDemo.util.session.SeesionUtil;
import com.example.springBootDemo.util.session.UserSession;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class) ;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserSession userSession ; 
	

    /**
     * 将登录的用户存入session
     */
    public void addSession(UserInfoVO userInfo){
//    	UserSession userSession = new UserSession();
    		userSession.setUserSn(userInfo.getUserSn());
        userSession.setAccount(userInfo.getAccount());
        userSession.setUserNick(userInfo.getUserNick());
        userSession.setDescripet(userInfo.getDescripet());
        userSession.setHeadUrl(userInfo.getHeadUrl());
        userSession.setPwd(userInfo.getPwd());
        userSession.setSex(userInfo.getSex());
        userSession.setStatus(userInfo.getStatus());
        UserSession admin = SeesionUtil.getBean(UserSession.class);
        System.out.println("登陆用户账号：" + admin.getAccount());
        System.out.println("登陆用户昵称：" + admin.getUserNick());
    }
	
	/**
	 * 
	 * @Project: springBootDemo 
	 * @Title: LoginController.java 
	 * @Package com.example.springBootDemo.controller.login 
	 * @Description: 登陆页面  
	 * @author chen.zhao 
	 * @date Apr 11, 2019 7:24:19 PM  
	 * @version V1.0
	 */
	@RequestMapping(value="tologin")
	public ModelAndView toLoginPage(HttpServletRequest request , HttpServletResponse response) {
		try {
			logger.info("tologin");
			return new ModelAndView("/login/login") ; 
		} catch (Exception e) {
			logger.error("跳转到登陆页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	/**
	 * 
	 * @Project: springBootDemo 
	 * @Title: LoginController.java 
	 * @Package com.example.springBootDemo.controller.login 
	 * @Description: 登陆验证
	 * @author chen.zhao 
	 * @date Apr 11, 2019 7:24:01 PM  
	 * @version V1.0
	 */
	@ResponseBody
	@RequestMapping(value="logincheck")
    public Map<String, Object> loginCheck(HttpServletRequest request , HttpServletResponse response , LoginCheckForm form )throws Exception{
    	try { 
    			Map<String, Object> model  = loginService.doLoginCheck(form);
    			UserInfoVO admin = loginService.queryAdminInfo(form);
    			this.addSession(admin);
    			request.getSession().setAttribute("loginUser", admin);
			return model;
		} catch (Exception e) {
			logger.error("修改作品模板排序失败", e);
			return RetCode.buildRetCodeResult(RetCode.SUCCESS);
		}
    }
	/**
	 * 
	 * @Project: springBootDemo 
	 * @Title: LoginController.java 
	 * @Package com.example.springBootDemo.controller.login 
	 * @Description: 跳转到主页
	 * @author chen.zhao 
	 * @date Apr 11, 2019 7:43:29 PM  
	 * @version V1.0
	 */
	@ResponseBody
	@RequestMapping(value="tomainpage")
	public ModelAndView toMainPage(HttpServletRequest request , HttpServletResponse response) {
		try {
			logger.info("跳转到主页");
			return new ModelAndView("/main/main") ; 
		} catch (Exception e) {
			logger.error("跳转到登陆页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
	
}
