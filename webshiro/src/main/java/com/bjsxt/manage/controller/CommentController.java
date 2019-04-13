package com.bjsxt.manage.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.manage.service.CommentService;

@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	/**
	 * 显示留言
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("showComment")
	@ResponseBody
	public Map<String,Object> showComment(int page,int rows){
		return commentService.showComment(page, rows);
	}
}
