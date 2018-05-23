package com.z4group.pos.dao;

import com.z4group.pos.dao.base.IBaseDao;
import com.z4group.pos.domain.Category;

public interface ICategoryDao extends IBaseDao<Category> {

	Category findByName(String categoryName);

}
