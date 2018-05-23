package com.z4group.pos.dao.impl;

import org.springframework.stereotype.Repository;

import com.z4group.pos.dao.ICategoryDao;
import com.z4group.pos.dao.base.impl.BaseDaoImpl;
import com.z4group.pos.domain.Category;
@Repository
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements ICategoryDao {

	@Override
	public Category findByName(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}


}
