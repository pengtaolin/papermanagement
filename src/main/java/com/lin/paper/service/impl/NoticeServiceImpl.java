package com.lin.paper.service.impl;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.paper.bean.UploadNotice;
import com.lin.paper.mapper.PNoticeMapper;
import com.lin.paper.pojo.PNotice;
import com.lin.paper.pojo.PNoticeExample;
import com.lin.paper.pojo.PNoticeExample.Criteria;
import com.lin.paper.service.ColumnService;
import com.lin.paper.service.NoticeService;
import com.lin.paper.utils.FileUtil;
import com.lin.paper.utils.IDUtils;

/**
 * 公告信息业务逻辑实现类
 * @author	lin
 * @date	2018年1月18日下午5:08:12
 * @version 1.0
 */
@Service
public class NoticeServiceImpl implements NoticeService{
	@Resource
	private PNoticeMapper noticeMapper;
	@Resource
	private ColumnService columnService;
	@Value("${FACE_NOTICE_SHOW_ROWS}")
	private Integer FACE_NOTICE_SHOW_ROWS;		//前台公告显示数据
	@Value("${NOTICE_SHOW_ROWS}")
	private Integer NOTICE_SHOW_ROWS;			//后台每页显示公告数据
	
	@Override
	public List<PNotice> getFaceNoticeByColumn(String columnid) {
		PNoticeExample example = new PNoticeExample();
		example.setOrderByClause("updateTime desc"); 	//根据更新时间进行排序
		//分页处理：page第几页，rows多少行
		PageHelper.startPage(1, FACE_NOTICE_SHOW_ROWS);
		Criteria criteria = example.createCriteria();
		criteria.andColumnidEqualTo(columnid);			//根据栏目ID查询数据
		criteria.andNoticestateNotEqualTo(1);			//状态为为删除
		return noticeMapper.selectByExample(example);
	}

