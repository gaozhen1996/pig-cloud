package com.gz.pigvideo.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("/webRest/test/")
public class TestRest {

	private static final Logger log = LoggerFactory.getLogger(TestRest.class);
	
	/**
	 * 用户登录
	 * @param reqstr
	 * @return
	 */
	@RequestMapping("test")
	public JSONObject login() {
		JSONObject response=new JSONObject();
		try {
			Subject currentuser=SecurityUtils.getSubject();
			System.out.println(currentuser.isAuthenticated());
		}catch(Exception e){
			log.error(e.getMessage());
			response.put("msg","密码或用户名错误");
			response.put("code", 5);
		}
		return response;
	}

}
