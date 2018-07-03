package com.lin.paper.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.lin.paper.pojo.PPaper;

/**
 * 论文文档的业务逻辑接口
 * @author	lin
 * @date	2018年3月12日下午9:24:43
 * @version 1.0
 */
public interface PaperService {

	/**
	 * 下载论文信息
	 * @param progressid
	 * @param path
	 * @return
	 */
	ResponseEntity<byte[]> downloadPaperById(String progressid, String path);

	/**
	 * 上传文件
	 * @param papername
	 * @param file
	 * @param file
	 * @param path
	 * @return
	 */
	PPaper uploadFile(String papername, String paperid, MultipartFile file, String path);

	/**
	 * 添加论文文档数据
	 * @param paper
	 */
	void savePaper(PPaper paper);

	/**
	 * 根据ID查询文章数据
	 * @param paperid
	 * @return
	 */
	PPaper getPaperById(String paperid);

	/**
	 * 更新文档数据
	 * @param paper
	 */
	void updatePaper(PPaper paper);

	/**
	 * 加载管理员后台文档数据
	 * @param page
	 * @return
	 */
	PageInfo<PPaper> getPaperList(Integer page);

	/**
	 * 加载系主任后台文档数据
	 * @param page
	 * @return
	 */
	PageInfo<PPaper> getPaperListByLeader(Integer page);

	/**
	 * 加载教师的后台文档数据
	 * @param teachid
	 * @return
	 */
	List<PPaper> getPaperListByTeach(String teachid);


}
