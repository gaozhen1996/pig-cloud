package com.gz.pigvideo.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by summer on 2017/5/11.
 */
@FeignClient(name= "pig-video-worm-service")
public interface WormRemote {

    @RequestMapping(value = "/autWormSetting")
    public String autWormSetting(@RequestParam(value = "flag") String flag);

}
