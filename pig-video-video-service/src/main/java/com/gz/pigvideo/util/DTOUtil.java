package com.gz.pigvideo.util;

import com.alibaba.fastjson.JSONObject;
import com.gz.pigvideo.domain.VideoInfo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DTOUtil {

    private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static JSONObject userInfo2JSONObject(VideoInfo videoInfo){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",videoInfo.getId());
        jsonObject.put("content",videoInfo.getContent());
        jsonObject.put("createTime",format.format(videoInfo.getCreateTime()));
        jsonObject.put("videoURL",videoInfo.getVideoURL());

        return jsonObject;
    }

}
