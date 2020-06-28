package com.gz.pigvideo.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.gz.pigvideo.domain.NewTabCount;
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
	
	/**
	 * 
	* @Description: 通过开始和结束日志获取用户访问的次数 
	* @param  参数说明
	* @return JSONObject 返回类型 示例数据
	*         newTabDetailCounts[{"strDate":2020-6-25,"account":gz,"count":10},{...},...]
	*         total_x,total_y 根据strDate分组的数据
	* @author gaozhen
	 */
	public JSONObject listNewTabCountByDate(Date startDate,Date endDate) {
		List<NewTabCount> newTabCounts = userActivityDao.
				selectCountByDate(startDate.getTime(), endDate.getTime(),"newTab");
		/**
		 * 根据strDate分组
		 */
		Map<String,Integer> date_count = new TreeMap<String, Integer>();
		for (NewTabCount newTabCount : newTabCounts) {
			Integer count = date_count.get(newTabCount.getStrDate());
			count = count==null?0:count;
			count += newTabCount.getCount();
			date_count.put(newTabCount.getStrDate(), count);
		}
		String[] xData = new String[date_count.size()];
		int[] yData = new int[date_count.size()];
		int i = 0;
		for (String key : date_count.keySet()) {
			xData[i] = key;
			yData[i] = date_count.get(key);
			i++;
		}
		/**
		 * put到返回的json中
		 */
		JSONObject returnData = new JSONObject();
		returnData.put("total_x", xData);
		returnData.put("total_y", yData);
		returnData.put("newTabDetailCounts", newTabCounts);
		return returnData;
	}
	
	
}
