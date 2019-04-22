package com.bjsxt.manage.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.commons.ManageResult;
import com.bjsxt.manage.service.CommentService;

@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	/**
	 * 显示留言
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("showComment")
	@ResponseBody
	public Map<String,Object> showComment(int page,int rows){
		return commentService.showComment(page, rows);
	}
	
	/**
	 * 权限的三种方式
	 * 1.显示调用方法subject.isPermitted("SRC")等
	 * 2.jsp标签 <shiro:hasPermission name="ADD"> <%@ taglib prefix="shiro"  uri="http://shiro.apache.org/tags"%>
	 * 3.方法上加注解@RequiresPermissions("SRC") spring-mvc.xml中开启 ,shiro.xml中声明依赖lifecycleBeanPostProcessor
	 * 
	 * @param req
	 * @return
	 */
	@RequiresPermissions("SRC")
	@RequestMapping("search")
	@ResponseBody
	public ManageResult searchCommnet(HttpServletRequest req) {
		Subject subject = SecurityUtils.getSubject();
		
		ManageResult mr = new ManageResult();
		if(subject.isPermitted("SRC")) {
			mr.setMsg("有浏览权限");
		} else {
			mr.setMsg("无浏览权限");
		}
		
		return mr;
	}
}
