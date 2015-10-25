package com.example.anstu.anstupro.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.anstu.anstupro.R;
import com.example.anstu.anstupro.comm.Constant;
import com.example.anstu.anstupro.entity.ApiResultVO;
import com.example.anstu.anstupro.entity.UserVO;
import com.example.anstu.anstupro.service.task.UserAsyncTask;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;


@SuppressLint("HandlerLeak")
public class LoginActivity extends BaseActivity implements OnClickListener {

    private EditText username = null;
    private EditText password = null;
    private ImageButton login_btn = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("zxy", "in LoginActivity here");

        /*String json= "[{\"USER_ID\":4.0,\"NAME\":\"李白\",\"SEX\":\"男\",\"BIRTHDAY\":\"2015-10-20T00:00:00\",\"TELEPHONE_WORK1\":\"13254455865\",\"TELEPHONE_WORK2\":\"02154234567\",\"FAX_WORK\":\"02154234523\",\"EMAIL\":\"libai@163.com\",\"MOBILEPHONE\":\"1335245128\",\"QQ\":\"354511568\",\"PARENT_COMPANY_ID\":4.0,\"ADDRESS_HOME\":\"上海市松江区华云路22号\",\"POSTCODE_HOME\":\"200032\",\"TELEPHONE_HOME\":\"2460171\",\"HEAD_PORTRAIT\":\"Chrysanthemum.jpg\",\"LOGIN_ID\":4.0,\"USER_ID1\":4.0,\"PASSWORD\":\"1234\",\"ROLE_ID\":4.0,\"OUT_TIME\":null}]";
        //String json="[{\"USER_ID\":4}]";
        JSONArray jsonObject = null;
        JSONObject jsonObject1=null;
        try {
            jsonObject = new JSONArray(json);
            jsonObject1=(JSONObject)jsonObject.get(0);
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
        }*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        setMyActivity(this);

        username = (EditText) findViewById(R.id.login_edittext_username);
        username.setText(getLoginUserName());
        password = (EditText) findViewById(R.id.login_edittext_password);
        //password.setText(getLoginPassword());
        login_btn = (ImageButton) findViewById(R.id.login_btn);
        login_btn.setOnClickListener(this);
    }

    private void loginAction(String username, String userpwd) {
        showProgress(R.string.dialog_operation_prompt_str, R.string.login_loading_str);
        Log.i("zxy", "login action -->call user async task");
        new UserAsyncTask(username, userpwd, myHandler, R.id.thread_tag_login).execute();
    }

    private int checkInput() {
        if (username.getText().toString().trim().length() < 1) {
            username.requestFocus();
            return R.string.login_edittext_username_empty_str;
        }
        else if (password.getText().toString().trim().length() < 1) {
            password.requestFocus();
            return R.string.login_edittext_password_empty_str;
        }
        /*else if (password.getText().toString().trim().length() > 20
                || password.getText().toString().trim().length() < 6) {
            password.requestFocus();
            return R.string.login_edittext_password_wrong_str;
        }*/
        return 0;
    }

    private Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            //gan
            dismissProgress();
            switch (msg.what) {
                case R.id.thread_tag_login:
                    ApiResultVO resultVO = (ApiResultVO) msg.obj;
                    if (resultVO != null && resultVO.isSuccess()) {
                        Constant.userVO = (UserVO) resultVO.getContent();
                        saveUserLoginInfo(username.getText().toString(), password.getText().toString());
                        if (Constant.userVO != null) {
                            startActivity(new Intent(Constant.ACTIVITY_NAME_HOMEPAGE));
                            finish();
                        } else {
                            showToast("用户名或密码错误......");
                        }

                    } else if (resultVO != null) {
                        showToast(resultVO.getMsg());
                    } else {
                        showToast("现在网络不佳，请稍候再试......");
                    }
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    public void onClick(View view) {
        if (!checkNetIsConnected()) {
            showNetSettingDialog();
        } else {
            switch (view.getId()) {
                case R.id.login_btn:
                    closeKeyBoard();
                    int resultId = checkInput();
                    if (resultId > 0) {
                        showToast(resultId);
                    }
                    else {
                        loginAction(username.getText().toString(), password.getText().toString());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}