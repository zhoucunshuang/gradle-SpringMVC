
/** 
 * @单位名称：合肥斡亿信息科技有限公司
 * @Copyright (c) 2018 All Rights Reserved.
 * @系统名称：微信平台
 * @工程名称：xiaoshuang-web
 * @文件名称: LoginController.java
 * @类路径: com.zcs.login.web.controller
 */

		package com.zcs.login.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/** 
 *
 * @see
 * @author  cszhou@woyitech.com
 * @date	2018年1月16日 下午4:37:36
 * @version
 * @desc    TODO
 */
@Controller
@RequestMapping({ "/", "/web" })
public class LoginController {
    /**
     * 登入 登出入口
     * 
     * @param response
     * @param request
     */
    @RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
    public void homePage(HttpServletResponse response, HttpServletRequest request) {
	try {
	    response.setHeader("Pragma", "no-cache");
	    response.setDateHeader("Expires", 0);
	    response.addHeader("Cache-Control", "no-cache"); // 浏览器和缓存服务器都不应该缓存页面信息
	    response.addHeader("Cache-Control", "no-store"); // 请求和响应的信息都不应该被存储在对方的磁盘系统中；
	    response.addHeader("Cache-Control", "must-revalidate");
	    // 重定向到主界面 让cas过滤器跳转到登录界面或者执行cas注销
	    response.sendRedirect(request.getContextPath() + "/web/index");
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
	
	/**
     * index 主界面的入口(返回主界面)
     * @Title index
     * @author zhangshun
     * @param request
     * @param response
     * @param model
     * @return String
     */
	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		//获取密钥
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/index/login";
	}
	/**
	 * 
	 * @Title: login   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param request
	 * @param response
	 * @param model
	 * @return String
	 * @author cszhou@woyitech.com
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		//获取密钥
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/index/index";
	}

}

		