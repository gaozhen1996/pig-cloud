package com.gz.pigvideo.util;


import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.gz.pigvideo.domain.Plan;

@Component
public class DTOUtil {

    private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    
    public JSONObject plan2Object(Plan plan) {
    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("id", plan.getId());
    	jsonObject.put("uid", plan.getUid());
    	jsonObject.put("planType", plan.getPlanType());
    	jsonObject.put("planIndex", plan.getPlanIndex());
    	jsonObject.put("status", plan.getFinishStatus()==1?true:false);
    	jsonObject.put("content",plan.getContent());
    	jsonObject.put("createDate", format.format(plan.getCreateDate()));
    	jsonObject.put("finishDate", format.format(plan.getFinishDate()));
    	return jsonObject;
    }
    
}
