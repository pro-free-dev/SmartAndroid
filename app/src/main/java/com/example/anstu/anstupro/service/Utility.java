package com.example.anstu.anstupro.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Utility {
	
	private static final String SPACE = "";

	/**
	 * @MethodName:	getJsonStringResult
	 * @Description:获取jsonString
	 * @Author:		yangxd
	 * @CreateDate:	2012/06/01
	 */
	protected int getJsonIntegerResult(JSONObject jsonObject, String key) {
		int jsonIntResult = -1;
		try {
			jsonIntResult = jsonObject.has(key) ? jsonObject.getInt(key) : -1;
		} catch (JSONException e) {
			e.printStackTrace();
			jsonIntResult = -1;
		} finally {
			
		}
		return jsonIntResult;
	}
	/**
	 * @MethodName:	getJsonStringResult
	 * @Description:获取jsonString
	 * @Author:		yangxd
	 * @CreateDate:	2012/06/01
	 */
	protected String getJsonStringResult(JSONObject jsonObject, String key) {
		String jsonStringResult = SPACE;
		try {
			jsonStringResult = jsonObject.has(key) ? jsonObject.getString(key) : SPACE;
		} catch (JSONException e) {
			e.printStackTrace();
			jsonStringResult = SPACE;
		} finally {
			
		}
		return jsonStringResult;
	}
	/**
	 * @MethodName:	getJsonDoubleResult
	 * @Description:获取jsonDouble
	 * @Author:		yangxd
	 * @CreateDate:	2012/06/01
	 */
	protected double getJsonDoubleResult(JSONObject jsonObject, String key) {
		double jsonDoubleResult = 0;
		try {
			jsonDoubleResult = jsonObject.has(key) ? jsonObject.getDouble(key) : 0;
		} catch (JSONException e) {
			e.printStackTrace();
			jsonDoubleResult = 0;
		} finally {
			
		}
		return jsonDoubleResult;
	}
	/**
	 * @MethodName:	getJsonStringListResult
	 * @Description:获取jsonDouble
	 * @Author:		yangxd
	 * @CreateDate:	2012/06/01
	 */
	protected List<String> getJsonStringListResult(JSONObject jsonObject, String key) {
		List<String> list = null;
		try {
			JSONArray jsonArray = jsonObject.has(key) ? jsonObject.getJSONArray(key) : null;
			if (jsonArray != null && jsonArray.length() > 0) {
				list = new ArrayList<String>();
				for (int i = 0; i < jsonArray.length(); i++) {
					list.add(jsonArray.getString(i));
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
			 list = null;
		} finally {
			
		}
		return list;
	}
	/**
	 * @MethodName:	getJsonArrayResult
	 * @Description:获取jsonArray
	 * @Author:		yangxd
	 * @CreateDate:	2012/06/01
	 */
	protected JSONArray getJsonArrayResult(JSONObject jsonObject, String key) {
		JSONArray jsonArray = null;
		try {
			jsonArray = jsonObject.has(key) ? jsonObject.getJSONArray(key) : null;
		} catch (JSONException e) {
			e.printStackTrace();
			jsonArray = null;
		} finally {
			
		}
		return jsonArray;
	}
	/**
	 * @MethodName:	getJsonObjectResult
	 * @Description:获取jsonObject
	 * @Author:		yangxd
	 * @CreateDate:	2012/06/01
	 */
	protected JSONObject getJsonObjectResult(JSONObject jsonObject, String key) {
		JSONObject jsonResult = null;
		try {
			jsonResult = jsonObject.has(key) ? jsonObject.getJSONObject(key) : null;
		} catch (JSONException e) {
			e.printStackTrace();
			jsonResult = null;
		} finally {
			
		}
		return jsonResult;
	}
	/**
	 * @MethodName:	getJsonBooleanResult
	 * @Description:获取jsonBoolean
	 * @Author:		yangxd
	 * @CreateDate:	2013/01/10
	 */
	protected boolean getJsonBooleanResult(JSONObject jsonObject, String key) {
		boolean jsonBooleanResult = false;
		try {
			jsonBooleanResult = jsonObject.has(key) ? jsonObject.getBoolean(key) : false;
		} catch (JSONException e) {
			e.printStackTrace();
			jsonBooleanResult = false;
		} finally {
			
		}
		return jsonBooleanResult;
	}
}
