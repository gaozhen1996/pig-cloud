package com.gz.pigvideo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gz.pigvideo.remote.IVideoService;
import com.gz.pigvideo.util.HTTPClient;


@RestController
public class WormController {

    @Autowired
    IVideoService videoService;

    @RequestMapping("/worm/{count}")
    public String worm(@PathVariable("count") int count) {
        String url = "https://kuaiyinshi.com/api/kuai-shou/recommend/";
        JSONArray urls = new HTTPClient().getVideoFromURL(url);
        String res_data = videoService.saveVideoURL(urls.toJSONString());
        JSONObject res_obj = JSONObject.parseObject(res_data);
        if(res_obj.getBoolean("res") ==true){
            return "成功爬取"+count+"个视频资源\n"+urls.toJSONString();
        }else{
            return "爬去视频失败！";
        }
    }

}