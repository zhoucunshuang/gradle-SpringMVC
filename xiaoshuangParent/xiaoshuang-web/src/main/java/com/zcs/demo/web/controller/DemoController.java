/** 
 * @单位名称：合肥斡亿信息科技有限公司
 * @Copyright (c) 2018 All Rights Reserved.
 * @系统名称：微信平台
 * @工程名称：xiaoshuang-web
 * @文件名称: DemoController.java
 * @类路径: com.zcs.demo.web.controller
 */
package com.zcs.demo.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 *
 * @see
 * @author  cszhou@woyitech.com
 * @date	2018年1月16日 下午2:51:27
 * @version
 * @desc    TODO
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
	
	@RequestMapping("/test")
	public String demo(HttpServletRequest request, HttpServletResponse response){
		System.out.println("1231312");
		return "12312321";
	}

}

		