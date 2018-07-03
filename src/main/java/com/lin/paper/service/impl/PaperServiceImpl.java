package com.lin.paper.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.paper.bean.UserInfo;
import com.lin.paper.mapper.PPaperMapper;
import com.lin.paper.pojo.PPaper;
import com.lin.paper.pojo.PPaperExample;
import com.lin.paper.pojo.PPaperExample.Criteria;
import com.lin.paper.pojo.PProgress;
import com.lin.paper.pojo.PSelect;
import com.lin.paper.service.InfoService;
import com.lin.paper.service.PaperService;
import com.lin.paper.service.ProgressService;
import com.lin.paper.service.SelectService;
import com.lin.paper.utils.FileUtil;
import com.lin.paper.utils.IDUtils;

/**
 * 论文文档的业务逻辑实现类
 * @author	lin
 * @date	2018年3月9日下午4:30:44
 * @version 1.0
 */
@Service
public class PaperServiceImpl implements PaperService {

	@Resource
	private PPaperMapper paperMapper;
	@Resource
	private InfoService infoService;
	@Resource
	private ProgressService progressService;
	@Resource
	private SelectService selectService;
	
	@Value("${COLUMN_SHOW_ROWS}")
	private Integer COLUMN_SHOW_ROWS;		//后台每页显示数据
	
	
	@Override
	public ResponseEntity<byte[]> downloadPaperById(String paperid, String path) {
		ResponseEntity<byte[]> entity = null;
		try {
			//查找文档信息
	    	PPaper paper = getPaperById(paperid);
	    	
	    	if (paper != null && paper.getFileurl() != null) {
	    		String filepath = path + paper.getFileurl();	//全路径
		    	String fileurl = paper.getFileurl();			//文件名(包括拓展名)
		    	String fileName = paper.getPapername();
		    	//下载文件
		    	entity = FileUtil.downloadFile(filepath, fileurl, fileName);
	    	}
	    	
		} catch (Exception e) {
			e.printStackTrace();
		}
        return entity;
	}

	
	@Override
	public PPaper uploadFile(String papername, String paperid, MultipartFile file, String path) {
		String pre = "/file";	//文件路径相对前缀
		
		//创建PPaper对象
		PPaper paper = new PPaper();
		
		//赋值部分属性
		paper.setCreatetime(new Date());
		paper.setPaperid(paperid);
		paper.setPapername(papername);
		paper.setPaperstate(0);
		paper.setUpdatetime(new Date());
		
		//文件上传部分
		if (!file.isEmpty()) {		//文件不为空
			//取文件扩展名
			String originalFilename = file.getOriginalFilename();
			String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
			//存储文件
			String url = uploadFile(path, ext, file);
			//设置文件url
			paper.setFileurl(pre+url);
		}
		
		
		//更新进度中的文章ID数据
		PProgress progress = progressService.getProgressById(paperid);
		if (progress != null) {
			progress.setPaperid(paperid);
			progressService.updateProgress(progress);
		}
		return paper;
	}

	/**
	 * 文件保存
	 * @param path	路径
	 * @param ext	拓展名
	 * @param uploadFile 文件
	 * @return
	 */
	private String uploadFile(String path, String ext, MultipartFile uploadFile) {
		String url = "";
		//生成文件名
		String fileName = IDUtils.getNoticeFileName();
		//文件在存放路径，应该使用日期分隔的目录结构
		DateTime dateTime = new DateTime();
		String filePath = dateTime.toString("/yyyy/MM/dd");
		//上传文件
		File filepath = new File(path+filePath, fileName + ext);
        //判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) { 
            filepath.getParentFile().mkdirs();
        }
        //将上传文件保存到一个目标文件当中
        File file = new File(path+filePath + File.separator + fileName+ext);
        try {
        	uploadFile.transferTo(file);
			//url = "/file"+filePath+"/"+fileName+ext;
        	url = filePath+"/"+fileName+ext;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}
	
	
	@Override
	public void savePaper(PPaper paper) {
		paperMapper.insert(paper);
		
	}

	@Override
	public PPaper getPaperById(String paperid) {
		return paperMapper.selectByPrimaryKey(paperid);
	}

	@Override
	public void updatePaper(PPaper paper) {
		paperMapper.updateByPrimaryKey(paper);
	}


