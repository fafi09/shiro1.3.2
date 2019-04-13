package com.bjsxt.manage.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjsxt.pojo.User;

@Controller
public class PageController {
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/")
	public String welcome(){
		Object obj = SecurityUtils.getSubject().getPrincipal();
		System.out.println("obj:"+obj);
		System.out.println("user"+SecurityUtils.getSubject().getSession().getAttribute("user"));
		
		//当前处于登录状态.
		if(obj!=null){
			SecurityUtils.getSubject().getSession().setAttribute("user", obj);
			return "main";
		}
		return "index";
	}
	/**
	 * 显示页面
	 * @param page
	 * @return
	 */
	@RequestMapping("{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
	/**
	 * 显示网站基本设置页面
	 * @param page
	 * @return
	 */
	@RequestMapping("base/{page}")
	public String showBasePage(@PathVariable String page){
		return "base/"+page;
	}
}
