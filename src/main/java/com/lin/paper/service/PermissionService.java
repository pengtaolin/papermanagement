package com.lin.paper.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lin.paper.bean.ColumnPerm;
import com.lin.paper.pojo.PPermission;

/**
 * 权限信息业务逻辑接口
 * @author	lin
 * @date	2018年1月28日下午8:52:06
 * @version 1.0
 */
public interface PermissionService {

	/**
	 * 分页显示权限列表
	 * @param page
	 * @return
	 */
	PageInfo<PPermission> getPermissionList(Integer page);
	
	/**
	 * 添加权限信息
	 * @param permission
	 */
	void savePermission(PPermission permission);

	/**
	 * 更新权限信息
	 * @param permission
	 */
	void updatePermission(PPermission permission);
	
	/**
	 * 根据ID删除权限信息
	 * @param permissionid
	 */
	void deletePermissionById(String permissionid);

	/**
	 * 根据ID查找权限信息
	 * @param permissionid
	 * @return
	 */
	PPermission getPermissionById(String permissionid);

	/**
	 * 加载显示角色界面中的权限（加载权限状态为正常的）
	 * @return
	 */
	List<PPermission> getRolePermissionList();

	/**
	 * 根据ID查询所有权限名称
	 * @param permissions
	 * @return
	 */
	String getNamesByIds(String permissions);

	/**
	 * 根据权限栏目ID查询出权限栏目列表
	 * @param permissionids
	 * @return
	 */
	List<ColumnPerm> getColumnPermByPermissions(String[] permissionids);

}
