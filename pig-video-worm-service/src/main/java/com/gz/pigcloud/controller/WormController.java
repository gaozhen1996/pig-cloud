package com.gz.pigcloud.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.gz.pigcloud.util.HTTPClient;


@RestController
public class WormController {
   
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping("/worm/{count}")
    public String worm(@PathVariable("count") int count) {
        String url = "https://kuaiyinshi.com/api/kuai-shou/recommend/";
        JSONArray urls = new HTTPClient().getVideoFromURL(url);
        rabbitTemplate.convertAndSend("saveVideoURL",urls);
        return "已成功添加至消息队列";
    }

}