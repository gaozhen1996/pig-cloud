package com.gz.pigvideo.controller;

import java.util.Date;

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
	}	

	@RequestMapping("/deleteNoteById")
	public CommonResult<Integer> deleteNoteById(@RequestBody Note para) {
		return CommonResult.success(noteService.deleteNoteById(para.getId()));
	}		
	
}
