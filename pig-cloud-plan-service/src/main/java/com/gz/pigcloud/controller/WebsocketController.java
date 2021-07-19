package com.gz.pigcloud.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.gz.pigcloud.api.CommonResult;
import com.gz.pigcloud.domain.Readlater;
import com.gz.pigcloud.service.ReadlaterService;
import com.gz.pigcloud.service.WebSocketService;

@RestController
public class WebsocketController {

	@Autowired
	private WebSocketService webSocketService;
	
	@Autowired
	private ReadlaterService readlaterService;
  
    @MessageMapping("/accept")
    public CommonResult<String> accept(JSONObject msg) {
    	long toUser = msg.getLongValue("toUser");
    	long fromUser = msg.getLongValue("fromUser");
    	String msgBody = msg.getString("msg");
    	if(toUser==-1 && "ping".equalsIgnoreCase(msgBody)) {
    		//1.心跳
    		webSocketService.updateheartTime(fromUser);
    	}else if ( toUser == -1 && "openSession".equalsIgnoreCase(msgBody)){
    		//2.上线
    		String name = msg.getString("fromUserName");
    		String account = msg.getString("fromUserAccount");
    		webSocketService.addOnlineUser(fromUser, account, name);
    		webSocketService.sendMessageToWebUser("onlineUsers",fromUser,fromUser, msgBody);
    	}else if(toUser == -1 && "readlater".equalsIgnoreCase(msgBody)){
    		//3.稍后阅读
    		String url = msg.getString("url");
    		String title = msg.getString("title");
    		Readlater readlater = new Readlater();
    		readlater.setAddDate(new Date());
    		readlater.setUid((int)fromUser);
    		readlater.setTitle(title);
    		readlater.setUrl(url);
    		readlaterService.insertReadlater(readlater);
    	}else {
    		//4.分享网页
    		webSocketService.sendMessageToWebUser("sharePage",fromUser,toUser, msgBody);
    	}
    	return CommonResult.success("SUCCESS");
    }
    
}
