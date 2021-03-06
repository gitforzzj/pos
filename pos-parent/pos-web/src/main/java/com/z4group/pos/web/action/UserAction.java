package com.z4group.pos.web.action;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.z4group.pos.domain.User;
import com.z4group.pos.service.IUserService;
import com.z4group.pos.utils.POSUtils;
import com.z4group.pos.utils.MD5Utils;
import com.z4group.pos.web.action.base.BaseAction;


@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	
	private String checkcode;
	/*@Autowired
	private ICustomerService proxy;*/
	
	@Autowired
	private IUserService userService;
	
	private String[] roleIds;
	
	
	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}
	
	public String add() {
		userService.save(model,roleIds);
		return LIST;
	}

	public String pageQuery() {
		userService.pageQuery(pageBean);
		this.java2json(pageBean, new String[] {"roles","birthday"});
		return NONE;
	}
	
	public String login() {
		String validatecode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		if(StringUtils.isNotBlank(checkcode)&&checkcode.equals(validatecode)) {
			
			Subject subject =  SecurityUtils.getSubject();
			AuthenticationToken token = new UsernamePasswordToken(model.getUsername(),MD5Utils.md5(model.getPassword()));
			try {
				subject.login(token);
				User user = (User)subject.getPrincipal();
				ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
			}catch(Exception e) {
				e.printStackTrace();
				return LOGIN;
			}
			return "home";
		}else {
			this.addActionError("输入的验证码错误");
			return LOGIN;
		}
	}
	
	public String logout() {
		ServletActionContext.getRequest().getSession().invalidate();
		return LOGIN;
	}
	
	public String editPassword() throws IOException{
		String f = "1";
		User user = POSUtils.getLoginUser();
		try {
			userService.editPassword(user.getId(),model.getPassword());
		}catch(Exception e) {
			f="0";
			e.printStackTrace();
		}
		
		ServletActionContext.getResponse().setContentType("text/html,charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(f);
		return NONE;
	}
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
}
