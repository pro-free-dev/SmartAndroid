package com.example.anstu.anstupro.service.action;

import android.os.Handler;

import com.example.anstu.anstupro.service.i.IUserInterface;
import com.example.anstu.anstupro.service.task.UserAsyncTask;

/**
 * @ClassName: UserAction.java
 * @Description:用户操作类
 * @Author:
 * @CreateDate: 2014/04/29
 */
public class UserAction implements IUserInterface {

	/**
	 * @MethodName: login
	 * @Description:登录
	 * @Author: yangxd
	 * @CreateDate: 2014/04/29
	 */
	@Override
	public void login(String username, String userpwd, Handler myHandler, int threadTag) {
		new UserAsyncTask(username, userpwd, myHandler, threadTag);
	}
}
