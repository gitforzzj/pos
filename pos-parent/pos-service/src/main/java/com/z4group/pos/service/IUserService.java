package com.z4group.pos.service;

import com.z4group.pos.domain.User;
import com.z4group.pos.utils.PageBean;

public interface IUserService {
	public User login(User user);

	public void editPassword(String id, String password);

	public void save(User model, String[] roleIds);

	public void pageQuery(PageBean pageBean);
}
