package com.example.anstu.anstupro.entity;

/**
 * @FileName: NodeVO.java
 * @Description:节点类
 * @Author: yangxd
 * @CreateDate: 2014/03/31
 */
public class NodeVO {
	
	private String parentId;	// 父节点ID
	private String nodeId;		// 节点ID
	private String name;		// 节点名称
	private boolean isParent;	// 是否是父节点
	private String nodeType;	// 节点类型
	private String checked;		// 是否有权限
	
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isParent() {
		return isParent;
	}
	public void setIsParent(boolean isParent) {
		this.isParent = isParent;
	}
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
}
