package com.bjsxt.bjsxt.mapper;

import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.User;

public interface UserMapper {
	/**
	 * 根据用户名和密码查询用户信息
	 * @param user
	 * @return
	 */
	@Select("select * from user where username=#{username} and password=#{password}")
	User selByUser(User user);
	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return
	 */
	@Select("select * from user where username=#{username}")
	User selByUsername(String username);
}
