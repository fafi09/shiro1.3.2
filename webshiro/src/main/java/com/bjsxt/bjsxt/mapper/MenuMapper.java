package com.bjsxt.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.Menu;

public interface MenuMapper {
	@Select("select *,case pid when 0 then 'closed' else  'open' end state from menu where pid=#{1} and  id in (select mid from permission_menu where pid in(select pid from role_permission where rid in (select rid from role_user where uid=#{0})))")
	List<Menu> selByUid(long uid,long pid);
}
