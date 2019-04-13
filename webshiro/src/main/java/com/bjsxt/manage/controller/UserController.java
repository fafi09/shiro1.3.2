package com.bjsxt.manage.controller;

import java.security.Security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.commons.ManageResult;
import com.bjsxt.manage.service.UserService;
import com.bjsxt.pojo.User;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	/**
	 * 未添加shiro时-登录功能
	 * @param user
	 * @return
	 */
//	@RequestMapping("login")
//	@ResponseBody
//	public ManageResult login(User user,String validCode,HttpSession session){
//		if(validCode!=null&&!validCode.equals("")){
//			String code = session.getAttribute("validateCode").toString();
//			if(code.equalsIgnoreCase(validCode)){
//				ManageResult mr = userService.login(user);
//				if(mr.getStatus()==200){
//					session.setAttribute("user", (User)mr.getData());
//				}
//				return mr;
//			}
//		}
//		
//		ManageResult mr = new ManageResult();
//		mr.setMsg("验证码不正确");
//		return mr;
//	}
	/**
	 * 认证失败执行的控制器
	 * @return
	 */
	@RequestMapping("login")
	@ResponseBody
	public ManageResult login(HttpServletRequest req){
		Object obj = req.getAttribute("shiroLoginFailure");
		if(obj.toString().equals(UnknownAccountException.class.getName())){
			System.out.println("账户不存在");
		}else if(obj.toString().equals(IncorrectCredentialsException.class.getName())){
			System.out.println("密码错误");
		}else{
			System.out.println("其他错误");
		}
		ManageResult mr = new ManageResult();
		mr.setMsg("登录失败");
		return mr;
	}
	/**
	 * 认证成功执行的控制器
	 * @return
	 */
	@RequestMapping("success")
	@ResponseBody
	public ManageResult success(){
		//把use取出
		Object obj = SecurityUtils.getSubject().getPrincipal();
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute("user", obj);
		ManageResult mr = new ManageResult();
		mr.setStatus(200);
		return mr;
	}
	/**
	 * 验证码错误
	 * @return
	 */
	@RequestMapping("validateError")
	@ResponseBody
	public ManageResult validateError(){
		ManageResult mr = new ManageResult();
		mr.setMsg("验证码错误");
		return mr;
	}
}
