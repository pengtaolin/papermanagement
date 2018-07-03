package com.lin.paper.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lin.paper.pojo.PTask;

/**
 * 任务数据业务逻辑接口
 * @author	lin
 * @date	2018年2月8日下午5:05:07
 * @version 1.0
 */
public interface TaskService {

	/**
	 * 分页显示任务集合数据
	 * @param page
	 * @return
	 */
	PageInfo<PTask> getTaskList(Integer page);

	/**
	 * 添加任务数据
	 * @param task
	 */
	void saveTask(PTask task);

	/**
	 * 更新任务数据状态
	 * @param taskid
	 * @param state
	 */
	void changeTaskState(String taskid, Integer state);

	/**
	 * 根据ID查询数据
	 * @param taskid
	 * @return
	 */
	PTask getTaskById(String taskid);

	/**
	 * 更新任务数据
	 * @param task
	 */
	void updateTask(PTask task);
	
	/**
	 * 根据任务状态查询数据
	 * @param state
	 * @return
	 */
	List<PTask> getTaskByState(Integer state);

}
