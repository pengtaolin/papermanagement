package com.lin.paper.controller;




import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lin.paper.bean.UserInfo;
import com.lin.paper.pojo.PProgress;
import com.lin.paper.pojo.PSelect;
import com.lin.paper.service.ProgressService;
import com.lin.paper.service.SelectService;
import com.lin.paper.service.SubjectService;


/**
 * 论文进度控制器
 * @author	lin
 * @date	2018年3月10日下午4:15:54
 * @version 1.0
 */
@Controller
@RequestMapping("/progress")
public class ProgressController {
	
	@Resource
	private SelectService selectService;
	@Resource
	private SubjectService subjectService;
	@Resource
	private ProgressService progressService;
	
	
	/**
	 * 学生进度主界面
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/stu/index")
	public String stuIndex(Model model,HttpSession session) {
		//获得学生对象
		UserInfo userInfo = (UserInfo)session.getAttribute("session_user");
		
		//查询进度数据集合
		List<PProgress> progressList = progressService.getProgressByStu(userInfo.getUserid());
		
		//TODO 更新选题中的进度，session中的进度
		PSelect select = selectService.getSelectByStuAndState(userInfo.getUserid(), 3);
		if(select != null){
			userInfo.setSelect(select);
		}
		
		
		if (progressList != null) {
			for (PProgress pProgress : progressList) {
				pProgress.setProgressname(subjectService.getSubjectById(userInfo.getSelect().getSubjectid()).getSubjectname()+":"+pProgress.getProgressname());
			}
		}
		
		
		//加载数据
		model.addAttribute("progressList", progressList);
		
		//跳转到进度界面
		return "progress/stu";
	}
	
	
	/**
	 * 学生开始写作开题报告，启动
	 * @param model
	 * @param subjectid
	 * @param session
	 * @return
	 */
	@RequestMapping("/start/{subjectid}")
	public String start(Model model,@PathVariable String subjectid, HttpSession session) {
		//获得学生对象
		UserInfo userInfo = (UserInfo)session.getAttribute("session_user");
		
		//处理选题善后工作，1、删除选题表中该用户其他选题信息，2、修改选题的状态为写作中（3）
		PSelect select = selectService.startSelect(subjectid, userInfo.getTeachid(), userInfo.getUserid());
		
		//添加选题数据数据到session中
		userInfo.setSelect(select);
		
		//查询进度数据集合
		List<PProgress> progressList = progressService.getProgressByStu(userInfo.getUserid());
		
		//加载数据
		model.addAttribute("progressList", progressList);
		
		//跳转到进度界面
		return "redirect:/progress/stu/index.html";
	}
	
	
	/**
	 * 学生提交进度
	 * @param subjectid
	 * @return
	 */
	@RequestMapping("/stu/up/{progressid}")
	public String up(@PathVariable String progressid) {
		//更新状态
		progressService.updateProgressStateById(progressid,1);
		
		//跳转到进度主界面
		return "redirect:/progress/stu/index.html";
	}
	
	
	/**
	 * 教师进度主界面
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/teach/index")
	public String teachIndex(Model model,HttpSession session) {
		//获得老师对象
		UserInfo userInfo = (UserInfo)session.getAttribute("session_user");
		
		//查询进度数据集合
		List<PProgress> progressList = progressService.getProgressByTeach(userInfo.getUserid());
		
		//加载数据
		model.addAttribute("progressList", progressList);
		
		//跳转到进度界面
		return "progress/teach";
	}
	
	/**
	 * 教师审核通过
	 * @param progressid
	 * @return
	 */
	@RequestMapping("/teach/pass/{progressid}")
	public String pass(@PathVariable String progressid) {
		
		//创建新的进度
		PProgress progress = progressService.startNewProgress(progressid);
		
		
		if (progress != null) {
			//更新数据库中进度数据
			PSelect select = selectService.getSelectByStuAndState(progress.getUserid(), 3);//获得当前进度
			select.setProgressid(progress.getProgressid());
			selectService.updateSelect(select);
		}
		
		//跳转到进度主界面
		return "redirect:/progress/teach/index.html";
	}


	/**
	 * 教师审核未通过
	 * @param progressid
	 * @return
	 */
	@RequestMapping("/teach/nopass/{progressid}")
	public String nopass(@PathVariable String progressid) {
		//更新状态
		progressService.updateProgressStateById(progressid,3);
		
		//跳转到进度主界面
		return "redirect:/progress/teach/index.html";
	}
	
	
	/**
	 * 教师修改意见
	 * @param progressid
	 * @param advice
	 * @return
	 */
	@RequestMapping("/teach/advice/{progressid}")
	public String advice(@PathVariable String progressid, String advice) {
		//查询数据
		PProgress progress = progressService.getProgressById(progressid);
		if (progress != null) {
			progress.setAdvice(advice.trim());
			
			//更新数据
			progressService.updateProgress(progress);
		}
		
		//跳转到进度主界面
		return "redirect:/progress/teach/index.html";
	}
	
	
}
