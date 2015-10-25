package com.example.anstu.anstupro.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.anstu.anstupro.R;
import com.example.anstu.anstupro.comm.Constant;

import java.util.ArrayList;

/**
 * @FileName: BaseActivity.java
 * @Description:基类
 * @Author:
 * @CreateDate:
 */
public class BaseActivity extends Activity {

    private Activity myActivity = null;
    private Toast myToast = null;
    private ProgressDialog myProgress = null;

    private long mExitTime;// 返回键 退出时间间隔

    private OnTitleBarClickListener titleBarClickListener;

    public void setOnTitleBarClickListener(OnTitleBarClickListener listener) {
        this.titleBarClickListener = listener;
    }

    /**
     * titlebar 按钮点击事件回调
     *
     * @author
     */
    public interface OnTitleBarClickListener {

        public void onLeftButtonClick();// titlebar 左键

        public void onRightButtonClick();// titlebar 右键

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((myActivity.getClass().getName().equals(Constant.ACTIVITY_NAME_HOMEPAGE) || myActivity.getClass().getName()
                .equals(Constant.ACTIVITY_NAME_LOGIN))
                && keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                showToast("再按一次返回键退出程序");
                mExitTime = System.currentTimeMillis();
            } else {
                System.exit(0);
            }
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
            if (getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null)
                closeKeyBoard();
        return super.onTouchEvent(event);
    }

    /**
     * @MethodName: setMyActivity
     * @Description:设置activity
     * @Author:
     * @CreateDate:
     */
    public void setMyActivity(Activity _activity) {
        this.myActivity = _activity;
        myToast = new Toast(myActivity);
    }

    /**
     * @MethodName: setTitleBar
     * @Description:设备标题栏
     * @Author:
     * @CreateDate:
     */
    public void setTitleBar(int titlebarBgId) {
//		// 初始化标题栏
//		LinearLayout layout = (LinearLayout) myActivity.findViewById(R.id.titlebar_layout);
//		// 设置标题栏背景
//		layout.setBackgroundResource(titlebarBgId);
    }

    /**
     * @MethodName: setTitleBar
     * @Description:设备标题栏
     * @Author:
     * @CreateDate:
     */
    public void setTitleBar(int titlebarBgId, int titlebarNameId, int leftBtnId) {
//		// 设置标题栏背景
//		setTitleBar(titlebarBgId);
//		// 初始化左侧按钮
//		ImageView leftBtn = (ImageView) myActivity.findViewById(R.id.titlebar_imageview_left);
//		// 设置左侧按钮图片
//		leftBtn.setBackgroundResource(leftBtnId);
//		// 初始化标题名
//		TextView textView = (TextView) myActivity.findViewById(R.id.titlebar_textview);
//		// 设置标题名
//		textView.setText(titlebarNameId);
//		leftBtn.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				if (titleBarClickListener != null)
//					titleBarClickListener.onLeftButtonClick();
//			}
//		});
//		// 隐藏右侧按钮
//		ImageView rightBtn = (ImageView) myActivity.findViewById(R.id.titlebar_imageview_right);
//		rightBtn.setBackgroundResource(leftBtnId);// 保持位置
//		rightBtn.setVisibility(View.INVISIBLE);

    }

    /**
     * @MethodName: setTitleBar
     * @Description:设备标题栏
     * @Author:
     * @CreateDate:
     */
    public void setTitleBar(int titlebarBgId, String titlebarName, int leftBtnId) {
//		// 设置标题栏背景
//		setTitleBar(titlebarBgId);
//		// 初始化左侧按钮
//		ImageView leftBtn = (ImageView) myActivity.findViewById(R.id.titlebar_imageview_left);
//		// 设置左侧按钮图片
//		leftBtn.setBackgroundResource(leftBtnId);
//		// 初始化标题名
//		TextView textView = (TextView) myActivity.findViewById(R.id.titlebar_textview);
//		// 设置标题名
//		textView.setText(titlebarName);
//		leftBtn.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				if (titleBarClickListener != null)
//					titleBarClickListener.onLeftButtonClick();
//			}
//		});
//		// 隐藏右侧按钮
//		ImageView rightBtn = (ImageView) myActivity.findViewById(R.id.titlebar_imageview_right);
//		rightBtn.setBackgroundResource(leftBtnId);// 保持位置
//		rightBtn.setVisibility(View.INVISIBLE);
    }

