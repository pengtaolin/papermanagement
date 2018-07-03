package com.lin.paper.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lin.paper.bean.ColumnPerm;
import com.lin.paper.bean.FaceNotice;
import com.lin.paper.pojo.PColumn;
import com.lin.paper.pojo.PNotice;

/**
 * 栏目信息业务逻辑接口
 * @author	lin
 * @date	2018年1月18日下午5:07:32
 * @version 1.0
 */
public interface ColumnService {
	/**
	 * 查询所有未删除的后台栏目信息
	 * @return
	 */
	public List<PColumn> getAllBackColumn();
	/**
	 * 后台分页查询栏目列表
	 * @param page
	 * @param rows
	 * @return
	 */
	public PageInfo<PColumn> getColumnList(int page);
	
	/**
	 * 根据ID查询栏目信息
	 * @param columnId
	 * @return
	 */
	public PColumn getColumnById(String columnId);

	/**
	 * 根据ID删除栏目数据
	 * @param columnId
	 */
	public void deleteColumnById(String columnId);

	/**
	 * 更新栏目数据
	 * @param column
	 */
	public void updateColumn(PColumn column);
	
	/**
	 * 保存栏目数据
	 * @param column
	 */
	public void saveColumn(PColumn column);
	
	/**
	 * 根据name查询栏目信息
	 * @param columnname
	 * @return
	 */
	public PColumn getColumnByName(String columnname);


	/**
	 * 查询前台显示的栏目
	 * @return
	 */
	public List<PColumn> getFaceColumns();
	
	/**
	 * 查询前台显示的公告信息
	 * @return
	 */
	public List<FaceNotice> getFaceNotices();
	
	/**
	 * 根据父级ID删除栏目数据
	 * @param parentId
	 */
	void deleteColumnByParent(String parentId);
	
	/**
	 * 前台根据栏目ID分页查询公告数据
	 * @param page
	 * @param columnid
	 * @return
	 */
	public PageInfo<PNotice> getNoticeListByColumnId(Integer page, String columnid);
	
	/**
	 * 后台根据栏目ID与父节点ID查询栏目集合
	 * @param string
	 * @param i
	 * @return
	 */
	public List<ColumnPerm> getBackColumnsByIdAndParent(String columnids, String parentid);
	
}



