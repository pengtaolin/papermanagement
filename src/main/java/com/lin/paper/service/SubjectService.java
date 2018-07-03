package com.lin.paper.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lin.paper.pojo.PSubject;

/**
 * 课题的业务逻辑接口
 * @author	lin
 * @date	2018年3月9日上午10:37:07
 * @version 1.0
 */
public interface SubjectService {

	/**
	 * 分页显示课题数据信息
	 * @param page
	 * @return
	 */
	PageInfo<PSubject> getSubjectList(Integer page);

	/**
	 * 根据指导老师ID分页显示课题数据信息
	 * @param page
	 * @param teachid
	 * @return
	 */
	PageInfo<PSubject> getSubjectListByTeach(Integer page, String teachid);

	/**
	 * 添加课题数据信息
	 * @param subject
	 */
	void saveSubject(PSubject subject);

	/**
	 * 删除课题数据信息
	 * @param subjectid
	 */
	void deleteSubjectById(String subjectid);

	/**
	 * 根据课题ID查询课题数据信息
	 * @param subjectid
	 * @return
	 */
	PSubject getSubjectById(String subjectid);

	/**
	 * 更新课题信息
	 * @param subject
	 */
	void updateSubject(PSubject subject);

	/**
	 * 分页显示系主任的课题数据信息
	 * @param page
	 * @return
	 */
	PageInfo<PSubject> getSubjectListByLeader(Integer page);

	/**
	 * 显示学生的课题数据信息
	 * @param major 
	 * @return
	 */
	List<PSubject> getSubjectListByStu(String major);

	/**
	 * 查询指定教师的选题集合
	 * @param teachid
	 * @return
	 */
	List<PSubject> getSubjectListByTeachid(String teachid);

	/**
	 * 根据学生查询选题信息
	 * @param userid
	 * @return
	 */
	List<PSubject> getSubjectListByStuid(String userid);


}
