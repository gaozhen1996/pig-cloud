package com.gz.pigvideo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gz.pigvideo.domain.Role;
import com.gz.pigvideo.domain.User;
import com.gz.pigvideo.repository.RoleDao;
import com.gz.pigvideo.repository.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	public User getUserByAccount(String account) {
		User user = null;
		User para = new User();
		para.setAccount(account);
		user = userDao.selectUserByObj(para);
		if(user==null) {
			return null;
		}
		Role role = roleDao.selectRoleById(user.getRoleId());
		user.setRole(role);
		return user;
	}
	
	public JSONArray listAllRole() {
		JSONArray arr = new JSONArray();
		List<Role> roles = roleDao.selectRole(null);
		for (Role role : roles) {
			JSONObject obj = new JSONObject();
			obj.put("roleId", role.getRoleId());
			obj.put("roleName", role.getRoleName());
			obj.put("roleDetail", role.getRoleDetail());
			if(role.getPermission()!=null) {
				obj.put("permission", role.getPermission().split(","));
			}else {
				obj.put("permission", null);
			}
			obj.put("menu",role.getMenu());
			arr.add(obj);
		}
		return arr;
	}
	
	public int updateNonEmptyRoleById(Role role){
		return roleDao.updateNonEmptyRoleById(role);
	}
	
	public int updateNonEmptyUserById(User user){
		return userDao.updateNonEmptyUserById(user);
	}
}
