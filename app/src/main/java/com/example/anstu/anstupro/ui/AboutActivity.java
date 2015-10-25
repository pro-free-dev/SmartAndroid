package com.example.anstu.anstupro.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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


public class AboutActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.about_activity);
            Button titlebar_previous_btn = (Button) findViewById(R.id.titlebar_previous_btn);
            titlebar_previous_btn.setText("< 我的消息");
            titlebar_previous_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        } catch (Exception ex) {
            System.out.println("zxy---- 错误消息: " + ex.getMessage());
        }
    }
}
