package com.gz.pigvideo.security;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.gz.pigvideo.domain.User;
import com.gz.pigvideo.service.UserService;

/**
 * @file MyShiroRealm.java
 * @author huang
 * @date 2017年4月13日
 * @desription 
 */
public class MyShiroRealm extends AuthorizingRealm{

	private static String REALM_NAME = "myShiroRealm";
	
	@Autowired
	private UserService userService;
	
	public MyShiroRealm(){
		setName(REALM_NAME);
		setAuthenticationCachingEnabled(false);
		setAuthorizationCachingEnabled(false);
	}
	
	
	@Override
	/**
	 * 权限验证
	 * @file MyShiroRealm.java
	 * @method doGetAuthorizationInfo
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 * <br>
	 * @author huang
	 * @time 2017年4月13日 下午7:49:11
	 * @desription TODO
	 * </br>
	 * 
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = null;
		String username = (String) principals.fromRealm(getName()).iterator().next();
		if (username != null) {
			Subject currentUser = SecurityUtils.getSubject();
			Object object = currentUser.getSession().getAttribute("user");
			if (object != null) {
				if(object instanceof User) {
					User user = (User) object;
					String authority = user.getRole().getRoleDetail();
					if (authority != null && !authority.equals("")) {
						String[] permissions = authority.split(";");
						if (permissions.length > 0) {
							 info = new SimpleAuthorizationInfo();
							for (String permission : permissions) {
								info.addStringPermission(permission);
							}
							return info;
						}
					}
				}
			}
		}
		return null;
	}

	
	@Override
	/**
	 * 登录验证
	 * @file MyShiroRealm.java
	 * @method doGetAuthenticationInfo
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 * <br>
	 * @author huang
	 * @time 2017年4月13日 下午7:48:47
	 * @desription TODO
	 * </br>
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken authtoken=(UsernamePasswordToken) token;
		String userName=authtoken.getUsername();
		User user=null;
		user = userService.getUserByAccount(userName);
		
		if(user==null){
			/**
			 * 用户不存在
			 */
			throw new UnknownAccountException("用户不存在！");
		}
		Subject currentuser=SecurityUtils.getSubject();
		currentuser.getSession().setAttribute("user", user);
		return new SimpleAuthenticationInfo(user.getAccount(), user.getPassword(), getName());
	}

}
