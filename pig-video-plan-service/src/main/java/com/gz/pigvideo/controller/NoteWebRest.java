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
import com.gz.pigvideo.api.CommonResult;
import com.gz.pigvideo.domain.Note;
import com.gz.pigvideo.service.NoteService;

@RestController
@RequestMapping("/web/rest/note")
public class NoteWebRest {
	
	private static final Logger log = LoggerFactory.getLogger(NoteWebRest.class);
	
	@Autowired
	private NoteService noteService;

	@RequestMapping("/listNoteByUidAndPaging")
	public CommonResult<JSONObject> listNoteByUidAndPaging(@RequestParam int uid,
									   @RequestParam int startRow,
									   @RequestParam int rowSize) {
		JSONObject data = noteService.listNoteByUidAndPaging(uid, startRow, rowSize);
		return CommonResult.success(data);
	}	
	
	@RequestMapping("/addNote")
	public CommonResult<JSONObject> addNote(@RequestBody Note para) {
		para.setCreateTime(new Date());
		para.setType("note");
		return CommonResult.success(noteService.insertNonEmptyNote(para));
	}
	
	@RequestMapping("/updateNoteById")
	public CommonResult<Integer> updateNoteById(@RequestBody Note para) {
		para.setUpdateTime(new Date());
		return CommonResult.success(noteService.updateNonEmptyNoteById(para));
//		log.info(reqstr);
//		JSONObject response = new JSONObject();
//		try {
//			JSONObject request = JSONObject.parseObject(reqstr);
//			Note note = new Note();
//			note.setId(request.getInteger("id"));
//			note.setTitle(request.getString("title"));
//			note.setContent(request.get("content"));
//			note.setUpdateTime(new Date());
//			int res = noteService.updateNonEmptyNoteById(note);
//			if(res==1) {
//				response.put("data", res);
//				response.put("code", 2);
//			}else {
//				response.put("code",5);
//				response.put("msg","未知错误");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			response.put("code",5);
//			response.put("msg", e.getMessage());
//		}
//		return response;
	}	

	@RequestMapping("/deleteNoteById")
	public CommonResult<Integer> deleteNoteById(@RequestBody Note para) {
		return CommonResult.success(noteService.deleteNoteById(para.getId()));
	}		
	
}