	@Override
	public PageInfo<PPaper> getPaperList(Integer page) {
		//查询论文文档列表
		PPaperExample example = new PPaperExample();
		//排序显示
		example.setOrderByClause("updatetime");
		//分页处理：page第几页，rows多少行
		PageHelper.startPage(page, COLUMN_SHOW_ROWS);
		//查询数据
		List<PPaper> list = paperMapper.selectByExample(example);
		if (list != null && list.size()>0) {
			//补全显示的数据
			for (PPaper paper : list) {
				//查询进度信息
				PProgress progress = progressService.getProgressById(paper.getPaperid());
				//查询用户信息
				UserInfo userInfo = infoService.getUserInfoById(progress.getUserid());
				//文档信息内容：届+班级+姓名+进度+名称
				String name = userInfo.getSession()+":"+userInfo.getClazz()+":"+userInfo.getName()+":"+progress.getProgressname()+":"+paper.getPapername();
				
				paper.setPapername(name);
			}
		}
		
		//创建一个返回值对象,设置数据
		PageInfo<PPaper> pageInfo = new PageInfo<>(list);
		
		return pageInfo;
	}


	@Override
	public PageInfo<PPaper> getPaperListByLeader(Integer page) {
		//查询论文文档列表
		PPaperExample example = new PPaperExample();
		//排序显示
		example.setOrderByClause("updatetime");
		//分页处理：page第几页，rows多少行
		PageHelper.startPage(page, COLUMN_SHOW_ROWS);
		Criteria criteria = example.createCriteria();
		
		criteria.andPaperstateNotEqualTo(0); //不为其他稿
		
		//查询数据
		List<PPaper> list = paperMapper.selectByExample(example);
		if (list != null && list.size()>0) {
			//补全显示的数据
			for (PPaper paper : list) {
				//查询进度信息
				PProgress progress = progressService.getProgressById(paper.getPaperid());
				//查询用户信息
				UserInfo userInfo = infoService.getUserInfoById(progress.getUserid());
				//文档信息内容：届+班级+姓名+进度+名称
				String name = userInfo.getSession()+":"+userInfo.getClazz()+":"+userInfo.getName()+":"+progress.getProgressname()+":"+paper.getPapername();
				
				paper.setPapername(name);
			}
		}
		
		//创建一个返回值对象,设置数据
		PageInfo<PPaper> pageInfo = new PageInfo<>(list);
		
		return pageInfo;
	}


	@Override
	public List<PPaper> getPaperListByTeach(String teachid) {
		List<String> ids = new ArrayList<>();
		
		//根据教师查询指导的学生信息
		List<UserInfo> userList = selectService.getUserListByTeach(teachid);
		
		if (userList != null) {
			for (UserInfo userInfo : userList) {
				List<PProgress> stu = progressService.getProgressByStu(userInfo.getUserid());
				for (PProgress pProgress : stu) {
					if ("论文定稿".equals(pProgress.getProgressname())) {	//定稿流程
						ids.add(pProgress.getPaperid());
					}
				}
			}
			
			if (ids.size()>0){
				//查询论文文档列表
				PPaperExample example = new PPaperExample();
				//排序显示
				example.setOrderByClause("updatetime");
				
				Criteria criteria = example.createCriteria();
				
				criteria.andPaperstateEqualTo(1); //为定稿
				criteria.andPaperidIn(ids);
				
				//查询数据
				List<PPaper> list = paperMapper.selectByExample(example);
				if (list != null && list.size()>0) {
					//补全显示的数据
					for (PPaper paper : list) {
						//查询进度信息
						PProgress progress = progressService.getProgressById(paper.getPaperid());
						//查询用户信息
						UserInfo userInfo = infoService.getUserInfoById(progress.getUserid());
						//文档信息内容：届+班级+姓名+进度+名称
						String name = userInfo.getSession()+":"+userInfo.getClazz()+":"+userInfo.getName()+":"+progress.getProgressname()+":"+paper.getPapername();
						PSelect select = selectService.getSelectByStuAndState(userInfo.getUserid(), 3);
						
						paper.setPapername(name);
						paper.setFileurl(select.getSelectid());
					}
				}
				return list;
			}
			
		}
		
		return null;
	}
	

}
