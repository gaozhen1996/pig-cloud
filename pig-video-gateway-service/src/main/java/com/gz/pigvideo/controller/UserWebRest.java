package com.gz.pigvideo.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.gz.pigvideo.domain.User;

@RestController
@RequestMapping("/webRest/user/")
public class UserWebRest {

	private static final Logger log = LoggerFactory.getLogger(UserWebRest.class);
	
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
			Subject currentuser=SecurityUtils.getSubject();
			if(currentuser.isAuthenticated()){
				log.info("current is Authenticated!");
				response.put("code", 2);
			}else{
				String userName=request.getString("username");
				String password=request.getString("password");
				UsernamePasswordToken token=new UsernamePasswordToken(userName, password);
				token.setRememberMe(true);
				currentuser.login(token);
				currentuser.getSession().setTimeout(-1001);
				log.info(userName+" is login!");
				User user = (User) currentuser.getSession().getAttribute("user");
				JSONObject userObj = new JSONObject();
				userObj.put("account", user.getAccount());
				userObj.put("name", user.getName());
				userObj.put("id", user.getUserId());
				userObj.put("role", user.getRole().getRoleDetail());
				response.put("Authorization", currentuser.getSession().getId());
				response.put("data", userObj);
				response.put("code", 2);
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			response.put("msg","密码或用户名错误");
			response.put("code", 5);
		}
		return response;
	}
	
	
	@RequestMapping("logout")
	public String logout(){
		JSONObject return_data=new JSONObject();
		JSONObject response=new JSONObject();
		try {
			Subject currentUser = SecurityUtils.getSubject();
			if (currentUser.isAuthenticated()) {
				currentUser.logout();
			}
			response.put("res", true);
		}catch (Exception e) {
			response.put("res", false);
			response.put("detail", e.getMessage());
		}
		return_data.put("response", response);
		return_data.put("cmd", "logout");
		return_data.put("type", "response");	
		return return_data.toJSONString();
	}

}
