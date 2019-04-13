package com.bjsxt.dubbo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.bjsxt.mapper.UserMapper;
import com.bjsxt.dubbo.service.UserDubboService;
import com.bjsxt.pojo.User;

@Service
public class UserDubboServiceImpl implements UserDubboService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public User selByUser(User user) {
		return userMapper.selByUser(user);
	}
	@Override
	public User selByUsername(String username) {
		return userMapper.selByUsername(username);
	}

	
}
