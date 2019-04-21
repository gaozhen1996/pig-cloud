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

    private int num = 3;
    
    private String url = "https://kuaiyinshi.com/#search-form";
    
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
            JSONArray urls = WormUtil.getCountVideoURL(url,num);
            videoService.saveVideoURL(urls.toJSONString());
        }
    }
}
