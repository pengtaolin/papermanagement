package com.lin.paper.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.paper.mapper.PTaskMapper;
import com.lin.paper.pojo.PTask;
import com.lin.paper.pojo.PTaskExample;
import com.lin.paper.pojo.PTaskExample.Criteria;
import com.lin.paper.service.TaskService;


/**
 * 任务数据业务逻辑实现类
 * @author	lin
 * @date	2018年2月8日下午5:04:48
 * @version 1.0
 */
@Service
public class TaskServiceImpl implements TaskService{

	@Resource
	private PTaskMapper taskMapper;
	
	@Value("${TASK_SHOW_ROWS}")
	private Integer TASK_SHOW_ROWS;		//后台每页显示任务数据
	
	@Override
	public PageInfo<PTask> getTaskList(Integer page) {
		//查询小组列表
		PTaskExample example = new PTaskExample();
		//排序显示
		example.setOrderByClause("year DESC");
		//分页处理：page第几页，rows多少行
		PageHelper.startPage(page, TASK_SHOW_ROWS);
		//查询数据
		List<PTask> list = taskMapper.selectByExample(example);
		
		//创建一个返回值对象,设置数据
		PageInfo<PTask> pageInfo = new PageInfo<>(list);
		
		return pageInfo;
	}

	@Override
	public void saveTask(PTask task) {
		//插入数据
		taskMapper.insert(task);
	}

	@Override
	public void changeTaskState(String taskid, Integer state) {
		//查找数据
		PTask task = taskMapper.selectByPrimaryKey(taskid);
		//更新状态
		task.setTaskstate(state);
		//更新数据
		taskMapper.updateByPrimaryKey(task);
	}

	@Override
	public PTask getTaskById(String taskid) {
		return taskMapper.selectByPrimaryKey(taskid);
	}

	@Override
	public void updateTask(PTask task) {
		taskMapper.updateByPrimaryKey(task);
	}

	@Override
	public List<PTask> getTaskByState(Integer state) {
		//查询小组列表
		PTaskExample example = new PTaskExample();
		//排序显示
		example.setOrderByClause("year DESC");
		//查询条件
		Criteria criteria = example.createCriteria();
		criteria.andTaskstateEqualTo(state);
		//查询数据
		List<PTask> list = taskMapper.selectByExample(example);
		if (list != null && list.size()>0) {
			return list;
		}else {
			return null;
		}
	}

}
