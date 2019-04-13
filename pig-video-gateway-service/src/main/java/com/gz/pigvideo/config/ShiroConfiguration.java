package com.gz.pigvideo.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gz.pigvideo.security.MyShiroRealm;


@Configuration
public class ShiroConfiguration {

	private static Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

	class UserCredentialsMatcher extends SimpleCredentialsMatcher {
		@Override
		public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
			
			UsernamePasswordToken usertoken = (UsernamePasswordToken) token;
			String password = (String) info.getCredentials();
			
			return equals(new String(usertoken.getPassword()), password);
		}

	}

	/**
	 * 
	 * @Title: myShiroRealm @Description:
	 * realmBean,实现了Realm接口或者继承AuthorizingRealm @return MyShiroRealm @throws
	 */
	@Bean(name = "myShiroRealm")
	public MyShiroRealm myShiroRealm() {
		MyShiroRealm realm = new MyShiroRealm();
		realm.setCredentialsMatcher(new UserCredentialsMatcher());
		return realm;
	}

	/**
	 * 
	 * @Title: getLifecycleBeanPostProcessor @Description: 与spring相关，可以自动调用spring
	 * IOC容器中的shiro bean生命周期方法 @return LifecycleBeanPostProcessor @throws
	 */
	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
		daap.setProxyTargetClass(true);
		return daap;
	}

	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilterFactoryBean() {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager());
		shiroFilterFactoryBean.setSuccessUrl("/");
		shiroFilterFactoryBean.setUnauthorizedUrl("/error/403.html");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	/**
	 * 
	 * @Title: securityManager @Description:
	 * shiro核心组件，可以添加添加Session,cache以及realm @return SecurityManager @throws
	 */
	@Bean(name = "securityManager")
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm());
		securityManager.setSessionManager(sessionManager());
		return securityManager;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {
		AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
		aasa.setSecurityManager(securityManager());
		return new AuthorizationAttributeSourceAdvisor();
	}
	
    @Bean
    public SessionManager sessionManager() {
        MySessionManager mySessionManager = new MySessionManager();
        return mySessionManager;
    }
	
	

}
