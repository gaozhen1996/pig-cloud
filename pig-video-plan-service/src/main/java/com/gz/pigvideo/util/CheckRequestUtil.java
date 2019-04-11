package com.gz.pigvideo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author huang
 *
 */
public class CheckRequestUtil {
	
	public static JSONObject checkReqInterface(String reqstr,String interf) throws Exception{
		JSONObject reqData=JSON.parseObject(reqstr);
		String cmd=reqData.getString("cmd");
		String type=reqData.getString("type");
		if(!type.equals("request")||!cmd.equals(interf)){
			throw new Exception("Rest层("+interf+")请求出现异常！");
		}
		JSONObject request=reqData.getJSONObject("request");
		return request;
	}
	
}
