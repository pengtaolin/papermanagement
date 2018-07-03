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
import com.lin.paper.pojo.PPermission;
import com.lin.paper.pojo.PRole;
import com.lin.paper.service.PermissionService;
import com.lin.paper.service.RoleService;
import com.lin.paper.utils.IDUtils;


/**
 * 角色信息控制器
 * @author	lin
 * @date	2018年1月28日下午8:37:32
 * @version 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Resource
	private RoleService roleService;
	@Resource
	private PermissionService permissionService;
	
	/**
	 * 分页显示后台角色主界面
	 * @return
	 */
	@RequestMapping("/index{page}")
	public String index(Model model, @PathVariable("page") Integer page) {
		if (page == null) {
			page = 1;
		}
		//分页加载角色数据
		PageInfo<PRole> roleList = roleService.getRoleList(page);
		//分页加载角色数据
		model.addAttribute("roleList", roleList);
		//跳转到界面
		return "role/role";
	}
	
	
	
	/**
	 * 转到添加角色界面
	 * @return
	 */
	@RequestMapping("/add")
	public String toAdd(Model model) {
		//加载所有权限数据 
		List<PPermission> permissionList = permissionService.getRolePermissionList();
		//设置数据
		model.addAttribute("permissionList", permissionList);
		//跳转到界面
		return "role/roleAdd";
	}
	
	/**
	 * 添加角色数据界面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Model model, PRole role,  HttpServletResponse response, HttpServletRequest request) {
		//判断角色名是否已存在
		if (roleService.getRoleByName(role.getRolename())!=null){
			//角色名已经存在回显数据
			model.addAttribute("nameError", "角色名已存在");
			model.addAttribute("role", role);
			String prems = permissionService.getNamesByIds(role.getPermissions());
			//已选权限
			model.addAttribute("perms", prems);
			return toAdd(model);
		}else {
			//补全其他数据信息
			role.setRoleid(IDUtils.getRoleId());
			role.setCreatetime(new Date());
			role.setUpdatetime(new Date());
			//添加数据
			roleService.saveRole(role);
			//跳转到界面
			return "redirect:/role/index.html";
		}
	}
	
	
	
	/**
	 * 转到修改角色界面
	 * @param model
	 * @param roleid
	 * @return
	 */
	@RequestMapping(value="/toUp/{roleid}")
	public String toUpdate(Model model, @PathVariable("roleid") String roleid) {
		//加载所有权限数据 
		List<PPermission> permissionList = permissionService.getRolePermissionList();
		//设置数据
		model.addAttribute("permissionList", permissionList);
		
		//根据角色ID查询数据
		PRole role = roleService.getRoleById(roleid);
		//添加数据
		model.addAttribute("role", role);
		
		//已选权限
		String prems = permissionService.getNamesByIds(role.getPermissions());
		model.addAttribute("perms", prems);
		//跳转到修改界面
		return "role/roleUpdate";
	}
	
	/**
	 * 修改角色信息
	 * @param permission
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(PRole role, Model model) {
		//判断角色名是否已存在
		PRole role2 = roleService.getRoleByName(role.getRolename());
		if (role2 !=null && !role2.getRoleid().equals(role.getRoleid())){
			//角色名已经存在回显数据
			model.addAttribute("nameError", "角色名已存在");
			//跳转到界面
			return toUpdate(model, role.getRoleid());
		}else {
			//补全其他数据信息
			role.setUpdatetime(new Date());
			//更新数据
			roleService.updateRole(role);
			//跳转到界面
			return toUpdate(model, role.getRoleid());
		}
	}
	
	
	/**
	 * 删除角色信息
	 * @param model
	 * @param roleid
	 * @return
	 */
	@RequestMapping(value="/delete/{roleid}")
	public String delete(Model model, @PathVariable("roleid") String roleid) {
		//删除角色信息
		roleService.deleteRoleById(roleid);
		//返回主页		
		return index(model, null);
	}
}
