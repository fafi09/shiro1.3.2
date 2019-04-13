package com.bjsxt.dubbo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.bjsxt.mapper.CommentMapper;
import com.bjsxt.dubbo.service.CommentDubboService;
import com.bjsxt.pojo.Comment;

@Service
public class CommentDubboServiceImpl implements CommentDubboService {
	@Autowired
	private CommentMapper commentMapper;
	@Override
	public List<Comment> selBy(int pageStart, int pageSize) {
		return commentMapper.selByPage(pageStart, pageSize);
	}

	@Override
	public Long selCount() {
		return commentMapper.selCount();
	}

}
