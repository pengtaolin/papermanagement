package com.lin.paper.bean;

import com.lin.paper.pojo.PSelect;

/**
 * 成绩汇总表
 * @author	lin
 * @date	2018年4月21日下午4:24:11
 * @version 1.0
 */
public class ScoreTable {
	public final static Double PAPER_BASE = 0.4; //论文指导基础分占比重
	public final static Double PAPER_SHOW = 0.6; //论文答辩分占比重
	
	
	/**
	 * 学生信息
	 */
	private UserInfo student;
	/**
	 * 指导老师信息
	 */
	private UserInfo teacher;
	/**
	 * 论文题目
	 */
	private String subjectname;
	/**
	 * 指导分数
	 */
	private String baseScore;
	/**
	 * 答辩分数
	 */
	private String showScore;
	
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public String getBaseScore() {
		return baseScore;
	}
	public void setBaseScore(String baseScore) {
		this.baseScore = baseScore;
	}
	public String getShowScore() {
		return showScore;
	}
	public void setShowScore(String showScore) {
		this.showScore = showScore;
	}
	
	/**
	 * 总成绩
	 */
	public Double getSumScore() {
		Double sum = Double.parseDouble(this.baseScore)*ScoreTable.PAPER_BASE+Double.parseDouble(this.showScore)*ScoreTable.PAPER_SHOW;
		return sum;
	}
	public UserInfo getStudent() {
		return student;
	}
	public UserInfo getTeacher() {
		return teacher;
	}
	public void setStudent(UserInfo student) {
		this.student = student;
	}
	public void setTeacher(UserInfo teacher) {
		this.teacher = teacher;
	}
	
}
