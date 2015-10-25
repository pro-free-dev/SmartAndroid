package com.example.anstu.anstupro.entity;

import java.util.List;

/**
 * @FileName: DeviceVO.java
 * @Description:设备类
 * @Author: yangxd
 * @CreateDate: 2014/03/31
 */
public class DeviceVO {
	
	private int breakdownTime;		// 故障时间	
	private int cuttingTime;		// 切削时间
	private int stopTime;			// 关机时间
	private int processTime;		// 加工时间
	private int idleTime;			// 空闲时间
	private int prepareTime;		// 准备时间
	private int runningTime;		// 
	private int equId;				// 
	private String equSerialNo;		// 设备序列号
	private String equName;			// 设备名
	private String imageUrl;		// 图片路径
	private String parentName;
	private String grandfatherName;
	private String status;
	private String operatingRate;	// 开工率
	private String prepareRate;		// 准备率
	private String offlineRate;		// 脱机率
	private String idleRate;		// 空闲率
	private String failureRate;		// 故障率
	private String flag;
	private String macAddress;		// 设备mac地址
	private List<String> values;
	private List<OEEVO> oeeList;
	
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public List<OEEVO> getOeeList() {
		return oeeList;
	}
	public void setOeeList(List<OEEVO> oeeList) {
		this.oeeList = oeeList;
	}
	public int getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}
	public int getBreakdownTime() {
		return breakdownTime;
	}
	public void setBreakdownTime(int breakdownTime) {
		this.breakdownTime = breakdownTime;
	}
	public int getCuttingTime() {
		return cuttingTime;
	}
	public void setCuttingTime(int cuttingTime) {
		this.cuttingTime = cuttingTime;
	}
	public int getStopTime() {
		return stopTime;
	}
	public void setStopTime(int stopTime) {
		this.stopTime = stopTime;
	}
	public int getProcessTime() {
		return processTime;
	}
	public void setProcessTime(int processTime) {
		this.processTime = processTime;
	}
	public int getIdleTime() {
		return idleTime;
	}
	public void setIdleTime(int idleTime) {
		this.idleTime = idleTime;
	}
	public int getPrepareTime() {
		return prepareTime;
	}
	public void setPrepareTime(int prepareTime) {
		this.prepareTime = prepareTime;
	}
	public int getEquId() {
		return equId;
	}
	public void setEquId(int equId) {
		this.equId = equId;
	}
	public String getEquSerialNo() {
		return equSerialNo;
	}
	public void setEquSerialNo(String equSerialNo) {
		this.equSerialNo = equSerialNo;
	}
	public String getEquName() {
		return equName;
	}
	public void setEquName(String equName) {
		this.equName = equName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getGrandfatherName() {
		return grandfatherName;
	}
	public void setGrandfatherName(String grandfatherName) {
		this.grandfatherName = grandfatherName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOperatingRate() {
		return operatingRate;
	}
	public void setOperatingRate(String operatingRate) {
		this.operatingRate = operatingRate;
	}
	public String getPrepareRate() {
		return prepareRate;
	}
	public void setPrepareRate(String prepareRate) {
		this.prepareRate = prepareRate;
	}
	public String getOfflineRate() {
		return offlineRate;
	}
	public void setOfflineRate(String offlineRate) {
		this.offlineRate = offlineRate;
	}
	public String getIdleRate() {
		return idleRate;
	}
	public void setIdleRate(String idleRate) {
		this.idleRate = idleRate;
	}
	public String getFailureRate() {
		return failureRate;
	}
	public void setFailureRate(String failureRate) {
		this.failureRate = failureRate;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public List<String> getValues() {
		return values;
	}
	public void setValues(List<String> values) {
		this.values = values;
	}
}
