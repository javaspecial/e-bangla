package com.service;

import java.util.List;

import com.model.MenuCategory;
import com.resources.Response;

public interface MenuCategoryService {
	public boolean save(MenuCategory menuCategory) throws Exception;

	public List<MenuCategory> getAllMenuCategories(Response model, int pageIndex, int pageSizeSelected) throws Exception;
}
