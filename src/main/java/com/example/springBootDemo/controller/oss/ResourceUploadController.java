package com.example.springBootDemo.controller.oss;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ResourceUploadController {
	@Autowired
	private com.example.springBootDemo.service.oss.ResourceUploadService ResourceUploadService ; 
	/**
	 * 
	 * @Project: springBootDemo 
	 * @Title: ResourceUploadController.java 
	 * @Package com.example.springBootDemo.controller.oss 
	 * @Description: 多文件上传到OSS 
	 * @author chen.zhao 
	 * @date Apr 17, 2019 9:35:53 AM  
	 * @version V1.0
	 */
	@ResponseBody
	@RequestMapping(value="uploadresource" , method = RequestMethod.POST)
	public  void uploadResource(HttpServletRequest request,  @RequestParam("files") MultipartFile[] files) throws Exception {
		if(files!=null && files.length>0){
			for (int i = 0; i < files.length; i++) {
				String head = ResourceUploadService.updateResourceAndGetUrl(files[i]);//此处是调用上传服务接口，获取URL
			}
		}
	}
	
}
