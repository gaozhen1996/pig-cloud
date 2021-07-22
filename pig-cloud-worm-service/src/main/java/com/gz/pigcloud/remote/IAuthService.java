package com.gz.pigcloud.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name= "pig-video-auth-service")
public interface IAuthService {

    @RequestMapping(value = "/isPermitted")
    public boolean isPermitted(@RequestParam(value = "permission") String permission);

    @RequestMapping(value = "/isAuthenticated")
    public boolean isAuthenticated();
}
