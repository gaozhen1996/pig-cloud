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
import com.gz.pigvideo.common.HTTPTool;
import com.gz.pigvideo.common.JWTUtil;
import com.gz.pigvideo.domain.Role;
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
	 * 
	 * @param reqstr
	 * @return
	 */
	@RequestMapping("login")
	public JSONObject login(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject response = new JSONObject();
		try {
			JSONObject request = JSONObject.parseObject(reqstr);
			String username = request.getString("username");
			String password = request.getString("password");
			User user = userService.getUserByAccount(username);
			if (user.getPassword().equals(password)) {
				// 修改登录时间
				User para = new User();
				para.setUserId(user.getUserId());
				para.setLastLoginDate(new Date());
				userService.updateNonEmptyUserById(para);
				// 返回值
				JSONObject userObj = new JSONObject();
				userObj.put("account", user.getAccount());
				userObj.put("name", user.getName());
				userObj.put("sex", user.getSex());
				userObj.put("id", user.getUserId());
				userObj.put("role", user.getRole().getRoleDetail());
				userObj.put("logo", user.getPhoto());
				response.put("data", userObj);
				response.put("token", JWTUtil.sign(username, password));
				response.put("code", 2);
			} else {
				response.put("msg", "用户名或密码错误");
				response.put("code", 5);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			response.put("msg", "没有注册");
			response.put("code", 5);
		}
		return response;
	}

	@RequestMapping("getMenuByAccount")
	public String getMenuByAccount(@RequestBody String reqstr) {
		JSONObject response = new JSONObject();
		try {
			JSONObject request = JSONObject.parseObject(reqstr);
			String username = request.getString("username");
			User user = userService.getUserByAccount(username);
			if (user != null) {
				response.put("data", user.getRole().getMenu());
				response.put("code", 2);
			} else {
				response.put("code", 5);
			}
		} catch (Exception e) {
			response.put("code", 5);
			response.put("msg", e.getMessage());
		}
		return response.toJSONString();
	}

	@RequestMapping("listAllRole")
	public JSONObject listAllRole() {
		log.info("listAllRole");
		JSONObject returnData = new JSONObject();
		try {
			Subject currentUser = SecurityUtils.getSubject();
			if (currentUser.isPermitted("role:select")) {
				returnData.put("code", 2);
				returnData.put("data", userService.listAllRole());
			} else {
				returnData.put("code", 4);
				returnData.put("msg", "亲，权限不足哟!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			returnData.put("code", 5);
			returnData.put("msg", e.getMessage());
		}
		return returnData;
	}

	@RequestMapping("updateRoleById")
	public JSONObject updateRoleById(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject response = new JSONObject();
		try {
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
					response.put("code", 2);
				} else {
					response.put("code", 5);
					response.put("msg", "修改角色发生异常");
				}
			} else {
				response.put("msg", "亲，权限不足哟!");
				response.put("code", 4);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			response.put("code", 5);
			response.put("msg", e.getMessage());
		}
		return response;
	}

	@RequestMapping("updateUserById")
	public JSONObject updateUserById(@RequestBody String reqstr) {
		log.info("updateUserById开始");
		JSONObject response = new JSONObject();
		try {
			Subject currentUser = SecurityUtils.getSubject();
			if (currentUser.isPermitted("user:udpate")) {
				JSONObject request = JSONObject.parseObject(reqstr);
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
					response.put("code", 2);
				} else {
					response.put("code", 5);
					response.put("msg", "亲，修改用户错误了，请联系管理员！");
				}
			} else {
				response.put("msg", "亲，权限不足哟!");
				response.put("code", 4);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.put("code", 5);
			response.put("msg", e.getMessage());
		}
		log.info("updateUserById结束");
		return response;
	}

	@RequestMapping("updatePasswdById")
	public JSONObject updatePasswdById(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject response = new JSONObject();
		try {
			JSONObject request = JSONObject.parseObject(reqstr);
			User user = new User();
			long userId = request.getLong("userId");
			String passwd  = request.getString("passwd");
			user.setUserId(userId);
			user.setPassword(passwd);
			int effect = userService.updateNonEmptyUserById(user);
			if (effect == 1) {
				response.put("code", 2);
			} else {
				response.put("code", 5);
				response.put("msg", "亲，修改密码错误了，请联系管理员！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.put("code", 5);
			response.put("msg", e.getMessage());
		}
		return response;
	}
	
	@RequestMapping("currentInfo")
	public JSONObject currentInfo(@RequestBody String reqstr) {
		JSONObject response = new JSONObject();
		try {
			JSONObject request = JSONObject.parseObject(reqstr);
			log.info("当前用户信息开始");
			log.info("account:"+request.getString("account"));
			log.info("当前用户信息结束");
			response.put("code", 2);
		} catch (Exception e) {
			response.put("code", 5);
			response.put("msg", e.getMessage());
		}
		return response;
	}
	
	
}
