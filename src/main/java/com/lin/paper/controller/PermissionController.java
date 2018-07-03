package com.lin.paper.controller;




import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.lin.paper.pojo.PPermission;
import com.lin.paper.service.PermissionService;


/**
 * 权限信息控制器
 * @author	lin
 * @date	2018年1月28日下午8:49:53
 * @version 1.0
 */
@Controller
@RequestMapping("/perm")
public class PermissionController {
	
	@Resource
	private PermissionService permissionService;
	
	/**
	 * 分页显示后台权限主界面
	 * @return
	 */
	@RequestMapping("/index{page}")
	public String index(Model model, @PathVariable("page") Integer page) {
		if (page == null) {
			page = 1;
		}
		//分页加载权限数据
		PageInfo<PPermission> permList = permissionService.getPermissionList(page);
		//分页加载权限数据
		model.addAttribute("permList", permList);
		//跳转到界面
		return "permission/permission";
	}
	
	
	/**
	 * 转到修改权限界面
	 * @param model
	 * @param permissionid
	 * @return
	 */
	@RequestMapping(value="/toUp/{permissionid}")
	public String toUpdate(Model model, @PathVariable("permissionid") String permissionid) {
		//根据权限ID查询数据
		PPermission permission = permissionService.getPermissionById(permissionid);
		//添加数据
		model.addAttribute("permission", permission);
		//跳转到修改界面
		return "permission/permissionUpdate";
	}
	
	/**
	 * 修改权限数据
	 * @return
	 */
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(PPermission permission, Model model) {
		//补全其他数据信息
		permission.setUpdatetime(new Date());
		//更新数据
		permissionService.updatePermission(permission);
		//跳转到界面
		return toUpdate(model, permission.getPermissionid());
	}
	
	/**
	 * 删除权限信息
	 * @param model
	 * @param permissionid
	 * @return
	 */
	@RequestMapping(value="/delete/{permissionid}")
	public String delete(Model model, @PathVariable("permissionid") String permissionid) {
		//删除权限信息
		permissionService.deletePermissionById(permissionid);
		//返回主页		
		return index(model, null);
	}
	
}
