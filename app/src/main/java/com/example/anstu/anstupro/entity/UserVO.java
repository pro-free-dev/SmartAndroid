package com.example.anstu.anstupro.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @FileName: UserVO.java
 * @Description:用户类
 * @Author:
 * @CreateDate:
 */
public class UserVO implements Serializable{
	private static final long serialVersionUID = -7060210544600464482L;//序列化ID 
	private int orgNode;				// 用户所属组织结构
	private String userId;				// 用户ID
	private String name;				// 用户名
	private String defaultNodeId;		// 默认节点ID
	private String defaultNodeName;		// 默认节点名
	private List<BlockVO> blockList;	// 词块列表
	
	public int getOrgNode() {
		return orgNode;
	}
	public void setOrgNode(int orgNode) {
		this.orgNode = orgNode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDefaultNodeId() {
		return defaultNodeId;
	}
	public void setDefaultNodeId(String defaultNodeId) {
		this.defaultNodeId = defaultNodeId;
	}
	public String getDefaultNodeName() {
		return defaultNodeName;
	}
	public void setDefaultNodeName(String defaultNodeName) {
		this.defaultNodeName = defaultNodeName;
	}
	public List<BlockVO> getBlockList() {
		return blockList;
	}
	public void setBlockList(List<BlockVO> blockList) {
		this.blockList = blockList;
	}
}
