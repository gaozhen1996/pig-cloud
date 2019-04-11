package com.gz.pigvideo.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name= "pig-video-video-service")
public interface IVideoService {

    @RequestMapping(value = "/saveVideoURL")
    public String saveVideoURL(@RequestParam(value = "urls") String urls);


}
