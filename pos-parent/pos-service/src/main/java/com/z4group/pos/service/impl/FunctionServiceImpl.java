package com.z4group.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z4group.pos.dao.IFunctionDao;
import com.z4group.pos.domain.Function;
import com.z4group.pos.domain.User;
import com.z4group.pos.service.IFunctionService;
import com.z4group.pos.utils.POSUtils;
import com.z4group.pos.utils.PageBean;
@Service
@Transactional
public class FunctionServiceImpl implements IFunctionService{

	@Autowired
	private IFunctionDao functionDao;
	
	@Override
	public List<Function> findAll() {
		// TODO Auto-generated method stub
		return functionDao.findAll();
	}

	@Override
	public void save(Function model) {
		Function parentFunction = model.getParentFunction();
		if(parentFunction!=null&&parentFunction.getId().equals("")) {
			model.setParentFunction(null);
		}
		functionDao.save(model);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		functionDao.pageQuery(pageBean);
	}

	@Override
	public List<Function> findMenu() {
		List<Function> list = null;
		User user = POSUtils.getLoginUser();
		if(user.getUsername().equals("admin")) {
			list = functionDao.findAllMenu();
		}else {
			list = functionDao.findMenuByUserId(user.getId());
		}
		return list;
	}

}
