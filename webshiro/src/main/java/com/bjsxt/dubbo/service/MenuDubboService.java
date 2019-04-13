package com.bjsxt.dubbo.service;

import java.util.List;

import com.bjsxt.pojo.Menu;

public interface MenuDubboService {
	/**
	 * 只查询一层
	 * @param uid
	 * @param pid
	 * @return
	 */
	List<Menu> selByUidPid(long uid,long pid);
}
