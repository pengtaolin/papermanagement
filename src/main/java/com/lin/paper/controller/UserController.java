package com.lin.paper.controller;

import java.awt.image.BufferedImage;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lin.paper.bean.ColumnPerm;
import com.lin.paper.bean.UserInfo;
import com.lin.paper.pojo.PInfo;
import com.lin.paper.pojo.PRole;
import com.lin.paper.pojo.PSelect;
import com.lin.paper.pojo.PUser;
import com.lin.paper.service.InfoService;
import com.lin.paper.service.RoleService;
import com.lin.paper.service.SelectService;
import com.lin.paper.service.UserService;
import com.lin.paper.utils.VerifyCode;


/**
 * 用户信息控制器
 * @author	lin
 * @date	2018年1月18日下午4:29:37
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@Resource
	private InfoService infoService;
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private SelectService selectService;
	
	
	/**
	 * 验证码
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/vcode")
	public void vcode(HttpServletRequest request, HttpServletResponse response) throws Exception{
		/*
		 * 1. 创建验证码类
		 */
		VerifyCode vc = new VerifyCode();
		/*
		 * 2. 得到验证码图片
		 */
		BufferedImage image = vc.getImage();
		/*
		 * 3. 把图片上的文本保存到session中
		 */
		request.getSession().setAttribute("vCode", vc.getText());
		/*
		 * 4. 把图片响应给客户端
		 */
		VerifyCode.output(image, response.getOutputStream());
	}
	
	
	/**
	 * 用户登录
	 * @param user
	 * @param vcode
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public void login(PUser user, String vcode, HttpServletRequest request, HttpServletResponse response) throws Exception{
		//验证码校验
		String vCode = (String) request.getSession().getAttribute("vCode");
		vCode = vCode==null ? "" : vCode;
		if (!vCode.equalsIgnoreCase(vcode)){		//验证码错误
			request.setAttribute("nameError", "验证码错误!");
			request.setAttribute("rcode", vcode);
			request.setAttribute("user", user);
			//转发
			request.getRequestDispatcher("/jsp/face/login.jsp").forward(request, response);
		} else {
			//用户登录
			PUser pUser = userService.login(user);
			if(pUser!=null) {	//成功
				//菜单权限
				List<ColumnPerm> columnPerms = userService.getColumnPermByUser(pUser);
				//用户基本信息
				UserInfo userInfo = infoService.getUserInfoById(pUser.getUserid());
				
				//获得指导老师ID
				String teachid = selectService.getTeachByStuid(userInfo.getUserid());
				if(teachid != null){
					userInfo.setTeachid(teachid);
				}
				
				// TODO 其他安排的
				
				//添加用户正在写的选题数据
				PSelect select = selectService.getSelectByStuAndState(userInfo.getUserid(), 3);
				if(select != null){
					userInfo.setSelect(select);
				}
				
				
				//数据赋值
				request.getSession().setAttribute("session_user", userInfo);
				request.getSession().setAttribute("ColumnPerm", columnPerms);
				//重定向
				response.sendRedirect("/main.html");
			} else {		//失败
				request.setAttribute("nameError", "用户名或密码错误!");
				request.setAttribute("rcode", vcode);
				request.setAttribute("user", user);
				//转发
				request.getRequestDispatcher("/jsp/face/login.jsp").forward(request, response);
			}
			
		}
	}
	
	/**
	 * 用户注销
	 * @return
	 */
	@RequestMapping("/exit")
	public String exit(HttpSession session){
		 //清除Session  
        session.invalidate();  
          
        return "redirect:/login.html";  
	}
	
	
	/**
	 * 后台加载所有用户数据
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String index(Model model){
		//查询所有用户信息数据
		List<PInfo> userList = infoService.getAllUserInfo();
		//加载数据
		model.addAttribute("userList", userList);
		//返回界面
		return "user/user";
	}
	
	/**
	 * 管理员加载显示单条用户数据信息
	 * @param userid
	 * @return
	 */
	@RequestMapping("/view/{userid}")
	public String view(Model model, @PathVariable String userid){
		//查询用户信息数据
		UserInfo userInfo = infoService.getUserInfoById(userid);
		
		//加载数据
		model.addAttribute("userinfo", userInfo);
		
		//返回界面
		return "user/userView";
	}
	
	/**
	 * 重置用户密码
	 * @param model
	 * @param userid
	 * @return
	 */
	@RequestMapping("/pwd/{userid}")
	public String pwd(Model model, @PathVariable String userid){
		//根据用户ID重置密码
		userService.restartPwd(userid);
		//跳转到主页
		return index(model);
	}
	
	/**
	 * 彻底删除用户信息
	 * @param model
	 * @param userid
	 * @return
	 */
	@RequestMapping("/delete/{userid}")
	public String delete(Model model, @PathVariable String userid){
		//根据第ID彻底删除用户信息数据
		infoService.deleteUserInfoById(userid);
		//跳转到主页
		return index(model);
	}
	
	/**
	 * 转到添加用户界面
	 * @return
	 */
	@RequestMapping("/add")
	public String toAdd(Model model) {
		//加载所有用户角色数据 
		List<PRole> roleList = roleService.getUserRoles();
		//设置数据
		model.addAttribute("roleList", roleList);
		//跳转到界面
		return "user/userAdd";
	}
	
	/**
	 * 添加用户数据
	 * @param userInfo
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(UserInfo userInfo, Model model, HttpServletRequest request) {
		//上传文件
		if (!userInfo.getFile().isEmpty()) {	//批量上传，表格上传文件
			String originalFilename = userInfo.getFile().getOriginalFilename();
			String ext = originalFilename.substring(originalFilename.lastIndexOf("."));		//获得拓展名
			if (!ext.equals(".xls")&&!ext.equals(".xlsx")) {		//上传的格式错误
				model.addAttribute("userInfo", userInfo);	//回显数据
				model.addAttribute("errorFile", "上传的格式错误");
				return toAdd(model);
			}else {
				//上传文件路径
		        String path = request.getSession().getServletContext().getRealPath("/file/");
				//上传文件数据
		        infoService.uploadFile(userInfo, path);
		        return "redirect:/user/index.html";
			}
		} else {		//单条数据上传
			//添加数据
			infoService.saveUserInfo(userInfo);
			//跳转到界面
			return "redirect:/user/index.html";
		}
	}
	
	/**
	 * 跳转到更新界面
	 * @param model
	 * @param userInfo
	 * @return
	 */
	@RequestMapping("/toUp")
	public String toUpdate(Model model, UserInfo userInfo) {
		//加载所有用户角色数据 
		List<PRole> roleList = roleService.getUserRoles();
		//设置数据
		model.addAttribute("roleList", roleList);
		model.addAttribute("userinfo", userInfo);
		//跳转到界面
		return "user/userUpdate";
	}
	
	
	/**
	 * 更新用户数据
	 * @param model
	 * @param userInfo
	 * @return
	 */
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(Model model, UserInfo userInfo) {
		
		//更新数据
		infoService.updateUserInfo(userInfo);
		
		//跳转到界面
		return toUpdate(model, userInfo);
	}
	
	/**
	 * 我的老师的基本信息
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/myteach")
	public String myTeach(Model model, HttpSession session) {
		//获取学生的信息
		UserInfo userInfo = (UserInfo)session.getAttribute("session_user");
		UserInfo info = null;
		if (userInfo.getTeachid() != null) {
			//查询用户信息
			info = infoService.getUserInfoById(userInfo.getTeachid());
		} else {
			//获得指导老师ID
			String teachid = selectService.getTeachByStuid(userInfo.getUserid());
			userInfo.setTeachid(teachid);
			//查询用户信息
			info = infoService.getUserInfoById(userInfo.getTeachid());
		}
		//设置数据
		model.addAttribute("userinfo", info);
		//跳转到界面
		return "user/userinfo";
	}
	
	/**
	 * 我的基本信息
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/detail")
	public String detail(Model model, HttpSession session) {
		//获取学生的信息
		UserInfo userInfo = (UserInfo)session.getAttribute("session_user");
		
		//设置数据
		model.addAttribute("userinfo", userInfo);
		//跳转到界面
		return "user/userinfo";
	}
	
	/**
	 * 我的指导学生
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/mystu")
	public String mystu(Model model, HttpSession session) {
		//获取教师的信息
		UserInfo userInfo = (UserInfo)session.getAttribute("session_user");
		
		//根据教师查询指导的学生信息
		List<UserInfo> userList = selectService.getUserListByTeach(userInfo.getUserid());
		
		//设置数据
		model.addAttribute("userList", userList);
		
		//跳转到界面
		return "user/mystu";
	}
	
	
	/**
	 * 教师加载显示单条用户数据信息
	 * @param userid
	 * @return
	 */
	@RequestMapping("/teachview/{userid}")
	public String teachview(Model model, @PathVariable String userid){
		//查询用户信息数据
		UserInfo userInfo = infoService.getUserInfoById(userid);
		
		//加载数据
		model.addAttribute("userinfo", userInfo);
		
		//返回界面
		return "user/userTeachView";
	}
	
}