    /**
     * @MethodName: setTitleBar
     * @Description:设备标题栏
     * @Author:
     * @CreateDate:
     */
    public void setTitleBar(int titlebarBgId, int titlebarNameId, int leftBtnId, int rightBtnId) {
//		// 设置标题栏背景
//		setTitleBar(titlebarBgId);
//		// 初始化标题名
//		TextView textView = (TextView) myActivity.findViewById(R.id.titlebar_textview);
//		// 设置标题名
//		textView.setText(titlebarNameId);
//		// 初始化右侧按钮
//		ImageView rightBtn = (ImageView) myActivity.findViewById(R.id.titlebar_imageview_right);
//		// 设置右侧按钮图片
//		rightBtn.setBackgroundResource(rightBtnId);
//		rightBtn.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				if (titleBarClickListener != null)
//					titleBarClickListener.onRightButtonClick();
//			}
//		});
//		// 初始化左侧按钮
//		ImageView leftBtn = (ImageView) myActivity.findViewById(R.id.titlebar_imageview_left);
//		// 设置左侧按钮图片
//		leftBtn.setBackgroundResource(leftBtnId);
//		leftBtn.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				if (titleBarClickListener != null)
//					titleBarClickListener.onLeftButtonClick();
//			}
//		});
    }

    /**
     * @MethodName: setTitleBar
     * @Description:设备标题栏
     * @Author:
     * @CreateDate:
     */
    public void setTitleBar(int titlebarBgId, String titlebarName, int leftBtnId, int rightBtnId) {
//		// 设置标题栏背景
//		setTitleBar(titlebarBgId);
//		// 初始化标题名
//		TextView textView = (TextView) myActivity.findViewById(R.id.titlebar_textview);
//		// 设置标题名
//		textView.setText(titlebarName);
//		// 初始化右侧按钮
//		ImageView rightBtn = (ImageView) myActivity.findViewById(R.id.titlebar_imageview_right);
//		// 设置右侧按钮图片
//		rightBtn.setBackgroundResource(rightBtnId);
//		rightBtn.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				if (titleBarClickListener != null)
//					titleBarClickListener.onRightButtonClick();
//			}
//		});
//		// 初始化左侧按钮
//		ImageView leftBtn = (ImageView) myActivity.findViewById(R.id.titlebar_imageview_left);
//		// 设置左侧按钮图片
//		leftBtn.setBackgroundResource(leftBtnId);
//		leftBtn.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				if (titleBarClickListener != null)
//					titleBarClickListener.onLeftButtonClick();
//			}
//		});
    }

