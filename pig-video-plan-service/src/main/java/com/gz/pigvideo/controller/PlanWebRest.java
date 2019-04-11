package com.gz.pigvideo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gz.pigvideo.domain.Plan;
import com.gz.pigvideo.service.PlanService;
import com.gz.pigvideo.util.DTOUtil;

@RestController
@RequestMapping("/web/rest/plan")
public class PlanWebRest {

	private static final Logger log = LoggerFactory.getLogger(PlanWebRest.class);
	
	private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private PlanService planService;
	
	@Autowired
	private DTOUtil dtoUtil; 
	
	@RequestMapping("/getVideoInfoByPage")
	public JSONObject getPlansGroupType(@RequestParam String today,@RequestParam int uid) {
		log.info("getPlansGroupType?today="+today+"&uid="+uid);
		JSONObject returnData = new JSONObject();
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(today);
			JSONArray jsonArray = planService.getPlansGroupType(date, uid);
			//填充lastArrLen
			JSONArray lastArrLen = new JSONArray();
			for (Object object : jsonArray) {
				JSONArray temp = (JSONArray) object;
				lastArrLen.add(temp.size());
			}
			returnData.put("code", 2);
			returnData.put("data", jsonArray);
			returnData.put("lastArrLen", lastArrLen);
		} catch (Exception e) {
			log.error(e.getMessage());
			returnData.put("code",5);
			returnData.put("msg",e.getMessage());
		}
		return returnData;
	}
	
	@RequestMapping("/updatePlanType")
	public JSONObject updatePlanType(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject response = new JSONObject();
		try {
			JSONObject request = JSONObject.parseObject(reqstr);
			Plan newPlan = new Plan();
			newPlan.setId(request.getInteger("id"));
			newPlan.setUid(request.getInteger("uid"));
			newPlan.setPlanType(request.getInteger("newType"));
			newPlan.setPlanIndex(request.getString("newIndex"));
			Plan oldPlan = new Plan();
			oldPlan.setPlanType(request.getInteger("oldType"));
			oldPlan.setPlanIndex(request.getString("oldIndex"));
			planService.updatePlanType(newPlan, oldPlan);
			response.put("code", 2);
		} catch (Exception e) {
			log.error(e.getMessage());
			response.put("code",5);
			response.put("msg", e.getMessage());
		}
		return response;
	}
	
	
	@RequestMapping("/updatePlanStatus")
	public JSONObject updatePlanStatus(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject response = new JSONObject();
		try {
			JSONObject request = JSONObject.parseObject(reqstr);
			Plan plan = new Plan();
			plan.setId(request.getInteger("id"));
			boolean status = request.getBooleanValue("status");
			plan.setFinishStatus(status?(long)1:(long)0);
			planService.updateNonEmptyPlanById(plan);
			response.put("code", 2);
		} catch (Exception e) {
			log.error(e.getMessage());
			response.put("code",5);
			response.put("msg", e.getMessage());
		}
		return response;
	}
	
	@RequestMapping("/addPlan")
	public JSONObject addPlan(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject response = new JSONObject();
		try {
			JSONObject request = JSONObject.parseObject(reqstr);
			Plan plan = new Plan();
			plan.setUid(request.getInteger("uid"));
			plan.setPlanType(request.getInteger("planType"));
			plan.setPlanIndex(request.getString("planIndex"));
			plan.setFinishDate(format.parse(request.getString("finishDate")));
			plan.setFinishStatus((long)0);
			plan.setCreateDate(format.parse(request.getString("createDate")));
			plan.setContent(request.getString("content"));
			planService.insertNonEmptyPlan(plan);
			response.put("code", 2);
			response.put("data",dtoUtil.plan2Object(plan));
		} catch (Exception e) {
			log.error(e.getMessage());
			response.put("code",5);
			response.put("msg", e.getMessage());
		}
		return response;
	}
	
	@RequestMapping("/deletePlanById")
	public JSONObject deletePlanById(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject response = new JSONObject();
		try {
			JSONObject request = JSONObject.parseObject(reqstr);
			Plan plan = new Plan();
			plan.setId(request.getInteger("id"));
			plan.setUid(request.getInteger("uid"));
			plan.setPlanType(request.getInteger("planType"));
			plan.setPlanIndex(request.getString("planIndex"));
			planService.deletePlanById(plan);
			response.put("code", 2);	
		} catch (Exception e) {
			log.error(e.getMessage());
			response.put("code",5);
			response.put("msg", e.getMessage());
		}
		return response;
	}
	
	
	@RequestMapping("/updateNonEmptyPlanById")
	public JSONObject updateNonEmptyPlanById(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject response = new JSONObject();
		try {
			JSONObject request = JSONObject.parseObject(reqstr);
			Plan plan = new Plan();
			plan.setId(request.getInteger("id"));
			plan.setContent(request.getString("content"));
			plan.setFinishDate(format.parse(request.getString("finishDate")));
			plan.setCreateDate(format.parse(request.getString("createDate")));
			planService.updateNonEmptyPlanById(plan);
			response.put("code", 2);
		} catch (Exception e) {
			log.error(e.getMessage());
			response.put("code",5);
			response.put("msg", e.getMessage());
		}
		return response;
	}
}
