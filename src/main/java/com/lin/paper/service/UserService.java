package com.lin.paper.service;

import java.util.List;

import com.lin.paper.bean.ColumnPerm;
import com.lin.paper.pojo.PUser;

/**
 * 用户的业务逻辑接口
 * @author	lin
 * @date	2018年1月18日下午4:32:14
 * @version 1.0
 */
public interface UserService {

	/**
	 * 用户登录验证
	 * @param user
	 * @return
	 */
	public PUser login(PUser user);

	
	/**
	 * 重置用户密码
	 * @param userid
	 */
	public void restartPwd(String userid);

	/**
	 * 获得指定用户的菜单权限列表
	 * @param user
	 * @return
	 */
	public List<ColumnPerm> getColumnPermByUser(PUser user);
}
