package com.lin.paper.controller;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.lin.paper.pojo.PColumn;
import com.lin.paper.pojo.PNotice;
import com.lin.paper.service.ColumnService;
import com.lin.paper.utils.IDUtils;

/**
 * 栏目信息控制器
 * @author	lin
 * @date	2018年1月18日下午4:29:24
 * @version 1.0
 */
@Controller
@RequestMapping("/column")
public class ColumnController {
	@Resource
	private ColumnService columnService;
	
	
	
	/**
	 * 转到添加栏目界面
	 * @return
	 */
	@RequestMapping("/add")
	public String toAdd(Model model) {
		//加载所有的栏目数据 
		List<PColumn> allColumn = columnService.getAllBackColumn();
		model.addAttribute("firstColumn", allColumn);
		//跳转到界面
		return "column/columnAdd";
	}
	
	/**
	 * 添加栏目信息
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Model model, PColumn column, HttpServletResponse response, HttpServletRequest request) throws Exception {
		//判断栏目名是否已存在
		if (columnService.getColumnByName(column.getColumnname())!=null){
			//栏目已经存在回显数据
			model.addAttribute("nameError", "栏目名已存在");
			model.addAttribute("col", column);
			return toAdd(model);
		}else {
			//补全其他数据信息
			column.setColumnid(IDUtils.getColumnId());
			column.setIsparent(0);
			column.setCreatetime(new Date());
			column.setUpdatetime(new Date());
			//添加数据
			columnService.saveColumn(column);
			//跳转到界面
			return "redirect:/column/index.html";
		}
	}
	
	
	/**
	 * 根据栏目ID删除数据
	 * @return
	 */
	@RequestMapping("/del/{columnid}")
	public String delete(Model model, @PathVariable("columnid") String columnid) {
		//删除栏目数据(修改栏目状态，级联操作)
		columnService.deleteColumnById(columnid);
		
		return index(model, null);
	}
	
	/**
	 * 转到修改栏目界面
	 * @param model
	 * @param columnid
	 * @return
	 */
	@RequestMapping(value="/toUp/{columnid}")
	public String toUpdate(Model model, @PathVariable("columnid") String columnid) {
		//加载所有的栏目数据
		List<PColumn> allColumn = columnService.getAllBackColumn();
		model.addAttribute("firstColumn", allColumn);
		//根据栏目ID查询数据
		PColumn column = columnService.getColumnById(columnid);
		//添加数据
		model.addAttribute("col", column);
		//跳转到修改界面
		return "column/columnUpdate";
	}
	
	/**
	 * 修改栏目数据
	 * @return
	 */
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(PColumn column, Model model) {
		//判断栏目名是否已存在
		if (columnService.getColumnByName(column.getColumnname())!=null 
				&& !columnService.getColumnByName(column.getColumnname()).getColumnname().equals(column.getColumnname())){
			//栏目已经存在回显数据
			model.addAttribute("nameError", "栏目名已存在");
			model.addAttribute("col", column);
			return toUpdate(model, column.getColumnid());
		}else {
			//补全其他数据信息
			column.setUpdatetime(new Date());
			//更新数据
			columnService.updateColumn(column);
			//跳转到界面
			return toUpdate(model, column.getColumnid());
		}
	}
	
	
	/**
	 * 分页显示栏目主界面
	 * @return
	 */
	@RequestMapping("/index{page}")
	public String index(Model model, @PathVariable("page") Integer page) {
		if (page == null) {
			page = 1;
		}
		//分页加载栏目数据
		PageInfo<PColumn> columnList = columnService.getColumnList(page);
		/*
		 * 	columnList.getFirstPage();		//1首页,
		 * 	columnList.getPrePage();		//0上一页,
		 *	columnList.getPages();			//2总页数,
		 *	columnList.getPageNum();		//1当前页数,
		 *	columnList.getPageSize();		//5每页数,
		 *	columnList.getTotal();			//8数据总数,
		 *	columnList.getNextPage();		//2下一页,
		 *	columnList.getLastPage();		//2最后一页
		 */
		//分页加载栏目数据
		model.addAttribute("columnList", columnList);
		//跳转到界面
		return "column/column";
	}
	
	/**
	 * 分页显示前台栏目界面
	 * @return
	 */
	@RequestMapping("/show/{columnid}-{page}")
	public String show(Model model, @PathVariable("columnid") String columnid, @PathVariable("page") Integer page) {
		//分页加载指定栏目数据
		PageInfo<PNotice> noticeList = columnService.getNoticeListByColumnId(page, columnid);
		PColumn column = columnService.getColumnById(columnid);
		//分页加载公告数据
		model.addAttribute("column", column);
		//分页加载公告数据
		model.addAttribute("noticeList", noticeList);
		//跳转到界面
		return "face/list";
	}
	
}
