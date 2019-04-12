package com.gz.pigvideo.util;


import java.util.logging.Level;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.URL;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.core.io.UrlResource;


/**
 * 
* <p>
* 爬虫工具
* <p>
* @author gaozhen
* @date 2019年1月11日
* @Version 1.1
 */
public class WormUtil {

    /**
     * 通过HTML获取video路径
     * @param url
     * @return
     * @throws IOException
     */
    public static JSONObject getVideoFromHTML(String url) throws IOException {
        JSONObject res = new JSONObject();

        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.http.client").setLevel(Level.OFF);

        // HtmlUnit 模拟浏览器
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(true);              // 启用JS解释器，默认为true
        webClient.getOptions().setCssEnabled(false);                    // 禁用css支持
        webClient.getOptions().setThrowExceptionOnScriptError(false);   // js运行错误时，是否抛出异常
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setTimeout(10 * 1000);                   // 设置连接超时时间
        HtmlPage page = webClient.getPage(url);
        webClient.waitForBackgroundJavaScript(1 * 1000);               // 等待js后台执行
        String pageAsXml = page.asXml();
        //关闭webclient
        webClient.close();
        // Jsoup解析处理
        Document doc = Jsoup.parse(pageAsXml, url);
        // 获取所有视频地址
        Elements video = doc.select("a[href$=.mp4]");
        String videoTitle = video.attr("download");
        String videoUrl = "http:"+video.attr("href");
        boolean flag = new UrlResource(videoUrl).exists();
        if (flag){
            res.put("videoTitle", videoTitle);
            res.put("videoUrl",videoUrl);
        }else{
            res.put("videoUrl",null);
            res.put("msg","视频连接失效");
        }
        return res;
    }

    /**
     * 从网络Url中下载文件
     *
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    public static boolean downLoadVideoFromUrl(String urlStr, String fileName, String savePath) throws IOException {
        boolean res = false;
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 设置超时间为3秒
        conn.setConnectTimeout(3 * 1000);
        // 防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        // 得到输入流
        InputStream inputStream = conn.getInputStream();
        // 获取自己数组
        byte[] getData = readInputStream(inputStream);

        // 文件保存位置
        File saveDir = new File(savePath);
        if (!saveDir.exists()) {
            saveDir.mkdir();
        }
        File file = new File(saveDir + File.separator + fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        res = true;
        if (fos != null) {
            fos.close();
        }
        if (inputStream != null) {
            inputStream.close();
        }

        return res;
    }

    /**
     * 从输入流中获取字节数组
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    private static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

//    public static void main(String[] args) throws IOException {
//        String url = "https://live.bilibili.com/147?spm_id_from=333.334.b_62696c695f6c697665.12";
//        System.out.println(getVideoFromHTML(url));
//    }

    /**
     * 通过URL下载指定数量的视频
     * @param url    HTML的URL
     * @param count  下载视频的数量
     * @param savePath
     */
    public static void saveVideoFromUrl(String url,int count,String savePath){
        JSONObject videoInfo=null;
        String videoTitle = null;
        String videoUrl = null;

        for (int i = 0; i < count; i++) {
            try {
                videoInfo = WormUtil.getVideoFromHTML(url);
                if (videoInfo!=null && videoInfo.get("videoTitle")!=null){
                    videoTitle = videoInfo.get("videoTitle") + ".mp4";
                    videoUrl = (String)videoInfo.get("videoUrl");
                }else{
                    System.out.println(videoInfo.get("msg"));
                }
            }catch (Exception e){
                // log.error("获取Html失败！");
            }

            try {
                boolean res = downLoadVideoFromUrl(videoUrl, videoTitle, savePath);
                if (res){
                   // log.info(videoTitle+"下载完成！");
                }else{
                   // log.error(videoTitle+"下载失败！   URL："+videoUrl);
                }
            } catch (Exception e) {
                //log.error(videoTitle+"下载失败！   URL："+videoUrl);
                e.printStackTrace();
                continue;
            }

        }
    }

    public static JSONArray getCountVideoURL(String url, int count) {
        JSONArray jsonArray = new JSONArray();
        try{
            for(int i=0;i<count;i++){
                JSONObject obj = WormUtil.getVideoFromHTML(url);
                if(obj!=null & obj.get("videoUrl")!=null){
                    jsonArray.add(obj);
                }
            }
        }catch (Exception e){
            System.out.println("爬去视频URL异常");
        }
        return jsonArray;
    }

}
