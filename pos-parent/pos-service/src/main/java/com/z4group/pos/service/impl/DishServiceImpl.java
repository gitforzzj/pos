package com.z4group.pos.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z4group.pos.dao.IDishDao;
import com.z4group.pos.domain.Dish;
import com.z4group.pos.service.IDishService;
import com.z4group.pos.utils.PageBean;

/*
 * @service是spring的一个注解，表名该类为service
 * @Transaction为给类的每个方法执行事务，即一个方法执行完后才进行事务提交
 */
@Service
@Transactional
public class DishServiceImpl implements IDishService{
	@Autowired
	private IDishDao dishDao;
	
	@Override
	public void pageQuery(PageBean pageBean) {
		dishDao.pageQuery(pageBean);
	}

	@Override
	public void save(Dish model) {
		dishDao.save(model);
	}

	@Override
	public void saveOrUpdate(Dish model) {
		dishDao.saveOrUpdate(model);
	}

	@Override
	public void deleteById(String dishid) {
		dishDao.deleteById(dishid);
	}

	@Override
	public List<Dish> findLikeId(String dishid) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Dish.class);
		detachedCriteria.add(Restrictions.or(Restrictions.like("dishid", "%"+dishid+"%"),Restrictions.like("dishname", "%"+dishid+"%")));
		return (List<Dish>) dishDao.findByCriteria(detachedCriteria);
	}

	@Override
	public void saveBatch(List<Dish> dishList) {
		for(Dish dish:dishList) {
			dishDao.saveOrUpdate(dish);
		}
	}

	@Override
	public List<Dish> findByCategoryId(String id) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Dish.class);
		
			detachedCriteria.add(Restrictions.eq("category.id", id));
		
		return (List<Dish>) dishDao.findByCriteria(detachedCriteria);
	}

	

}
