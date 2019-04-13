package com.bjsxt.manage.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.bjsxt.dubbo.service.UserDubboService;
import com.bjsxt.pojo.User;

/**
 * 想象成service
 * @author Administrator
 *
 */
public class ManageRealm extends AuthorizingRealm{
	@Autowired
	private UserDubboService userDubboService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		Object username = token.getPrincipal();
		System.out.println("username;"+username);
		System.out.println(userDubboService);
		User user = userDubboService.selByUsername(username.toString());
		if(user!=null){
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),ByteSource.Util.bytes(""+user.getId()),"key:"+user.getId());
			return info;
		}
		return null;
	}

}
