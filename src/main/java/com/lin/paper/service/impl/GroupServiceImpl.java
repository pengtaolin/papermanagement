package com.lin.paper.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.paper.mapper.PGroupMapper;
import com.lin.paper.pojo.PGroup;
import com.lin.paper.pojo.PGroupExample;
import com.lin.paper.pojo.PGroupExample.Criteria;
import com.lin.paper.service.GroupService;

/**
 * 小组的业务逻辑实现类
 * @author	lin
 * @date	2018年2月8日上午11:07:58
 * @version 1.0
 */
@Service
public class GroupServiceImpl implements GroupService {
	@Resource
	private PGroupMapper groupMapper;
	
	@Value("${GROUP_SHOW_ROWS}")
	private Integer GROUP_SHOW_ROWS;		//后台每页显示小组数据
	
	@Override
	public PageInfo<PGroup> getGroupList(Integer page) {
		//查询小组列表
		PGroupExample example = new PGroupExample();
		//排序显示
		example.setOrderByClause("updatetime DESC");
		//分页处理：page第几页，rows多少行
		PageHelper.startPage(page, GROUP_SHOW_ROWS);
		//查询数据
		List<PGroup> list = groupMapper.selectByExample(example);
		
		//创建一个返回值对象,设置数据
		PageInfo<PGroup> pageInfo = new PageInfo<>(list);
		
		return pageInfo;
	}

	@Override
	public PGroup getGroupByName(String groupname) {
		//创建查询条件
		PGroupExample example = new PGroupExample();
		Criteria criteria = example.createCriteria();
		criteria.andGroupnameEqualTo(groupname);
		//查询数据
		List<PGroup> list = groupMapper.selectByExample(example);
		
		if (list.size()==0) {
			return null;
		}else {
			return list.get(0);
		}
	}

	@Override
	public void saveGroup(PGroup group) {
		//插入数据
		groupMapper.insert(group);
	}

	@Override
	public void deleteGroupById(String groupid) {
		//删除数据
		groupMapper.deleteByPrimaryKey(groupid);
	}

	@Override
	public PGroup getGroupById(String groupid) {
		PGroup group = groupMapper.selectByPrimaryKey(groupid);
		return group;
	}

	@Override
	public void updateGroup(PGroup group) {
		PGroup group1 = groupMapper.selectByPrimaryKey(group.getGroupid());
		
		if (StringUtils.isEmpty(group.getUsers())){	//未选择用户
			group.setUsers(group1.getUsers());
		} 
		group.setCreatetime(group1.getCreatetime());
		
		//更新数据
		groupMapper.updateByPrimaryKey(group);
	}

}
