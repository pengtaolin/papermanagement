package com.lin.paper.controller;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.lin.paper.pojo.PGroup;
import com.lin.paper.pojo.PInfo;
import com.lin.paper.service.GroupService;
import com.lin.paper.service.InfoService;
import com.lin.paper.utils.IDUtils;

/**
 * 工作小组信息控制器
 * @author	lin
 * @date	2018年2月6日下午7:26:39
 * @version 1.0
 */
@Controller
@RequestMapping("/group")
public class GroupController {
	
	@Resource
	private GroupService groupService;
	@Resource
	private InfoService infoService;
	
	/**
	 * 分页显示小组主界面
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping("/index{page}")
	public String index(Model model, @PathVariable("page") Integer page) {
		if (page == null) {
			page = 1;
		}
		//分页加载小组数据
		PageInfo<PGroup> groupList = groupService.getGroupList(page);
		//分页加载小组数据
		model.addAttribute("groupList", groupList);
		//跳转到界面
		return "group/group";
	}
	
	
	/**
	 * 转到添加栏小组界面
	 * @return
	 */
	@RequestMapping("/add")
	public String toAdd(Model model) {
		//加载用户数据 
		List<PInfo> infos = infoService.getUserInfoByRoleIn();
		//加载数据
		model.addAttribute("infos", infos);
		//跳转到界面
		return "group/groupAdd";
	}
	
	
	/**
	 * 添加小组信息
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Model model, PGroup group, HttpServletResponse response, HttpServletRequest request) throws Exception {
		//判断小组名是否已存在
		if (groupService.getGroupByName(group.getGroupname())!=null){
			//小组数据已经存在回显数据
			model.addAttribute("nameError", "小组名已存在");
			model.addAttribute("group", group);
			return toAdd(model);
		}else {
			//补全其他数据信息
			group.setGroupid(IDUtils.getGroupId());
			group.setCreatetime(new Date());
			group.setUpdatetime(new Date());
			//添加数据
			groupService.saveGroup(group);
			//跳转到界面
			return "redirect:/group/index.html";
		}
	}
	
	/**
	 * 根据小组ID删除数据
	 * @return
	 */
	@RequestMapping("/del/{groupid}")
	public String delete(Model model, @PathVariable("groupid") String groupid) {
		//删除小组数据
		groupService.deleteGroupById(groupid);
		
		return index(model, null);
	}
	
	
	/**
	 * 转到修改小组界面
	 * @param model
	 * @param groupid
	 * @return
	 */
	@RequestMapping(value="/toUp/{groupid}")
	public String toUpdate(Model model, @PathVariable("groupid") String groupid) {
		//加载用户数据 
		List<PInfo> infos = infoService.getUserInfoByRoleIn();
		//根据小组ID查询数据
		PGroup group = groupService.getGroupById(groupid);
		group.setUsers(infoService.getNameByIds(group.getUsers()));
		//添加数据
		model.addAttribute("group", group);
		model.addAttribute("infos", infos);
		//跳转到修改界面
		return "group/groupUpdate";
	}
	
	/**
	 * 修改小组数据
	 * @return
	 */
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(PGroup group, Model model) {
		//判断小组名是否已存在
		if (groupService.getGroupByName(group.getGroupname())!=null 
				&& !groupService.getGroupByName(group.getGroupname()).getGroupname().equals(group.getGroupname())){
			//小组已经存在回显数据
			model.addAttribute("nameError", "小组名已存在");
			model.addAttribute("group", group);
			return toUpdate(model, group.getGroupid());
		}else {
			//补全其他数据信息
			group.setUpdatetime(new Date());
			//更新数据
			groupService.updateGroup(group);
			//跳转到界面
			return toUpdate(model, group.getGroupid());
		}
	}
}
