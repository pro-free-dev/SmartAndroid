package com.example.anstu.anstupro.entity;

/**
 * @FileName: PlanVO.java
 * @Description:计划类
 * @Author: yangxd
 * @CreateDate: 2014/03/31
 */
public class PlanVO {
	
	private int uplanNum;				// 计划产量
	private int uplanActualQuantity;	// 完成产量
	private int uplanGoodQuantity;		// 良品产量
	private String uplanName;			// 计划名称
	private String uprodType;			// 产品型号
	private String userProId;			// 流水ID
	private String image;				// 产品图片
	private String uplanStatus;			// 计划状态
	private String uplanType;			// 计划类型
	private String uplanNo;				// 计划编号
	
	public int getUplanNum() {
		return uplanNum;
	}
	public void setUplanNum(int uplanNum) {
		this.uplanNum = uplanNum;
	}
	public int getUplanActualQuantity() {
		return uplanActualQuantity;
	}
	public void setUplanActualQuantity(int uplanActualQuantity) {
		this.uplanActualQuantity = uplanActualQuantity;
	}
	public int getUplanGoodQuantity() {
		return uplanGoodQuantity;
	}
	public void setUplanGoodQuantity(int uplanGoodQuantity) {
		this.uplanGoodQuantity = uplanGoodQuantity;
	}
	public String getUplanName() {
		return uplanName;
	}
	public void setUplanName(String uplanName) {
		this.uplanName = uplanName;
	}
	public String getUprodType() {
		return uprodType;
	}
	public void setUprodType(String uprodType) {
		this.uprodType = uprodType;
	}
	public String getUserProId() {
		return userProId;
	}
	public void setUserProId(String userProId) {
		this.userProId = userProId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUplanStatus() {
		return uplanStatus;
	}
	public void setUplanStatus(String uplanStatus) {
		this.uplanStatus = uplanStatus;
	}
	public String getUplanType() {
		return uplanType;
	}
	public void setUplanType(String uplanType) {
		this.uplanType = uplanType;
	}
	public String getUplanNo() {
		return uplanNo;
	}
	public void setUplanNo(String uplanNo) {
		this.uplanNo = uplanNo;
	}
}
