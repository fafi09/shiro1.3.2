package com.bjsxt.manage.filter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;

public class MyUserFilter extends UserFilter {
	@Override
	protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
		System.out.println("执行自定义");
		String loginUrl = "/";
        WebUtils.issueRedirect(request, response, loginUrl);
	}
}
