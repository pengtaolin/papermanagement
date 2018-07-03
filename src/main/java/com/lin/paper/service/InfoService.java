package com.lin.paper.service;

import java.util.List;

import com.lin.paper.bean.UserInfo;
import com.lin.paper.pojo.PInfo;

/**
 * 用户信息的业务逻辑接口
 * @author	lin
 * @date	2018年1月18日下午4:32:14
 * @version 1.0
 */
public interface InfoService {

	/**
	 * 获得所有未删除的用户数据
	 * @return
	 */
	public List<PInfo> getAllUserInfo();

	/**
	 * 查询单条用户信息数据
	 * @param userid
	 * @return
	 */
	public UserInfo getUserInfoById(String userid);

	/**
	 * 添加用户信息数据
	 * @param userInfo
	 */
	public void saveUserInfo(UserInfo userInfo);

	/**
	 * 批量上传用户信息数据
	 * @param userInfo
	 * @param path
	 */
	public void uploadFile(UserInfo userInfo, String path);

	/**
	 * 根据第ID删除用户信息数据
	 * @param userid
	 */
	public void deleteUserInfoById(String userid);

	/**
	 * 更新用户信息数据
	 * @param userInfo
	 */
	public void updateUserInfo(UserInfo userInfo);

	/**
	 *  加载教师小组用户信息
	 * @return
	 */
	public List<PInfo> getUserInfoByRoleIn();
	
	/**
	 * 指定ID查询用户姓名
	 * @param users
	 * @return
	 */
	public String getNameByIds(String users);
}
