package com.gz.pigcloud.config;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

  
/**
 * druid过滤器.
 * @author Administrator
 *
 */
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
    initParams={
             @WebInitParam(name="exclusions",value="*/druid/*")// 忽略资源
     }
)
public class DruidStatFilter extends WebStatFilter{

}
