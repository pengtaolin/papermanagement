package com.lin.paper.controller;


import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.lin.paper.bean.ScoreTable;
import com.lin.paper.bean.UserInfo;
import com.lin.paper.pojo.PSelect;
import com.lin.paper.pojo.PSubject;
import com.lin.paper.pojo.PTask;
import com.lin.paper.service.ProgressService;
import com.lin.paper.service.SelectService;
import com.lin.paper.service.SubjectService;
import com.lin.paper.service.TaskService;
import com.lin.paper.utils.IDUtils;

/**
 * 选题信息控制器
 * @author	lin
 * @date	2018年3月9日下午4:00:08
 * @version 1.0
 */
@Controller
@RequestMapping("/select")
public class SelectController {
	
	@Resource
	private SelectService selectService;
	@Resource
	private TaskService taskService;
	@Resource
	private SubjectService subjectService;
	@Resource
	private ProgressService progressService;
	
	
	/**
	 * 转到添加选题界面
	 * @return
	 */
	@RequestMapping("/teach/add/{subjectid}")
	public String toTeachAdd(Model model, @PathVariable("subjectid") String subjectid) {
		//查找当前运行中的任务信息
		List<PTask> taskList = taskService.getTaskByState(1);
		//添加任务列表信息数据
		model.addAttribute("taskList", taskList);
		
		//查找课题信息
		PSubject subject = subjectService.getSubjectById(subjectid);
		//添加课题数据
		model.addAttribute("subject", subject);
		
		//跳转到界面
		return "select/teachAdd";
	}
	
	
	/**
	 * 添加选题信息
	 * @param model
	 * @param subject
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/teach/save", method=RequestMethod.POST)
	public String save(Model model, PSelect select, Integer maxselect) throws Exception {
		
		for (int i=0; i<maxselect; i++) {
			PSelect pSelect = new PSelect();
			BeanUtils.copyProperties(select, pSelect);
			
			//补全其他数据信息
			select.setSelectid(IDUtils.getSelectId());
			select.setSelectstate(0);
			select.setStuid("");
			
			select.setCreatetime(new Date());
			select.setUpdatetime(new Date());
			//添加数据
			selectService.saveSelect(select);
		}
		
		//修改选题状态
		PSubject subject = subjectService.getSubjectById(select.getSubjectid());
		subject.setSubjectstate(6);
		subjectService.updateSubject(subject);
		
		//跳转到界面
		return "redirect:/subject/teach/index.html";
	}
	
	/**
	 * 显示学生选题主界面
	 * @param model
	 * @param page
	 * @param session
	 * @return
	 */
	@RequestMapping("/stu/index")
	public String stuIndex(Model model, HttpSession session) {
		
		//获取学生的信息
		UserInfo userInfo = (UserInfo)session.getAttribute("session_user");
		
		//加载学生选题信息集合
		List<PSubject> subjectList = subjectService.getSubjectListByStu(userInfo.getMajor());
		
		
		//选题状态设置
		subjectList = selectService.getSelectStatesByStu(subjectList,userInfo.getUserid());
		
		//添加数据
		model.addAttribute("subjectList", subjectList);
		//跳转到界面
		return "select/select";
	}
	
