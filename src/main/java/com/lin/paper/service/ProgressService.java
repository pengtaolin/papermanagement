package com.lin.paper.service;

import java.util.List;

import com.lin.paper.pojo.PProgress;

/**
 * 进度的业务逻辑接口
 * @author	lin
 * @date	2018年3月12日下午3:34:33
 * @version 1.0
 */
public interface ProgressService {

	/**
	 * 添加进度信息
	 * @param userid 
	 * @param string
	 * @return
	 */
	String addProgress(String name, String userid);

	
	/**
	 * 根据ID查询当前进度
	 * @param progressid
	 * @return
	 */
	PProgress getProgressById(String progressid);


	/**
	 * 查询学生的所有进度
	 * @param userid
	 * @return
	 */
	List<PProgress> getProgressByStu(String userid);

	/**
	 * 更新指定进度的指定状态
	 * @param progressid
	 * @param i
	 */
	void updateProgressStateById(String progressid, int i);

	/**
	 * 更新进度数据
	 * @param progress
	 */
	void updateProgress(PProgress progress);

	/**
	 * 查询教师的所有需要审核的进度
	 * @param userid
	 * @return
	 */
	List<PProgress> getProgressByTeach(String userid);

	/**
	 * 创建新的进度
	 * @param progressid
	 * @return
	 */
	PProgress startNewProgress(String progressid);


}
