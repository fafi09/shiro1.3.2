package com.bjsxt.manage.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class MyLoginFilter extends FormAuthenticationFilter{
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
//		System.out.println("执行了");
		String validateCode = request.getParameter("validCode");
		String sessionValidCode = ((HttpServletRequest)request).getSession().getAttribute("validateCode").toString();
		if(sessionValidCode.equals(validateCode)){
			return super.onAccessDenied(request, response);
		}else{
			System.out.println("执行return false");
			((HttpServletRequest)request).getRequestDispatcher("validateError").forward(request, response);
			//阻止程序继续执行.
			return false;
		}
	}
}
