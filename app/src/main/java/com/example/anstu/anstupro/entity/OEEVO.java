package com.example.anstu.anstupro.entity;

/**
 * @FileName: OEEVO.java
 * @Description:OEE类
 * @Author: yangxd
 * @CreateDate: 2014/03/31
 */
public class OEEVO {

	private String caclDate;		// 日
	private String weekOfYear;		// 周
	private String month;			// 月
	private String year;			// 年
	private double oeeValue;		// oee值
	private double teepValue;		// teep值
	
	public double getOeeValue() {
		return oeeValue;
	}
	public void setOeeValue(double oeeValue) {
		this.oeeValue = oeeValue;
	}
	public double getTeepValue() {
		return teepValue;
	}
	public void setTeepValue(double teepValue) {
		this.teepValue = teepValue;
	}
	public String getCaclDate() {
		return caclDate;
	}
	public void setCaclDate(String caclDate) {
		this.caclDate = caclDate;
	}
	public String getWeekOfYear() {
		return weekOfYear;
	}
	public void setWeekOfYear(String weekOfYear) {
		this.weekOfYear = weekOfYear;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	
}
