package com.lin.paper.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lin.paper.bean.UserInfo;

/**
 * 登录拦截器
 * @author	lin
 * @date	2018年2月7日下午7:27:00
 * @version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor{

	/**
	 * Handler执行之前调用这个方法 
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获取请求的URL  
        String url = request.getRequestURI();  
        
        if(url.indexOf("/login.html")>=0 				//登录界面
        		|| url.indexOf("/column/show/")==0 		//栏目
        		|| url.indexOf("/notice/show/")==0		//公告浏览
        		|| url.indexOf("/notice/download/")==0	//公告下载
        		|| url.indexOf("/notice/search")==0		//搜索
        		|| url.indexOf("/user/vcode")==0		//验证码
        		|| url.indexOf("/index.html")==0		//主页
        		||(url.indexOf("/")==0&&url.lastIndexOf("/")==0&&url.indexOf("/main.html")==-1)){  	//前台主页
            return true;  
        }  
        //获取Session  
        HttpSession session = request.getSession();  
        UserInfo userInfo = (UserInfo)session.getAttribute("session_user");  
          
        if(userInfo != null){  
            return true;  
        }  
        //不符合条件的，跳转到登录界面  
        request.getRequestDispatcher("/login.html").forward(request, response);  
          
        return false;  
	}

	
	/**
	 * Handler执行之后，ModelAndView返回之前调用这个方法 
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/**
	 *  Handler执行完成之后调用这个方法 
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
