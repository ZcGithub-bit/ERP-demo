package com.example.springBootDemo.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.springBootDemo.entity.form.user.EditUserInfoForm;
import com.example.springBootDemo.entity.vo.user.UserInfoVO;
import com.example.springBootDemo.entity.vo.user.UserPhotoVO;
import com.example.springBootDemo.service.user.UserService;
import com.example.springBootDemo.util.BeanUtil;
import com.example.springBootDemo.util.page.PageInfo;
import com.example.springBootDemo.util.page.PageUtil;
import com.example.springBootDemo.util.session.SeesionUtil;
import com.example.springBootDemo.util.session.UserSession;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService ; 
	
	private  static  final Logger logger = LoggerFactory.getLogger(UserController.class) ;
	/**
	 * 
	 * @Project: springBootDemo 
	 * @Title: UserController.java 
	 * @Package com.example.springBootDemo.controller.user 
	 * @Description: 上传用户相册图片
	 * @author chen.zhao 
	 * @date Apr 17, 2019 2:05:06 PM  
	 * @version V1.0
	 */
	@ResponseBody
	@RequestMapping(value="uploadphoto" , method = RequestMethod.POST)
	public  ModelAndView uploadResource(HttpServletRequest request,  @RequestParam("files") MultipartFile[] files) throws Exception {
		try {
			UserInfoVO admin = (UserInfoVO) request.getSession().getAttribute("loginUser");
			userService.addUserPhoto(admin , files );
			return  new ModelAndView("/main/imglist") ; 
		} catch (Exception e) {
			logger.error("跳转到用户图片列表失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	/**
	 * 
	 * @Project: springBootDemo 
	 * @Title: UserController.java 
	 * @Package com.example.springBootDemo.controller.user 
	 * @Description: 跳转到用户相册列表
	 * @author chen.zhao 
	 * @date Apr 17, 2019 2:57:01 PM  
	 * @version V1.0
	 */
	@RequestMapping(value="getimglistpage")
	public ModelAndView getImglistPage(HttpServletRequest request , HttpServletResponse response) {
		try {
			Map<String, Object> paramMap = BeanUtil.getOrderModel(request);
			Map<String, Object> model = new HashMap<String, Object>();
			UserInfoVO admin = (UserInfoVO) request.getSession().getAttribute("loginUser");
			paramMap.put("pageNow",  (paramMap.get("pageNow") == null || request.getParameter("pageNow").equals( "0" )  ) ? 1 : Integer.valueOf(paramMap.get("pageNow").toString()));
			paramMap.put("pageSize", (paramMap.get("pageSize") == null ) ? 3 : Integer.valueOf(paramMap.get("pageSize").toString() ));
			paramMap.put("userSn", admin.getUserSn()) ; 
			paramMap = PageUtil.matainPageNow(paramMap);
			PageInfo<UserPhotoVO> pageInfo = userService.queryUserPhotosByUserSn( paramMap );
			model.put("admin", admin) ; 
			model.put("pageInfo", pageInfo);
			return new ModelAndView("/main/imglist"  , model) ; 
		} catch (Exception e) {
			logger.error("跳转到用户相册列表页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
	/**
	 * 
	 * @Project: springBootDemo 
	 * @Title: UserController.java 
	 * @Package com.example.springBootDemo.controller.user 
	 * @Description: 跳转到用户基本信息页面
	 * @author chen.zhao 
	 * @date Apr 18, 2019 4:55:12 PM  
	 * @version V1.0
	 */
	@ResponseBody
	@RequestMapping(value="touserpage")
	public  ModelAndView queryUserInfo(HttpServletRequest request,  HttpServletResponse response, Integer userSn ) throws Exception {
		try {
			Map<String, Object> model = new HashMap<String, Object>();
//			UserInfoVO userInfo = userService.queryUserInfoByUserSn(userSn);
			UserSession admin = SeesionUtil.getBean(UserSession.class);
			logger.info("用户账号" +admin.getAccount());
			logger.info("用户昵称" +admin.getUserNick());
			model.put("user", admin) ; 
			model.put("admin", admin ) ; 
			return  new ModelAndView("/user/userInfo" , model ) ; 
		} catch (Exception e) {
			logger.error("跳转到用户基本信息页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
	/**
	 * 
	 * @Project: springBootDemo 
	 * @Title: UserController.java 
	 * @Package com.example.springBootDemo.controller.user 
	 * @Description: 编辑个人信息  
	 * @author chen.zhao 
	 * @date Apr 18, 2019 3:50:18 PM  
	 * @version V1.0
	 */
	@ResponseBody
	@RequestMapping(value="editUserInfo")
	public  ModelAndView editUserInfo(HttpServletRequest request,  HttpServletResponse response , EditUserInfoForm form) throws Exception {
		try {
			UserInfoVO admin = (UserInfoVO) request.getSession().getAttribute("loginUser");
			userService.editUserInfo(admin.getUserSn() , form , admin.getHeadUrl());
			return  queryUserInfo(request, response, admin.getUserSn()) ; 
		} catch (Exception e) {
			logger.error("跳转到用户图片列表失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
	
	
}
