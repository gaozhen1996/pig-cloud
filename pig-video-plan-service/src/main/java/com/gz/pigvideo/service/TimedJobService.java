package com.gz.pigvideo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class TimedJobService {
	
	@Autowired
	private WebSocketService webSocketService;  
	
	@Scheduled(cron = "0 */1 * * * ? ") // 间隔5秒执行
 	public void removeUnlinkUser() {
		//最小应该发送心跳的时间
		long minHertTime = System.currentTimeMillis()-1000*60;
		Map<Long, Long>  onlineUsers = webSocketService.getAllOnlineLastTime();
		for (Long uid : onlineUsers.keySet()) {
			long hertTime = onlineUsers.get(uid);
			//实际心跳<最小应该发送心跳的时间,认为该客户端已失去连接,需要删除
			if(hertTime<minHertTime) {
				webSocketService.delOnlineUser(uid);
			}
		}
		
 	}
}
