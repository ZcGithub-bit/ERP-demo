package com.example.springBootDemo.service.oss;

import java.io.ByteArrayInputStream;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSSClient;

@Service
public class ResourceUploadService {
	
	private  static  final Logger logger = LoggerFactory.getLogger(ResourceUploadService.class) ;
	
	private String endpoint = "http://oss-cn-shanghai.aliyuncs.com" ; //EndPoint（地域节点)
	private String bucket = "bucket-zc" ; 
	private String accessId = "LTAIlViXWEGdEqN6";
	private String accesskey = "GJCLLcrropwwMTwWJdPbhr8Lj2p29D";
	
	public String updateResourceAndGetUrl(MultipartFile file) throws Exception{
		try {
			String fileName = file.getOriginalFilename();
			OSSClient ossClient = new OSSClient(endpoint, accessId, accesskey);
	        ossClient.putObject(bucket, fileName, new ByteArrayInputStream(file.getBytes()));//图片上传
			ossClient.shutdown();
			Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
			String url = ossClient.generatePresignedUrl(bucket, fileName, expiration).toString();//获取URL
			return url;
		} catch (Exception e) {
			logger.error("上传资源失败：" ,e);
			return "";
		}
	    
	}
	
}
