package com.lin.paper.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.paper.bean.ScoreTable;
import com.lin.paper.bean.UserInfo;
import com.lin.paper.mapper.PSelectMapper;
import com.lin.paper.pojo.PPaper;
import com.lin.paper.pojo.PPaperExample;
import com.lin.paper.pojo.PProgress;
import com.lin.paper.pojo.PSelect;
import com.lin.paper.pojo.PSelectExample;
import com.lin.paper.pojo.PSelectExample.Criteria;
import com.lin.paper.pojo.PSubject;
import com.lin.paper.service.InfoService;
import com.lin.paper.service.ProgressService;
import com.lin.paper.service.SelectService;
import com.lin.paper.service.SubjectService;
import com.lin.paper.service.TaskService;
import com.lin.paper.utils.IDUtils;

/**
 * 选题的业务逻辑实现类
 * @author	lin
 * @date	2018年3月9日下午4:30:44
 * @version 1.0
 */
@Service
public class SelectServiceImpl implements SelectService {
	@Value("${SUBJECT_SHOW_ROWS}")
	private Integer SUBJECT_SHOW_ROWS;		//后台每页显示课题数据
	
	@Resource
	private PSelectMapper selectMapper;
	@Resource
	private SubjectService subjectService;
	@Resource
	private ProgressService progressService;
	@Resource
	private TaskService taskService;
	@Resource
	private InfoService infoService;
	
	
	@Override
	public void saveSelect(PSelect select) {
		//插入数据
		selectMapper.insertSelective(select);
	}


	@Override
	public List<PSubject> getSelectStatesByStu(List<PSubject> subjectList, String userid) {
		
		for (PSubject pSubject : subjectList) {
			PSelect select = getFirstSelectBySubjectid(pSubject.getSubjectid(), userid);
			if (select == null) {		//没有选择
				PSelect first = getFirstSelectBySubjectid(pSubject.getSubjectid(), "");
				if (first != null) {		//有没选的
					pSubject.setSubjectstate(0);
				} else {		//都选完了
					pSubject.setSubjectstate(2);
				}
			} else {		//已经选择
				pSubject.setSubjectstate(1);
				if (select.getSelectstate()==1) {		//通过
					pSubject.setSubjectstate(3);
				} else if (select.getSelectstate()==2){		//未通过
					pSubject.setSubjectstate(4);
				}
				/*else if (select.getSelectstate()==3){		//开始写作中
					pSubject.setSubjectstate(8);   			
				}*/
				
			}
		}
		
		return subjectList;
	}
	
	
	@Override
	public PSelect getFirstSelectBySubjectid(String Subjectid, String Stuid) {
		//查询选题列表
		PSelectExample example = new PSelectExample();
		//创建查询条件
		Criteria criteria = example.createCriteria();
		criteria.andSubjectidEqualTo(Subjectid);		//课题
		criteria.andStuidEqualTo(Stuid);				//用户
		
		//查询数据
		List<PSelect> list = selectMapper.selectByExample(example);
		
		if (list != null && list.size()>0) {		//有没选的
			return list.get(0);
		} else {		//都选完了
			return null;
		}
	}


	@Override
	public void updateSelect(PSelect select) {
		//更新数据
		selectMapper.updateByPrimaryKey(select);
	}


	@Override
	public PageInfo<PSelect> getSelectList(Integer page, String teachid) {
		List<PSubject> list2 = subjectService.getSubjectListByTeachid(teachid);
		List<String> subjectids = new ArrayList<>();
		if (list2 != null) {
			for (PSubject subject : list2) {
				subjectids.add(subject.getSubjectid());
			}
		}
		
		//查询选题列表
		PSelectExample example = new PSelectExample();
		//排序显示
		example.setOrderByClause("subjectid DESC");
		//分页处理：page第几页，rows多少行
		PageHelper.startPage(page, SUBJECT_SHOW_ROWS);
		//查询条件
		Criteria criteria = example.createCriteria();
		criteria.andSubjectidIn(subjectids);
		criteria.andStuidNotEqualTo("");		//不为空
		//查询数据
		List<PSelect> list = selectMapper.selectByExample(example);
		
		//补全题目与学生的姓名
		for (PSelect select : list) {
			//题目
			select.setSubjectid(subjectService.getSubjectById(select.getSubjectid()).getSubjectname());
			//学生
			select.setStuid(infoService.getUserInfoById(select.getStuid()).getName());
		}
		
		//创建一个返回值对象,设置数据
		PageInfo<PSelect> pageInfo = new PageInfo<>(list);
		
		return pageInfo;
	}


