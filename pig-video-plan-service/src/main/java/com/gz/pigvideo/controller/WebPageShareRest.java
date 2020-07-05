package com.gz.pigvideo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.gz.pigvideo.api.CommonResult;
import com.gz.pigvideo.service.WebSocketService;

@RestController
@RequestMapping("/webPageShare")
public class WebPageShareRest {

	@Autowired
	private WebSocketService webSocketService;
	
    @RequestMapping("/send/{msg}")
    public CommonResult<String> send(@PathVariable("msg") String msg) {
    	webSocketService.sendMessageToWebUser("onlineUsers",1,1, msg);
        return CommonResult.success("SUCCESS");
    }
  
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
    	}else {
    		webSocketService.sendMessageToWebUser("sharePage",fromUser,toUser, msgBody);
    	}
    	return CommonResult.success("SUCCESS");
    }
    
}
