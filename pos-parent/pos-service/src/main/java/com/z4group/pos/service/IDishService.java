package com.z4group.pos.service;

import java.util.List;

import com.z4group.pos.domain.Dish;
import com.z4group.pos.utils.PageBean;

public interface IDishService {
	//接口方法默认为 public abstract
	void pageQuery(PageBean pageBean);

	void save(Dish model);

	void saveOrUpdate(Dish model);


	void deleteById(String dishid);

	List<Dish> findLikeId(String dishid);

	void saveBatch(List<Dish> dishList);

	List<Dish> findByCategoryId(String id);

}
