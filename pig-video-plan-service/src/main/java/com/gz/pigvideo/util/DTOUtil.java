package com.gz.pigvideo.util;


import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.gz.pigvideo.domain.Note;
import com.gz.pigvideo.domain.Plan;

@Component
public class DTOUtil {

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    private static DateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public JSONObject plan2Object(Plan plan) {
    	
    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("id", plan.getId());
    	jsonObject.put("uid", plan.getUid());
    	jsonObject.put("planType", plan.getPlanType());
    	jsonObject.put("planIndex", plan.getPlanIndex());
    	jsonObject.put("status", plan.getFinishStatus()==1?true:false);
    	jsonObject.put("content",plan.getContent());
    	jsonObject.put("createDate", dateFormat.format(plan.getCreateDate()));
    	jsonObject.put("finishDate", dateFormat.format(plan.getFinishDate()));
    	if(jsonObject.getBooleanValue("status")) {
    		jsonObject.put("actualFinishDate", timeFormat.format(plan.getActualFinishDate()));
    	}else {
    		jsonObject.put("actualFinishDate","");
    	}
    	return jsonObject;
    }
    
    public JSONObject note2Object(Note note) {
    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("id", note.getId());
    	jsonObject.put("uid", note.getUid());
    	jsonObject.put("content", note.getContent());
    	jsonObject.put("createTime", timeFormat.format(note.getCreateTime()));
    	jsonObject.put("fromid", note.getFromid());
    	jsonObject.put("title",note.getTitle());
    	jsonObject.put("type", note.getType());
    	if(note.getUpdateTime()!=null) {
    		jsonObject.put("updateTime", timeFormat.format(note.getUpdateTime()));
    	}else {
    		jsonObject.put("updateTime","");
    	}
    	return jsonObject;
    }
    
}
