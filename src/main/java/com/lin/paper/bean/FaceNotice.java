package com.lin.paper.bean;

import java.util.List;


import com.lin.paper.pojo.PColumn;
import com.lin.paper.pojo.PNotice;

/**
 * 前台显示的公告信息
 * @author	lin
 * @date	2018年1月21日下午6:27:56
 * @version 1.0
 */
public class FaceNotice extends PColumn{
	
	private List<PNotice> notices;

	public List<PNotice> getNotices() {
		return notices;
	}

	public void setNotices(List<PNotice> notices) {
		this.notices = notices;
	}
	
}
