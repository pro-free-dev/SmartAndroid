package com.example.anstu.anstupro.entity;

/**
 * @FileName: ProductionVO.java
 * @Description:产品类
 * @Author: yangxd
 * @CreateDate: 2014/06/05
 */
public class ProductionVO {
	
	private String uprodName;		// 产品名称
	private String uprodType;		// 产品类型
	private String userProdId;		// 产品id
	private int dailyOutput;		// 日产量
	private int weeklyOutput;		// 周产量
	private int monthlyOutput;		// 月产量
	private int annualOutput;		// 年产量
	private int totalOutput;		// 总产量
	
	public String getUprodName() {
		return uprodName;
	}
	public void setUprodName(String uprodName) {
		this.uprodName = uprodName;
	}
	public String getUprodType() {
		return uprodType;
	}
	public void setUprodType(String uprodType) {
		this.uprodType = uprodType;
	}
	public String getUserProdId() {
		return userProdId;
	}
	public void setUserProdId(String userProdId) {
		this.userProdId = userProdId;
	}
	public int getDailyOutput() {
		return dailyOutput;
	}
	public void setDailyOutput(int dailyOutput) {
		this.dailyOutput = dailyOutput;
	}
	public int getWeeklyOutput() {
		return weeklyOutput;
	}
	public void setWeeklyOutput(int weeklyOutput) {
		this.weeklyOutput = weeklyOutput;
	}
	public int getMonthlyOutput() {
		return monthlyOutput;
	}
	public void setMonthlyOutput(int monthlyOutput) {
		this.monthlyOutput = monthlyOutput;
	}
	public int getAnnualOutput() {
		return annualOutput;
	}
	public void setAnnualOutput(int annualOutput) {
		this.annualOutput = annualOutput;
	}
	public int getTotalOutput() {
		return totalOutput;
	}
	public void setTotalOutput(int totalOutput) {
		this.totalOutput = totalOutput;
	}
}
