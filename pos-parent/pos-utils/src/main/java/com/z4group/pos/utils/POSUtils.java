package com.z4group.pos.utils;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.z4group.pos.domain.User;

public class POSUtils {
	public static HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}
	
	public static User getLoginUser() {
		return (User) getSession().getAttribute("loginUser");
	}
}
