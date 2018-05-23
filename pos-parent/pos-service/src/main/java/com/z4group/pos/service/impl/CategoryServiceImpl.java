package com.z4group.pos.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z4group.pos.dao.ICategoryDao;
import com.z4group.pos.domain.Category;
import com.z4group.pos.service.ICategoryService;
@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryDao categoryDao;
	
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

	@Override
	public Category findById(String categoryName) {
		// TODO Auto-generated method stub
		
		return categoryDao.findById(categoryName);
	}

	@Override
	public Category findLikeId(String id) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Category.class);
		detachedCriteria.add(Restrictions.or(Restrictions.like("id", "%"+id+"%"),Restrictions.like("name", "%"+id+"%")));
		
		
		return categoryDao.findByCriteria(detachedCriteria).get(0);
	}

	
	
}
