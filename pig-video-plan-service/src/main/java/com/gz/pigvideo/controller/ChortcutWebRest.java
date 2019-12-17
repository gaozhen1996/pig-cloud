package com.gz.pigvideo.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.gz.pigvideo.api.CommonResult;
import com.gz.pigvideo.domain.Chortcut;
import com.gz.pigvideo.service.ChortcutService;

@RestController
@RequestMapping("/web/rest/chortcut")
public class ChortcutWebRest {

	private static final Logger log = LoggerFactory.getLogger(ChortcutWebRest.class);
	
	@Autowired
	private ChortcutService chortcutService;
	
	@RequestMapping("/selectSystemChortcutByUid")
	public CommonResult<List<Chortcut>> selectSystemChortcutByUid(@RequestParam int uid) {
		List<Chortcut> chortcuts = chortcutService.selectSystemChortcutByUid(uid);
		return new CommonResult<List<Chortcut>>(chortcuts);
	}
	
	@RequestMapping("/selectChortcutByUid")
	public CommonResult<List<Chortcut>> selectChortcutByUid(@RequestParam int uid) {
		List<Chortcut> chortcuts = chortcutService.selectChortcutByUid(uid);
		return new CommonResult<List<Chortcut>>(chortcuts);
	}
	
	@RequestMapping("/addChortcut")
	public JSONObject addChortcut(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject response = new JSONObject();
		try {
			JSONObject request = JSONObject.parseObject(reqstr);
			Chortcut chortcut = new Chortcut();
			chortcut.setAddDate(new Date());
			chortcut.setImgUrl(request.getString("color"));
			chortcut.setName(request.getString("name"));
			chortcut.setUrl(request.getString("url"));
			chortcut.setUid(request.getInteger("uid"));
			if(request.getInteger("relation")!=null) {
				chortcut.setRelation(request.getInteger("relation"));
			}else {
				chortcut.setRelation(0);
			}
			if(chortcutService.insertNonEmptyChortcut(chortcut)==1) {
				response.put("code", 2);
			}else {
				response.put("code", 5);
				log.error("插入chortcut失败");
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			response.put("code",5);
			response.put("msg", e.getMessage());
		}
		return response;
	}
	
	@RequestMapping("/updateChortcut")
	public JSONObject updateChortcut(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject response = new JSONObject();
		try {
			JSONObject request = JSONObject.parseObject(reqstr);
			Chortcut chortcut = new Chortcut();
			chortcut.setId(request.getInteger("id"));
			chortcut.setName(request.getString("name"));
			chortcut.setUrl(request.getString("url"));
			if(chortcutService.updateNonEmptyChortcutById(chortcut)==1) {
				response.put("code", 2);
			}else {
				response.put("code", 5);
				response.put("msg","修改chortcut失败");
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			response.put("code",5);
			response.put("msg", e.getMessage());
		}
		return response;
	}
	
	@RequestMapping("/deleteChortcut")
	public JSONObject deleteChortcut(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject response = new JSONObject();
		try {
			JSONObject request = JSONObject.parseObject(reqstr);
			int chortcutId = request.getInteger("id");
			if(chortcutService.deleteChortcutById(chortcutId)==1) {
				response.put("code", 2);
			}else {
				response.put("code", 5);
				response.put("msg","删除chortcut失败");
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			response.put("code",5);
			response.put("msg", e.getMessage());
		}
		return response;
	}
}
