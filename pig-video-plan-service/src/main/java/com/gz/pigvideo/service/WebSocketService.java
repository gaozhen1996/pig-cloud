package com.gz.pigvideo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service
public class WebSocketService {
	
	@Autowired
	private SimpMessagingTemplate template;

	private Map<Long, User> onlineUsers = new ConcurrentHashMap<Long, WebSocketService.User>();
	
	public void sendMessageToWebUser(String type,long fromUserId,long toUserId,String message) {
		switch (type) {
		case "sharePage":
			this.sendSharePage(fromUserId, toUserId, message);
			break;
		case "onlineUsers":
			this.sendOnlineUsers(toUserId);
			break;
		default:
			break;
		}
	}
	
	/**
	 * 
	* @Description: 添加在线的用户
	* @param  参数说明
	* @return void    返回类型
	* @author gaozhen
	 */
	public boolean  addOnlineUser(long id,String account,String name) {
		boolean res = false;
		User user = new User(id, account, name,System.currentTimeMillis());
		this.onlineUsers.put(id, user);
		res = true;
		return res;
	}
	/**
	 * 刪除在线的用户
	 * @param id
	 * @return
	 */
	public boolean delOnlineUser(long id) {
		boolean res =false;
		this.onlineUsers.remove(id);
		res = true;
		return res;
	}

	/**
	 * 
	 * @return
	 */
	public Map<Long, Long> getAllOnlineLastTime() {
		Map<Long, Long> userid_lastTime = new HashMap<Long, Long>();
		for (Long userid : this.onlineUsers.keySet()) {
			User user = this.onlineUsers.get(userid);
			userid_lastTime.put(userid, user.lastHeartTime);
		}
		return userid_lastTime;
	}

	public JSONArray listAllOnlineUsers(){		
		JSONArray onlineUsers = new JSONArray();
		for (long userId : this.onlineUsers.keySet()) {
			User user = this.onlineUsers.get(userId);
			JSONObject jsonUser = new JSONObject();
			jsonUser.put("name", user.name+"("+user.account+")");
			jsonUser.put("id",user.id);
			onlineUsers.add(jsonUser);
		}
		return onlineUsers;
	}
	
	/**
	 * 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param  fromUser id即可
	* @return void    返回类型
	* @author gaozhen
	 */
	public void updateheartTime(long fromUser) {
		User user = onlineUsers.get(fromUser);
		//更新心跳时间
		user.lastHeartTime = System.currentTimeMillis();
	}
	
	private void sendSharePage(long fromUserId,long toUserId,String message) {
		String destination = "/topic/" + toUserId;
		User fromUser = onlineUsers.get(fromUserId);
		//不在线
		if(fromUser == null) {
			return;
		}
		JSONObject sendMsgBody = new JSONObject();
		sendMsgBody.put("type","sharePage");
		sendMsgBody.put("fromUser",fromUser.name+"("+fromUser.account+")");
		sendMsgBody.put("url",message);
		template.convertAndSend(destination, sendMsgBody);		
	}

	public void sendOnlineUsers(long toUserId) {
		String destination = "/topic/" + toUserId;
		JSONObject sendMsgBody = new JSONObject();
		sendMsgBody.put("type","onlineUsers");
		sendMsgBody.put("data",this.listAllOnlineUsers());
		template.convertAndSend(destination, sendMsgBody);		
	}
	
	private class User{
		long id;
		String account;
		String name;
		long lastHeartTime;
		public User(long id, String account, String name,long lastHeartTime) {
			super();
			this.id = id;
			this.account = account;
			this.name = name;
			this.lastHeartTime = lastHeartTime;
		}
		@Override
		public String toString() {
			return "User [id=" + id + ", account=" + account + ", name=" + name + ", lastHeartTime=" + lastHeartTime
					+ "]";
		}
	}	
}
