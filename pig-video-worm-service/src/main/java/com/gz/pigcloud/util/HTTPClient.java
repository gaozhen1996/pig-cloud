package com.gz.pigcloud.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.core.io.UrlResource;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class HTTPClient {

	public JSONObject post(JSONObject json, String url) {
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);
			httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
			// 解决中文乱码问题
			StringEntity stringEntity = new StringEntity(json.toString(), "UTF-8");
			stringEntity.setContentEncoding("UTF-8");
			httpPost.setEntity(stringEntity);
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				@Override
				public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {//
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity) : null;
					} else {
						throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}
			};
			String responseBody = httpclient.execute(httpPost, responseHandler);
			return JSONObject.parseObject(responseBody);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public JSONObject get(String url) {
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url);
			httpGet.addHeader("Content-Type", "text/plain; charset=UTF-8");
			// 解决中文乱码问题
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				@Override
				public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {//
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity) : null;
					} else {
						throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}
			};
			String responseBody = httpclient.execute(httpGet, responseHandler);
			return JSONObject.parseObject(responseBody);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private  String convertCode(String videoEncode) {
		String secretKey = "A0MjZfMTY0NDA3Mj";
		String videoDecode = null;
		//参数校验
		if(videoEncode==null) {
			return null;
		}
		
		try {
			int secretNum = secretKey.length();
			byte[] secretAscII = new byte[secretNum];
			for(int i=0;i<secretNum;i++) {
				secretAscII[i]= (byte)secretKey.charAt(i);
			}
			//将videoEncode转化为数组
			String[] ves = videoEncode.split(":");
			int[] temp = new int[ves.length-1];
			for(int i=1;i<ves.length;i++) {
				temp[i-1]=Integer.valueOf(ves[i])-(255&secretAscII[(i-1)%secretNum]);
			}
			StringBuffer sb = new StringBuffer();
			sb.append(ves[0]);
			for (int i : temp) {
				sb.append((char)i);
			}
			sb.append(".mp4");
			videoDecode = sb.toString();
		} catch (Exception e) {
			
		}
		
		return videoDecode;
	}
	
    public JSONArray getVideoFromURL(String url) {
    	JSONArray resArray = new JSONArray();
    	try {
        	JSONObject json = this.get(url);
        	if(json.getInteger("code")==200) {
        		JSONArray jsonArray = json.getJSONArray("data");
        		for(int i=0;i<jsonArray.size();i++) {
        			JSONObject res = new JSONObject();
        			JSONObject videoObject = jsonArray.getJSONObject(i);
        			String video = videoObject.getString("video_url");
        			video = "http:"+this.convertCode(video.substring(0, video.length()-4));
        			String videoTitle = videoObject.getString("desc");
        			System.out.println(video);
        			boolean flag = new UrlResource(video).exists();
        			if(flag) {
                        res.put("videoTitle",videoTitle);
                        res.put("videoUrl",video);
                        resArray.add(res);
        			}
        		}
        	}
		} catch (Exception e) {
			System.out.println(e);
		}
    	System.out.println(resArray);
    	return resArray;
    }
}
