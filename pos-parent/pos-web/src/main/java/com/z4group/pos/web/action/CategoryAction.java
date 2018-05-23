package com.z4group.pos.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.z4group.pos.domain.Category;
import com.z4group.pos.service.ICategoryService;
import com.z4group.pos.web.action.base.BaseAction;
@Controller
public class CategoryAction extends BaseAction<Category> {
	@Autowired
	private ICategoryService categoryService;
	
	public String findAll() {
		List<Category> list = categoryService.findAll();
		this.java2json(list, new String[] {"disheses"});
		return NONE;
	}
	
}
