package com.gz.pigvideo.controller;

import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gz.pigvideo.api.CommonResult;
import com.gz.pigvideo.api.ResultCode;
import com.gz.pigvideo.common.HTTPTool;
import com.gz.pigvideo.common.JWTUtil;
import com.gz.pigvideo.domain.Role;
import com.gz.pigvideo.domain.User;
import com.gz.pigvideo.exceptions.PasswordErrorException;
import com.gz.pigvideo.exceptions.UserNotExistsException;
import com.gz.pigvideo.service.UserService;

@RestController
@RequestMapping("/userWebRest/")
public class UserWebRest {

	private static final Logger log = LoggerFactory.getLogger(UserWebRest.class);

	@Autowired
	private UserService userService;

	/**
	 * 用户登录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("login")
	public CommonResult<JSONObject> login(@RequestBody JSONObject request) {
		// 返回值
		JSONObject data = new JSONObject();
		
		String username = request.getString("username");
		String password = request.getString("password");
		User user = userService.getUserByAccount(username);
		if(user==null) {
			throw new UserNotExistsException();
		}
		if (user.getPassword().equals(password)) {
			// 修改登录时间
			User para = new User();
			para.setUserId(user.getUserId());
			para.setLastLoginDate(new Date());
			userService.updateNonEmptyUserById(para);
			data.put("account", user.getAccount());
			data.put("name", user.getName());
			data.put("sex", user.getSex());
			data.put("id", user.getUserId());
			data.put("role", user.getRole().getRoleDetail());
			data.put("logo", user.getPhoto());
			data.put("token", JWTUtil.sign(username, password));
		}else {
			throw new PasswordErrorException();
		}
		return CommonResult.success(data);
	}

	@RequestMapping("getMenuByAccount")
	public CommonResult<String> getMenuByAccount(@RequestBody JSONObject request) {
		User user = userService.getUserByAccount(request.getString("username"));
		if(user==null) {
			throw new UserNotExistsException();
		}
		return CommonResult.success(user.getRole().getMenu());
	}

	@RequestMapping("listAllRole")
	public CommonResult<JSONArray> listAllRole() {
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser.isPermitted("role:select")) {
			return CommonResult.success(userService.listAllRole());
		} else {
			return CommonResult.failed(ResultCode.FORBIDDEN); 
		}
	}

	@RequestMapping("updateRoleById")
	public CommonResult<Integer> updateRoleById(@RequestBody String reqstr) {
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser.isPermitted("role:udpate")) {
			JSONObject request = JSONObject.parseObject(reqstr);
			JSONArray arr = request.getJSONArray("permission");
			StringBuffer permissionsb = new StringBuffer();
			for (Object object : arr) {
				permissionsb.append(object + ",");
			}
			Role role = new Role();
			role.setRoleId(request.getLong("roleId"));
			role.setMenu(request.getString("menu"));
			role.setPermission(permissionsb.toString());
			int effect = userService.updateNonEmptyRoleById(role);
			if (effect == 1) {
				return CommonResult.success();
			} else {
				return CommonResult.failed(ResultCode.FAILED);
			}
		} else {
			return CommonResult.failed(ResultCode.FORBIDDEN);
		}
	}

	@RequestMapping("updateUserById")
	public CommonResult<Integer> updateUserById(@RequestBody JSONObject request) throws Exception {
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser.isPermitted("user:udpate")) {
			User user = new User();
			long userId = request.getLong("userId");
			user.setUserId(userId);
			user.setSex(request.getInteger("sex"));
			user.setName(request.getString("name"));
			String logo = request.getString("logo");
			// 存储logo
			if (!logo.contains("http") && !logo.startsWith("img/")) {
				// 去除无用部分
				String[] tlogo = logo.split(",");
				if (tlogo.length > 1) {
					logo = tlogo[1];
				} else {
					throw new Exception("图片格式不支持");
				}
				JSONObject para = new JSONObject();
				para.put("base64str", logo);
				para.put("goalFileName", userId + "-" + System.currentTimeMillis() + ".png");
				JSONObject temp = HTTPTool.post(para, "http://47.94.131.201:10000/upload/saveBase64Img");
				if (temp == null || temp.getIntValue("code") != 2) {
					throw new Exception("图片存储失败");
				}
				logo = temp.getString("data");
				user.setPhoto(logo);
			}
			int effect = userService.updateNonEmptyUserById(user);
			if (effect == 1) {
				return CommonResult.success();
			} else {
				return CommonResult.failed(ResultCode.FORBIDDEN);
			}
		} else {
			return CommonResult.failed(ResultCode.FORBIDDEN);
		}
	}

	@RequestMapping("updatePasswdById")
	public CommonResult<Integer> updatePasswdById(@RequestBody User para) {
		return CommonResult.success(userService.updateNonEmptyUserById(para));
	}
	
	@RequestMapping("currentInfo")
	public CommonResult<Integer> currentInfo(@RequestBody JSONObject request) {
		log.info("当前用户信息开始");
		log.info("account:"+request.getString("account"));
		log.info("当前用户信息结束");
		return CommonResult.success();
	}
	
	
}
