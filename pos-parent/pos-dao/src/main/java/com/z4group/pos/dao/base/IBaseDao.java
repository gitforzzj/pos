package com.z4group.pos.dao.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.z4group.pos.utils.PageBean;


public interface IBaseDao<T> {
	public void save(T entity);
	void saveOrUpdate(T entity);
	public void delete(T entity);
	public void update(T entity);
	public T findById(Serializable id);
	public void deleteById(Serializable id);
	public List<T> findByCriteria(DetachedCriteria detachedCriteria);
	public List<T> findAll();
	public void executeUpdate(String string, Object...objects);
	void pageQuery(PageBean pageBean);
}
