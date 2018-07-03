package com.lin.paper.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lin.paper.bean.ScoreTable;
import com.lin.paper.bean.UserInfo;
import com.lin.paper.pojo.PSelect;
import com.lin.paper.pojo.PSubject;

/**
 * 选题的业务逻辑接口
 * @author	lin
 * @date	2018年3月9日下午4:10:54
 * @version 1.0
 */
public interface SelectService {

	/**
	 * 添加选题数据
	 * @param select
	 */
	void saveSelect(PSelect select);

	
	/**
	 * 设置用户的选题状态
	 * @param subjectList
	 * @param userid
	 * @return
	 */
	List<PSubject> getSelectStatesByStu(List<PSubject> subjectList, String userid);


	/**
	 * 获得第一个选题对象
	 * @param Subjectid
	 * @param Stuid
	 * @return
	 */
	PSelect getFirstSelectBySubjectid(String Subjectid, String Stuid);

	/**
	 * 更新选题信息数据
	 * @param select
	 */
	void updateSelect(PSelect select);

	/**
	 * 分页显示指定教师的选题审核
	 * @param page
	 * @param teachid 
	 * @return
	 */
	PageInfo<PSelect> getSelectList(Integer page, String teachid);

	/**
	 * 根据ID获得选题信息
	 * @param selectid
	 * @return
	 */
	PSelect getSelectById(String selectid);

	/**
	 * 根据学号查询确定的指导老师ID
	 * @param userid
	 * @return
	 */
	String getTeachByStuid(String stuid);

	/**
	 * 根据学号与状态查询选题数据
	 * @param userid
	 * @param i
	 * @return
	 */
	PSelect getSelectByStuAndState(String userid, int i);


	/**
	 * 开始选题写作内容
	 * @param subjectid
	 * @param teachid
	 * @param userid 
	 * @return 
	 */
	PSelect startSelect(String subjectid, String teachid, String userid);


	/**
	 * 查询汇总选题信息
	 * @param page
	 * @return
	 */
	PageInfo<PSelect> getSelectListByLeader(Integer page);

	/**
	 * 查询指导学生信息
	 * @param userid
	 * @return
	 */
	List<UserInfo> getUserListByTeach(String userid);


	/**
	 * 论文成绩信息汇总
	 * @return
	 */
	List<ScoreTable> getScoreListByLeader();

}
