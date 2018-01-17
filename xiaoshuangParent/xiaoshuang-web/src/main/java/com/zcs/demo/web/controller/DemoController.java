package com.zcs.demo.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 *
 * @see
 * @author  zhoucunshuang@163.com
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

		