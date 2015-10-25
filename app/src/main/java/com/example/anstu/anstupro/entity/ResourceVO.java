package com.example.anstu.anstupro.entity;

import java.util.List;

/**
 * @FileName: ResourceVO.java
 * @Description:资源类
 * @Author: yangxd
 * @CreateDate: 2014/03/31
 */
public class ResourceVO {
	
	private int userResourceId;			// 物料ID
	private int replaceId;				// 消耗ID
	private String uResoNo;				// 物料编号
	private String image;				// 图片
	private String uResoUnit;			// 资源单位
	private String uResoStock;			// 资源库存
	private String uResoNorms;			// 资源规格
	private String uResoProvider;		// 资源厂家
	private String beginTime;			// 开始时间
	private String endTime;				// 结束时间
	private String usedAmount;			// 使用数量
	private List<String> uResoTypeList;	// 物料类型
	
	public int getUserResourceId() {
		return userResourceId;
	}
	public void setUserResourceId(int userResourceId) {
		this.userResourceId = userResourceId;
	}
	public int getReplaceId() {
		return replaceId;
	}
	public void setReplaceId(int replaceId) {
		this.replaceId = replaceId;
	}
	public String getuResoNo() {
		return uResoNo;
	}
	public void setuResoNo(String uResoNo) {
		this.uResoNo = uResoNo;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getuResoUnit() {
		return uResoUnit;
	}
	public void setuResoUnit(String uResoUnit) {
		this.uResoUnit = uResoUnit;
	}
	public String getuResoStock() {
		return uResoStock;
	}
	public void setuResoStock(String uResoStock) {
		this.uResoStock = uResoStock;
	}
	public String getuResoNorms() {
		return uResoNorms;
	}
	public void setuResoNorms(String uResoNorms) {
		this.uResoNorms = uResoNorms;
	}
	public String getuResoProvider() {
		return uResoProvider;
	}
	public void setuResoProvider(String uResoProvider) {
		this.uResoProvider = uResoProvider;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getUsedAmount() {
		return usedAmount;
	}
	public void setUsedAmount(String usedAmount) {
		this.usedAmount = usedAmount;
	}
	public List<String> getuResoTypeList() {
		return uResoTypeList;
	}
	public void setuResoTypeList(List<String> uResoTypeList) {
		this.uResoTypeList = uResoTypeList;
	}
}
