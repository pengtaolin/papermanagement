package com.lin.paper.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lin.paper.bean.FaceNotice;
import com.lin.paper.pojo.PColumn;
import com.lin.paper.service.ColumnService;
import com.lin.paper.service.NoticeService;

/**
 * 页面跳转控制器
 * @author	lin
 * @date	2018年1月18日下午4:29:24
 * @version 1.0
 */
@Controller
public class PageController {
	@Resource
	private ColumnService columnService;
	@Resource
	private NoticeService noticeService;
	
	/**
	 * 前台主界面
	 * @return
	 */
	@RequestMapping("/index")
	public String toIndex(HttpServletRequest request) {
		//加载栏目数据(数据为空)
		//if (request.getSession().getServletContext().getAttribute("faceColumns") == null) {
			List<PColumn> faceColumns = columnService.getFaceColumns();
			request.getSession().getServletContext().setAttribute("faceColumns", faceColumns);
		//}
		
		//加载栏目公告数据(数据为空)
		//if (request.getSession().getServletContext().getAttribute("faceNotices") == null) {
			List<FaceNotice> faceNotices = columnService.getFaceNotices();
			request.getSession().getServletContext().setAttribute("faceNotices", faceNotices);
		//}
		//跳转到前端界面
		return "face/index";
	}
	
	/**
	 * 后台主界面
	 * @return
	 */
	@RequestMapping("/main")
	public String toMain() {
		
		return "index";
	}
	
	/**
	 * 登录界面
	 */
	@RequestMapping("/login")
	public String toLogin() {
		
		return "face/login";
	}
	
}
