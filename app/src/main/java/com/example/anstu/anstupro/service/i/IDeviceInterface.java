package com.example.anstu.anstupro.service.i;

import android.os.Handler;

/**
 * @ClassName: IDeviceInterface.java
 * @Description:设备接口类
 * @Author: yangxd
 * @CreateDate: 2014/04/29
 */
public interface IDeviceInterface {

	/**
	 * @MethodName: getFunctionTMagneticBlocks
	 * @Description:获取我的功能磁块列表
	 * @Author: yangxd
	 * @CreateDate: 2014/04/29
	 */
	public void getFunctionTMagneticBlocks(String userId, Handler myHandler, int threadTag);
	/**
	 * @MethodName: getShortcutTMagneticBlocks
	 * @Description:获取我的快捷磁块列表
	 * @Author: yangxd
	 * @CreateDate: 2014/04/29
	 */
	public void getShortcutTMagneticBlocks(String userId, Handler myHandler, int threadTag);
	/**
	 * @MethodName: addMyTMagneticBlocksByUserId
	 * @Description:添加我的磁块
	 * @Author: yangxd
	 * @CreateDate: 2014/04/29
	 */
	public void addMyTMagneticBlocksByUserId(String userId, String nodeId,
											 String modelIds, String type, Handler myHandler, int threadTag);
	/**
	 * @MethodName: updateMyTMagneticBlocks
	 * @Description:更新我的功能磁块
	 * @Author: yangxd
	 * @CreateDate: 2014/04/29
	 */
	public void updateMyTMagneticBlocks(String userId, String nodeId,
										String modelId, Handler myHandler, int threadTag);
	/**
	 * @MethodName: delMyTMagneticBlocks
	 * @Description:删除我的磁块
	 * @Author: yangxd
	 * @CreateDate: 2014/04/29
	 */
	public void delMyTMagneticBlocks(String modelId, Handler myHandler, int threadTag);
	/**
	 * @MethodName: compareDevicesTime
	 * @Description:查看时间分析比较
	 * @Author: yangxd
	 * @CreateDate: 2014/04/29
	 */
	public void compareDevicesTime(String userId, String nodeId, String equserialNos,
								   String startTime, String endTime, String flag, Handler myHandler, int threadTag);
	/**
	 * @MethodName: getOEECompare
	 * @Description:查看设备效率
	 * @Author: yangxd
	 * @CreateDate: 2014/04/29
	 */
	public void getOEECompare(String userId, String nodeId, String equserialNo,
							  String startTime, String endTime, String compareContent, String unit,
							  String flag, Handler myHandler, int threadTag);
	/**
	 * @MethodName: getStatisticalEquipmentStatusInfo
	 * @Description:查看设备开动率
	 * @Author: yangxd
	 * @CreateDate: 2014/04/29
	 */
	public void getStatisticalEquipmentStatusInfo(String userId,
												  String nodeId, Handler myHandler, int threadTag);
	/**
	 * @MethodName: getNodeequipmentList
	 * @Description:获取节点下设备列表
	 * @Author: yangxd
	 * @CreateDate: 2014/04/29
	 */
	public void getNodeequipmentList(String userId, String nodeId,
									 String flag, Handler myHandler, int threadTag);
	/**
	 * @MethodName: addMyEquipment
	 * @Description:添加我的设备
	 * @Author: yangxd
	 * @CreateDate: 2014/04/29
	 */
	public void addMyEquipment(String userId, String nodeId,
							   String equSerialNo, Handler myHandler, int threadTag);
	/**
	 * @MethodName: deleteMyEquipment
	 * @Description:删除我的设备
	 * @Author: yangxd
	 * @CreateDate: 2014/04/29
	 */
	public void deleteMyEquipment(String userId,
								  String equSerialNo, Handler myHandler, int threadTag);
	/**
	 * @MethodName: getEquipmentDetail
	 * @Description:获取机床信息
	 * @Author: yangxd
	 * @CreateDate: 2014/04/29
	 */
	public void getEquipmentDetail(String equSerialNo, Handler myHandler, int threadTag);
}
