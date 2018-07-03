package com.lin.paper.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.paper.bean.ColumnPerm;
import com.lin.paper.bean.FaceNotice;
import com.lin.paper.mapper.PColumnMapper;
import com.lin.paper.pojo.PColumn;
import com.lin.paper.pojo.PColumnExample;
import com.lin.paper.pojo.PColumnExample.Criteria;
import com.lin.paper.pojo.PNotice;
import com.lin.paper.pojo.PPermission;
import com.lin.paper.service.ColumnService;
import com.lin.paper.service.NoticeService;
import com.lin.paper.service.PermissionService;

/**
 * 栏目信息业务逻辑实现类
 * @author	lin
 * @date	2018年1月18日下午5:07:32
 * @version 1.0
 */
@Service
public class ColumnServiceImpl implements ColumnService{
	@Resource
	private PColumnMapper columnMapper;
	@Resource
	private NoticeService noticeService;
	@Resource
	private PermissionService permissionService;
	
	@Value("${COLUMN_SHOW_ROWS}")
	private Integer COLUMN_SHOW_ROWS;		//后台每页显示数据
	@Value("${FACE_NOTICE_SHOW_ROWS}")
	private Integer FACE_NOTICE_SHOW_ROWS;		//前台指定栏目每页显示公告数
	
	
	
	@Override
	public List<PColumn> getAllBackColumn() {
		PColumnExample example = new PColumnExample();
		//排序显示
		example.setOrderByClause("columnName");
		Criteria criteria = example.createCriteria();
		//设置查询条件不为删除状态
		ArrayList<Integer> notIn = new ArrayList<Integer>();
		notIn.add(1);
		criteria.andColumnstateNotIn(notIn);
		criteria.andParentcolumnNotEqualTo("0");	//不为前台栏目
		return columnMapper.selectByExample(example);
	}
	
	@Override
	public PageInfo<PColumn> getColumnList(int page) {
		//查询栏目列表
		PColumnExample example = new PColumnExample();
		//排序显示
		example.setOrderByClause("parentColumn,orderBy DESC");
		//分页处理：page第几页，rows多少行
		PageHelper.startPage(page, COLUMN_SHOW_ROWS);
		//查询数据
		List<PColumn> list = columnMapper.selectByExample(example);
		//补全显示的数据
		for (PColumn pColumn : list) {
			String parentName = pColumn.getParentcolumn();
			if (columnMapper.selectByPrimaryKey(parentName)==null) {
				parentName = parentName.equals("0") ? "前台主页":"后台主页";
			}else {
				parentName= columnMapper.selectByPrimaryKey(parentName).getColumnname();
			}
			pColumn.setParentcolumn(parentName);
		}
		//创建一个返回值对象,设置数据
		PageInfo<PColumn> pageInfo = new PageInfo<>(list);
		
		return pageInfo;
	}

	@Override
	public PColumn getColumnById(String columnId) {
		return columnMapper.selectByPrimaryKey(columnId);
	}

	@Override
	public void deleteColumnById(String columnId) {
		//查询数据
		PColumn column = columnMapper.selectByPrimaryKey(columnId);
		//设置状态
		column.setColumnstate(1);
		if (column.getIsparent() == 1) {		//为父级
			//根据父级删除数据
			deleteColumnByParent(column.getColumnid());
		}
		//更新数据
		columnMapper.updateByPrimaryKey(column);
		
		
		//修改权限中的数据
		if (!column.getParentcolumn().equals("0")) {
			//创建对象
			PPermission permission = new PPermission();
			//数据赋值
			permission.setPermissionid(column.getColumnid());
			permission.setPermissionname(column.getColumnname());
			permission.setPermissionstate(column.getColumnstate());
			permission.setCreatetime(column.getCreatetime());
			permission.setUpdatetime(column.getUpdatetime());
			//更新数据
			permissionService.updatePermission(permission);
		}
	}
	
	@Override
	public void deleteColumnByParent(String parentId) {
		//查询数据
		PColumnExample example = new PColumnExample();
		//查询条件
		Criteria criteria = example.createCriteria();
		criteria.andParentcolumnEqualTo(parentId);
		//查询数据
		List<PColumn> list = columnMapper.selectByExample(example);
		//删除数据状态
		for (PColumn column : list) {
			//设置状态
			column.setColumnstate(1);
			if (column.getIsparent() == 1) {		//为父级
				//根据父级删除数据
				deleteColumnByParent(column.getParentcolumn());
			}
			//更新数据
			columnMapper.updateByPrimaryKey(column);
			
			
			//修改权限中的数据
			if (!column.getParentcolumn().equals("0")) {
				//创建对象
				PPermission permission = new PPermission();
				//数据赋值
				permission.setPermissionid(column.getColumnid());
				permission.setPermissionname(column.getColumnname());
				permission.setPermissionstate(column.getColumnstate());
				permission.setCreatetime(column.getCreatetime());
				permission.setUpdatetime(column.getUpdatetime());
				//更新数据
				permissionService.updatePermission(permission);
			}
			
		}
	}

