package com.example.anstu.anstupro.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anstu.anstupro.R;

/**
 * Created by zxy on 2015/8/20.
 */
public class SheZhi_List_Adapter extends BaseAdapter {

    private Context myContext;
    private String[] arryaTitle = {"功能图标设置", "登录账号详细信息", "口令管理", "检查更新", "信息推送", "关于", "切换用户"};
    private int[] arrayUrl = {R.mipmap.main_icon_2};

    public SheZhi_List_Adapter(Context context) {
        this.myContext = context;
    }

    private static class ViewHolder {
        ImageView IconimageView;
        TextView titleTextView;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return arryaTitle != null ? arryaTitle.length : 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(myContext).inflate(R.layout.shezhi_listview_item_acitivity, null);
            viewHolder = new ViewHolder();
            viewHolder.IconimageView = (ImageView) convertView.findViewById(R.id.image_item_icon);
            viewHolder.titleTextView = (TextView) convertView.findViewById(R.id.txt_title);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String title = arryaTitle[position];
        int src=arrayUrl[0];
        viewHolder.titleTextView.setText(title);
        viewHolder.IconimageView.setImageResource(src);
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
