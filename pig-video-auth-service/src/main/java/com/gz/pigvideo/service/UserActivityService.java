package com.gz.pigvideo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.pigvideo.domain.UserActivity;
import com.gz.pigvideo.repository.UserActivityDao;

@Service
public class UserActivityService {

	@Autowired
	private UserActivityDao userActivityDao;
	
	public int insertUserActivity(UserActivity userActivity){
		userActivity.setCreateTime(System.currentTimeMillis());
		return userActivityDao.insertNonEmptyUserActivity(userActivity);
	}
	
}
