package com.gz.pigvideo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.gz.pigvideo.common.Assist;
import com.gz.pigvideo.common.Assist.WhereRequire;
import com.gz.pigvideo.domain.Plan;
import com.gz.pigvideo.repository.PlanDao;
import com.gz.pigvideo.util.DTOUtil;

@Service
public class PlanService {
	
	@Autowired
	private PlanDao planDao;
	
	@Autowired
	private DTOUtil dtoUtil; 
	
	public JSONArray getPlansGroupType(Date today,int uid) {
		JSONArray planArr = new JSONArray();
		planArr.add(new JSONArray());
		planArr.add(new JSONArray());
		planArr.add(new JSONArray());
		planArr.add(new JSONArray());
		Assist assist = new Assist();
		assist.setOrder(Assist.order("plan_type", true));
		assist.setOrder(Assist.order("plan_index", true));
		String todayStr = new SimpleDateFormat("yyyy-MM-dd").format(today);
		WhereRequire<?> require = assist.new WhereRequire<Object>(
				" uid = "+ uid+" and create_date<='"+ todayStr +"'"
				+" and ((finish_date>='"+todayStr
				+"' and finish_status=1) or finish_status=0)", null);
		assist.setRequires(require);
		List<Plan> plans = planDao.selectPlan(assist);
		for (Plan plan : plans) {
			JSONArray tempArr = (JSONArray) planArr.get( plan.getPlanType());
			tempArr.add(dtoUtil.plan2Object(plan));
		}
		return planArr;
	}
	
	public void updatePlanType(Plan newPlan , Plan oldPlan) {
		planDao.updatePlanType(newPlan, oldPlan);
	}
	
	public int insertNonEmptyPlan(Plan plan) {
		return  planDao.insertNonEmptyPlan(plan);
	}
	
	public int updateNonEmptyPlanById(Plan plan) {
		return planDao.updateNonEmptyPlanById(plan);
	}
	
	public int deletePlanById(Plan plan) {
		return planDao.deletePlanById(plan);
	}
}
