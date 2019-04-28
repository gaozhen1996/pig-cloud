package com.gz.pigvideo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.gz.pigvideo.remote.IVideoService;
import com.gz.pigvideo.util.WormUtil;

@Component
public class AutoWormService {
    private boolean autoFlag = false;

    private int num = 3;
    
    private String url = "https://kuaiyinshi.com/#search-form";
    
    private static final Logger log = LoggerFactory.getLogger(AutoWormService.class);
    
    @Autowired
    IVideoService videoService;

    public void setAutoFlag(boolean autoFlag) {
        this.autoFlag = autoFlag;
    }
    
    public boolean getAutoFlag() {
    	return this.autoFlag;
    }
    
    public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Scheduled(fixedDelay = 1000*60*10)
    public void autoWormTask(){
        if (autoFlag){
        	log.info("---------------自动爬取开始-------------------");
            JSONArray urls = WormUtil.getCountVideoURL(url,num);
            log.info(urls.toJSONString());
            videoService.saveVideoURL(urls.toJSONString());
        }
    }
}
