package com.bjsxt.dubbo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.bjsxt.mapper.MenuMapper;
import com.bjsxt.dubbo.service.MenuDubboService;
import com.bjsxt.pojo.Menu;

@Service
public class MenuDubboServiceImpl implements MenuDubboService {
	@Autowired
	private MenuMapper menuMapper;
	@Override
	public List<Menu> selByUidPid(long uid, long pid) {
		return menuMapper.selByUid(uid, pid);
	}

}
