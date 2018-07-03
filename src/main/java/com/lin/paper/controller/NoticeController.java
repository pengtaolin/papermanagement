package com.lin.paper.controller;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.lin.paper.bean.UploadNotice;
import com.lin.paper.pojo.PColumn;
import com.lin.paper.pojo.PNotice;
import com.lin.paper.service.ColumnService;
import com.lin.paper.service.NoticeService;
import com.lin.paper.utils.IDUtils;


/**
 * 公告信息控制器
 * @author	lin
 * @date	2018年1月22日下午3:03:22
 * @version 1.0
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {
	@Resource
	private NoticeService noticeService;
	@Resource
	private ColumnService columnService;
	
	
	/**
	 * 分页显示公告主界面
	 * @return
	 */
	@RequestMapping("/index{page}")
	public String index(Model model, @PathVariable("page") Integer page) {
		if (page == null) {
			page = 1;
		}
		//分页加载公告数据
		PageInfo<PNotice> noticeList = noticeService.getNoticeList(page);
		//分页加载栏目数据
		model.addAttribute("noticeList", noticeList);
		//跳转到界面
		return "notice/notice";
	}
	
	/**
	 * 跳转到添加公告界面
	 * @return
	 */
	@RequestMapping("/add")
	public String add(Model model) {
		//加载所有的栏目数据(未删除的前台栏目)
		List<PColumn> allFaceColumn = columnService.getFaceColumns();
		model.addAttribute("allFaceColumn", allFaceColumn);
		//跳转到界面
		return "notice/noticeAdd";
	}
	
	
	/**
	 * 添加公告信息
	 * @return
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Model model, UploadNotice uploadNotice, HttpServletRequest request) {
		//上传文件
		if (!uploadNotice.getFile().isEmpty()) {
			String originalFilename = uploadNotice.getFile().getOriginalFilename();
			String ext = originalFilename.substring(originalFilename.lastIndexOf("."));		//获得拓展名
			if (!ext.equals(".doc")&&!ext.equals(".docx")) {		//上传的格式错误
				model.addAttribute("notice", uploadNotice);	//回显数据
				model.addAttribute("errorFile", "上传的格式错误");
				return add(model);
			}
		}
		//上传文件路径
        String path = request.getSession().getServletContext().getRealPath("/file/");
		//同步上传文件
		PNotice notice = noticeService.uploadFile(uploadNotice, path);
		//补全初始化其他数据信息
		notice.setDownloads(0);	//下载数
		notice.setNoticeid(IDUtils.getNoticeId());		//设置公告ID
		notice.setCreatetime(new Date());	//设置创建时间
		notice.setUpdatetime(new Date());	//设置更新时间
		notice.setWatchnum(0);		//设置浏览量
		//添加数据
		noticeService.saveNotice(notice);
		//跳转到界面
		return "redirect:/notice/index.html";
	}
	
	/**
	 * 根据公告ID删除数据
	 * @return
	 */
	@RequestMapping("/del/{noticeid}")
	public String delete(Model model, @PathVariable("noticeid") String noticeid) {
		//删除公告数据(修改公告状态)
		noticeService.deleteNoticeById(noticeid);
		
		return index(model, null);
	}
	
	
	/**
	 * 转到修改公告界面
	 * @param model
	 * @param noticeid
	 * @return
	 */
	@RequestMapping(value="/toUp/{noticeid}")
	public String toUpdate(Model model, @PathVariable("noticeid") String noticeid) {
		//加载所有的栏目数据(未删除的前台栏目)
		List<PColumn> allFaceColumn = columnService.getFaceColumns();
		model.addAttribute("allFaceColumn", allFaceColumn);
		//根据公告ID查询数据
		PNotice notice = noticeService.getNoticeById(noticeid);
		//添加数据
		model.addAttribute("notice", notice);
		//跳转到修改界面
		return "notice/noticeUpdate";
	}
	
	/**
	 * 修改公告数据
	 * @return
	 */
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(Model model, UploadNotice uploadNotice, HttpServletRequest request) {
		//上传文件
		if (!uploadNotice.getFile().isEmpty()) {
			String originalFilename = uploadNotice.getFile().getOriginalFilename();
			String ext = originalFilename.substring(originalFilename.lastIndexOf("."));		//获得拓展名
			if (!ext.equals(".doc")&&!ext.equals(".docx")) {		//上传的格式错误
				model.addAttribute("notice", uploadNotice);	//回显数据
				model.addAttribute("errorFile", "上传的格式错误");
				return toUpdate(model, uploadNotice.getNoticeid());
			}
		}
		
		//上传文件路径
        String path = request.getSession().getServletContext().getRealPath("/file/");
		//同步上传文件
		PNotice notice = noticeService.uploadFile(uploadNotice, path);
		//补全其他数据信息
		notice.setUpdatetime(new Date());	//修改时间
		//修改数据
		noticeService.updateNotice(notice);
		
		//跳转到界面
		return toUpdate(model, uploadNotice.getNoticeid());
	}
	
	
	/**
	 * 前台显示公告详情内容
	 * @return
	 */
	@RequestMapping("/show/{columnid}/{noticeid}")
	public String show(Model model, @PathVariable("columnid") String columnid, @PathVariable("noticeid") String noticeid) {
		PColumn column = columnService.getColumnById(columnid);
		PNotice notice = noticeService.showNoticeById(noticeid);
		//加载数据
		model.addAttribute("column", column);
		model.addAttribute("notice", notice);
		//跳转到界面
		return "face/content";
	}
	
	
	/**
	 * 下载公告信息
	 * @param request
	 * @param noticeid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/download/{noticeid}")
    public ResponseEntity<byte[]> download(HttpServletRequest request, @PathVariable("noticeid") String noticeid){
    	//下载文件路径
    	String path = request.getSession().getServletContext().getRealPath("/");
    	
    	return noticeService.downloadNoticeById(noticeid,path);
    }
    
    /**
     * 前台公告搜索
     * @param model
     * @param page
     * @return
     */
    @RequestMapping(value="/search{page}")
    public String search(Model model, @PathVariable("page") Integer page, String kw) {
    	if (page == null) {
			page = 1;
		}
		//根据关键字分页加载公告数据
		PageInfo<PNotice> noticeList = noticeService.getNoticeListByTitle(page, kw);
		//分页加载栏目数据
		model.addAttribute("noticeList", noticeList);
    	model.addAttribute("kw", kw);
		//跳转到界面
		return "face/search";
	}
	
}
