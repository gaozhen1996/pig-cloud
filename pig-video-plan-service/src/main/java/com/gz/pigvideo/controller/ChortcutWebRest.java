package com.gz.pigvideo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gz.pigvideo.api.CommonResult;
import com.gz.pigvideo.domain.Chortcut;
import com.gz.pigvideo.service.ChortcutService;

@RestController
@RequestMapping("/web/rest/chortcut")
public class ChortcutWebRest {

	@Autowired
	private ChortcutService chortcutService;
	
	@RequestMapping("/selectSystemChortcutByUid")
	public CommonResult<List<Chortcut>> selectSystemChortcutByUid(@RequestParam int uid) {
		List<Chortcut> chortcuts = chortcutService.selectSystemChortcutByUid(uid);
		return CommonResult.success(chortcuts);
	}
	
	@RequestMapping("/selectChortcutByUid")
	public CommonResult<List<Chortcut>> selectChortcutByUid(@RequestParam int uid) {
		List<Chortcut> chortcuts = chortcutService.selectChortcutByUid(uid);
		return CommonResult.success(chortcuts);
	}
	
	@RequestMapping("/addChortcut")
	public CommonResult<Integer> addChortcut(@RequestBody Chortcut para) {
		if(chortcutService.insertNonEmptyChortcut(para)==1) {
			return CommonResult.success();
		}
		return CommonResult.failed();
	}
	
	@RequestMapping("/updateChortcut")
	public CommonResult<Integer> updateChortcut(@RequestBody Chortcut para) {
		if(chortcutService.updateNonEmptyChortcutById(para)==1) {
			return CommonResult.success();
		}
		return CommonResult.failed();
	}
	
	@RequestMapping("/deleteChortcut")
	public CommonResult<Integer> deleteChortcut(@RequestBody Chortcut para) {
		if(chortcutService.deleteChortcutById(para.getId())==1) {
			return CommonResult.success();
		}
		return CommonResult.failed();
	}
}
