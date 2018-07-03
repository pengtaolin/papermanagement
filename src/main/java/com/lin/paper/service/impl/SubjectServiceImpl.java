package com.lin.paper.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.paper.mapper.PInfoMapper;
import com.lin.paper.mapper.PSubjectMapper;
import com.lin.paper.pojo.PGroup;
import com.lin.paper.pojo.PInfo;
import com.lin.paper.pojo.PSubject;
import com.lin.paper.pojo.PSubjectExample;
import com.lin.paper.pojo.PSubjectExample.Criteria;
import com.lin.paper.service.GroupService;
import com.lin.paper.service.SubjectService;
import com.mysql.fabric.xmlrpc.base.Array;

/**
 * 课题的业务逻辑实现类
 * @author	lin
 * @date	2018年3月9日上午10:54:35
 * @version 1.0
 */
@Service
public class SubjectServiceImpl implements SubjectService {
	@Resource
	private PSubjectMapper subjectMapper;
	
	@Resource
	private PInfoMapper infoMapper;
	
	@Resource
	private GroupService groupService;
	
	@Value("${SUBJECT_SHOW_ROWS}")
	private Integer SUBJECT_SHOW_ROWS;		//后台每页显示课题数据

	@Override
	public PageInfo<PSubject> getSubjectList(Integer page) {
		//查询课题列表
		PSubjectExample example = new PSubjectExample();
		//排序显示
		example.setOrderByClause("teachid DESC");
		//分页处理：page第几页，rows多少行
		PageHelper.startPage(page, SUBJECT_SHOW_ROWS);
		Criteria criteria = example.createCriteria();
		List<Integer> values = new ArrayList<>();
		values.add(0);
		criteria.andSubjectstateNotIn(values);
		//查询数据
		List<PSubject> list = subjectMapper.selectByExampleWithBLOBs(example);
		
		//补全指导老师与创建者的姓名
		for (PSubject pSubject : list) {
			//指导老师
			pSubject.setTeachid(infoMapper.selectByPrimaryKey(pSubject.getTeachid()).getName());
			//创建者
			pSubject.setCreateuser(infoMapper.selectByPrimaryKey(pSubject.getCreateuser()).getName());
		}
		
		//创建一个返回值对象,设置数据
		PageInfo<PSubject> pageInfo = new PageInfo<>(list);
		
		return pageInfo;
	}

	@Override
	public PageInfo<PSubject> getSubjectListByTeach(Integer page, String teachid) {
		//分页处理：page第几页，rows多少行
		PageHelper.startPage(page, SUBJECT_SHOW_ROWS);
		
		List<PSubject> list = getSubjectListByTeachid(teachid);
		if (list!=null && list.size()>0) {
			//补全指导老师与创建者的姓名
			for (PSubject pSubject : list) {
				//创建者
				pSubject.setCreateuser(infoMapper.selectByPrimaryKey(pSubject.getCreateuser()).getName());
			}
		}
		
		//创建一个返回值对象,设置数据
		PageInfo<PSubject> pageInfo = new PageInfo<>(list);
		
		return pageInfo;
	}
	
	@Override
	public List<PSubject> getSubjectListByTeachid(String teachid){
		//查询课题列表
		PSubjectExample example = new PSubjectExample();
		//排序显示
		example.setOrderByClause("updatetime DESC");
		
		
		//创建查询条件
		Criteria criteria = example.createCriteria();
		criteria.andTeachidEqualTo(teachid);
		
		//查询数据
		List<PSubject> list = subjectMapper.selectByExampleWithBLOBs(example);
		if (list != null && list.size()>0) {
			return list;
		}else {
			return null;
		}
	}

	
	@Override
	public void saveSubject(PSubject subject) {
		//插入数据
		subjectMapper.insert(subject);
	}

	@Override
	public void deleteSubjectById(String subjectid) {
		//删除数据
		subjectMapper.deleteByPrimaryKey(subjectid);
	}

	@Override
	public PSubject getSubjectById(String subjectid) {
		return subjectMapper.selectByPrimaryKey(subjectid);
	}

	@Override
	public void updateSubject(PSubject subject) {
		//更新数据
		subjectMapper.updateByPrimaryKeyWithBLOBs(subject);
	}

	@Override
	public PageInfo<PSubject> getSubjectListByLeader(Integer page) {
		//查询课题列表
		PSubjectExample example = new PSubjectExample();
		//排序显示
		example.setOrderByClause("updatetime DESC");
		//分页处理：page第几页，rows多少行
		PageHelper.startPage(page, SUBJECT_SHOW_ROWS);
		
		//创建查询条件
		Criteria criteria = example.createCriteria();
		criteria.andSubjectstateEqualTo(2);
		
		//查询数据
		List<PSubject> list = subjectMapper.selectByExampleWithBLOBs(example);
		
		//补全指导老师与创建者的姓名
		for (PSubject pSubject : list) {
			//指导老师
			pSubject.setTeachid(infoMapper.selectByPrimaryKey(pSubject.getTeachid()).getName());
			//创建者
			pSubject.setCreateuser(infoMapper.selectByPrimaryKey(pSubject.getCreateuser()).getName());
		}
		
		//创建一个返回值对象,设置数据
		PageInfo<PSubject> pageInfo = new PageInfo<>(list);
		
		return pageInfo;
	}

	@Override
	public List<PSubject> getSubjectListByStu(String major) {
		//查询课题列表
		PSubjectExample example = new PSubjectExample();
		//排序显示
		example.setOrderByClause("updatetime DESC");
		
		//根据专业选择小组
		PGroup group = groupService.getGroupByName(major);
		List<String> teachids = null;
		if (group != null && group.getUsers() != null){
			teachids = Arrays.asList(group.getUsers().split(","));
		}
		
		//创建查询条件
		Criteria criteria = example.createCriteria();
		//用户在小组集合中
		criteria.andTeachidIn(teachids);
		
		criteria.andSubjectstateEqualTo(6);	//选题状态
		
		//查询数据
		List<PSubject> list = subjectMapper.selectByExampleWithBLOBs(example);
		
		//补全指导老师与创建者的姓名
		for (PSubject pSubject : list) {
			//指导老师
			pSubject.setTeachid(infoMapper.selectByPrimaryKey(pSubject.getTeachid()).getName());
		}
		
		return list;
	}

	@Override
	public List<PSubject> getSubjectListByStuid(String userid) {
		//查询课题列表
		PSubjectExample example = new PSubjectExample();
		//排序显示
		example.setOrderByClause("updatetime DESC");
		
		//创建查询条件
		Criteria criteria = example.createCriteria();
		//创建者为学生
		criteria.andCreateuserEqualTo(userid);
		
		//查询数据
		List<PSubject> list = subjectMapper.selectByExample(example);
		if (list != null && list.size()>0) {
			//补全指导老师与创建者的姓名
			for (PSubject pSubject : list) {
				//指导老师
				PInfo info = infoMapper.selectByPrimaryKey(pSubject.getTeachid());
				if (info != null) {
					pSubject.setTeachid(info.getName());
				}
			}
		}
		
		return list;
	}
	

}
