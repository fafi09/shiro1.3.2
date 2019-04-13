package com.bjsxt.manage.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.dubbo.service.CommentDubboService;
import com.bjsxt.manage.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDubboService commentDubboService;
	@Override
	public Map<String, Object> showComment(int pageNumber, int pageSize) {
		Map<String, Object> map = new HashMap<>();
		map.put("rows", commentDubboService.selBy(pageSize*(pageNumber-1), pageSize));
		map.put("total", commentDubboService.selCount());
		return map;
	}

}
