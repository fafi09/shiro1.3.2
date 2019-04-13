package com.bjsxt.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.commons.ManageResult;
import com.bjsxt.dubbo.service.UserDubboService;
import com.bjsxt.manage.service.UserService;
import com.bjsxt.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDubboService userDubboService;
	@Override
	public ManageResult login(User user) {
		ManageResult mr = new ManageResult();
		User userResult = userDubboService.selByUser(user);
		if(userResult!=null){
			mr.setStatus(200);
			mr.setData(userResult);
		}else{
			//错误提交小时
			mr.setMsg("用户名或密码错误");
		}
		return mr;
	}

}
