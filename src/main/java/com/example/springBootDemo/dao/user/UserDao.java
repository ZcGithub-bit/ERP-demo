package com.example.springBootDemo.dao.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.springBootDemo.entity.po.user.UserInfoPO;
import com.example.springBootDemo.entity.po.user.UserPhotoPO;
import com.example.springBootDemo.entity.vo.user.UserInfoVO;
import com.example.springBootDemo.entity.vo.user.UserPhotoVO;

@Mapper
public interface UserDao {
	
	void addUserPhoto(UserPhotoPO po);

	List<UserPhotoVO> queryUserPhotosByUserSn(Map<String, Object> paramMap);

	Integer queryUserPhotosByUserSnTotals(Map<String, Object> paramMap);

	void editUserInfo(UserInfoPO po);

	UserInfoVO queryUserInfoByUserSn(@Param("userSn")Integer userSn);
	
}
