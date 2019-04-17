package com.gz.pigvideo.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.gz.pigvideo.domain.Note;
import com.gz.pigvideo.service.NoteService;

@RestController
@RequestMapping("/web/rest/note")
public class NoteWebRest {
	
	private static final Logger log = LoggerFactory.getLogger(NoteWebRest.class);
	
	@Autowired
	private NoteService noteService;

	@RequestMapping("/listNoteByUidAndPaging")
	public JSONObject listNoteByUidAndPaging(@RequestParam int uid,
									   @RequestParam int startRow,
									   @RequestParam int rowSize) {
		log.info("listNoteByUidAndPaging?");
		JSONObject response = new JSONObject();
		try {
			JSONObject data = noteService.listNoteByUidAndPaging(uid, startRow, rowSize);
			response.put("data", data);
			response.put("code", 2);
		} catch (Exception e) {
			log.error(e.getMessage());
			response.put("code",5);
			response.put("msg",e.getMessage());
		}
		return response;
	}	
	
	@RequestMapping("/addNote")
	public JSONObject addNote(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject response = new JSONObject();
		try {
			JSONObject request = JSONObject.parseObject(reqstr);
			Note note = new Note();
			note.setContent(request.get("content"));
			note.setCreateTime(new Date());
			note.setFromid(request.getInteger("fromid"));
			note.setTitle(request.getString("title"));
			note.setType("note");
			note.setUid(request.getInteger("uid"));
			JSONObject res = noteService.insertNonEmptyNote(note);
			if(res==null) {
				response.put("code",5);
				response.put("msg","未知错误");
			}else {
				response.put("data", res);
				response.put("code", 2);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			response.put("code",5);
			response.put("msg", e.getMessage());
		}
		return response;
	}
	
	@RequestMapping("/updateNoteById")
	public JSONObject updateNoteById(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject response = new JSONObject();
		try {
			JSONObject request = JSONObject.parseObject(reqstr);
			Note note = new Note();
			note.setId(request.getInteger("id"));
			note.setTitle(request.getString("title"));
			note.setContent(request.get("content"));
			note.setUpdateTime(new Date());
			int res = noteService.updateNonEmptyNoteById(note);
			if(res==1) {
				response.put("data", res);
				response.put("code", 2);
			}else {
				response.put("code",5);
				response.put("msg","未知错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.put("code",5);
			response.put("msg", e.getMessage());
		}
		return response;
	}	

	@RequestMapping("/deleteNoteById")
	public JSONObject deleteNoteById(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject response = new JSONObject();
		try {
			JSONObject request = JSONObject.parseObject(reqstr);
			int id = request.getInteger("id");
			int res = noteService.deleteNoteById(id);
			if(res==1) {
				response.put("data", res);
				response.put("code", 2);
			}else {
				response.put("code",5);
				response.put("msg","未知错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.put("code",5);
			response.put("msg", e.getMessage());
		}
		return response;
	}		
	
}
