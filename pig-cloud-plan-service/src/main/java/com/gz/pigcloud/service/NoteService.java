package com.gz.pigcloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gz.pigcloud.common.Assist;
import com.gz.pigcloud.domain.Note;
import com.gz.pigcloud.repository.NoteDao;
import com.gz.pigcloud.util.DTOUtil;

@Service
public class NoteService {
	
	@Autowired
	private NoteDao noteDao; 

	@Autowired
	private DTOUtil dtoUtil; 

	public JSONObject insertNonEmptyNote(Note value) {
		JSONObject res = new JSONObject();
		int effect = noteDao.insertNonEmptyNote(value);
		if(effect==1) {
			res = dtoUtil.note2Object(value);
		}else {
			res = null;
		}
		return res;
	}

	public int updateNonEmptyNoteById(Note value) {
		return noteDao.updateNonEmptyNoteById(value);
	}
	
	
	public JSONObject listNoteByUidAndPaging(int uid,int startRow,int rowSize) {
		JSONObject res = new JSONObject();
		JSONArray noteArr = new JSONArray();
		Assist assist = new Assist();
		assist.setOrder(Assist.order("id", true));
		assist.setRequires(Assist.andEq("uid", uid));
		assist.setRowSize(rowSize);
		assist.setStartRow(startRow);
		List<Note> notes = noteDao.selectNote(assist);
		for (Note note : notes) {
			noteArr.add(dtoUtil.note2Object(note));
		}
		res.put("data",noteArr);
		assist.setStartRow(null);
		assist.setRowSize(null);
		long row = noteDao.getNoteRowCount(assist);
		res.put("row",row);
		return res;
	}
	
	public int deleteNoteById(int id) {
		return noteDao.deleteNoteById(id);
	}
	
}
