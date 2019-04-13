package com.bjsxt.manage.service;

import com.bjsxt.commons.ManageResult;
import com.bjsxt.pojo.User;

public interface UserService {
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	ManageResult login(User user);
}
