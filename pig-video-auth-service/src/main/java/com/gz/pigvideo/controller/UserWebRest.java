package com.gz.pigvideo.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.gz.pigvideo.common.JWTUtil;
import com.gz.pigvideo.domain.User;
import com.gz.pigvideo.service.UserService;

@RestController
@RequestMapping("/userWebRest/")
public class UserWebRest {

	private static final Logger log = LoggerFactory.getLogger(UserWebRest.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * 用户登录
	 * @param reqstr
	 * @return
	 */
	@RequestMapping("login")
	public JSONObject login(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject response=new JSONObject();
		try {
			JSONObject request=JSONObject.parseObject(reqstr);
			String username=request.getString("username");
			String password=request.getString("password");
			User user = userService.getUserByAccount(username);
			if(user.getPassword().equals(password)) {
				JSONObject userObj = new JSONObject();
				userObj.put("account", user.getAccount());
				userObj.put("name", user.getName());
				userObj.put("id", user.getUserId());
				userObj.put("role", user.getRole().getRoleDetail());
				response.put("data", userObj);
				response.put("token", JWTUtil.sign(username, password));
				response.put("code", 2);
			}else {
				response.put("msg","用户名或密码错误");
				response.put("code", 5);
			}
		}catch(Exception e){
			log.error(e.getMessage());
			response.put("msg","没有注册");
			response.put("code", 5);
		}
		return response;
	}
	
	
	@RequestMapping("getMenuByAccount")
	public String getMenuByAccount(@RequestBody String reqstr){
		JSONObject response=new JSONObject();
		try {
			Subject currentUser = SecurityUtils.getSubject();
			JSONObject request=JSONObject.parseObject(reqstr);
			if (currentUser.isAuthenticated()) {
				String username=request.getString("username");
				User user = userService.getUserByAccount(username);
				if(user!=null) {
					response.put("data", user.getRole().getMenu());
					response.put("code", 2);
				}else {
					response.put("code", 4);
				}
			}else {
				response.put("code", 4);
			}
		}catch (Exception e) {
			response.put("code", 5);
			response.put("msg", e.getMessage());
		}
		return response.toJSONString();
	}

	
}
