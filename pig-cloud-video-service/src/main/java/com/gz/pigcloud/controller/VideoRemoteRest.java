package com.gz.pigcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gz.pigcloud.service.VideoInfoService;

//@RabbitListener(queues = "saveVideoURL")
@RestController
public class VideoRemoteRest {

    private static final Logger log = LoggerFactory.getLogger(VideoRemoteRest.class);

    @Autowired
    private VideoInfoService videoInfoService;

//    @RabbitHandler
    public void process(JSONArray urls) {
        try{
            for (Object obj:urls) {
                JSONObject jsonobj = (JSONObject) obj;
                System.out.println(jsonobj);
                if (jsonobj!=null){
                    String url = jsonobj.getString("videoUrl");
                    String title = jsonobj.getString("videoTitle");
                    int effect= videoInfoService.insertNonEmptyVideoInfo(url,title);
                    if (effect==1){
                        log.info(title+"存储完成");
                    }else{
                        log.error(title+"存储失败");
                    }
                }
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
    
    
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