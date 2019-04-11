package com.gz.pigvideo.controller;


import com.alibaba.fastjson.JSONObject;
import com.gz.pigvideo.util.CheckRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 接口层
 */
@RestController
@RequestMapping("/web/rest/setting")
public class SettingRest {

	private static final Logger log = LoggerFactory.getLogger(SettingRest.class);

	@Autowired
	com.gz.pigvideo.remote.WormRemote wormRemote;
	
	@RequestMapping("/autWormSetting")
	public JSONObject autWormSetting(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject return_data=new JSONObject();
		JSONObject response=new JSONObject();
		try {
			JSONObject request = CheckRequestUtil.checkReqInterface(reqstr, "autWormSetting");
			boolean flag = request.getBooleanValue("autoFlag");
			if (flag){
				wormRemote.autWormSetting("open");
			}else {
				wormRemote.autWormSetting("close");
			}
			response.put("res", true);
		}catch(Exception e){
			log.error(e.getMessage());
			response.put("res", false);
			response.put("msg",e.getMessage());
		}
		return_data.put("type", "response");
		return_data.put("cmd", "autWormSetting");
		return_data.put("response", response);
		return return_data;
	}

	
}
