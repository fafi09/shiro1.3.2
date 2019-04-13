package com.bjsxt.commons;

import java.io.Serializable;

public class ManageResult implements Serializable{
	//如果status=200 执行成功
	private int status;
	//返回内容.
	private Object data;
	//返回消息
	private String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