	/**
	 * 学生选择选题
	 * @param subjectid
	 * @param session
	 * @return
	 */
	@RequestMapping("/stu/add/{subjectid}")
	public String stuAdd(@PathVariable("subjectid") String subjectid, HttpSession session) {
		//获取学生的信息
		UserInfo userInfo = (UserInfo)session.getAttribute("session_user");
		
		//查询空闲的选题数据
		PSelect select = selectService.getFirstSelectBySubjectid(subjectid, "");
		if (select != null) {	//不为空开始添加数据
			select.setStuid(userInfo.getUserid());
			select.setUpdatetime(new Date());
			//更新数据
			selectService.updateSelect(select);
		}
		
		//跳转到界面
		return "redirect:/select/stu/index.html";
	}
	
	
	/**
	 * 分页显示教师审核主界面
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping("/teach/index{page}")
	public String teachIndex(Model model, @PathVariable("page") Integer page, HttpSession session) {
		if (page == null) {
			page = 1;
		}
		
		//获取角色的信息
		UserInfo userInfo = (UserInfo)session.getAttribute("session_user");
		
		//分页加载选题数据
		PageInfo<PSelect> selectList = selectService.getSelectList(page, userInfo.getUserid());
		model.addAttribute("selectList", selectList);
		//跳转到界面
		return "select/teach";
	}
	
	/**
	 * 修改指定选课的信息的状态
	 * @param selectid
	 * @param state
	 * @return
	 */
	@RequestMapping(value="/teach/state/{selectid}/{state}")
	public String state(@PathVariable("selectid") String selectid, @PathVariable("state") Integer state) {
		PSelect select = selectService.getSelectById(selectid);	
		//修改状态
		select.setSelectstate(state);
		//更新数据
		selectService.updateSelect(select);
		
		return "redirect:/select/teach/index.html";
	}
	
	/**
	 * 教师的选题重新让学生选择
	 * @param selectid
	 * @return
	 */
	@RequestMapping(value="/teach/restart/{selectid}")
	public String restart(@PathVariable("selectid") String selectid) {
		PSelect select = selectService.getSelectById(selectid);	
		//修改状态
		select.setSelectstate(0);
		select.setStuid(""); 	//学生为空
		//更新数据
		selectService.updateSelect(select);
		
		return "redirect:/select/teach/index.html";
	}
	
	
	
	/**
	 * 分页显示选题汇总主界面
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping("/leader/index{page}")
	public String index(Model model, @PathVariable("page") Integer page) {
		if (page == null) {
			page = 1;
		}
		
		//分页加载选题数据
		PageInfo<PSelect> selectList = selectService.getSelectListByLeader(page);
		model.addAttribute("selectList", selectList);
		
		//跳转到界面
		return "select/leader";
	}
	
	
	/**
	 * 查询最后成绩数据
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/stu/score")
	public String score(HttpSession session, Model model) {
		
		//获取学生的信息
		UserInfo userInfo = (UserInfo)session.getAttribute("session_user");
		
		PSelect select = userInfo.getSelect(); 
		
		PSelect select2 = null;
		/*if (select != null && select.getScore() != null) {
			select2 = new PSelect();
			BeanUtils.copyProperties(select, select2);
			//设置题目
			select2.setSubjectid(subjectService.getSubjectById(select.getSubjectid()).getSubjectname());
			//设置进度
			select2.setProgressid(progressService.getProgressById(select.getProgressid()).getProgressname());
			
			model.addAttribute("select", select2);
		} else if (select != null && select.getScore() == null){*/
			select2 = selectService.getSelectById(select.getSelectid());
			select.setScore(select2.getScore());
			//设置题目
			select2.setSubjectid(subjectService.getSubjectById(select.getSubjectid()).getSubjectname());
			//设置进度
			select2.setProgressid(progressService.getProgressById(select.getProgressid()).getProgressname());
			
			if (select2!=null&&select2.getScore()!=null){
				//保留两位小数
				DecimalFormat dFormat=new DecimalFormat("#.00");  
	            String score = dFormat.format(select2.getScore());  
				
	    		String[] scores = score.split("\\.");
	    		model.addAttribute("first", scores[0]);
	    		model.addAttribute("second", scores[1]);
	    		
	    		Double sum = Double.parseDouble(scores[0])*ScoreTable.PAPER_BASE+Double.parseDouble(scores[1])*ScoreTable.PAPER_SHOW;		
	    		
	    		model.addAttribute("sumscore", sum);
			}
			
			model.addAttribute("select", select2);
		//}
		
		//跳转到界面
		return "select/score";
	}
	
	/**
	 * 论文成绩汇总
	 * @param model
	 * @return
	 */
	@RequestMapping("/leader/score/index")
	public String leaderIndex(Model model) {
		//论文成绩信息汇总
		List<ScoreTable> scoreTables = selectService.getScoreListByLeader();
		
		model.addAttribute("scoreTables", scoreTables);
		//跳转到界面
		return "select/scoretable";
	}
}
