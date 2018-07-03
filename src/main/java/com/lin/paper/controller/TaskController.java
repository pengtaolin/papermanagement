package com.lin.paper.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.lin.paper.pojo.PTask;
import com.lin.paper.service.TaskService;
import com.lin.paper.utils.IDUtils;

/**
 * 任务信息控制器
 * @author	lin
 * @date	2018年2月6日下午4:42:36
 * @version 1.0
 */
@Controller
@RequestMapping("/task")
public class TaskController {
	@Resource
	private TaskService taskService;
	
	
	/**
	 * 分页显示任务主界面
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping("/index{page}")
	public String index(Model model, @PathVariable("page") Integer page) {
		if (page == null) {
			page = 1;
		}
		//分页加载任务数据
		PageInfo<PTask> taskList = taskService.getTaskList(page);
		//分页加载任务数据
		model.addAttribute("taskList", taskList);
		//跳转到界面
		return "task/task";
	}
	
	
	
	/**
	 * 转到添加任务界面
	 * @return
	 */
	@RequestMapping("/add")
	public String toAdd() {
		
		//跳转到界面
		return "task/taskAdd";
	}
	
	
	/**
	 * 添加任务信息
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(PTask task, String years) throws Exception {
		
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(years);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		//补全其他数据信息
        task.setYear(date);
		task.setTaskid(IDUtils.getTaskId());
		task.setTaskstate(0);		//正常
		task.setCreatetime(new Date());
		//添加数据
		taskService.saveTask(task);
		//跳转到界面
		return "redirect:/task/index.html";
	}
	
	/**
	 * 更新数据状态
	 * @return
	 */
	@RequestMapping("/state/{taskid}/{state}")
	public String state(Model model, @PathVariable("taskid") String taskid, @PathVariable("state") Integer state) {
		//更新任务数据状态
		taskService.changeTaskState(taskid,state);
		
		return index(model, null);
	}
	
	
	/**
	 * 转到修改任务界面
	 * @param model
	 * @param taskid
	 * @return
	 */
	@RequestMapping(value="/toUp/{taskid}")
	public String toUpdate(Model model, @PathVariable("taskid") String taskid) {
		//根据任务ID查询数据
		PTask task = taskService.getTaskById(taskid);
		//添加数据
		model.addAttribute("task", task);
		//跳转到修改界面
		return "task/taskUpdate";
	}
	
	/**
	 * 修改任务数据
	 * @return
	 */
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(PTask task, String years, Model model) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(years);
        } catch (Exception e) {
            e.printStackTrace();
        }
		//补全其他数据信息
		task.setYear(date);
		//更新数据
		taskService.updateTask(task);
		//跳转到界面
		return toUpdate(model, task.getTaskid());
	}
	
}
