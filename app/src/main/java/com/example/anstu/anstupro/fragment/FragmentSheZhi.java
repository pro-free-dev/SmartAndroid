package com.example.anstu.anstupro.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.anstu.anstupro.R;
import com.example.anstu.anstupro.adapter.SheZhi_List_Adapter;
import com.example.anstu.anstupro.ui.AboutActivity;


public class FragmentSheZhi extends Fragment {

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        System.out.println("AAAAAAAAAA____onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("AAAAAAAAAA____onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("AAAAAAAAAA____onCreateView");
        View myView = inflater.inflate(R.layout.shezhi_acitivity, container, false);
        try {
            SheZhi_List_Adapter adapter = new SheZhi_List_Adapter(getActivity());
            ListView listview = (ListView) myView.findViewById(R.id.listSheZhi);
            listview.setAdapter(adapter);

            //设置点击事件
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    // TODO Auto-generated method stub
                    if (arg2 == 5) {
                        //FragmentManager fragmentManager =getFragmentManager();
                        try {
                            // 进入关于我们界面
                            Intent intent = new Intent(getActivity(), AboutActivity.class);
                            getActivity().startActivity(intent);
                        } catch (Exception ex) {
                            System.out.println("ZXY_Err" + ex.getMessage());
                        }
                    }
                    System.out.println("ZXY_Click" + arg2);
                }
            });

            System.out.println("ZXY_" + listview);
            return myView;
        } catch (Exception ex) {
            System.out.println("ZXY_" + ex.getMessage());
        }
        return myView;
    }


    @Override
    public void onStart() {
        super.onStart();
        System.out.println("AAAAAAAAAA____onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("AAAAAAAAAA____onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("AAAAAAAAAA____onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("AAAAAAAAAA____onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("AAAAAAAAAA____onDestroy");
    }
}
