package com.example.anstu.anstupro.ui;

import android.widget.ListView;

/**
 * Created by zxy on 2015/8/22.
 */
public class MyListView extends ListView {
    public MyListView(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}

