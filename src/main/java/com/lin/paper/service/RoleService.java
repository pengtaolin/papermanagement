package com.lin.paper.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lin.paper.bean.ColumnPerm;
import com.lin.paper.pojo.PRole;

/**
 * 角色信息的业务逻辑接口
 * @author	lin
 * @date	2018年1月28日下午8:38:26
 * @version 1.0
 */
public interface RoleService {

	/**
	 * 分页加载所有有用的角色集合
	 * @param page
	 * @return
	 */
	PageInfo<PRole> getRoleList(Integer page);
	
	/**
	 * 根据角色名查找数据
	 * @param rolename
	 * @return
	 */
	PRole getRoleByName(String rolename);

	/**
	 * 保存角色数据
	 * @param role
	 */
	void saveRole(PRole role);

	/**
	 * 更新用户信息
	 * @param role
	 */
	void updateRole(PRole role);
	
	/**
	 * 根据ID删除用户信息
	 * @param roleid
	 */
	void deleteRoleById(String roleid);

	/**
	 * 根据ID查找角色信息
	 * @param roleid
	 * @return
	 */
	PRole getRoleById(String roleid);

	/**
	 * 获得所有的用户角色集合
	 * @return
	 */
	List<PRole> getUserRoles();

	/**
	 * 根据ID查询所有角色名称
	 * @param roles
	 * @return
	 */
	String getNamesByIds(String roles);
	
	/**
	 * 获得所有用户的权限列表
	 * @param roles
	 * @return
	 */
	List<ColumnPerm> getColumnPermByRole(String roles);

}
