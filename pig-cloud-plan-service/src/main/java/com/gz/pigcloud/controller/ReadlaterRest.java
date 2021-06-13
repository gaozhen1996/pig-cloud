package com.gz.pigcloud.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.gz.pigcloud.api.CommonResult;
import com.gz.pigcloud.domain.Readlater;
import com.gz.pigcloud.service.ReadlaterService;

@RestController
@RequestMapping("/web/rest/readlater")
public class ReadlaterRest {
	
	@Autowired
	private ReadlaterService readlaterService;

	@RequestMapping("/listReadlaterByUidAndPaging")
	public CommonResult<JSONObject> listReadlaterByUidAndPaging(@RequestParam int uid,
									   @RequestParam int startRow,
									   @RequestParam int rowSize) {
		JSONObject data = readlaterService.listReadlaterByUidAndPaging(uid, startRow, rowSize);
		return CommonResult.success(data);
	}	
	
	@RequestMapping("/addReadlater")
	public CommonResult<JSONObject> addReadlater(@RequestBody Readlater para) {
		para.setAddDate(new Date());
		return CommonResult.success(readlaterService.insertReadlater(para));
	}

	@RequestMapping("/deleteNoteById")
	public CommonResult<Integer> deleteNoteById(@RequestBody Readlater para) {
		return CommonResult.success(readlaterService.deleteReadLaterById(para.getId()));
	}		
	
}
