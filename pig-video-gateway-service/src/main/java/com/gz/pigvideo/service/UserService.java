package com.gz.pigvideo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
