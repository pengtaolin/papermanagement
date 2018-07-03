package com.lin.paper.bean;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.lin.paper.pojo.PInfo;
import com.lin.paper.pojo.PSelect;

/**
 * 用户数据中间产物
 * @author	lin
 * @date	2018年1月23日下午5:38:08
 * @version 1.0
 */
public class UserInfo extends PInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	//密码
	private String pwd;
	//用户状态
	private Integer userstate;
	//角色集合
	private String roles;
	//上传的文件
	private MultipartFile file;
	
	//指导老师ID
	private String teachid;
	
	//选题信息
	private PSelect select;
	
	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Integer getUserstate() {
		return userstate;
	}

	public void setUserstate(Integer userstate) {
		this.userstate = userstate;
	}

	public String getTeachid() {
		return teachid;
	}

	public void setTeachid(String teachid) {
		this.teachid = teachid;
	}

	public PSelect getSelect() {
		return select;
	}

	public void setSelect(PSelect select) {
		this.select = select;
	}
}
