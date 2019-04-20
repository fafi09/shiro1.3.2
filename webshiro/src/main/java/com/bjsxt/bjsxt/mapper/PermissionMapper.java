package com.bjsxt.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface PermissionMapper {

	@Select("select pid from role_permission where rid in (select rid from role_user where uid=#{0})")
	List<Long> selPermissionByUid(long uid);
}