	@Override
	public PSelect getSelectById(String selectid) {
		return selectMapper.selectByPrimaryKey(selectid);
	}


	@Override
	public String getTeachByStuid(String stuid) {
		//查询选题列表
		PSelectExample example = new PSelectExample();
		//查询条件
		Criteria criteria = example.createCriteria();
		criteria.andStuidEqualTo(stuid);		//学号
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(3);
		criteria.andSelectstateIn(list2);		//状态
		//查询数据
		List<PSelect> list = selectMapper.selectByExample(example);
		
		if (list != null && list.size()>0) {
			PSubject subject = subjectService.getSubjectById(list.get(0).getSubjectid());
			if (subject != null) {
				return subject.getTeachid();
			}
		}
		
		return null;
	}


	@Override
	public PSelect getSelectByStuAndState(String userid, int i) {
		//查询选题列表
		PSelectExample example = new PSelectExample();
		//查询条件
		Criteria criteria = example.createCriteria();
		criteria.andStuidEqualTo(userid);		//学号
		criteria.andSelectstateEqualTo(i);		//状态
		//查询数据
		List<PSelect> list = selectMapper.selectByExample(example);
		
		if (list != null && list.size()>0) {
			return list.get(0);
		}else{
			return null;
		}
	}


	@Override
	public PSelect startSelect(String subjectid, String teachid, String userid) {
		PSelect selectById = getFirstSelectBySubjectid(subjectid, userid);
		if (selectById == null) {
			PSelect select = new PSelect();
			select.setCreatetime(new Date());
			select.setUpdatetime(new Date());
			select.setSelectid(IDUtils.getSelectId());
			select.setSelectstate(1);
			select.setStuid(userid);
			select.setSubjectid(subjectid);
			select.setTaskid(taskService.getTaskByState(1).get(0).getTaskid());
			
			//插入数据
			saveSelect(select);
		}
		//1、删除选题表中该用户其他选题信息，2、修改选题的状态为写作中（3），3、修改课题的状态为8（写作中）
		//删除选题表中该用户其他选题信息
		deleteOtherSelects(subjectid, userid);
		
		//修改选题的状态为写作中
		selectById = getFirstSelectBySubjectid(subjectid, userid);
		if (selectById != null) {
			//开始进度内容：开题报告、一稿、二稿、三稿、定稿内容
			//创建开题报告进度
			String progressid = progressService.addProgress("开题报告", userid);
			selectById.setProgressid(progressid);
			selectById.setSelectstate(3); //写作中3
			
			updateSelect(selectById);   //更新数据
			
			//修改课题的状态为8（写作中）
			PSubject subject = subjectService.getSubjectById(selectById.getSubjectid());
			subject.setSubjectstate(8); //写作中
			subjectService.updateSubject(subject);
		} 
		
		return selectById;
	}


	/**
	 * 删除选题表中该用户其他选题信息
	 * @param selectid
	 * @param userid
	 */
	private void deleteOtherSelects(String subjectid, String userid) {
		//查询选题列表
		PSelectExample example = new PSelectExample();
		//查询条件
		Criteria criteria = example.createCriteria();
		criteria.andStuidEqualTo(userid);		//学号
		criteria.andSubjectidNotEqualTo(subjectid); //课题不为开始subjectid
		
		//删除数据
		selectMapper.deleteByExample(example);
	}


