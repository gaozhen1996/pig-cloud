package com.gz.pigcloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.pigcloud.domain.Chortcut;
import com.gz.pigcloud.repository.ChortcutDao;

@Service
public class ChortcutService {
	
	@Autowired
	private ChortcutDao chortcutDao; 

	public List<Chortcut> selectChortcutByUid(int uid){
		return chortcutDao.selectChortcutByUid(uid);
	}
	
	public List<Chortcut> selectSystemChortcutByUid(int uid){
		return chortcutDao.selectSystemChortcutByUid(uid);
	}
	
	public int insertNonEmptyChortcut(Chortcut chortcut) {
		return chortcutDao.insertNonEmptyChortcut(chortcut);
	}
	
	public int updateNonEmptyChortcutById(Chortcut chortcut) {
		return chortcutDao.updateNonEmptyChortcutById(chortcut);
	}

	public int deleteChortcutById(int chortcutId) {
		return chortcutDao.deleteChortcutById(chortcutId);
	}

}