    /**
     * @MethodName: showToast
     * @Description:显示Toast
     * @Author:
     * @CreateDate:
     */
    public void showToast(int toastTextId) {
		LayoutInflater inflate = getLayoutInflater();
		View view = inflate.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_layout));
		TextView toastTextView = (TextView) view.findViewById(R.id.custom_toast_msg_textview);
		toastTextView.setText(toastTextId);
		myToast.setDuration(Toast.LENGTH_SHORT);
		myToast.setView(view);
		myToast.show();
    }

    /**
     * @MethodName: showToast
     * @Description:显示Toast
     * @Author:
     * @CreateDate:
     */
    public void showToast(String toastTextStr) {
        LayoutInflater inflate = getLayoutInflater();
        View view = inflate.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_layout));
        TextView toastTextView = (TextView) view.findViewById(R.id.custom_toast_msg_textview);
        toastTextView.setText(toastTextStr);
        myToast.setDuration(Toast.LENGTH_SHORT);
        myToast.setView(view);
        myToast.show();
    }

    /**
     * @MethodName: showProgress
     * @Description:显示进度条
     * @Author:
     * @CreateDate:
     */
    public void showProgress(String title, String message) {
        dismissProgress();
        myProgress = ProgressDialog.show(myActivity, title, message);
        myProgress.setCancelable(false);
    }

    /**
     * @MethodName: showProgress
     * @Description:显示进度条
     * @Author:
     * @CreateDate:
     */
    public void showProgress(int titleId, int messageId) {
        dismissProgress();
        myProgress = ProgressDialog.show(myActivity, getStringByResId(titleId), getStringByResId(messageId));
        myProgress.setCancelable(false);
    }

    /**
     * @MethodName:isProgressBarShowing
     * @Description: 当前是否显示进度条
     * @AuthorName:
     * @CreateDate:2014-6-25
     */
    public boolean isProgressBarShowing() {
        if (myProgress != null) {
            return myProgress.isShowing();
        }
        return false;
    }

    /**
     * @MethodName: dismissProgress
     * @Description:关闭进度条
     * @Author:
     * @CreateDate:
     */
    public void dismissProgress() {
        if (myProgress != null) {
            if (myProgress.isShowing())
                myProgress.dismiss();
            myProgress.cancel();
        }
    }

    /**
     * @MethodName: showNetSettingDialog
     * @Description:显示网络设置提示框
     * @Author:
     * @CreateDate:
     */
    public void showNetSettingDialog() {
//		AlertDialog dialog = new AlertDialog.Builder(myActivity).setIcon(R.drawable.app_icon)
//				.setTitle(R.string.dialog_system_prompt_str).setMessage(R.string.dialog_net_setting_str)
//				.setPositiveButton(R.string.dialog_setting_btn_str, new AlertDialog.OnClickListener() {
//					@Override
//					public void onClick(DialogInterface dialog, int which) {
//						startActivity(new Intent("android.settings.WIFI_SETTINGS"));
//					}
//				}).create();
//		dialog.show();
    }

    /**
     * @MethodName: closeKeyBoard
     * @Description:关闭软键盘
     * @Author:
     * @CreateDate:
     */
    public void closeKeyBoard() {
        ((InputMethodManager) myActivity.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                myActivity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * @MethodName: checkNetIsConnected
     * @Description:判断是否链接网路
     * @Author:
     * @CreateDate:
     */
    public boolean checkNetIsConnected() {
        NetworkInfo networkInfo = ((ConnectivityManager) myActivity.getSystemService(Context.CONNECTIVITY_SERVICE))
                .getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable())
            return true;
        return false;
    }

    /**
     * @MethodName: getStringByResId
     * @Description:根据资源ID获取字符串
     * @Author:
     * @CreateDate:
     */
    public String getStringByResId(int resId) {
        return getResources().getString(resId);
    }

    /**
     * @MethodName:saveUserLoginInfo
     * @Description: 保存用户名
     * @AuthorName:
     * @CreateDate:
     */
    public void saveUserLoginInfo(String userName, String password) {
        SharedPreferences sp = getSharedPreferences("symg", MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putString("user_name", userName);
        editor.putString("password", password);
        editor.commit();
    }

    /**
     * @MethodName:saveIsAutoLogin
     * @Description: 保存是否自动登录的标志
     * @AuthorName:
     * @CreateDate:
     */
    public void saveIsAutoLogin(boolean isAuto) {
        SharedPreferences sp = getSharedPreferences("symg", MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putBoolean("is_auto_login", isAuto);
        editor.commit();
    }

    /**
     * @MethodName:getLoginUserName
     * @Description: 获取保存的用户名
     * @AuthorName:
     * @CreateDate:
     */
    public String getLoginUserName() {
        SharedPreferences sp = getSharedPreferences("symg", MODE_PRIVATE);
        return sp.getString("user_name", "");
    }

    /**
     * @MethodName:getLoginPassword
     * @Description: 获取保存的密码
     * @AuthorName:
     * @CreateDate:
     */
    public String getLoginPassword() {
        SharedPreferences sp = getSharedPreferences("symg", MODE_PRIVATE);
        return sp.getString("password", "");
    }

    /**
     * @MethodName:saveDefaultNode
     * @Description: 保存默认节点ID和NAME
     * @AuthorName:
     * @CreateDate:
     */
    public void saveDefaultNode(String nodeName, String nodeID) {
        SharedPreferences sp = getSharedPreferences("symg", MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putString("default_node_name", nodeName);
        editor.putString("default_node_id", nodeID);
        editor.commit();
    }


    // 一下是为了保证程序在后台被回收后，保存重要的两个静态变量
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//		Log.i("TTTT", "onRestoreInstanceState");
//		super.onRestoreInstanceState(savedInstanceState);
//		Constant.userVO = (UserVO) savedInstanceState.getSerializable("uservo");
//		Constant.shortcutList = savedInstanceState.getStringArrayList("shortcut_list");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
//		Log.i("TTTT", "onSaveInstanceState");
//		super.onSaveInstanceState(outState);
//		outState.putSerializable("uservo", Constant.userVO);
//		outState.putStringArrayList("shortcut_list", (ArrayList<String>) Constant.shortcutList);
    }

}
