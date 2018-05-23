package com.z4group.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z4group.pos.dao.IUserDao;
import com.z4group.pos.domain.Role;
import com.z4group.pos.domain.User;
import com.z4group.pos.service.IUserService;
import com.z4group.pos.utils.MD5Utils;
import com.z4group.pos.utils.PageBean;

@Service
@Transactional
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public User login(User user) {
		String password = MD5Utils.md5(user.getPassword());
		return userDao.findUserByUsernameAndPassword(user.getUsername(), password);
	}

	@Override
	public void editPassword(String id, String password) {
		password=MD5Utils.md5(password);
		userDao.executeUpdate("user.editpassword",password,id);
	}

	@Override
	public void save(User model, String[] roleIds) {
		String password = model.getPassword();
		password = MD5Utils.md5(password);
		model.setPassword(password);
		userDao.save(model);
		if(roleIds!=null&&roleIds.length>0) {
			for(String roleId:roleIds) {
				Role role = new Role(roleId);
				 model.getRoles().add(role);
			}
		}
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		userDao.pageQuery(pageBean);
	}

	
	
}
