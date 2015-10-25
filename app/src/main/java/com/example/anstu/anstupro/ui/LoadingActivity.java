package com.example.anstu.anstupro.ui;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.WindowManager;

import com.example.anstu.anstupro.R;
import com.example.anstu.anstupro.comm.Constant;
import com.example.anstu.anstupro.ui.util.Utility;

import java.util.Timer;

/**
 * @ClassName: LoadingActivity.java
 * @Description:Loading界面
 * @Author: zxy
 * @CreateDate: 2015/07/26
 */
@SuppressLint("HandlerLeak")
public class LoadingActivity extends BaseActivity {

    private static final int RUNNALE_TAG_WAITING = 10001;
    private static final int RUNNALE_TAG_TIMEOUT = 10002;
    private static final int LOADING_WAIT_TIME = 3000;
    private boolean isShowingSetNetAlertDialog = false;
    private AlertDialog alertDialog;
    private SharedPreferences sp;
    private Timer timer = null;// 定时器
    private boolean flag = true;// 线程开关

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_activity);
        setMyActivity(this);
        sp = getSharedPreferences("myLoadingSp", MODE_PRIVATE);
        // 检查网络状况
        checkNetState(this);
        // 计算屏幕分辨率比率
        WindowManager window = this.getWindowManager();
        Constant.SCREEN_HEIGHT = window.getDefaultDisplay().getHeight();
        Constant.SCREEN_WIDTH = window.getDefaultDisplay().getWidth();
        Log.i("zxy", "SCREEN_HEIGHT = " + Constant.SCREEN_HEIGHT + "   SCREEN_WIDTH = " + Constant.SCREEN_WIDTH);
    }

    private Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.i("zxy", "do myHandler,msg.what="+msg.what);
            switch (msg.what) {
                case RUNNALE_TAG_WAITING: // loading页面等待
                    // 判断是否是自动登录
                    if (sp.getBoolean("is_auto_login", false)) {
                        Log.i("zxy", "goto homepage");
                        login(sp.getString("user_name", ""), sp.getString("password", ""));
                    } else {
                        Log.i("zxy", "goto login");
                        startActivity(new Intent(Constant.ACTIVITY_NAME_LOGIN));
                        finish();
                    }
                    break;
                case RUNNALE_TAG_TIMEOUT: // loading等待超时
                    myHandler.removeCallbacks(runnable);
                    break;
                case R.id.thread_tag_login: // 用户登录

                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onRestart() {
        super.onRestart();
        // 从WIFI设置界面返回时调用计时器 检查网络状态
        if (alertDialog != null) {
            alertDialog.cancel();
        }
        timer = new Timer();
        timer.schedule(new checkNetStateTimerTask(), 2000, 3000);
    }

    /**
     * @MethodName: checkNetState
     * @Description:检查网络状况
     * @Author: zxy
     * @CreateDate: 2013/01/09
     */
    @SuppressLint("NewApi")
    private void checkNetState(Context context) {
        // 判断网络连接状态
        if (Utility.getCurrentNetType(context) == Constant.NETWORK_TYPE_NONE) { // 断网
            isShowingSetNetAlertDialog = true;
            // 弹出请求设置WIFI网络的对话框
            alertDialog = new AlertDialog.Builder(this).setIcon(R.mipmap.ic_launcher)
                    .setTitle(R.string.dialog_system_prompt_str).setMessage(R.string.dialog_net_setting_str)
                    .setPositiveButton(R.string.dialog_setting_btn_str, new AlertDialog.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // isShowingSetNetAlertDialog = true;
                            // 跳转至WIFI设置界面
                            startActivity(new Intent("android.settings.WIFI_SETTINGS"));
                            if (alertDialog != null)
                                alertDialog.cancel();
                        }
                    }).setOnCancelListener(new OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            Log.i("zxy", " alertDialog  onCancel");
                            isShowingSetNetAlertDialog = false;
                            if (timer != null) {
                                timer.cancel();
                                timer = null;
                            }
                            // 开启计时器，等待2秒检查网络状态
                            timer = new Timer();
                            timer.schedule(new checkNetStateTimerTask(), 2000, 3000);
                        }
                    }).create();
            alertDialog.show();
        } else { // wifi或者gprs
            new Thread(runnable).start();
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            myHandler.sendEmptyMessageDelayed(RUNNALE_TAG_WAITING, LoadingActivity.LOADING_WAIT_TIME);
        }
    };

    /**
     * ***
     *
     * @Method: checkNetStateTimerTask
     * @Description: 扫描网络连接状态的计时器 在没有对话框弹出的情况下等待2秒 发送消息弹出提示框
     * @Author: Libin
     * @CreateDate: 2014-05-11
     * ****
     */
    public class checkNetStateTimerTask extends java.util.TimerTask {
        @Override
        public void run() {
            Log.i("zxy", "checkNetStateTimerTask start~~");
            if (!isShowingSetNetAlertDialog && timerHandler != null) {// 如果已经有该提示框已经弹出，则不再弹出提示框
                timerHandler.sendEmptyMessage(0);
            }
            cancel();// 关闭计时器
        }
    }

    /**
     * 计时器接收
     */
    private Handler timerHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            // 检查网络
            checkNetState(LoadingActivity.this);
        }
    };

    /**
     * @MethodName: login
     * @Description: 自动登录
     * @Author: zxy
     * @CreateDate: 2014/04/08
     */
    private void login(String username, String userpwd) {
        showProgress(R.string.dialog_operation_prompt_str, R.string.login_loading_str);
//        new UserAsyncTask(username, userpwd, myHandler, R.id.TaskDoLogin).execute();
    }


    @Override
    protected void onDestroy() {
        if (myHandler != null) {
            myHandler.removeCallbacksAndMessages(myHandler);
            myHandler = null;
        }
        if (timerHandler != null) {
            timerHandler.removeCallbacksAndMessages(timerHandler);
            timerHandler = null;
        }
        if (timer != null) {
            timer.purge();
            timer = null;
        }
        if (runnable != null) {
            runnable = null;
        }
        super.onDestroy();
    }

}
