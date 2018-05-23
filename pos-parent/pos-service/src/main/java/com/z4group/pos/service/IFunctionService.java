package com.z4group.pos.service;

import java.util.List;

import com.z4group.pos.domain.Function;
import com.z4group.pos.utils.PageBean;

public interface IFunctionService {

	List<Function> findAll();

	void save(Function model);

	void pageQuery(PageBean pageBean);

	List<Function> findMenu();


}
