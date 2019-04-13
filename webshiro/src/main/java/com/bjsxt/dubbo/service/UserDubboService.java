package com.bjsxt.dubbo.service;

import com.bjsxt.commons.ManageResult;
import com.bjsxt.pojo.User;

public interface UserDubboService {
	/**
	 * 根据用户名和密码查询用户
	 * @param user
	 * @return
	 */
	User selByUser(User user);
	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return
	 */
	User selByUsername(String username);
}
