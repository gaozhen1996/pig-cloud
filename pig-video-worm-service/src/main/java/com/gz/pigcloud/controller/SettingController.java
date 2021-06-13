package com.gz.pigcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.gz.pigcloud.remote.IAuthService;
import com.gz.pigcloud.service.AutoWormService;

@RestController
@RequestMapping("/web/rest/setting")
public class SettingController {

	@Autowired
	private AutoWormService autoWormService;

    @Autowired
    private IAuthService authService;
	
	@RequestMapping("/setWormInfo")
	public JSONObject setWormInfo(@RequestParam boolean flag,
							      @RequestParam int num,
							      @RequestParam String url) {
		JSONObject response = new JSONObject();
		try {
			if(authService.isPermitted("wormInfo:update")) {
				autoWormService.setAutoFlag(flag);
				autoWormService.setUrl(url);
				if(num>0) {
					autoWormService.setNum(num);
				}
				response.put("code", 2);
			}else {
				response.put("code", 4);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.put("code", 5);
			response.put("msg", e.getMessage());
		}

		return response;
	}

	@RequestMapping("/getWormInfo")
    public JSONObject getWormInfo() {
        JSONObject response = new JSONObject();
        try {
        	if(authService.isPermitted("wormInfo:select")) {
            	JSONObject data = new JSONObject();
            	data.put("url",autoWormService.getUrl());
            	data.put("autoFlag", autoWormService.getAutoFlag());
            	data.put("num", autoWormService.getNum());
                response.put("data", data);
            	response.put("code", 2);
        	}else {
        		response.put("code", 4);
        	}
		} catch (Exception e) {
			response.put("code", 5);
			response.put("msg", e.getMessage());
		}
        return response;
    }

}