	@Override
	public void updateColumn(PColumn column) {
		PColumn column2 = columnMapper.selectByPrimaryKey(column.getColumnid());
		column.setCreatetime(column2.getCreatetime());
		column.setIsparent(column2.getIsparent());
		columnMapper.updateByPrimaryKey(column);
		//更新父节点数据信息
		PColumn parentColumn = getColumnById(column.getParentcolumn());
		if (parentColumn!=null&&parentColumn.getIsparent()!=1) {
			parentColumn.setIsparent(1);
			columnMapper.updateByPrimaryKey(parentColumn);
		}
		
		
		//同步权限部分
		if (!column.getParentcolumn().equals("0")) {
			//创建对象
			PPermission permission = new PPermission();
			//数据赋值
			permission.setPermissionid(column.getColumnid());
			permission.setPermissionname(column.getColumnname());
			permission.setPermissionstate(column.getColumnstate());
			permission.setCreatetime(column.getCreatetime());
			permission.setUpdatetime(column.getUpdatetime());
			//更新数据
			permissionService.updatePermission(permission);
		}
	}

	@Override
	public void saveColumn(PColumn column) {
		//插入数据
		columnMapper.insert(column);
		//更新父节点数据信息
		PColumn parentColumn = getColumnById(column.getParentcolumn());
		if (parentColumn!=null&&parentColumn.getIsparent()!=1) {
			parentColumn.setIsparent(1);
			columnMapper.updateByPrimaryKey(parentColumn);
		}
		
		
		//同步权限表中的数据（只能为后台栏目）
		if (!column.getParentcolumn().equals("0")) {	//0:为前台主页
			//创建对象
			PPermission permission = new PPermission();
			//数据赋值
			permission.setPermissionid(column.getColumnid());
			permission.setPermissionname(column.getColumnname());
			permission.setPermissionstate(column.getColumnstate());
			permission.setCreatetime(column.getCreatetime());
			permission.setUpdatetime(column.getUpdatetime());
			//插入数据
			permissionService.savePermission(permission);
		}
		
	}

	@Override
	public PColumn getColumnByName(String columnname) {
		//创建查询条件
		PColumnExample example = new PColumnExample();
		Criteria criteria = example.createCriteria();
		criteria.andColumnnameEqualTo(columnname);
		//查询数据
		List<PColumn> list = columnMapper.selectByExample(example);
		
		if (list.size()==0) {
			return null;
		}else {
			return list.get(0);
		}
		
	}

	@Override
	public List<PColumn> getFaceColumns() {
		PColumnExample example = new PColumnExample();
		//排序显示
		example.setOrderByClause("orderBy DESC");
		Criteria criteria = example.createCriteria();
		//设置前台显示栏目状态
		List<Integer> state = new ArrayList<>();
		state.add(0); //前台正常栏目
		state.add(2);	//前台公告
		criteria.andParentcolumnEqualTo("0"); //前台栏目
		criteria.andColumnstateIn(state); //前台栏目
		//查询数据
		return columnMapper.selectByExample(example);
	}

	@Override
	public List<FaceNotice> getFaceNotices() {
		PColumnExample example = new PColumnExample();
		example.setOrderByClause("orderby desc");	//设置排序顺序
		Criteria criteria = example.createCriteria();
		criteria.andColumnstateEqualTo(2);	//公告栏目
		//查询数据
		List<PColumn> face = columnMapper.selectByExample(example);
		List<FaceNotice> faceNotices = new ArrayList<>();
		for (PColumn c : face) {
			FaceNotice f = new FaceNotice();
			//复制参数
			BeanUtils.copyProperties(c, f);
			f.setNotices(noticeService.getFaceNoticeByColumn(c.getColumnid()));
			faceNotices.add(f);
		}
		if (faceNotices.size() == 0) {
			return null;
		}else {
			return faceNotices;	
		}	
	}

	@Override
	public PageInfo<PNotice> getNoticeListByColumnId(Integer page, String columnid) {
		//分页处理：page第几页，rows多少行
		PageHelper.startPage(page, FACE_NOTICE_SHOW_ROWS);
		//查询数据
		List<PNotice> list = noticeService.getAllNoticeByColumn(columnid);
		//创建一个返回值对象,设置数据
		PageInfo<PNotice> pageInfo = new PageInfo<>(list);
		
		return pageInfo;
	}

	
	@Override
	public List<ColumnPerm> getBackColumnsByIdAndParent(String columnids, String parentid) {
		PColumnExample example = new PColumnExample();
		example.setOrderByClause("orderby desc");	//设置排序顺序
		Criteria criteria = example.createCriteria();
		criteria.andParentcolumnEqualTo(parentid);		//父节点
		List<String> ids = Arrays.asList(columnids.split(","));
		criteria.andColumnidIn(ids);		//查询栏目ID
		//查询数据
		List<PColumn> back = columnMapper.selectByExample(example);
		List<ColumnPerm> columnPerm = new ArrayList<>();
		for (PColumn c : back) {
			ColumnPerm f = new ColumnPerm();
			//复制参数
			BeanUtils.copyProperties(c, f);
			//设置子节点参数
			List<ColumnPerm> child = null;
			if (c.getIsparent() == 1){		//为父结点
				child = getBackColumnsByIdAndParent(columnids, c.getColumnid());
				if (child!=null && child.size()==0) {
					child = null;
				}
			} 
			f.setChilds(child);
			columnPerm.add(f);
		}
		if (columnPerm.size() == 0) {
			return null;
		}else {
			return columnPerm;	
		}	
	}
}
