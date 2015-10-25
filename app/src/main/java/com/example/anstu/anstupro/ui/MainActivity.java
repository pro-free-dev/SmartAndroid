package com.example.anstu.anstupro.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.anstu.anstupro.R;
import com.example.anstu.anstupro.fragment.FragmentSheZhi;
import com.example.anstu.anstupro.fragment.FragmentTabAdapter;
import com.example.anstu.anstupro.fragment.FragmentTuanDui;
import com.example.anstu.anstupro.fragment.FragmentXiaoXi;
import com.example.anstu.anstupro.fragment.FragmentZhuYe;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {

    //private Fragment contentFragment;
    private RadioGroup myTabRg;
    private TextView titlebar_textview;
    public List<Fragment> fragments = new ArrayList<Fragment>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            //setContentView(R.layout.loading_activity);
            setContentView(R.layout.main_activity);

            //��ʼ��Fragement����
            fragments.add(new FragmentXiaoXi());
            fragments.add(new FragmentTuanDui());
            fragments.add(new FragmentZhuYe());
            fragments.add(new FragmentSheZhi());

            myTabRg = (RadioGroup) findViewById(R.id.tab_menu);

            //注册Fragment
            RegisterFragment();

            //初始
            InitActivity();
        } catch (Exception ex) {
            System.out.println("zxy---- 错误消息: " + ex.getMessage());
        }
    }

    public void InitActivity() {
        SetTitle(0);
    }

    public void SetTitle(int i) {
        String title = "";
        switch (i) {
            case 0:
                title = "我的消息";
                break;
            case 1:
                title = "我的团队";
                break;
            case 2:
                title = "我的主页";
                break;
            case 3:
                title = "我的信息";
                break;
        }
        titlebar_textview = (TextView) findViewById(R.id.titlebar_textview);
        titlebar_textview.setText(title);
    }

    public void RegisterFragment() {
        FragmentTabAdapter tabAdapter = new FragmentTabAdapter(this, fragments, R.id.main_content, myTabRg);
        tabAdapter.setOnRgsExtraCheckedChangedListener(new FragmentTabAdapter.OnRgsExtraCheckedChangedListener() {
            @Override
            public void OnRgsExtraCheckedChanged(RadioGroup radioGroup, int checkedId, int index) {
                System.out.println("zxy---- " + index + " checked!!! ");
                SetTitle(index);
            }
        });
    }
}
