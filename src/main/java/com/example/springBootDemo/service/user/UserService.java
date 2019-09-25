package com.example.springBootDemo.service.user;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.springBootDemo.dao.user.UserDao;
import com.example.springBootDemo.entity.form.user.EditUserInfoForm;
import com.example.springBootDemo.entity.po.user.UserInfoPO;
import com.example.springBootDemo.entity.po.user.UserPhotoPO;
import com.example.springBootDemo.entity.vo.user.UserInfoVO;
import com.example.springBootDemo.entity.vo.user.UserPhotoVO;
import com.example.springBootDemo.service.oss.ResourceUploadService;
import com.example.springBootDemo.util.DateFormatUtil;
import com.example.springBootDemo.util.page.PageInfo;
import com.example.springBootDemo.util.page.PageUtil;

@Service
public class UserService {
	
	private  static  final Logger logger = LoggerFactory.getLogger(UserService.class) ;
	
	@Autowired
	private ResourceUploadService resourceUploadService ; 
	
	@Autowired
	private UserDao userDao ; 
	
	/**
	 * 
	 * @Project: springBootDemo 
	 * @Title: UserService.java 
	 * @Package com.example.springBootDemo.service.user 
	 * @Description: 新增用户相册图片 
	 * @author chen.zhao 
	 * @date Apr 17, 2019 2:25:42 PM  
	 * @version V1.0
	 */
	public void addUserPhoto(UserInfoVO admin, MultipartFile[] files) throws Exception{
		try {
			if( files == null ){
				return ; 
			}
			for (int i = 0; i < files.length; i++) {
				String imgUrl = resourceUploadService.updateResourceAndGetUrl(files[i]);//此处是调用上传服务接口，获取URL
				addUserPhoto( imgUrl , admin.getUserSn());
			}
		} catch (Exception e) {
			logger.info("错误日志："  , e);
		}
		
	}
	/*
	 * 新增相册图片
	 */
	private void addUserPhoto(String imgUrl, Integer userSn) {
		UserPhotoPO po = new UserPhotoPO(); 
		po.setUserSn(userSn);
		po.setImgUrl(imgUrl);
		po.setCreateDt(DateFormatUtil.CREATE_FULL_DATE_FORMATIN_STR());
		po.setCreateTm(DateFormatUtil.CREATE_FULL_DATE_STR_TM());
		userDao.addUserPhoto(po);
	}
	
	public PageInfo<UserPhotoVO> queryUserPhotosByUserSn(Map<String, Object> paramMap) throws Exception{
		try {
			PageInfo<UserPhotoVO> pageInfo = new PageInfo<UserPhotoVO>();
			paramMap.putAll( PageUtil.buildPage( Integer.valueOf(paramMap.get("pageNow").toString() ) , Integer.valueOf(paramMap.get("pageSize").toString() ) ) ) ;
			List<UserPhotoVO> userPhotoVOs = userDao.queryUserPhotosByUserSn(paramMap);
			Integer pageCount = userDao.queryUserPhotosByUserSnTotals(paramMap) ;
			pageInfo.setDataList(userPhotoVOs) ;
			pageInfo.setDataCount(pageCount);
			pageInfo.setCurrentlyPageNo(Integer.valueOf( paramMap.get("pageNow").toString())  );
			pageInfo.setPageSize( Integer.valueOf( paramMap.get("pageSize").toString()));
			return pageInfo;
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
		
	}
	public void editUserInfo(Integer userSn, EditUserInfoForm form, String headUrl) throws Exception{
		try {
			UserInfoPO po = new UserInfoPO();
			if ( StringUtils.isBlank(form.getFile().getOriginalFilename()) ) {//未上传头像，不做处理
				po.setHeadUrl(headUrl);
			}else {//上传新的头像
				String imgUrl = resourceUploadService.updateResourceAndGetUrl(form.getFile());
				logger.info(imgUrl);
				po.setHeadUrl(imgUrl);
			}
			po.setDescripet(form.getDescripet());
			po.setSex(form.getSex());
			po.setStatus(form.getStatus());
			po.setUserNick(form.getUserNick());
			po.setUserSn(userSn);
			userDao.editUserInfo(po);
		} catch (Exception e) {
			logger.error("错误日志：", e );
			throw e ;
		}
	}
	
	public UserInfoVO queryUserInfoByUserSn(Integer userSn) {
		UserInfoVO userInfoVO = userDao.queryUserInfoByUserSn(userSn);
		return userInfoVO;
	}
	
	
}
