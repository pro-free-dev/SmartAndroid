package com.example.anstu.anstupro.entity;


/**
 * @FileName: ApiResultVO.java
 * @Description:接口返回结果类
 * @Author:
 * @CreateDate:
 */
public class ApiResultVO {

	private String msg;			// 请求状态
	private boolean success;	// 是否成功获取数据
	private Object content;		// 结果
	private int count;			// 列表总数
	private int noReadCount;	// 派工单未读数
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getNoReadCount() {
		return noReadCount;
	}
	public void setNoReadCount(int noReadCount) {
		this.noReadCount = noReadCount;
	}
}
