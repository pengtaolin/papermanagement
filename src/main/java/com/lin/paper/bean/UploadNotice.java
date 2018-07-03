package com.lin.paper.bean;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.lin.paper.pojo.PNotice;

public class UploadNotice extends PNotice implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 上传的文件
	 */
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
}
