package com.example.anstu.anstupro.service.i;

import android.os.Handler;


/**
 * @ClassName: INodeInterface.java
 * @Description:节点接口类
 * @Author: yangxd
 * @CreateDate: 2014/04/29
 */
public interface INodeInterface {

	/**
	 * @MethodName: getAllNodesByParentNodeId
	 * @Description:获取节点下的所有子节点
	 * @Author: yangxd
	 * @CreateDate: 2014/04/29
	 */
	public void getAllNodesByParentNodeId(String userId, String nodeId, Handler myHandler, int threadTag);
	/**
	 * @MethodName: updateDefaultNode
	 * @Description:更新默认节点
	 * @Author: yangxd
	 * @CreateDate: 2014/04/29
	 */
	public void updateDefaultNode(String userId, String nodeId, Handler myHandler, int threadTag);
}
