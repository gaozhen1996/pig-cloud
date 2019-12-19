package com.gz.pigvideo.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gz.pigvideo.common.Assist;
import com.gz.pigvideo.common.Assist.WhereRequire;
import com.gz.pigvideo.domain.Plan;
import com.gz.pigvideo.exceptions.ParaException;
import com.gz.pigvideo.repository.PlanDao;
import com.gz.pigvideo.util.DTOUtil;

@Service
public class PlanService {
	
	@Autowired
	private PlanDao planDao;
	
	@Autowired
	private DTOUtil dtoUtil; 
	
	public JSONArray getPlansGroupType(String todayDateStr,int uid) {
		//校验日期参数，是否是合法的字符串
		try {
			new SimpleDateFormat("yyyy-MM-dd").parse(todayDateStr);
		} catch (Exception e) {
			throw new ParaException();
		}
		//计划有四类
		JSONArray planArr = new JSONArray();
		planArr.add(new JSONArray());
		planArr.add(new JSONArray());
		planArr.add(new JSONArray());
		planArr.add(new JSONArray());
		Assist assist = new Assist();
		assist.setOrder(Assist.order("plan_type", true));
		assist.setOrder(Assist.order("plan_index", true));
		WhereRequire<?> require = assist.new WhereRequire<Object>(
				" uid = "+ uid+" and create_date<='"+ todayDateStr +"'"
				+" and ((finish_date>='"+todayDateStr
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
	
	public JSONObject listByUidAndPaging(int uid,int startRow,int rowSize,String sel_status, 
										 String sel_word, String sel_date){
		JSONObject res = new JSONObject();
		JSONArray planArr = new JSONArray();
		Assist assist = new Assist();
		assist.setOrder(Assist.order("id", false));
		assist.setRequires(Assist.andEq("uid", uid));
		assist.setRowSize(rowSize);
		assist.setStartRow(startRow);
		//搜索条件
		if(!sel_status.equals("")) {
			assist.setRequires(Assist.andEq("finish_status",sel_status));
		}
		if(!sel_word.equals("")) {
			assist.setRequires(Assist.andLike("content", "%"+sel_word+"%"));
		}
		if(!sel_date.equals("")) {
			assist.setRequires(Assist.andEq("create_date",sel_date));
		}
		List<Plan> plans = planDao.selectPlan(assist);
		for (Plan plan : plans) {
			planArr.add(dtoUtil.plan2Object(plan));
		}
		res.put("data",planArr);
		assist.setStartRow(null);
		assist.setRowSize(null);
		long row = planDao.getPlanRowCount(assist);
		res.put("row",row);
		return res;
	}
	
}
