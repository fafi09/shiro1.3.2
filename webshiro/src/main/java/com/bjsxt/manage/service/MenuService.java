package com.bjsxt.manage.service;

import java.util.List;

import com.bjsxt.manage.pojo.EasyUITree;
import com.bjsxt.pojo.Menu;

public interface MenuService {
	/**
	 * 查询当前用户一级菜单
	 * @param uid
	 * @param pid
	 * @return
	 */
	List<EasyUITree> selByUidPid(long uid,long pid);
}
