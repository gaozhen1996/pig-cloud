package com.gz.pigvideo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gz.pigvideo.api.CommonResult;
import com.gz.pigvideo.common.HTTPTool;

@RestController
@RequestMapping("/ProxyBaiduWebRest/")
public class ProxyBaiduWebRest {

	private static final Logger log = LoggerFactory.getLogger(ProxyBaiduWebRest.class);

	/**
	 * 获取百度自动提示关键字
	 */
	@RequestMapping("loadWd")
	public CommonResult<JSONArray> loadWd(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONArray arr;
		JSONObject request = JSONObject.parseObject(reqstr);
		String wd = request.getString("wd");
		JSONObject res = HTTPTool.get("https://www.baidu.com/sugrec?prod=pc&wd="+wd);
		arr = res.getJSONArray("g");
		if(arr==null) {
			arr = new JSONArray();
		}
		return CommonResult.success(arr);
	}

}
