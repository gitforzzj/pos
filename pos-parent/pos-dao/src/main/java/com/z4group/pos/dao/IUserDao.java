package com.z4group.pos.dao;

import com.z4group.pos.dao.base.IBaseDao;
import com.z4group.pos.domain.User;

public interface IUserDao extends IBaseDao<User> {

	public User findUserByUsernameAndPassword(String username, String password);

	public User findUserByUsername(String username);


	

}
