package com.bjsxt.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.Comment;

public interface CommentMapper {
	/**
	 * 
	 * @param pageStart 从哪条开始
	 * @param pageSize
	 * @return
	 */
	@Select("select * from comment limit #{0},#{1}")
	List<Comment> selByPage(int pageStart,int pageSize);
	/**
	 * 查询总个数
	 * @return
	 */
	@Select("select count(*) from comment")
	Long selCount();
}
