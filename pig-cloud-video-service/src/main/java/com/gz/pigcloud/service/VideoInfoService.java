package com.gz.pigcloud.service;

import com.gz.pigcloud.common.Assist;
import com.gz.pigcloud.domain.VideoInfo;
import com.gz.pigcloud.repository.VideoInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class VideoInfoService {

	@Autowired
	private VideoInfoDao videoInfoDao;

	private DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public long getVideoInfoRowCount(Assist assist) {
		return videoInfoDao.getVideoInfoRowCount(assist);
	}

	public List<VideoInfo> selectVideoInfo(Assist assist) {
		return videoInfoDao.selectVideoInfo(assist);
	}

	public int insertNonEmptyVideoInfo(String videoUrl,String videoTitle){
		int effect = 0;
		VideoInfo videoInfo = new VideoInfo();
		videoInfo.setVideoURL(videoUrl);
		videoInfo.setContent(videoTitle);
		videoInfo.setCreateTime(System.currentTimeMillis());
		effect=videoInfoDao.insertNonEmptyVideoInfo(videoInfo);
		return effect;
	}

	public List<Integer> selectCountGreaterDate(Date date){
		String dateStr = format.format(date);
		return videoInfoDao.selectCountGreaterDate(dateStr);
	}


}