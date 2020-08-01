package com.gz.pigvideo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class TimedJobService {
	
	@Autowired
	private WebSocketService webSocketService;  
	
	/**
	 * 
	* @Description: 该方法作用是移除不在线的用户，通过心跳来检测
	* 主要步骤：
	* 1.删除不在线的用户
	* 2.将在线的用户推送给所有的用户
	* @param  参数说明
	* @return void    返回类型
	* @author gaozhen
	 */
	@Scheduled(fixedDelay = 1000*50)
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
		//给所有在线的用户刷新在线用户列表
		webSocketService.sendOnlineUsers((long)-99);
 	}
}
