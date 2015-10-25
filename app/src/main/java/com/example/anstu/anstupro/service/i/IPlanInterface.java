package com.example.anstu.anstupro.service.i;

import android.os.Handler;


/**
 * @ClassName: IPlanInterface.java
 * @Description:生产计划接口类
 * @Author: yangxd
 * @CreateDate: 2014/04/29
 */
public interface IPlanInterface {

	/**
	 * @MethodName: getPlanList
	 * @Description:获取生产计划列表
	 * @Author: yangxd
	 * @CreateDate: 2014/04/29
	 */
	public void getPlanList(String userId, String nodeId, String uplanStatus,
							String pageno, String timeValue, Handler myHandler, int threadTag);
	/**
	 * @MethodName: getStatus
	 * @Description:获取生产计划状态列表
	 * @Author: yangxd
	 * @CreateDate: 2014/04/29
	 */
	public void getStatus(String nodeId, Handler myHandler, int threadTag);
}
