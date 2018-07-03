package com.lin.paper.service;

import com.github.pagehelper.PageInfo;
import com.lin.paper.pojo.PGroup;

/**
 * 小组的业务逻辑接口
 * @author	lin
 * @date	2018年2月8日上午11:07:21
 * @version 1.0
 */
public interface GroupService {

	/**
	 * 分页显示小组数据信息
	 * @param page
	 * @return
	 */
	PageInfo<PGroup> getGroupList(Integer page);

	/**
	 * 根据小组名称查询数据
	 * @param groupname
	 * @return
	 */
	PGroup getGroupByName(String groupname);

	/**
	 * 保存小组数据
	 * @param group
	 */
	void saveGroup(PGroup group);
	
	/**
	 * 删除小组信息
	 * @param groupid
	 */
	void deleteGroupById(String groupid);

	/**
	 * 根据ID查询小组信息
	 * @param groupid
	 * @return
	 */
	PGroup getGroupById(String groupid);

	/**
	 * 更新小组信息
	 * @param group
	 */
	void updateGroup(PGroup group);

}
