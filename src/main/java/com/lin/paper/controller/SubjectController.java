package com.lin.paper.controller;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.lin.paper.bean.UserInfo;
import com.lin.paper.pojo.PSubject;
import com.lin.paper.service.SelectService;
import com.lin.paper.service.SubjectService;
import com.lin.paper.utils.IDUtils;

/**
 * 课题信息控制器
 * @author	lin
 * @date	2018年3月9日上午10:33:17
 * @version 1.0
 */
@Controller
@RequestMapping("/subject")
public class SubjectController {
	
	@Resource
	private SubjectService subjectService;
	
	@Resource
	private SelectService selectService;
	
	/**
	 * 分页显示课题主界面
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping("/index{page}")
	public String index(Model model, @PathVariable("page") Integer page) {
		if (page == null) {
			page = 1;
		}
		//分页加载课题数据
		PageInfo<PSubject> subjectList = subjectService.getSubjectList(page);
		model.addAttribute("subjectList", subjectList);
		//跳转到界面
		return "subject/subject";
	}
	
	
	/**
	 * 分页显示教师的课题主界面
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping("/teach/index{page}")
	public String teachIndex(Model model, @PathVariable("page") Integer page, HttpSession session) {
		if (page == null) {
			page = 1;
		}
		
		//获得老师对象
		UserInfo userInfo = (UserInfo)session.getAttribute("session_user");
		
		//分页加载课题数据
		PageInfo<PSubject> subjectList = subjectService.getSubjectListByTeach(page, userInfo.getUserid());
		model.addAttribute("subjectList", subjectList);
		//跳转到界面
		return "subject/teach";
	}
	
	
	/**
	 * 转到添加课题界面
	 * @return
	 */
	@RequestMapping("/teach/add")
	public String toTeachAdd(Model model) {
		
		//跳转到界面
		return "subject/subjectAdd";
	}
	
	/**
	 * 添加课程信息
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/teach/save", method=RequestMethod.POST)
	public String save(Model model, PSubject subject, HttpSession session) throws Exception {
		//获得老师对象
		UserInfo userInfo = (UserInfo)session.getAttribute("session_user");
		
		//补全其他数据信息
		subject.setSubjectid(IDUtils.getSubjectId());
		subject.setTeachid(userInfo.getUserid());
		subject.setSubjecttype("教师命题");
		subject.setSubjectstate(0);
		subject.setCreateuser(userInfo.getUserid());
		
		subject.setCreatetime(new Date());
		subject.setUpdatetime(new Date());
		//添加数据
		subjectService.saveSubject(subject);
		//跳转到界面
		return "redirect:/subject/teach/index.html";
	}
	
	
	/**
	 * 根据课程ID删除数据
	 * @param subjectid
	 * @return
	 */
	@RequestMapping("/teach/del/{subjectid}")
	public String delete(@PathVariable("subjectid") String subjectid) {
		//删除课程数据
		subjectService.deleteSubjectById(subjectid);
		
		return "redirect:/subject/teach/index.html"; 
	}
	
	
	/**
	 * 转到修改课程界面
	 * @param model
	 * @param subjectid
	 * @return
	 */
	@RequestMapping(value="/teach/toUp/{subjectid}")
	public String toUpdate(Model model, @PathVariable("subjectid") String subjectid) {
		//根据课程ID查询数据
		PSubject subject = subjectService.getSubjectById(subjectid);
		//添加数据
		model.addAttribute("subject", subject);
		//跳转到修改界面
		return "subject/subjectUpdate";
	}
	
	
	/**
	 * 修改课程数据
	 * @return
	 */
	@RequestMapping(value="/teach/update", method=RequestMethod.POST)
	public String update(PSubject subject, Model model) {
		//补全其他数据信息
		subject.setUpdatetime(new Date());
		//更新数据
		subjectService.updateSubject(subject);
		//跳转到界面
		return toUpdate(model, subject.getSubjectid());
	}
	
