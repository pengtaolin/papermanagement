package com.lin.paper.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.paper.bean.ColumnPerm;
import com.lin.paper.mapper.PRoleMapper;
import com.lin.paper.pojo.PRole;
import com.lin.paper.pojo.PRoleExample;
import com.lin.paper.pojo.PRoleExample.Criteria;
import com.lin.paper.service.PermissionService;
import com.lin.paper.service.RoleService;

/**
 * 角色信息业务逻辑实现类
 * @author	lin
 * @date	2018年1月28日下午9:14:54
 * @version 1.0
 */
@Service
public class RoleServiceImpl implements RoleService{
	@Value("${ROLE_SHOW_ROWS}")
	private Integer ROLE_SHOW_ROWS;		//后台每页显示角色数据
	@Resource
	private PRoleMapper roleMapper;
	@Resource
	private PermissionService permissionService;
	
	
	@Override
	public PageInfo<PRole> getRoleList(Integer page) {
		//查询角色列表
		PRoleExample example = new PRoleExample();
		//排序显示
		//分页处理：page第几页，rows多少行
		PageHelper.startPage(page, ROLE_SHOW_ROWS);
		//查询数据
		List<PRole> list = roleMapper.selectByExample(example);
		//创建一个返回值对象,设置数据
		PageInfo<PRole> pageInfo = new PageInfo<>(list);
		
		return pageInfo;
	}

	
	@Override
	public PRole getRoleByName(String rolename) {
		//查询角色列表
		PRoleExample example = new PRoleExample();
		//创建查询条件
		Criteria criteria = example.createCriteria();
		criteria.andRolenameEqualTo(rolename);
		//查询数据
		List<PRole> list = roleMapper.selectByExample(example);
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
		
	}

	
	@Override
	public void saveRole(PRole role) {
		//插入数据
		roleMapper.insert(role);
	}


	@Override
	public void updateRole(PRole role) {
		//查询原来的数据
		PRole role2 = roleMapper.selectByPrimaryKey(role.getRoleid());
		//判断权限内容是更改
		if (StringUtils.isEmpty(role.getPermissions())){	//没有更改
			//赋值原来的
			role.setPermissions(role2.getPermissions());	
		}
		//更新数据
		roleMapper.updateByPrimaryKey(role);
	}


	@Override
	public void deleteRoleById(String roleid) {
		//查询角色数据
		PRole role = roleMapper.selectByPrimaryKey(roleid);
		//修改角色状态
		role.setRolestate(1); 	//删除
		//更新角色数据
		roleMapper.updateByPrimaryKey(role);
	}


	@Override
	public PRole getRoleById(String roleid) {
		return roleMapper.selectByPrimaryKey(roleid);
	}


	@Override
	public List<PRole> getUserRoles() {
		//查询角色列表
		PRoleExample example = new PRoleExample();
		//创建查询条件
		Criteria criteria = example.createCriteria();
		criteria.andRolestateEqualTo(0);	//正常角色
		//查询数据
		List<PRole> list = roleMapper.selectByExample(example);
		return list;
	}


	@Override
	public String getNamesByIds(String roles) {
		if (!StringUtils.isEmpty(roles)) {
			//查询角色列表
			PRoleExample example = new PRoleExample();
			//设置查询条件
			Criteria criteria = example.createCriteria();
			List<String> ids = Arrays.asList(roles.split(","));
			criteria.andRoleidIn(ids);
			//查询数据
			List<PRole> list = roleMapper.selectByExample(example);
			
			//名称集合
			StringBuilder names = new StringBuilder();
			names.append(list.get(0).getRolename());
			
			for (int i = 1; i< list.size(); i++) {
				names.append(","+list.get(i).getRolename());
			}
			
			return names.toString();
		} else {
			return "";
		}
	}


	@Override
	public List<ColumnPerm> getColumnPermByRole(String roles) {
		List<ColumnPerm> columnPerms = null;
		if (!StringUtils.isEmpty(roles)) {
			//查询角色列表
			PRoleExample example = new PRoleExample();
			//设置查询条件
			Criteria criteria = example.createCriteria();
			List<String> ids = Arrays.asList(roles.split(","));
			criteria.andRoleidIn(ids);
			//查询数据
			List<PRole> list = roleMapper.selectByExample(example);	//角色集合
			Set<String> prems = new HashSet<>();
			for (PRole pRole : list) {
				String[] strings = pRole.getPermissions().split(",");
				for (String string : strings) {
					prems.add(string);
				}
			}
			String[] array = prems.toArray(new String[40]);	//新建权限ID集合
			
			columnPerms = permissionService.getColumnPermByPermissions(array);	//权限数据集合
			
			return columnPerms;
		} else {
			return columnPerms;
		}
	}

}
