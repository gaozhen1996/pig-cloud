package com.gz.pigvideo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gz.pigvideo.api.CommonResult;
import com.gz.pigvideo.domain.Plan;
import com.gz.pigvideo.service.PlanService;
import com.gz.pigvideo.util.DTOUtil;

@RestController
@RequestMapping("/web/rest/plan")
public class PlanWebRest {
	
	@Autowired
	private PlanService planService;
	
	@Autowired
	private DTOUtil dtoUtil; 
	
	@RequestMapping("/getPlansGroupType")
	public CommonResult<JSONArray> getPlansGroupType(@RequestParam String today,@RequestParam int uid) {
		JSONArray jsonArray = planService.getPlansGroupType(today, uid);
		return CommonResult.success(jsonArray);
	}
	
	@RequestMapping("/updatePlanType")
	public CommonResult<Integer> updatePlanType(@RequestBody JSONObject request) {
		Plan newPlan = new Plan();
		newPlan.setId(request.getInteger("id"));
		newPlan.setUid(request.getInteger("uid"));
		newPlan.setPlanType(request.getInteger("newType"));
		newPlan.setPlanIndex(request.getString("newIndex"));
		Plan oldPlan = new Plan();
		oldPlan.setPlanType(request.getInteger("oldType"));
		oldPlan.setPlanIndex(request.getString("oldIndex"));
		planService.updatePlanType(newPlan, oldPlan);
		return CommonResult.success();
	}
	
	
	@RequestMapping("/updatePlanStatus")
	public CommonResult<Integer> updatePlanStatus(@RequestBody JSONObject request) {
		Plan plan = new Plan();
		plan.setId(request.getInteger("id"));
		boolean status = request.getBooleanValue("status");
		if(status) {
			plan.setFinishStatus((long)1);
			plan.setActualFinishDate(new Date());
		}else{
			plan.setFinishStatus((long)0);
		}
		planService.updateNonEmptyPlanById(plan);
		return CommonResult.success();
	}
	
	@RequestMapping("/addPlan")
	public CommonResult<JSONObject> addPlan(@RequestBody Plan para) {
		planService.insertNonEmptyPlan(para);
		return CommonResult.success(dtoUtil.plan2Object(para));
	}
	
	@RequestMapping("/deletePlanById")
	public CommonResult<Integer> deletePlanById(@RequestBody Plan para) {
		planService.deletePlanById(para);
		return CommonResult.success();
	}
	
	
	@RequestMapping("/updateNonEmptyPlanById")
	public CommonResult<Integer> updateNonEmptyPlanById(@RequestBody Plan para) {
		planService.updateNonEmptyPlanById(para);
		return CommonResult.success();
	}
	
	@RequestMapping("/listByUidAndPaging")
	public CommonResult<JSONObject> listByUidAndPaging(@RequestParam int uid,
										 @RequestParam int startRow,
										 @RequestParam int rowSize,
										 @RequestParam String sel_status,
										 @RequestParam String sel_word,
										 @RequestParam String sel_date) {
		
		return CommonResult.success(planService.listByUidAndPaging(uid, startRow, rowSize, sel_status, sel_word, sel_date));
	} 
}