	/**
	 * 修改指定课题信息的状态1
	 * @param subjectid
	 * @param state
	 * @return
	 */
	@RequestMapping(value="/teach/state/{subjectid}/{state}")
	public String state1(@PathVariable("subjectid") String subjectid, @PathVariable("state") Integer state) {
		PSubject subject = subjectService.getSubjectById(subjectid);
		
		subject.setSubjectstate(state);
		//更新数据
		subjectService.updateSubject(subject);
		
		return "redirect:/subject/teach/index.html"; 
	}
	
	
	/**
	 * 分页显示系主任的课题主界面
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping("/leader/index{page}")
	public String leaderIndex(Model model, @PathVariable("page") Integer page) {
		if (page == null) {
			page = 1;
		}
		
		//分页加载课题数据
		PageInfo<PSubject> subjectList = subjectService.getSubjectListByLeader(page);
		model.addAttribute("subjectList", subjectList);
		//跳转到界面
		return "subject/leader";
	}
	
	/**
	 * 修改指定课题信息的状态2
	 * @param subjectid
	 * @param state
	 * @return
	 */
	@RequestMapping(value="/leader/state/{subjectid}/{state}")
	public String state2(@PathVariable("subjectid") String subjectid, @PathVariable("state") Integer state) {
		PSubject subject = subjectService.getSubjectById(subjectid);
		subject.setSubjectstate(state);
		//更新数据
		subjectService.updateSubject(subject);
		
		return "redirect:/subject/leader/index.html"; 
	}
	
	
	/**
	 * 转到学生申请课题界面
	 * @return
	 */
	@RequestMapping("/stu/add")
	public String toStuAdd(Model model) {
		//跳转到界面
		return "subject/stuAdd";
	}
	
	/**
	 * 学生课程信息
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/stu/save", method=RequestMethod.POST)
	public String stuSave(PSubject subject, HttpSession session) throws Exception {
		//获得学生对象
		UserInfo userInfo = (UserInfo)session.getAttribute("session_user");
		
		//补全其他数据信息
		subject.setSubjectid(IDUtils.getSubjectId());
		subject.setTeachid(userInfo.getTeachid());
		subject.setSubjecttype("学生创建");
		subject.setSubjectstate(0);
		subject.setCreateuser(userInfo.getUserid());
		
		subject.setCreatetime(new Date());
		subject.setUpdatetime(new Date());
		//添加数据
		subjectService.saveSubject(subject);
		
		//跳转到界面
		return "redirect:/subject/stu/index.html"; 
		
	}
	
	/**
	 * 学生申请换题界面
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/stu/index")
	public String stuIndex(Model model, HttpSession session) {
		//获得学生对象
		UserInfo userInfo = (UserInfo)session.getAttribute("session_user");
		
		//分页加载课题数据
		List<PSubject> subjectList = subjectService.getSubjectListByStuid(userInfo.getUserid());
		
		model.addAttribute("subjectList", subjectList);
		//跳转到界面
		return "subject/stu";
	}
	
	/**
	 * 学生修改课题状态
	 * @param subjectid
	 * @param state
	 * @return
	 */
	@RequestMapping(value="/stu/state/{subjectid}/{state}")
	public String state3(@PathVariable("subjectid") String subjectid, @PathVariable("state") Integer state) {
		PSubject subject = subjectService.getSubjectById(subjectid);
		
		subject.setSubjectstate(state);
		//更新数据
		subjectService.updateSubject(subject);
		
		return "redirect:/subject/stu/index.html"; 
	}
	
	/**
	 * 学生根据课程ID删除数据
	 * @return
	 */
	@RequestMapping("/stu/del/{subjectid}")
	public String stuDelete(@PathVariable("subjectid") String subjectid) {
		//删除课程数据
		subjectService.deleteSubjectById(subjectid);
		
		return "redirect:/subject/stu/index.html"; 
	}
	
}
