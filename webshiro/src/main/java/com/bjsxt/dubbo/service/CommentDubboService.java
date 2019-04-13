package com.bjsxt.dubbo.service;

import java.util.List;

import com.bjsxt.pojo.Comment;

public interface CommentDubboService {
	/**
	 * 分页查询
	 * @param pageStart
	 * @param pageSize
	 * @return
	 */
	List<Comment> selBy(int pageStart,int pageSize);
	/**
	 * 总个数
	 * @return
	 */
	Long selCount();
}