	@Override
	public PageInfo<PSelect> getSelectListByLeader(Integer page) {
		
		//查询选题列表
		PSelectExample example = new PSelectExample();
		//排序显示
		example.setOrderByClause("subjectid DESC");
		//分页处理：page第几页，rows多少行
		PageHelper.startPage(page, SUBJECT_SHOW_ROWS);
		//查询条件
		Criteria criteria = example.createCriteria();
		criteria.andSelectstateEqualTo(3);		//写作中
		criteria.andStuidNotEqualTo("");		//不为空
		//查询数据
		List<PSelect> list = selectMapper.selectByExample(example);
		
		//补全题目与学生的姓名
		for (PSelect select : list) {
			PSubject subject = subjectService.getSubjectById(select.getSubjectid());
			if (subject != null) {
				//指导老师:题目
				select.setSubjectid(infoService.getUserInfoById(subject.getTeachid()).getName()+":"+subject.getSubjectname());
			}
			//班级：学生
			UserInfo info = infoService.getUserInfoById(select.getStuid());
			select.setStuid(info.getClazz()+":"+info.getName());
			//任务
			select.setTaskid(taskService.getTaskById(select.getTaskid()).getTaskname());
		}
		
		//创建一个返回值对象,设置数据
		PageInfo<PSelect> pageInfo = new PageInfo<>(list);
		
		return pageInfo;
	}


	@Override
	public List<UserInfo> getUserListByTeach(String userid) {
		//查询选题集合
		List<PSubject> subjects = subjectService.getSubjectListByTeachid(userid);
		List<String> subjectids = new ArrayList<>();
		List<UserInfo> userInfos = null;
		
		if (subjects != null) {
			for (PSubject pSubject : subjects) {
				subjectids.add(pSubject.getSubjectid());
			}
		}
		
		
		
		//查询选题列表
		PSelectExample example = new PSelectExample();
		//排序显示
		example.setOrderByClause("subjectid DESC");
		//查询条件
		Criteria criteria = example.createCriteria();
		criteria.andStuidNotEqualTo("");		//学生不为空
		
		criteria.andSubjectidIn(subjectids);	//课题ID
		//查询数据
		List<PSelect> list = selectMapper.selectByExample(example);
		
		if (list != null && list.size()>0){
			userInfos = new ArrayList<>();
			
			for (PSelect pSelect : list) {
				UserInfo userInfo = infoService.getUserInfoById(pSelect.getStuid());
				PSubject subject = subjectService.getSubjectById(pSelect.getSubjectid());
				userInfo.setTitle(subject==null?"":subject.getSubjectname()); 		//设置选题信息
				
				userInfos.add(userInfo);
			}
		}
		
		return userInfos;
	}


	@Override
	public List<ScoreTable> getScoreListByLeader() {
		List<ScoreTable> scoreTables = null;
		//查询选题列表
		PSelectExample example = new PSelectExample();
		//排序显示
		example.setOrderByClause("updatetime");
		Criteria criteria = example.createCriteria();
		criteria.andScoreIsNotNull();		//成绩不为空
		criteria.andSelectstateEqualTo(3);  //状态为3
		//查询数据
		List<PSelect> list = selectMapper.selectByExample(example);
		if (list != null && list.size()>0) {
			scoreTables = new ArrayList<>();
			//补全显示的数据
			for (PSelect select : list) {
				ScoreTable scoreTable = new ScoreTable();
				//学生信息
				UserInfo student = infoService.getUserInfoById(select.getStuid());
				//学生的课题信息
				PSubject subject = subjectService.getSubjectById(select.getSubjectid());
				//教师信息
				UserInfo teacher = infoService.getUserInfoById(subject.getTeachid());
				
				//保留两位小数
				DecimalFormat dFormat=new DecimalFormat("#.00");  
	            String score = dFormat.format(select.getScore());  
				
	    		String[] scores = score.split("\\.");
	    		String baseScore = scores[0];
	    		String showScore = scores[1];
	    		
				//设置数据
				scoreTable.setStudent(student);
				scoreTable.setTeacher(teacher);
				scoreTable.setBaseScore(baseScore);
				scoreTable.setShowScore(showScore);
				scoreTable.setSubjectname(subject.getSubjectname());
				
				scoreTables.add(scoreTable);
			}
		}
		
		return scoreTables;
	}
	
	
}
