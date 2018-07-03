package com.lin.paper.controller;




import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.lin.paper.bean.UserInfo;
import com.lin.paper.pojo.PPaper;
import com.lin.paper.pojo.PSelect;
import com.lin.paper.service.InfoService;
import com.lin.paper.service.PaperService;
import com.lin.paper.service.SelectService;


/**
 * 论文文档控制器
 * @author	lin
 * @date	2018年3月12日下午9:23:37
 * @version 1.0
 */
@Controller
@RequestMapping("/paper")
public class PaperController {
	
	@Resource
	private PaperService paperService;
	@Resource
	private SelectService selectService;
	@Resource
	private InfoService infoService;
	
	/**
	 * 学生端上传文件
	 * @param model
	 * @param request
	 * @param file
	 * @param papername
	 * @return
	 */
	@RequestMapping(value="/stu/upload", method=RequestMethod.POST)
	public String save(Model model, HttpServletRequest request, MultipartFile file, String papername) {
		//获得用户信息
		UserInfo userInfo = (UserInfo)request.getSession().getAttribute("session_user");
		
		//上传文件
		if (!file.isEmpty()) {
			String originalFilename = file.getOriginalFilename();
			String ext = originalFilename.substring(originalFilename.lastIndexOf("."));		//获得拓展名
			//取消文件格式校验
			/*if (!ext.equals(".doc")&&!ext.equals(".docx")&&!ext.equals(".zip")) {		//上传的格式错误
				return "redirect:/main.html";
			}*/
		}
		
		//TODO ?? 要做什么呢
		
		if (userInfo.getSelect() != null && userInfo.getSelect().getProgressid() != null) {
			//上传文件路径
	        String path = request.getSession().getServletContext().getRealPath("/file/");
			//同步上传文件
			PPaper paper = paperService.uploadFile(papername, userInfo.getSelect().getProgressid(), file, path);
			
			PPaper Paper1 = paperService.getPaperById(paper.getPaperid());
			if (Paper1 != null) {
				//更新数据
				paperService.updatePaper(paper);
			}else {
				//添加数据
				paperService.savePaper(paper);
			}
		}
		
		//跳转到界面
		return "redirect:/progress/stu/index.html";
	}
	
	/**
	 * 教师端上传文件
	 * @param model
	 * @param request
	 * @param file
	 * @param papername
	 * @param paperid
	 * @return
	 */
	@RequestMapping(value="/teach/upload", method=RequestMethod.POST)
	public String teachSave(Model model, HttpServletRequest request, MultipartFile file, String papername, String paperid) {
		
		//上传文件
		if (!file.isEmpty()) {
			String originalFilename = file.getOriginalFilename();
			String ext = originalFilename.substring(originalFilename.lastIndexOf("."));		//获得拓展名
			//取消文件格式校验
			/*if (!ext.equals(".doc")&&!ext.equals(".docx")&&!ext.equals(".zip")) {		//上传的格式错误
				return "redirect:/main.html";
			}*/
		}
		
		//TODO ?? 要做什么呢
		
		//上传文件路径
        String path = request.getSession().getServletContext().getRealPath("/file/");
		//同步上传文件
		PPaper paper = paperService.uploadFile(papername, paperid, file, path);
		
		PPaper Paper1 = paperService.getPaperById(paper.getPaperid());
		if (Paper1 != null) {
			//更新数据
			paperService.updatePaper(paper);
		}else {
			//添加数据
			paperService.savePaper(paper);
		}
		
		//跳转到界面
		return "redirect:/progress/teach/index.html";
	}
	
	
	/**
	 * 下载论文信息
	 * @param request
	 * @param progressid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/download/{progressid}")
    public ResponseEntity<byte[]> download(HttpServletRequest request, @PathVariable("progressid") String progressid){
    	//下载文件路径
    	String path = request.getSession().getServletContext().getRealPath("/");
    	
    	return paperService.downloadPaperById(progressid,path);
    }
    
    /**
     * 管理员的论文文档管理
     * @param model
     * @param page
     * @return
     */
    @RequestMapping("/admin/index{page}")
	public String adminIndex(Model model, @PathVariable("page") Integer page) {
		if (page == null) {
			page = 1;
		}
		//分页加载论文文档数据
		PageInfo<PPaper> paperList = paperService.getPaperList(page);
		//分页加载论文数据
		model.addAttribute("paperList", paperList);
		//跳转到界面
		return "paper/admin";
	}
    
    /**
     * 系主任的论文文档管理
     * @param model
     * @param page
     * @return
     */
    @RequestMapping("/leader/index{page}")
	public String leaderIndex(Model model, @PathVariable("page") Integer page) {
		if (page == null) {
			page = 1;
		}
		//分页加载论文文档数据
		PageInfo<PPaper> paperList = paperService.getPaperListByLeader(page);
		//分页加载论文数据
		model.addAttribute("paperList", paperList);
		//跳转到界面
		return "paper/leader";
	}
    
    /**
     * 指导老师的成绩评审
     * @param model
     * @return
     */
    @RequestMapping("/teach/index{page}")
   	public String teachIndex(Model model, HttpSession session) {
    	//获得用户信息
    	UserInfo userInfo = (UserInfo)session.getAttribute("session_user");
    	
    	
   		//加载论文文档数据
   		List<PPaper> paperList = paperService.getPaperListByTeach(userInfo.getUserid());
   		//分页加载论文数据
   		model.addAttribute("paperList", paperList);
   		//跳转到界面
   		return "paper/teach";
   	}
    
    /**
     * 跳转成绩输入界面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/score/{selectid}")
   	public String toScore(Model model, @PathVariable String selectid) {
    	//学生信息 成绩信息 ：答辩：基本  显示
    	PSelect select = selectService.getSelectById(selectid);
    	//加载成绩分数
    	if (select != null && select.getScore()!=null){
    		
    		//保留两位小数
        	DecimalFormat dFormat=new DecimalFormat("#.00");  
            String score = dFormat.format(select.getScore());  
    		String[] scores = score.split("\\.");
    		model.addAttribute("first", scores[0]);
    		model.addAttribute("second", scores[1]);
    	}
    	//加载学生信息
    	if (select != null && select.getStuid()!=null){
    		String stuname = infoService.getNameByIds(select.getStuid());
    		model.addAttribute("stuname", stuname);
    	}
    	
   		//加载数据
   		model.addAttribute("selectid", selectid);
   		//跳转到界面
   		return "paper/score";
   	}
    
    /**
     * 成绩输入
     * @param model
     * @param paperid
     * @return
     */
    @RequestMapping(value="/score/save", method=RequestMethod.POST)
   	public String score(Model model, String selectid, String firstScore, String secondScore) {
    	
    	//查找数据
    	//firstScore = firstScore * 0.4 + secondScore * 0.6;
    	PSelect select = selectService.getSelectById(selectid);
    	//格式化数字
    	/*java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");  
    	df.format(firstScore);
    	select.setScore(firstScore);*/
    	//基本.答辩成绩
    	String score = firstScore+"."+secondScore;
    	select.setScore(Double.parseDouble(score));
    	//更新数据
    	selectService.updateSelect(select);
    	
   		//跳转到界面
   		return "redirect:/paper/teach/index.html";
   	}
}
