package com.example.anstu.anstupro.service.i;

import android.os.Handler;


/**
 * @ClassName: IUserInterface.java
 * @Description:用户接口类
 * @Author: yangxd
 * @CreateDate: 2014/04/29
 */
public interface IUserInterface {

	/**
	 * @MethodName: login
	 * @Description:登录
	 * @Author: yangxd
	 * @CreateDate: 2014/04/29
	 */
	public void login(String username, String userpwd, Handler myHandler, int threadTag);
}
