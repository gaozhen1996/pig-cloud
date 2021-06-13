package com.gz.pigcloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gz.pigcloud.common.Assist;
import com.gz.pigcloud.domain.Readlater;
import com.gz.pigcloud.repository.ReadlaterDao;
import com.gz.pigcloud.util.DTOUtil;

@Service
public class ReadlaterService {

	@Autowired
	private ReadlaterDao readlaterDao;

	@Autowired
	private DTOUtil dtoUtil; 
	
	public JSONObject listReadlaterByUidAndPaging(int uid,int startRow,int rowSize) {
		JSONObject res = new JSONObject();
		JSONArray noteArr = new JSONArray();		
		Assist assist = new Assist();
		assist.setRequires(Assist.andEq("uid",uid));
		assist.setRowSize(rowSize);
		assist.setStartRow(startRow);
		List<Readlater> readlaters = readlaterDao.selectReadlater(assist);
		for (Readlater readlater : readlaters) {
			noteArr.add(dtoUtil.readlater2Object(readlater));
		}
		res.put("data",noteArr);
		assist.setStartRow(null);
		assist.setRowSize(null);
		long row = readlaterDao.getReadlaterRowCount(assist);
		res.put("row",row);
		return res;		
	}
	
	public JSONObject insertReadlater(Readlater readlater) {
		JSONObject res = null;
		int effect = readlaterDao.insertNonEmptyReadlater(readlater);
		if(effect==1) {
			res = dtoUtil.readlater2Object(readlater);
		}
		return res;
	}
		
	public int deleteReadLaterById(int id) {
		return readlaterDao.deleteReadlaterById(id);
	}
}
