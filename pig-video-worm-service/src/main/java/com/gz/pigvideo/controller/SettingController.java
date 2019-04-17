package com.gz.pigvideo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.gz.pigvideo.service.AutoWormService;

@RestController
@RequestMapping("/web/rest/setting")
public class SettingController {

	@Autowired
	private AutoWormService autoWormService;

	@RequestMapping("/setWormInfo")
	public JSONObject setWormInfo(@RequestParam boolean flag,@RequestParam int num) {
		JSONObject response = new JSONObject();
		try {
			System.out.println(num+" "+flag);
			autoWormService.setAutoFlag(flag);
			if(num>0) {
				autoWormService.setNum(num);
			}
			response.put("code", 2);
		} catch (Exception e) {
			response.put("code", 5);
			response.put("msg", e.getMessage());
		}

		return response;
	}

	@RequestMapping("/getWormInfo")
    public JSONObject getWormInfo() {
        JSONObject response = new JSONObject();
        try {
        	JSONObject data = new JSONObject();
        	data.put("autoFlag", autoWormService.getAutoFlag());
        	data.put("num", autoWormService.getNum());
            response.put("data", data);
        	response.put("code", 2);
		} catch (Exception e) {
			response.put("code", 5);
			response.put("msg", e.getMessage());
		}
        return response;
    }

}