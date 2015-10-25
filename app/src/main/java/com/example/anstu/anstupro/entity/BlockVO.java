package com.example.anstu.anstupro.entity;

import java.io.Serializable;

/**
 * @FileName: BlockVO.java
 * @Description:词块类
 * @Author: yangxd
 * @CreateDate: 2014/03/31
 */
public class BlockVO implements Serializable{//序列化
	
	private String modelId;		// 词块ID
	private String pageId;		// 页面ID
	private String name;		// 词块名称
	private String nodeId;		// 节点ID
	private String nodeName;	// 节点名称
	private String type;		// 词块类型	1:功能词块	2:快捷词块
	private String mId;			// 流水ID
	
	public String getModelId() {
		return modelId;
	}
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	public String getPageId() {
		return pageId;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
}
