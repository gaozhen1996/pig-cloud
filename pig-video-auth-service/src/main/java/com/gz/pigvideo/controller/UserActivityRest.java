package com.gz.pigvideo.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.gz.pigvideo.api.CommonResult;
import com.gz.pigvideo.service.UserActivityService;


/**
 * 
* <p>
* Description:用户活跃度rest层
* <p>
* @author gaozhen
* @date 2020年6月25日
* @Version 1.1
 */
@RestController
@RequestMapping("/userActivityRest/")
public class UserActivityRest {
	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private UserActivityService userActivityService;
	
	@RequestMapping(value="/listNewTabCountByDate",method= RequestMethod.GET)
	public CommonResult<JSONObject> listNewTabCountByDate(@RequestParam String startDate,@RequestParam String endDate) throws ParseException {
		Date dateStartDate = dateFormat.parse(startDate);
		Date dateEndDate = dateFormat.parse(endDate);
		JSONObject json = userActivityService.listNewTabCountByDate(dateStartDate, dateEndDate);
		return CommonResult.success(json);
	}
}
