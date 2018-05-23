package com.z4group.pos.shiro;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;

import com.z4group.pos.dao.IFunctionDao;
import com.z4group.pos.dao.IUserDao;
import com.z4group.pos.domain.Function;
import com.z4group.pos.domain.User;

public class PosRealm extends AuthorizingRealm{

	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IFunctionDao functionDao;
	//认证方法
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken mytoken = (UsernamePasswordToken)token;
		String username = mytoken.getUsername();
		User user = userDao.findUserByUsername(username);
		if(user==null) {
			return null;
		}
		
		AuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
		return info;
	}

	//授权方法
		@Override
		protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			User user = (User)SecurityUtils.getSubject().getPrincipal();
			List<Function> list= null;
			if(user.getUsername().equals("admin")) {
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Function.class);
				list = functionDao.findByCriteria(detachedCriteria);
			}else {
				list=functionDao.findFunctionListByUserId(user.getId());
			}
			
			for(Function function:list) {
				info.addStringPermission(function.getCode());
			}
			
			return info;
		}
		
	
}
