package com.lin.paper.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lin.paper.mapper.PProgressMapper;
import com.lin.paper.pojo.PPaper;
import com.lin.paper.pojo.PProgress;
import com.lin.paper.pojo.PProgressExample;
import com.lin.paper.pojo.PProgressExample.Criteria;
import com.lin.paper.service.InfoService;
import com.lin.paper.service.PaperService;
import com.lin.paper.service.ProgressService;
import com.lin.paper.utils.IDUtils;

/**
 * 进度的业务逻辑实现类
 * @author	lin
 * @date	2018年3月9日下午4:30:44
 * @version 1.0
 */
@Service
public class ProgressServiceImpl implements ProgressService {
	
	@Resource
	private PProgressMapper progressMapper;
	@Resource
	private PaperService paperService;
	@Resource
	private InfoService infoService;
	
	
	
	@Override
	public String addProgress(String name, String userid) {
		PProgress progress = new PProgress();
		
		progress.setProgressid(IDUtils.getProgressId());
		progress.setProgressname(name);
		progress.setProgressstate(0); 		//刚创建
		progress.setStarttime(new Date());
		progress.setCreatetime(new Date());
		progress.setUpdatetime(new Date());
		progress.setUserid(userid); //学生ID
		
		progressMapper.insert(progress);		//插入数据
		
		return progress.getProgressid();
	}


	@Override
	public PProgress getProgressById(String progressid) {
		PProgressExample example = new PProgressExample();
		Criteria criteria = example.createCriteria();
		criteria.andProgressidEqualTo(progressid);   //查询条件
		
		List<PProgress> list = progressMapper.selectByExampleWithBLOBs(example); 	//数据查询
		if (list != null && list.size()>0) {
			return list.get(0);
		}
		
		return null;
	}


	@Override
	public List<PProgress> getProgressByStu(String userid) {
		PProgressExample example = new PProgressExample();
		example.setOrderByClause("createtime DESC");   //排序
		
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userid);   //查询条件
		
		List<PProgress> list = progressMapper.selectByExampleWithBLOBs(example); 	//数据查询
		if (list != null && list.size()>0) {
			return list;
		}
		return null;
	}


	@Override
	public void updateProgressStateById(String progressid, int state) {
		PProgress progress = getProgressById(progressid);	
		if (progress != null) {
			//修改状态
			progress.setProgressstate(state);
			//更新数据
			updateProgress(progress);
		}
		
	}


	@Override
	public void updateProgress(PProgress progress) {
		//更新数据
		progressMapper.updateByPrimaryKeyWithBLOBs(progress);
	}


	@Override
	public List<PProgress> getProgressByTeach(String userid) {
		PProgressExample example = new PProgressExample();
		example.setOrderByClause("createtime DESC");   //排序
		
		Criteria criteria = example.createCriteria();
		criteria.andProgressstateEqualTo(1);   //为已提交状态
		
		List<PProgress> list = progressMapper.selectByExampleWithBLOBs(example); 	//数据查询
		if (list != null && list.size()>0) {
			//补充其他数据
			
			//补充学生名单
			for (PProgress pProgress : list) {
				pProgress.setUserid(infoService.getUserInfoById(pProgress.getUserid()).getName());
			}
			
			return list;
		}
		return null;
	}


	@Override
	public PProgress startNewProgress(String progressid) {
		PProgress old = getProgressById(progressid);
		
		String name = "";
		if (old != null) {
			name = old.getProgressname();
		}
		
		//更新上一个进度的结束时间
		old.setEndtime(new Date());
		old.setUpdatetime(new Date());
		//更新状态
		old.setProgressstate(2);	//已通过
		
		progressMapper.updateByPrimaryKey(old);
		
		switch (name) {
		case "开题报告":
			if (old.getProgressstate() == 2) {
				name = "论文一稿";
			}
			break;
		case "论文一稿":
			if (old.getProgressstate() == 2) {
				name = "论文二稿";
			}
			break;
		case "论文二稿":
			if (old.getProgressstate() == 2) {
				name = "论文三稿";
			}
			break;
		case "论文三稿":
			if (old.getProgressstate() == 2) {
				name = "论文定稿";
			}
			break;
		case "论文定稿":
			if (old.getProgressstate() == 2) {
				//论文定稿进入最后阶段
				
				//修改当前论文状态为1。审核中
				PPaper paper = paperService.getPaperById(old.getProgressid());
				if (paper != null) {
					paper.setPaperstate(1);
					paperService.updatePaper(paper);
				}
				
				return null;
			}
			break;
		}
		
		if (!"".equals(name)) {
			//创建新的进度
			PProgress progress = new PProgress();
			
			progress.setProgressid(IDUtils.getProgressId());
			progress.setProgressname(name);
			progress.setProgressstate(0); 		//刚创建
			progress.setStarttime(new Date());
			progress.setCreatetime(new Date());
			progress.setUpdatetime(new Date());
			progress.setUserid(old.getUserid()); //学生ID
			
			progressMapper.insert(progress);		//插入数据
			return progress;
		} else {
			return null;
		}
	}
}
