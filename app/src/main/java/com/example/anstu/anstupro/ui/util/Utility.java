package com.example.anstu.anstupro.ui.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.anstu.anstupro.comm.Constant;

/**
 * Created by zxy on 2015/10/10.
 */
public class Utility {
    /**
     * @MethodName:getCurrentNetType
     * @Description: »ñÈ¡ÍøÂç×´Ì¬
     * @AuthorName:zxy
     * @CreateDate:2015-10-10
     */
    public static int getCurrentNetType(Context mContext) {
        ConnectivityManager connManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI); // wifi
        NetworkInfo gprs = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE); // gprs
        // ÅÐ¶Ïµ±Ç°ÍøÂç×´Ì¬
        if (wifi != null && wifi.getState() == NetworkInfo.State.CONNECTED) { // wifi
            Log.i("zxy", "Current net type:  WIFI.");
            return Constant.NETWORK_TYPE_WIFI;
        } else if (gprs != null && gprs.getState() == NetworkInfo.State.CONNECTED) { // gprs
            Log.i("zxy", "Current net type:  MOBILE.");
            return Constant.NETWOKR_TYPE_MOBILE;
        } else { // ¶ÏÍø
            Log.e("zxy", "Current net type:  NONE.");
            return Constant.NETWORK_TYPE_NONE;
        }
    }
}
