package com.lin.paper.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.paper.bean.ColumnPerm;
import com.lin.paper.mapper.PPermissionMapper;
import com.lin.paper.pojo.PPermission;
import com.lin.paper.pojo.PPermissionExample;
import com.lin.paper.pojo.PPermissionExample.Criteria;
import com.lin.paper.service.ColumnService;
import com.lin.paper.service.PermissionService;

/**
 * 权限信息业务逻辑实现类
 * @author	lin
 * @date	2018年1月28日下午9:13:48
 * @version 1.0
 */
@Service
public class PermissionServiceImpl implements PermissionService {
	@Value("${COLUMN_SHOW_ROWS}")
	private Integer COLUMN_SHOW_ROWS;		//后台每页显示数据
	
	@Resource
	private PPermissionMapper permissionMapper;
	@Resource
	private ColumnService columnService;
	
	
	@Override
	public PageInfo<PPermission> getPermissionList(Integer page) {
		//查询权限列表
		PPermissionExample example = new PPermissionExample();
		//排序显示
		//分页处理：page第几页，rows多少行
		PageHelper.startPage(page, COLUMN_SHOW_ROWS);
		//查询数据
		List<PPermission> list = permissionMapper.selectByExample(example);
		//创建一个返回值对象,设置数据
		PageInfo<PPermission> pageInfo = new PageInfo<>(list);
		
		return pageInfo;
	}


	@Override
	public void savePermission(PPermission permission) {
		//插入数据
		permissionMapper.insert(permission);
	}


	@Override
	public void updatePermission(PPermission permission) {
		if (permissionMapper.selectByPrimaryKey(permission.getPermissionid()) == null) {
			//插入数据
			permissionMapper.insert(permission);
		} else {
			//更新数据
			permissionMapper.updateByPrimaryKey(permission);
		}
	}


	@Override
	public void deletePermissionById(String permissionid) {
		//查找数据
		PPermission permission = permissionMapper.selectByPrimaryKey(permissionid);
		//修改状态
		permission.setPermissionstate(1);
		//更新数据
		permissionMapper.updateByPrimaryKey(permission);
	}


	@Override
	public PPermission getPermissionById(String permissionid) {
		//查询数据
		return permissionMapper.selectByPrimaryKey(permissionid);
	}


	@Override
	public List<PPermission> getRolePermissionList() {
		//查询权限列表
		PPermissionExample example = new PPermissionExample();
		//设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andPermissionstateEqualTo(0);	//0:正常
		//查询数据
		List<PPermission> list = permissionMapper.selectByExample(example);
		
		return list;
	}


	@Override
	public String getNamesByIds(String permissions) {
		//查询权限列表
		PPermissionExample example = new PPermissionExample();
		//设置查询条件
		Criteria criteria = example.createCriteria();
		List<String> ids = Arrays.asList(permissions.split(","));
		criteria.andPermissionidIn(ids);
		//查询数据
		List<PPermission> list = permissionMapper.selectByExample(example);
		if (list != null && list.size()>0) {
			//名称集合
			StringBuilder names = new StringBuilder();
			names.append(list.get(0).getPermissionname());
			
			for (int i = 1; i< list.size(); i++) {
				names.append(","+list.get(i).getPermissionname());
			}
			return names.toString();
		}else{
			return "";
		}
		
	}


	@Override
	public List<ColumnPerm> getColumnPermByPermissions(String[] permissionids) {
		List<ColumnPerm> columnPerms = null;
		if (permissionids.length != 0) {
			columnPerms = new ArrayList<>();
			//查询权限列表
			PPermissionExample example = new PPermissionExample();
			//设置查询条件
			Criteria criteria = example.createCriteria();
			List<String> ids = Arrays.asList(permissionids);
			criteria.andPermissionidIn(ids);
			criteria.andPermissionstateEqualTo(0);		//正常权限栏目
			//查询权限栏目数据
			List<PPermission> list = permissionMapper.selectByExample(example);
			if (list!=null && list.size()>0) {
				//权限栏目id数据
				StringBuffer columnids = new StringBuffer(list.get(0).getPermissionid());
				for (int i = 1; i<list.size(); i++) {
					columnids.append(","+list.get(i).getPermissionid());
				}
				columnPerms = columnService.getBackColumnsByIdAndParent(columnids.toString(), "1");
			}
			
			return columnPerms;
		} else {
			return columnPerms;
		}
	}

}