	@Override
	public PageInfo<PNotice> getNoticeList(Integer page) {
		//查询公告列表
		PNoticeExample example = new PNoticeExample();
		//排序显示
		example.setOrderByClause("columnid,updatetime DESC");
		//分页处理：page第几页，rows多少行
		PageHelper.startPage(page, NOTICE_SHOW_ROWS);
		//查询数据
		List<PNotice> list = noticeMapper.selectByExample(example);
		//补全显示的数据
		for (PNotice pNotice : list) {
			String parentName = pNotice.getColumnid();
			if (columnService.getColumnById(parentName)==null) {
				parentName = parentName.equals("0") ? "前台主页":"后台主页";
			}else {
				parentName= columnService.getColumnById(parentName).getColumnname();
			}
			pNotice.setColumnid(parentName);
		}
		//创建一个返回值对象,设置数据
		PageInfo<PNotice> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public PNotice uploadFile(UploadNotice uploadNotice, String path) {
		String pre = "/file";	//文件路径相对前缀
		
		//创建Pnotice对象
		PNotice notice = new PNotice();
		//赋值部分属性
		BeanUtils.copyProperties(uploadNotice, notice);
		//文件上传部分
		if (uploadNotice.getFile().isEmpty()) {		//文件为空
			if (StringUtils.isEmpty(uploadNotice.getNoticecontent())) {		//公告内容为空
				//公告内容为空，fileurl为空	
				notice.setFileurl("");			
			} else {	//公告内容不为空
				//生成文件存储路径
				String url = uploadFile(path, ".doc", uploadNotice.getFile());
	            //内容生成文件
				FileUtil.htmlToWord(uploadNotice.getNoticecontent(), path+"/"+url);
				//设置文件url
				notice.setFileurl(pre+url);
			}
		}else {		//文件不为空
			if (StringUtils.isEmpty(uploadNotice.getNoticecontent())) {		//公告内容为空
				
				//取文件扩展名
				String originalFilename = uploadNotice.getFile().getOriginalFilename();
				String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
				//存储文件
				String url = uploadFile(path, ext, uploadNotice.getFile());
				//设置文件url
				notice.setFileurl(pre+url);
				//装换文件到公告内容
				String contnet = FileUtil.wordToHtml(path+"/"+url);
				//设置公告内容
				notice.setNoticecontent(contnet);
			} else {	//公告内容不为空（同时存储文件与内容）
				//取文件扩展名
				String originalFilename = uploadNotice.getFile().getOriginalFilename();
				String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
				//存储文件
				String url = uploadFile(path, ext, uploadNotice.getFile());
				//设置文件url
				notice.setFileurl(pre+url);
			}
		}
		return notice;
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
	public void saveNotice(PNotice notice) {
		//插入数据
		noticeMapper.insert(notice);
	}

	@Override
	public void deleteNoticeById(String noticeid) {
		//查询数据
		PNotice notice = noticeMapper.selectByPrimaryKey(noticeid);
		//设置状态
		notice.setNoticestate(1);
		//更新数据
		noticeMapper.updateByPrimaryKey(notice);
	}

	@Override
	public PNotice getNoticeById(String noticeid) {
		return noticeMapper.selectByPrimaryKey(noticeid);
	}

	@Override
	public void updateNotice(PNotice notice) {
		PNotice notice2 = noticeMapper.selectByPrimaryKey(notice.getNoticeid());
		notice.setDownloads(notice2.getDownloads());
		notice.setCreatetime(notice2.getCreatetime());
		notice.setWatchnum(notice2.getWatchnum());
		
		if (StringUtils.isEmpty(notice.getNoticecontent())) {	//内容为空
			notice.setNoticecontent(notice2.getNoticecontent());
		}
		if (StringUtils.isEmpty(notice.getFileurl())) { //文件url为空
			notice.setFileurl(notice2.getFileurl());
		}
		//更新数据
		noticeMapper.updateByPrimaryKeyWithBLOBs(notice);
	}

	@Override
	public List<PNotice> getAllNoticeByColumn(String columnid) {
		PNoticeExample example = new PNoticeExample();
		example.setOrderByClause("updateTime desc"); 	//根据更新时间进行排序
		Criteria criteria = example.createCriteria();
		criteria.andColumnidEqualTo(columnid);			//根据栏目ID查询数据
		criteria.andNoticestateNotEqualTo(1);			//状态不为删除
		return noticeMapper.selectByExample(example);
	}

	@Override
	public PNotice showNoticeById(String noticeid) {
		//查询数据
		PNotice notice = noticeMapper.selectByPrimaryKey(noticeid);
		if (notice != null){
			//浏览量加一
			notice.setWatchnum(notice.getWatchnum()+1);
			//更新数据
			noticeMapper.updateByPrimaryKey(notice);
		}
		//返回结果
		return notice;
	}
	
	@Override
	public ResponseEntity<byte[]> downloadNoticeById(String noticeid, String path) {
		ResponseEntity<byte[]> entity = null;
		try {
			//查找公告信息
	    	PNotice notice = getNoticeById(noticeid);
	    	
	    	if (notice != null && notice.getFileurl() != null) {
	    		String filepath = path + notice.getFileurl();	//全路径
		    	String fileurl = notice.getFileurl();			//文件名(包括拓展名)
		    	String fileName = notice.getNoticetitle();
		    	//下载文件
		    	entity = FileUtil.downloadFile(filepath, fileurl, fileName);
		    	
		        //更新下载量
		        notice.setDownloads(notice.getDownloads()+1);
		        
		        noticeMapper.updateByPrimaryKey(notice);
	    	}
	    	
		} catch (Exception e) {
			e.printStackTrace();
		}
        return entity;
	}

	@Override
	public PageInfo<PNotice> getNoticeListByTitle(Integer page, String kw) {
		//查询公告列表
		PNoticeExample example = new PNoticeExample();
		//排序显示
		example.setOrderByClause("columnid,updatetime DESC");
		//分页处理：page第几页，rows多少行
		PageHelper.startPage(page, NOTICE_SHOW_ROWS);
		//查询条件
		Criteria criteria = example.createCriteria();
		criteria.andNoticetitleLike("%"+kw+"%");
		
		//查询数据
		List<PNotice> list = noticeMapper.selectByExample(example);
		//创建一个返回值对象,设置数据
		PageInfo<PNotice> pageInfo = new PageInfo<>(list);
		
		return pageInfo;
	}

}
