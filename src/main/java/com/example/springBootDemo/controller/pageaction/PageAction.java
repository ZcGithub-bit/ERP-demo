package com.example.springBootDemo.controller.pageaction;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.springBootDemo.entity.vo.user.UserInfoVO;

@Controller
public class PageAction {
	
	private static final Logger logger = LoggerFactory.getLogger(PageAction.class) ;
	
	@RequestMapping(value="gettoppage")
	public ModelAndView getTopPage(HttpServletRequest request , HttpServletResponse response) {
		try {
			logger.info("gettoppage");
			Map<String, Object> model = new HashMap<String, Object>();
			UserInfoVO admin = getAdmin(request);
			model.put("admin", admin) ; 
			return new ModelAndView("/main/top" , model ) ; 
		} catch (Exception e) {
			logger.error("跳转到登陆页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
	@RequestMapping(value="getleftpage")
	public ModelAndView getLeftPage(HttpServletRequest request , HttpServletResponse response) {
		try {
			logger.info("getleftpage");
			Map<String, Object> model = new HashMap<String, Object>();
			UserInfoVO admin = getAdmin(request);
			model.put("admin", admin) ; 
			return new ModelAndView("/main/left" , model ) ; 
		} catch (Exception e) {
			logger.error("跳转到登陆页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
	@RequestMapping(value="getindexpage")
	public ModelAndView getIndexPage(HttpServletRequest request , HttpServletResponse response) {
		try {
			Map<String, Object> model = new HashMap<String, Object>();
			UserInfoVO admin = (UserInfoVO)request.getSession().getAttribute("loginUser") ;
			model.put("admin", admin) ; 
			logger.info("getindexpage");
			return new ModelAndView("/main/index" , model) ; 
		} catch (Exception e) {
			logger.error("跳转到登陆页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
	@RequestMapping(value="getfooterpage")
	public ModelAndView getFooterPage(HttpServletRequest request , HttpServletResponse response) {
		try {
			logger.info("getfooterpage");
			Map<String, Object> model = new HashMap<String, Object>();
			UserInfoVO admin = getAdmin(request);
			model.put("admin", admin) ; 
			return new ModelAndView("/main/footer" , model) ; 
		} catch (Exception e) {
			logger.error("跳转到登陆页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
	@RequestMapping(value="getdefaultpage")
	public ModelAndView getDefaultPage(HttpServletRequest request , HttpServletResponse response) {
		try {
			logger.info("getdefaultpage");
			Map<String, Object> model = new HashMap<String, Object>();
			UserInfoVO admin = getAdmin(request);
			model.put("admin", admin) ; 
			return new ModelAndView("/main/default" , model) ; 
		} catch (Exception e) {
			logger.error("跳转到登陆页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
	@RequestMapping(value="getimgtablepage")
	public ModelAndView getImgtablePage(HttpServletRequest request , HttpServletResponse response) {
		try {
			logger.info("getimgtablepage");
			Map<String, Object> model = new HashMap<String, Object>();
			UserInfoVO admin = getAdmin(request);
			model.put("admin", admin) ; 
			return new ModelAndView("/main/imgtable" , model) ; 
		} catch (Exception e) {
			logger.error("跳转到登陆页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
	
		
	/*
	 * 获取登陆用户信息
	 */
	private UserInfoVO getAdmin(HttpServletRequest request) {
		UserInfoVO admin = (UserInfoVO)request.getSession().getAttribute("loginUser") ;
		return admin;
	}
	
	@RequestMapping(value="getimglist1page")
	public ModelAndView getImglist1Page(HttpServletRequest request , HttpServletResponse response) {
		try {
			logger.info("getimglist1page");
			Map<String, Object> model = new HashMap<String, Object>();
			UserInfoVO admin = getAdmin(request);
			model.put("admin", admin) ; 
			return new ModelAndView("/main/imglist1" , model) ; 
		} catch (Exception e) {
			logger.error("跳转到登陆页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
	
	@RequestMapping(value="gettoolspage")
	public ModelAndView getToolsPage(HttpServletRequest request , HttpServletResponse response) {
		try {
			logger.info("gettoolspage");
			Map<String, Object> model = new HashMap<String, Object>();
			UserInfoVO admin = getAdmin(request);
			model.put("admin", admin) ; 
			return new ModelAndView("/main/tools" , model) ; 
		} catch (Exception e) {
			logger.error("跳转到登陆页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
	@RequestMapping(value="getcomputerpage")
	public ModelAndView getComputerPage(HttpServletRequest request , HttpServletResponse response) {
		try {
			logger.info("getcomputerpage");
			Map<String, Object> model = new HashMap<String, Object>();
			UserInfoVO admin = getAdmin(request);
			model.put("admin", admin) ; 
			return new ModelAndView("/main/computer" , model) ; 
		} catch (Exception e) {
			logger.error("跳转到登陆页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
	@RequestMapping(value="gettabpage")
	public ModelAndView getTabPage(HttpServletRequest request , HttpServletResponse response) {
		try {
			logger.info("gettabpage");
			Map<String, Object> model = new HashMap<String, Object>();
			UserInfoVO admin = getAdmin(request);
			model.put("admin", admin) ; 
			return new ModelAndView("/main/tab" , model ) ; 
		} catch (Exception e) {
			logger.error("跳转到登陆页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
	@RequestMapping(value="getrightpage")
	public ModelAndView getRightPage(HttpServletRequest request , HttpServletResponse response) {
		try {
			logger.info("getrightpage");
			Map<String, Object> model = new HashMap<String, Object>();
			UserInfoVO admin = getAdmin(request);
			model.put("admin", admin) ; 
			return new ModelAndView("/main/right" , model) ; 
		} catch (Exception e) {
			logger.error("跳转到登陆页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
	@RequestMapping(value="getformpage")
	public ModelAndView getFormPage(HttpServletRequest request , HttpServletResponse response) {
		try {
			logger.info("getformpage");
			Map<String, Object> model = new HashMap<String, Object>();
			UserInfoVO admin = getAdmin(request);
			model.put("admin", admin) ; 
			return new ModelAndView("/main/form" , model) ; 
		} catch (Exception e) {
			logger.error("跳转到登陆页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
	@RequestMapping(value="getfilllistpage")
	public ModelAndView getFilllistPage(HttpServletRequest request , HttpServletResponse response) {
		try {
			logger.info("getfilllistpage");
			Map<String, Object> model = new HashMap<String, Object>();
			UserInfoVO admin = getAdmin(request);
			model.put("admin", admin) ; 
			return new ModelAndView("/main/filllist" ,model) ; 
		} catch (Exception e) {
			logger.error("跳转到登陆页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
	@RequestMapping(value="geterrorpage")
	public ModelAndView getErrorPage(HttpServletRequest request , HttpServletResponse response) {
		try {
			logger.info("geterrorpage");
			Map<String, Object> model = new HashMap<String, Object>();
			UserInfoVO admin = getAdmin(request);
			model.put("admin", admin) ; 
			return new ModelAndView("/login/error" , model) ; 
		} catch (Exception e) {
			logger.error("跳转到登陆页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
	@RequestMapping(value="getflowpage")
	public ModelAndView getFlowPage(HttpServletRequest request , HttpServletResponse response) {
		try {
			logger.info("getflowpage");
			Map<String, Object> model = new HashMap<String, Object>();
			UserInfoVO admin = getAdmin(request);
			model.put("admin", admin) ; 
			return new ModelAndView("/main/flow" , model) ; 
		} catch (Exception e) {
			logger.error("跳转到登陆页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
	@RequestMapping(value="getprojectpage")
	public ModelAndView getProjectPage(HttpServletRequest request , HttpServletResponse response) {
		try {
			logger.info("getprojectpage");
			Map<String, Object> model = new HashMap<String, Object>();
			UserInfoVO admin = getAdmin(request);
			model.put("admin", admin) ; 
			return new ModelAndView("/main/project" , model) ; 
		} catch (Exception e) {
			logger.error("跳转到登陆页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
	@RequestMapping(value="getsearchpage")
	public ModelAndView getSearchPage(HttpServletRequest request , HttpServletResponse response) {
		try {
			logger.info("getsearchpage");
			return new ModelAndView("/main/search") ; 
		} catch (Exception e) {
			logger.error("跳转到登陆页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
	@RequestMapping(value="gettechpage")
	public ModelAndView getTechPage(HttpServletRequest request , HttpServletResponse response) {
		try {
			logger.info("gettechpage");
			Map<String, Object> model = new HashMap<String, Object>();
			UserInfoVO admin = getAdmin(request);
			model.put("admin", admin) ; 
			return new ModelAndView("/main/tech" , model) ; 
		} catch (Exception e) {
			logger.error("跳转到登陆页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
	@RequestMapping(value="getpicuploadpage")
	public ModelAndView getPicUploadPage(HttpServletRequest request , HttpServletResponse response) {
		try {
			logger.info("getpicuploadpage");
			Map<String, Object> model = new HashMap<String, Object>();
			UserInfoVO admin = getAdmin(request);
			model.put("admin", admin) ; 
			return new ModelAndView("/main/picupload" , model) ; 
		} catch (Exception e) {
			logger.error("跳转到登陆页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
	@RequestMapping(value="login1")
	public ModelAndView login1(HttpServletRequest request , HttpServletResponse response) {
		try {
			logger.info("login1");
			Map<String, Object> model = new HashMap<String, Object>();
			return new ModelAndView("/index" , model ) ; 
		} catch (Exception e) {
			logger.error("跳转到登陆页面失败" , e);
			return new ModelAndView("/login/error") ; 
		}
	}
	
}
