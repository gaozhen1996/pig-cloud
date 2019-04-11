package com.gz.pigvideo.controller;

import com.gz.pigvideo.service.VideoInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@RestController
public class VideoRemoteRest {

    private static final Logger log = LoggerFactory.getLogger(VideoRemoteRest.class);

    @Autowired
    private VideoInfoService videoInfoService;

    @RequestMapping("/saveVideoURL")
    public String saveVideoURL(@RequestParam(value = "urls") String urls){
        JSONArray jsonArray = JSONObject.parseArray(urls);
        JSONObject return_data = new JSONObject();
        int total = 0;
        try{
            for (Object obj:jsonArray) {
                JSONObject jsonobj = (JSONObject) obj;
                System.out.println(jsonobj);
                if (jsonobj!=null){
                    String url = jsonobj.getString("videoUrl");
                    String title = jsonobj.getString("videoTitle");
                    int effect= videoInfoService.insertNonEmptyVideoInfo(url,title);
                    if (effect==1){
                        total++;
                        log.info(title+"存储完成");
                    }else{
                        log.error(title+"存储失败");
                    }
                }
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }

        return_data.put("res",true);
        return_data.put("total",total);
        return return_data.toJSONString();
    }

}