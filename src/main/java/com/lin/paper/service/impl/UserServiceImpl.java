package com.lin.paper.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import com.lin.paper.bean.ColumnPerm;
import com.lin.paper.mapper.PUserMapper;
import com.lin.paper.pojo.PUser;
import com.lin.paper.pojo.PUserExample;
import com.lin.paper.pojo.PUserExample.Criteria;
import com.lin.paper.service.RoleService;
import com.lin.paper.service.UserService;

/**
 * 用户信息的业务逻辑实现类
 * @author	lin
 * @date	2018年1月18日下午4:33:17
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private PUserMapper userMapper;
	@Resource
	private RoleService roleService;
	

	@Override
	public void restartPwd(String userid) {
		//查询数据
		PUser user = userMapper.selectByPrimaryKey(userid);
		//设置密码
		user.setPwd(DigestUtils.md5Hex(user.getUserno()).toString());
		//更新数据
		userMapper.updateByPrimaryKey(user);
	}


	@Override
	public PUser login(PUser user) {
		PUserExample example = new PUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserstateEqualTo(0);	//数据正常
		criteria.andUsernoEqualTo(user.getUserno());	//用户名
		criteria.andPwdEqualTo(DigestUtils.md5Hex(user.getPwd()).toString());	//密码
		List<PUser> list = userMapper.selectByExample(example);
		
		//存在用户数据
		if (list.size() > 0) {
			return list.get(0);
		}
		
		return null;
	}


	@Override
	public List<ColumnPerm> getColumnPermByUser(PUser user) {
		List<ColumnPerm> columnPerms = roleService.getColumnPermByRole(user.getRoles());
		return columnPerms;
	}
}
