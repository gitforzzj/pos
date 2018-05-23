package com.z4group.pos.service;

import java.util.List;

import com.z4group.pos.domain.Category;

public interface ICategoryService {

	List<Category> findAll();

	Category findById(String categoryName);


	Category findLikeId(String id);

}
