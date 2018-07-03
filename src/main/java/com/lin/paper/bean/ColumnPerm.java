package com.lin.paper.bean;

import java.io.Serializable;
import java.util.List;

import com.lin.paper.pojo.PColumn;

/**
 * 权限使用的菜单栏目
 * @author	lin
 * @date	2018年2月1日下午9:36:07
 * @version 1.0
 */
public class ColumnPerm extends PColumn implements Serializable{
	private static final long serialVersionUID = 1L;
	//子节点
	private List<ColumnPerm> childs;

	public List<ColumnPerm> getChilds() {
		return childs;
	}

	public void setChilds(List<ColumnPerm> childs) {
		this.childs = childs;
	}

}
