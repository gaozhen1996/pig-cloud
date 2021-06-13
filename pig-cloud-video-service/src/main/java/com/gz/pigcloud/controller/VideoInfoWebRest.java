package com.gz.pigcloud.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gz.pigcloud.common.Assist;
import com.gz.pigcloud.domain.VideoInfo;
import com.gz.pigcloud.service.VideoInfoService;
import com.gz.pigcloud.util.CheckRequestUtil;
import com.gz.pigcloud.util.DTOUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * videoInfo接口层
 */
@RestController
@RequestMapping("/web/rest/videoInfo")
public class VideoInfoWebRest {

	private static final Logger log = LoggerFactory.getLogger(VideoInfoWebRest.class);

	@Autowired
	private VideoInfoService videoInfoService;
	
	private DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 
	 * @Description: 安卓端调用
	 * @param 参数说明
	 * @return JSONObject 返回类型
	 * @author gaozhen
	 */
	@RequestMapping("/listVideoInfoByPage")
	public JSONObject listVideoInfoByPage(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject return_data = new JSONObject();
		JSONObject response = new JSONObject();
		try {
			JSONObject request = CheckRequestUtil.checkReqInterface(reqstr, "listVideoInfoByPage");
			Assist assist = new Assist();
			int startRow = request.getIntValue("startRow");
			int rowSize = request.getIntValue("rowSize");
			assist.setOrder(Assist.order("create_time", false));
			assist.setStartRow(startRow);
			assist.setRowSize(rowSize);
			JSONArray jsonArray = new JSONArray();
			for (VideoInfo videoInfo : videoInfoService.selectVideoInfo(assist)) {
				jsonArray.add(DTOUtil.userInfo2JSONObject(videoInfo));
			}
			response.put("res", true);
			response.put("dataType", "list");
			response.put("data", jsonArray);
		} catch (Exception e) {
			log.error(e.getMessage());
			response.put("res", false);
			response.put("msg", e.getMessage());
		}
		return_data.put("type", "response");
		return_data.put("cmd", "listVideoInfoByPage");
		return_data.put("response", response);
		return return_data;
	}

	@RequestMapping("/getVideoInfoByPage")
	public String getVideoInfoByPage(@RequestParam int startRow,@RequestParam int rowSize) {
		log.info("getVideoInfoByPag?startRow="+startRow+"&rowSize="+rowSize);
		JSONObject returnData = new JSONObject();
		try {
			Assist assist = new Assist();
			assist.setOrder(Assist.order("create_time", false));
			assist.setStartRow(startRow);
			assist.setRowSize(rowSize);
			//分页获取视频信息
			JSONArray jsonArray = new JSONArray();
			for (VideoInfo videoInfo : videoInfoService.selectVideoInfo(assist)) {
				jsonArray.add(DTOUtil.userInfo2JSONObject(videoInfo));
			}
			returnData.put("code",0);
			returnData.put("msg", "");
			//获取视频总条数
			long count = videoInfoService.getVideoInfoRowCount(null);
			returnData.put("count",count);
			returnData.put("data", jsonArray);
			
		} catch (Exception e) {
			log.error(e.getMessage());
			returnData.put("code",0);
			returnData.put("msg",e.getMessage());
		}
		return returnData.toJSONString();
	}

	@RequestMapping("/selectCountGreaterDate")
	public String selectCountGreaterDate(@RequestParam String date) {
		log.info("selectCountGreaterDate?date="+date);
		JSONObject response = new JSONObject();
		try {
//			JSONArray jsonArray = new JSONArray();
			Date d = format.parse(date);
			List<Integer> counts = videoInfoService.selectCountGreaterDate(d);
			response.put("data", counts);
			response.put("code",2);
		} catch (Exception e) {
			log.error(e.getMessage());
			response.put("code",0);
			response.put("msg",e.getMessage());
		}
		return response.toJSONString();
	}
	
}
