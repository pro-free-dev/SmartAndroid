package com.example.anstu.anstupro.comm;


import com.example.anstu.anstupro.entity.UserVO;

import java.util.List;

/**
 * @FileName: Constant.java
 * @Description:常量类
 * @Author:
 * @CreateDate:
 */
public class Constant {

	/**
	 * space
	 */
	public static final String SPACE = "";

	/**
	 * 用户
	 */
	public static boolean AUTO_LOGIN = false;

	/**
	 * 界面标示
	 */
	public static final int ACTIVITY_TAG_OUTPUT_LIST = 90001;
	public static final int ACTIVITY_TAG_PLAN_LIST = 90002;
	public static final int ACTIVITY_TAG_TIME_ANALYSIS = 90003;
	public static final int ACTIVITY_TAG_DEVIC_EEFFICIENCY = 90004;
	public static final int ACTIVITY_TAG_DEVICE_STATUS = 90005;
	public static final int ACTIVITY_TAG_DEVICE_RUNNINGRATE = 90006;
	public static final int ACTIVITY_TAG_RESOURCE_LIST = 90007;
	public static final int ACTIVITY_TAG_MAIN = 90008;

	/**
	 * 界面地址
	 */
	public static final String ACTIVITY_NAME_LOGIN = "com.example.anstu.anstupro.ui.LoginActivity";
	public static final String ACTIVITY_NAME_HOMEPAGE = "com.example.anstu.anstupro.ui.MainActivity";

	/**
	 * MainActivity的mainHandler接收的标志 ， 从每个fragment发来的message中判断操作类型
	 */
	public static final int HANDLER_OPEN_SUB_MENU = 0x0000;

	/**
	 * FilterActivity的标志，表示当前显示哪个类型的界面
	 */
	public static final int FILTER_TYPE_PLAN_LIST = 0x1001;
	public static final int FILTER_TYPE_TIME_ANALYSIS = 0x1002;
	public static final int FILTER_TYPE_DEVICE_EFFICIENCY = 0x1003;
	public static final int FILTER_TYPE_OUTPUT_COUNT = 0x1004;
	public static final int FILTER_TYPE_OUTPUT_TREND = 0x1005;

	/**
	 * 屏幕高宽
	 */
	public static int SCREEN_HEIGHT = 1280;
	public static int SCREEN_WIDTH = 720;

    /**
     * 用户信息类
     */
    public static UserVO userVO;

	/**
	 * 保存已添加的快捷方式集合 用于判断是否已经添加
	 */
	public static List<String> shortcutList;

	/**
	 * Fragment的定义标志，表示跳转目标
	 */
	public static final int FRAGMENT_PLAN_LIST = 0x2002;
	public static final int FRAGMENT_TIME_ANALYSIS = 0x2003;
	public static final int FRAGMENT_DEVICE_EFFICIENCY = 0x2004;
	public static final int FRAGMENT_DEVICE_RUNNINGRATE = 0x2005;
	public static final int FRAGMENT_DEVICE_STATUS = 0x2006;
	public static final int FRAGMENT_OUTPUT_COUNT = 0x2007;
	public static final int FRAGMENT_PARAM = 0x2008;

	/**
	 * 网络状态
	 */
	public static final int NETWORK_TYPE_NONE = 0x3000; // 断网情况
	public static final int NETWORK_TYPE_WIFI = 0x3001; // WiFi模式
	public static final int NETWOKR_TYPE_MOBILE = 0x3002; // gprs模式

}
