package com.gz.pigvideo.service;

import com.alibaba.fastjson.JSONArray;
import com.gz.pigvideo.remote.IVideoService;
import com.gz.pigvideo.util.WormUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AutoWormService {
    private boolean autoFlag = false;

    @Autowired
    IVideoService videoService;

    public void setAutoFlag(boolean autoFlag) {
        this.autoFlag = autoFlag;
    }

    @Scheduled(fixedDelay = 1000*60*10)
    public void autoWormTask(){
        if (autoFlag){
            String url = "https://kuaiyinshi.com/#search-form";
            JSONArray urls = WormUtil.getCountVideoURL(url,10);
            videoService.saveVideoURL(urls.toJSONString());
        }
    }
}
