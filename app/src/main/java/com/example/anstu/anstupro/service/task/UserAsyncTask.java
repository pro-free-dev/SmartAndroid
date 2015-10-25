package com.example.anstu.anstupro.service.task;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.anstu.anstupro.comm.Constant;
import com.example.anstu.anstupro.entity.ApiResultVO;
import com.example.anstu.anstupro.service.UserService;

/**
 * @FileName: UserAsyncTask.java
 * @Description:用户接口线程类
 * @Author:
 * @CreateDate:
 */
public class UserAsyncTask extends AsyncTask<Object, Integer, Object> {
	
	private Handler myHandler = null;
	private ApiResultVO resultVO = null;
	private String username = Constant.SPACE;
	private String userpwd = Constant.SPACE;
	private int threadTag = -1;
	
	/**
	 * 构造函数
	 * @Description:获取登录时使用
	 * @Author:
	 * @CreateDate:
	 */
	public UserAsyncTask(String username, String userpwd, Handler myHandler, int threadTag) {
		this.username = username;
		this.userpwd = userpwd;
		this.myHandler = myHandler;
		this.threadTag = threadTag;
	}
	@Override
	protected void onPostExecute(Object object) {
        Log.i("zxy", "login action -->onPostExecute");
		/*Message message = myHandler.obtainMessage();
		message.what = threadTag;
		message.obj = resultVO;
		myHandler.sendMessage(message);*/
        Message message = myHandler.obtainMessage();
        message.what = threadTag;
        myHandler.sendMessage(message);
	}
	@Override
	protected Object doInBackground(Object... params) {
		 return (resultVO = new UserService().login(username, userpwd));
	}
}
