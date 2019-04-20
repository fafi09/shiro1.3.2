package com.bjsxt.dubbo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.bjsxt.mapper.PermissionMapper;
import com.bjsxt.dubbo.service.PermissionDubboService;

@Service
public class PermissionDubboServiceImpl implements PermissionDubboService {

	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	public List<Long> selPermissionByUid(long uid) {
		return permissionMapper.selPermissionByUid(uid);
	}

}
