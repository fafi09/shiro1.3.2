package com.bjsxt.manage.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.manage.pojo.EasyUITree;
import com.bjsxt.manage.service.MenuService;
import com.bjsxt.pojo.Menu;
import com.bjsxt.pojo.User;

@Controller
public class MenuController  {
	@Autowired
	private MenuService menuService;
	
	/**
	 * 查询菜单内容
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping("showMenu")
	@ResponseBody
	public List<EasyUITree> showMenu(@RequestParam(defaultValue="0") long id){
		Session session = SecurityUtils.getSubject().getSession();
		
		User user = (User)session.getAttribute("user");
		if(user==null){
			session.setAttribute("user", SecurityUtils.getSubject().getPrincipal());
			user = (User)session.getAttribute("user");
		}
		return menuService.selByUidPid(user.getId(), id);
	}
}
