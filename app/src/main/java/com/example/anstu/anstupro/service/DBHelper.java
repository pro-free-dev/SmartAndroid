package com.example.anstu.anstupro.service;

import android.content.Context;
import android.util.Log;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.*;

/**
 * @ClassName:	DBHelper.java
 * @Description:网络连接服务类
 * @Author:		yangxd
 * @CreateDate:	2012/03/18
 * @Version:	v1.0.0
 *
 */
public class DBHelper {
	
	private HttpClient httpClient;
	private HttpPost httpPost;
	private HttpResponse httpResponse;
	public static Context context = null;
	public static final String API_HOST_URL = "http://61.129.51.174:8089/api/";
	public static String APK_DOWNLOAD_URL = "";
	public static boolean isUpdata = false;
	public static boolean isTimeOut;
	
	/**
	 * @MethodName:	getHttpPost
	 * @Description:获取HttpPost
	 * @Author:		yangxd
	 * @CreateDate:	2012/03/18
	 */
	@SuppressWarnings("finally")
	private HttpPost getHttpPost(String apiPath, List<NameValuePair> paramList) {
		HttpPost httpPost = null;
		try {
			httpPost = new HttpPost(apiPath);
			httpPost.setEntity(new UrlEncodedFormEntity(paramList, HTTP.UTF_8));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			return httpPost;
		}
	}
	/**
	 * @MethodName:	getHttpClient
	 * @Description:获取HttpClient
	 * @Author:		yangxd
	 * @CreateDate:	2012/03/18
	 */
	private HttpClient getHttpClient() {
		if (httpClient == null) {
			HttpParams httpParams = new BasicHttpParams();    	
	    	HttpConnectionParams.setConnectionTimeout(httpParams, 15000);
	    	HttpConnectionParams.setSoTimeout(httpParams, 15000);
	    	httpClient = new DefaultHttpClient(httpParams);
		}
    	return httpClient;
	}
	/**
	 * @MethodName:	getJsonObject
	 * @Description:获取JsonObject对象
	 * @Author:		yangxd
	 * @CreateDate:	2012/03/18
	 */
	@SuppressWarnings("finally")
	public JSONObject getJsonObject(String namespace, String methodName, Map<String, String> methodParamMap) {
		String jsonString = getJsonString(namespace, methodName, methodParamMap);
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(jsonString);
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			return jsonObject;
		}
	}

    public JSONObject getJsonObjectByArray(String namespace, String methodName, Map<String, String> methodParamMap) {
        String jsonString = getJsonString(namespace, methodName, methodParamMap);
        JSONArray jsonArray = null;
        JSONObject jsonObject=null;
        try {
            jsonArray = new JSONArray(jsonString);
            jsonObject=(JSONObject)jsonArray.get(0);
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            return jsonObject;
        }
    }



    /**
	 * @MethodName:	getJsonString
	 * @Description:获取Json返回信息
	 * @Author:		yangxd
	 * @CreateDate:	2012/03/18
	 */
	@SuppressWarnings("finally")
	private String getJsonString(String namespace, String methodName, Map<String, String> methodParamMap) {
		String resultStr = "";
		// 获取�?��接口�?��接地�?
		String apiPath = API_HOST_URL + namespace + methodName;
		Log.d("EEE", "methodName : " + methodName);
		Log.d("EEE", "namespace : " + namespace);
		Log.d("EEE", "apiPath : " + apiPath);
		// 获取Post�??参数列表
		List<NameValuePair> paramList = getParamList(methodParamMap);
//		StringBuilder builder = new StringBuilder();
		try {
			// 获取HttpPost
			httpPost = getHttpPost(apiPath, paramList);
			if (httpPost == null) {
				Log.d("EEE", "httpPost == null");
			}
			// 获取HttpClient
			httpClient = getHttpClient();
			if (httpClient == null) {
				Log.d("EEE", "httpClient == null");
			}
			// 获取HttpResponse
			httpResponse = getHttpResponse(httpClient, httpPost);
			if (httpResponse == null) {
				Log.d("EEE", "httpResponse == null");
				return "";//
			}
//			HttpEntity entity = httpResponse.getEntity();
			
			resultStr = EntityUtils.toString(httpResponse.getEntity());
			Log.d("EEE", "resultStr : " + resultStr);
			
//			if (entity != null) {
//				Log.d("EEE", "entity != null");
//				BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
//				String line = null;
//				while ((line = reader.readLine()) != null) {
//					builder.append(line + "\n");
//					Log.d("EEE", builder.toString());
//				}
//				reader.close();
//			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
//		catch (IOException e) {
//			e.printStackTrace();
//		} 
		finally {			
//			return builder.toString();
			return resultStr;
		}
	}
	/**
	 * @MethodName:	getParamList
	 * @Description:获取Post�??参数列表
	 * @Author:		yangxd
	 * @CreateDate:	2012/03/18
	 */
	private List<NameValuePair> getParamList(Map<String, String> methodParamMap) {
		List<NameValuePair> paramList  = new ArrayList<NameValuePair>();
		// 创建key�?��
		List<String> keyList = new ArrayList<String>();
		// 遍历�?��
		Iterator<String> iterator = methodParamMap.keySet().iterator();
		while (iterator.hasNext()) {
			keyList.add(iterator.next());
		}
		// 按key排�?
		Collections.sort(keyList);
		// Post�??参数字符串
		StringBuilder builder = new StringBuilder();
		// 添�?ost�??参数
		for (int i = 0; i < keyList.size(); i++) {
			paramList.add(new BasicNameValuePair(keyList.get(i), methodParamMap.get(keyList.get(i))));
			// 拼接格�?key=value"
			try {
				builder.append(keyList.get(i) + "=" + URLEncoder.encode(methodParamMap.get(keyList.get(i)), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 非最后项拼接"&"
			if (i < (keyList.size() - 1)) {
				builder.append("&");
			}
		}
		Log.d("EEE", builder.toString());
		return paramList;
	}
	/**
	 * @MethodName:	getHttpResponse
	 * @Description:获取HttpResponse
	 * @Author:		yangxd
	 * @CreateDate:	2011/10/25
	 */
	private HttpResponse getHttpResponse(HttpClient client, HttpPost post) {
		HttpResponse response = null;
		try {			
			response = client.execute(post);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) isTimeOut = false;
			else post.abort();
		} catch (SocketTimeoutException e) {
			isTimeOut = true;
		}catch (Exception e) {
			isTimeOut = true;
		} 
		return response;
	}
	/**
	 * @MethodName:	getTimeOut
	 * @Description:判断是否网络超时
	 * @Author:		yangxd
	 * @CreateDate:	2011/10/25
	 */
	public static boolean checkNetIsTimeOut(){
		return isTimeOut;
	}
	/**
	 * @MethodName:	testNet
	 * @Description:判断是否可以联�?
	 * @Author:		yangxd
	 * @CreateDate:	2011/09/05
	 */
	public static boolean checkNetIsConnected() {
		try {
			for (Enumeration<?> enumeration = NetworkInterface
					.getNetworkInterfaces(); enumeration.hasMoreElements();) {
				NetworkInterface networkInterface = (NetworkInterface) enumeration.nextElement();// 联�?
				for (Enumeration<?> enumeration2 = networkInterface
						.getInetAddresses(); enumeration2.hasMoreElements();) {
					InetAddress inetAddress = (InetAddress) enumeration2
							.nextElement();
					if (!inetAddress.isLoopbackAddress()) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
}
