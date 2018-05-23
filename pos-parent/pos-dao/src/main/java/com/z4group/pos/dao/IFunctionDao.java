package com.z4group.pos.dao;

import java.util.List;

import com.z4group.pos.dao.base.IBaseDao;
import com.z4group.pos.domain.Function;

public interface IFunctionDao extends IBaseDao<Function>{
	public List<Function> findAll();

	public List<Function> findFunctionListByUserId(String id);

	public List<Function> findAllMenu();

	public List<Function> findMenuByUserId(String id);
}
