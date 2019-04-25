package com.gz.pigvideo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectRemoteRest {

    /**
     * 
    * @Description: 判断权限
    * @param  参数说明
    * @return String    返回类型
    * @author gaozhen
     */
    @RequestMapping("/isPermitted")
    public boolean isPermitted(@RequestParam(value = "permission") String permission){
    	Subject currentUser = SecurityUtils.getSubject();
        return currentUser.isPermitted(permission);
    }
    
    /**
     * 
    * @Description: 是否被认证
    * @param  参数说明
    * @return boolean    返回类型
    * @author gaozhen
     */
    @RequestMapping("/isAuthenticated")
    public boolean isAuthenticated(){
    	Subject currentUser = SecurityUtils.getSubject();
    	currentUser.isAuthenticated();
        return currentUser.isAuthenticated();
    }

}