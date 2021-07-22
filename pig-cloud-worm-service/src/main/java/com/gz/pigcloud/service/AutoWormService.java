package com.gz.pigcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gz.pigcloud.remote.IVideoService;

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

}
