package com.gz.pigvideo.controller;

import com.alibaba.fastjson.JSONObject;
import com.gz.pigvideo.service.AutoWormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettingController {

    @Autowired
    private AutoWormService autoWormService;

    @RequestMapping("/autWormSetting")
    public String autWormSetting(@RequestParam String flag) {
        JSONObject obj = new JSONObject();
        if (flag.equals("open")){
            autoWormService.setAutoFlag(true);
            obj.put("res",true);
        }else if (flag.equals("close")){
            autoWormService.setAutoFlag(false);
            obj.put("res",true);
        }else {
            obj.put("res",false);
            obj.put("msg","参数异常");
        }
        return obj.toJSONString();
    }
}