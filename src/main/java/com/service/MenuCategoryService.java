package com.service;

import java.util.List;

import com.model.MenuCategory;
import com.resources.Response;

public interface MenuCategoryService {
	public boolean save(MenuCategory menuCategory) throws Exception;

	public boolean update(MenuCategory menuCategory) throws Exception;

	public boolean delete(MenuCategory menuCategory, Response model) throws Exception;

	public List<MenuCategory> getAllMenuCategories(Response model, String name) throws Exception;
}
