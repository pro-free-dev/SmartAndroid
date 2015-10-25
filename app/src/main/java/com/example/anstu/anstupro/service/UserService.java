package com.example.anstu.anstupro.service;


import android.util.Log;

import com.example.anstu.anstupro.entity.ApiResultVO;
import com.example.anstu.anstupro.entity.BlockVO;
import com.example.anstu.anstupro.entity.UserVO;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserService.java
 * @Description:用户服务类
 * @Author:
 * @CreateDate:
 */
public class UserService {

	public static final String SPACENAME_USER_SERVICE = "values/";
	public static final String METHODNAME_LOGIN = "processlist";
	
	private Map<String, String> methodParamMap = null;
	private ApiResultVO resultVO = null;
	private DBHelper dbHelper = null;
	private Utility utility = null;
	private String msg = "";
	private boolean success = false;
	
	public UserService() {
		dbHelper = new DBHelper();
		resultVO = new ApiResultVO();
		utility = new Utility();
	}
	
	/**
	 * @MethodName: login
	 * @Description:登录
	 * @return:接口返回结果对象
	 * @Author:
	 * @CreateDate:
	 */
	public ApiResultVO login(String username, String userpwd) {
		methodParamMap = new HashMap<String, String>();
        methodParamMap.put("name", username);
		methodParamMap.put("pwd", userpwd);
		
		JSONObject jsonObject = null;
		UserVO userVO = null;
		try {
            Log.i("zxy", "login action=" + SPACENAME_USER_SERVICE+","+METHODNAME_LOGIN+","+methodParamMap);
			jsonObject = dbHelper.getJsonObjectByArray(SPACENAME_USER_SERVICE, METHODNAME_LOGIN, methodParamMap);
			if (jsonObject != null) {
				msg = utility.getJsonStringResult(jsonObject, "msg");
				success=true;
				success = utility.getJsonBooleanResult(jsonObject, "success");
				if (success) {
					JSONObject jsonObject2 = utility.getJsonObjectResult(jsonObject, "content");
					if (jsonObject2 != null) {
						userVO = new UserVO();
						userVO.setUserId(utility.getJsonStringResult(jsonObject2, "userId"));
						userVO.setDefaultNodeName(utility.getJsonStringResult(jsonObject2, "defaultNodeName"));
						userVO.setDefaultNodeId(utility.getJsonStringResult(jsonObject2, "defaultNodeId"));
						JSONArray jsonArray = utility.getJsonArrayResult(jsonObject2, "magneticBlocks");
						if (jsonArray != null && jsonArray.length() > 0) {
							userVO.setBlockList(getBlockListByJsonArray(jsonArray));
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resultVO.setMsg(msg);
		resultVO.setSuccess(success);
		resultVO.setContent(userVO);
		return resultVO;
	}
	/**
	 * @MethodName:	getBlockListByJsonArray
	 * @Description:
	 * @Author:
	 * @CreateDate:
	 */
	private List<BlockVO> getBlockListByJsonArray(JSONArray _jsonArray) {
		List<BlockVO> blockList = new ArrayList<BlockVO>();
		BlockVO blockVO = null;
		JSONObject jsonObject = null;
		for (int i = 0; i < _jsonArray.length(); i++) {
			jsonObject = (JSONObject) _jsonArray.opt(i);
			blockVO = new BlockVO();
			blockVO.setModelId(utility.getJsonStringResult(jsonObject, "modelId"));
			blockVO.setPageId(utility.getJsonStringResult(jsonObject, "pageId"));
			blockVO.setName(utility.getJsonStringResult(jsonObject, "name"));
			blockList.add(blockVO);
		}
		return blockList;
	}	
}
