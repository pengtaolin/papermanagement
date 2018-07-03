package com.lin.paper.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.github.pagehelper.PageInfo;
import com.lin.paper.bean.UploadNotice;
import com.lin.paper.pojo.PNotice;

/**
 * 公告信息业务逻辑接口
 * @author	lin
 * @date	2018年1月18日下午5:08:12
 * @version 1.0
 */
public interface NoticeService {

	/**
	 * 根据栏目ID查询前几条数据
	 * @param columnname
	 * @param i
	 * @return
	 */
	List<PNotice> getFaceNoticeByColumn(String columnid);

	/**
	 * 后台分页查询公告列表
	 * @param page
	 * @return
	 */
	PageInfo<PNotice> getNoticeList(Integer page);
	
	/**
	 * 尽可能同步上传的文件,返回存储数据对象
	 * @param uploadNotice
	 * @param path 
	 * @return
	 */
	PNotice uploadFile(UploadNotice uploadNotice, String path);

	/**
	 * 保存公告信息
	 * @param notice
	 */
	void saveNotice(PNotice notice);

	/**
	 * 根据ID删除公告信息
	 * @param noticeid
	 */
	void deleteNoticeById(String noticeid);

	/**
	 * 根据ID查询公告信息
	 * @param noticeid
	 * @return
	 */
	PNotice getNoticeById(String noticeid);

	/**
	 * 更新公告信息
	 * @param notice
	 */
	void updateNotice(PNotice notice);

	/**
	 * 根据栏目ID查询所有未删除公告信息
	 * @param columnid
	 * @return
	 */
	List<PNotice> getAllNoticeByColumn(String columnid);

	/**
	 * 浏览公告信息
	 * @param noticeid
	 * @return
	 */
	PNotice showNoticeById(String noticeid);

	/**
	 * 根据公告ID下载文件
	 * @param noticeid
	 * @return
	 */
	ResponseEntity<byte[]> downloadNoticeById(String noticeid, String path);

	/**
	 * 根据关键字分页加载公告数据
	 * @param page
	 * @param kw
	 * @return
	 */
	PageInfo<PNotice> getNoticeListByTitle(Integer page, String kw);

}
